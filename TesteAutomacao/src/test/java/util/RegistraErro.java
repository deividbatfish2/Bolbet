package util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class RegistraErro {

	private String localImagens = new File("src/test/resources/imagens_Bug").getAbsolutePath();
	
	public RegistraErro(){
		
		SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
		localImagens = localImagens + "/"+format1.format(Calendar.getInstance().getTime());
		
		try{
			if(!new File(localImagens).exists()){
				new File(localImagens).mkdirs();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void registraErro(WebDriver navegadorLocal) {
		File imagemBug = ((TakesScreenshot)navegadorLocal).getScreenshotAs(OutputType.FILE);
		try {
			SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
			String hora = format1.format(Calendar.getInstance().getTime());
			FileUtils.copyFile(imagemBug, new File(localImagens+"/"+hora+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
