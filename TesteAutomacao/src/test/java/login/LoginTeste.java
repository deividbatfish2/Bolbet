package login;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import baseTeste.BaseTeste;
import pageObjects.homePage.HomePage;
import pageObjects.login.Login;
import pageObjects.paginaInicial.PaginaInicial;
public class LoginTeste extends BaseTeste{
	
	@Test
	public void testeLogin(){
		PaginaInicial paginaInicial = new PaginaInicial(navegadorLocal);
		HomePage home = paginaInicial.acessarSistema();
		Login paginaLogin = home.logarNoSistema();
		paginaLogin.preencherCampoEmail("Teste@teste.com");
		paginaLogin.preencherCampoSenha("Senha");
		paginaLogin.clicarNoBotaoEntrar();
		try{
			assertTrue(false);
		}
		catch (AssertionError e) {
			bug.registraErro(navegadorLocal);
			throw new AssertionError("Não foi possível realizar o login na aplicação");
		}
		
		System.out.println("testes");
	}

}
