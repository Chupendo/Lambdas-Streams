package core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.xml.crypto.Data;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import configuration.Constants;
import pjo.MemberCommunity;
import pjo.MemberTeams;
import pjo.PersonDigitalCenters;

public class ExcelComparator {

	public static ProccesListTeams proccesListTeams;
	public static ProccesExcels proccesExcel;

	private static final Short[] TYPEINPUTMEMBERSTEAMS = { 0, 1, 2 };// Fichero de entrada con los miembos en el Teams
																		// {0-> txt, 1->csv, 2->xlsx}
	private static final Logger LOG = Logger.getLogger("core.ExcelComparator");
	private static final double PERCENT = 0.50; // Tanto por uno de conincidineida de nombres para descartar
	// private static final Constants CTN_CONSTANTS = new Constants();

	public static void main(String[] args) {
		String menu = "1-> Generar excel de la lista de miembros del teams a partir del txt"
				+ "\n2-> Generar excel de la lista de miembros del teams a partir del csv"
				+ "\n3-> Leer excel Miembros de la Comunidad" + "\n4-> Leer excel de Personas digital center"
				+ "\n5-> Comparar lista miembros del teams (csv) con Miembros de la Comunidad"
				+ "\n6-> Comparar lista miembros del teams (csv) con Personas digital center"
				+ "\n7-> Comparar lista Miembros de la Comunidad con Personas digital center"
				+ "\nIndique una opcion (0, para salir): ";
		short option = -1;
		Scanner sc = new Scanner(System.in);
		String doc, doc1, doc2; // Sintaxis: "./src/resources/input/excels/[NameFIle].xls";
		char writing; // {S,N} para guardar los resultados en un excel
		String filterByComunity = "";

		// List<MemberCommunity> listaMC = null;
		// List<MemberTeams> listMT=null;
		do {
			//
			List<Object> l1 = null, l2 = null;
			List<String> nameL1 = new ArrayList<String>(), nameL2 = new ArrayList<String>();
			List<String> head = null, listNameSNotFoundInDoc1 = null, listNameSNotFoundInDoc2 = null;
			//
			System.out.println(menu);
			try {

				option = sc.nextShort();
			} catch (Exception e) {
				// TODO: handle exception
				option = (short) 100;
				sc.nextLine();// Limpiamos buffer de entrada
			}

			switch (option) {
			case 0:
				sc.close();
				break;
			case 1:
				// Generar excel de la lista de miembros del teams a partir del txt
				generateExcelFromTXT();
				break;
			case 2:
				// Generar excel de la lista de miembros del teams a partir del csv
				generateExcelFromCSV();
				break;
			case 3:
				// Leer excel Miembros de la Comunidad
				doc = "./src/resources/input/excels/Miembros de la comunidad.xlsx";
				List<String> headMiemberComunity = Arrays.asList("codEmployed", "name", "office", "category", "rol",
						"level", "codeProject", "project", "codResponsable", "responsable", "technology",
						"certificiation", "low");
				// headMiemberComunity = Arrays.asList("codEmployed", "name",
				// "technology","certificiation", "low");
				List<MemberCommunity> listMembersComunity = null;
				try {
					listMembersComunity = (List) ProccesExcels.readExcel(doc, headMiemberComunity, (short) 0, "");
				} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				listMembersComunity = orderListMemberByName((List) listMembersComunity);
				System.out.println(listMembersComunity);
				/*
				 * listMembersComunity.forEach((m) -> { System.out.println(m.toString()); });
				 */

				break;
			case 4:
				// Leer Personas digital enter
				doc = "./src/resources/input/excels/Personas de Digital Centers.xlsx";
				List<PersonDigitalCenters> listPeopleDitialCenter = null;
				List<String> headPeopleDigital = Arrays.asList("codEmployed", "name", "linkCV", "technologyComunity",
						"rate", "rol", "drefyfusLevel", "office", "scholar", "admisionDate", "validaterMain",
						"validaterSecond", "assigned2021", "subcontracted");
				filterByComunity = "";
				try {
					// Leemos el documento
					listPeopleDitialCenter = (List) ProccesExcels.readExcel(doc, headPeopleDigital, (short) 2,
							filterByComunity);
					listPeopleDitialCenter = orderListMemberByName((List) listPeopleDitialCenter);

				} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Resultado ( filtrado por comunidad: " + filterByComunity + "): ");
				listPeopleDitialCenter.forEach((lPC) -> {
					System.out.println(lPC);
				});
				break;
			case 5:
				// Comparar lista miembros del teams (csv) con Miembros de la Comunidad

				// doc1 = "./src/resources/input/excels/listaMiembros1.xls";
				doc1 = "./src/resources/input/excels/listaMiembros2.xls";
				doc2 = "./src/resources/input/excels/Miembros de la comunidad.xlsx";
				/*
				 * List<String> headMiemberComunity2 = Arrays.asList("codEmployed", "name",
				 * "office", "category", "rol", "level", "codeProject", "project",
				 * "codResponsable", "responsable", "technology", "certificiation", "low");
				 */
				try {
					// Leemos listaMiembros2.xls
					// head = Arrays.asList("nombre", "email", "puesto", "ubicacion");
					head = Arrays.asList("nombre", "email");
					l1 = (List) ProccesExcels.readExcel(doc1, head, (short) 1, "");
					l1 = orderListMemberByName((List) l1);

					// Leemos Miembros de la comunidad.xls
					head = Arrays.asList("codEmployed", "name");
					l2 = (List) ProccesExcels.readExcel(doc2, head, (short) 0, "");
					l2 = orderListMemberByName((List) l2);

				} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// if (l1 != null) l1.stream().forEach(System.out::println);

				/*
				 * if (l2 != null) l2.stream().forEach(System.out::println);
				 */
				System.out.println("l1 = " + l1.size() + " members reads in " + doc1);
				System.out.println("l2 = " + l2.size() + " members reads in " + doc2);

				// Comparamos dos listas
				// List<String> nameL1 = new ArrayList<String>();
				l1.stream().forEach((l) -> {
					// System.out.println(((MemberTeams)l).getName());
					nameL1.add(((MemberTeams) l).getName());
				});

				// System.out.println("Lista de nombres de L1: \n"+nameL1);
				// nameL1.forEach(System.out::println);

				// List<String> nameL2 = new ArrayList<String>();
				l2.stream().forEach((l) -> {
					// System.out.println(((MemberTeams)l).getName());
					nameL2.add(((MemberCommunity) l).getName());
				});

				// System.out.println("Lista de nombres de L2: \n"+nameL2);
				// nameL2.forEach(System.out::println);

				// Obtenemos los miembros que no sale en doc1 pero si en el doc2
				// List<String> listNameSNotFoundInDoc1 = nameL2.stream().filter(f ->
				// !nameL1.contains(f)).collect(Collectors.toList());
				listNameSNotFoundInDoc1 = nameL2.stream().filter(f -> !nameL1.contains(f)).collect(Collectors.toList());
				listNameSNotFoundInDoc1 = orderListMemberByName((List) listNameSNotFoundInDoc1);// Lista de nombres
																								// ordenada de miembros
																								// que aparecen en doc1
																								// pero no en doc2
				/*
				 * lista.sort(new Comparator<String>() {
				 * 
				 * @Override public int compare(String o1, String o2) { return o1.compareTo(o2);
				 * } });
				 */

				//
				// Obtenemos los miembros que no sale en doc2 pero si en el doc1
				/*
				 * List<String> listNameSNotFoundInDoc2 = nameL1.stream().filter(f ->
				 * !nameL2.contains(f)) .collect(Collectors.toList());
				 */
				listNameSNotFoundInDoc2 = nameL1.stream().filter(f -> !nameL2.contains(f)).collect(Collectors.toList());
				listNameSNotFoundInDoc2 = orderListMemberByName((List) listNameSNotFoundInDoc2);

				System.out.println(
						"------------------------------------------------------------------------------------------------");
				System.out.println("Lista de nombres que no sale en " + doc1.split("/")[doc1.split("/").length - 1]
						+ " ordenada:");
				System.out.println(
						"(l1) " + doc1.split("/")[doc1.split("/").length - 1] + ">> " + listNameSNotFoundInDoc1);
				System.out.println("Lista de nombres que no sale en " + doc2.split("/")[doc2.split("/").length - 1]
						+ " ordenada:");
				System.out.println(
						"(l2) " + doc2.split("/")[doc2.split("/").length - 1] + ">> " + listNameSNotFoundInDoc2);
				System.out.println(
						"------------------------------------------------------------------------------------------------");
				//

				// Comporamos la lista de nombres de miembros no encontrada mas larga con la
				// lista de nombre de miembros menos larga, por que si se cumple la condicion de
				// coincidencia deja de buscar y empiza con el otro
				// Criterio de coincidencia: Si parte del nombre es mayor o igual a un valor
				// dado "PERCENT"
				Map<String, List<String>> mapListNameNotFounInDoc = null;
				if (listNameSNotFoundInDoc1.size() > listNameSNotFoundInDoc2.size()) {// Si L1 > L2?
					// Comparamos L2 con L1
					mapListNameNotFounInDoc = null;
					mapListNameNotFounInDoc = listNameDiff(listNameSNotFoundInDoc2, listNameSNotFoundInDoc1);
					// mapListNameNotFounInDoc.forEach((k, v) -> System.out.println((k + ":" + v)));
					/**
					 * //1º For (size of L2)*(size of L1)* iteraciones maximo //2º while (size of
					 * L1) iteraciones maxima for (int i = 0; i < listNameSNotFoundInDoc2.size();
					 * i++) { String[] nameMemberNotFoundL2 = listNameSNotFoundInDoc2.get(i).split("
					 * "); //Fragmentamos el nombre de L2, ya que se compara L1 con L2, al ser L2 de
					 * menor tamaño que L1 short be = 0; //Se incrembre el fragmento del nombre esta
					 * en L2 int j = 0; //Permite recorrer la lista de nombres de L1 while (j <
					 * listNameSNotFoundInDoc1.size()) { //Comprobamos L1 con el framgneto del
					 * nombre extradio de L2 for (int r = 0; r < nameMemberNotFoundL2.length; r++) {
					 * if (listNameSNotFoundInDoc1.get(j).contains(nameMemberNotFoundL2[r])) { be++;
					 * } } // System.out.println("***********"); //
					 * System.out.println(listNameSNotFoundInDoc1.get(j)+" porcentaje= //
					 * "+be/(double)nameMemberNotFoundL2.length);
					 * 
					 * if (be / (double) nameMemberNotFoundL2.length >= PERCENT) { // Mas de un
					 * "PERCENT" de coinidencia, Si esta pero es un nombre compuesto, el // este
					 * abreibadio listNameSNotFoundInDoc1.remove(j); break; }
					 * 
					 * j++; } // System.out.println(listNameSNotFoundInDoc2.get(i)+" portenajte= //
					 * "+be/(double)nameMemberNotFoundL2.length); //
					 * System.out.println("-------------"); if (be / (double)
					 * nameMemberNotFoundL2.length >= PERCENT) { // Mas de un "PERCENT" de
					 * coinidencia, Si esta pero es un nombre compuesto, el // este abreibadio
					 * listNameSNotFoundInDoc2.remove(i); i--; } }
					 **/
				} else { // L1>L2
					// Comparamos L1 con L2
					mapListNameNotFounInDoc = null;
					mapListNameNotFounInDoc = listNameDiff(listNameSNotFoundInDoc1, listNameSNotFoundInDoc2);
					// mapListNameNotFounInDoc.forEach((k, v) -> System.out.println((k + ":" + v)));
				}

				System.out.println(
						"------------------------------------------------------------------------------------------------"
								+ "\nLista de nombres de miembros no encontrados con un porcetaje de coincidencia  menor al "
								+ PERCENT * 100 + " %:");

				// mapListNameNotFounInDoc.forEach((k, v) -> System.out.println((k + ":" + v)));
				System.out.println("(l1) " + doc1.split("/")[doc1.split("/").length - 1] + ">> "
						+ mapListNameNotFounInDoc.get("l1"));
				System.out.println("(l2) " + doc2.split("/")[doc2.split("/").length - 1] + ">> "
						+ mapListNameNotFounInDoc.get("l2"));
				System.out.println(
						"------------------------------------------------------------------------------------------------");

				do {
					System.out.println("Resultado en excel?(y/n)");
					writing = sc.next().toLowerCase().charAt(0);
				} while (writing != 'y' && writing != 'n');

				if (writing == 'y') {
					// memberNotFoundToCampare[]Witch[].xls &&
					// memberNotFoundToCampare[]Witch[]To[]Percent.xl
					outputComparteExcel(doc1, doc2, (List) listNameSNotFoundInDoc1, (List) listNameSNotFoundInDoc2,
							(short) 0);
					outputComparteExcel(doc1, doc2, (List) mapListNameNotFounInDoc.get("l1"),
							(List) mapListNameNotFounInDoc.get("l2"), (short) 1);

				}

				break;
			case 6:
				// Comparar lista miembros del teams (csv) con Miembros de la Comunidad
				// doc1 = "./src/resources/input/excels/listaMiembros1.xls";
				doc1 = "./src/resources/input/excels/listaMiembros2.xls";
				doc2 = "./src/resources/input/excels/Personas de Digital Centers.xlsx";

				filterByComunity = Constants.TYPETECNHOLOGY.get(3); // Desarrollo Back
				try {
					// Leemos listaMiembros2.xls
					// head = Arrays.asList("nombre", "email", "puesto", "ubicacion");
					head = Arrays.asList("nombre", "email");
					// head = Arrays.asList("email");
					l1 = (List) ProccesExcels.readExcel(doc1, head, (short) 1, "");
					l1 = orderListMemberByName((List) l1);

					// Leemos Personas de Digital Centers.xlsx
					head = Arrays.asList("codEmployed", "name", "technologyComunity", "scholar");
					/*
					 * head = Arrays.asList("codEmployed","name", "linkCV", "technologyComunity",
					 * "rate", "rol", "drefyfusLevel", "office", "scholar", "admisionDate",
					 * "validaterMain", "validaterSecond", "assigned2021", "subcontracted");
					 */
					l2 = (List) ProccesExcels.readExcel(doc2, head, (short) 2, filterByComunity);
					// l2 = (List) ProccesExcels.readExcel(doc2, head, (short)
					// 2,Constants.TYPETECNHOLOGY.get(Constants.TYPETECNHOLOGY.size()-1)); //SN
					l2 = orderListMemberByName((List) l2);

				} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("l1 = " + l1.size() + " members reads in " + doc1);
				System.out.println("l2 = " + l2.size() + " members reads in " + doc2 + " (" + filterByComunity + ")");

				// Comparamos dos listas
				l1.stream().forEach((l) -> {
					// System.out.println(((MemberTeams)l).getName());
					nameL1.add(((MemberTeams) l).getName());
				});
				l2.stream().forEach((l) -> {
					// System.out.println(((MemberTeams)l).getName());
					nameL2.add(((PersonDigitalCenters) l).getName());
				});

				// System.out.println("nameL1>> "+nameL1);
				// System.out.println("nameL2>> "+nameL2);
				listNameSNotFoundInDoc1 = nameL2.stream().filter(f -> !nameL1.contains(f)).collect(Collectors.toList());
				listNameSNotFoundInDoc2 = nameL1.stream().filter(f -> !nameL2.contains(f)).collect(Collectors.toList());
				listNameSNotFoundInDoc1 = orderListMemberByName((List) listNameSNotFoundInDoc1);
				listNameSNotFoundInDoc2 = orderListMemberByName((List) listNameSNotFoundInDoc2);

				System.out.println(
						"------------------------------------------------------------------------------------------------");
				System.out.println("Lista de nombres que no sale en " + doc1.split("/")[doc1.split("/").length - 1]
						+ " ordenada (para la comunidad " + filterByComunity + "):");
				System.out.println(
						"(l1) " + doc1.split("/")[doc1.split("/").length - 1] + ">> " + listNameSNotFoundInDoc1);
				System.out.println("Lista de nombres que no sale en " + doc2.split("/")[doc2.split("/").length - 1]
						+ " ordenada:");
				System.out.println(
						"(l2) " + doc2.split("/")[doc2.split("/").length - 1] + ">> " + listNameSNotFoundInDoc2);
				System.out.println(
						"------------------------------------------------------------------------------------------------");
				Map<String, List<String>> mapListNameNotFounInDoc2 = null;
				if (listNameSNotFoundInDoc1.size() > listNameSNotFoundInDoc2.size()) {// Si L1 > L2?
					// Comparamos L2 con L1
					mapListNameNotFounInDoc2 = null;
					mapListNameNotFounInDoc2 = listNameDiff(listNameSNotFoundInDoc2, listNameSNotFoundInDoc1);
				} else { // L1>L2
					// Comparamos L1 con L2
					mapListNameNotFounInDoc2 = null;
					mapListNameNotFounInDoc2 = listNameDiff(listNameSNotFoundInDoc1, listNameSNotFoundInDoc2);
					// mapListNameNotFounInDoc.forEach((k, v) -> System.out.println((k + ":" + v)));
				}
				System.out.println("Lista de nombres que no sale en (l1) " + doc1.split("/")[doc1.split("/").length - 1]
						+ " y en (l2) " + doc2.split("/")[doc2.split("/").length - 1] + " (para la comunidad "
						+ filterByComunity + ")" + " (ordenadas y con un PERCENT de coincidencia >" + PERCENT * 100
						+ "%):");
				mapListNameNotFounInDoc2.forEach((k, v) -> System.out.println((k + ":" + v)));
				System.out.println(
						"------------------------------------------------------------------------------------------------");

				do {
					System.out.println("Resultado en excel?(y/n)");
					writing = sc.next().toLowerCase().charAt(0);
				} while (writing != 'y' && writing != 'n');

				if (writing == 'y') {
					// memberNotFoundToCampare[]Witch[].xls &&
					// memberNotFoundToCampare[]Witch[]To[]Percent.xl
					outputComparteExcel(doc1, doc2, (List) listNameSNotFoundInDoc1, (List) listNameSNotFoundInDoc2,
							(short) 0);
					outputComparteExcel(doc1, doc2, (List) mapListNameNotFounInDoc2.get("l1"),
							(List) mapListNameNotFounInDoc2.get("l2"), (short) 1);

				}
				
				do {
					System.out.println("¿Comprobar miembros en otra comunidad?(y/n)");
					writing = sc.next().toLowerCase().charAt(0);
				} while (writing != 'y' && writing != 'n');

				if (writing == 'y') {
					try {
						head = Arrays.asList("codEmployed", "name", "technologyComunity", "scholar");
						/*
						 * head = Arrays.asList("codEmployed","name", "linkCV", "technologyComunity",
						 * "rate", "rol", "drefyfusLevel", "office", "scholar", "admisionDate",
						 * "validaterMain", "validaterSecond", "assigned2021", "subcontracted");
						 */
						//l2 = (List) ProccesExcels.readExcel(doc2, head, (short) 2, filterByComunity);
						//filterByComunity = Constants.TYPETECNHOLOGY.get(Constants.TYPETECNHOLOGY.size()-1);
						filterByComunity="";
						l2 = (List) ProccesExcels.readExcel(doc2, head, (short) 2, ""); //ALL
						//l2 = orderListMemberByName((List) l2);

					} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("l1 = " + l1.size() + " members reads in " + doc1);
					System.out.println("l2 = " + l2.size() + " members reads in " + doc2 + " (" + filterByComunity + ")");
					
					//
					List<PersonDigitalCenters> personOtherComunity = new ArrayList<PersonDigitalCenters>(); //Lista de personas que salen en otra comunidad
					//¿Persoans de otra comunidad?
					System.out.println("------------------------------------------------------------------------------------------------");
					personOtherComunity = (List) lookPersonOtherComunity((List)l2,(List)listNameSNotFoundInDoc2);
					System.out.println("Personas de "+doc1.split("/")[doc1.split("/").length-1]+" en otra comunidad ("+personOtherComunity.size()+"): \n\t"+personOtherComunity);
					
					//¿Personas que no salen en doc1 pero no doc2
					List<String> listNameNotFound = new ArrayList<String>(); //Lista de nombres de miembros que no salen en ninguna comunidad
																			//parte de la lista de nombres que salen en doc1 pero no en doc2: listNameSNotFoundInDoc2
					listNameNotFound = (List) lookNotPersonOtherComunity((List)personOtherComunity,(List)listNameSNotFoundInDoc2);
					System.out.println("Nombre de personas de "+doc1.split("/")[doc1.split("/").length-1]+" no encontrado para ninguna comunidad en "+doc2.split("/")[doc2.split("/").length-1]+": \n\t"+listNameNotFound);
					System.out.println("------------------------------------------------------------------------------------------------");
					
					//Aplicando criterio "PERCENT"
					System.out.println(
							"------------------------------------------------------------------------------------------------"
									+ "\nLista de nombres de miembros no encontrados con un porcetaje de coincidencia  menor al "
									+ PERCENT * 100 + " %:");
					//List<String> listNamePersonOtherComunity = (List) personOtherComunity.stream().map(p->p.getName()).collect(Collectors.toList());
					//¿Personas de otra comunidad (aplicando un criteiro de coincidencia)?
					List<PersonDigitalCenters> personOtherComunityPercent=  new ArrayList<PersonDigitalCenters>();
					personOtherComunityPercent = (List) lookPersonOtherComunity((List)l2,(List)mapListNameNotFounInDoc2.get("l2"));
					System.out.println("Personas de "+doc1.split("/")[doc1.split("/").length-1]+" en otra comunidad ["+PERCENT*100+"%] ("+personOtherComunityPercent.size()+"): \n\t"+personOtherComunityPercent);
					
					//Lista de nombres que no aparecen en doc2 (aplicando un criteiro de coincidencia)?
					List<String> listNameNotFoundPercent = new ArrayList<String>(); 
					listNameNotFoundPercent = (List) lookNotPersonOtherComunity((List)personOtherComunity,(List)(List)mapListNameNotFounInDoc2.get("l2"));
					System.out.println("Nombre de personas de "+doc1.split("/")[doc1.split("/").length-1]+" no encontrado para ninguna comunidad ["+PERCENT*100+"%] ("+doc2.split("/")[doc2.split("/").length-1]+"): \n\t"+listNameNotFoundPercent);
					System.out.println("------------------------------------------------------------------------------------------------");
					do {
						System.out.println("Resultado en excel?(y/n)");
						writing = sc.next().toLowerCase().charAt(0);
					} while (writing != 'y' && writing != 'n');
					
					if (writing == 'y') {
						String outPathAbsoluteFileOuput="./src/resources/output/";
						String nameDoc1 = doc1.split("\\.")[1];
						nameDoc1 = nameDoc1.split("/")[nameDoc1.split("/").length-1];
						String nameDoc2 = doc2.split("\\.")[1];
						nameDoc2 = nameDoc2.split("/")[nameDoc2.split("/").length-1];
						
						//memberNotFoundToCampareOtherTecnhology[]In[].xls
						//String outPathAbsoluteFileOuputCompare = outPathAbsoluteFileOuput+"memberNotFoundToCampareOtherTecnhology"+nameDoc1+"In"+nameDoc2+".xls";
						String outPathAbsoluteFileOuputCompare = "";
						//outPathAbsoluteFileOuput= +"memeber"+nameDoc1+"InOtherComunityFindIn"+nameDoc2.replace(" ","")+".xls";
						
						
						//System.out.println("ss: "+personOtherComunity.stream().map(p->p.getName()).collect(Collectors.toList()));
						//System.out.println("aa: "+personOtherComunity.stream().map(p->p.getTechnologyComunity()).collect(Collectors.toList()));
						
						//member_[]_InOtherComunityFindIn_[].xls >> Miembros con otras tecnolgoias
						outPathAbsoluteFileOuputCompare = outPathAbsoluteFileOuput+"memeber_"+nameDoc1+"_InOtherComunityFindIn_"+nameDoc2.replace(" ","")+".xls";
						proccesExcel.createExcel(outPathAbsoluteFileOuputCompare, 
								Arrays.asList("name","comunity"), 
								(List) personOtherComunity.stream().map(p->p.getName()).collect(Collectors.toList()), 
								(List) personOtherComunity.stream().map(p->p.getTechnologyComunity()).collect(Collectors.toList()));
						
						//memberNotFoundToCampareOtherTecnhology_[]_In_[].xls
						outPathAbsoluteFileOuputCompare = outPathAbsoluteFileOuput+"memberNotFoundToCampareOtherTecnhology_"+nameDoc1+"_In_"+nameDoc2.replace(" ","")+".xls";
						proccesExcel.createExcel(outPathAbsoluteFileOuputCompare, 
								Arrays.asList("Miembros de "+nameDoc1+"no encontrado en "+nameDoc2,"Miembros de "+nameDoc1+" encontrados en "+nameDoc2+" en otra comunidad"), 
								(List) listNameNotFound,
								(List) personOtherComunity.stream().map(p->p.getName()).collect(Collectors.toList()));

						
						//Aplicando criterio "PERCENT"
						//member_[]_InOtherComunityFindIn_[]_Percent.xls >> Miembros con otras tecnolgoias
						outPathAbsoluteFileOuputCompare = outPathAbsoluteFileOuput+"memeber_"+nameDoc1+"_InOtherComunityFindIn_"+nameDoc2.replace(" ","")+"_To"+PERCENT*100+"PERCENT.xls";
						proccesExcel.createExcel(outPathAbsoluteFileOuputCompare, 
								Arrays.asList("name","comunity"), 
								(List) personOtherComunityPercent.stream().map(p->p.getName()).collect(Collectors.toList()), 
								(List) personOtherComunityPercent.stream().map(p->p.getTechnologyComunity()).collect(Collectors.toList()));
						//memberNotFoundToCampareOtherTecnhology_[]_In_[]__Percent.xls
						outPathAbsoluteFileOuputCompare = outPathAbsoluteFileOuput+"memberNotFoundToCampareOtherTecnhology_"+nameDoc1+"_In_"+nameDoc2.replace(" ","")+"_To"+PERCENT*100+"PERCENT.xls";
						proccesExcel.createExcel(outPathAbsoluteFileOuputCompare, 
								Arrays.asList("Miembros de "+nameDoc1+"no encontrado en "+nameDoc2,"Miembros de "+nameDoc1+" encontrados en "+nameDoc2+" en otra comunidad"), 
								(List) listNameNotFoundPercent,
								(List) personOtherComunityPercent.stream().map(p->p.getName()).collect(Collectors.toList()));
					}
				}
				break;
			case 7:
				//Comparar lista Miembros de la Comunidad con Personas digital center
				doc1 = "./src/resources/input/excels/Miembros de la comunidad.xlsx";
				doc2 = "./src/resources/input/excels/Personas de Digital Centers.xlsx";

				filterByComunity = Constants.TYPETECNHOLOGY.get(3); // Desarrollo Back
				List<MemberCommunity> listMC = new ArrayList<MemberCommunity>();
				List<PersonDigitalCenters> listPDC = new ArrayList<PersonDigitalCenters>();
				try {
					// Leemos Miembros de la comunidad.xlsx
					/*
					  head = Arrays.asList("codEmployed", "name", "office",
					  "category", "rol", "level", "codeProject", "project", "codResponsable", "responsable", "technology",
					  "certificiation", "low");
					*/
					head = Arrays.asList("codEmployed", "name","category","rol","level");

					// head = Arrays.asList("email");
					listMC = (List) ProccesExcels.readExcel(doc1, head, (short) 0, "");
					listMC = orderListMemberByName((List) listMC);

					// Leemos Personas de Digital Centers.xlsx
					
					head = Arrays.asList("codEmployed", "name", "technologyComunity", "scholar");
					/*
					 head = Arrays.asList("codEmployed","name", "linkCV", "technologyComunity",
					 "rate", "rol", "drefyfusLevel", "office", "scholar", "admisionDate",
					 "validaterMain", "validaterSecond", "assigned2021", "subcontracted");
					 */
					listPDC = (List) ProccesExcels.readExcel(doc2, head, (short) 2, filterByComunity);
					listPDC = orderListMemberByName((List) listPDC);
					/**
					l2 = (List) ProccesExcels.readExcel(doc2, head, (short) 2, filterByComunity);
					// l2 = (List) ProccesExcels.readExcel(doc2, head, (short)
					// 2,Constants.TYPETECNHOLOGY.get(Constants.TYPETECNHOLOGY.size()-1)); //SN
					l2 = orderListMemberByName((List) l2);
					**/

				} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//System.out.println("listMC> "+listMC);
				if(listMC==null || listPDC==null){
					break;
				}
				//List<MemberCommunity> listMC = new ArrayList<MemberCommunity>((List)l1);
				Map<Integer,Object> mapNameComunity = listMC.stream().collect(Collectors.toMap(MemberCommunity::getCodEmployed, l->new MemberCommunity(l)));
				Map<Integer,Object> mapNamePersonalDigitalCenter = listPDC.stream().collect(Collectors.toMap(PersonDigitalCenters::getCodEmployed, l->new PersonDigitalCenters(l)));
				
				System.out.println("------------------------------------------------------------------------------------------------");
				System.out.println("Miembors ledios en "+doc1.split("/")[doc1.split("/").length-1]+":");
				System.out.println("mapNameComunity> \n\t"+mapNameComunity);
				System.out.println("Miembors ledios en "+doc2.split("/")[doc2.split("/").length-1]+" ("+filterByComunity+"):");
				System.out.println("mapNamePersonalDigitalCenter> \n\t"+mapNamePersonalDigitalCenter);
				System.out.println("------------------------------------------------------------------------------------------------");
				
				// Comparamos dos listas
				System.out.println(	 );
				mapNameComunity.values().stream().forEach(l->{
					nameL1.add(((MemberCommunity) l).getName());
				});
				mapNamePersonalDigitalCenter.values().stream().forEach(l->{
					nameL2.add(((PersonDigitalCenters) l).getName());
				});
//				// System.out.println("nameL1>> "+nameL1);
//				// System.out.println("nameL2>> "+nameL2);
				listNameSNotFoundInDoc1 = nameL2.stream().filter(f -> !nameL1.contains(f)).collect(Collectors.toList());
				listNameSNotFoundInDoc2 = nameL1.stream().filter(f -> !nameL2.contains(f)).collect(Collectors.toList());
				listNameSNotFoundInDoc1 = orderListMemberByName((List) listNameSNotFoundInDoc1);
				listNameSNotFoundInDoc2 = orderListMemberByName((List) listNameSNotFoundInDoc2);
				
				System.out.println("------------------------------------------------------------------------------------------------");
				System.out.println("Miembros de "+doc2.split("/")[doc2.split("/").length-1]+" ("+filterByComunity+") no encontrados en "+doc1.split("/")[doc1.split("/").length-1]+":");
				System.out.println("listNameSNotFoundInDoc1> \n\t"+listNameSNotFoundInDoc1);
				System.out.println("Miembros de "+doc1.split("/")[doc1.split("/").length-1]+" no encontrados en "+doc2.split("/")[doc2.split("/").length-1]+" ("+filterByComunity+"):");
				System.out.println("listNameSNotFoundInDoc2> \n\t"+listNameSNotFoundInDoc2);
				System.out.println("------------------------------------------------------------------------------------------------");
				
				//
				Map<String, List<String>> mapListNameDo1NotFounInDoc2 = null;
				if (listNameSNotFoundInDoc1.size() > listNameSNotFoundInDoc2.size()) {// Si L1 > L2?
					// Comparamos L2 con L1
					mapListNameDo1NotFounInDoc2 = null;
					mapListNameDo1NotFounInDoc2 = listNameDiff(listNameSNotFoundInDoc2, listNameSNotFoundInDoc1);
				} else { // L1>L2
					// Comparamos L1 con L2
					mapListNameDo1NotFounInDoc2 = null;
					mapListNameDo1NotFounInDoc2 = listNameDiff(listNameSNotFoundInDoc1, listNameSNotFoundInDoc2);
					// mapListNameNotFounInDoc.forEach((k, v) -> System.out.println((k + ":" + v)));
				}
				System.out.println("Lista de nombres que no sale en (l1) " + doc1.split("/")[doc1.split("/").length - 1]
						+ " y en (l2) " + doc2.split("/")[doc2.split("/").length - 1] + " (para la comunidad "
						+ filterByComunity + ")" + " (ordenadas y con un PERCENT de coincidencia >" + PERCENT * 100
						+ "%):");
				mapListNameDo1NotFounInDoc2.forEach((k, v) -> System.out.println((k + ":" + v)));
				System.out.println(
						"------------------------------------------------------------------------------------------------");
				//
				do {
					System.out.println("Resultado en excel?(y/n)");
					writing = sc.next().toLowerCase().charAt(0);
				} while (writing != 'y' && writing != 'n');
				
				if (writing == 'y') {
					// memberNotFoundToCampare[]Witch[].xls &&
					// memberNotFoundToCampare[]Witch[]To[]Percent.xl
					outputComparteExcel(doc1, doc2, (List) listNameSNotFoundInDoc1, (List) listNameSNotFoundInDoc2,
							(short) 0);
					outputComparteExcel(doc1, doc2, (List) mapListNameDo1NotFounInDoc2.get("l1"),
							(List) mapListNameDo1NotFounInDoc2.get("l2"), (short) 1);

				}
				
				//
				break;
			default:
				option = -1;
				break;
			}
		} while (option != 0);

		// Leemos el documento csv con la lista de miembros de Teams

		// Leemos cvs de la lista de miembros
		// proccesExcel.readExcel("./src/resources/input/",(short)0,"");

	}

