package Project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Menu {
	public Menu() {

	}

	public void create() throws Throwable {
//	public Menu() throws Throwable {
		Scanner keyb = new Scanner(System.in);
		int i;
		System.out.println("*********** MENU ***********");
		System.out.println(
				"To read a XML file and export it in CSV digit 1 \n To read a XML file and insert data into DB digit 2 \n ");
		i = keyb.nextInt();
		switch (i) {
		case 1:
			fromXMLtoCSV(keyb);
			break;
		case 2:
			DatabaseConnection db = new DatabaseConnection();
			Parser pa = new Parser();
			ArrayList<Person> persone = new ArrayList<Person>();
			System.out.print("Insert file path");
			String path = keyb.next();
			persone = pa.parseXML(path);
			db.closeConnection();
			break;
		}
	}

	public void fromXMLtoCSV(Scanner keyb) throws Throwable {

		String inputXML, outputCSV;
		System.out.print("Insert XML file path");
		inputXML = keyb.next();
		System.out.println("");
		Parser p = new Parser();
		try {
			// File input = new File(inputXML);

			ArrayList<Person> persone = null;
			persone = p.parseXML(inputXML);
			System.out.println("Insert CSV file destination path \n");
			outputCSV = keyb.next();
			File output = new File(outputCSV);
			Iterator iterator = persone.iterator();

			output.write(persone);

		} catch (Exception e) {
			System.err.println("Error");
			e.printStackTrace();
		}
		keyb.close();
	}

}
