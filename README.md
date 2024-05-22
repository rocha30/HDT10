# Proyecto de Distribución de Suministros Médicos

Este proyecto implementa un sistema de grafos para la distribución de suministros médicos en una red de ciudades. Utiliza el algoritmo de Floyd-Warshall para calcular las rutas más cortas entre las ciudades y determinar el centro del grafo.

## Estructura del Proyecto

El proyecto consta de los siguientes archivos y clases:

- `App.java`: La clase principal que inicia la aplicación y maneja la interacción con el usuario.
- `Controller.java`: Clase que actúa como controlador principal del sistema, gestionando la carga del grafo, cálculos y modificaciones.
- `Grafo.java`: Clase que representa el grafo y contiene la implementación del algoritmo de Floyd-Warshall.
- `GraphLoader.java`: Clase encargada de cargar el grafo desde un archivo de texto y gestionar las operaciones de modificación.
- `guategrafo.txt`: Archivo de texto que contiene la información de las conexiones entre ciudades.

## Requisitos

- JDK 8 o superior.
- PlantUML para generar diagramas UML (opcional).

## Cómo Ejecutar

1. Clona el repositorio a tu máquina local.
2. Compila el proyecto utilizando el comando `javac App.java`.
3. Ejecuta el proyecto con el comando `java App`.

## Funcionalidades Principales

- **Mostrar ruta más corta entre dos ciudades**: Permite al usuario ingresar dos ciudades y muestra la ruta más corta entre ellas.
- **Indicar ciudad centro del grafo**: Calcula y muestra la ciudad que actúa como centro del grafo.
- **Modificar grafo**: Permite al usuario agregar o eliminar conexiones entre ciudades para simular interrupciones de tráfico o nuevas rutas.

## Contribuciones

Si deseas contribuir a este proyecto, ¡no dudes en hacerlo! Abre un issue para discutir tus ideas o envía un pull request con tus cambios propuestos.

## Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo LICENSE.md para más detalles.