	/*
	 * lookNotPersonOtherComunity() Comprueba si la listA contiente el objeto de la listB
	 * 
	 * @param listA List<PersonDigitalCenters>
	 * @param listB	List<Object> Lista de String con los nombres a buscar
	 *
	 * @return List<PersonDigitalCenters> lista de personas de la listA que no estan en listB
	 */
	public static List<PersonDigitalCenters> lookNotPersonOtherComunity(List<Object> listA, List<Object> listB){
		//System.out.println(listB);
		List<String> lcopy = new ArrayList<String>((List)listB);
		for(Object namePersonOtherComunity:listA) {
			for(Object nameNotFoundDoc2: listB) {
				if(((PersonDigitalCenters) namePersonOtherComunity).getName().contains((String) nameNotFoundDoc2)) {
					//System.out.println("listNameSNotFoundInDoc2= "+listNameSNotFoundInDoc2+"\n entro: "+((PersonDigitalCenters) person).getName());
					lcopy.remove((String) nameNotFoundDoc2);
				}
			}
		}
		return (List)lcopy; 
	}
	/*
	 * lookPersonOtherComunity() Comprueba si la listA contiente el objeto de la listB
	 * 
	 * @param listA List<PersonDigitalCenters>
	 * @param listB	List<Object> Lista de String con los nombres a buscar
	 *
	 * @return List<PersonDigitalCenters> lista de personas que estan en listA y listB
	 */
	public static List<PersonDigitalCenters> lookPersonOtherComunity(List<Object> listA, List<Object> listB){
		List<PersonDigitalCenters> resul = new ArrayList<PersonDigitalCenters>();
		for(Object person: listA) {
			for(Object nameSearh:listB) {
				if(((PersonDigitalCenters) person).getName().contains((String) nameSearh)) {
					//System.out.println("listNameSNotFoundInDoc2= "+listNameSNotFoundInDoc2+"\n entro: "+((PersonDigitalCenters) person).getName());
					resul.add((PersonDigitalCenters)person);
				}
			}
			
		}
		return resul;
	}
	public static void outputComparteExcel(String doc1, String doc2, List<Object> listA, List<Object> listB,
			short type) {
		// memberNotFoundToCampare[]Witch[].xls &&
		// memberNotFoundToCampare[]Witch[]To[]Percent.xls in "./src/resources/output/"
		String pathAbsoluteFileOuput = null;
		List<String> head = null;
		String fragmentHeadC1 = "", fragmentHeadC2;
		//
		// memberNotFoundToCampare[]Witch[]
		pathAbsoluteFileOuput = "./src/resources/output/memberNotFoundToCampare"
				+ doc1.split("\\.")[1].split("/")[doc1.split("\\.")[1].split("/").length - 1].replace(" ", "").trim()
				+ "Witch"
				+ doc2.split("\\.")[1].split("/")[doc2.split("\\.")[1].split("/").length - 1].replace(" ", "").trim();

		// listNameOf[name-doc2]NotFoundIn[name-doc1],
		// listNameOf[name-doc1]NotFoundIn[name-doc2]
		fragmentHeadC1 = "listNameOf"
				+ doc2.split("\\.")[1].split("/")[doc2.split("\\.")[1].split("/").length - 1].replace(" ", "").trim()
				+ "NotFoundIn"
				+ doc1.split("\\.")[1].split("/")[doc1.split("\\.")[1].split("/").length - 1].replace(" ", "").trim();
		fragmentHeadC2 = "listNameOf"
				+ doc1.split("\\.")[1].split("/")[doc1.split("\\.")[1].split("/").length - 1].replace(" ", "").trim()
				+ "NotFoundIn"
				+ doc2.split("\\.")[1].split("/")[doc2.split("\\.")[1].split("/").length - 1].replace(" ", "").trim();
		switch (type) {
		case 0:
			/* LISTA DE MIEMBRSO QUE NO APARECNE SIN APLICAR CRITERIO */
			// memberNotFoundToCampare[]Witch[].xls
			pathAbsoluteFileOuput += ".xls";
			// listNameOf[name-doc2]NotFoundIn[name-doc1] | listNameOf[name-doc1]NotFoundIn[name-doc2]
			head = Arrays.asList(fragmentHeadC1, fragmentHeadC2);
			break;
		case 1:
			/* LISTA DE MIEMBRSO QUE NO APARECNE APLICANDO CRITERIO */
			// memberNotFoundToCampare[]Witch[]To[]Percent.xl
			pathAbsoluteFileOuput += "To" + ((int) (PERCENT * 100)) + "Percent" + ".xls";
			// listNameOf[name-doc2]NotFoundIn[name-doc1]To[percent],
			// listNameOf[name-doc1]NotFoundIn[name-doc2]To[percent]
			head = Arrays.asList(fragmentHeadC1 + "To" + ((int) (PERCENT * 100)),
					fragmentHeadC2 + "To" + ((int) (PERCENT * 100)));
			break;
		}
		
		if(head!=null && listA!=null && listB!=null ) {
			System.out.println("File=" + pathAbsoluteFileOuput + "\nElements" + head);
			proccesExcel.createExcel(pathAbsoluteFileOuput, head, (List) listA, (List) listB);
		}
		
		//Restablecemos variables
		head = null;
		listA = null;
		listB = null;
	}

