package project;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Menu {
	Scanner keyb = new Scanner(System.in);
	private static Menu istance;
	
	private Menu() {
	}
	
	public static Menu getIstance() {
		if(istance==null) {
			istance=new Menu();
		}
		return istance;
	}

	public void create() throws Throwable {
		
		int i;
		do {
		System.out.println("*********** MENU ***********");
		System.out.println(
				"To read a XML file and export it in CSV digit 1 \n To read a XML file and insert data into DB digit 2 \n ");
		i = keyb.nextInt();
		
		switch (i) {
		case 1:
			fromXMLtoCSV();
			break;
		case 2:
			dbInsert();
			break;
		}
		System.out.println("Do you want to continue? \n Digit 1 to continue or 0 to end.");
		i=keyb.nextInt();
		{
			}
		}
		while(i!=0);
		keyb.close();
		
	}
		

	private void fromXMLtoCSV() throws Throwable {

		String inputXML, outputCSV;
		System.out.print("Insert XML file path");
		inputXML = keyb.next();
		System.out.println("");
		Parser p = Parser.getInstance();
		try {
			// File input = new File(inputXML);

			ArrayList<Person> persone = null;
			persone = p.parseXML(inputXML);
			System.out.println("Insert CSV file destination path \n");
			outputCSV = keyb.next();
			File output = new File(outputCSV);
			write(persone,outputCSV);

		} catch (Exception e) {
			System.err.println("Error");
			e.printStackTrace();
		}
		
	}
	
	private void dbInsert() {
		DatabaseConnection db=DatabaseConnection.getInstance();
		db.start();
		Parser pa = Parser.getInstance();
		ArrayList<Person> persone = new ArrayList<Person>();
		System.out.print("Insert file path");
		String path = keyb.next();
		try {
			persone = pa.parseXML(path);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		for(int j=0;j<persone.size();j++) {
			db.insertDB(persone.get(j));
		}
		
		db.closeConnection();
	}

	public void write(ArrayList<Person> elements,String filename) {
		try {
			System.out.println("I'm writing on file: " + filename);
			PrintWriter outFile = new PrintWriter(filename);
			outFile.println("uniqueKey , name , surname , birth");
			for (int i=0;i<elements.size();i++) {
				outFile.println(elements.get(i).toString());
			}

			outFile.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
}
