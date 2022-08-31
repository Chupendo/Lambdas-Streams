package babel.compares.back.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import babel.compares.back.constants.Constants;
import babel.compares.back.dto.MemberCommunity;
import babel.compares.back.dto.MemberCommunityManager;
import babel.compares.back.dto.MemberCommunityPublic;
import babel.compares.back.dto.PersonDigitalCenters;

public class PersonComparativesFuntions {
	/**
	 * comparativeMemberComunitinyAllFields() Devuelve una lista con los miembros de
	 * comunidad del documento de responsables/publico que se ha detectado algún campo que
	 * no coincinde con él mismo en el documento de centros.
	 * 
	 * Utiliza para comparar el metodo equal de la clase, y compara los siguientes
	 * campos: 
	 * 
	 * 	- Campos comunes Doc deComunidad de Responsables con el Doc de Centros:
	 * 		- fecha de incorporacion, nº empleado, nombre, oficina, comunidad tecnologíaca (categoria), rol, nivel,tarifa, becario
	 * 	-Campos comunes Doc deComunidad de Responsables con el Doc de Centros:
	 * 		- nº empleado, nombre, oficina, comunidad tecnologíaca (categoria), rol, nivel
	 * 
	 * @param l1 List<MemberCommunityManager>,List<MemberCommunityPublic> Lista de miembros del documento de
	 *           comunidad de responsables, Lista de miembros del documento de comunidad público
	 * @param l2 List<PersonDigitalCenters> Lista de personas del documenot de centros
	 * @return
	 * @throws Exception
	 */
	public static List<Object> comparativePersonComunitinyAllFields(List<Object> l1, List<Object> l2)
			throws ClassCastException {
		
		if (l1.size() == 0 || l2.size() == 0)
			throw new IndexOutOfBoundsException("Error, the size of the one or both lists haven't defined");
		if (!(l1.get(0) instanceof MemberCommunityManager) && !(l1.get(0) instanceof MemberCommunityPublic) || !(l2.get(0) instanceof PersonDigitalCenters))
			throw new ClassCastException("Error, the type of list don't define corretly");

		int cover = l1.size();
		if(l1.size()>l2.size()){
			cover = l2.size();
		}
		
		List<Object> resul1 = new ArrayList();
		for (int i = 0; i < cover; i++) {
			// System.out.println( l1.get(i).equals(l2.get(i)));
			if (!l1.get(i).equals(l2.get(i))) {
				resul1.add(l1.get(i));
			}
		}
		

		System.out.println(resul1.size() + " miembros con diferencias");
		resul1.forEach(f -> {
			System.out.println(f);
		});
		return resul1;
	}

