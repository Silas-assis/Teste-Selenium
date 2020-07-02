import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampo {

	private WebDriver driver;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\assissl\\Desktop\\Curso Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); // Comando que deixa o navegador em tela cheia.
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}

	@After
	public void finaliza() {
		driver.quit();
	}

	@Test
	public void testeTextField() {

		// Consultando elemento por ID. Comando sendKeys é para inserir o texto.
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Testando Nome");
		Assert.assertEquals("Testando Nome", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
	}

	@Test
	public void testeTextArea() {

		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Testando Sugestões");
		Assert.assertEquals("Testando Sugestões",
				driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
	}

	@Test
	public void testeInteragirComRadioButton() {

		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
	}

	@Test
	public void testeInteragirComRadioCheckBox() {

		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
	}

	@Test
	public void testeInteragirComCombo() {

		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);

		// combo.selectByIndex(2);
		// combo.selectByValue("1grauincomp");
		combo.selectByVisibleText("Superior");
		Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
	}

	@Test
	public void VerificarValoresCombo() {

		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());

		boolean encontrou = false;
		for (WebElement option : options) {
			if (option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}

		}
		Assert.assertTrue(encontrou);
	}

	@Test
	public void VerificarValoresComboMultiplo() {

		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Futebol");
		combo.selectByVisibleText("Karate");
		combo.selectByVisibleText("Corrida");

		List<WebElement> allSelectOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectOptions.size());

		combo.deselectByVisibleText("Corrida");// Desmarcar.

		allSelectOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectOptions.size());
	}

	@Test
	public void InteragirComBotões() {

		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();

		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		driver.quit();
	}

	@Test
	@Ignore
	public void InteragirComLinks() {

		WebElement link = driver.findElement(By.linkText("Voltar"));
		link.click();
	}

	@Test
	public void deveBuscarTextoNaPagina() {
		Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText()); // Procurar por
																										// Tag.

		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
				driver.findElement(By.className("facilAchar")).getText());// Procuar por Class.
	}
}
