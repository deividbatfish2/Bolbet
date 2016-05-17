import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTeste {

	public WebDriver navegadorLocal;
	
	@BeforeMethod
	public void inciaTeste(){
		navegadorLocal = new FirefoxDriver();
	}
	
}
