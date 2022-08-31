package babel.compares.back.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import babel.compares.back.constants.Constants;
import babel.compares.back.dao.CommunityComparativesFuntions;
import babel.compares.back.dao.GFunctions;
import babel.compares.back.dao.IOperacionsDigitalCenter;
import babel.compares.back.dao.IOperacionsMemberCommunity;
import babel.compares.back.dao.ImpOperationsMemberManagerComunity;
import babel.compares.back.dao.ImpOperationsMemberPublic;
import babel.compares.back.dao.ImpOperationsPersonDigitalCenter;
import babel.compares.back.dto.MemberCommunityManager;
import babel.compares.back.dto.MemberCommunityPublic;
import babel.compares.back.dto.PersonDigitalCenters;

/**
 * Comparar la excel de la comunidad pública con la excel de responsables,
 * comparando: - Exceso o ausencia de miembros de la comunidad - Discrepancias
 * en proyecto actual, perfil, rol y nivel dreyfus, tecnologÃ­as o
 * certificaciones
 *
 * @author andres.rpenuela
 *
 */
public class CompareOne {

	private static IOperacionsMemberCommunity daoManagerComunity = new ImpOperationsMemberManagerComunity();
	private static IOperacionsMemberCommunity daoManagerPublic = new ImpOperationsMemberPublic();
	private static IOperacionsDigitalCenter daoPeopleDigitalCenter = new ImpOperationsPersonDigitalCenter();

	private static Map<Integer, MemberCommunityManager> mapMemberComunityManager = null;
	private static Map<Integer, MemberCommunityPublic> mapMemberComunityPublic = null;
	private static Map<Integer, PersonDigitalCenters> mapPersonDigitalCenter = null;

	private static List<Object> l1 = null, l2 = null;
	private static List<Integer> employedCodenotFindInL1 = new ArrayList<Integer>(),
			employedCodenotFindInL2 = new ArrayList<Integer>();
	private static List<String> head = null;
	private static String filterByComunity = "";

