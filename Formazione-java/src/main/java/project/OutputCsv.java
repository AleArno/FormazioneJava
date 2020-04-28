package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class OutputCsv implements Output {

	@Override
	public void menu() {
		String inputXML;
		System.out.println("Insert XML file path");
		inputXML = keyb.next();
		Parser p = Parser.getInstance();
		try {
			ArrayList<Person> persone= p.parseXML(inputXML);
			System.out.println("Insert CSV file destination path");
			String outputCSV = keyb.next();
			write(persone, outputCSV);

		} catch (Exception e) {
			System.err.println("Error");
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	public void write(ArrayList<Person> elements, String filename) {
		try {
			System.out.println("I'm writing on file: " + filename);
			PrintWriter outFile = new PrintWriter(filename);
			outFile.println("uniqueKey , name , surname , birth");
			for (int i = 0; i < elements.size(); i++) {
				outFile.println(elements.get(i).toString());
			}

			outFile.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}

}