	public static void generateExcelFromTXT() {
		proccesExcel = new ProccesExcels();
		List listMembersTeams = null;

		/** LISTA DE MIEMBROS DE TEAM - TXT **/
		// Leemos el documento txt con la lista de miembros de Teams
		proccesListTeams = new ProccesListTeams(); // Lee por defecto el fivherio de
		// texto de la lsita de teams
		listMembersTeams = proccesListTeams.read(TYPEINPUTMEMBERSTEAMS[0]);
		// proccesListTeams.load(); //Carga del documento
		// Cargmos la lista de miembros de teams en un documento excel

		// Guardamos los elemenots leidos

		if (listMembersTeams != null && !listMembersTeams.isEmpty()) {
			proccesExcel.writeExcel(ProccesListTeams.OUTPUTFILE, listMembersTeams, (short) 0);
		} else {
			LOG.log(Level.WARNING, "THE PARAMETER listMembersTeams IS NULL OR EMPTY");
		}

		/** Pruebas load() ficle no exisit/other path/... **/
		// proccesListTeams = new
		// ProccesListTeams("C:\\Users\\andres.rpenuela\\Downloads\\Spring\\DOC\\Seccion4\\hola.xlsx");
		// proccesListTeams.load(); //Carga del documento
		// proccesListTeams = new
		// ProccesListTeams("C:\\Users\\andres.rpenuela\\Downloads\\Spring\\DOC\\Seccion4\\Seccion4.docx");
		// proccesListTeams.load(); //Carga del documento

	}

