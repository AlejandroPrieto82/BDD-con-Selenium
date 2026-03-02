# 🧪 BDD con Selenium - Java + Cucumber

Laboratorio de pruebas automatizadas usando **Behavior Driven Development (BDD)** con Selenium WebDriver, Cucumber y JUnit en Java, ejecutado en GitHub Codespaces.

**Autor:** [@AlejandroPrieto82](https://github.com/AlejandroPrieto82)  
**Repositorio:** [https://github.com/AlejandroPrieto82/BDD-con-Selenium](https://github.com/AlejandroPrieto82/BDD-con-Selenium)

---

## 📋 Descripción

Este proyecto implementa un flujo BDD completo que automatiza pruebas web usando Chrome en modo headless. Incluye dos features:

1. **Google Search** — Verifica que al buscar "GitHub" en Google, los resultados contengan dicho término.
2. **Login en The Internet** *(Challenge)* — Verifica login exitoso y fallido en `https://the-internet.herokuapp.com/login` usando el patrón **Page Object Model con PageFactory**.

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
│   └── devcontainer.json
├── src/
│   ├── main/
│   │   └── java/com/eci/myproject/
│   │       └── App.java
│   └── test/
│       └── java/com/eci/myproject/
│           ├── features/
│           │   ├── google_search.feature   # Feature 1: Google Search
│           │   └── login.feature           # Feature 2: Login (Challenge)
│           ├── steps/
│           │   ├── SearchSteps.java        # Steps de Google Search
│           │   ├── LoginSteps.java         # Steps de Login
│           │   └── LoginPage.java          # Page Object con PageFactory
│           └── runners/
│               └── TestRunner.java
├── pom.xml
└── README.md
```

---

## 🥒 Escenarios BDD

### Feature 1 — Google Search
```gherkin
Feature: Google Search

  Scenario: Search for a term
    Given I am on the Google search page
    When I search for "GitHub"
    Then I should see "GitHub" in the results
```

### Feature 2 — Login en The Internet (Challenge)
```gherkin
Feature: Login on The Internet

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter username "tomsmith" and password "SuperSecretPassword!"
    Then I should see a success message

  Scenario: Failed login with invalid credentials
    Given I am on the login page
    When I enter username "wronguser" and password "wrongpass"
    Then I should see an error message
```

---

## 🏗️ Challenge — PageFactory

El challenge consistió en implementar el patrón **Page Object Model con PageFactory** de Selenium.

En lugar de buscar elementos directamente en los steps:
```java
// Sin PageFactory ❌
driver.findElement(By.id("username")).sendKeys("tomsmith");
```

Se declaran en una clase de página con anotaciones `@FindBy`:
```java
// Con PageFactory ✅
@FindBy(id = "username")
private WebElement usernameField;
```

`PageFactory.initElements(driver, this)` inicializa todos los elementos automáticamente, haciendo el código más limpio, reutilizable y mantenible.

---

## ⚙️ Configuración del entorno (GitHub Codespaces)

1. Ve al repositorio en GitHub
2. Click en **Code → Codespaces → Create codespace on main**
3. Espera a que el entorno se configure

### Instalación de Chrome y ChromeDriver

```bash
# Instalar Google Chrome
wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
sudo apt-get install -y ./google-chrome-stable_current_amd64.deb

# Obtener versión exacta de Chrome
CHROME_FULL=$(google-chrome --version | grep -oP '[\d.]+')

# Descargar ChromeDriver compatible
wget "https://storage.googleapis.com/chrome-for-testing-public/${CHROME_FULL}/linux64/chromedriver-linux64.zip" -O chromedriver.zip
unzip chromedriver.zip
sudo mv chromedriver-linux64/chromedriver /usr/local/bin/chromedriver
sudo chmod +x /usr/local/bin/chromedriver

# Verificar
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
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

---

## 📊 Reportes

| Formato | Ruta |
|---|---|
| HTML | `target/HtmlReports/report.html` |
| JSON | `target/JSonReports/report.json` |
| JUnit XML | `target/JUnitReports/report.xml` |

Para ver el reporte: click derecho sobre `target/HtmlReports/report.html` → **Download** → abrir en el navegador.

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

- Chrome corre en modo **headless** (sin interfaz gráfica) para funcionar en Codespaces.
- El ChromeDriver debe coincidir exactamente con la versión de Chrome instalada.
- Los binarios de Chrome y ChromeDriver están excluidos del repo vía `.gitignore`.