package babel.compares.back.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import babel.compares.back.constants.Constants;
import babel.compares.back.dao.CommunityComparativesFuntions;
import babel.compares.back.dao.GFunctions;
import babel.compares.back.dao.IOperacionsDigitalCenter;
import babel.compares.back.dao.IOperacionsMemberCommunity;
import babel.compares.back.dao.ImpOperationsMemberManagerComunity;
import babel.compares.back.dao.ImpOperationsMemberPublic;
import babel.compares.back.dao.ImpOperationsPersonDigitalCenter;
import babel.compares.back.dao.PersonComparativesFuntions;
import babel.compares.back.dto.MemberCommunityManager;
import babel.compares.back.dto.MemberCommunityPublic;
import babel.compares.back.dto.PersonDigitalCenters;

/**
 * Comparar la excel de la comunidad de responsables con la excel de centros,
 * comparando: Exceso o ausencia de miembros de la comunidad Discrepancias en
 * oficina, perfil, rol y nivel dreyfus, tarifa
 * 
 * @author andres.rpenuela
 *
 */
public class CompareTwo {

	private static IOperacionsMemberCommunity daoMemberManagerComunity = new ImpOperationsMemberManagerComunity();
	private static IOperacionsMemberCommunity daoMemberPublicComunity = new ImpOperationsMemberPublic();
	private static IOperacionsDigitalCenter daoPeopleDigitalCenter = new ImpOperationsPersonDigitalCenter();
	
	private static Map<Integer, MemberCommunityManager> mapMemberComunityManager = null;
	private static Map<Integer, MemberCommunityPublic> mapMemberComunityPublic = null;
	private static Map<Integer, PersonDigitalCenters> mapPersonDigitalCenter = null;

	private static List<Object> lAux1 = null, lAux2 = null;
	private static List<Integer> employedCodenotFindInL1 = new ArrayList<Integer>(),
			employedCodenotFindInL2 = new ArrayList<Integer>();
	private static List<String> head = null, listNameSNotFoundInDoc1 = null, listNameSNotFoundInDoc2 = null;
	
	//MANAGER
	private static List<PersonDigitalCenters> lMemberCommunityManagerInPersonDigitalCenterLikeBack = null;
	private static List<PersonDigitalCenters> lMemberCommunityManagerInPersonDigitalCenterOtherCommunity = null;
	private static List<PersonDigitalCenters> lPersonDigitalCenterOutMemberComunityManager = null;
	private static List<MemberCommunityManager> lMemberCommunityManagerOutPersonDigitalCenter = null;
	//PUBLIC
	private static List<PersonDigitalCenters> lMemberCommunityPublicInPersonDigitalCenterLikeBack =  null; 
	private static List<PersonDigitalCenters> lMemberCommunityPublicInPersonDigitalCenterOtherCommunity = null;
	private static List<PersonDigitalCenters> lPersonDigitalCenterOutMemberComunityPublic =  null;
	private static List<MemberCommunityPublic> lMemberCommunityPublicOutPersonDigitalCenter = null;
	//MANAGER && PUBLIC
	private static List<PersonDigitalCenters> lPersonDigitalCenterWithOutCommunity = null;
	
