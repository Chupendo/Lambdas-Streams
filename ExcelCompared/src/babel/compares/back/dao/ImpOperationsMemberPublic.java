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
import babel.compares.back.dto.PersonDigitalCenters;

public class ImpOperationsMemberPublic implements IOperacionsMemberCommunity {

	private static final String PATCHROOT = "src/resources/input/excels/";
	private static final String NAMEFILE = "Miembros de la comunidad.xlsx";
	private static String INPUTFILE;
	private static File doc = null;

	private final static Logger LOG = Logger.getLogger("babel.comares.back.dao.ImpOperationsManagerPublic");
	private static final int Collections = 0;

	Map<Integer, MemberCommunityPublic> mapMemberComunityPublic = null;
	List<MemberCommunityPublic> listMemberComunityPublic = null;
	List<MemberCommunityPublic> listMemberComunityPublicDuplicate = null;
	List<MemberCommunityPublic> listMemberComunityPublicWithOuthEmployedCode = null;

	public ImpOperationsMemberPublic() {
		this.INPUTFILE = this.PATCHROOT + this.NAMEFILE;
		mapMemberComunityPublic = new HashMap<Integer, MemberCommunityPublic>();
		listMemberComunityPublic = new ArrayList<MemberCommunityPublic>();
		listMemberComunityPublicDuplicate = new ArrayList<MemberCommunityPublic>();
		listMemberComunityPublicWithOuthEmployedCode = new ArrayList<MemberCommunityPublic>();
	}

