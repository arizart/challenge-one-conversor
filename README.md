# Conversor de Unidades - Challenge ONE Back End

![Conversor de Unidades](/presskit.png)

Conversor de unidades desarrollado con Java para el Challenge ONE de la especialización Back End. Convierte entre dos monedas cualesquiera usando el servicio gratuito de [ExchangeRate-API](https://www.exchangerate-api.com/) y entre las escalas de temperatura Celsius, Fahrenheit, Kelvin y Rankine.

## Uso

Descarge la versión más reciente del ejecutable [JAR](https://github.com/arizart/challenge-one-conversor/releases) y ejecútelo con un doble click. Debe tener Java instalado en su equipo. En la ventana abierta elija si desea convertir entre divisas o temperatura, seleccione las unidades de origen y destino con los menús desplegables, ingrese un monto y haga click en el botón _Convertir_.

Si lo desea también puede compilar desde el código fuente. Para eso descargue o clone el repositorio a su equipo. En la carpeta principal debe crear una nueva carpeta con nombre **lib** y colocar dentro una librería para JSON que puede obtener [aquí](https://mvnrepository.com/artifact/org.json/json/20230227). Abra una terminal de comandos en la ubicación del repositorio y ejecute el comando `javac -cp .:src:lib/* -d bin src/App.java` (para Windows reemplace los dos puntos ":" por punto y coma ";"). Una vez compilado puede ejecutar la aplicación con el comando `java -cp .:bin:lib/* App`.