	public static void main(String[] args) {

		try {
			System.out.println("*********************************************************");
			System.out.println("(Step 1) READ DOC'S");
			System.out.println("*********************************************************");
			//(Step 1) Read to all people in digital center doc
			//Se lee todas las personas en el documento de centro digital
			head = Constants.HEADERSLISTPERSONDIGITALCENTERS;
			mapPersonDigitalCenter = (Map) daoPeopleDigitalCenter.readDoc(head, "all");
			System.out.println("Person digital center Doc has "+mapPersonDigitalCenter.size()+" people, who:"
					+"\n\t- There are "+daoPeopleDigitalCenter.getListPersonDigitalDuplicate().size()+" peopole have the employed code duplicate"
					+"\n\t- There are "+daoPeopleDigitalCenter.getListPersonDigitalWithOutEmpledCode().size()+" poeples without employed code");
			
			//(Step 2) Read to all members are in comunity back of community manager doc
			//Se lee todas los miembros de la comunida backs del documento de responsables
			head = Constants.HEADERSMEMBERSCOMUNITYMANAGER;
			mapMemberComunityManager = (Map) daoMemberManagerComunity.readDoc(head);
			System.out.println("Member of Manager Community Doc has "+mapMemberComunityManager.size()+" members, who:"
					+"\n\t- There are "+daoMemberManagerComunity.getListMemberDuplicate().size()+" members have the employed code duplicate"
					+"\n\t- There are "+daoMemberManagerComunity.getListMemberWithOutEmpledCode().size()+" members without employed code");
				
		
			//(Step 3) Read to all members are in comunity back of community public doc
			//Se lee todas los miembros de la comunida backs del documento publico de la comunidad
			head = Constants.HEADERSMEMBERSCOMUNITYPUBLIC;
			mapMemberComunityPublic = (Map) daoMemberPublicComunity.readDoc(head);
			System.out.println("Member of Public Community Doc has "+mapMemberComunityPublic.size()+" members, who:"
					+"\n\t- There are "+daoMemberPublicComunity.getListMemberDuplicate().size()+" members have the employed code duplicate"
					+"\n\t- There are "+daoMemberPublicComunity.getListMemberWithOutEmpledCode().size()+" members without employed code");
			
			
			System.out.println("*********************************************************");
			System.out.println("(Step 2) PERSON DIGITAL CENTER IN BACK");
			System.out.println("*********************************************************");
			String filterByComunity = Constants.TYPETECNHOLOGY.get(3); // Desarrollo Back
			showPersonCommunity(filterByComunity);
			
			// Exceso o ausencia de miembros
			System.out.println("*********************************************************");
			System.out.println("(Step 3) COMPARE MEMBER OF MANAGER COMMUNITY DOC WITH PERSON DIGITAL CENTER FOR BACK COMMUNITY");
			System.out.println("*********************************************************");
			lMemberCommunityManagerInPersonDigitalCenterLikeBack =  new ArrayList<PersonDigitalCenters>(); 
			lMemberCommunityManagerInPersonDigitalCenterOtherCommunity = new ArrayList<PersonDigitalCenters>(); 
			lPersonDigitalCenterOutMemberComunityManager =  new ArrayList<PersonDigitalCenters>();
			lMemberCommunityManagerOutPersonDigitalCenter = new ArrayList<MemberCommunityManager>();
			lPersonDigitalCenterWithOutCommunity =  new ArrayList<PersonDigitalCenters>();
			
			CommunityComparativesFuntions.comparativeCommunityWichPerson( (Map) mapPersonDigitalCenter,
					(Map) mapMemberComunityManager,
					lMemberCommunityManagerInPersonDigitalCenterLikeBack,
					lMemberCommunityManagerInPersonDigitalCenterOtherCommunity,
					lPersonDigitalCenterOutMemberComunityManager, 
					(List) lMemberCommunityManagerOutPersonDigitalCenter,
					lPersonDigitalCenterWithOutCommunity,
					filterByComunity);
			GFunctions.showExcessInsufficent(lMemberCommunityManagerInPersonDigitalCenterLikeBack,
					lMemberCommunityManagerInPersonDigitalCenterOtherCommunity,
					lPersonDigitalCenterOutMemberComunityManager, 
					(List) lMemberCommunityManagerOutPersonDigitalCenter,
					lPersonDigitalCenterWithOutCommunity,
					filterByComunity);
			
			// Exceso o ausencia de miembros
			System.out.println("*********************************************************");
			System.out.println("(Step 4) COMPARE MEMBER OF PUBLIC COMMUNITY DOC WITH PERSON DIGITAL CENTER FOR BACK COMMUNITY");
			System.out.println("*********************************************************");
			lMemberCommunityPublicInPersonDigitalCenterLikeBack =  new ArrayList<PersonDigitalCenters>(); 
			lMemberCommunityPublicInPersonDigitalCenterOtherCommunity = new ArrayList<PersonDigitalCenters>(); 
			lPersonDigitalCenterOutMemberComunityPublic =  new ArrayList<PersonDigitalCenters>();
			lMemberCommunityPublicOutPersonDigitalCenter = new ArrayList<MemberCommunityPublic>();
			lPersonDigitalCenterWithOutCommunity =  new ArrayList<PersonDigitalCenters>();
			
			CommunityComparativesFuntions.comparativeCommunityWichPerson( (Map) mapPersonDigitalCenter,
					(Map)  mapMemberComunityPublic,
					lMemberCommunityPublicInPersonDigitalCenterLikeBack,
					lMemberCommunityPublicInPersonDigitalCenterOtherCommunity,
					lPersonDigitalCenterOutMemberComunityPublic, 
					(List) lMemberCommunityPublicOutPersonDigitalCenter,
					lPersonDigitalCenterWithOutCommunity,
					filterByComunity);
			GFunctions.showExcessInsufficent(lMemberCommunityPublicInPersonDigitalCenterLikeBack,
					lMemberCommunityPublicInPersonDigitalCenterOtherCommunity,
					lPersonDigitalCenterOutMemberComunityPublic, 
					(List) lMemberCommunityPublicOutPersonDigitalCenter,
					lPersonDigitalCenterWithOutCommunity,
					filterByComunity);
			
			System.out.println("*********************************************************");
			System.out.println("(Step 5) PERSON AND MEMBER DUPLICATES");
			System.out.println("*********************************************************");
			GFunctions.showListWithMsg(daoMemberPublicComunity.getListMemberDuplicate(),"numero de duplicados en PublicComunity Member: "+daoMemberPublicComunity.getListMemberDuplicate().size());
			GFunctions.showListWithMsg(daoMemberManagerComunity.getListMemberDuplicate(),"numero de duplicados en Manager Comunity Member: "+daoMemberManagerComunity.getListMemberDuplicate().size());
			GFunctions.showListWithMsg(daoPeopleDigitalCenter.getListPersonDigitalDuplicate(),"numero de duplicados en Person Digital Center: "+daoPeopleDigitalCenter.getListPersonDigitalDuplicate().size());
			
			System.out.println("*********************************************************");
			System.out.println("(Step 6) PERSON AND MEMBER WITHOUT COMMUNITY");
			System.out.println("*********************************************************");
			GFunctions.showListWithMsg(daoMemberPublicComunity.getListMembertWithOutCommunity(),"numero de miembros sin comunidad (categoria) en PublicComunity Member: "+daoMemberPublicComunity.getListMembertWithOutCommunity().size());
			GFunctions.showListWithMsg(daoMemberManagerComunity.getListMembertWithOutCommunity(),"numero de miembros sin comunidad en (categoria) en en Manager Comunity Member: "+daoMemberManagerComunity.getListMembertWithOutCommunity().size());
			GFunctions.showListWithMsg(daoPeopleDigitalCenter.getListPersonDigitalWithOutCommunity(),"numero de personas sin comunidad en Person Digital Center: "+daoPeopleDigitalCenter.getListPersonDigitalWithOutCommunity().size());
			
			
			
			System.out.println("*********************************************************");
			System.out.println("(Step 6) DIFFERENCIES IN THE FIELDS");
			System.out.println("*********************************************************");
			compareFieldsMemberComunitWithPerson();
			
			//Discrepancias en	 oficina, perfil, rol y nivel dreyfus, tarifa
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void showPersonCommunity(String filterByComunity) {
		List<PersonDigitalCenters> peopleBack;
		try {
			peopleBack = (List) daoPeopleDigitalCenter.getListPersonDigitalByTechnology(filterByComunity);
			System.out.println("Person in "+filterByComunity+" has been load: "+peopleBack.size());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void compareFieldsMemberComunitWithPerson() throws Exception {
		Scanner sc = new Scanner(System.in);
		short option = 0;

		lAux1 = daoPeopleDigitalCenter.getListPersonDigitlaCenterByCode(mapMemberComunityManager.keySet().stream().collect(Collectors.toList()));	
		lAux2 = daoPeopleDigitalCenter.getListPersonDigitlaCenterByCode(mapMemberComunityPublic.keySet().stream().collect(Collectors.toList()));
		System.out.println(
				"\n*********************************************************************************************************************");
		System.out.println("Buscando discrepancias entre los miembros comunes de ambos documentos");
		System.out.println(
				"*********************************************************************************************************************");
		System.out.println("(" + daoMemberManagerComunity.getListMember().size() + ") miembros, MemberCommunityManager: \n" + daoMemberManagerComunity.getListMember());
		System.out.println("(" + daoMemberPublicComunity.getListMember().size() + ") miembros, MemberPublicManager: \n" + daoMemberManagerComunity.getListMember());
		System.out.println("(" + daoPeopleDigitalCenter.getListPersonDigitlaCenter().size() + ") miembros, PersonDitialCenter: \n" + daoPeopleDigitalCenter.getListPersonDigitlaCenter());
		System.out.println("(" + lAux1.size() + ") miembros del documento de la comunidad de responsables en el doc de centros, PersonDitialCenter: \n" + lAux1);
		System.out.println("(" + lAux2.size() + ") miembros del documento de la cumunidad público en el doc de centros, PersonDitialCenter: \n" + lAux2);
		

		do {
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------");
			System.out.print("Deteccion de discrepancias:"
					+ "\n\t 1- Comprobar todos los campos comunes entre el documento de la comunidad de responsables y el documento de centro." 
					+ "\n\t 2- Comprobar todos los campos comunes entre el documento de la comunidad publico y el documento de centro."
					+ "\n\t 3- Comprobar el nombre del documento de la comunidad de responsables y el documento de centro."
					+ "\n\t 4- Comprobar el nombre del documento de la comunidad publico y el documento de centro."
					+ "\n\t 5- Comprobar el oficina del documento de la comunidad de responsables y el documento de centro."
					+ "\n\t 6- Comprobar el oficina del documento de la comunidad publico y el documento de centro."
					+ "\n\t 7- Comprobar el categoria (comunidad tecnologica) del documento de la comunidad de responsables y el documento de centro."
					+ "\n\t 8- Comprobar el categoria (comunidad tecnologica) del documento de la comunidad publico y el documento de centro."
					+ "\n\t 9- Comprobar el rol del documento de la comunidad de responsables y el documento de centro."
					+ "\n\t10- Comprobar el rol del documento de la comunidad publico y el documento de centro."
					+ "\n\t11- Comprobar el nivel dreyfus del documento de la comunidad de responsables y el documento de centro."
					+ "\n\t12- Comprobar el nivel dreyfus del documento de la comunidad publico y el documento de centro."
					+ "\n\t13- Comprobar la tarifa del documento de la comunidad de responsables y el documento de centro."
					+ "\n\t14- Comprobar la fecha de incorporacion de la comunidad de responsables y el documento de centro."
					+ "\n\t15- Identificar campos difierentes de la comunidad de responsables y el documento de centro."
					+ ""//TODO: manager fields: fields: nº empleado, nombre, oficina, comunidad tecnologíaca (categoria), rol, nivel,tarifa, becario, f. incorporacion, identificar campos diferntes
						//TODO: public fields: 			nº empleado, nombre, oficina, comunidad tecnologíaca (categoria), rol, nivel, identificar campos diferntes
					+"\n\topcion (0- salir): ");
			try {
				option = sc.nextShort();

				switch (option) {
				case 1:
					// Compare all commons fields of Manager Community Doc with Person Digital Center
					PersonComparativesFuntions.comparativePersonComunitinyAllFields(daoMemberManagerComunity.getListMember(),daoPeopleDigitalCenter.getListPersonDigitlaCenter());
					break;
				case 2:
					// Compare all commons fields of Public Community Doc with Person Digital Center
					PersonComparativesFuntions.comparativePersonComunitinyAllFields(daoMemberPublicComunity.getListMember(),daoPeopleDigitalCenter.getListPersonDigitlaCenter());
					break;
				case 3:
					// Compare el name fiel of Manager Community Doc with Person Digital Center
					//lAux1 = daoPeopleDigitalCenter.getListPersonDigitlaCenterByCode(mapMemberComunityPublic.keySet().stream().collect(Collectors.toList()));		
					PersonComparativesFuntions.comparativeMemberComunitinyByName(daoMemberManagerComunity.getListMember(),lAux1);
					break;
				case 4:
					// Compare el name fiel of Public Doc with Person Digital Center
					//lAux2 = daoPeopleDigitalCenter.getListPersonDigitlaCenterByCode(mapMemberComunityPublic.keySet().stream().collect(Collectors.toList()));
					PersonComparativesFuntions.comparativeMemberComunitinyByName(daoMemberPublicComunity.getListMember(),lAux2);
					break;
				case 5:
					// Compare el office fiel of Manager Doc with Person Digital Center
					//lAux1 = daoPeopleDigitalCenter.getListPersonDigitlaCenterByCode(mapMemberComunityPublic.keySet().stream().collect(Collectors.toList()));
					PersonComparativesFuntions.comparativeMemberComunitinyByOffice(daoMemberManagerComunity.getListMember(),lAux1);
					break;	
				case 6:
					// Compare el office fiel of Manager Public Doc with Person Digital Center
					//lAux2 = daoPeopleDigitalCenter.getListPersonDigitlaCenterByCode(mapMemberComunityPublic.keySet().stream().collect(Collectors.toList()));
					PersonComparativesFuntions.comparativeMemberComunitinyByOffice(daoMemberPublicComunity.getListMember(),lAux2);
					break;
				case 7:
					// Compare el category fiel of Manager Public Doc with Person Digital Center
					//lAux1 = daoPeopleDigitalCenter.getListPersonDigitlaCenterByCode(mapMemberComunityPublic.keySet().stream().collect(Collectors.toList()));
					PersonComparativesFuntions.comparativeMemberComunitinyByCategory(daoMemberManagerComunity.getListMember(),lAux1,Constants.TYPETECNHOLOGY.get(3));
					break;
				case 8:
					// Compare el category fiel of Manager Public Doc with Person Digital Center
					//lAux2 = daoPeopleDigitalCenter.getListPersonDigitlaCenterByCode(mapMemberComunityPublic.keySet().stream().collect(Collectors.toList()));
					PersonComparativesFuntions.comparativeMemberComunitinyByCategory(daoMemberPublicComunity.getListMember(),lAux2,Constants.TYPETECNHOLOGY.get(3));
					break;
				case 9:
					// Compare el rol fiel of Manager Doc with Person Digital Center
					//lAux1 = daoPeopleDigitalCenter.getListPersonDigitlaCenterByCode(mapMemberComunityPublic.keySet().stream().collect(Collectors.toList()));
					PersonComparativesFuntions.comparativeMemberComunitinyByRol(daoMemberManagerComunity.getListMember(),lAux1);
					break;	
				case 10:
					// Compare el rol fiel of Manager Public Doc with Person Digital Center
					//lAux2 = daoPeopleDigitalCenter.getListPersonDigitlaCenterByCode(mapMemberComunityPublic.keySet().stream().collect(Collectors.toList()));
					PersonComparativesFuntions.comparativeMemberComunitinyByRol(daoMemberPublicComunity.getListMember(),lAux2);
					break;
				case 11:
					// Compare el dreyfous level fiel of Manager Doc with Person Digital Center
					//lAux1 = daoPeopleDigitalCenter.getListPersonDigitlaCenterByCode(mapMemberComunityPublic.keySet().stream().collect(Collectors.toList()));
					PersonComparativesFuntions.comparativeMemberComunitinyByLevelD(daoMemberManagerComunity.getListMember(),lAux1);
					break;	
				case 12:
					// Compare el dreyfous level fiel of Manager Public Doc with Person Digital Center
					//lAux2 = daoPeopleDigitalCenter.getListPersonDigitlaCenterByCode(mapMemberComunityPublic.keySet().stream().collect(Collectors.toList()));
					PersonComparativesFuntions.comparativeMemberComunitinyByLevelD(daoMemberPublicComunity.getListMember(),lAux2);
					break;
				case 13:
					// Compare el rate fiel of Manager Public Doc with Person Digital Center
					//lAux1 = daoPeopleDigitalCenter.getListPersonDigitlaCenterByCode(mapMemberComunityPublic.keySet().stream().collect(Collectors.toList()));
					PersonComparativesFuntions.comparativeMemberComunitinyByRate(daoMemberManagerComunity.getListMember(),lAux1);
					break;
				case 14:
					// Compare el admission date of Manager Public Doc with Person Digital Center
					//lAux1 = daoPeopleDigitalCenter.getListPersonDigitlaCenterByCode(mapMemberComunityPublic.keySet().stream().collect(Collectors.toList()));
					PersonComparativesFuntions.comparativeMemberComunitinyByAdmissionDate(daoMemberManagerComunity.getListMember(),lAux1);
					break;
				case 15:
					// Compare el admission date of Manager Public Doc with Person Digital Center
					//lAux1 = daoPeopleDigitalCenter.getListPersonDigitlaCenterByCode(mapMemberComunityPublic.keySet().stream().collect(Collectors.toList()));
					PersonComparativesFuntions.identifierFieldDifferences(daoMemberManagerComunity.getListMember(),lAux1);
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

	
}
