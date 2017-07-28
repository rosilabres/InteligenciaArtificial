package br.com.xlsreader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Reader {	
	
	public void processaSpamIndividual(File file) throws IOException {
		List<String> spamFile = Files.readAllLines(file.toPath());
		System.out.println(file.getAbsolutePath());
		Path path = Paths.get(System.getProperty("user.dir"));
		
		String[] vetorNomeArquivo = file.getName().split("_");
		StringBuilder novoNomeArquivo = new StringBuilder().append(vetorNomeArquivo[0]).append("_").append(vetorNomeArquivo[1]).append("_").append(vetorNomeArquivo[2]);
		
		File directory = new File(Paths.get(path + File.separator + "splitJavaIndividual" + File.separator + file.getParentFile().getName() + File.separator).toString());
		
		if(!directory.exists()) directory.mkdirs();

		Path p = Paths.get(directory.getPath() + File.separator + novoNomeArquivo.toString());
				
	
		for(String s : spamFile) {
			String[] sSeparada = s.split(Pattern.quote("#SUP: "));
			String seq = sSeparada[0].replaceAll(" -1 ", ">");
			String linhaAlunos = s.split(Pattern.quote("#SID: "))[1];
			
			List<String> alunosV = Arrays.asList(linhaAlunos.split(" "));
			for (String a : alunosV) {
				Files.write(p, (a + ";" + seq + "\n").getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
			}
		}
		
	}

	
	public void processaSpamFora(File file) throws IOException {
		List<String> spamFile = Files.readAllLines(file.toPath());
		System.out.println(file.getAbsolutePath());
		Path path = Paths.get(System.getProperty("user.dir"));
		
		String[] vetorNomeArquivo = file.getName().split("_");
		StringBuilder novoNomeArquivo = new StringBuilder().append(vetorNomeArquivo[0]).append("_").append(vetorNomeArquivo[1]).append("_").append(vetorNomeArquivo[2]).append("_").append(vetorNomeArquivo[3]);
		

		File directory = new File(Paths.get(path + File.separator + "splitJavaFora" + File.separator + file.getParentFile().getName() + File.separator).toString());
		
		if(!directory.exists()) directory.mkdirs();

		Path p = Paths.get(directory.getPath() + File.separator + novoNomeArquivo.toString());

	
		for(String s : spamFile) {
			String[] sSeparada = s.split(Pattern.quote("#SUP: "));
			String seq = sSeparada[0].replaceAll(" -1 ", ">");
			String linhaAlunos = s.split(Pattern.quote("#SID: "))[1];
			
			List<String> alunosV = Arrays.asList(linhaAlunos.split(" "));
			for (String a : alunosV) {
				Files.write(p, (a + ";" + seq + "\n").getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
			}
		}
		
	}

	
}
