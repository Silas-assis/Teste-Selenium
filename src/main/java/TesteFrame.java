import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteFrame {
	
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
	public void frame() {
		
		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		Alert alert = driver.switchTo().alert();
		String mensagem = alert.getText();
		Assert.assertEquals("Frame OK!", mensagem);
		alert.accept();
		
		driver.switchTo().defaultContent();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(mensagem);
	}
}
