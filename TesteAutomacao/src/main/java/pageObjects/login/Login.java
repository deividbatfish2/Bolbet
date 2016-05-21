package pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageObjects.base.Base;

public class Login extends Base{

	private WebElement campoEmail;
	private WebElement campoSenha;
	private WebElement campoSalvarSenha;
	private WebElement botaoFechar;
	private WebElement botaoEntrar;
	
	public Login(WebDriver navegadorLocal){
		iniciaNavegador(navegadorLocal);
		aguarde.until(ExpectedConditions.visibilityOf(navegador.findElement(By.id("TxbEmail"))));
		campoEmail = navegador.findElement(By.id("TxbEmail"));
		campoSenha = navegador.findElement(By.id("TxbSenha"));
		campoSalvarSenha = navegador.findElement(By.cssSelector("label[for=\"CkbSalvarSenha\"]"));
		botaoFechar = navegador.findElement(By.id("BtnFecharLogin"));
		botaoEntrar = navegador.findElement(By.id("BtnEntrar"));
	}
	
	public void preencherCampoEmail(String email){
		campoEmail.clear();
		campoEmail.sendKeys(email);
	}
	
	public void preencherCampoSenha(String senha){
		
		Actions acao = new Actions(navegador);
		acao.moveToElement(campoSenha).perform();
		acao.click(campoSenha).perform();
		campoSenha.clear();
		acao.sendKeys(campoSenha, senha).perform();
	}
	
	public void selecionarOpcaoSalvarSenha(String opcao){
		if(opcao.equalsIgnoreCase("sim") && navegador.findElement(By.id("HdfSalvarSenha")).getAttribute("value").equalsIgnoreCase("false")){
			campoSalvarSenha.click();
		}
		else{
			if(opcao.equalsIgnoreCase("não") && navegador.findElement(By.id("HdfSalvarSenha")).getAttribute("value").equalsIgnoreCase("true")){
				campoSalvarSenha.click();
			}
		}
	}
	
	public void clicarNoBotaoFechar(){
		botaoFechar.click();
	}
	
	public void clicarNoBotaoEntrar(){
		botaoEntrar.click();
	}

	public boolean verificaUsuarioLogado(String nome) {
		try{
			navegador.findElement(By.cssSelector("a[class=\"dropdown-toggle fw600 p15\"] span"));
			if(nome.equals(navegador.findElement(By.cssSelector("a[class=\"dropdown-toggle fw600 p15\"] span")).getText())){
				return true;
			}
			else{
				return false;
			}
		}
		catch(Exception e){
			return false;
		}
		
	}
	
}
