package babel.compares.back.dto;

import java.util.List;
import java.util.Objects;

public class MemberCommunityManager extends MemberCommunity implements Comparable<Object> {
	// Employed Code (Código dej empleado)
	//private Integer codEmployed;
	// Employed Name (Nombre del empleado)
	//private String name;
	// Employed Office (Oficina del empleado)
	//private String office;
	// Employed Category(Categoría del empleado)
	//private String category;
	// Main Rol (Rol principal)
	//private String rol;
	// Level D (Nivel D)
	//private String level;
	// Reate (Tarifa)
	private double rate;
	// Scholar (Escolar/Becario)
	private boolean scholar;
	// Evaluation (Evalcuión)
	private String evaluation;
	// Project Code (Código del proyecto)
	//private List<String> codeProject;
	// Project (Proyecto)
	//private List<String> project;
	// Manager (Responsable)
	//private List<String> responsable;
	// Tecnology/Ability (Tenología/Habilidad)
	//private List<String> technology;
	// Certificiacion (Certificacion)
	//private List<String> certification;
	// Progress Comment (Comentario de progreso)
	private String progressComment;
	// Admision time (Fecha de admision/ingreso)
	private String admisionDate;
	// Formation (Formación)
	private List<String> formation;
	// Formation targe timet (Fecha objetivo formación)
	private String formationTargetTime;
	// Low (Baja)
	//private boolean low;
	// Field1 (Campo 1)
	private String field1;
	// Field2 (Campo 2)
	private String field2;
	// Field1 (Campo 3)
	private String field3;
	// Field2 (Campo 4)
	private String field4;
	// Evaluatro (Evaluador)
	private String evaluator;
	// Official meeting (Evaluador)
	private boolean officialEvalution;
	// Called to meeting (Convocado)
	private boolean calledToMeeting;
	// Teams Group Correlation (Correlión grupo teams)
	private String teamsGroupCorrelation;

	// Constructors
	public MemberCommunityManager() {
		super();
	}

	public MemberCommunityManager(MemberCommunityManager m) {
		super(m);
		
		//this.codEmployed = m.getCodEmployed();
		//this.name = m.getName();
		//this.office = m.getOffice();
		//this.category = m.getCategory();
		//this.rol = m.getRol();
		//this.level = m.getLevel();
		this.rate = m.getRate();
		this.scholar = m.isScholar();
		this.evaluation = m.getEvaluation();
		//this.codeProject = m.getCodeProject();
		//this.project = m.getProject();
		//this.responsable = m.getResponsable();
		//this.technology = m.getTechnology();
		//this.certification = m.getCertification();
		this.progressComment = m.getProgressComment();
		this.admisionDate = m.getAdmisionDate();
		this.formation = m.getFormation();
		this.formationTargetTime = m.getFormationTargetTime();
		//this.low = m.isLow();
		this.field1 = m.getField1();
		this.field2 = m.getField2();
		this.field3 = m.getField3();
		this.field4 = m.getField4();
		this.evaluator = m.getEvaluator();
		this.officialEvalution = m.isOfficialEvalution();
		this.calledToMeeting = m.isCalledToMeeting();
		this.teamsGroupCorrelation = m.getTeamsGroupCorrelation();
	}

	public MemberCommunityManager(Integer codEmployed, String name, String office, String category, String rol,
			String level, double rate, boolean scholar, String evaluation, List<String> codeProject,
			List<String> project, List<String> responsable, List<String> technology, List<String> certification,
			String progressComment, String admisionDate, List<String> formation, String formationTargetTime,
			boolean low, String field1, String field2, String field3, String field4, String evaluator,
			boolean officialEvalution, boolean calledToMeeting, String teamsGroupCorrelation) {
		super(codEmployed, name, office, category, rol, level,
				codeProject, project, responsable, technology,
				certification,  low);
		//this.codEmployed = codEmployed;
		//this.name = name;
		//this.office = office;
		//this.category = category;
		//this.rol = rol;
		//this.level = level;
		this.rate = rate;
		this.scholar = scholar;
		this.evaluation = evaluation;
		//this.codeProject = codeProject;
		//this.project = project;
		//this.responsable = responsable;
		//this.technology = technology;
		//this.certification = certification;
		this.progressComment = progressComment;
		this.admisionDate = admisionDate;
		this.formation = formation;
		this.formationTargetTime = formationTargetTime;
		//this.low = low;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.evaluator = evaluator;
		this.officialEvalution = officialEvalution;
		this.calledToMeeting = calledToMeeting;
		this.teamsGroupCorrelation = teamsGroupCorrelation;
	}

