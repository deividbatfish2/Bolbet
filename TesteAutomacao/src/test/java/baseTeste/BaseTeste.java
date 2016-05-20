package baseTeste;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import util.RegistraErro;

public class BaseTeste {

	public WebDriver navegadorLocal;
	public RegistraErro bug;
	
	@BeforeMethod
	public void inciaTeste(){
		bug = new RegistraErro();
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drives/chromedriver");
		navegadorLocal = new ChromeDriver();
		navegadorLocal.get("http://www.bolbet.com.br");
		manipulaNavegador();
	}
	
	private void manipulaNavegador() {
		navegadorLocal.manage().window().maximize();
		
	}

	@AfterMethod
	public void finalizaTeste(){
		navegadorLocal.close();
	}
	
}
