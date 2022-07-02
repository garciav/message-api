# Message Api

Este es un proyecto de chat grupal.

## Installation

Luego de clonar el repositorio:

```bash
cd message-api/

# Generando el .jar 
mvn clean package

# Creando la docker image
docker build -t message-api/tag -f src/main/resources/Dockerfile .

# Levantando el contenedor
docker run -p8887:5000 message-api/tag

```

## Usage

```python
# Creando un grupo 
En http://localhost:8887/swagger-ui/index.html

# group-controller
Creamos un grupo desde /groups
```
![Test Image 5](https://user-images.githubusercontent.com/1074327/177016568-e90f54bd-86b8-4bd3-bda4-7f73f1ddddd0.png)

```python
# Enviando mensajes al grupo
Abrimos dos pestañas de http://localhost:8887 
y nos conectamos en ambas
haciendo click en "Connect".
```
![Test Image 5](https://user-images.githubusercontent.com/1074327/177016569-6ec1a441-056a-4c4f-a4af-c22223f4785a.png)


```python
#Escribiendo un segundo mensaje
Escribimos un mensaje en la primer y enviamos.
En la segunda
pestaña se muestra la notificación de un nuevo mensaje, y al hacer
focus en ella desaparece la notificación.

```
![Test Image 5](https://user-images.githubusercontent.com/1074327/177016566-acdafe5e-5836-44ef-839d-0684a89703c1.png)




## License
[MIT](https://choosealicense.com/licenses/mit/)