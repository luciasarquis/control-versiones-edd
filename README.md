# Control de Versiones - Entornos de Desarrollo

## Descripción

Proyecto de una calculadora desarrollada con Java y HTML.

La aplicación realiza cuatro operaciones: suma, resta, multiplicación y potencias. Los números introducidos deben estar comprendidos entre -99999 y 99999.

## Organización del trabajo

- Persona A: repositorio, backend en Java y gestión de main.
- Persona B: frontend en HTML.

## Ramas

- main: rama principal del proyecto.
- backend: desarrollo de Calculadora.java.
- frontend: desarrollo de index.html.

## Comandos utilizados por la Persona A

Los comandos se muestran en orden cronológico, incluyendo las correcciones realizadas durante la práctica.

1. `mkdir -p ~/EDD/control-versiones-edd` - Crear la carpeta.
2. `cd ~/EDD/control-versiones-edd` - Entrar en la carpeta.
3. `git init -b main` - Inicializar el repositorio.
4. `printf "*.png\n*.pdf\n.source/\n" > .gitignore` - Crear el archivo inicial.
5. `cat .gitignore` - Comprobar su contenido.
6. `git add .gitignore` - Preparar el archivo.
7. `git commit -m "new-JOKER: configurar gitignore"` - Primer commit.
8. `git remote add origin https://github.com/luciasarquis/control-versiones-edd.git` - Conectar con GitHub.
9. `git remote -v` - Comprobar la conexión.
10. `git push -u origin main` - Publicar main.
11. `git switch -c backend` - Crear la rama backend.
12. `code .` - Intentar abrir VS Code.
13. `open -a "Visual Studio Code" ~/EDD/control-versiones-edd` - Abrir VS Code.
14. `git switch main` - Volver a main.
15. `rm .gitignore` - Eliminar el archivo inicial.
16. `echo "# Control de Versiones - Entornos de Desarrollo" > README.md` - Crear README.
17. `git status` - Comprobar los cambios.
18. `git add -A` - Preparar la corrección.
19. `git commit --amend -m "Initial commit README"` - Corregir el primer commit.
20. `git status` - Comprobar el estado.
21. `git branch -f backend main` - Actualizar backend.
22. `git switch backend` - Cambiar a backend.
23. `git branch` - Mostrar las ramas.
24. `javac Calculadora.java` - Compilar el programa.
25. `java Calculadora` - Ejecutar y probar la calculadora.
26. `git add Calculadora.java` - Preparar el archivo Java.
27. `git status` - Comprobar los archivos.
28. `git config user.name "Lucia"` - Configurar el autor.
29. `git config user.email "CORREO_VERIFICADO"` - Configurar el correo (se corrigió durante la práctica).
30. `git commit -m "Añadir calculadora Java"` - Guardar Java.
31. `git commit --amend --no-edit --reset-author` - Corregir el autor.
32. `git status` - Comprobar el commit.
33. `git ls-remote --heads origin` - Consultar las ramas remotas.
34. `git switch main` - Volver a main.
35. `git push --force-with-lease origin main` - Publicar el historial corregido.
36. `git switch backend` - Volver a backend.
37. `git push -u origin backend` - Publicar backend.
38. `git status` - Comprobar la sincronización.
39. `git switch main` - Volver a la rama principal.
40. `git pull origin main` - Descargar los cambios fusionados.

## Pull Request

Se creó un Pull Request desde backend hacia main.

Se revisó que únicamente se incorporara Calculadora.java y se confirmó el merge desde GitHub.

## Cómo publicar un repositorio en GitHub

1. Crear un repositorio público en GitHub.
2. Inicializar Git localmente con `git init -b main`.
3. Conectarlo con `git remote add origin URL`.
4. Añadir archivos mediante `git add`.
5. Guardar cambios utilizando `git commit`.
6. Publicar mediante `git push -u origin main`.
7. Crear ramas con `git switch -c nombre-rama`.
8. Trabajar y publicar cada rama.
9. Crear Pull Requests para incorporar cambios a main.
10. Revisar los archivos y confirmar los merges.

## Pendiente

Añadir los comandos utilizados por la Persona B y verificar el funcionamiento conjunto del proyecto.
