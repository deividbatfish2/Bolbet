package pageObjects.homePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageObjects.base.Base;
import pageObjects.login.Login;

public class HomePage extends Base{

	private WebElement linkLogin;

	public HomePage(WebDriver navegadorLocal) {
		iniciaNavegador(navegadorLocal);
		aguarde.until(ExpectedConditions.visibilityOf(navegador.findElement(By.id("LkbLogin"))));
		linkLogin = navegador.findElement(By.id("LkbLogin"));
	}

	public Login logarNoSistema() {
		linkLogin.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Login login = new Login(navegador);
		return login;
	}

	
	
}
