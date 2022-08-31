package configuration;

import java.util.Arrays;
import java.util.List;

public final class Constants {

	/* ruta de los ficheros */
	
	/* Cabeceras: El orden de la cabecera determina el orden de recoleción de datos, por lo que es importante no variarlo */ 
	public static final List<String> HEADERSLISTMEMBERSTEAMS = Arrays.asList("nombre", "email", "puesto", "ubicacion");
	public static final List<String> HEADERSLISTMEMBERSCOMUNITY = Arrays.asList("codEmployed", "name", "office",
			"category", "rol", "level", "codeProject", "project", "codResponsable", "responsable", "technology",
			"certificiation", "low");
	public static final List<String> HEADERSLISTPEOPLEDIGITALCENTERS = Arrays.asList("codEmployed","name", "linkCV", "technologyComunity",
			"rate", "center", "rol", "profile", "drefyfusLevel", "office", "scholar", "admisionDate", "outputDate", "outputPreviewDate","validaterMain", "validaterSecond",
			"assigned2021", "subcontracted");
	
	/*Others*/
	public static final List<String> TYPETECNHOLOGY = Arrays.asList("Administración Infraestructuras","Arquitectura","BABELCreativa",
		"Desarrollo Back","Desarrollo Front","Desarrollo Web & Content Solution Platforms","DPA","Gestión Centros","Liferay Camp","Microsoft",
		"Modernización & Legacy","Movilidad","Nivel 1 - Monitorización & Operación 24x7","Outsystems","QA","Servicios Cloud","SN");//Muy imporante el orden, "SN" siembre al fina de la lista
}