	/**
	 * comparativeMemberComunitinyByName() Devuelve una lista con los miembros de
	 * comunidad del documento de responsables/público que se ha detectado con el campo
	 * "name" no coincinde con el mismo en el documento de centros 
	 * 
	 * Utiliza para comparar el metodo equal de la clase, y compara los siguientes
	 * campos: - name
	 * 
	 * @param l1 List<MemberCommunityManager>,List<MemberCommunityPublic> Lista de miembros del documento de
	 *           comunidad de responsables, Lista de miembros del documento de comunidad público
	 * @param l2 List<PersonDigitalCenters> Lista de miembros (personas) en del documento de centros
	 * @return
	 * @throws Exception
	 * 
	 * @throws NullPointerException if the field of one or both list is null (si el
	 *                              campo de una o ambas listas es nulo)
	 */
	public static List<Object> comparativeMemberComunitinyByName(List<Object> l1, List<Object> l2)
			throws ClassCastException, NullPointerException {
		if (l1.size() == 0 || l2.size() == 0)
			throw new IndexOutOfBoundsException("Error, the size of the one or both lists haven't defined");
		if (!(l1.get(0) instanceof MemberCommunityManager) && !(l1.get(0) instanceof MemberCommunityPublic) || !(l2.get(0) instanceof PersonDigitalCenters))
			throw new ClassCastException("Error, the type of list don't define corretly");

		final boolean isManager = (l1.get(0) instanceof MemberCommunityManager)?true:false;
		int limitA,limitB;
		List<Object> resul1 = new ArrayList();
		
		try {
			if(l1.size()>l2.size()){
				limitA = l1.size();
				limitB = l2.size();
				//Compara la lista mayor con la lista menor
				for(int i=0;i<limitA;i++) {//Lista de miembros mayor que lista de personas
					int j=0;
					do{
						PersonDigitalCenters p = (PersonDigitalCenters) l2.get(j);
						if(isManager) {
							MemberCommunityManager m = (MemberCommunityManager) l1.get(i);
							if( m.getCodEmployed()!=null && p.getCodEmployed()!=null &&(m.getCodEmployed().equals(p.getCodEmployed())) ) {
								if( (m.getName()==null && p.getName()!=null) || (m.getName()!=null && p.getName()==null) || !(m.getName().equals(p.getName()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getName()+","+p.getName()+"]");
									resul1.add(m);
									j=limitB;
								}
							}
						}else {
							MemberCommunityPublic m = (MemberCommunityPublic) l1.get(i);
							if( m.getCodEmployed()!=null && p.getCodEmployed()!=null &&(m.getCodEmployed().equals(p.getCodEmployed())) ) {
								if( (m.getName()==null && p.getName()!=null) || (m.getName()!=null && p.getName()==null) || !(m.getName().equals(p.getName()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getName()+","+p.getName()+"]");
									resul1.add(m);
									j=limitB;
								}
							}
						}
						j++;
					
					}while(j<limitB);
				}
				
				
			}else {//Lista de personas mayor que lista de miembros
				limitA = l2.size();
				limitB = l1.size();

				//Compara la lista mayor con la lista menor
				for(int i=0;i<limitA;i++) {
					int j=0;
					PersonDigitalCenters p = (PersonDigitalCenters) l2.get(i);
					do{
						if(isManager) {
							MemberCommunityManager m = (MemberCommunityManager) l1.get(j);
							if( m.getCodEmployed()!=null && p.getCodEmployed()!=null &&(m.getCodEmployed().equals(p.getCodEmployed())) ) {
								if( (m.getName()==null && p.getName()!=null) || (m.getName()!=null && p.getName()==null) || !(m.getName().equals(p.getName()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getName()+","+p.getName()+"]");
									resul1.add(m);
									j=limitB;
								}
							}
						}else {
							MemberCommunityPublic m = (MemberCommunityPublic) l1.get(j);
							if( m.getCodEmployed()!=null && p.getCodEmployed()!=null &&(m.getCodEmployed().equals(p.getCodEmployed())) ) {
								if( (m.getName()==null && p.getName()!=null) || (m.getName()!=null && p.getName()==null) || !(m.getName().equals(p.getName()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getName()+","+p.getName()+"]");
									resul1.add(m);
									j=limitB;
								}
							}
						}
						j++;
					
					}while(j<limitB);
				}
			}

			System.out.println(resul1.size() + " miembros con diferencias en el campo 'nombre'.");
			resul1.forEach(f -> {
				System.out.println(f);
			});
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resul1;
	}
	
	/**
	 * comparativeMemberComunitinyByOffice() Devuelve una lista con los miembros de
	 * comunidad del documento de responsables/público que se ha detectado con el campo
	 * "office" no coincinde con el mismo en el documento de centros 
	 * 
	 * Utiliza para comparar el metodo equal de la clase, y compara los siguientes
	 * campos: - office
	 * 
	 * @param l1 List<MemberCommunityManager>,List<MemberCommunityPublic> Lista de miembros del documento de
	 *           comunidad de responsables, Lista de miembros del documento de comunidad público
	 * @param l2 List<PersonDigitalCenters> Lista de miembros (personas) en del documento de centros
	 * @return
	 * @throws Exception
	 * 
	 * @throws NullPointerException if the field of one or both list is null (si el
	 *                              campo de una o ambas listas es nulo)
	 */
	public static List<Object> comparativeMemberComunitinyByOffice(List<Object> l1, List<Object> l2)
			throws ClassCastException, NullPointerException {
		if (l1.size() == 0 || l2.size() == 0)
			throw new IndexOutOfBoundsException("Error, the size of the one or both lists haven't defined");
		if (!(l1.get(0) instanceof MemberCommunityManager) && !(l1.get(0) instanceof MemberCommunityPublic) || !(l2.get(0) instanceof PersonDigitalCenters))
			throw new ClassCastException("Error, the type of list don't define corretly");

		final boolean isManager = (l1.get(0) instanceof MemberCommunityManager)?true:false;
		int limitA,limitB;
		List<Object> resul1 = new ArrayList();
		
		try {
			if(l1.size()>l2.size()){//Lista de miembros mayor que lista de personas
				limitA = l1.size();
				limitB = l2.size();
				//Compara la lista mayor con la lista menor
				for(int i=0;i<limitA;i++) {
					int j=0;
					
					do{
						PersonDigitalCenters p = (PersonDigitalCenters) l2.get(j);
						
						if(isManager) {
							MemberCommunityManager m = (MemberCommunityManager) l1.get(i);
							if( m.getCodEmployed()!=null && p.getCodEmployed()!=null &&(m.getCodEmployed().equals(p.getCodEmployed())) ) {
								if( (m.getOffice()==null && p.getOffice()!=null) || (m.getOffice()!=null && p.getOffice()==null) || !(m.getOffice().equals(p.getOffice()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getOffice()+","+p.getOffice()+"]");
									resul1.add(m);
									j=limitB;
								}
							}
						}else {
							MemberCommunityPublic m = (MemberCommunityPublic) l1.get(i);
							if( m.getCodEmployed()!=null && p.getCodEmployed()!=null &&(m.getCodEmployed().equals(p.getCodEmployed())) ) {
								if( (m.getOffice()==null && p.getOffice()!=null) || (m.getOffice()!=null && p.getOffice()==null) || !(m.getOffice().equals(p.getOffice()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getOffice()+","+p.getOffice()+"]");
									resul1.add(m);
									j=limitB;
								}
							}
						}
						j++;
					
					}while(j<limitB);
				}
				
				
			}else {///Lista de personas mayor que lista de miembros
				limitA = l2.size();
				limitB = l1.size();

				//Compara la lista mayor con la lista menor
				for(int i=0;i<limitA;i++) {
					int j=0;
					PersonDigitalCenters p = (PersonDigitalCenters) l2.get(i);
					do{
						if(isManager) {
							MemberCommunityManager m = (MemberCommunityManager) l1.get(j);
							if( m.getCodEmployed()!=null && p.getCodEmployed()!=null &&(m.getCodEmployed().equals(p.getCodEmployed())) ) {
								if( (m.getOffice()==null && p.getOffice()!=null) || (m.getOffice()!=null && p.getOffice()==null) || !(m.getOffice().equals(p.getOffice()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getOffice()+","+p.getOffice()+"]");
									resul1.add(m);
									j=limitB;
								}
							}
						}else {
							MemberCommunityPublic m = (MemberCommunityPublic) l1.get(j);
							if( m.getCodEmployed()!=null && p.getCodEmployed()!=null &&(m.getCodEmployed().equals(p.getCodEmployed())) ) {
								if( (m.getOffice()==null && p.getOffice()!=null) || (m.getOffice()!=null && p.getOffice()==null) || !(m.getOffice().equals(p.getOffice()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getOffice()+","+p.getOffice()+"]");
									resul1.add(m);
									j=limitB;
								}
							}
						}
						j++;
					
					}while(j<limitB);
				}
			}

			System.out.println(resul1.size() + " miembros con diferencias en el campo 'office'.");
			resul1.forEach(f -> {
				System.out.println(f);
			});
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resul1;
	}

	/**
	 * comparativeMemberComunitinyByCategory() Devuelve una lista con los miembros de
	 * comunidad del documento de responsables/público que se ha detectado con el campo
	 * "category/technology community" no coincinde con el mismo en el documento de centros 
	 * 
	 * Utiliza para comparar el metodo equal de la clase, y compara los siguientes
	 * campos: - category/technology community
	 * 
	 * @param l1 List<MemberCommunityManager>,List<MemberCommunityPublic> Lista de miembros del documento de
	 *           comunidad de responsables, Lista de miembros del documento de comunidad público
	 * @param l2 List<PersonDigitalCenters> Lista de miembros (personas) en del documento de centros
	 * 
	 * @return <tt>List&lt;MemberCommunityManager&gt;</tt> wwith the members of the
	 *         managers documents who don't have the same value in the field
	 *         <b>category</b> in public document of member community (list con los
	 *         miembros del documenot de responsalbes los cuales no tiene el mis
	 *         valor en el campo "categoria" en el documento publico de la comunidad
	 *         de miembros)
	 * 
	 * @throws ClassCastException        if the type of the specified element is
	 *                                   incompatible (si el tipo de elemento
	 *                                   especificado es incompatible)
	 * 
	 * @throws IndexOutOfBoundsException if the size of one or both list are 0 (si
	 *                                   el tamaño de una lista o ambas es 0)
	 *
	 * @throws NullPointerException      if the field of one or both list is null
	 *                                   (si el campo de una o ambas listas es nulo)
	 */
	public static List<Object> comparativeMemberComunitinyByCategory(List<Object> l1, List<Object> l2,String filterCommunity)
			throws ClassCastException, IndexOutOfBoundsException, NullPointerException {
		if (l1.size() == 0 || l2.size() == 0)
			throw new IndexOutOfBoundsException("Error, the size of the one or both lists haven't defined");
		if (!(l1.get(0) instanceof MemberCommunityManager) && !(l1.get(0) instanceof MemberCommunityPublic) || !(l2.get(0) instanceof PersonDigitalCenters))
			throw new ClassCastException("Error, the type of list don't define corretly");

		final boolean isManager = (l1.get(0) instanceof MemberCommunityManager)?true:false;
		int limitA,limitB;
		List<Object> resul1 = new ArrayList();
		
		try {
			if(l1.size()>l2.size()){//Lista de miembros mayor que lista de personas
				limitA = l1.size();
				limitB = l2.size();
				//Compara la lista mayor con la lista menor
				for(int i=0;i<limitA;i++) {
					int j=0;
					
					do{
						PersonDigitalCenters p = (PersonDigitalCenters) l2.get(j);
						
						if(isManager) {
							MemberCommunityManager m = (MemberCommunityManager) l1.get(i);
							if( m.getCodEmployed()!=null && p.getCodEmployed()!=null &&(m.getCodEmployed().equals(p.getCodEmployed())) ) {
								if( (m.getCategory()==null && p.getTechnologyComunity()!=null) || (m.getCategory()!=null && p.getTechnologyComunity()==null) || !(m.getCategory().equals(p.getTechnologyComunity()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getCategory()+","+p.getTechnologyComunity()+"]");
									resul1.add(m);
									j=limitB;
								}
							}
						}else {
							MemberCommunityPublic m = (MemberCommunityPublic) l1.get(i);
							if( m.getCodEmployed()!=null && p.getCodEmployed()!=null &&(m.getCodEmployed().equals(p.getCodEmployed())) ) {
								if( (m.getCategory()==null && p.getTechnologyComunity()!=null) || (m.getCategory()!=null && p.getTechnologyComunity()==null) || !(m.getCategory().equals(p.getTechnologyComunity()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getCategory()+","+p.getTechnologyComunity()+"]");
									resul1.add(m);
									j=limitB;
								}
							}
						}
						j++;
					
					}while(j<limitB);
				}
				
				
			}else {///Lista de personas mayor que lista de miembros
				limitA = l2.size();
				limitB = l1.size();

				//Compara la lista mayor con la lista menor
				for(int i=0;i<limitA;i++) {
					int j=0;
					PersonDigitalCenters p = (PersonDigitalCenters) l2.get(i);
					do{
						if(isManager) {
							MemberCommunityManager m = (MemberCommunityManager) l1.get(j);
							if( m.getCodEmployed()!=null && p.getCodEmployed()!=null &&(m.getCodEmployed().equals(p.getCodEmployed())) ) {
								if( (m.getCategory()==null && p.getTechnologyComunity()!=null) || (m.getCategory()!=null && p.getTechnologyComunity()==null) || !(m.getCategory().equals(p.getTechnologyComunity()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getCategory()+","+p.getTechnologyComunity()+"]");
									resul1.add(m);
									j=limitB;
								}
							}
						}else {
							MemberCommunityPublic m = (MemberCommunityPublic) l1.get(j);
							if( m.getCodEmployed()!=null && p.getCodEmployed()!=null &&(m.getCodEmployed().equals(p.getCodEmployed())) ) {
								if( (m.getCategory()==null && p.getTechnologyComunity()!=null) || (m.getCategory()!=null && p.getTechnologyComunity()==null) || !(m.getCategory().equals(p.getTechnologyComunity()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getCategory()+","+p.getTechnologyComunity()+"]");
									resul1.add(m);
									j=limitB;
								}
							}
						}
						j++;
					
					}while(j<limitB);
				}
			}

			System.out.println(resul1.size() + " miembros con diferencias en el campo 'category/technology community' distinto a '"+filterCommunity+"' en el documento de Centros.");
			resul1.forEach(f -> {
				System.out.println(f);
			});
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resul1;
	}

	/**
	 * comparativeMemberComunitinyByRol() Devuelve una lista con los miembros de
	 * comunidad del documento de responsables/público que se ha detectado con el campo
	 * "rol" no coincinde con el mismo en el documento de centros 
	 * 
	 * Utiliza para comparar el metodo equal de la clase, y compara los siguientes
	 * campos: - rol
	 * 
	 * @param l1 List<MemberCommunityManager>,List<MemberCommunityPublic> Lista de miembros del documento de
	 *           comunidad de responsables, Lista de miembros del documento de comunidad público
	 * @param l2 List<PersonDigitalCenters> Lista de miembros (personas) en del documento de centros
	 * 
	 * @return <tt>List&lt;MemberCommunityManager&gt;</tt> wwith the members of the
	 *         managers documents who don't have the same value in the field
	 *         <b>rol</b> in public document of member community (list con los
	 *         miembros del documenot de responsalbes los cuales no tiene el mis
	 *         valor en el campo "categoria" en el documento publico de la comunidad
	 *         de miembros)
	 * 
	 * @return <tt>List&lt;MemberCommunityManager&gt;</tt> wwith the members of the
	 *         managers documents who don't have the same value in the field
	 *         <b>rol</b> in public document of member community (list con los
	 *         miembros del documenot de responsalbes los cuales no tiene el mis
	 *         valor en el campo "rol" en el documento publico de la comunidad de
	 *         miembros)
	 * 
	 * @throws ClassCastException        if the type of the specified element is
	 *                                   incompatible (si el tipo de elemento
	 *                                   especificado es incompatible)
	 * 
	 * @throws IndexOutOfBoundsException if the size of one or both list are 0 (si
	 *                                   el tamaño de una lista o ambas es 0)
	 *
	 * @throws NullPointerException      if the field of one or both list is null
	 *                                   (si el campo de una o ambas listas es nulo)
	 */
	public static List<Object> comparativeMemberComunitinyByRol(List<Object> l1, List<Object> l2) {
		// Test the size of the lists (testea el tamaño de la listas)
		if (l1.size() == 0 || l2.size() == 0)
			throw new IndexOutOfBoundsException("Error, the size of the one or both lists haven't defined");
		if (!(l1.get(0) instanceof MemberCommunityManager) && !(l1.get(0) instanceof MemberCommunityPublic) || !(l2.get(0) instanceof PersonDigitalCenters))
			throw new ClassCastException("Error, the type of list don't define corretly");

		final boolean isManager = (l1.get(0) instanceof MemberCommunityManager)?true:false;
		int limitA,limitB;
		List<Object> resul1 = new ArrayList();
		
		try {
			if(l1.size()>l2.size()){//Lista de miembros mayor que lista de personas
				limitA = l1.size();
				limitB = l2.size();
				//Compara la lista mayor con la lista menor
				for(int i=0;i<limitA;i++) {
					int j=0;
					
					do{
						PersonDigitalCenters p = (PersonDigitalCenters) l2.get(j);
						
						if(isManager) {
							MemberCommunityManager m = (MemberCommunityManager) l1.get(i);
							if( m.getCodEmployed()!=null && p.getCodEmployed()!=null &&(m.getCodEmployed().equals(p.getCodEmployed())) ) {
								if( (m.getRol()==null && p.getRol()!=null) || (m.getRol()!=null && p.getRol()==null) || !(m.getRol().equals(p.getRol()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getRol()+","+p.getRol()+"]");
									resul1.add(m);
									j=limitB;
								}
							}
						}else {
							MemberCommunityPublic m = (MemberCommunityPublic) l1.get(i);
							if( m.getCodEmployed()!=null && p.getCodEmployed()!=null &&(m.getCodEmployed().equals(p.getCodEmployed())) ) {
								if( (m.getRol()==null && p.getRol()!=null) || (m.getRol()!=null && p.getRol()==null) || !(m.getRol().equals(p.getRol()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getRol()+","+p.getRol()+"]");
									resul1.add(m);
									j=limitB;
								}
							}
						}
						j++;
					
					}while(j<limitB);
				}
				
				
			}else {///Lista de personas mayor que lista de miembros
				limitA = l2.size();
				limitB = l1.size();

				//Compara la lista mayor con la lista menor
				for(int i=0;i<limitA;i++) {
					int j=0;
					PersonDigitalCenters p = (PersonDigitalCenters) l2.get(i);
					do{
						if(isManager) {
							MemberCommunityManager m = (MemberCommunityManager) l1.get(j);
							if( m.getCodEmployed()!=null && p.getCodEmployed()!=null &&(m.getCodEmployed().equals(p.getCodEmployed())) ) {
								if( (m.getRol()==null && p.getRol()!=null) || (m.getRol()!=null && p.getRol()==null) || !(m.getRol().equals(p.getRol()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getRol()+","+p.getRol()+"]");
									resul1.add(m);
									j=limitB;
								}
							}
						}else {
							MemberCommunityPublic m = (MemberCommunityPublic) l1.get(j);
							if( m.getCodEmployed()!=null && p.getCodEmployed()!=null &&(m.getCodEmployed().equals(p.getCodEmployed())) ) {
								if( (m.getRol()==null && p.getRol()!=null) || (m.getRol()!=null && p.getRol()==null) || !(m.getRol().equals(p.getRol()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getRol()+","+p.getRol()+"]");
									resul1.add(m);
									j=limitB;
								}
							}
						}
						j++;
					
					}while(j<limitB);
				}
			}

			System.out.println(resul1.size() + " miembros con diferencias en el campo 'rol'.");
			resul1.forEach(f -> {
				System.out.println(f);
			});
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resul1;		

	}

	/**
	 * comparativeMemberComunitinyByLevelD() Devuelve una lista con los miembros de
	 * comunidad del documento de responsables/público que se ha detectado con el campo
	 * "nivel dreyfus" no coincinde con el mismo en el documento de centros 
	 * 
	 * Utiliza para comparar el metodo equal de la clase, y compara los siguientes
	 * campos: - level
	 * 
	 * @param l1 List<MemberCommunityManager>,List<MemberCommunityPublic> Lista de miembros del documento de
	 *           comunidad de responsables, Lista de miembros del documento de comunidad público
	 * @param l2 List<PersonDigitalCenters> Lista de miembros (personas) en del documento de centros
	 * 
	 * @return <tt>List&lt;MemberCommunityManager&gt;</tt> wwith the members of the
	 *         managers documents who don't have the same value in the field
	 *         <b>level</b> in public document of member community (list con los
	 *         miembros del documenot de responsalbes los cuales no tiene el mis
	 *         valor en el campo "rol" en el documento publico de la comunidad de
	 *         miembros)
	 * 
	 * @throws ClassCastException        if the type of the specified element is
	 *                                   incompatible (si el tipo de elemento
	 *                                   especificado es incompatible)
	 * 
	 * @throws IndexOutOfBoundsException if the size of one or both list are 0 (si
	 *                                   el tamaño de una lista o ambas es 0)
	 *
	 * @throws NullPointerException      if the field of one or both list is null
	 *                                   (si el campo de una o ambas listas es nulo)
	 */
	public static List<Object> comparativeMemberComunitinyByLevelD(List<Object> l1, List<Object> l2) {
		if (l1.size() == 0 || l2.size() == 0)
			throw new IndexOutOfBoundsException("Error, the size of the one or both lists haven't defined");
		if (!(l1.get(0) instanceof MemberCommunityManager) && !(l1.get(0) instanceof MemberCommunityPublic) || !(l2.get(0) instanceof PersonDigitalCenters))
			throw new ClassCastException("Error, the type of list don't define corretly");

		final boolean isManager = (l1.get(0) instanceof MemberCommunityManager)?true:false;
		int limitA,limitB;
		List<Object> resul1 = new ArrayList();
		
		try {
			if(l1.size()>l2.size()){//Lista de miembros mayor que lista de personas
				limitA = l1.size();
				limitB = l2.size();
				//Compara la lista mayor con la lista menor
				for(int i=0;i<limitA;i++) {
					int j=0;
					
					do{
						PersonDigitalCenters p = (PersonDigitalCenters) l2.get(j);
						
						if(isManager) {
							MemberCommunityManager m = (MemberCommunityManager) l1.get(i);
							if( m.getCodEmployed()!=null && p.getCodEmployed()!=null &&(m.getCodEmployed().equals(p.getCodEmployed())) ) {
								if( (m.getLevel()==null && p.getDrefyfusLevel()!=null) || (m.getLevel()!=null && p.getDrefyfusLevel()==null) || !(m.getLevel().equals(p.getDrefyfusLevel()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getLevel()+","+p.getRol()+"]");
									resul1.add(m);
									j=limitB;
								}
							}
						}else {
							MemberCommunityPublic m = (MemberCommunityPublic) l1.get(i);
							if( m.getCodEmployed()!=null && p.getCodEmployed()!=null &&(m.getCodEmployed().equals(p.getCodEmployed())) ) {
								if( (m.getLevel()==null && p.getDrefyfusLevel()!=null) || (m.getLevel()!=null && p.getDrefyfusLevel()==null) || !(m.getLevel().equals(p.getDrefyfusLevel()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getLevel()+","+p.getRol()+"]");
									resul1.add(m);
									j=limitB;
								}
							}
						}
						j++;
					}while(j<limitB);
				}
				
				
			}else {///Lista de personas mayor que lista de miembros
				limitA = l2.size();
				limitB = l1.size();

				//Compara la lista mayor con la lista menor
				for(int i=0;i<limitA;i++) {
					int j=0;
					PersonDigitalCenters p = (PersonDigitalCenters) l2.get(i);
					do{
						if(isManager) {
							MemberCommunityManager m = (MemberCommunityManager) l1.get(j);
							if( m.getCodEmployed()!=null && p.getCodEmployed()!=null &&(m.getCodEmployed().equals(p.getCodEmployed())) ) {
								if( (m.getLevel()!=null || p.getDrefyfusLevel()!=null) && !(m.getLevel().equals(p.getDrefyfusLevel()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getLevel()+","+p.getDrefyfusLevel()+"]");
									resul1.add(m);
									j=limitB;
								}
							}
						}else {
							MemberCommunityPublic m = (MemberCommunityPublic) l1.get(j);
							if( m.getCodEmployed()!=null && p.getCodEmployed()!=null &&(m.getCodEmployed().equals(p.getCodEmployed())) ) {
								if( (m.getLevel()!=null || p.getDrefyfusLevel()!=null) && !(m.getLevel().equals(p.getDrefyfusLevel()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getLevel()+","+p.getDrefyfusLevel()+"]");
									resul1.add(m);
									j=limitB;
								}
							}
						}
						j++;
					
					}while(j<limitB);
				}
			}

			System.out.println(resul1.size() + " miembros con diferencias en el campo 'nivel dreyfus'.");
			resul1.forEach(f -> {
				System.out.println(f);
			});
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resul1;		

	}

	/**
	 * comparativeMemberComunitinyByRate() Devuelve una lista con los miembros de
	 * comunidad del documento de responsables/público que se ha detectado con el campo
	 * "tarifa" no coincinde con el mismo en el documento de centros 
	 * 
	 * Utiliza para comparar el metodo equal de la clase, y compara los siguientes
	 * campos: - rate
	 * 
	 * @param l1 List<MemberCommunityManager> Lista de miembros del documento de
	 *           comunidad de responsables, Lista de miembros del documento de comunidad público
	 * @param l2 List<PersonDigitalCenters> Lista de miembros (personas) en del documento de centros
	 * 
	 * @return <tt>List&lt;MemberCommunityManager&gt;</tt> wwith the members of the
	 *         managers documents who don't have the same value in the field
	 *         <b>rate</b> in public document of member community (list con los
	 *         miembros del documenot de responsalbes los cuales no tiene el mis
	 *         valor en el campo "rol" en el documento publico de la comunidad de
	 *         miembros)
	 * 
	 * @throws ClassCastException        if the type of the specified element is
	 *                                   incompatible (si el tipo de elemento
	 *                                   especificado es incompatible)
	 * 
	 * @throws IndexOutOfBoundsException if the size of one or both list are 0 (si
	 *                                   el tamaño de una lista o ambas es 0)
	 *
	 * @throws NullPointerException      if the field of one or both list is null
	 *                                   (si el campo de una o ambas listas es nulo)
	 */
	public static List<Object> comparativeMemberComunitinyByRate(List<Object> l1, List<Object> l2) {
		// Test the size of the lists (testea el tamaño de la listas)
				if (l1.size() == 0 || l2.size() == 0)
					throw new IndexOutOfBoundsException("Error, the size of the one or both lists haven't defined");
				if (!(l1.get(0) instanceof MemberCommunityManager) || !(l2.get(0) instanceof PersonDigitalCenters))
					throw new ClassCastException("Error, the type of list don't define corretly");

				int limitA,limitB;
				List<Object> resul1 = new ArrayList();
				
				try {
					if(l1.size()>l2.size()){//Lista de miembros mayor que lista de personas
						limitA = l1.size();
						limitB = l2.size();
						//Compara la lista mayor con la lista menor
						for(int i=0;i<limitA;i++) {
							int j=0;
							
							do{
								PersonDigitalCenters p = (PersonDigitalCenters) l2.get(j);

								MemberCommunityManager m = (MemberCommunityManager) l1.get(i);
								if( m.getCodEmployed()!=null && p.getCodEmployed()!=null &&(m.getCodEmployed().equals(p.getCodEmployed())) ) {
									if( m.getRate()!=p.getRate()) {
										//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getRate()+","+p.getRate()+"]");
										resul1.add(m);
										j=limitB;
									}
								}
								j++;
							
							}while(j<limitB);
						}
						
						
					}else {///Lista de personas mayor que lista de miembros
						limitA = l2.size();
						limitB = l1.size();

						//Compara la lista mayor con la lista menor
						for(int i=0;i<limitA;i++) {
							int j=0;
							PersonDigitalCenters p = (PersonDigitalCenters) l2.get(i);
							do{
								MemberCommunityManager m = (MemberCommunityManager) l1.get(j);
								if( m.getCodEmployed()!=null && p.getCodEmployed()!=null &&(m.getCodEmployed().equals(p.getCodEmployed())) ) {
									if( (m.getLevel()!=null || p.getDrefyfusLevel()!=null) && !(m.getLevel().equals(p.getDrefyfusLevel()))) {
										//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getLevel()+","+p.getDrefyfusLevel()+"]");
										resul1.add(m);
										j=limitB;
									}
								}
								j++;
							
							}while(j<limitB);
						}
					}

					System.out.println(resul1.size() + " miembros con diferencias en el campo 'rate'.");
					resul1.forEach(f -> {
						System.out.println(f);
					});
					
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return resul1;
		
	}

	
	/**
	 * comparativeMemberComunitinyByAdmissionDate() Devuelve una lista con los miembros de
	 * comunidad del documento de responsables/público que se ha detectado con el campo
	 * "fecha de incorporacion" no coincinde con el mismo en el documento de centros 
	 * 
	 * Utiliza para comparar el metodo equal de la clase, y compara los siguientes
	 * campos: - admisiondate
	 * 
	 * @param l1 List<MemberCommunityManager> Lista de miembros del documento de
	 *           comunidad de responsables, Lista de miembros del documento de comunidad público
	 * @param l2 List<PersonDigitalCenters> Lista de miembros (personas) en del documento de centros
	 * 
	 * @return <tt>List&lt;MemberCommunityManager&gt;</tt> wwith the members of the
	 *         managers documents who don't have the same value in the field
	 *         <b>admisionDate</b> in public document of member community (list con los
	 *         miembros del documenot de responsalbes los cuales no tiene el mis
	 *         valor en el campo "rol" en el documento publico de la comunidad de
	 *         miembros)
	 * 
	 * @throws ClassCastException        if the type of the specified element is
	 *                                   incompatible (si el tipo de elemento
	 *                                   especificado es incompatible)
	 * 
	 * @throws IndexOutOfBoundsException if the size of one or both list are 0 (si
	 *                                   el tamaño de una lista o ambas es 0)
	 *
	 * @throws NullPointerException      if the field of one or both list is null
	 *                                   (si el campo de una o ambas listas es nulo)
	 */
	public static List<Object> comparativeMemberComunitinyByAdmissionDate(List<Object> l1, List<Object> l2) {
		if (l1.size() == 0 || l2.size() == 0)
			throw new IndexOutOfBoundsException("Error, the size of the one or both lists haven't defined");
		if (!(l1.get(0) instanceof MemberCommunityManager) || !(l2.get(0) instanceof PersonDigitalCenters))
			throw new ClassCastException("Error, the type of list don't define corretly");

		final boolean isManager = (l1.get(0) instanceof MemberCommunityManager)?true:false;
		int limitA,limitB;
		List<Object> resul1 = new ArrayList();
		
		try {
			if(l1.size()>l2.size()){//Lista de miembros mayor que lista de personas
				limitA = l1.size();
				limitB = l2.size();
				//Compara la lista mayor con la lista menor
				for(int i=0;i<limitA;i++) {
					int j=0;
					
					do{
						PersonDigitalCenters p = (PersonDigitalCenters) l2.get(j);
						MemberCommunityManager m = (MemberCommunityManager) l1.get(i);
						if( m.getCodEmployed()!=null && p.getCodEmployed()!=null && (m.getCodEmployed().equals(p.getCodEmployed())) ) {
							if( m.getAdmisionDate()!=null && p.getAdmisionDate()!=null && !(m.getAdmisionDate().equals(p.getAdmisionDate()))) {
								//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getAdmisionDate()+","+p.getAdmisionDate()+"]");
								resul1.add(m);
								j=limitB;
							}
						}
						j++;
					}while(j<limitB);
				}
				
				
			}else {///Lista de personas mayor que lista de miembros
				limitA = l2.size();
				limitB = l1.size();

				//Compara la lista mayor con la lista menor
				for(int i=0;i<limitA;i++) {
					int j=0;
					PersonDigitalCenters p = (PersonDigitalCenters) l2.get(i);
					do{
						MemberCommunityManager m = (MemberCommunityManager) l1.get(j);
						if( m.getCodEmployed()!=null && p.getCodEmployed()!=null &&(m.getCodEmployed().equals(p.getCodEmployed())) ) {
							if( (m.getLevel()!=null || p.getDrefyfusLevel()!=null) && !(m.getLevel().equals(p.getDrefyfusLevel()))) {
								//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getLevel()+","+p.getDrefyfusLevel()+"]");
								resul1.add(m);
								j=limitB;
							}
						}
						j++;
					}while(j<limitB);
				}
			}

			System.out.println(resul1.size() + " miembros con diferencias en el campo 'admission date'.");
			resul1.forEach(f -> {
				System.out.println(f);
			});
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resul1;		
	}
	
	/**
	 * 
	 * Constante: FIELDCOMMONMEMBERSCOMUNITY List with the name of the fields are
	 * commons in both documents of members comunity, its containt next values
	 * FIELDCOMMONMEMBERSCOMUNITY = Arrays.asList("codEmployed", "name",
	 * "office","category", "rol", "level","codeProject", "project", "responsable",
	 * "technology","certificiation","low"); (ver file
	 * babel.compares.back.constants.Constants.FIELDCOMMONMEMBERSCOMUNITY)
	 * 
	 * @param l1
	 * @param l2
	 * @throws ClassCastException
	 * @throws IndexOutOfBoundsException
	 * @throws NullPointerException
	 */
	public static Map<Integer, List<String>> identifierFieldDifferences(List<Object> l1, List<Object> l2)
			throws ClassCastException, IndexOutOfBoundsException, NullPointerException {
		if (l1.size() == 0 || l2.size() == 0)
			throw new IndexOutOfBoundsException("Error, the size of the one or both lists haven't defined");
		if (!(l1.get(0) instanceof MemberCommunityManager) && !(l1.get(0) instanceof MemberCommunityPublic) || !(l2.get(0) instanceof PersonDigitalCenters))
			throw new ClassCastException("Error, the type of list don't define corretly");

		final boolean isManager = (l1.get(0) instanceof MemberCommunityManager)?true:false;
		int limitA,limitB;
		List<Object> resul1 = new ArrayList();
		List<String> lFieldCommon = Constants.FIELDCOMMONMEMBERSCOMUNITYWITHPERSON;
		Map<Integer, List<String>> mapResult = new HashMap<Integer, List<String>>();
		
		try {
			if(l1.size()>l2.size()){
				limitA = l1.size();
				limitB = l2.size();
				//Compara la lista mayor con la lista menor
				for(int i=0;i<limitA;i++) {//Lista de miembros mayor que lista de personas
					int j=0;
					List<String> listDifference = new ArrayList<String>();
					do{
						PersonDigitalCenters p = (PersonDigitalCenters) l2.get(j);
						if(isManager) {
							MemberCommunityManager m = (MemberCommunityManager) l1.get(i);
							if( m.getCodEmployed()!=null && p.getCodEmployed()!=null &&(m.getCodEmployed().equals(p.getCodEmployed())) ) {
								//name
								if(m.getName()==null) m.setName("");
								if(p.getName()==null) p.setName("");
								if( (m.getName()==null && p.getName()!=null) || (m.getName()!=null && p.getName()==null) || !(m.getName().equals(p.getName()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getName()+","+p.getName()+"]");
									listDifference.add(lFieldCommon.get(0));
									j=limitB;
								}
								//category or technology community
								if(m.getOffice()==null) m.setOffice("");
								if(p.getOffice()==null) p.setOffice("");
								if((m.getOffice()==null && p.getOffice()!=null) || (m.getOffice()!=null && p.getOffice()==null) || !(m.getOffice().equals(p.getOffice()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getOffice()+","+p.getOffice()+"]");
									listDifference.add(lFieldCommon.get(1));
									j=limitB;
								}
								//category or technology community
								if(m.getCategory()==null) m.setCategory("");
								if(p.getTechnologyComunity()==null) p.setTechnologyComunity("");
								if( (m.getCategory()==null && p.getTechnologyComunity()!=null) || (m.getCategory()!=null && p.getTechnologyComunity()==null) || !(m.getCategory().equals(p.getTechnologyComunity()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getCategory()+","+p.getTechnologyComunity()+"]");
									listDifference.add(lFieldCommon.get(2));
									j=limitB;
								}
								//rol
								if(m.getRol()==null) m.setRol("");
								if(p.getRol()==null) p.setRol("");
								if( (m.getRol()==null && p.getRol()!=null) || (m.getRol()!=null && p.getRol()==null) || !(m.getRol().equals(p.getRol()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getRol()+","+p.getRol()+"]");
									listDifference.add(lFieldCommon.get(3));
									j=limitB;
								}
								//nivel dreyfus
								if(m.getLevel()==null) m.setLevel("");
								if(p.getDrefyfusLevel()==null) p.setDrefyfusLevel("");
								if( (m.getLevel()==null && p.getDrefyfusLevel()!=null) || (m.getLevel()!=null && p.getDrefyfusLevel()==null) || !(m.getLevel().equals(p.getDrefyfusLevel()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getLevel()+","+p.getDrefyfusLevel()+"]");
									listDifference.add(lFieldCommon.get(4));
									j=limitB;
								}
								//rate
								if(p.getRate()==null) {p.setRate(0.0);}
								if( m.getRate()!= p.getRate()) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getRate()+","+p.getRate()+"]");
									listDifference.add(lFieldCommon.get(5));
									j=limitB;
								}
								//admission date
								if(m.getAdmisionDate()==null) m.setAdmisionDate("");
								if( (m.getAdmisionDate()==null && p.getAdmisionDate()!=null) || (m.getAdmisionDate()!=null && p.getAdmisionDate()==null) || !(m.getAdmisionDate().equals(p.getAdmisionDate()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getAdmisionDate()+","+p.getAdmisionDate()+"]");
									listDifference.add(lFieldCommon.get(6));
									j=limitB;
								}
							}
							//Adding the differencies find
							if(!listDifference.isEmpty()) {
								mapResult.put(m.getCodEmployed(), listDifference);
							}
						}else {
							MemberCommunityPublic m = (MemberCommunityPublic) l1.get(i);
							if( m.getCodEmployed()!=null && p.getCodEmployed()!=null &&(m.getCodEmployed().equals(p.getCodEmployed())) ) {
								//name
								if(m.getName()==null) m.setName("");
								if(p.getName()==null) p.setName("");
								if( (m.getName()==null && p.getName()!=null) || (m.getName()!=null && p.getName()==null) || !(m.getName().equals(p.getName()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getName()+","+p.getName()+"]");
									listDifference.add(lFieldCommon.get(0));
									j=limitB;
								}
								//category or technology community
								if(m.getOffice()==null) m.setOffice("");
								if(p.getOffice()==null) p.setOffice("");
								if((m.getOffice()==null && p.getOffice()!=null) || (m.getOffice()!=null && p.getOffice()==null) || !(m.getOffice().equals(p.getOffice()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getOffice()+","+p.getOffice()+"]");
									listDifference.add(lFieldCommon.get(1));
									j=limitB;
								}
								//category or technology community
								if(m.getCategory()==null) m.setCategory("");
								if(p.getTechnologyComunity()==null) p.setTechnologyComunity("");
								if( (m.getCategory()==null && p.getTechnologyComunity()!=null) || (m.getCategory()!=null && p.getTechnologyComunity()==null) || !(m.getCategory().equals(p.getTechnologyComunity()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getCategory()+","+p.getTechnologyComunity()+"]");
									listDifference.add(lFieldCommon.get(2));
									j=limitB;
								}
								//rol
								if(m.getRol()==null) m.setRol("");
								if(p.getRol()==null) p.setRol("");
								if( (m.getRol()==null && p.getRol()!=null) || (m.getRol()!=null && p.getRol()==null) || !(m.getRol().equals(p.getRol()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getRol()+","+p.getRol()+"]");
									listDifference.add(lFieldCommon.get(3));
									j=limitB;
								}
								//nivel dreyfus
								if(m.getLevel()==null) m.setLevel("");
								if(p.getDrefyfusLevel()==null) p.setDrefyfusLevel("");
								if( (m.getLevel()==null && p.getDrefyfusLevel()!=null) || (m.getLevel()!=null && p.getDrefyfusLevel()==null) || !(m.getLevel().equals(p.getDrefyfusLevel()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getLevel()+","+p.getDrefyfusLevel()+"]");
									listDifference.add(lFieldCommon.get(4));
									j=limitB;
								}
							}
							
							//Adding the differencies find
							if(!listDifference.isEmpty()) {
								mapResult.put(m.getCodEmployed(), listDifference);
							}
						}
						j++;
						
					}while(j<limitB);
				}
				
				
			}else {//Lista de personas mayor que lista de miembros
				limitA = l2.size();
				limitB = l1.size();
				
				//Compara la lista mayor con la lista menor
				for(int i=0;i<limitA;i++) {
					int j=0;
					List<String> listDifference = new ArrayList<String>();
					PersonDigitalCenters p = (PersonDigitalCenters) l2.get(i);
					do{
						if(isManager) {
							MemberCommunityManager m = (MemberCommunityManager) l1.get(j);
							if( m.getCodEmployed()!=null && p.getCodEmployed()!=null &&(m.getCodEmployed().equals(p.getCodEmployed())) ) {
								//name
								if(m.getName()==null) m.setName("");
								if(p.getName()==null) p.setName("");
								if( (m.getName()==null && p.getName()!=null) || (m.getName()!=null && p.getName()==null) || !(m.getName().equals(p.getName()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getName()+","+p.getName()+"]");
									listDifference.add(lFieldCommon.get(0));
									j=limitB;
								}
								//category or technology community
								if(m.getOffice()==null) m.setOffice("");
								if(p.getOffice()==null) p.setOffice("");
								if((m.getOffice()==null && p.getOffice()!=null) || (m.getOffice()!=null && p.getOffice()==null) || !(m.getOffice().equals(p.getOffice()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getOffice()+","+p.getOffice()+"]");
									listDifference.add(lFieldCommon.get(1));
									j=limitB;
								}
								//category or technology community
								if(m.getCategory()==null) m.setCategory("");
								if(p.getTechnologyComunity()==null) p.setTechnologyComunity("");
								if( (m.getCategory()==null && p.getTechnologyComunity()!=null) || (m.getCategory()!=null && p.getTechnologyComunity()==null) || !(m.getCategory().equals(p.getTechnologyComunity()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getCategory()+","+p.getTechnologyComunity()+"]");
									listDifference.add(lFieldCommon.get(2));
									j=limitB;
								}
								//rol
								if(m.getRol()==null) m.setRol("");
								if(p.getRol()==null) p.setRol("");
								if( (m.getRol()==null && p.getRol()!=null) || (m.getRol()!=null && p.getRol()==null) || !(m.getRol().equals(p.getRol()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getRol()+","+p.getRol()+"]");
									listDifference.add(lFieldCommon.get(3));
									j=limitB;
								}
								//nivel dreyfus
								if(m.getLevel()==null) m.setLevel("");
								if(p.getDrefyfusLevel()==null) p.setDrefyfusLevel("");
								if( (m.getLevel()==null && p.getDrefyfusLevel()!=null) || (m.getLevel()!=null && p.getDrefyfusLevel()==null) || !(m.getLevel().equals(p.getDrefyfusLevel()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getLevel()+","+p.getDrefyfusLevel()+"]");
									listDifference.add(lFieldCommon.get(4));
									j=limitB;
								}
								//rate
								if(p.getRate()==null) {p.setRate(0.0);}
								if( m.getRate()!= p.getRate()) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getRate()+","+p.getRate()+"]");
									listDifference.add(lFieldCommon.get(5));
									j=limitB;
								}
								//admission date
								if(m.getAdmisionDate()==null) m.setAdmisionDate("");
								if( (m.getAdmisionDate()==null && p.getAdmisionDate()!=null) || (m.getAdmisionDate()!=null && p.getAdmisionDate()==null) || !(m.getAdmisionDate().equals(p.getAdmisionDate()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getAdmisionDate()+","+p.getAdmisionDate()+"]");
									listDifference.add(lFieldCommon.get(6));
									j=limitB;
								}
							}
							//Adding the differencies find
							if(!listDifference.isEmpty()) {
								mapResult.put(m.getCodEmployed(), listDifference);
							}
						}else {
							MemberCommunityPublic m = (MemberCommunityPublic) l1.get(j);
							if( m.getCodEmployed()!=null && p.getCodEmployed()!=null &&(m.getCodEmployed().equals(p.getCodEmployed())) ) {
								//name
								if(m.getName()==null) m.setName("");
								if(p.getName()==null) p.setName("");
								if( (m.getName()==null && p.getName()!=null) || (m.getName()!=null && p.getName()==null) || !(m.getName().equals(p.getName()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getName()+","+p.getName()+"]");
									listDifference.add(lFieldCommon.get(0));
									j=limitB;
								}
								//category or technology community
								if(m.getOffice()==null) m.setOffice("");
								if(p.getOffice()==null) p.setOffice("");
								if((m.getOffice()==null && p.getOffice()!=null) || (m.getOffice()!=null && p.getOffice()==null) || !(m.getOffice().equals(p.getOffice()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getOffice()+","+p.getOffice()+"]");
									listDifference.add(lFieldCommon.get(1));
									j=limitB;
								}
								//category or technology community
								if(m.getCategory()==null) m.setCategory("");
								if(p.getTechnologyComunity()==null) p.setTechnologyComunity("");
								if( (m.getCategory()==null && p.getTechnologyComunity()!=null) || (m.getCategory()!=null && p.getTechnologyComunity()==null) || !(m.getCategory().equals(p.getTechnologyComunity()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getCategory()+","+p.getTechnologyComunity()+"]");
									listDifference.add(lFieldCommon.get(2));
									j=limitB;
								}
								//rol
								if(m.getRol()==null) m.setRol("");
								if(p.getRol()==null) p.setRol("");
								if( (m.getRol()==null && p.getRol()!=null) || (m.getRol()!=null && p.getRol()==null) || !(m.getRol().equals(p.getRol()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getRol()+","+p.getRol()+"]");
									listDifference.add(lFieldCommon.get(3));
									j=limitB;
								}
								//nivel dreyfus
								if(m.getLevel()==null) m.setLevel("");
								if(p.getDrefyfusLevel()==null) p.setDrefyfusLevel("");
								if( (m.getLevel()==null && p.getDrefyfusLevel()!=null) || (m.getLevel()!=null && p.getDrefyfusLevel()==null) || !(m.getLevel().equals(p.getDrefyfusLevel()))) {
									//System.out.println("[m,p] -- ["+m.getCodEmployed()+","+p.getCodEmployed()+"] -- "+"["+m.getLevel()+","+p.getDrefyfusLevel()+"]");
									listDifference.add(lFieldCommon.get(4));
									j=limitB;
								}
							}
							//Adding the differencies find
							if(!listDifference.isEmpty()) {
								mapResult.put(m.getCodEmployed(), listDifference);
							}
						}
						j++;
					
					}while(j<limitB);
				}
			}

			System.out.println(mapResult.size() + " miembros con diferencias encontradas.");
			System.out.println(mapResult);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mapResult;
		
	}

}
