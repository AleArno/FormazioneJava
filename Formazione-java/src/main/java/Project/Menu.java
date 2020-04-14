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
				"Per leggere un file XML ed esportarlo in un file csv digitare 1 \n Per leggere un file XML ed inserire i dati nel DB digitare 2 \n ");
		i = keyb.nextInt();
		switch (i) {
		case 1:
			fromXMLtoCSV(keyb);
			break;
		case 2:
			DatabaseConnection db=new DatabaseConnection();
			Parser pa=new Parser();
			ArrayList<Persona>persone=new ArrayList<Persona>();
			System.out.print("Inserire il path del file contenente i dati da inserire sul DB");
			String path= keyb.next();
			persone=pa.parseXML(path);
			for(int j=0;j<persone.size();j++) {
				System.out.println("Inserita persona numero: "+j);
				db.insertDB(persone.get(j));	
			}
			
		
			db.closeConnection();
			break;
		}
	}
	

	public void fromXMLtoCSV(Scanner keyb) throws Throwable {

		String inputXML, outputCSV;
		System.out.print("Inserire il path del file XML");
		inputXML = keyb.next();
		System.out.println("");
		Parser p = new Parser();
		try {
			//File input = new File(inputXML);
			
			ArrayList<Persona> persone = null;
			persone = p.parseXML(inputXML);
			System.out.println("Inserire il path destinazione del file CSV \n");
			outputCSV = keyb.next();
			File output = new File(outputCSV);
			Iterator iterator = persone.iterator();
			
				
				output.write(persone);
			
			
		} catch (Exception e) {
			System.err.println("Errore dio");
			e.printStackTrace();
		}
		keyb.close();
	}

}
