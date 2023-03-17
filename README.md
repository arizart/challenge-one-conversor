# Conversor de Unidades - Challenge ONE Back End

![Conversor de Unidades](/presskit.png)

Conversor de unidades desarrollado con Java para el Challenge ONE de la especialización Back End. Convierte entre dos monedas cualesquiera usando el servicio gratuito de [ExchangeRate-API](https://www.exchangerate-api.com/) y entre las escalas de temperatura Celsius, Fahrenheit, Kelvin y Rankine.

## Uso

Descarge la versión más reciente del ejecutable [JAR](https://github.com/arizart/challenge-one-conversor/releases) y ejecútelo con un doble click. Debe tener Java instalado en su equipo.
Elija entre los distintos modos de conversión, seleccione las unidades de origen y destino, ingrese un valor y haga click en el botón _Convertir_.

## Compilación

Instrucciones para compilar desde el código fuente:

1. Descarge y extraiga el repositorio a su equipo.
2. Descargue la librería para JSON desde este [vínculo](https://mvnrepository.com/artifact/org.json/json/20230227).
3. Dentro del repositorio cree una carpeta con nombre **lib** y coloque ahí la librería.
4. Abra una terminal dentro del repositorio y ejecute el comando `javac -cp .:src:lib/* -d bin src/App.java` para compilar (en Windows reemplace los dos puntos ":" por punto y coma ";").
5. Finalmente inicie la aplicación con el comando `java -cp .:bin:lib/* App`.
6. (Opcional) Ejecute `jar -cvmf manifest.mf Conversor.jar res -C bin .` para crear un archivo ejecutable JAR.
