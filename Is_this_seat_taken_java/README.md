[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/O_FCEqJB)
[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-2e0aaae1b6195c2367325f4f02e2d04e9abb55f0b24a779b69b11b9e10269abc.svg)](https://classroom.github.com/online_ide?assignment_repo_id=20262954&assignment_repo_type=AssignmentRepo)

# Proyecto: Motor lógico para juego basado en “Is This Seat Taken?”
## Autores: 
- Samuel Chinchilla Vásquez 
- Joshua Rayo Arcia

## Descripción
El programa consiste en un motor lógico de juego en Java que
evalúa la felicidad de los asistentes a una sala de cine en 
función de sus preferencias, características, y ubicación.

El motor lógico está basado en un reciente producto comercial denominado “Is This Seat Taken?”.
En el cual existen personajes que desean sentarse al lado de otro personaje en 
específico, junto a una ventana, o lejos de la música fuerte. Similar al juego, 
nuestro programa funciona como un motor que es capaz de recibir una serie de
reglas y un ejemplo de pantalla, y nos dirá si los personajes están felices o tristes.

Para utilizar el programa, un usuario invocará el programa desde la consola, pasando como parámetro
el tamaño y configuración de la sala de cine, y dos archivos CSV (valores separados por coma):

1) Archivo de reglas: contiene la lista de personas con sus características y atributos.
2) Archivo de juego: indica la ubicación exacta de cada persona en los asientos para su evaluación.

El sistema lee ambos archivos, verifica si cada persona está feliz o triste según las reglas
especificadas en el archivo de reglas, y muestra una representación visual de cómo se
observa la sala según lo ejecutado, identificando claramente el estado de felicidad con una "O" de color verde 
o  tristeza con una "X" de color rojo para las personas. Al mismo tiempo, el sistema producirá una bitácora textual (log file) 
con los detalles de la evaluación y el resultado de la ejecución

## Ejemplo de salida
Para una sala de 8x11x4 con cuatro personas:
        O = Persona feliz  
        X = Persona triste  
        . . | . . | O . | . . 
        . X | O O | . . | . .
        . . | . . | . . | . .
        . . | . . | . . | . .
        . . | . . | . . | . .
        . . | . . | . . | . .
        . . | . . | . . | . .
        . . | . . | . . | . .
en cojunto con un archivo.txt con la información resumida.

## Instalación:
    
    1. Asegúrate de tener la última versión de java instalada

    2. Clona el repositorio
    Desde la consola de tu preferencia y desde la 
    ubicación deseada clona el repositorio
    ``` bash
    git clone https://github.com/CR-UCR-ECCI/tarea-programada-1-joshua-samuel-josue.git
    ``` 
    3. Compila todas las clases en un solo archivo principal   
    utilizando el comando javac *.java

## Uso o ejecución:
    Con el archivo motor.jar ubicado en tu ordenador
    y en la consola de tu preferencia
    llama el archivo donde se encuentre el motor utilizando
    el comando cd y la ubicación de dicho archivo, una vez 
    en dicha ubicación puedes utilizar el comando con 
    la estructura: 
        java -jar ./motor.jar <String> <csv de reglas > <csv de distribución>
        <String> representa las dimensiones de la sala en formato FilasxColumnasxPasillos.  
    un ejemplo puede ser:
        ``` bash
        java -jar ./motor.jar “10x12x1” reglas.csv juego.csv
        ```
    recordar que los archivos reglas.csv y juego.csv deben
    encontrarse en la misma ubicación que el archivo motor.

## Requisitos
- Java 17 o superior
- Archivos CSV válidos

## Licencia
Este proyecto no tiene licencia de distribución.  
Su uso y modificación están restringidos al autor o a los fines académicos del curso.