	public static void generateExcelFromCSV() {
		proccesExcel = new ProccesExcels();
		List listMembersTeams = null;
		/** LISTA DE MIEMBROS DE TEAM - CSV **/
		// Leemos el documento csv con la lista de miembros de Teams
		proccesListTeams = new ProccesListTeams("./src/resources/input/csv/Comunidad_Desarrollo_Backend.csv");
		listMembersTeams = proccesListTeams.read(TYPEINPUTMEMBERSTEAMS[1]);
		// proccesListTeams.load(); //Carga del documento

		// Guardamos los elemenots leidos
		if (listMembersTeams != null && !listMembersTeams.isEmpty()) {
			// System.out.println(proccesListTeams.OUTPUTFILE);
			proccesExcel.writeExcel(ProccesListTeams.OUTPUTFILE, listMembersTeams, (short) 1);
		} else {
			LOG.log(Level.WARNING, "THE PARAMETER listMembersTeams IS NULL OR EMPTY");
		}

		// TO DO: En un futuro se peude juntar el txt + csv
	}

	public static void generarExcel() {

	}

	/**/
	public static List<Object> orderListMemberByName(List<Object> list) {
		if (list != null)
			Collections.sort(list, new Comparator<Object>() {
				@Override
				public int compare(Object m1, Object m2) {
					if (m1 instanceof String)
						return ((String) m1).compareTo((String) m2);

					else if (m1 instanceof MemberCommunity)
						return new String(((MemberCommunity) m1).getName())
								.compareTo(new String(((MemberCommunity) m2).getName()));
					else
						return 0;
				}
			});

		return list;
	}