	public static void main(String[] args) {

		try {
			// Let's read one doc (Leemos el documento 1)
			System.out.println(
					"\n*********************************************************************************************************************");
			System.out.println("Leyendo excel de la comunidad de responsables");
			System.out.println(
					"*********************************************************************************************************************");
			head = Constants.HEADERSMEMBERSCOMUNITYMANAGER;

			/*
			 * head= Arrays.asList( "name", "office", "category", "rol", "level", "rate",
			 * "scholar,","evaluation","codeProject", "project", "responsable",
			 * "technology", "certificiation","progressComment","admisionDate","formation",
			 * "formationTargetTime","low","field1","field2","field3","field4","evaluator",
			 * "officialEvalution",
			 * "calledToMeeting","meetingTime","teamsGroupCorrelation");
			 */
			
			// head = Arrays.asList("codEmployed", "name", "office", "category", "rol",
			// "level", "rate", "scholar");
			mapMemberComunityManager = (Map) daoManagerComunity.readDoc(head);
			// System.out.println(mapMemberComunityManager);

			// l1 = daoManagerComunity.MapToList(head);
			// System.out.println(daoManagerComunity.getListName());

			// Let's read two doc (Leemos el documento 2)
			System.out.println(
					"\n*********************************************************************************************************************");
			System.out.println("Leyendo excel de la comunidad publica");
			System.out.println(
					"*********************************************************************************************************************");
			head = Constants.HEADERSMEMBERSCOMUNITYPUBLIC;
			mapMemberComunityPublic = (Map) daoManagerPublic.readDoc(head);
			// System.out.println(mapMemberComunityPublic);
			// Let's go to compared the docs by employed code = key (Vamos a comparar los
			// documentos por código de empelado = key)
			// Map<Integer,Object> mapNameComunity =
			// listMC.stream().collect(Collectors.toMap(MemberCommunity::getCodEmployed,
			// l->new MemberCommunity(l)));
			// Map<Integer,Object> mapNamePersonalDigitalCenter =
			// listPDC.stream().collect(Collectors.toMap(PersonDigitalCenters::getCodEmployed,
			// l->new PersonDigitalCenters(l)));

			// Let's get copy of the key/employedcode of the doc1 and doc2 (Obtenemos una
			// copia de la clave/código empleado del doc1 y doc2)
			// l1 = new ArrayList<Object>(daoManagerComunity.getListKey());
			// l2 = new ArrayList<Object>(daoManagerPublic.getListKey());

			// Let's compare the key/employed code of the DOC1 (ComunityTeams (1).xls)
			// "excel of managers" with the DOC2 (Miembros de la comunidad.xlsx) "excel
			// public", so result we get a list with the key/employed code what it is
			// present in the DOC2 but it hasn't found in DOC1
			// (Comparamos la calve/codigo de empelado del DOC1 (ComunityTeams (1).xls)
			// "excel de responsables" con el DOC2 (Miembros de la comunidad.xlsx "excel
			// público", commo resultado obtenemos una lista con las claves/codigos emelas
			// que está en el DOC2 pero no se han econtrado en el DOC1
			employedCodenotFindInL1 = GFunctions.notContainsL2inL1((List) daoManagerComunity.getListKey(),
					(List) daoManagerPublic.getListKey());

			// Let's compare the key/employed code of the DOC2 (Miembros de la
			// comunidad.xlsx) "excel public" with the DOC1 (ComunityTeams (1).xls) "excel
			// of managers", so result we get a list with the key/employed code what it is
			// present in the DOC1 but it hasn't found in DOC2
			// (Comparamos la calve/codigo de empelado del DOC2 (Miembros de la
			// comunidad.xlsx) "excel público" con el DOC1 (ComunityTeams (1).xls) "excel de
			// responsables", commo resultado obtenemos una lista con las claves/codigos
			// emelas que está en el DOC1 pero no se han econtrado en el DOC2
			employedCodenotFindInL2 = GFunctions.notContainsL2inL1((List) daoManagerPublic.getListKey(),
					(List) daoManagerComunity.getListKey());

			// Is found the members have disappeared (Se descubre a los miembros
			// desaparecidos)
			findToDisappeared();

			// Mibemros en DOC1 y en DOC2 de otra tiene otra comunidad
			// TODO FALTA
			findDisappearedInOtherCommunity();

			// Defferences of the fields for same member in both documents (Deferencias de
			// los campos para el mismo miembro en ambos documentos)
			// Get the commons members in bot documents, matching by employed code (Obtiene
			// los miembros comúnes en ambos documentos, coindecniada por codigo de
			// empelado)
			List<Integer> employedsCodesInBothsDoc = GFunctions.getEmployedsCotiansInBothsLists(
					(List) daoManagerComunity.getListKey(), (List) daoManagerPublic.getListKey());
			// System.out.println(employedsCodesInBothsDoc);
			l1 = daoManagerComunity.getListMemberByEmployedCode(employedsCodesInBothsDoc);
			l2 = daoManagerPublic.getListMemberByEmployedCode(employedsCodesInBothsDoc);
			compareMemberComunitManacherAndPublic(l1, l2);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(mapMemberComunityManager);

	}

	private static void findDisappearedInOtherCommunity() {
		String readCommunity;
		// TODO Auto-generated method stub
		System.out.println(
				"\n*********************************************************************************************************************");
		System.out.println("Buscando miembros en otras comunidad");
		System.out.println(
				"*********************************************************************************************************************");
		// Getting the list of member of the people document

		// Getting the list of member community total (members community of managers doc
		// more members not found or member community of public doc more member not
		// found)
		// Obtiene la lista de miembros de comunidad total (miembros comunitoda de
		// responables mas miembros no encontrados o miembros de comunidad publica mas
		// miembros no encontrados)
		List<PersonDigitalCenters> listPersonDigtialCenter = new ArrayList<PersonDigitalCenters>();

		try {
			// head = Constants.HEADERSLISTPERSONDIGITALCENTERS;
			head = Arrays.asList("codEmployed", "name", "technologyComunity");
			//readCommunity = Constants.TYPETECNHOLOGY.get(3); // Desarrollo Back
			// readCommunity=Constants.TYPETECNHOLOGY.get(Constants.TYPETECNHOLOGY.size()-1);//all people with technology
			readCommunity = Constants.TYPETECNHOLOGY.get(Constants.TYPETECNHOLOGY.size() - 2);// all people with and
																								// without
																								// technology

			//Step 1 Reading all people (with and without community) of the document Person Digital Center
			//(Lee todas las persoNAS (con y sin comunidad) del documento "Person Digital Center"
			mapPersonDigitalCenter = (Map) daoPeopleDigitalCenter.readDoc(head, readCommunity);
			
			System.out.println("\n (Step 1) Answer we get when we end of readed the document of  People Center Digital:");
			System.out.println("\t- Poeple of the community \"" + readCommunity + "\" read: " + mapPersonDigitalCenter.size());
			System.out.println("\t- Are there duplicates?: "+daoPeopleDigitalCenter.thereAreDuplicates());
			if(daoPeopleDigitalCenter.getListPersonDigitalDuplicate().size()!=0) {
				System.out.println("("+daoPeopleDigitalCenter.getListPersonDigitalDuplicate().size()+") people duplicates, value = ");
				daoPeopleDigitalCenter.getListPersonDigitalDuplicate().forEach(System.out::println);
			}
			System.out.println("\t- Are there people without code?: "+daoPeopleDigitalCenter.thereArePersonWithOutEmpledCode());
			if(daoPeopleDigitalCenter.getListPersonDigitalWithOutEmpledCode().size()!=0) {
				System.out.println("("+daoPeopleDigitalCenter.getListPersonDigitalWithOutEmpledCode().size()+") people without employed code, value = ");
				daoPeopleDigitalCenter.getListPersonDigitalWithOutEmpledCode().forEach(System.out::println);
			}
			
			//(Step 2) Get the people of the Back community who it has been read at step 1
			//(Obtener las personas de la comunidad back que se han leido en el paso 1
			System.out.println("\n (Step 2) Get the people of the Back community who it has been read at step 1:");
			filterByComunity = Constants.TYPETECNHOLOGY.get(3); // Desarrollo Back
			Map<Integer, String> mapPersonDigitalCenterBack = daoPeopleDigitalCenter.getMapPersonDigitalByTechnology(filterByComunity);
			System.out.println("\t - Member of Comunity in Manager Doc "+mapMemberComunityManager.size());
			System.out.println("\t - Member of Comunity in Public Doc "+mapMemberComunityPublic.size());
			System.out.println("\t - People of the community in \"" + filterByComunity + "\": " + mapPersonDigitalCenterBack.size());
			
			
			//(Step 3) Look for member of comunity is in Person Digtial Center for a community specified and what member is other community or isn't in Person digital center Doc and who Person isn't in Member Manager/Public Doc 
			//(Busque un miembro de la comunidad que esté en el Centro De Dignidad de Persona para una comunidad especificada y qué miembro es otra comunidad o no está en persona centro digital Doc y quién Persona no está en  el Documento de Miembros de la Comunidad Responsables/público)
			List<PersonDigitalCenters> lMemberCommunityManagerInPersonDigitalCenterLikeBack =  new ArrayList<PersonDigitalCenters>(); 
			List<PersonDigitalCenters> lMemberCommunityManagerInPersonDigitalCenterOtherCommunity = new ArrayList<PersonDigitalCenters>(); 
			List<PersonDigitalCenters> lPersonDigitalCenterOutMemberComunityManager =  new ArrayList<PersonDigitalCenters>();
			List<MemberCommunityManager> lMemberCommunityManagerOutPersonDigitalCenter = new ArrayList<MemberCommunityManager>();
			List<PersonDigitalCenters> lPersonDigitalCenterWithOutCommunity =  new ArrayList<PersonDigitalCenters>();
			
			CommunityComparativesFuntions.comparativeCommunityWichPerson( (Map) mapPersonDigitalCenter,
					(Map) mapMemberComunityManager,
					lMemberCommunityManagerInPersonDigitalCenterLikeBack,
					lMemberCommunityManagerInPersonDigitalCenterOtherCommunity,
					lPersonDigitalCenterOutMemberComunityManager, 
					(List) lMemberCommunityManagerOutPersonDigitalCenter,
					lPersonDigitalCenterWithOutCommunity,
					filterByComunity);
					
			System.out.println("\n (Step 3.1) Comparative of Memeber of Community of Manager Doc with Personal Digital Center:");
			GFunctions.showExcessInsufficent(lMemberCommunityManagerInPersonDigitalCenterLikeBack,
					lMemberCommunityManagerInPersonDigitalCenterOtherCommunity,
					lPersonDigitalCenterOutMemberComunityManager, 
					(List) lMemberCommunityManagerOutPersonDigitalCenter,
					lPersonDigitalCenterWithOutCommunity,
					filterByComunity);
			
			//CommunityComparativesFuntions.comparativeCommunityWichPerson(null, null, lMemberCommunityManagerInPersonDigitalCenterLikeBack, lMemberCommunityManagerInPersonDigitalCenterOtherCommunity, lPersonDigitalCenterOutMemberComunityManager, lMemberCommunityManagerOutPersonDigitalCenter, lPersonDigitalCenterWithOutCommunity);
			List<PersonDigitalCenters> lMemberCommunityPublicInPersonDigitalCenterLikeBack =  new ArrayList<PersonDigitalCenters>(); 
			List<PersonDigitalCenters> lMemberCommunityPublicInPersonDigitalCenterOtherCommunity = new ArrayList<PersonDigitalCenters>(); 
			List<PersonDigitalCenters> lPersonDigitalCenterOutMemberComunityPublic =  new ArrayList<PersonDigitalCenters>();
			List<MemberCommunityPublic> lMemberCommunityPublicOutPersonDigitalCenter = new ArrayList<MemberCommunityPublic>();
			lPersonDigitalCenterWithOutCommunity =  new ArrayList<PersonDigitalCenters>();
			CommunityComparativesFuntions.comparativeCommunityWichPerson( (Map) mapPersonDigitalCenter,
					(Map)  mapMemberComunityPublic,
					lMemberCommunityPublicInPersonDigitalCenterLikeBack,
					lMemberCommunityPublicInPersonDigitalCenterOtherCommunity,
					lPersonDigitalCenterOutMemberComunityPublic, 
					(List) lMemberCommunityPublicOutPersonDigitalCenter,
					lPersonDigitalCenterWithOutCommunity,
					filterByComunity);
			
			System.out.println("\n (Step 3.2) Comparative of Memebers of Public Doc  with Personal Digital Center:");
			GFunctions.showExcessInsufficent(lMemberCommunityPublicInPersonDigitalCenterLikeBack, //Miembros y Person como Back en abmos doc
					lMemberCommunityPublicInPersonDigitalCenterOtherCommunity, //Miembros Back en otra comunidad en Person
					lPersonDigitalCenterOutMemberComunityPublic, //Personas back no encontradas en el documento de Miembros 
					(List) lMemberCommunityPublicOutPersonDigitalCenter,//Miembros no encontrados en el doc de Person
					lPersonDigitalCenterWithOutCommunity,//Personas sin comunidad
					filterByComunity);
			//---
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void compareMemberComunitManacherAndPublic(List<Object> l1, List<Object> l2) throws Exception {
		Scanner sc = new Scanner(System.in);
		short option = 0;

		System.out.println(
				"\n*********************************************************************************************************************");
		System.out.println("Buscando discrepancias entre los miembros comunes de ambos documentos");
		System.out.println(
				"*********************************************************************************************************************");
		System.out.println("(" + l1.size() + ") miembros, MemberCommunityManager: \n" + l1);
		System.out.println("(" + l2.size() + ") miembros, MemberCommunityPublic: \n" + l2);

		do {
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------");
			System.out.print("Deteccion de discrepancias:"
					+ "\n\t1- Comprobar todos los campos comunes en ambos documentos." + "\n\t2- Comprobar el nombre."
					+ "\n\t3- Comprobar oficina." + "\n\t4- Comparar categoria." + "\n\t5- Comparar rol."
					+ "\n\t6- Comparar nivel de dreyfus." + "\n\t7- Comparar codigo de proyecto."
					+ "\n\t8- Comparar proyecto." + "\n\t10- Comparar responsable." + "\n\t11- Comparar tecnología."
					+ "\n\t12- Comparar certificacion." + "\n\t13- Comparar baja."
					+ "\n\t14- Identificar que campos tienen diferencias."
					+ "\n\t15- Obtener miembros duplicados. "
					+ "\n\t16- Obtener miembros sin codigo de empleado."
					+"\n\topcion (0- salir): ");
			try {
				option = sc.nextShort();

				switch (option) {
				case 1:
					// Compare all commons fields
					CommunityComparativesFuntions.comparativeMemberComunitinyAllFields(l1, l2);
					break;
				case 2:
					// Compare all name fields
					CommunityComparativesFuntions.comparativeMemberComunitinyByName(l1, l2);
					break;
				case 3:
					// Compare all office fields
					CommunityComparativesFuntions.comparativeMemberComunitinyByOffice(l1, l2);
					break;
				case 4:
					// Compare all category fields
					CommunityComparativesFuntions.comparativeMemberComunitinyByCategory(l1, l2);
					break;
				case 5:
					// Compare all rol field
					CommunityComparativesFuntions.comparativeMemberComunitinyByRol(l1, l2);

					break;
				case 6:
					// Compare all level dreyfus field
					CommunityComparativesFuntions.comparativeMemberComunitinyByLevel(l1, l2);
					break;
				case 7:
					// Compare all CodeProject field
					CommunityComparativesFuntions.comparativeMemberComunitinyByCodeProject(l1, l2);
					break;
				case 8:
					// Compare all Project field
					CommunityComparativesFuntions.comparativeMemberComunitinyByProject(l1, l2);
					break;
				case 10:
					// Compare all Technology d field
					CommunityComparativesFuntions.comparativeMemberComunitinyByResponsable(l1, l2);
					break;
				case 11:
					// Compare all Technology d field
					CommunityComparativesFuntions.comparativeMemberComunitinyByTechnology(l1, l2);
					break;
				case 12:
					// Compare all Certification Certification field
					CommunityComparativesFuntions.comparativeMemberComunitinyByCertification(l1, l2);
					break;
				case 13:
					// Compare all Low d field
					CommunityComparativesFuntions.comparativeMemberComunitinyByLow(l1, l2);
					break;
				case 14:
					// Identify which field is different in both documents for a same member
					CommunityComparativesFuntions.identifierFieldDifferences(l1, l2);
					break;
				case 15:
					// Get member duplicates
					System.out.println("Manager Doc>> "+daoManagerComunity.getListMemberDuplicate().size()+" duplicates. \n"+daoManagerComunity.getListMemberDuplicate());
					System.out.println("Public Doc>> "+daoManagerPublic.getListMemberDuplicate().size()+" duplicates. \n"+daoManagerPublic.getListMemberDuplicate());
					break;
				case 16:
					// Get member without employed code
					System.out.println("Manager Doc>> "+daoManagerComunity.getListMemberWithOutEmpledCode().size()+" without employed code. \n"+daoManagerComunity.getListMemberWithOutEmpledCode());
					System.out.println("Public Doc>> "+daoManagerPublic.getListMemberWithOutEmpledCode().size()+" without employed code. \n"+daoManagerPublic.getListMemberWithOutEmpledCode());
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println(e);
				option = (short) 99;
				sc.nextLine();
			}

		} while (option != 0);
	}

	public static void findToDisappeared() throws Exception {
		System.out.println(
				"*********************************************************************************************************************");
		System.out.println("Resultado de buscar el código de empleado de ambos documentos");
		System.out.println(
				"*********************************************************************************************************************");
		System.out.println(
				"Resultado 1: Lista de codigo de emepelados que no aparecen en ComunityTeams (1).xls (excel de responsables) pero si en Miembros de la Comunidad.xlsx (excel publico)");
		System.out.println(employedCodenotFindInL1);
		System.out.println(
				"Resultado 2: Lista de codigo de emepelados que no aparecen en Miembros de la Comunidad.xlsx (excel publico)) pero si en Miembros de la ComunityTeams (1).xls (excel de responsables)");
		System.out.println(employedCodenotFindInL2);

		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"Datos de miembros que no aparecen en ComunityTeams (1).xls (pero esta en Miembros de la Comunidad.xlsx) ");
		// System.out.println(daoManagerComunity.getMemberByEmployedCode(employedCodenotFindInL2.get(0)));
		System.out.println(daoManagerPublic.getListMemberByEmployedCode(employedCodenotFindInL1));

		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"Datos de miembros que no aparecen en Miembros de la Comunidad.xlsx (pero esta en ComunityTeams (1).xls)");
		// System.out.println(daoManagerPublic.getMemberByEmployedCode(employedCodenotFindInL1.get(0)));
		System.out.println(daoManagerComunity.getListMemberByEmployedCode(employedCodenotFindInL2));
	}
}
