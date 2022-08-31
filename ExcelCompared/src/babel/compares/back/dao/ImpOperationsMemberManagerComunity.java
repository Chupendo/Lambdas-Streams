package babel.compares.back.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class ImpOperationsMemberManagerComunity implements IOperacionsMemberCommunity {

	private static final String PATCHROOT = "src/resources/input/excels/";
	private static final String NAMEFILE = "ComunityTeams (1).xlsx";
	private static String INPUTFILE;
	private static File doc = null;

	private final static Logger LOG = Logger.getLogger("babel.comares.back.dao.ImpOperationsManagerComunity");
	private static final int Collections = 0;

	Map<Integer, MemberCommunityManager> mapMemberComunityManager = null;
	List<MemberCommunityManager> listMemberComunityManager = null;
	List<MemberCommunityManager> listMemberComunityManagerDuplicate = null;
	List<MemberCommunityManager> listMemberComunityManagerWithOuthEmployedCode = null;

	public ImpOperationsMemberManagerComunity() {
		this.INPUTFILE = this.PATCHROOT + this.NAMEFILE;
		mapMemberComunityManager = new HashMap<Integer, MemberCommunityManager>();
		listMemberComunityManager = new ArrayList<MemberCommunityManager>();
		listMemberComunityManagerDuplicate = new ArrayList<MemberCommunityManager>();
		listMemberComunityManagerWithOuthEmployedCode = new ArrayList<MemberCommunityManager>();
	}

	@Override
	public Map<Object, Object> readDoc(List<String> head) throws Exception {
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
		MemberCommunityManager member = null;

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
				member = new MemberCommunityManager();

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

						// System.out.println("field: "+
						// Constants.HEADERSMEMBERSCOMUNITYMANAGER.get((int) iCell)+" //value=
						// "+value.toString()+" //value is null? "+(value==null)+" //length is empaty?
						// "+(value.length()));
						// Let's check if there content (Comprobamos si hay contenido)
						if (value.length() > 0) {
							if (head.contains(Constants.HEADERSMEMBERSCOMUNITYMANAGER.get((int) iCell))) {
								/*
								 * System.out.println("row: " + iRow + ",cell:" + iCell + ", field: " +
								 * Constants.HEADERSMEMBERSCOMUNITYMANAGER.get((int) iCell) + " value: " +
								 * value);
								 */
								/*
								 * Let's set the next fields (Seteamos los siguietnes campos:
								 * 
								 * public static final List<String> HEADERSMEMBERSCOMUNITYMANAGER =
								 * Arrays.asList( "codEmployed", "name", "office", "category", "rol", "level",
								 * "rate", "scholar,", "evaluation","codeProject", "project", "responsable",
								 * "technology","certificiation",
								 * "progressComment","admisionDate","formation","formationTargetTime","low",
								 * "field1","field2", "field3", "field4","evaluator","officialEvalution",
								 * "calledToMeeting","meetingTime", "teamsGroupCorrelation");
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
									// Set office
									member.setOffice(GFunctions.normalizeString(value.toString()));
									break;
								case 3:
									// Set category
									member.setCategory(GFunctions.normalizeString(value.toString()));
									break;
								case 4:
									// Set rol
									member.setRol(GFunctions.normalizeString(value.toString()));
									break;
								case 5:
									// Set level
									member.setLevel(GFunctions.normalizeString(value.toString()));
									break;
								case 6:
									// Set rate
									member.setRate(Double.parseDouble(value.toString()));
									break;
								case 7:
									// Set scholar
									member.setScholar(GFunctions.getBoolean(value.toString()));

									break;
								case 8:
									// Set evaluation
									member.setEvaluation(GFunctions.normalizeString(value.toString()));
									break;
								case 9:
									// Set project project code
									member.setCodeProject(GFunctions.getListCodeString(value.toString()));
									break;
								case 10:
									// Set project
									member.setProject(GFunctions.getListString(value.toString()));
									break;
								case 11:
									// Set manager
									member.setResponsable(GFunctions.getListString(value.toString()));
									break;
								case 12:
									// Set technology
									member.setTechnology(GFunctions.getListString(value.toString()));
									break;
								case 13:
									// Set certification
									member.setCertification(GFunctions.getListString(value.toString()));
									break;
								case 14:
									// Set progress comment
									member.setProgressComment(value.toString());
									break;
								case 15:
									// Set admisionDate
									member.setAdmisionDate(value.toString());
									break;
								case 16:
									// Set formation
									member.setFormation(GFunctions.getListString(value.toString()));
									break;
								case 17:
									// Set formation target time
									member.setFormationTargetTime(value.toString());
									break;
								case 18:
									// Set Low
									member.setLow(GFunctions.getBoolean(value.toString()));

									break;
								case 19:
									// Set field 1
									member.setField1(value.toString());
									break;
								case 20:
									// Set field 2
									member.setField2(value.toString());
									break;
								case 21:
									// Set field 3
									member.setField3(value.toString());
									break;
								case 22:
									// Set field 4
									member.setField4(value.toString());
									break;
								case 23:
									// Set evaluator
									member.setEvaluator(GFunctions.normalizeString(value.toString()));
									break;
								case 24:
									// Set official evaluation
									member.setOfficialEvalution(GFunctions.getBoolean(value.toString()));
									break;
								case 25:
									// Set calle to meeting
									member.setCalledToMeeting(GFunctions.getBoolean(value.toString()));
									break;
								case 26:
									// Set teams group correlation
									member.setTeamsGroupCorrelation(GFunctions.normalizeString(value.toString()));
									break;
								}

							}
						}
					}
					
					iCell++;

				}
				
				if(member.getCodEmployed()!=null) {
					// System.err.println(member);
					// mapPersonDigitalCenter.put(member.getCodEmployed(), member);
					// listPersonDigitalCenter.add(member);
					if (mapMemberComunityManager.containsKey(member.getCodEmployed())) {
						// Person with employed code duplied
						LOG.log(Level.WARNING, "This employed code " + member.getCodEmployed() + " is duplicate.");
						mapMemberComunityManager.put((int) withOutOrDuplicateEmployedCode, member);
						listMemberComunityManager.add(member);
						listMemberComunityManagerDuplicate.add(member);
						withOutOrDuplicateEmployedCode--;

					}else {
						mapMemberComunityManager.put(member.getCodEmployed(), member);
						listMemberComunityManager.add(member);
					}
					
				}else {
					// Person without employed code
					if (member.getCodEmployed() == null && member.getName() != null) {
						LOG.log(Level.WARNING, "The employed "+member.getName()+" don't have a employed code");
						//System.out.println("Person without employed code >> " + member);
						mapMemberComunityManager.put((int) withOutOrDuplicateEmployedCode, member);
						listMemberComunityManager.add(member);
						listMemberComunityManagerWithOuthEmployedCode.add(member);
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

		return (Map) mapMemberComunityManager;
	}

	@Override
	public List<Object> MapToList(List<String> head) throws Exception {

		// TODO Auto-generated method stub
		if (this.mapMemberComunityManager == null || this.mapMemberComunityManager.isEmpty()) {
			this.readDoc(head);
			this.MapToList(head);
		}
		// mapMemberComunityManager

		/*
		 * for(Integer key: mapMemberComunityManager.keySet()) {
		 * listMemberComunityManager.add(mapMemberComunityManager.get(key)); }
		 * 
		 * return (List) listMemberComunityManager;
		 */
		Collection<MemberCommunityManager> values = mapMemberComunityManager.values();
		return values.stream().collect(Collectors.toList());
	}

	
	public List<String> getListName() throws Exception {
		if (this.mapMemberComunityManager == null || this.mapMemberComunityManager.isEmpty()) {
			throw new Exception("The doc is not load");
		}
		/*
		 * System.out.println(mapMemberComunityManager.entrySet().stream().filter(m ->
		 * m.getValue().getName() != null)
		 * .map(Map.Entry::getValue).collect(Collectors.toList()).stream().map(
		 * MemberCommunityManager::getName) .collect(Collectors.toList()));
		 */
		return mapMemberComunityManager.entrySet().stream().filter(m -> m.getValue().getName() != null)
				.map(Map.Entry::getValue).collect(Collectors.toList()).stream().map(MemberCommunityManager::getName)
				.collect(Collectors.toList());
	}

	public List<Integer> getListKey() throws Exception {
		if (this.mapMemberComunityManager == null || this.mapMemberComunityManager.isEmpty()) {
			throw new Exception("The doc is not load");
		}
		return mapMemberComunityManager.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());
	}
	
	public List<Object> getListValues() throws Exception {
		if (this.mapMemberComunityManager == null || this.mapMemberComunityManager.isEmpty()) {
			throw new Exception("The doc is not load");
		}
		return mapMemberComunityManager.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
	}
	
	public Object getMemberByEmployedCode(Integer key) throws Exception {
		if (this.mapMemberComunityManager == null || this.mapMemberComunityManager.isEmpty()) {
			throw new Exception("The doc is not load");
		}
		return (mapMemberComunityManager.containsKey(key))?mapMemberComunityManager.get(key):null;
	}
	
	public List<Object> getListMemberByEmployedCode(List<Integer> listKey) throws Exception{
		List<MemberCommunityManager> listMemberManagerFind = new ArrayList<MemberCommunityManager>();
		if (this.mapMemberComunityManager == null || this.mapMemberComunityManager.isEmpty()) {
			throw new Exception("The doc is not load");
		}
		
		listKey.stream().forEach(key->{
			try {
				Object result = getMemberByEmployedCode(key);
				if(result!=null)
					listMemberManagerFind.add((MemberCommunityManager) result);
			} catch (Exception e) {
				System.err.println("Couldn't get the list of the member for "+e);
				//e.printStackTrace();
			}
		});
		
		if(listMemberManagerFind.isEmpty())
			return null;
		
		return (List) listMemberManagerFind;
		
	}
	
	public List<Object> getListMember() throws Exception{
		if (this.mapMemberComunityManager == null || this.mapMemberComunityManager.isEmpty()) {
			throw new Exception("The doc is not load");
		}
		
		//listMemberComunityManager = new ArrayList<MemberCommunityManager>();
		//Collection<MemberCommunityManager> values = mapMemberComunityManager.values();
		//listMemberComunityManager = (List) values.stream().collect(Collectors.toList());
		return (List) listMemberComunityManager;
		
	}

	@Override
	public boolean thereAreDuplicates() throws Exception {
		if (listMemberComunityManagerDuplicate==null)
			throw new Exception("The doc hasn't been loaded. ");
		
		return (listMemberComunityManagerDuplicate.size()!=0)?true:false;
	}

	@Override
	public boolean thereAreMemberWithOutEmpledCode() throws Exception {
		if (listMemberComunityManagerWithOuthEmployedCode==null)
			throw new Exception("The doc hasn't been loaded. ");
		
		return (listMemberComunityManagerWithOuthEmployedCode.size()!=0)?true:false;
	}

	@Override
	public List<Object> getListMemberDuplicate() throws Exception {
		if (listMemberComunityManagerWithOuthEmployedCode==null)
			throw new Exception("The doc hasn't been loaded. ");
		
		return (List) listMemberComunityManagerDuplicate;
	}


	@Override
	public List<Object> getListMemberWithOutEmpledCode() throws Exception {
		if (listMemberComunityManagerWithOuthEmployedCode==null)
			throw new Exception("The doc hasn't been loaded. ");
		
		return (List) listMemberComunityManagerWithOuthEmployedCode;
	}
	
	@Override
	public boolean thereAregetListMembertWhithOutCommunity() throws Exception {
		if (listMemberComunityManager==null)
			throw new Exception("The doc hasn't been loaded. ");
		
		return (getListMembertWithOutCommunity().size()!=0)?true:false;
	}
	
	@Override
	public List<Object> getListMembertWithOutCommunity() throws Exception {
		if (listMemberComunityManager==null)
			throw new Exception("The doc hasn't been loaded. ");
		
		List<Object> lMemerberWithOutCommunity = new ArrayList<Object>();
		Iterator<MemberCommunityManager> itr = listMemberComunityManager.iterator();
		
		while(itr.hasNext()) {
			MemberCommunityManager m = itr.next();
			if(m.getCategory()==null  ||m.getCategory().replace("\\s", "").equals("")){
				lMemerberWithOutCommunity.add(m);
			} 
		}
		return lMemerberWithOutCommunity;
	}
}
