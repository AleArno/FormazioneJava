package project;

import java.util.Scanner;

public class Menu {
	Scanner keyb = new Scanner(System.in);
	private static Menu istance;

	private Menu() {
	}

	public static Menu getIstance() {
		if (istance == null) {
			istance = new Menu();
		}
		return istance;
	}

	public void create() throws Throwable {

		int i;
		do {
			System.out.println("*********** MENU ***********");
			System.out.println("-To read a XML file and export it in CSV digit 1");
			System.out.println("-To read a XML file and insert data into DB digit 2");
			i = keyb.nextInt();

			if (i == 1) {

				OutputCsv csv = new OutputCsv();
				csv.menu();
			}
			if (i == 2) {
				OutputDb odb = new OutputDb();
				odb.menu();
				break;
			}

			System.out.println("Do you want to continue?");
			System.out.println("-Digit 1 to continue");
			System.out.println("-Digit 0 to end");
			i = keyb.nextInt();

		} while (i != 0);
		keyb.close();

	}
}
