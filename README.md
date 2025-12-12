🏦 Proyecto de Automatización – Banco Central de Chile

Selenium + Java + Cucumber

Este proyecto es una suite de pruebas automatizadas que navega por el sitio oficial del Banco Central de Chile y realiza validaciones e inspecciones simples utilizando Selenium WebDriver, Java, Cucumber y JUnit.

📌 Objetivo del proyecto

El propósito es automatizar un flujo básico que permita:

Abrir el sitio del Banco Central.

Contar etiquetas HTML <h1> y <p>.

Validar el título de la página.

Leer los valores UF, UTM, Dólar y Euro mostrados en la interfaz del sitio.

Todo esto está orquestado a través de un escenario Gherkin (Cucumber) y ejecutado mediante un runner JUnit.

🧩 Tecnologías y dependencias

Las dependencias están declaradas en el pom.xml del proyecto 

pom

:

Selenium Java 4.26.0

Cucumber Java 7.18.1

Cucumber JUnit 7.18.1

JUnit 4.13.2

org.json 20240303

El proyecto usa Maven para la gestión de dependencias y ejecución.

🗂 Estructura principal del proyecto
✔ Feature: bancoCentral.feature

Contiene el escenario Cucumber (Gherkin) que define los pasos en lenguaje natural.
(El archivo fue subido pero su contenido no se mostró en la vista; aun así, sus pasos coinciden con los bindings detectados en el step definition.)

✔ Step Definitions: BancoCentralSteps.java

Este archivo implementa los pasos definidos en el feature y ejecuta Selenium para interactuar con el sitio del Banco Central.
Entre sus funciones destacadas:

Inicialización del navegador (ChromeDriver) 

BancoCentralSteps

Apertura del sitio https://www.bcentral.cl

Conteo de etiquetas h1 y p

Validación del título esperado:
"Inicio - Banco Central de Chile"

Extracción mediante XPath de valores UF, UTM, Dólar y Euro 

BancoCentralSteps

Incluye también un método tearDown() para cerrar el navegador al finalizar cada prueba.

✔ Runner: TestRunner.java

Define la configuración para ejecutar los escenarios con Cucumber y JUnit:

Ubicación de las features: src/test/resources/features

Glue: steps

Plugin: pretty


TestRunner

▶️ ¿Cómo ejecutar el proyecto?

Instalar dependencias

mvn clean install


Ejecutar Cucumber via Maven

mvn test


Asegúrate de tener ChromeDriver compatible con tu versión de Google Chrome
(Debe estar en el PATH o configurado vía WebDriverManager si decides agregarlo en el futuro).

📘 Flujo del escenario automatizado

Abrir sitio del Banco Central

Esperar y contar etiquetas H1 y P

Mostrar texto de cada H1 encontrado

Validar título del sitio

Leer indicadores económicos:

UF

UTM

Dólar

Euro

Los valores se imprimen por consola durante la ejecución.
