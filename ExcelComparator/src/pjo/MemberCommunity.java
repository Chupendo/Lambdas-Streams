package pjo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class MemberCommunity {

	private Integer codEmployed;
	private String name;
	private String office;
	private String category;
	private String rol;
	private String level;
	private List<String> codeProject;
	private List<String> project;
	private List<Integer> codResponsable;
	private List<String> responsable;
	private List<String> technology;
	private List<String> certification;
	private boolean low;
	
	//Constructors
	public MemberCommunity() {
		
	}
public MemberCommunity(MemberCommunity m) {
	this.codEmployed =m.getCodEmployed();// codEmployed;
	this.name = m.getName(); //name
	this.office = m.getOffice(); //office;
	this.category = m.getCategory();  //category;
	this.rol = m.getRol(); //rol;
	this.level = m.getLevel(); //level;
	this.codeProject = m.getCodeProject(); //codeProject;
	this.project = m.getProject(); //project;
	this.codResponsable = m.getCodResponsable(); //codResponsable;
	this.responsable = m.getResponsable(); //responsable;
	this.technology = m.getTechnology(); //technology;
	this.certification = m.getCertification(); //certification;
	this.low = m.isLow(); //low;
	}
	public MemberCommunity(Integer codEmployed, String name, String office, String category, String rol, String level,
			List<String> codeProject, List<String> project, List<Integer> codResponsable, List<String> responsable,
			List<String> technology, List<String> certification, boolean low) {
		this.codEmployed = codEmployed;
		this.name = name;
		this.office = office;
		this.category = category;
		this.rol = rol;
		this.level = level;
		this.codeProject = codeProject;
		this.project = project;
		this.codResponsable = codResponsable;
		this.responsable = responsable;
		this.technology = technology;
		this.certification = certification;
		this.low = low;
	}

	/* hashCode, equal & toSTring */
	public Integer getCodEmployed() {
		return codEmployed;
	}
	@Override
	public int hashCode() {
		return Objects.hash(category, certification, codEmployed, codResponsable, codeProject, level, low, name, office,
				project, responsable, rol, technology);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof MemberCommunity)) {
			return false;
		}
		MemberCommunity other = (MemberCommunity) obj;
		return Objects.equals(category, other.category) && Objects.equals(certification, other.certification)
				&& Objects.equals(codEmployed, other.codEmployed)
				&& Objects.equals(codResponsable, other.codResponsable)
				&& Objects.equals(codeProject, other.codeProject) && Objects.equals(level, other.level)
				&& low == other.low && Objects.equals(name, other.name) && Objects.equals(office, other.office)
				&& Objects.equals(project, other.project) && Objects.equals(responsable, other.responsable)
				&& Objects.equals(rol, other.rol) && Objects.equals(technology, other.technology);
	}
	
	
	@Override
	public String toString() {
		return "MemberCommunity [codEmployed=" + codEmployed + ", name=" + name + ", office=" + office + ", category="
				+ category + ", rol=" + rol + ", level=" + level + ", codeProject=" + codeProject + ", project="
				+ project + ", codResponsable=" + codResponsable + ", responsable=" + responsable + ", technology="
				+ technology + ", certification=" + certification + ", low=" + low + "]";
	}

	/* Getters && Setters*/
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public List<String> getCodeProject() {
		return codeProject;
	}

	public void setCodeProject(List<String> codeProject) {
		this.codeProject = codeProject;
	}

	public List<String> getProject() {
		return project;
	}

	public void setProject(List<String> project) {
		this.project = project;
	}

	public List<Integer> getCodResponsable() {
		return codResponsable;
	}

	public void setCodResponsable(List<Integer> codResponsable) {
		this.codResponsable = codResponsable;
	}

	public List<String> getResponsable() {
		return responsable;
	}

	public void setResponsable(List<String> responsable) {
		this.responsable = responsable;
	}

	public List<String> getTechnology() {
		return technology;
	}

	public void setTechnology(List<String> technology) {
		this.technology = technology;
	}

	public List<String> getCertification() {
		return certification;
	}

	public void setCertification(List<String> certification) {
		this.certification = certification;
	}

	public boolean isLow() {
		return low;
	}

	public void setLow(boolean low) {
		this.low = low;
	}

	public void setCodEmployed(Integer codEmployed) {
		this.codEmployed = codEmployed;
	}

	

	
	
	
	
}
