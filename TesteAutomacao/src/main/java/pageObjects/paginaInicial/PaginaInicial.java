package pageObjects.paginaInicial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageObjects.base.Base;
import pageObjects.homePage.HomePage;

public class PaginaInicial extends Base{

	private WebElement botaoEntrar;
	
	public PaginaInicial(WebDriver navegadorLocal){
		iniciaNavegador(navegadorLocal);
		aguarde.until(ExpectedConditions.visibilityOf(navegador.findElement(By.cssSelector("a[class=\"btnParticipe pull-right\"]"))));
		botaoEntrar = navegador.findElement(By.cssSelector("a[class=\"btnParticipe pull-right\"]"));
	}

	public HomePage acessarSistema() {
		botaoEntrar.click();
		HomePage home = new HomePage(navegador);
		return home;
	}
	
}
