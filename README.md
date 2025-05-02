# Franquicia API

## Endpoints
La API cuenta con los siguientes endpoints:

**FRANQUICIAS**
1. Obtener todas las franquicias
    - **URL:**  http://localhost:8080/api/franquicia
    - **METODO:** GET

2. Crear Franquicia
    - **URL:**  http://localhost:8080/api/franquicia
    - **METODO:** POST
    - **BODY:**
   ```
    {
        "nombre": "Franquicia Prueba"
    }
   ```
3. Actualizar nombre de franquicia
    - **URL:**  http://localhost:8080/api/franquicia/{franquiciaId}/update-name
    - **METODO:** PUT
    - **PARAMETROS URL:**
        - **franquiciaId:** (obligatorio) id de la franquicia a actualizar el nombre.
   - **BODY:**
   ```
    {
        "nombre": "Franquicia Nuevo Nombre"
    }
   ```
**SUCURSALES**
1. Obtener todas las sucursales
    - **URL:**  http://localhost:8080/api/sucursal
    - **METODO:** GET

2. Crear Sucursal
    - **URL:**  http://localhost:8080/api/sucursal/franquicia/{franquiciaId}
    - **METODO:** POST
    - **PARAMETROS URL:**
        - **sucursalId:** (obligatorio) id de la franquicia para asociar la sucursal.
    - **BODY:**
   ```
    {
        "nombre": "Sucursal Prueba"
    }
   ```
3. Actualizar nombre de sucursal
    - **URL:**  http://localhost:8080/api/sucursal/{sucursalId}/update-name
    - **METODO:** PUT
    - **PARAMETROS URL:**
      Parámetros de consulta:
        - **sucursalId:** (obligatorio) id de la sucursal a actualizar el nombre.
    - **BODY:**
   ```
    {
        "nombre": "Sucursal Nuevo Nombre"
    }
   ```
**PRODUCTOS**
1. Obtener todos las productos
    - **URL:**  http://localhost:8080/api/producto
    - **METODO:** GET

2. Crear Producto
    - **URL:**  http://localhost:8080/api/producto
    - **METODO:** POST
    - **BODY:**
   ```
    {
        "nombre": "Producto Prueba",
        "stock": 20
    }
   ```
3. Actualizar nombre de Producto
    - **URL:**  http://localhost:8080/api/producto/{productoId}/update-name
    - **METODO:** PUT
    - **PARAMETROS URL:**
      Parámetros de consulta:
        - **productoId:** (obligatorio) id del producto a actualizar el nombre.
    - **BODY:**
   ```
    {
        "nombre": "Producto Nuevo Nombre"
    }
   ```
4. Actualizar stock de Producto
    - **URL:**  http://localhost:8080/api/producto/{productoId}/update-stock
    - **METODO:** PUT
    - **PARAMETROS URL:**
      Parámetros de consulta:
        - **productoId:** (obligatorio) id del producto a actualizar el stock.
    - **BODY:**
   ```
    {
        "nuevoStock": 50
    }
   ```

5. Obtener la franquicia y sucursal de acuerdo al producto con max stock de una franquicia en particular
    - **URL:**  http://localhost:8080/api/producto/franquicia/{franquiciaId}/max-stock
    - **METODO:** GET
    - **PARAMETROS URL:**
      Parámetros de consulta:
        - **productoId:** (obligatorio) id de la franquicia a consultar el stock mayor.

   Este proyecto incluye una configuracion de Docker la cual se compone de una imagen para ejecutar el proyecto de spring boot con una compose de mysql el cual se puede ejecutar con el siguiente comando:

    ```bash
    docker-compose up --build
    ```


Esto iniciará la aplicación y la hará accesible en http://localhost:8080.

