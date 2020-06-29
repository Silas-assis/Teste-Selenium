import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastro {
	@Test

	public void criandoUmCadastro() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\assissl\\Desktop\\Curso Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // Comando que deixa o navegador em tela cheia.
		driver.get("file:///" + System.getProperty("user.dir") + 
				"/src/main/resources/componentes.html");
	
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste"); //Input Nome.
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Testando"); // Input Sobrenome.
		driver.findElement(By.id("elementosForm:sexo:0")).click(); //Escolhendo Sexo Masculino.
		driver.findElement(By.id("elementosForm:comidaFavorita:1")).click(); // Escolhendo Comida (Frango).
		
		WebElement elementEscolaridade =  driver.findElement(By.id("elementosForm:escolaridade")); // Escolhendo Escolaridade.
		Select comboEscolaridade = new Select(elementEscolaridade);
		comboEscolaridade.selectByVisibleText("Superior"); 
		
		WebElement elementEsportes =  driver.findElement(By.id("elementosForm:esportes")); // Escolhendo Esportes.
		Select comboEsportes = new Select(elementEsportes);
		comboEsportes.selectByVisibleText("Corrida");
		comboEsportes.selectByVisibleText("Futebol");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();//Botão para Cadastrar.
	}
}
