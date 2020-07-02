import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteJanelaPopUp {

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
	public void InteragirPopUp() {

		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup"); // Redirecionando para a Janela do PopUp
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo!"); // Escrevendo no PopUp
		driver.close(); // Fechar apenas a janela do PopUp
		driver.switchTo().window(""); // Retornando para a Janela Principal.
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo tamb�m!");
	}

	@Test
	public void InteragirJanelaSemTitulo() {

		driver.findElement(By.id("buttonPopUpHard")).click();
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
		driver.findElement(By.tagName("textarea")).sendKeys("Testando no Pop-Up");

		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.tagName("textarea")).sendKeys("Testando na Home");
	}
}
