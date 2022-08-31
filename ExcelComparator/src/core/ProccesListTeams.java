package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//import com.opencsv.CSVWriter;

import pjo.MemberTeams;

public class ProccesListTeams {
	private String patchDefault = "./src/resources/input/";
	private String nameListTeamsTXT = "listaMiembremosTeams.txt";
	private String nameListTeamsCSV = "Comunidad_Desarrollo_Backend.csv";
	public static String INPUTFILE;
	public static String OUTPUTFILE;
	
	private static File doc = null;
	private final static Logger LOG = Logger.getLogger("core.ProccesListTeams");

	public ProccesListTeams() {
		this.INPUTFILE = patchDefault+this.nameListTeamsTXT;
		this.OUTPUTFILE = this.patchDefault+"excels/listaMiembros1.xls";
	}

	// Se recibe un fichero que no esta en la apliacion--
	// this.INPUTFILE="C:\\Users\\andres.rpenuela\\Downloads\\eclipse-jee-2022-03-R-win32-x86_64\\workspace\\ExcelComparator\\src\\resources\\input\\listaMiembremosTeams.txt";
	// this.OUTPUTFILE="C:\\Users\\andres.rpenuela\\Downloads\\eclipse-jee-2022-03-R-win32-x86_64\\workspace\\ExcelComparator\\src\\resources\\input\\excels\\listaMiembremosTeams.xls";
	public ProccesListTeams(String INPUTFILE,String OUTPUTFILE) {
		this.INPUTFILE = INPUTFILE;
		this.OUTPUTFILE = OUTPUTFILE;
	}

	public ProccesListTeams(String INPUTFILE) {
		this.INPUTFILE = INPUTFILE;
		this.OUTPUTFILE = this.patchDefault+"excels/listaMiembros2.xls";
	}
	/**/
	public String getOutPutFIle() {
		return this.OUTPUTFILE;
	}
	/**/
	public void listFilesDirDefault() {

		LOG.log(Level.INFO, "Listnado los elementos de: " + this.patchDefault+ " (hasta dos niveles)");

		///
		File path = new File(patchDefault);
		String[] nameFiles = path.list();
		
		System.out.println(this.patchDefault);
		for (int i = 0; i < nameFiles.length; i++) {
			//Elementos del patchDefault
			File element = new File(patchDefault+nameFiles[i]);
			if(element.isDirectory()) {
				//Elementos de patchDefault+subdirectorio
				System.out.println("\t|-"+nameFiles[i]+"/ (dir)");
				for (String subElement : element.list()) {
					
					File subelement = new File(patchDefault+nameFiles[i]+"/"+subElement);
					if(subelement.isDirectory()) {
						System.out.println("\t\t|-"+subElement+"/ (dir)");
					}else {
						System.out.println("\t\t|-"+subElement+" (file)");
					}
				}
			}else {
				//Elementos del patchDefault
				System.out.println("\t|-"+nameFiles[i]+ " (file)");
			}
		}

	}

	public void load() {
		LOG.log(Level.INFO, "TRYING LOAD FILE: " + this.INPUTFILE);

		listFilesDirDefault();

		/*Visualiza el centidio de la ruta por defecto: Da un detalle de hasta dos directorios */
		File txt = new File(this.INPUTFILE);
		
		/* Comprueba si existe el fichero aleer*/
		if (!txt.exists()) {
			LOG.log(Level.WARNING, "FILE NOT EXISTS");
			return;
		} else {
			if(!txt.isFile()) {
				LOG.log(Level.WARNING, "THIS IS NO FILE");
				return;
			}
			
		}
		
		LOG.log(Level.WARNING, "FILE LOADED: " + txt.getAbsolutePath());
		doc = txt;
	}
	
	public List<Object> read(Short type) {
		List<MemberTeams> listMembersTeams = null;
		load();
		if(doc==null)
			return null;
		
		/* Leemos el contenido del fichero */
		switch (type) {
		case 0:
			//Se lee un txt
			LOG.log(Level.WARNING, "READING THE FILE: " + this.doc.getName());
			try {
				listMembersTeams = (List)readTxt();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 1:
			//Se lee un csv
			LOG.log(Level.WARNING, "READING THE FILE: " + this.doc.getName());
			ProccesCSV CSV = new ProccesCSV();
			
			try {
				listMembersTeams = (List)CSV.readCSV(this.INPUTFILE);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
		
		return (List) listMembersTeams;
	}
	
	public List<Object> readTxt() throws IOException {

		//Fichero de entrada
		FileReader fr = null;
		BufferedReader br = null;
		
		//Lectura del fichero txt de entrada
		try {
	         // Apertura del fichero y creacion de BufferedReader para poder
	         // hacer una lectura comoda (disponer del metodo readLine()).
	         fr = new FileReader (doc);
	         br = new BufferedReader(fr);

	         // Lectura del fichero
	         //CONDICION DEL FICEHRO DE ENTRADA (ESTRUCUTRA DEL FICHERO ESPERADA):
	         //Linea 1: Imagen de perfil de José Antonio González Aguilar.
	         //Linea 2: José Antonio González Aguilar
	         //Linea 3: Software Engineer Back
	         //Linea 4: OFICINA VIRTUAL
	         //Se repite el patrón
	         String linea;
	         
	         List<MemberTeams> listMemberTeams = new ArrayList<MemberTeams>();
	         
	         while((linea=br.readLine())!=null) {
	        	 //System.out.println(linea.substring(0, 6));
	        	 // Aplicamos un filtro.
	        	MemberTeams memberTeams = new MemberTeams();
	        	if(!linea.equalsIgnoreCase("Miembro") && !linea.equals("Propietario")) {
		           	
	        		//Si leemos Imagen ..., la siguiente linea es el nombre, la siugiente la categoría y la siguiente la localicació7n
	        		if(linea.substring(0, 6).equalsIgnoreCase("Imagen")) {
	        			//Leemos el nombre
	        			memberTeams.setName(br.readLine());
	        			//System.out.println(memberTeams.getName());
		        		//Leemos la categoria
	        			memberTeams.setCategory(br.readLine());
	        			//System.out.println(memberTeams.getCategory());
	        			//Leemos la localicacion
	        			memberTeams.setLocalitation(br.readLine());
	        			//System.out.println(memberTeams.getLocalitation());
	        			
	        			//Guardamos el miembro ledio
	        			listMemberTeams.add(memberTeams);
	        		}
	        		
		           	//System.out.println(linea);
	        		//writer.writeNext(pais);
	        	}
	            
	         }
	         
	         //
	         LOG.log(Level.INFO, listMemberTeams.size()+" MEMBERS IN TEAMS READING " );
	         /*
	         for (MemberTeams memberTeams : listMemberTeams) {
				System.out.println(memberTeams);
			 }
			*/
	       //Generamos el fichero de salida
	        //ProccesExcels.writeExcel(OUTPUTFILE, (List)listMemberTeams,(short)0);
	         return (List)listMemberTeams;
		}
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         // En el finally cerramos el fichero, para asegurarnos
	         // que se cierra tanto si todo va bien como si salta 
	         // una excepcion.
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
		return null;
		  
	}
}
