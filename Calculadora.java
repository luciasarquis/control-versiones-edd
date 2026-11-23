import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Calculadora {

    private static final int MIN = -99999;
    private static final int MAX = 99999;

    // Comprueba que el numero este permitido.
    private static boolean valido(int n) {
        return n >= MIN && n <= MAX;
    }

    // Operaciones de la calculadora.
    private static long sumar(int a, int b) {
        return (long) a + b;
    }

    private static long restar(int a, int b) {
        return (long) a - b;
    }

    private static long multiplicar(int a, int b) {
        return (long) a * b;
    }

    private static double potencia(int a, int b) {
        return Math.pow(a, b);
    }

    // Recoge los datos enviados desde el HTML.
    private static Map<String, String> parametros(String consulta) {
        Map<String, String> datos = new HashMap<>();

        if (consulta == null) {
            return datos;
        }

        for (String parte : consulta.split("&")) {
            String[] campo = parte.split("=", 2);

            if (campo.length == 2) {
                datos.put(
                    URLDecoder.decode(campo[0], StandardCharsets.UTF_8),
                    URLDecoder.decode(campo[1], StandardCharsets.UTF_8)
                );
            }
        }

        return datos;
    }

    // Calcula el resultado de la operacion.
    private static String resolver(Map<String, String> datos) {
        try {
            int a = Integer.parseInt(datos.getOrDefault("a", ""));
            int b = Integer.parseInt(datos.getOrDefault("b", ""));

            if (!valido(a) || !valido(b)) {
                return "Error: numeros fuera del rango permitido.";
            }

            String operacion = datos.getOrDefault("op", "");

            switch (operacion) {
                case "suma":
                    return "Resultado: " + sumar(a, b);

                case "resta":
                    return "Resultado: " + restar(a, b);

                case "multiplicacion":
                    return "Resultado: " + multiplicar(a, b);

                case "potencia":
                    double resultado = potencia(a, b);

                    if (!Double.isFinite(resultado)) {
                        return "Error: resultado demasiado grande o indefinido.";
                    }

                    if (resultado == Math.rint(resultado)
                            && Math.abs(resultado) < 1e15) {
                        return "Resultado: " + (long) resultado;
                    }

                    return "Resultado: " + resultado;

                default:
                    return "Error: operacion no valida.";
            }

        } catch (NumberFormatException e) {
            return "Error: introduce dos numeros enteros validos.";
        }
    }

    // Envia el contenido al navegador.
    private static void enviar(HttpExchange peticion, String html)
            throws IOException {

        byte[] contenido = html.getBytes(StandardCharsets.UTF_8);

        peticion.getResponseHeaders().set(
            "Content-Type", "text/html; charset=UTF-8"
        );

        peticion.sendResponseHeaders(200, contenido.length);

        try (OutputStream salida = peticion.getResponseBody()) {
            salida.write(contenido);
        }
    }

    // Inicia el servidor y conecta Java con HTML.
    public static void main(String[] args) throws IOException {

        HttpServer servidor = HttpServer.create(
            new InetSocketAddress("127.0.0.1", 18765), 0
        );

        servidor.createContext("/calcular", peticion -> {

            Map<String, String> datos = parametros(
                peticion.getRequestURI().getRawQuery()
            );

            String resultado = resolver(datos);

            String html =
                "<!DOCTYPE html>" +
                "<html lang='es'>" +
                "<head><meta charset='UTF-8'>" +
                "<title>Resultado</title></head>" +
                "<body style='font-family:Arial;" +
                "max-width:480px;margin:80px auto;padding:24px'>" +
                "<h1>Calculadora</h1>" +
                "<h2>" + resultado + "</h2>" +
                "<a href='/'>Volver a calcular</a>" +
                "</body></html>";

            enviar(peticion, html);
        });

        servidor.createContext("/", peticion -> {

            Path archivo = Path.of("index.html");

            String html;

            if (Files.exists(archivo)) {
                html = Files.readString(
                    archivo, StandardCharsets.UTF_8
                );
            } else {
                html = "<h1>Falta el archivo index.html</h1>";
            }

            enviar(peticion, html);
        });

        servidor.start();

        System.out.println("Calculadora disponible en:");
        System.out.println("http://localhost:18765");
        System.out.println("Pulsa Control+C para detener.");
    }
}
