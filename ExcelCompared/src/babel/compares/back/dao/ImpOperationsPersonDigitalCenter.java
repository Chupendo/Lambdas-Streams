package babel.compares.back.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.attribute.AclEntry.Builder;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.util.StringBuilders;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import babel.compares.back.constants.Constants;
import babel.compares.back.dto.MemberCommunityManager;
import babel.compares.back.dto.MemberCommunityPublic;
import babel.compares.back.dto.PersonDigitalCenters;

public class ImpOperationsPersonDigitalCenter implements IOperacionsDigitalCenter {

	private static final String PATCHROOT = "src/resources/input/excels/";
	private static final String NAMEFILE = "Personas de Digital Centers2.xlsx";
	private static String INPUTFILE;
	private static File doc = null;

	private final static Logger LOG = Logger.getLogger("babel.comares.back.dao.ImpOperationsPersonDigitalCenter");
	private static final int Collections = 0;

	Map<Integer, PersonDigitalCenters> mapPersonDigitalCenter = null;
	List<PersonDigitalCenters> listPersonDigitalCenter = null;
	List<PersonDigitalCenters> listPersonDigitalCenterDuplied = null;
	List<PersonDigitalCenters> listPersonDigitalCenterWithOutEmployedCode = null;

	public ImpOperationsPersonDigitalCenter() {
		this.INPUTFILE = this.PATCHROOT + this.NAMEFILE;
		mapPersonDigitalCenter = new HashMap<Integer, PersonDigitalCenters>();
		listPersonDigitalCenter = new ArrayList<PersonDigitalCenters>();
		listPersonDigitalCenterDuplied = new ArrayList<PersonDigitalCenters>();
		listPersonDigitalCenterWithOutEmployedCode = new ArrayList<PersonDigitalCenters>();
	}

