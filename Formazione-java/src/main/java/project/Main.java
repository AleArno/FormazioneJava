package project;

public class Main {

	public static void main(String[] args) throws Throwable {

		Menu m = Menu.getIstance();
		OutputCsv csv=new OutputCsv();
		OutputDb db=new OutputDb();
		m.add(csv);
		m.add(db);
		m.menu();
	}

}
