package project;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class File {

	protected String fileName;

	public File() {

	}

	public File(String fileName) {
		this.fileName = fileName;

	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void fileContains() {
		try {
			System.out.println("I'm reading from the file: " + this.getFileName());
			Scanner inFile = new Scanner(new FileReader(this.fileName));
			System.out.println("Content: ");

			while (inFile.hasNextLine()) {
				System.out.println(inFile.nextLine());
			}

			inFile.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public void write(ArrayList<Person> elements) {
		try {
			System.out.println("I'm writing on file: " + this.getFileName());
			PrintWriter outFile = new PrintWriter(new FileWriter(this.fileName));
			outFile.println("uniqueKey , name , surname , birth");
			for (int i=0;i<elements.size();i++) {
				outFile.println(elements.get(i).toString());
			}

			outFile.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public ArrayList<String> fileItems() {
		ArrayList<String> elements = new ArrayList<String>();
		try {
			Scanner inFile = new Scanner(new FileReader(this.fileName));
			while (inFile.hasNextLine()) {
				elements.add(inFile.nextLine());
			}
			inFile.close();
		} catch (IOException e) {
			System.err.println(e);
		}
		return elements;
	}
	


}