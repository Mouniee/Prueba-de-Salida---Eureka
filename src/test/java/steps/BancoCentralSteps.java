package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BancoCentralSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Given("que abro el sitio del Banco Central")
    public void abrirSitio() {
        driver.get("https://www.bcentral.cl");
    }

    @When("cuento las etiquetas H1 y P")
    public void contarEtiquetas() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h1")));

        List<WebElement> h1s = driver.findElements(By.tagName("h1"));
        System.out.println("Cantidad de H1: " + h1s.size());

        for (WebElement h1 : h1s) {
            if (!h1.getText().trim().isEmpty()) {
                System.out.println("Texto H1: " + h1.getText());
            }
        }

        List<WebElement> pTags = driver.findElements(By.tagName("p"));
        System.out.println("Cantidad de párrafos <p>: " + pTags.size());
    }

    @Then("valido el título del sitio")
    public void validarTitulo() {
        String tituloEsperado = "Inicio - Banco Central de Chile";
        String tituloActual = driver.getTitle();

        System.out.println("Título encontrado: " + tituloActual);

        if (tituloEsperado.equals(tituloActual)) {
            System.out.println("Título correcto!!");
        } else {
            System.out.println("Error en el título.");
        }
    }

    @Then("muestro los valores de UF UTM Dolar y Euro")
    public void mostrarValores() {
        try {
            System.out.println("Búsqueda de indicares:");
            String valorUF = driver.findElement(By.xpath("//*[@id=\"_BcentralIndicadoresViewer_INSTANCE_pLcePZ0Eybi8_myTooltipDelegate\"]/div/div/div[1]/div/div/div[1]/div/p[2]")).getText();
            String valorUTM = driver.findElement(By.xpath("//*[@id=\"_BcentralIndicadoresViewer_INSTANCE_pLcePZ0Eybi8_myTooltipDelegate\"]/div/div/div[1]/div/div/div[2]/div/p[2]")).getText();
            String valorDolar = driver.findElement(By.xpath("//*[@id=\"_BcentralIndicadoresViewer_INSTANCE_pLcePZ0Eybi8_myTooltipDelegate\"]/div/div/div[1]/div/div/div[4]/div/p[2]")).getText();
            String valorEuro = driver.findElement(By.xpath("//*[@id=\"_BcentralIndicadoresViewer_INSTANCE_pLcePZ0Eybi8_myTooltipDelegate\"]/div/div/div[1]/div/div/div[6]/div/p[2]")).getText();

            System.out.println("Valor UF: " + valorUF);
            System.out.println("Valor UTM: " + valorUTM);
            System.out.println("Valor Dólar: " + valorDolar);
            System.out.println("Valor Euro: " + valorEuro);

        } catch (Exception e) {
            System.out.println("Error obteniendo valores: " + e.getMessage());
        }
    }

    private String obtenerValorPorTexto(String nombreIndicador) {
        try {
            WebElement el = driver.findElement(By.xpath("//p[contains(text(),'" + nombreIndicador + "')]/following-sibling::p"));
            return el.getText();
        } catch (Exception e) {
            try {

                WebElement el = driver.findElement(By.xpath("//*[contains(text(),'" + nombreIndicador + "')]"));
                return el.getText();
            } catch (Exception e2) {
                return "No encontrado";
            }
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}