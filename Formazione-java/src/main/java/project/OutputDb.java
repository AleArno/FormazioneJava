package project;

import java.util.ArrayList;

public class OutputDb implements Output {

	@Override
	public void menu() {

		DatabaseConnection db = DatabaseConnection.getInstance();
		db.start();
		Parser pa = Parser.getInstance();
		ArrayList<Person> persone = new ArrayList<Person>();
		System.out.println("Insert XML file path");
		String path = keyb.next();
		try {
			persone = pa.parseXML(path);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		for (int j = 0; j < persone.size(); j++) {
			db.insertDB(persone.get(j));
		}
		System.out.println("Person successfully added to DB");

		db.closeConnection();
	}

}
