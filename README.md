# AvisadorDeCorreo-CorrectorConsola

# Avisador de Correo en Java

Este es un programa simple en Java que simula un "Avisador de Correo". El programa verifica periódicamente si hay correo electrónico nuevo y muestra un mensaje de "Nuevo Correo" en la consola cuando se detecta correo nuevo.

## Instrucciones de Uso

1. **Compilación**:

    Para compilar el programa, asegúrate de tener Java instalado en tu sistema. Luego, abre una terminal en la carpeta donde se encuentra el archivo fuente (`AvisadorDeCorreo.java`) y ejecuta el siguiente comando:

    ```shell
    javac AvisadorDeCorreo.java
    ```

2. **Ejecución**:

    Después de compilar el programa, puedes ejecutarlo con el siguiente comando:

    ```shell
    java AvisadorDeCorreo
    ```

3. **Interacción**:

    El programa te permitirá interactuar a través de la consola. Puedes usar los siguientes comandos:

    - `nuevo`: Inicia la recepción de avisos de nuevo correo.
    - `leer`: Marca el correo como leído y detiene los avisos de nuevo correo.
    - `fin`: Finaliza el programa y detiene todos los hilos.

4. **Avisos de Nuevo Correo**:

    Cuando recibes un nuevo correo, el programa mostrará "Nuevo Correo" en la consola cada 5 segundos mientras esté habilitado.

## Ejemplo de Uso

1. Ejecuta el programa con `java AvisadorDeCorreo`.
2. Ingresa el comando `nuevo` para iniciar los avisos de nuevo correo.
3. Si hay un correo nuevo, verás "Nuevo Correo" en la consola cada 5 segundos.
4. Para marcar el correo como leído, ingresa el comando `leer`.
5. Si deseas finalizar el programa, ingresa el comando `fin`.
