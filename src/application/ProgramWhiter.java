package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ProgramWhiter {

	public static void main(String[] args) {

		String[] lines = new String[] {"Good Morning","Good Afternoon", "Goog Night"};
		
		String path = "c:\\temp\\out.txt";
		
		 try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) { // Esta linha não recria o arquivo
		//try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			for (String line : lines ) {
				bw.write(line);
				bw.newLine(); // Inclui uma quebra de linha
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		
	}

}
