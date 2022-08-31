package babel.compares.back.dao;

import java.io.File;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import babel.compares.back.dto.PersonDigitalCenters;

public class GFunctions {

	private final static Logger LOG = Logger.getLogger("babel.comares.back.dao.GFunctions"); 
	
	public static File loadFile(String file) {
		LOG.log(Level.INFO, "TRYING LOAD FILE: " + file);
		
		
		File f = new File(file);
		// System.out.println(txt.getAbsolutePath());
		/* Comprueba si existe el fichero aleer */
		if (!f.exists()) {
			LOG.log(Level.WARNING, "FILE NOT EXISTS");
			return null;
		} else {
			if (!f.isFile()) {
				LOG.log(Level.WARNING, "THIS IS NO FILE");
				return null;
			}

		}

		LOG.log(Level.WARNING, "FILE LOADED: " + f.getAbsolutePath());
		return f;

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
		return limpio.toLowerCase().trim();
	}

	public static String deleteMultipleSpace(String cadena) {

		return cadena.trim().replaceAll("( ){2,}", " ");

	}

	public static List<String> getListString(String value) {

		return Arrays.asList(value.replaceAll("( ){2,}", " ").replaceAll("[(,)(;)(.)(\n)]", "#@").split("(#@){1,10}"));
	}
	
	public static List<String> getListCodeString(String value) {

		return Arrays.asList(value.replaceAll("( ){2,}", " ").replaceAll("[(\\s)(,)(;)(.)(\n)]", "#@").split("(#@){1,10}"));
	}

	public static boolean getBoolean(String value) {
		if (value.toString().equalsIgnoreCase("si")) {
			return true;
		} else {
			return Boolean.parseBoolean(value.toString());
		}
	}
	
	public static List<Integer> getListInteger(String value){
		List<String> listCodeResponsableString = null;
		List<Integer> listCodeResponsableInteger = new ArrayList<Integer>();
		
		// Convertimos a lista de enteros + Elimina dos o mas espacios en blanco, y los
		// caracteres (,)(;)(.)(\\s)(#@), los consideramos una separacion entre responsables
		value = value.trim().replaceAll("( ){2,}", " ").replaceAll("[(,)(;)(.)(\\s)]", "#@");
		listCodeResponsableString = Arrays
				.asList(value.split("(#@){1,10}"));
		
		
		listCodeResponsableString.forEach((codResponsable) -> {
			listCodeResponsableInteger.add(Integer.parseInt(codResponsable));
		});
		
		return listCodeResponsableInteger;
	}
	
	public static List<Object> notContainsL2inL1(List<Object> l1,List<Object> l2) {
		 return (List) l2.stream().filter(l->!l1.contains(l)).collect(Collectors.toList());
	}
	
	public static List<Object> getEmployedsCotiansInBothsLists(List<Object> l1,List<Object> l2){
		return (List) l1.stream().filter(l->l2.contains(l)).collect(Collectors.toList());
	}
	
	public static List<Object> joinList(List<Object> l1, List<Object> l2){
		List<Object> list = new ArrayList<Object>();
		addMemberToList(list,l1);
		addMemberToList(list,l2);
		//list.addAll(l2);
		//System.out.println(list);
		return list;
	}
	
	public static void addMemberToList(List<Object> l1,List<Object> l2) {
		l2.forEach(l->{
			l1.add(l);
		});
	}
	
	
	public static void showExcessInsufficent(List<PersonDigitalCenters> lMemberCommunityInPersonDigitalCenterLikeBack,
			List<PersonDigitalCenters> lMemberCommunityInPersonDigitalCenterOtherCommunity,
			List<PersonDigitalCenters> lPersonDigitalCenterOutMemberComunity,
			List<Object> lMemberCommunityOutPersonDigitalCenter,
			List<PersonDigitalCenters> lPersonDigitalCenterWithOutCommunity,
			String filterByComunity) {
		//Miembros de la comunidad que esta en el documento de Centro, en la comunidad dada
		System.out.println("\t- Members is in  "+filterByComunity+" community in Person Digital Center Doc: "+ lMemberCommunityInPersonDigitalCenterLikeBack.size());
		//Miembros de la comunidad que esta en el documento de Centro, en otra comunidad
		System.out.println("\t- Other community (not "+filterByComunity+"): "+lMemberCommunityInPersonDigitalCenterOtherCommunity.size());
		lMemberCommunityInPersonDigitalCenterOtherCommunity.forEach(System.out::println);
		//Miembros de la comunidad que no esta en el documento de Centro
		System.out.println("\t- Member Not find in Personal center digital: "+lMemberCommunityOutPersonDigitalCenter.size());
		lMemberCommunityOutPersonDigitalCenter.forEach(System.out::println);
		//Personas de centro que esta en la comunidad pero no el documento de Miembros de la comunidad (de responsables/publico)
		System.out.println("\t- People like \""+filterByComunity+ "\" but not find in Member Community: "+lPersonDigitalCenterOutMemberComunity.size());
		lPersonDigitalCenterOutMemberComunity.forEach(System.out::println);
		//Personas sin comunidad
		System.out.println("\t- People witouh community: "+lPersonDigitalCenterWithOutCommunity.size());
		lPersonDigitalCenterWithOutCommunity.forEach(System.out::println);

	}
	
	

	public static void showListWithMsg(List<Object> l,String msg){
		System.out.println(msg);
		l.stream().forEach(System.out::println);
	}
}
