package lambdas.secction.For.method.refence.three;

public class Persona {
	private String name;
	private int edad;
	private String email;
		
	public Persona(String name, int edad, String email) {
		this.name = name;
		this.edad = edad;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Persona [name=" + name + ", edad=" + edad + ", email=" + email + "]";
	}
	
	public static int comparPorEda(Persona a, Persona b) {
		return a.getEdad()-b.getEdad();
	}
	
	public int comparPorEda2(Persona b) {
		return b.getEdad()-this.edad;
	}
}