	@Override
	public Map<Object, Object> readDoc(List<String> head) throws Exception {
		LOG.log(Level.INFO,"readDoc in run ... ");
		InputStream file;// Contained the stream in bytes of the file (Contiene la secuencia en bytes del
							// fichero)
		Workbook wb; // WorkBook (Libro de trabajo)
		Sheet sheet; // Sheet of WorkBook (Hoja del libro de trabajo)
		int iRow = 0, iCell = 0; // Determine the number of Row & Cell of the sheet to write (Determina el numero
									// de Fila y Columan de la hoja aescribir) Note: the number of row & cell start
									// by 0 (Nota: El nmero defila y columna empiza por 0)
		short sizeHead = (short) Constants.HEADERSMEMBERSCOMUNITYPUBLIC.size(); // Contained the number cell
		short withOutOrDuplicateEmployedCode = -1; // Employed Code for person who read without employed code
		Row row; // Row of the sheet (Fila de la hoja de estilos)
		Cell cell; // Cell of the sheet (Columna de la hoja de estilos)
		StringBuilder value;
		MemberCommunityPublic member = null;

		doc = GFunctions.loadFile(this.INPUTFILE);// Are Checked if exist the file and let's loader it (Se comprueba si
													// existe el archivo y lo cargamos)
		if (doc == null || !head.contains(Constants.HEADERSMEMBERSCOMUNITYPUBLIC.get(0))) {// No exist the file or head
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
				member = new MemberCommunityPublic();

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
							if (head.contains(Constants.HEADERSMEMBERSCOMUNITYPUBLIC.get((int) iCell))) {
								/*
								 * System.out.println("row: " + iRow + ",cell:" + iCell + ", field: " +
								 * Constants.HEADERSMEMBERSCOMUNITYMANAGER.get((int) iCell) + " value: " +
								 * value);
								 */
								/*
								 * Let's set the next fields (Seteamos los siguietnes campos:
								 * 
								 * Arrays.asList("codEmployed", "name", "office", "category", "rol", "level",
								 * "codeProject", "project", "codResponsable", "responsable", "technology",
								 * "certificiation", "low");
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
									// Set project code
									member.setCodeProject(GFunctions.getListCodeString(value.toString()));
									break;
								case 7:
									// Set project
									member.setProject(GFunctions.getListString(value.toString()));
									break;
								case 8:
									// Set responsable code
									member.setCodResponsable(GFunctions.getListInteger(value.toString()));
									break;
								case 9:
									// Set manager/responsable
									member.setResponsable(GFunctions.getListString(value.toString()));
									break;
								case 10:
									// Set technology
									member.setTechnology(GFunctions.getListString(value.toString()));
									break;
								case 11:
									// Set certification
									member.setCertification(GFunctions.getListString(value.toString()));
									break;
								case 12:
									// Set Low
									member.setLow(GFunctions.getBoolean(value.toString()));
									break;
								}

							}
						}
					}
					
					
					// mapMemberComunityPublic.add((MemberCommunityManager) member);
					iCell++;

				}
				
						
				if(member.getCodEmployed()!=null) {
					// System.err.println(member);
					// mapPersonDigitalCenter.put(member.getCodEmployed(), member);
					// listPersonDigitalCenter.add(member);
					if (mapMemberComunityPublic.containsKey(member.getCodEmployed())) {
						// Person with employed code duplied
						LOG.log(Level.WARNING, "This employed code " + member.getCodEmployed() + " is duplicate.");
						mapMemberComunityPublic.put((int) withOutOrDuplicateEmployedCode, member);
						listMemberComunityPublic.add(member);
						listMemberComunityPublicDuplicate.add(member);
						withOutOrDuplicateEmployedCode--;
					}else {
						mapMemberComunityPublic.put(member.getCodEmployed(), member);
						listMemberComunityPublic.add(member);
					}
					
				}else {
					// Person without employed code
					if (member.getCodEmployed() == null && member.getName() != null) {
						LOG.log(Level.WARNING, "The employed "+member.getName()+" don't have a employed code");
						//System.out.println("Person without employed code >> " + member);
						mapMemberComunityPublic.put((int) withOutOrDuplicateEmployedCode, member);
						listMemberComunityPublic.add(member);
						listMemberComunityPublicWithOuthEmployedCode.add(member);
						withOutOrDuplicateEmployedCode--;
					}
				}
				// Nueva fila
				iRow++;
				row = sheet.getRow(iRow);

			}
			// System.out.println(mapMemberComunityPublic);
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

		return (Map) mapMemberComunityPublic;
	}

	@Override
	public List<Object> MapToList(List<String> head) throws Exception {

		// TODO Auto-generated method stub
		if (this.mapMemberComunityPublic == null || this.mapMemberComunityPublic.isEmpty()) {
			this.readDoc(head);
			this.MapToList(head);
		}

		// mapMemberComunityPublic

		/*
		 * for(Integer key: mapMemberComunityPublic.keySet()) {
		 * listMemberComunityPublic.add(mapMemberComunityPublic.get(key)); }
		 * 
		 * return (List) listMemberComunityPublic;
		 */
		Collection<MemberCommunityPublic> values = mapMemberComunityPublic.values();
		return values.stream().collect(Collectors.toList());
	}

	public List<String> getListName() throws Exception {
		if (this.mapMemberComunityPublic == null || this.mapMemberComunityPublic.isEmpty()) {
			throw new Exception("The doc is not load");
		}
		/*
		 * System.out.println(mapMemberComunityPublic.entrySet().stream().filter(m ->
		 * m.getValue().getName() != null)
		 * .map(Map.Entry::getValue).collect(Collectors.toList()).stream().map(
		 * MemberCommunityManager::getName) .collect(Collectors.toList()));
		 */
		return mapMemberComunityPublic.entrySet().stream().filter(m -> m.getValue().getName() != null)
				.map(Map.Entry::getValue).collect(Collectors.toList()).stream().map(MemberCommunityPublic::getName)
				.collect(Collectors.toList());
	}

	public List<Integer> getListKey() throws Exception {
		if (this.mapMemberComunityPublic == null || this.mapMemberComunityPublic.isEmpty()) {
			throw new Exception("The doc is not load");
		}
		return mapMemberComunityPublic.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());
	}

	public List<Object> getListValues() throws Exception {
		if (this.mapMemberComunityPublic == null || this.mapMemberComunityPublic.isEmpty()) {
			throw new Exception("The doc is not load");
		}
		return mapMemberComunityPublic.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
	}

	public Object getMemberByEmployedCode(Integer key) throws Exception {
		if (this.mapMemberComunityPublic == null || this.mapMemberComunityPublic.isEmpty()) {
			throw new Exception("The doc is not load");
		}
		return (mapMemberComunityPublic.containsKey(key)) ? mapMemberComunityPublic.get(key) : null;
	}

	/**
	 * TOMAR COMO EJEMPLO PARA DOCUMENTAR EN JAVADOC Returns <tt>true</tt> if this
	 * list contains the specified element. More formally, returns <tt>true</tt> if
	 * and only if this list contains at least one element <tt>e</tt> such that
	 * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
	 *
	 * @param o element whose presence in this list is to be tested
	 * @return <tt>true</tt> if this list contains the specified element
	 * @throws ClassCastException   if the type of the specified element is
	 *                              incompatible with this list (<a href=
	 *                              "Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if the specified element is null and this list
	 *                              does not permit null elements (<a href=
	 *                              "Collection.html#optional-restrictions">optional</a>)
	 */
	public List<Object> getListMemberByEmployedCode(List<Integer> listKey) throws Exception {
		List<MemberCommunityPublic> listMemberPublicFind = new ArrayList<MemberCommunityPublic>();
		if (this.mapMemberComunityPublic == null || this.mapMemberComunityPublic.isEmpty()) {
			throw new Exception("The doc is not load");
		}

		listKey.stream().forEach(key -> {
			try {
				Object result = getMemberByEmployedCode(key);
				if(result!=null)
					listMemberPublicFind.add((MemberCommunityPublic) result);
			} catch (Exception e) {
				System.err.println("Couldn't get the list of the member for " + e);
				// e.printStackTrace();
			}
		});

		if (listMemberPublicFind.isEmpty())
			return null;

		return (List) listMemberPublicFind;

	}

	public List<Object> getListMember() throws Exception {
		if (this.mapMemberComunityPublic == null || this.mapMemberComunityPublic.isEmpty()) {
			throw new Exception("The doc is not load");
		}
		//Collection<MemberCommunityPublic> values = mapMemberComunityPublic.values();
		//listMemberComunityPublic = (List) values.stream().collect(Collectors.toList());
		return (List) listMemberComunityPublic;

	}

	@Override
	public boolean thereAreDuplicates() throws Exception {
		if (listMemberComunityPublicDuplicate==null)
			throw new Exception("The doc hasn't been loaded. ");
		
		return (listMemberComunityPublicDuplicate.size()!=0)?true:false;
	}

	@Override
	public boolean thereAreMemberWithOutEmpledCode() throws Exception {
		if (listMemberComunityPublicWithOuthEmployedCode==null)
			throw new Exception("The doc hasn't been loaded. ");
		
		return (listMemberComunityPublicWithOuthEmployedCode.size()!=0)?true:false;
	}

	@Override
	public List<Object> getListMemberDuplicate() throws Exception {
		if (listMemberComunityPublicDuplicate==null)
			throw new Exception("The doc hasn't been loaded. ");
		return (List) listMemberComunityPublicDuplicate;
	}


	@Override
	public List<Object> getListMemberWithOutEmpledCode() throws Exception {
		if (listMemberComunityPublicDuplicate==null)
			throw new Exception("The doc hasn't been loaded. ");
		return (List) listMemberComunityPublicWithOuthEmployedCode;
	}
	
	@Override
	public boolean thereAregetListMembertWhithOutCommunity() throws Exception {
		if (listMemberComunityPublic==null)
			throw new Exception("The doc hasn't been loaded. ");
		
		return (getListMembertWithOutCommunity().size()!=0)?true:false;
	}
	
	@Override
	public List<Object> getListMembertWithOutCommunity() throws Exception {
		if (listMemberComunityPublic==null)
			throw new Exception("The doc hasn't been loaded. ");
		
		List<Object> lMemerberWithOutCommunity = new ArrayList<Object>();
		Iterator<MemberCommunityPublic> itr = listMemberComunityPublic.iterator();
		
		while(itr.hasNext()) {
			MemberCommunityPublic m = itr.next();
			if(m.getCategory()==null || m.getCategory().replace("\\s", "").equals("")){
				lMemerberWithOutCommunity.add(m);
			} 
		}
		return lMemerberWithOutCommunity;
	}
}
