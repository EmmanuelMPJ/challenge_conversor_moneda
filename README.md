# Conversor de moneda

Este programa te permite convertir cantidades de una moneda a otra. Utiliza la API 'ExchangeRate-API' para obtener las tasas de cambio entre las distintas monedas y los métodos necesarios para realizar la conversión. Los posibles cambios que se pueden hacer son:
- Dólar ==> Peso argentino
- Peso argentino ==> Dólar
- Dólar ==> Real brasileño
- Real brasileño ==> Dólar
- Dólar ==> Peso colombiano
- Peso colombiano ==> Dólar

## :hammer:Funcionalidades del proyecto
- `Menú`: Contiene un menú que se muestra en consola, en el que se pide al usuario ingresar un numero del 1 al 7 para elegir la acción que quiere realizar, y luego se le pide ingresar un número para el valor que quiere convertir.- `Consumo de la API`: Se crearon los metodos y clases necesarias para la solicitud de la información a la API y el correcto tratamiento de esta información para poder ser usada.- `Analisis de input`: Se trabajó con expresiones regulares para analizar la entrada del usuario en la cantidad de la moneda, condicionando que solo se acepten valores que sean números enteros o numeros decimales.- `Filtro de las divisas a convertir`: Se realizó el filtro para saber qué corresponde al valor ingresado por el usuario y a qué se quiere convertir, esto al analizar que opción eligió, tambien se creó una "flag" para indicarle a la conversión si se debe usar la tasa de cambio tal cual se obtuvo de la API o si se debe usar de manera inversa.- `Acción de salir`: Cuando el usuario haya culminado con el uso del programa se agregó una opción para terminar este mismo (opción 7).
