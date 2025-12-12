
# Proyecto de Automatización -- Banco Central

**Selenium + Java + Cucumber**

Este proyecto es una suite de pruebas automatizadas que navega por el
sitio oficial del Banco Central y realiza validaciones e
inspecciones utilizando **Selenium WebDriver**, **Java**,
**Cucumber** y **JUnit**.

## Objetivo del proyecto

El propósito es automatizar un flujo básico que permita:

-   Abrir el sitio del Banco Central.\
-   Contar etiquetas HTML `<h1>` y `<p>`.\
-   Validar el título de la página.\
-   Leer los valores UF, UTM, Dólar y Euro mostrados en la interfaz del
    sitio.

## Tecnologías y dependencias

Las dependencias están declaradas en el `pom.xml` del proyecto:

-   **Selenium Java 4.26.0**\
-   **Cucumber Java 7.18.1**\
-   **Cucumber JUnit 7.18.1**\
-   **JUnit 4.13.2**\
-   **org.json 20240303**

## Estructura principal del proyecto

### Feature: `bancoCentral.feature`

Define el escenario de prueba Cucumber.

### Step Definitions: `BancoCentralSteps.java`

Implementa los pasos definidos en el feature utilizando Selenium
WebDriver.

### Runner: `TestRunner.java`

Configura la ejecución de las pruebas con Cucumber + JUnit.

## ¿Cómo ejecutar el proyecto?

1.  Instalar dependencias:

```{=html}
<!-- -->
```
    mvn clean install

2.  Ejecutar pruebas:

```{=html}
<!-- -->
```
    mvn test

3.  Asegurar que ChromeDriver sea compatible con tu versión de Chrome.

## 🚀 Cómo ejecutar este proyecto

### Requisitos previos
- Java 8+ (ideal Java 11/17)
- Maven instalado
- Google Chrome actualizado
- ChromeDriver compatible con tu versión de Chrome (debe estar en el PATH)

### Clonar o abrir el proyecto
Si usas Git:
```
git clone <URL-del-repo>
cd bcentral-test
```

Si es ZIP, solo descomprímelo.

### Instalar dependencias
```
mvn clean install
```

###  Ejecutar las pruebas
**A) Con Maven**
```
mvn test
```

**B) Desde el IDE**
Ejecutar `TestRunner.java`.