	@Override
	public Map<Object, Object> readDoc(List<String> head, String filter) throws Exception {
		LOG.log(Level.INFO,"readDoc run ...");
		InputStream file;// Contained the stream in bytes of the file (Contiene la secuencia en bytes del
							// fichero)
		Workbook wb; // WorkBook (Libro de trabajo)
		Sheet sheet; // Sheet of WorkBook (Hoja del libro de trabajo)
		int iRow = 0, iCell = 0; // Determine the number of Row & Cell of the sheet to write (Determina el numero
									// de Fila y Columan de la hoja aescribir) Note: the number of row & cell start
									// by 0 (Nota: El nmero defila y columna empiza por 0)
		short sizeHead = (short) Constants.HEADERSMEMBERSCOMUNITYMANAGER.size(); // Contained the number cell
		short withOutOrDuplicateEmployedCode = -1; // Employed Code for person who read without employed code
		Row row; // Row of the sheet (Fila de la hoja de estilos)
		Cell cell; // Cell of the sheet (Columna de la hoja de estilos)
		StringBuilder value;
		PersonDigitalCenters member = null;

		doc = GFunctions.loadFile(this.INPUTFILE);// Are Checked if exist the file and let's loader it (Se comprueba si
													// existe el archivo y lo cargamos)
		if (doc == null || !head.contains(Constants.HEADERSMEMBERSCOMUNITYMANAGER.get(0))) {// No exist the file or head
																							// not containt employed
																							// code, let's finish the
																							// operation (No existe el
																							// archivo o la cabecera no
																							// contiene el codigo de
																							// empelado, finalizamos la
																							// operación)
			throw new Exception("doc not exisit or head not containt employed code");
		}

		// Exist the file, let's read it (Existe el archivo, lo leemos)
		// Obtenemos los bytes del fichero a leear

		try {
			// Let's get the stream of bytes of the document to read (Obtenemos el flujo de
			// bytes del documenot a leer)
			file = new FileInputStream(doc);

			// Let's get the object/instancie to work book (Obtenemos el objeto/instnacia al
			// libro de trabajo) // ficheor .xls or xlsx
			wb = WorkbookFactory.create(file);

			// Let's create a Sheet in the Work Boot to retrieve it (Creamos una hoja en el
			// libro de trabajo para recuperar la informacion)
			sheet = wb.getSheetAt(0);

			// Let's select the first row of the sheet to read (Seleccionamos la segunda
			// fila de la hoja a leer)
			iRow = 1;
			row = sheet.getRow(iRow);

			//

			while (row != null) {
				// Let'sselect the first cell of the sheet to read(Seleccionamos la primera
				// columna de la hoja a leer)
				iCell = 0;
				cell = row.getCell(iCell);
				member = new PersonDigitalCenters();

				while (iCell < sizeHead) {
					// Let's get data of the cell
					cell = row.getCell(iCell);

					// Let's get value and normalize for process it (Obtemoss valor y normalizamos
					// para procesarlo)
					value = new StringBuilder();

					/*
					 * System.out.println("[row][cell]:["+iRow+"]["+iCell+"] field: " +
					 * Constants.HEADERSMEMBERSCOMUNITYMANAGER.get((int) iCell)+" //cell= "+cell);
					 */
					// Let's check if has getted information or the cell is null (Comprobamos si se
					// ha leido informaicón o es nula)
					if (cell != null) {
						// Let's normalize a string (Normalizamos un string)
						value.append(GFunctions.deleteMultipleSpace(cell.toString()));

						if (value.length() > 0) {
							if (head.contains(Constants.HEADERSLISTPERSONDIGITALCENTERS.get((int) iCell))) {
								/*
								 * System.out.println("row: " + iRow + ",cell:" + iCell + ", field: " +
								 * Constants.HEADERSLISTPERSONDIGITALCENTERS.get((int) iCell) + " value: " +
								 * value);
								 */

								/*
								 * Let's set the next fields (Seteamos los siguientes campos):
								 * 
								 * public static final List<String> HEADERSLISTPERSONDIGITALCENTERS =
								 * Arrays.asList("codEmployed","name", "linkCV", "technologyComunity", "rate",
								 * "center", "rol", "profile", "drefyfusLevel", "office", "scholar",
								 * "admisionDate", "outputDate", "outputPreviewDate","validaterMain",
								 * "validaterSecond", "assigned2021", "subcontracted");
								 */
								switch (iCell) {
								case 0:
									// Set codEmployed
									member.setCodEmployed(
											Integer.parseInt(value.toString().replaceAll("\\.([0-9]){1,20}", "")));
									break;
								case 1:
									// Set name
									member.setName(GFunctions.normalizeString(value.toString()));
									break;
								case 2:
									// Set linkcv
									member.setLinkCV(GFunctions.normalizeString(value.toString()));
									break;
								case 3:
									// Set technologyComunity
									member.setTechnologyComunity(GFunctions.normalizeString(value.toString()));
									break;
								case 4:
									// Set rate
									member.setRate(Double.parseDouble(value.toString()));
									break;
								case 5:
									// Set center
									member.setCenter(GFunctions.normalizeString(value.toString()));
									break;
								case 6:
									// Set rol
									member.setRol(GFunctions.normalizeString(value.toString()));
									break;
								case 7:
									// Set profile
									member.setProfile(GFunctions.normalizeString(value.toString()));
									break;
								case 8:
									// Set DrefyfusLevel
									member.setDrefyfusLevel(GFunctions.normalizeString(value.toString()));
									break;
								case 9:
									// Set office
									//System.out.println(member.getCodEmployed()+" office="+value.toString());
									member.setOffice(GFunctions.normalizeString(value.toString()));
									break;
								case 10:
									// Set scholar
									member.setScholar(GFunctions.getBoolean(value.toString()));
									break;
								case 11:
									// Set admision time
									member.setAdmisionDate(GFunctions.normalizeString(value.toString()));
									break;
								case 12:
									// Set out time
									member.setOutputDate(GFunctions.normalizeString(value.toString()));
									break;
								case 13:
									// Set out preview time
									member.setOutputPreviewDate(GFunctions.normalizeString(value.toString()));
									break;
								case 14:
									// Set validater main
									member.setValidaterMain(GFunctions.normalizeString(value.toString()));
									break;
								case 15:
									// Set validater second
									member.setValidaterSecond(GFunctions.normalizeString(value.toString()));
									break;
								case 16:
									// Set assigned
									member.setAssigned(GFunctions.normalizeString(value.toString()));
									break;
								case 17:
									// Set subemployed
									member.setSubcontracted(GFunctions.normalizeString(value.toString()));
									break;
								}

							}
						}
					}

					// mapMemberComunityManager.add((MemberCommunityManager) member);
					iCell++;

				}

				if (member.getCodEmployed() != null) {
					// System.err.println(member);
					// mapPersonDigitalCenter.put(member.getCodEmployed(), member);
					// listPersonDigitalCenter.add(member);
					if (mapPersonDigitalCenter.containsKey(member.getCodEmployed())) {//It is a person duplicated
						// Person with employed code duplied
						LOG.log(Level.WARNING, "This employed code " + member.getCodEmployed() + " is duplicate.");

						//Add the person duplicate of mapPersonDigitalCenter in listPersonDigitalCenterDuplied
						final Integer LookForEmployedCode = member.getCodEmployed();
						//Check if it is inside listPersonDigitalCenterDuplied
						Optional<PersonDigitalCenters> p =  listPersonDigitalCenterDuplied.stream().filter(f->f.getCodEmployed().equals(LookForEmployedCode)).findFirst();
						if( !p.isPresent()) {//No, then it is added for first times to list
							listPersonDigitalCenterDuplied.add(mapPersonDigitalCenter.get(member.getCodEmployed()));
						}
						
						//Update the others lists
						listPersonDigitalCenter.add(member);
						listPersonDigitalCenterDuplied.add(member);
						//Load the data of last person readed about the other person with same employed code
						mapPersonDigitalCenter.put((int) withOutOrDuplicateEmployedCode, member);
						withOutOrDuplicateEmployedCode--;
						
					} else {
						if (filter.equals(Constants.TYPETECNHOLOGY.get(Constants.TYPETECNHOLOGY.size() - 2))) {// todos
																												// los
																												// miembros
																												// con y
																												// sin
																												// tecnologia
							mapPersonDigitalCenter.put(member.getCodEmployed(), member);
							listPersonDigitalCenter.add(member);
						} else {
							if (member.getTechnologyComunity() == null && (filter
									.equals(Constants.TYPETECNHOLOGY.get(Constants.TYPETECNHOLOGY.size() - 1)))) { // solo
																													// las
																													// personas
																													// sin
																													// tecnologia
								// System.out.println("miembros sin comunidad------\n"+member);
								mapPersonDigitalCenter.put(member.getCodEmployed(), member);
								listPersonDigitalCenter.add(member);
							} else {
								// System.out.println("miembros con comunidad------\n"+member);
								if (member.getTechnologyComunity() != null) {
									if (filter.equals("")) { // todos las personas que tenga una tecnologia asociada
										mapPersonDigitalCenter.put(member.getCodEmployed(), member);
										listPersonDigitalCenter.add(member);
									} else {
										//System.out.println(member);
										if (member.getTechnologyComunity().equalsIgnoreCase(filter)) { // solo las
																										// personas de
																										// la tecnologia
																										// especificada
											//System.err.println(member);
											mapPersonDigitalCenter.put(member.getCodEmployed(), member);
											listPersonDigitalCenter.add(member);
										}
									}
								}
							}
						}
					}

				} else {
					// Person without employed code
					if (member.getCodEmployed() == null && member.getName() != null) {
						LOG.log(Level.WARNING, "The employed "+member.getName()+" don't have a employed code");
						//System.out.println("Person without employed code >> " + member);
						mapPersonDigitalCenter.put((int) withOutOrDuplicateEmployedCode, member);
						listPersonDigitalCenter.add(member);
						listPersonDigitalCenterWithOutEmployedCode.add(member);
						withOutOrDuplicateEmployedCode--;
					}
				}
				// Nueva fila
				iRow++;
				row = sheet.getRow(iRow);

			}
			// System.out.println(mapMemberComunityManager);
			file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return (Map) mapPersonDigitalCenter;
	}
	
	public boolean thereAreDuplicates() throws Exception {
		if (listPersonDigitalCenterDuplied==null)
			throw new Exception("The doc hasn't been loaded. ");
		
		return (listPersonDigitalCenterDuplied.size()!=0)?true:false;
	}
	
	public boolean thereArePersonWithOutEmpledCode()throws Exception {
		if (listPersonDigitalCenterWithOutEmployedCode==null)
			throw new Exception("The doc hasn't been loaded. ");
		
		return (listPersonDigitalCenterWithOutEmployedCode.size()!=0)?true:false;
	}
	@Override
	public List<Object> MapToList(List<String> head) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getListName() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getListKey() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getListValues() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPersonDigitlaCenterByCode(Integer key) throws Exception {
		if (this.mapPersonDigitalCenter == null || this.mapPersonDigitalCenter.isEmpty()) {
			throw new Exception("The doc is not load");
		}
		return (mapPersonDigitalCenter.containsKey(key))?mapPersonDigitalCenter.get(key):null;
	}

	@Override
	public List<Object> getListPersonDigitlaCenterByCode(List<Integer> listKey) throws Exception {
		List<PersonDigitalCenters> listPersonDigitalFind = new ArrayList<PersonDigitalCenters>();
		if (this.mapPersonDigitalCenter == null || this.mapPersonDigitalCenter.isEmpty()) {
			throw new Exception("The doc is not load");
		}
		
		listKey.stream().forEach(key->{
			try {
				Object result = getPersonDigitlaCenterByCode(key);
				if(result!=null)
					listPersonDigitalFind.add((PersonDigitalCenters) result);
			} catch (Exception e) {
				System.err.println("Couldn't get the list of the member for "+e);
				//e.printStackTrace();
			}
		});
		
		if(listPersonDigitalFind.isEmpty())
			return null;
		
		return (List) listPersonDigitalFind;
	}

	@Override
	public List<Object> getListPersonDigitlaCenter() throws Exception {
		if (mapPersonDigitalCenter == null || listPersonDigitalCenter == null)
			throw new Exception("Doc " + NAMEFILE + " has't readed");

		return (List) listPersonDigitalCenter;
	}

	public Map<Integer, String> getMapPersonDigitalByTechnology(String filter) {
		LOG.log(Level.INFO,"getMapTechnologyCommunityByCodeEmployed run ...");
		List<PersonDigitalCenters> peopleF = null;
		Map<Integer, String> resul = new HashMap<Integer, String>();
		if (GFunctions.normalizeString(filter).equalsIgnoreCase("all")) {
			// All People (without filter)
			peopleF = listPersonDigitalCenter;
		} else {
			if (GFunctions.normalizeString(filter).equalsIgnoreCase("SN")) {
				// People without community
				peopleF = listPersonDigitalCenter.stream().filter(f -> f.getTechnologyComunity() == null)
						.collect(Collectors.toList());
			} else {
				// People with community
				if (GFunctions.normalizeString(filter).equalsIgnoreCase("")) {
					peopleF = listPersonDigitalCenter.stream().filter(f -> f.getTechnologyComunity() != null)
							.collect(Collectors.toList());

				} else {
					
					/*listPersonDigitalCenter.stream()
					.filter(f -> f.getTechnologyComunity().equalsIgnoreCase(GFunctions.normalizeString(filter))).forEach(System.out::println);
					*/
					peopleF = listPersonDigitalCenter.stream().filter(f -> f.getTechnologyComunity() != null)
							.collect(Collectors.toList());
					peopleF = peopleF.stream()
							.filter(f -> f.getTechnologyComunity().equalsIgnoreCase(GFunctions.normalizeString(filter)))
							.collect(Collectors.toList());
				}
			}
		}

		
		//System.out.println("(" + peopleF.size() + ") members of " + filter + ", " + "values= "+peopleF);
		//peopleF.forEach(System.out::println);
		if (peopleF != null) {
			peopleF.forEach(f -> {
				resul.put(f.getCodEmployed(), f.getName());
			});
		}
		LOG.log(Level.INFO,"getMapTechnologyCommunityByCodeEmployed response: "+"(" + resul.size() + ") members of " + filter + ", " + "values= "+resul);
		return resul;
	}

	@Override
	public List<Object> getListPersonDigitalDuplicate() throws Exception {
		if (mapPersonDigitalCenter == null || listPersonDigitalCenter == null)
			throw new Exception("Doc " + NAMEFILE + " has't readed");

		return (List) listPersonDigitalCenterDuplied;
	}

	@Override
	public List<Object> getListPersonDigitalWithOutEmpledCode() throws Exception {
		if (mapPersonDigitalCenter == null || listPersonDigitalCenter == null)
			throw new Exception("Doc " + NAMEFILE + " has't readed");

		return (List) listPersonDigitalCenterWithOutEmployedCode;
	}

	@Override
	public List<Object> getListPersonDigitalByTechnology(String filter) throws Exception {
		if (mapPersonDigitalCenter == null || listPersonDigitalCenter == null)
			throw new Exception("Doc " + NAMEFILE + " has't readed");
		List<Object> lResul = new ArrayList<Object>();
		for(int i=0;i<listPersonDigitalCenter.size();i++) {
			if(listPersonDigitalCenter.get(i).getTechnologyComunity()!=null &&
					listPersonDigitalCenter.get(i).getTechnologyComunity().equalsIgnoreCase(filter))
				lResul.add(listPersonDigitalCenter.get(0));
		}
		return (List) lResul;
	}

	@Override
	public boolean thereArePersonWithOutCommunity() throws Exception {
		if (listPersonDigitalCenter==null)
			throw new Exception("The doc hasn't been loaded. ");
		
		return (getListPersonDigitalWithOutCommunity().size()!=0)?true:false;
	}
	
	@Override
	public List<Object> getListPersonDigitalWithOutCommunity() throws Exception {
		if (listPersonDigitalCenter==null)
			throw new Exception("The doc hasn't been loaded. ");
		
		List<Object> lPersonWithOutCommunity = new ArrayList<Object>();
		Iterator<PersonDigitalCenters> itr = listPersonDigitalCenter.iterator();
		
		while(itr.hasNext()) {
			PersonDigitalCenters m = itr.next();
			if(m.getTechnologyComunity()==null || m.getTechnologyComunity().replace("\\s", "").equals("")){
				lPersonWithOutCommunity.add(m);
			} 
		}
		return lPersonWithOutCommunity;
	}
}
