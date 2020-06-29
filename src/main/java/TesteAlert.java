import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAlert {
	@Test
	public void TestAlert() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\assissl\\Desktop\\Curso Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // Comando que deixa o navegador em tela cheia.
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples", texto);
		alert.accept();
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
		
		driver.quit();
	}
	
	@Test
	public void TestAlertConfirm() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\assissl\\Desktop\\Curso Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // Comando que deixa o navegador em tela cheia.
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("confirm")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alerta.getText());
		alerta.accept();
		Assert.assertEquals("Confirmado", alerta.getText());
		alerta.accept();
		
		driver.findElement(By.id("confirm")).click();
		alerta = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alerta.getText());
		alerta.dismiss();
		Assert.assertEquals("Negado", alerta.getText());
		alerta.accept();
		
		driver.quit();
	}
	
	@Test
	public void TestAlertConfirmPrompt() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\assissl\\Desktop\\Curso Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // Comando que deixa o navegador em tela cheia.
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
		driver.findElement(By.id("prompt")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alerta.getText());
		alerta.sendKeys("12");
		alerta.accept();
		Assert.assertEquals("Era 12?", alerta.getText());
		alerta.accept();
		Assert.assertEquals(":D", alerta.getText());
		
		driver.quit();
	}

}