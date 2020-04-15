package project;

public class Person {

	private String key;
	private String name;
	private String surname;
	private String birth;

	public Person() {
	}

	public Person(String key, String name, String surname, String birth) {
		this.key = key;
		this.name = name;
		this.surname = surname;
		this.birth = birth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return key+" , "+name+" , "+surname+" , "+birth;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

}