	/*
	 * listNameDiff() Compara una lista de String "l1" con otra lista de String "l2"
	 * 
	 * @param l1 List<String>
	 * 
	 * @param l2 List<String>
	 * 
	 * @return Map<String,List<String>> Mapa con las lista de nombres que no
	 * aparecen dado unporcentaje "PERCENT"
	 */
	public static Map<String, List<String>> listNameDiff(List<String> l1, List<String> l2) {
		List<String> copyL1 = new ArrayList(l1);
		List<String> copyL2 = new ArrayList(l2);
		// final double PERCENT = 0.25; //Tanto por uno de conincidineida de nombres
		// para descartar
		Map<String, List<String>> result = new HashMap<String, List<String>>();

		// 1º For (size of L2)*(size of L1)* iteraciones maximo
		// 2º while (size of L1) iteraciones maxima
		for (int i = 0; i < copyL2.size(); i++) {
			String[] nameMemberNotFoundL2 = copyL2.get(i).split(" "); // Fragmentamos el nombre de L2, ya que se compara
																		// L1 con L2, al ser L2 de menor tamaño que L1
			short be = 0; // Se incrembre el fragmento del nombre esta en L2
			int j = 0; // Permite recorrer la lista de nombres de L1
			while (j < copyL1.size()) {
				// Comprobamos L1 con el framgneto del nombre extradio de L2
				for (int r = 0; r < nameMemberNotFoundL2.length; r++) {
					if (copyL1.get(j).contains(nameMemberNotFoundL2[r])) {
						be++;
					}
				}
				// System.out.println("***********");
				// System.out.println(l1.get(j)+" porcentaje=
				// "+be/(double)nameMemberNotFoundL2.length);

				if (be / (double) nameMemberNotFoundL2.length >= PERCENT) {
					// Mas de un "PERCENT" de coinidencia, Si esta pero es un nombre compuesto, el
					// este abreibadio
					copyL1.remove(j);
					break;
				}

				j++;
			}
			// System.out.println(l2.get(i)+" portenajte=
			// "+be/(double)nameMemberNotFoundL2.length);
			// System.out.println("-------------");
			if (be / (double) nameMemberNotFoundL2.length >= PERCENT) {
				// Mas de un "PERCENT" de coinidencia, Si está, pero es un nombre compuesto por
				// ejemplo
				copyL2.remove(i);
				i--;
			}
		}
		// System.out.println("l1= "+l1);
		// System.out.println("l2= "+l2);
		result.put("l1", copyL1);
		result.put("l2", copyL2);
		return result;
	}
}