	@Override
	public String toString() {
		return "MemberCommunityManager [" + super.toString() + "rate=" + +rate + ", scholar=" + scholar + ", evaluation=" + evaluation
				+ ", progressComment=" + progressComment + ", admisionDate=" + admisionDate + ", formation=" + formation
				+ ", formationTargetTime=" + formationTargetTime + ", field1=" + field1 + ", field2=" + field2
				+ ", field3=" + field3 + ", field4=" + field4 + ", evaluator=" + evaluator + ", officialEvalution="
				+ officialEvalution + ", calledToMeeting=" + calledToMeeting + ", teamsGroupCorrelation="
				+ teamsGroupCorrelation + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(admisionDate, calledToMeeting, evaluation, evaluator, field1, field2,
				field3, field4, formation, formationTargetTime, officialEvalution, progressComment, rate, scholar,
				teamsGroupCorrelation);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		//mismo objeto?
		if (this == obj) {//Si
			return true;
		}
		
		//Objeto de la clase MemberCommunityPublic?
		if (obj instanceof MemberCommunityPublic) {//Si
			//Campos comunes iguales?
			if (super.equals(obj)) {//Si
				return true;
			}
		}
		
		//Objeto de la clase PersonDigitalCenters?
		//fields: nº empleado, nombre, oficina, comunidad tecnologíaca (categoria), rol, nivel,tarifa, becario, f. incorporacion
		if(obj instanceof PersonDigitalCenters) {//Si
			PersonDigitalCenters other = (PersonDigitalCenters) obj;
			return Objects.equals(admisionDate, other.getAdmisionDate())
					&& Objects.equals(getCodEmployed(), other.getCodEmployed()) && Objects.equals(getName(), other.getName())
					&& Objects.equals(getOffice(), other.getOffice()) && Objects.equals(getCategory(), other.getTechnologyComunity())
					&& Objects.equals(getRol(), other.getRol()) && Objects.equals(getLevel(), other.getDrefyfusLevel())
					&& Double.doubleToLongBits(rate) == Double.doubleToLongBits(other.getRate()) && scholar == other.isScholar();
		}
		//Objecto de la misma clase?
		if (obj instanceof MemberCommunityManager) {//Si
			//Campos coamunes diferentes?
			if (!super.equals(obj)) {//Si
				return false;
			}else {//No, son iguales, ¿campos especificoas de la case iguales? Si->True, No->False
				MemberCommunityManager other = (MemberCommunityManager) obj;
				return Objects.equals(admisionDate, other.admisionDate) && calledToMeeting == other.calledToMeeting
						&& Objects.equals(evaluation, other.evaluation) && Objects.equals(evaluator, other.evaluator)
						&& Objects.equals(field1, other.field1) && Objects.equals(field2, other.field2)
						&& Objects.equals(field3, other.field3) && Objects.equals(field4, other.field4)
						&& Objects.equals(formation, other.formation)
						&& Objects.equals(formationTargetTime, other.formationTargetTime)
						&& officialEvalution == other.officialEvalution
						&& Objects.equals(progressComment, other.progressComment)
						&& Double.doubleToLongBits(rate) == Double.doubleToLongBits(other.rate) && scholar == other.scholar
						&& Objects.equals(teamsGroupCorrelation, other.teamsGroupCorrelation);
			}
		}
		
		//Resto de casos -> False
		return false;
	}

	// Methods Getters && Setters
	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public boolean isScholar() {
		return scholar;
	}

	public void setScholar(boolean scholar) {
		this.scholar = scholar;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public String getProgressComment() {
		return progressComment;
	}

	public void setProgressComment(String progressComment) {
		this.progressComment = progressComment;
	}

	public String getAdmisionDate() {
		return admisionDate;
	}

	public void setAdmisionDate(String admisionDate) {
		this.admisionDate = admisionDate;
	}

	public List<String> getFormation() {
		return formation;
	}

	public void setFormation(List<String> formation) {
		this.formation = formation;
	}

	public String getFormationTargetTime() {
		return formationTargetTime;
	}

	public void setFormationTargetTime(String formationTargetTime) {
		this.formationTargetTime = formationTargetTime;
	}


	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

	public String getField4() {
		return field4;
	}

	public void setField4(String field4) {
		this.field4 = field4;
	}

	public String getEvaluator() {
		return evaluator;
	}

	public void setEvaluator(String evaluator) {
		this.evaluator = evaluator;
	}

	public boolean isOfficialEvalution() {
		return officialEvalution;
	}

	public void setOfficialEvalution(boolean officialEvalution) {
		this.officialEvalution = officialEvalution;
	}

	public boolean isCalledToMeeting() {
		return calledToMeeting;
	}

	public void setCalledToMeeting(boolean calledToMeeting) {
		this.calledToMeeting = calledToMeeting;
	}

	public String getTeamsGroupCorrelation() {
		return teamsGroupCorrelation;
	}

	public void setTeamsGroupCorrelation(String teamsGroupCorrelation) {
		this.teamsGroupCorrelation = teamsGroupCorrelation;
	}

	/*
	 * compareTo() method Compare the field "code emploeyed" of this class object
	 * (x) with other class specific objects (o) given as parameter. It returns the
	 * value: 0: if (x==o) -1: if (x < o) 1: if (x > o)
	 */
	@Override
	public int compareTo(Object o) {
		MemberCommunityManager otra = (MemberCommunityManager) o;
		return this.getCodEmployed().compareTo(otra.getCodEmployed());
	}

	//Casting MemberCommunityPublic to MemberCommunityManager, this method add only commons fields
	/*
	public void memberCommunityPublicToMemberComunityManager(MemberCommunityPublic m) {
		this.codEmployed = m.getCodEmployed();
		this.name = m.getName();
		this.office = m.getOffice();
		this.category = m.getCategory();
		this.rol = m.getRol();
		this.level = m.getLevel();
		this.codeProject = m.getCodeProject();
		this.project = m.getProject();
		this.responsable = m.getResponsable();
		this.technology = m.getTechnology();
		this.certification = m.getCertification();
		this.low = m.isLow();
	}
	*/
}
