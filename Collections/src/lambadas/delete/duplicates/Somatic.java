package lambadas.delete.duplicates;

import java.util.Date;

public class Somatic {
	private int numeroPoliza;
	private String tomador;
	private String tomadorDni;
	private Date efectoPoliza;
	
	public Somatic() {};
	public Somatic(int numeroPoliza, String tomador, String tomadorDni, Date efectoPoliza) {
		super();
		this.numeroPoliza = numeroPoliza;
		this.tomador = tomador;
		this.tomadorDni = tomadorDni;
		this.efectoPoliza = efectoPoliza;
	}

	public int getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(int numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public String getTomador() {
		return tomador;
	}

	public void setTomador(String tomador) {
		this.tomador = tomador;
	}

	public String getTomadorDni() {
		return tomadorDni;
	}

	public void setTomadorDni(String tomadorDni) {
		this.tomadorDni = tomadorDni;
	}

	public Date getEfectoPoliza() {
		return efectoPoliza;
	}

	public void setEfectoPoliza(Date date) {
		this.efectoPoliza = date;
	}

	@Override
	public String toString() {
		return "Somatic [numeroPoliza=" + numeroPoliza + ", tomador=" + tomador + ", tomadorDni=" + tomadorDni
				+ ", efectoPoliza=" + efectoPoliza + "]";
	}
}
