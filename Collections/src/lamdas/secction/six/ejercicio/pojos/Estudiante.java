package lamdas.secction.six.ejercicio.pojos;

public class Estudiante {

	private String identification;
	private int edad;
	private double altura;
	private double promedio;
	
	public Estudiante(String identification, int edad, double altura, double promedio) {
		this.identification = identification;
		this.edad = edad;
		this.altura = altura;
		this.promedio = promedio;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}

	@Override
	public String toString() {
		return "Estudiante [identification=" + identification + ", edad=" + edad + ", altura=" + altura + ", promedio="
				+ promedio + "]";
	}
	
}
