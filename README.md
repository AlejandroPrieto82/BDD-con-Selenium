# 🧪 BDD con Selenium - Java + Cucumber

Laboratorio de pruebas automatizadas usando **Behavior Driven Development (BDD)** con Selenium WebDriver, Cucumber y JUnit en Java, ejecutado en GitHub Codespaces.

**Autor:** [@AlejandroPrieto82](https://github.com/AlejandroPrieto82)  
**Repositorio:** [https://github.com/AlejandroPrieto82/BDD-con-Selenium](https://github.com/AlejandroPrieto82/BDD-con-Selenium)

---

## 📋 Descripción

Este proyecto implementa un flujo BDD completo que automatiza una búsqueda en Google usando Chrome en modo headless. El escenario verifica que al buscar "GitHub", los resultados contengan dicho término.

---

## 🛠️ Tecnologías utilizadas

| Tecnología | Versión |
|---|---|
| Java | 17 |
| Maven | 3.x |
| Selenium WebDriver | 4.0.0 |
| Cucumber Java | 7.0.0 |
| Cucumber JUnit | 7.0.0 |
| Google Chrome | 145.x |
| ChromeDriver | 145.x |

---

## 📁 Estructura del proyecto

```
BDD-con-Selenium/
├── .devcontainer/
│   └── devcontainer.json           # Configuración de GitHub Codespaces
├── src/
│   ├── main/
│   │   └── java/com/eci/myproject/
│   │       └── App.java
│   └── test/
│       └── java/com/eci/myproject/
│           ├── features/
│           │   └── google_search.feature   # Escenario BDD en Gherkin
│           ├── steps/
│           │   └── SearchSteps.java        # Implementación de los pasos
│           └── runners/
│               └── TestRunner.java         # Configuración del runner
├── pom.xml                                 # Dependencias Maven
└── README.md
```

---

## 🥒 Escenario BDD

```gherkin
Feature: Google Search

  Scenario: Search for a term
    Given I am on the Google search page
    When I search for "GitHub"
    Then I should see "GitHub" in the results
```

---

## ⚙️ Configuración del entorno (GitHub Codespaces)

El proyecto incluye un `devcontainer.json` que configura automáticamente el entorno con Java 17, Maven y Node.js al abrir el Codespace.

Para levantar el entorno:

1. Ve al repositorio en GitHub
2. Haz click en **Code → Codespaces → Create codespace on main**
3. Espera a que el entorno se configure automáticamente

### Instalación de Chrome y ChromeDriver (dentro del Codespace)

```bash
# Instalar Google Chrome
wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
sudo apt-get install -y ./google-chrome-stable_current_amd64.deb

# Instalar ChromeDriver compatible con la versión de Chrome instalada
CHROME_FULL=$(google-chrome --version | grep -oP '[\d.]+')
wget "https://storage.googleapis.com/chrome-for-testing-public/${CHROME_FULL}/linux64/chromedriver-linux64.zip" -O chromedriver.zip
unzip chromedriver.zip
sudo mv chromedriver-linux64/chromedriver /usr/local/bin/chromedriver
sudo chmod +x /usr/local/bin/chromedriver

# Verificar instalación
google-chrome --version
chromedriver --version
```

---

## 🚀 Ejecución

```bash
mvn test
```

### Resultado esperado

```
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

---

## 📊 Reportes

Después de ejecutar `mvn test`, los reportes se generan en:

| Formato | Ruta |
|---|---|
| HTML | `target/HtmlReports/report.html` |
| JSON | `target/JSonReports/report.json` |
| JUnit XML | `target/JUnitReports/report.xml` |

Para ver el reporte HTML en el Codespace: click derecho sobre `target/HtmlReports/report.html` → **Download** → abrir en el navegador.

---

## 📦 Dependencias (pom.xml)

```xml
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.0.0</version>
    </dependency>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>7.0.0</version>
    </dependency>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-junit</artifactId>
        <version>7.0.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

---

## 📝 Notas

- Chrome corre en modo **headless** (sin interfaz gráfica), lo que permite ejecutarlo en entornos sin pantalla como Codespaces.
- El ChromeDriver debe coincidir exactamente con la versión de Google Chrome instalada.
- Los archivos binarios de Chrome y ChromeDriver están excluidos del repositorio vía `.gitignore`.