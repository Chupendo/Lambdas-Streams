package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import configuration.Constants;
import pjo.MemberCommunity;
import pjo.MemberTeams;
import pjo.PersonDigitalCenters;

public class ProccesExcels {
	private static Logger LOG = Logger.getLogger("core.ProccesExcels");
	private static final Constants CTN = new Constants();

	/*
	 * writeExcel() Guarda los datos en un documento excel
	 * 
	 * @param type Short indica el tipo de documento de procendia de la informacion
	 * {0-> Miembros de la comunidad.xlsx, 1-> listaMiembrosX.xls ,2-> Persoans de Digital Center.xlsx }
	 * 
	 * @param doc String ruta absoluta del fichero de excel de entrada
	 * 
	 * @param head List<String> cabecera del fichero a leer
	 * 
	 * @parma filter String usada para obtener todos las persoans de digital center o por alguna tecnologia (ver constante TYPETECNHOLOGY)
	 * @return List<Object> lista con los datos a guardar
	 */
	public static List<Object> readExcel(String doc, List<String> head, short type, String filter)
			throws IOException, EncryptedDocumentException, InvalidFormatException {
		LOG.log(Level.INFO, "IS READING EXCEL: " + doc.split("/")[doc.split("/").length - 1]);
		List<MemberCommunity> listMemberComunity = new ArrayList<MemberCommunity>();
		List<MemberTeams> listMemberTeams = new ArrayList<MemberTeams>();
		List<PersonDigitalCenters> listPersonDigitlaCenters = new ArrayList<PersonDigitalCenters>();
		Object member = null;
		short sizeHead=0;
		if (type == 0) {
			member = new MemberCommunity();
			sizeHead = (short) Constants.HEADERSLISTMEMBERSCOMUNITY.size();
		}else if (type == 1) {
			member = new MemberTeams();
			sizeHead = (short) Constants.HEADERSLISTMEMBERSTEAMS.size();
		}else if (type == 2){
			member = new PersonDigitalCenters();
			sizeHead = (short) Constants.HEADERSLISTPEOPLEDIGITALCENTERS.size();
		}
			
		
		// Obtenemos los bytes del fichero a leear
		File f = new File(doc);
		InputStream file = new FileInputStream(f);
		// Creamos el objeto/instancia del libro de trabajo "workbook" que referencia al
		// ficheor .xls or xlsx
		Workbook wb = WorkbookFactory.create(file);

		// creating a Sheet object to retrieve the object
		Sheet sheet = wb.getSheetAt(0);
		int iRow = 1;
		Row row = sheet.getRow(iRow); // En qué fila empezar ya dependerá también de si tenemos, por ejemplo, el
										// título de cada columna en la primera fila
		while (row != null) {
			short iCell = 0;
			
			// Leemos las columnas
			while (iCell < sizeHead) {
				//System.out.println("Leyendo: "+head.get(iCell));
				// System.out.println("Fila="+row.getRowNum()+" Celda= "+iCell);
				Cell cell = row.getCell(iCell);

				// String value = cell.getStringCellValue();
				// Integer value = (int) cell.getNumericCellValue();
				String value = "";
				
				if (cell != null) {
					// value = cell.toString().replaceAll("\\.([0-9]){1,20}", "");
					value = normalizeString(cell.toString().replaceAll("\\.([0-9]){1,20}", "")).toLowerCase().trim();
				}

				// String value = "1532.058585858".replaceAll("\\.([0-9]){1,20}","");
				// System.out.println("Valor de la celda es: " + value+".");

				//
				//System.out.println("show:: "+value);
				if (value != null && !value.trim().equals("")) {
					switch (type) {
					case 0:
						// 0-> Miembros de la comunidad.xlsx
						if(head.contains(Constants.HEADERSLISTMEMBERSCOMUNITY.get((int)iCell))) {
							if (iCell==0) {
								((MemberCommunity) member).setCodEmployed(Integer.parseInt(value));
							} else if (iCell==1) {
								((MemberCommunity) member).setName(value);
							} else if (iCell==2) {
								((MemberCommunity) member).setOffice(value);
							} else if (iCell==3) {
								((MemberCommunity) member).setCategory(value);
							} else if (iCell==4) {
								((MemberCommunity) member).setRol(value);
							} else if (iCell==5) {
								((MemberCommunity) member).setLevel(value);
							} else if (iCell==6) {
								// System.out.println("----------");
								// System.out.println(value.replaceAll("[(,)(;)(.)(\\s)]","#@"));
								// Arrays.asList(value.replaceAll("[(,)(;)(.)(\\s)]","#@").trim().split("(#@){1,10}")).forEach((x)->{System.out.println(x);});
								// System.out.println("----------");
								// Los caracteres (,)(;)(.)(\\s)(#@), lo considera una separacion entre codigos
								// de proyecto
								((MemberCommunity) member).setCodeProject(Arrays
										.asList(value.replaceAll("[(,)(;)(.)(\\s)]", "#@").trim().split("(#@){1,10}")));
							} else if (iCell==7) {
								// Elimina dos o mas espacios en blanco, y el caracter (;)(\n), lo considera una
								// separacion entre proyectos
								((MemberCommunity) member).setProject(Arrays.asList(value.trim().replaceAll("( ){2,}", " ")
										.replaceAll("[(;)]", "\n").trim().split("\n")));
							} else if (iCell==8) {
								// System.out.println("value= "+value);
								// Convertimos a lista de enteros + Elimina dos o mas espacios en blanco, y los
								// caracteres (,)(;)(.)(\\s)(#@), lo considera una separacion entre responsables
								List<String> listCodeResponsableString = Arrays
										.asList(value.trim().replaceAll("( ){2,}", " ").replaceAll("[(,)(;)(.)(\\s)]", "#@")
												.split("(#@){1,10}"));
								List<Integer> listCodeResponsableInteger = new ArrayList<Integer>();
								listCodeResponsableString.forEach((codResponsable) -> {
									listCodeResponsableInteger.add(Integer.parseInt(codResponsable));
								});
								((MemberCommunity) member).setCodResponsable(listCodeResponsableInteger);
							} else if (iCell==9) {
								// Dos o mas espaciones en blanco y (\n),y el caracter (\n) lo considera una
								// separacion entre responsables
								((MemberCommunity) member).setResponsable(
										Arrays.asList(value.trim().replaceAll("( ){2,}", "\n").split("(\n){1,10}")));
							} else if (iCell==10) {
								// Elimina dos o mas espaciones en blanco, y los caracteres (,)(;)(.)(\n) lo
								// considera una separacion entre tecnologías
								// Se detecta que algunas celdas conitnete palabras como Antiguamente...., una Y
								((MemberCommunity) member)
										.setTechnology(Arrays.asList(value.trim().replaceAll("( ){2,}", " ")
												.replaceAll("[(,)(;)(.)(\n)]", "#@").split("(#@){1,10}")));
							} else if (iCell==11) {
								// Elimina dos o mas espaciones en blanco, y los caracteres (,)(;)(.)(\n) lo
								// considera una separacion entre certificaciones
								((MemberCommunity) member)
										.setCertification(Arrays.asList(value.trim().replaceAll("( ){2,}", " ")
												.replaceAll("[(,)(;)(.)(\n)]", "#@").split("(#@){1,10}")));
							} else if (iCell==12) {
								// Elimina dos o mas espaciones en blanco,
								((MemberCommunity) member)
										.setLow(Boolean.parseBoolean(value.trim().replaceAll("( ){2,}", " ")));
							}
						}
						break;
					case 1:
						// 1-> listaMiembrosX.xlsx
						// System.out.println("value= "+value);
						if(head.contains(Constants.HEADERSLISTMEMBERSTEAMS.get((int)iCell))) {
							if (iCell==0) {
								((MemberTeams) member).setName(value.trim().replaceAll("( ){2,}", " "));
							} else if (iCell==1) {
								((MemberTeams) member).setEmail(value.trim().replaceAll("( ){2,}", " "));
							} else if (iCell==2) {
								((MemberTeams) member).setCategory(value.trim().replaceAll("( ){2,}", " "));
							} else if (iCell==3) {
								((MemberTeams) member).setLocalitation(value.trim().replaceAll("( ){2,}", " "));
							}
						}
						break;
					case 2:
						// 2 -> Miembros de la comunidad.xls
						//System.out.println(iCell+":"+Constants.HEADERSLISTPEOPLEDIGITALCENTERS.get((int)iCell)+", value= "+value);
						/*System.out.println(iCell+" Cargando: "+Constants.HEADERSLISTPEOPLEDIGITALCENTERS.get((int)iCell)
								+", "+Constants.HEADERSLISTPEOPLEDIGITALCENTERS.get(0));*/
						
						if(head.contains(Constants.HEADERSLISTPEOPLEDIGITALCENTERS.get((int)iCell))) {
							if (iCell==0) {
								((PersonDigitalCenters) member).setCodEmployed(Integer.parseInt(value));
							} else if (iCell==1) {
								((PersonDigitalCenters) member).setName(value.trim().replaceAll("( ){2,}", " "));
							} else if (iCell==2) {
								((PersonDigitalCenters) member).setLinkCV(value.trim().replaceAll("( ){2,}", " "));
							} else if (iCell==3) {
								((PersonDigitalCenters) member).setTechnologyComunity(value.trim().replaceAll("( ){2,}", " "));
							} else if (iCell==4) {
								((PersonDigitalCenters) member).setRate(Double.parseDouble(value));
							} else if (iCell==5) {
								((PersonDigitalCenters) member).setCenter(value.trim().replace("( ){2,}"," "));							
							} else if (iCell==6) {
								((PersonDigitalCenters) member).setRol(value.trim().replace("( ){2,}"," "));	
							}else if (iCell==7) {
								((PersonDigitalCenters) member).setProfile(value.trim().replace("( ){2,}"," "));	
							} else if (iCell==8) {
								((PersonDigitalCenters) member).setDrefyfusLevel(value.trim().replaceAll("( ){2,}", " "));
							} else if (iCell==9) {
								((PersonDigitalCenters) member).setOffice(value.trim().replaceAll("( ){2,}", " "));
							} else if (iCell==10) {
								if(value.trim().replaceAll("( ){2,}", " ").equalsIgnoreCase("si")){
									((PersonDigitalCenters) member).setScholar(true);
								}else {
									((PersonDigitalCenters) member).setScholar(Boolean.parseBoolean(value.trim().replaceAll("( ){2,}", " ")));
								}
							} else if (iCell==11) {
								((PersonDigitalCenters) member).setAdmisionDate(value.trim().replaceAll("( ){2,}", " "));
							} else if (iCell==12) {
								((PersonDigitalCenters) member).setOutputPreviewDate(value.trim().replaceAll("( ){2,}", " "));
							}else if (iCell==13) {
								((PersonDigitalCenters) member).setValidaterMain(value.trim().replaceAll("( ){2,}", " "));
							} else if (iCell==14) {
								((PersonDigitalCenters) member).setValidaterSecond(value.trim().replaceAll("( ){2,}", " "));
							} else if (iCell==15) {
								((PersonDigitalCenters) member).setAssigned(value.trim().replaceAll("( ){2,}", " "));
							} else if (iCell==16) {
								((PersonDigitalCenters) member).setSubcontracted(value.trim().replaceAll("( ){2,}", " "));
							}
						}
						
						break;
					case 3:
						// ListNameOf[]NotFoundIn[].xls
						break;
					default:
						break;
					}
				}

				//
				iCell++;
				// System.out.println("iRow= "+iRow+", iCell= "+iCell+", head.size()=
				// "+head.size()+", value= "+value);
				// System.out.println(member.toString());
			}
			
			if (type == 0){// 0-> Miembros de la comunicdad.xlsx
				//System.out.println("0-> Miembros de la comunicdad.xlsx: "+member);
				listMemberComunity.add((MemberCommunity) member);
				//System.out.println("-----------");
				//System.out.println(iRow+"Miembro leido: "+member);
				//System.out.println(listMemberComunity);
				//listMemberComunity.forEach((lm)->{System.out.println(lm);});
				//System.out.println("-----------");
				//Restablecemmos el miembro
				member = new MemberCommunity();
				
			}else if (type == 1){// 1-> listaMiembrosX.xlsx
				//System.out.println("1-> listaMiembrosX.xlsx: "+member);
				listMemberTeams.add((MemberTeams) member);
				//Restablecemmos el miembro
				member = new MemberTeams();
			}else if (type == 2 ){// 2 -> Miembros de la comunidad.xls
				//System.out.println("2 -> Miembros de la comunidad.xls: "+member);
				if(((PersonDigitalCenters) member).getName()!=null){
					
					if(((PersonDigitalCenters) member).getTechnologyComunity()==null && 
							(filter.equals(CTN.TYPETECNHOLOGY.get(CTN.TYPETECNHOLOGY.size()-1))) ){ //solo las personas sin tecnologia 
						//System.out.println("miembros sin comunidad------\n"+member);
						listPersonDigitlaCenters.add((PersonDigitalCenters) member);
					}else {
						//System.out.println("miembros con comunidad------\n"+member);
						if(((PersonDigitalCenters) member).getTechnologyComunity()!=null) {
							if(filter.equals("")) { //todos las personas
								listPersonDigitlaCenters.add((PersonDigitalCenters) member);
							}else {
								if(((PersonDigitalCenters) member).getTechnologyComunity().equalsIgnoreCase(filter)) { //solo las personas de la tecnologia
									
									listPersonDigitlaCenters.add((PersonDigitalCenters) member);
								}
							}
						}
					}
					//Restablecemmos el miembro
					member = new PersonDigitalCenters();
				}
					
			}
			//Nueva fila
			iRow++;
			row = sheet.getRow(iRow);
		}

		if (type == 0) {
			// 0-> Miembros de la comunicdad.xlsx
			LOG.log(Level.INFO, "HAS READED EXCEL: " + doc.split("/")[doc.split("/").length - 1] + ": "
					+ listMemberComunity.size() + " members");
			//System.out.println(listMemberComunity);
			//listMemberComunity.forEach((m) -> { System.out.println(">>"+m.toString()); });
			//return null;
			return (List) listMemberComunity;
			//
		} else if (type == 1) {
			// 1-> ListaMiembrosX.xls
			LOG.log(Level.INFO, "HAS READED EXCEL: " + doc.split("/")[doc.split("/").length - 1] + ": "
					+ listMemberTeams.size() + " members");
			//listMemberTeams.forEach((m) -> { System.out.println(m.toString()); });
			// return null;
			return (List) listMemberTeams;
			//
		} else if (type == 2) {
			// 1-> ListaMiembrosX.xls
			LOG.log(Level.INFO, "HAS READED EXCEL: " + doc.split("/")[doc.split("/").length - 1] + ": "
					+ listPersonDigitlaCenters.size() + " people");
			// listmember.forEach((m) -> { System.out.println(m.toString()); });
			// return null;
			return (List) listPersonDigitlaCenters;
			//
		}
		return null;
	}

