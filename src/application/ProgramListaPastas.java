package application;

import java.io.File;
import java.util.Scanner;

public class ProgramListaPastas {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Entre com o diretório das pastas:");
		String strPath = sc.nextLine();

		File path = new File(strPath);
		
        // Lê as pastas no caminho especificado
		File[] folders = path.listFiles(File::isDirectory);
		System.out.println("Folders:");
		for (File folder : folders) {
			System.out.println(folder);
		
		}
		
		// Lê os arquivos no caminho especificado
		File[] files = path.listFiles(File::isFile);
		System.out.println("Files:");
		
		for (File file : files) {
			System.out.println(file);
		}

		// Cria uma pasta com o nome especificado
		boolean sucess = new File(strPath + "\\subdir").mkdir();
		System.out.println("Pasta criada com sucesso" + sucess);
		sc.close();
		
	}

}
