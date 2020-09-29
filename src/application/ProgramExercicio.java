package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class ProgramExercicio {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<>();

        // variável para receber a entrada com o caminho do arquivo
		System.out.println("Enter file path:");
		String path = sc.nextLine();

		// caminho do arquivo de entrada
		File sourceFile = new File(path);
		String sourceFolderStr = sourceFile.getParent();
		
		// Criar o arquivo de saída
		boolean success = new File(sourceFile.getParent() + "\\out").mkdir();
		String targetFileStr = sourceFolderStr + "\\out\\summary.csv";
		
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {

			String itemCsv = br.readLine();
			while (itemCsv != null) {

				String[] fields = itemCsv.split(",");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);
				
				list.add(new Product(name, price, quantity));
				itemCsv = br.readLine();

			}
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {
				
				for (Product item : list) {
					bw.write(item.getName() + "," + String.format("%.2f",item.total()));
					bw.newLine();
				}
				
				System.out.println(targetFileStr + " Created!");
				
			} catch (IOException e) {
				System.out.println("Erro ao escrever o arquivo " + e.getMessage());
				
			}
				
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
		
	}

}
