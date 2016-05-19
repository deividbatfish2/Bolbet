package pageObjects.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public WebDriver navegador;
	public WebDriverWait aguarde;
	
	public void iniciaNavegador(WebDriver navegadorLocal){
		navegador = navegadorLocal;
		aguarde = new WebDriverWait(navegador, 10);
	}
	
}
