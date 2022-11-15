package lambdas.secction.three.function.ejercicios.two;

public class Comensal {
	String name;
	String surname;
	Integer edad;
	public Comensal(String name, String surname, Integer edad) {
		this.name = name;
		this.surname = surname;
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "Comensal [name=" + name + ", surname=" + surname + ", edad=" + edad + "]";
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
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	
}
