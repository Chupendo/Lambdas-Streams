package babel.compares.back.dto;

import java.util.List;
import java.util.Objects;

public class PersonDigitalCenters {
	private Integer codEmployed;
	private String name;
	private String linkCV;
	private String technologyComunity;
	private Double rate;
	private String rol;
	private String center;
	private String profile;
	private String drefyfusLevel;
	private String office;
	private boolean scholar;
	private String admisionDate;
	private String outputDate;
	private String outputPreviewDate;
	private String validaterMain;
	private String validaterSecond;
	private String assigned;
	private String subcontracted;

	// Constructors
	public PersonDigitalCenters() {
	}

	public PersonDigitalCenters(PersonDigitalCenters m) {
		this.codEmployed = m.getCodEmployed(); //codEmployed;
		this.name = m.getName(); //name;
		this.linkCV = m.getLinkCV(); //linkCV;
		this.technologyComunity = m.getTechnologyComunity(); //technologyComunity;
		this.rate = m.getRate(); //rate;
		this.rol = m.getRol(); //rol;
		this.center = m.getCenter(); //center;
		this.profile = m.getProfile(); //profile;
		this.drefyfusLevel = m.getDrefyfusLevel(); //drefyfusLevel;
		this.office = m.getOffice(); //office;
		this.scholar = m.isScholar(); //scholar;
		this.admisionDate = m.getAdmisionDate(); //admisionDate;
		this.outputPreviewDate = m.getOutputPreviewDate(); //outputPreviewDate;
		this.validaterMain = m.getValidaterMain(); //validaterMain;
		this.validaterSecond = m.getValidaterSecond(); //validaterSecond;
		this.assigned = m.getAssigned(); //assigned;
		this.subcontracted = m.getSubcontracted(); //subcontracted;
	}
	
	public PersonDigitalCenters(Integer codEmployed, String name, String linkCV, String technologyComunity, Double rate,
			String rol, String center, String profile, String drefyfusLevel, String office, boolean scholar,
			String admisionDate, String outputDate, String outputPreviewDate, String validaterMain,
			String validaterSecond, String assigned, String subcontracted) {
		this.codEmployed = codEmployed;
		this.name = name;
		this.linkCV = linkCV;
		this.technologyComunity = technologyComunity;
		this.rate = rate;
		this.rol = rol;
		this.center = center;
		this.profile = profile;
		this.drefyfusLevel = drefyfusLevel;
		this.office = office;
		this.scholar = scholar;
		this.admisionDate = admisionDate;
		this.outputDate = outputDate;
		this.outputPreviewDate = outputPreviewDate;
		this.validaterMain = validaterMain;
		this.validaterSecond = validaterSecond;
		this.assigned = assigned;
		this.subcontracted = subcontracted;
	}

	@Override
	public int hashCode() {
		return Objects.hash(admisionDate, assigned, center, codEmployed, drefyfusLevel, linkCV, name, office,
				outputDate, outputPreviewDate, profile, rate, rol, scholar, subcontracted, technologyComunity,
				validaterMain, validaterSecond);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PersonDigitalCenters)) {
			return false;
		}
		PersonDigitalCenters other = (PersonDigitalCenters) obj;
		return Objects.equals(admisionDate, other.admisionDate) && Objects.equals(assigned, other.assigned)
				&& Objects.equals(center, other.center) && Objects.equals(codEmployed, other.codEmployed)
				&& Objects.equals(drefyfusLevel, other.drefyfusLevel) && Objects.equals(linkCV, other.linkCV)
				&& Objects.equals(name, other.name) && Objects.equals(office, other.office)
				&& Objects.equals(outputDate, other.outputDate)
				&& Objects.equals(outputPreviewDate, other.outputPreviewDate) && Objects.equals(profile, other.profile)
				&& Objects.equals(rate, other.rate) && Objects.equals(rol, other.rol) && scholar == other.scholar
				&& Objects.equals(subcontracted, other.subcontracted)
				&& Objects.equals(technologyComunity, other.technologyComunity)
				&& Objects.equals(validaterMain, other.validaterMain)
				&& Objects.equals(validaterSecond, other.validaterSecond);
	}
	
	
	
	@Override
	public String toString() {
		return "PersonDigitalCenters [codEmployed=" + codEmployed + ", name=" + name + ", linkCV=" + linkCV
				+ ", technologyComunity=" + technologyComunity + ", rate=" + rate + ", rol=" + rol + ", center="
				+ center + ", profile=" + profile + ", drefyfusLevel=" + drefyfusLevel + ", office=" + office
				+ ", scholar=" + scholar + ", admisionDate=" + admisionDate + ", outputDate=" + outputDate
				+ ", outputPreviewDate=" + outputPreviewDate + ", validaterMain=" + validaterMain + ", validaterSecond="
				+ validaterSecond + ", assigned=" + assigned + ", subcontracted=" + subcontracted + "]";
	}


	

	/* Getters && Setters*/
	public Integer getCodEmployed() {
		return codEmployed;
	}

	public void setCodEmployed(Integer codEmployed) {
		this.codEmployed = codEmployed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLinkCV() {
		return linkCV;
	}

	public void setLinkCV(String linkCV) {
		this.linkCV = linkCV;
	}

	public String getTechnologyComunity() {
		return technologyComunity;
	}

	public void setTechnologyComunity(String technologyComunity) {
		this.technologyComunity = technologyComunity;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getDrefyfusLevel() {
		return drefyfusLevel;
	}

	public void setDrefyfusLevel(String drefyfusLevel) {
		this.drefyfusLevel = drefyfusLevel;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public boolean isScholar() {
		return scholar;
	}

	public void setScholar(boolean scholar) {
		this.scholar = scholar;
	}

	public String getAdmisionDate() {
		return admisionDate;
	}

	public void setAdmisionDate(String admisionDate) {
		this.admisionDate = admisionDate;
	}

	public String getValidaterMain() {
		return validaterMain;
	}

	public void setValidaterMain(String validaterMain) {
		this.validaterMain = validaterMain;
	}

	public String getValidaterSecond() {
		return validaterSecond;
	}

	public void setValidaterSecond(String validaterSecond) {
		this.validaterSecond = validaterSecond;
	}

	public String getAssigned() {
		return assigned;
	}

	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}

	public String getSubcontracted() {
		return subcontracted;
	}

	public void setSubcontracted(String subcontracted) {
		this.subcontracted = subcontracted;
	}


	public String getCenter() {
		return center;
	}


	public void setCenter(String center) {
		this.center = center;
	}


	public String getProfile() {
		return profile;
	}


	public void setProfile(String profile) {
		this.profile = profile;
	}


	public String getOutputPreviewDate() {
		return outputPreviewDate;
	}


	public void setOutputPreviewDate(String outputPreviewDate) {
		this.outputPreviewDate = outputPreviewDate;
	}

	public String getOutputDate() {
		return outputDate;
	}

	public void setOutputDate(String outputDate) {
		this.outputDate = outputDate;
	}
	
}
