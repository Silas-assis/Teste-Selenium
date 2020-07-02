import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastro {

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
	public void criandoUmCadastro() {

		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste"); // Input Nome.
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Testando"); // Input Sobrenome.
		driver.findElement(By.id("elementosForm:sexo:0")).click(); // Escolhendo Sexo Masculino.
		driver.findElement(By.id("elementosForm:comidaFavorita:1")).click(); // Escolhendo Comida (Frango).

		WebElement elementEscolaridade = driver.findElement(By.id("elementosForm:escolaridade")); // Escolhendo
																									// Escolaridade.
		Select comboEscolaridade = new Select(elementEscolaridade);
		comboEscolaridade.selectByVisibleText("Superior");

		WebElement elementEsportes = driver.findElement(By.id("elementosForm:esportes")); // Escolhendo Esportes.
		Select comboEsportes = new Select(elementEsportes);
		comboEsportes.selectByVisibleText("Corrida");
		comboEsportes.selectByVisibleText("Futebol");

		driver.findElement(By.id("elementosForm:cadastrar")).click();// Botão para Cadastrar.

		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Teste"));
		Assert.assertTrue(driver.findElement(By.id("descSobrenome")).getText().endsWith("Testando"));
		Assert.assertTrue(driver.findElement(By.id("descSexo")).getText().endsWith("Masculino"));
		Assert.assertTrue(driver.findElement(By.id("descComida")).getText().endsWith("Frango"));
		Assert.assertTrue(driver.findElement(By.id("descEscolaridade")).getText().endsWith("superior"));
		Assert.assertEquals("Esportes: Futebol Corrida", driver.findElement(By.id("descEsportes")).getText());
	}
}
