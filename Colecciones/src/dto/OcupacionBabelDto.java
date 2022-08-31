package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class OcupacionBabelDto implements Serializable {
    private Integer numProyecto;
    private Integer codEmpleado;
    private String codProyecto;
    private Integer codEmpleadoReal;
    private Date fechOcupacion;
    private Integer indManANAtARDE;
    private Integer indRealPrevisto;
    private Integer tipoDia;
    
    public OcupacionBabelDto(int i, int j, String string, int k, Date date, int l, int m, int n) {
    	this.numProyecto = i;
		this.codEmpleado = j;
		this.codProyecto = string;
		this.codEmpleadoReal = k;
		this.fechOcupacion = date;
		this.indManANAtARDE = l;
		this.indRealPrevisto = m;
		this.tipoDia = n;
	}
    
    
    
	@Override
	public int hashCode() {
		return Objects.hash(codEmpleado, codEmpleadoReal, codProyecto, fechOcupacion, indManANAtARDE, indRealPrevisto,
				numProyecto, tipoDia);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof OcupacionBabelDto)) {
			return false;
		}
		OcupacionBabelDto other = (OcupacionBabelDto) obj;
		return Objects.equals(codEmpleado, other.codEmpleado) && Objects.equals(codEmpleadoReal, other.codEmpleadoReal)
				&& Objects.equals(codProyecto, other.codProyecto) && Objects.equals(fechOcupacion, other.fechOcupacion)
				&& Objects.equals(indManANAtARDE, other.indManANAtARDE)
				&& Objects.equals(indRealPrevisto, other.indRealPrevisto)
				&& Objects.equals(numProyecto, other.numProyecto) && Objects.equals(tipoDia, other.tipoDia);
	}

	

	@Override
	public String toString() {
		return "OcupacionBabelDto [numProyecto=" + numProyecto + ", codEmpleado=" + codEmpleado + ", codProyecto="
				+ codProyecto + ", codEmpleadoReal=" + codEmpleadoReal + ", fechOcupacion=" + fechOcupacion
				+ ", indManANAtARDE=" + indManANAtARDE + ", indRealPrevisto=" + indRealPrevisto + ", tipoDia=" + tipoDia
				+ "]";
	}



	public OcupacionBabelDto(Integer numProyecto, Integer codEmpleado, String codProyecto, Integer codEmpleadoReal,
			Date fechOcupacion, Integer indManANAtARDE, Integer indRealPrevisto, Integer tipoDia) {
		this.numProyecto = numProyecto;
		this.codEmpleado = codEmpleado;
		this.codProyecto = codProyecto;
		this.codEmpleadoReal = codEmpleadoReal;
		this.fechOcupacion = fechOcupacion;
		this.indManANAtARDE = indManANAtARDE;
		this.indRealPrevisto = indRealPrevisto;
		this.tipoDia = tipoDia;
	}
	public Integer getNumProyecto() {
		return numProyecto;
	}
	public void setNumProyecto(Integer numProyecto) {
		this.numProyecto = numProyecto;
	}
	public Integer getCodEmpleado() {
		return codEmpleado;
	}
	public void setCodEmpleado(Integer codEmpleado) {
		this.codEmpleado = codEmpleado;
	}
	public String getCodProyecto() {
		return codProyecto;
	}
	public void setCodProyecto(String codProyecto) {
		this.codProyecto = codProyecto;
	}
	public Integer getCodEmpleadoReal() {
		return codEmpleadoReal;
	}
	public void setCodEmpleadoReal(Integer codEmpleadoReal) {
		this.codEmpleadoReal = codEmpleadoReal;
	}
	public Date getFechOcupacion() {
		return fechOcupacion;
	}
	public void setFechOcupacion(Date fechOcupacion) {
		this.fechOcupacion = fechOcupacion;
	}
	public Integer getIndManANAtARDE() {
		return indManANAtARDE;
	}
	public void setIndManANAtARDE(Integer indManANAtARDE) {
		this.indManANAtARDE = indManANAtARDE;
	}
	public Integer getIndRealPrevisto() {
		return indRealPrevisto;
	}
	public void setIndRealPrevisto(Integer indRealPrevisto) {
		this.indRealPrevisto = indRealPrevisto;
	}
	public Integer getTipoDia() {
		return tipoDia;
	}
	public void setTipoDia(Integer tipoDia) {
		this.tipoDia = tipoDia;
	}
    
    
}
