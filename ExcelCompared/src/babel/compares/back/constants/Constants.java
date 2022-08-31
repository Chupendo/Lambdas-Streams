package babel.compares.back.constants;

import java.util.Arrays;
import java.util.List;

public final class Constants {

	/* ruta de los ficheros */
	
	/* Cabeceras: El orden de la cabecera determina el orden de recoleción de datos, por lo que es importante no variarlo */ 
	public static final List<String> HEADERSLISTMEMBERSTEAMS = Arrays.asList("nombre", "email", "puesto", "ubicacion");
	/*
	 public static final List<String> HEADERSLISTMEMBERSCOMUNITY = Arrays.asList("codEmployed", "name", "office",
			"category", "rol", "level", "codeProject", "project", "codResponsable", "responsable", "technology",
			"certificiation", "low");
	 */
	
	//HEAR MEMBERS COMUNITY PUBLIC
	public static final List<String> HEADERSMEMBERSCOMUNITYPUBLIC = Arrays.asList("codEmployed", "name", "office",
			"category", "rol", "level", "codeProject", "project", "codResponsable", "responsable", "technology",
			"certificiation", "low");
	
	//HEAR MEMBERS COMUNITY MANAGER
	public static final List<String> HEADERSMEMBERSCOMUNITYMANAGER = Arrays.asList("codEmployed", "name", "office",
			"category", "rol", "level", "rate", "scholar,","evaluation","codeProject", "project", "responsable", "technology",
			"certificiation","progressComment","admisionDate","formation","formationTargetTime","low","field1","field2","field3","field4","evaluator","officialEvalution",
			"calledToMeeting","meetingTime","teamsGroupCorrelation");
	
	//LIST OF FIELDS COMMONS IN THE DOCUMENTS OF MEMBERS COMUNITY
	public static final List<String> FIELDCOMMONMEMBERSCOMUNITY = Arrays.asList("codEmployed", "name", "office",
			"category", "rol", "level","codeProject", "project", "responsable", "technology",
			"certificiation","low");
	
	
	//LIST OF FIELDS COMMONS IN THE DOCUMENTS OF MEMBERS COMUNITY WITH PERSON DIGITAL CENTER
	/**
	 * HEADERSLISTPERSONDIGITALCENTERS
	 * Arrays.asList("name", "office","category", "rol", "level","rate", "admisiondate")
	 */
	public static final List<String> FIELDCOMMONMEMBERSCOMUNITYWITHPERSON = Arrays.asList("name", "office",
			"category", "rol", "level","rate", "admisiondate");
	
	//HEAR PERSON DIGITLA CENTER
	public static final List<String> HEADERSLISTPERSONDIGITALCENTERS = Arrays.asList("codEmployed","name", "linkCV", "technologyComunity",
			"rate", "center", "rol", "profile", "drefyfusLevel", "office", "scholar", "admisionDate", "outputDate", "outputPreviewDate","validaterMain", "validaterSecond",
			"assigned2021", "subcontracted");
	
	/*Others*/
	public static final List<String> TYPETECNHOLOGY = Arrays.asList("Administración Infraestructuras","Arquitectura","BABELCreativa",
		"Desarrollo Back","Desarrollo Front","Desarrollo Web & Content Solution Platforms","DPA","Gestión Centros","Liferay Camp","Microsoft",
		"Modernización & Legacy","Movilidad","Nivel 1 - Monitorización & Operación 24x7","Outsystems","QA","Servicios Cloud","all","SN");//Muy imporante el orden, "all" y "SN" siempbre al fina de la lista
}
