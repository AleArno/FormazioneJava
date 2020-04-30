package project;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu implements Output{
	Scanner keyb = new Scanner(System.in);
	private List<Output> out=new ArrayList<Output>();
	private static Menu istance;

	private Menu() {
	}

	public static Menu getIstance() {
		if (istance == null) {
			istance = new Menu();
		}
		return istance;
	}
	@Override
	public void menu() {

		int i;
		do {
			System.out.println("*********** MENU ***********");
			System.out.println("-To read a XML file and export it in CSV digit 1");
			System.out.println("-To read a XML file and insert data into DB digit 2");
			i = keyb.nextInt();
			if(i!=1 || i!=2) {
				System.out.println("Inserisci una scelta corretta");
			if (i == 1) {
				for(int j=0;j<out.size();j++) {
					if(out.get(j).getClass().equals(OutputCsv.class)) {
						out.get(j).menu();
					}
				}
				
			}
			if (i == 2) {
				for(int j=0;j<out.size();j++) {
					if(out.get(j).getClass().equals(OutputDb.class)) {
						out.get(j).menu();
					}
				}
			}
			
			
			
			
			}
			
			System.out.println("Do you want to continue?");
			System.out.println("-Digit 1 to continue");
			System.out.println("-Digit 0 to end");
			i = keyb.nextInt();

		} while (i != 0);
		keyb.close();

	}
	
	public void add(Output o) {
		out.add(o);
	}
	
}