	/*
	 * writeExcel() Guarda los datos en un documento excel
	 * 
	 * @param type Short indica el tipo de documento de procendia de la informacion
	 * {0-> txt, 1-> xlsx,2-> csv}
	 * 
	 * @param data List<Object> lista con los datos a guardar
	 * 
	 * @param doc String ruta absolutasa del fichero de excel salida
	 * 
	 */
	public static void writeExcel(String doc, List<Object> data, short type) {
		LOG.log(Level.INFO, "IS WRITTEN EXCEL, type= " + type);
		// Se crea el libro
		HSSFWorkbook libro = new HSSFWorkbook();

		// Se crea una hoja dentro del libro
		HSSFSheet hoja = libro.createSheet();

		short row = 0, cell = 0;
		// System.out.println(data.toString());
		for (Object element : data) {
			// System.out.println(data.toString());

			// Se crea una fila dentro de la hoja
			HSSFRow fila = hoja.createRow(row);
			MemberTeams memberTeam = (MemberTeams) element;

			switch (type) {
			case 0:// Se guarda la lista de miembros de un txt a excel

				while (cell < CTN.HEADERSLISTMEMBERSTEAMS.size()) {

					// Se crea una celda dentro de la fila
					HSSFCell celda = fila.createCell(cell);
					// Se crea el contenido de la celda y se mete en ella.
					HSSFRichTextString texto = null;

					if (row == 0) {
						// Guardamos la cabecera CTN.HEADERSLISTMEMBERSTEAMS[cell] => 0->Nombre,
						// 1->Email, 2->Categoria, 3->Localicacion
						texto = new HSSFRichTextString(CTN.HEADERSLISTMEMBERSTEAMS.get(cell));
					} else {
						String original = null;
						// Guardamos los miembros
						if (CTN.HEADERSLISTMEMBERSTEAMS.get(cell).equals(CTN.HEADERSLISTMEMBERSTEAMS.get(0))) {// Nombre
							original = memberTeam.getName();
							// System.out.println(memberTeam);
						} else if (CTN.HEADERSLISTMEMBERSTEAMS.get(cell).equals(CTN.HEADERSLISTMEMBERSTEAMS.get(2))) {// Categoria
							original = memberTeam.getCategory();
						} else if (CTN.HEADERSLISTMEMBERSTEAMS.get(cell).equals(CTN.HEADERSLISTMEMBERSTEAMS.get(3))) {// Localicacion
							original = memberTeam.getLocalitation();
						}
						// normalizamos el texto (sin acentos y minusculas) y lo guardamos como
						// HSSFRichTextString
						if (original == null)
							original = "";
						texto = new HSSFRichTextString(normalizeString(original).toLowerCase().trim());
						// reseteamos variable
						original = null;
					}

					// Se introduce la celda
					// System.out.println(texto);
					celda.setCellValue(texto);
					cell++;
				}
				cell = 0;
				row++;
				break;
			case 1:// Se guarda la lista de miembros de un csv a excel
				while (cell < CTN.HEADERSLISTMEMBERSTEAMS.size()) {

					// Se crea una celda dentro de la fila
					HSSFCell celda = fila.createCell(cell);
					// Se crea el contenido de la celda y se mete en ella.
					HSSFRichTextString texto = null;

					if (row == 0) {
						// Guardamos la cabecera CTN.HEADERSLISTMEMBERSTEAMS[cell] => 0->Nombre,
						// 1->Email, 2->Categoria, 3->Localicacion
						texto = new HSSFRichTextString(CTN.HEADERSLISTMEMBERSTEAMS.get(cell));
					} else {
						String original = null;
						// Guardamos los miembros
						if (CTN.HEADERSLISTMEMBERSTEAMS.get(cell).equals(CTN.HEADERSLISTMEMBERSTEAMS.get(0))) {// Nombre
							original = memberTeam.getName();
							// System.out.println(memberTeam);
						} else if (CTN.HEADERSLISTMEMBERSTEAMS.get(cell).equals(CTN.HEADERSLISTMEMBERSTEAMS.get(1))) {// Email
							original = memberTeam.getEmail();
						}

						// normalizamos el texto (sin acentos y minusculas) y lo guardamos como
						// HSSFRichTextString
						if (original == null)
							original = "";
						texto = new HSSFRichTextString(normalizeString(original).toLowerCase().trim());
						// reseteamos variable
						original = null;
					}

					// Se introduce el parametro leido en la celda
					// System.out.println(texto);
					celda.setCellValue(texto);
					cell++;
				}
				cell = 0;
				row++;

				break;
			default:
				break;
			}

		}

		// Se salva el libro.
		try {
			// System.out.println(doc);
			FileOutputStream fileOut = new FileOutputStream(doc);
			libro.write(fileOut);
			fileOut.close();

			LOG.log(Level.INFO, doc + " HAS BEEN WRITTEN");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * createExcel() Guarda dos listas en un excel
	 * 
	 * @param doc String Ruta absoluta del archivo de salida
	 * 
	 * @param head List<String> Lista de String con la información de la cabecera
	 * 
	 * @param l1 List<Object> Lista Generia a registrar en el excel
	 * 
	 * @param l2 List<Object> Lista Generica a registrar en el excel
	 * 
	 */
	public static void createExcel(String doc, List<String> head, List<Object> l1, List<Object> l2) {
		LOG.log(Level.INFO, "IS WRITTEN EXCEL " + doc);
		List<Object> dataLarge = null, dataShort = null;
		if (l1.size() > l2.size()) {
			dataLarge = new ArrayList<Object>(l1);
			dataShort = new ArrayList<Object>(l2);
		} else {
			dataLarge = new ArrayList<Object>(l2);
			dataShort = new ArrayList<Object>(l1);
		}
		// Se crea el libro y una una hoja dentro del libro
		HSSFWorkbook libro = new HSSFWorkbook();
		HSSFSheet hoja = libro.createSheet();

		short row = 0;
		for (Object element : dataLarge) {
			// System.out.println(data.toString());

			// Se crea una fila dentro de la hoja
			HSSFRow fila = hoja.createRow(row);
			

			//Celda a escribir
			HSSFCell celda = null;
			// Se crea el contenido de la celda y se mete en ella.
			HSSFRichTextString texto = null;

			if (row == 0) {
				// Se crea una celda dentro de la fila
				
				// Guardamos la cabecera recibida en una celda neva dentro de la fila "0" y columna 0
				celda = fila.createCell(0);
				texto = new HSSFRichTextString(head.get(0));
				celda.setCellValue(texto);
				// Guardamos la cabecera recibida en una celda neva dentro de la fila "0" y columna 0
				celda = fila.createCell(1);
				texto = new HSSFRichTextString(head.get(1));
				celda.setCellValue(texto);
				
				//
				row++;
				fila = hoja.createRow(row);
			} 
				// Se obtiene los elementos a regisrar en el excel
				//System.out.println("row= "+row+"l1= "+dataLarge.size()+", l2="+dataShort.size());
				String dataCell1 = (row<=l1.size()) ? (String) l1.get(row-1) : "";
				String dataCell2 = (row<=l2.size()) ? (String) l2.get(row-1) : "";
				// Guardamos los miembros-HSSFRichTextString

				// Guardamos la Lista 1 recibida en una celda neva dentro de la fila "Row" y columna 0
				celda = fila.createCell(0);
				// normalizamos el texto (sin acentos y minusculas) y lo guardamos como
				texto = new HSSFRichTextString(normalizeString(dataCell1).toLowerCase().trim());
				// Se introduce el parametro leido en la celda
				// System.out.println(texto);
				celda.setCellValue(texto);
				//System.out.println("["+row+"][0]: "+texto);
				
				// Guardamos la Lista 2 recibida en una celda neva dentro de la fila "Row" y columna 0
				celda = fila.createCell(1);
				texto = new HSSFRichTextString(normalizeString(dataCell2).toLowerCase().trim());
				celda.setCellValue(texto);
				//System.out.println("["+row+"][1]: "+texto);
			
			row++;
		}

		// Se salva el libro.
		try {
			// System.out.println(doc);
			FileOutputStream fileOut = new FileOutputStream(doc);
			libro.write(fileOut);
			fileOut.close();

			LOG.log(Level.INFO, doc + " HAS BEEN WRITTEN");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * normalizeString() Método que quitar caracteres no ASCII excepto: - la enie -
	 * interrogacion que abre - exclamacion que abre - grados - U con dieresis.
	 * 
	 * @param cadena String mensaje con carecteres no ASCII
	 * @return String mensjae sin acentos
	 */
	public static String normalizeString(String cadena) {
		String limpio = null;
		if (cadena != null) {
			String valor = cadena;
			valor = valor.toUpperCase();
			// Normalizar texto para eliminar acentos, dieresis, cedillas y tildes
			limpio = Normalizer.normalize(valor, Normalizer.Form.NFD);
			// Quitar caracteres no ASCII excepto la enie, interrogacion que abre,
			// exclamacion que abre, grados, U con dieresis.
			limpio = limpio.replaceAll("[^\\p{ASCII}(N\u0303)(n\u0303)(\u00A1)(\u00BF)(\u00B0)(U\u0308)(u\u0308)]", "");
			// Regresar a la forma compuesta, para poder comparar la enie con la tabla de
			// valores
			limpio = Normalizer.normalize(limpio, Normalizer.Form.NFC);
		}
		return limpio;
	}
}
