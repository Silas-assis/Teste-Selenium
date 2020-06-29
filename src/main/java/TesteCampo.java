import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampo {
	@Test
	public void testeTextField() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\assissl\\Desktop\\Curso Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // Comando que deixa o navegador em tela cheia.
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		// Consultando elemento por ID. Comando sendKeys é para inserir o texto.
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Testando Nome");
		Assert.assertEquals("Testando Nome", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));

		driver.quit(); // fechar o browser.
	}

	@Test
	public void testeTextArea() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\assissl\\Desktop\\Curso Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // Comando que deixa o navegador em tela cheia.
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Testando Sugestões");
		Assert.assertEquals("Testando Sugestões",
				driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));

		driver.quit(); // fechar o browser.
	}

	@Test
	public void testeInteragirComRadioButton() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\assissl\\Desktop\\Curso Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // Comando que deixa o navegador em tela cheia.
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());

		driver.quit(); // fechar o browser.
	}

	@Test
	public void testeInteragirComRadioCheckBox() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\assissl\\Desktop\\Curso Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // Comando que deixa o navegador em tela cheia.
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());

		driver.quit(); // fechar o browser.
	}

	@Test
	public void testeInteragirComCombo() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\assissl\\Desktop\\Curso Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // Comando que deixa o navegador em tela cheia.
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);

		// combo.selectByIndex(2);
		// combo.selectByValue("1grauincomp");
		combo.selectByVisibleText("Superior");

		Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
		driver.quit();
	}

	@Test
	public void VerificarValoresCombo() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\assissl\\Desktop\\Curso Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // Comando que deixa o navegador em tela cheia.
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

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
		driver.quit();
	}
	
	@Test
	public void VerificarValoresComboMultiplo() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\assissl\\Desktop\\Curso Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // Comando que deixa o navegador em tela cheia.
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Futebol");
		combo.selectByVisibleText("Karate");
		combo.selectByVisibleText("Corrida");
		
		List<WebElement> allSelectOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectOptions.size());
		
		combo.deselectByVisibleText("Corrida");//Desmarcar.
		
		allSelectOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectOptions.size());
		
		driver.quit();
	}
	
	@Test
	public void InteragirComBotões() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\assissl\\Desktop\\Curso Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // Comando que deixa o navegador em tela cheia.
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		driver.quit();
	}
	
	@Test
	@Ignore
	public void InteragirComLinks() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\assissl\\Desktop\\Curso Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // Comando que deixa o navegador em tela cheia.
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement link = driver.findElement(By.linkText("Voltar"));
		link.click();
		
		driver.quit();
	}
	@Test

	public void deveBuscarTextoNaPagina() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\assissl\\Desktop\\Curso Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // Comando que deixa o navegador em tela cheia.
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		Assert.assertEquals("Campo de Treinamento", 
				driver.findElement(By.tagName("h3")).getText()); //Procurar por Tag.
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", 
				driver.findElement(By.className("facilAchar")).getText());//Procuar por Class.
		driver.quit();
	}
	
}

	
