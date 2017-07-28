package br.com.xlsreader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class Main {
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		Path path = Paths.get(System.getProperty("user.dir"));
		
		Reader r = new Reader();
		
//		File folder = new File(path.toString() + File.separator + "depositoJava"+ File.separator + "fora" + File.separator + "spam" + File.separator);
//		for (File f : folder.listFiles()) {
//		for(File file : f.listFiles()) {
//			r.processaSpamFora(file);
//		}
//			}
		
	File folder = new File(path.toString() + File.separator + "depositoJava" + File.separator + "individual" + File.separator + "spam" + File.separator);
		for (File f : folder.listFiles()) {
			for(File file : f.listFiles()) {
				r.processaSpamIndividual(file);
			}
				
			}
			
		System.out.println("Fim de leitura.");
	}
}
