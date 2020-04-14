package Project;
import org.w3c.dom.*;

import javax.xml.parsers.*;

import java.util.ArrayList;

public class Parser {

	public Parser() {
	}

	private Persona getPersona(Element element) {
		Persona p;
		String key = getTextValue(element, "uniqueKey");
		String name = getTextValue(element, "name");
		String surname = getTextValue(element, "surname");
		String birth = getTextValue(element, "Birth");

		p = new Persona(key, name, surname, birth);
		return p;
	}

	private String getTextValue(Element element, String tag) {
		String value = null;
		NodeList nodelist;
		nodelist = element.getElementsByTagName(tag);
		if (nodelist != null && nodelist.getLength() > 0) {
			value = nodelist.item(0).getFirstChild().getNodeValue();
		}
		return value;
	}

	public ArrayList<Persona> parseXML(String filename) throws Throwable {
		ArrayList<Persona> persone = new ArrayList<Persona>();
		DocumentBuilderFactory factory;
		DocumentBuilder builder;
		Document document;
		Element element;
		NodeList nodelist;
		Persona p;

		factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();
		document = builder.parse(filename);
		nodelist = document.getElementsByTagName("Person");
		if (nodelist != null && nodelist.getLength() > 0) {
			for (int i = 0; i < nodelist.getLength(); i++) {
				Node node = nodelist.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					element = (Element) node;
					p = getPersona(element);
					persone.add(p);

				}

			}

		}

		return persone;
	}

}
