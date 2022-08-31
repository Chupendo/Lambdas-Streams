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

public class CommunityComparativesFuntions {
	/**
	 * comparativeMemberComunitinyAllFields() Devuelve una lista con los miembros de
	 * comunidad del documento de responsables que se ha detectado algún campo que
	 * no coincinde con el mismo en el documento público.
	 * 
	 * Utiliza para comparar el metodo equal de la clase, y compara los siguientes
	 * campos: - nombre - categoria - rol - nivel d - codio de proyecto - proyecto -
	 * responsable - tecnología - certificaicón - baja
	 * 
	 * @param l1 List<MemberCommunityManager> Lista de miembros del documento de
	 *           comunidad de responsables
	 * @param l2 List<MemberCommunityPublic> Lista de miembros del documento de
	 *           comunidad público
	 * @return
	 * @throws Exception
	 */
	public static List<Object> comparativeMemberComunitinyAllFields(List<Object> l1, List<Object> l2)
			throws ClassCastException {
		if (l1.size() == 0 || l2.size() == 0)
			throw new IndexOutOfBoundsException("Error, the size of the one or both lists haven't defined");
		if (!(l1.get(0) instanceof MemberCommunityManager) || !(l2.get(0) instanceof MemberCommunityPublic))
			throw new ClassCastException("Error, the type of list don't define corretly");

		List<Object> resul1 = new ArrayList();
		for (int i = 0; i < l1.size(); i++) {
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
	 * comunidad del documento de responsables que se ha detectado con el campo
	 * "name" no coincinde con el mismo en el documento público.
	 * 
	 * Utiliza para comparar el metodo equal de la clase, y compara los siguientes
	 * campos: - name
	 * 
	 * @param l1 List<MemberCommunityManager> Lista de miembros del documento de
	 *           comunidad de responsables
	 * @param l2 List<MemberCommunityPublic> Lista de miembros del documento de
	 *           comunidad público
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
		if (!(l1.get(0) instanceof MemberCommunityManager) || !(l2.get(0) instanceof MemberCommunityPublic))
			throw new ClassCastException("Error, the type of list don't define corretly");
		List<Object> resul1 = new ArrayList();
		for (int i = 0; i < l1.size(); i++) {
			// System.out.println( l1.get(i).equals(l2.get(i)));

			if (!(((MemberCommunityManager) l1.get(i)).getName()
					.equals(((MemberCommunityPublic) l2.get(i)).getName()))) {
				// System.out.println("name of MemberCommunityManager (l1)>
				// "+((MemberCommunityManager) l1.get(i)).getName());
				// System.out.println("name of MemberCommunityPublic (l2)>
				// "+((MemberCommunityPublic) l2.get(i)).getName());
				resul1.add(l1.get(i));
			}
		}

		System.out.println(resul1.size() + " miembros con diferencias en el campo 'nombre'.");
		resul1.forEach(f -> {
			System.out.println(f);
		});
		return resul1;
	}

	/**
	 * comparativeMemberComunitinyByOffice() Devuelve una lista con los miembros de
	 * comunidad del documento de responsables que se ha detectado con el campo
	 * "office" no coincinde con el mismo en el documento público.
	 * 
	 * Utiliza para comparar el metodo equal de la clase, y compara los siguientes
	 * campos: - office
	 * 
	 * @param l1 List<MemberCommunityManager> Lista de miembros del documento de
	 *           comunidad de responsables
	 * @param l2 List<MemberCommunityPublic> Lista de miembros del documento de
	 *           comunidad público
	 * @return
	 * @throws Exception
	 */
	public static List<Object> comparativeMemberComunitinyByOffice(List<Object> l1, List<Object> l2)
			throws ClassCastException, IndexOutOfBoundsException, NullPointerException {
		if (l1.size() == 0 || l2.size() == 0)
			throw new IndexOutOfBoundsException("Error, the size of the one or both lists haven't defined");
		if (!(l1.get(0) instanceof MemberCommunityManager) || !(l2.get(0) instanceof MemberCommunityPublic))
			throw new ClassCastException("Error, the type of list don't define corretly");

		List<Object> resul1 = new ArrayList();
		for (int i = 0; i < l1.size(); i++) {
			// System.out.println( l1.get(i).equals(l2.get(i)));

			if (!(((MemberCommunityManager) l1.get(i)).getOffice())
					.equals(((MemberCommunityPublic) l2.get(i)).getOffice())) {
				// System.out.println("name of MemberCommunityManager (l1)>
				// "+((MemberCommunityManager) l1.get(i)).getName());
				// System.out.println("name of MemberCommunityPublic (l2)>
				// "+((MemberCommunityPublic) l2.get(i)).getName());
				resul1.add(l1.get(i));
			}
		}

		System.out.println(resul1.size() + " miembros con diferencias en el campo 'oficina'.");
		resul1.forEach(f -> {
			System.out.println(f);
		});
		return resul1;
	}

	/**
	 * comparativeMemberComunitinyByCategory() Returns
	 * <tt>List&lt;MemberCommunityManager&gt;</tt> with the members of the manager
	 * document who have the field "category" a value diferrent with themself but of
	 * the public document of the members community
	 * 
	 * Retorna <tt>List&lt;MemberCommunityManager&gt;</tt> con los miembros del
	 * documento gestor que tienen el campo "categoría" un valor diferente a sí
	 * mismos pero del documento público de la comunidad miembros
	 * 
	 * 
	 * @param l1 <code>List&lt;MemberCommunityManager&gt;</code> list with the
	 *           members of the manager document of the members communitys who are
	 *           in public document (lista con los miembros del documento de
	 *           respoanbles de la comunidad de miembros comunes con el documento
	 *           publcio)
	 * 
	 * @param l2 <code>List&lt;MemberCommunityPublic&gt;</code> list with the
	 *           members in the public document of the members communitys who are in
	 *           manager document (lista con los miembros del documento publico de
	 *           la comunidad de miembors comunes con el documento de responsalbes)
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
	public static List<Object> comparativeMemberComunitinyByCategory(List<Object> l1, List<Object> l2)
			throws ClassCastException, IndexOutOfBoundsException, NullPointerException {
		// Test the size of the lists (testea el tamaño de la listas)
		if (l1.size() == 0 || l2.size() == 0)
			throw new IndexOutOfBoundsException("Error, the size of the one or both lists haven't defined");

		// Test the type of the lists (teste el tipo de las listas)
		if (!(l1.get(0) instanceof MemberCommunityManager) || !(l2.get(0) instanceof MemberCommunityPublic))
			throw new ClassCastException("Error, the type of list don't define corretly");

		// Comparing and getting the member who is value diferent in the field specified
		// (Compara y obtiente el miembro que tiene una valor difiernte en el campo
		// especificado)
		List<Object> resul1 = new ArrayList();
		for (int i = 0; i < l1.size(); i++) {
			// System.out.println( l1.get(i).equals(l2.get(i)));

			if (!(((MemberCommunityManager) l1.get(i)).getCategory())
					.equals(((MemberCommunityPublic) l2.get(i)).getCategory())) {
				// System.out.println("Category of MemberCommunityManager (l1)>
				// "+((MemberCommunityManager) l1.get(i)).getCategory());
				// System.out.println("Category of MemberCommunityPublic (l2)>
				// "+((MemberCommunityPublic) l2.get(i)).getCategory());
				resul1.add(l1.get(i));
			}
		}

		System.out.println(resul1.size() + " miembros con diferencias en el campo 'categoría'.");
		resul1.forEach(f -> {
			System.out.println(f);
		});
		return resul1;
	}

	/**
	 * comparativeMemberComunitinyByRol() Returns
	 * <tt>List&lt;MemberCommunityManager&gt;</tt> with the members of the manager
	 * document who have the field "rol" a value diferrent with themself but of the
	 * public document of the members community
	 * 
	 * Retorna <tt>List&lt;MemberCommunityManager&gt;</tt> con los miembros del
	 * documento gestor que tienen el campo "rol" un valor diferente a sí mismos
	 * pero del documento público de la comunidad miembros
	 * 
	 * 
	 * @param l1 <code>List&lt;MemberCommunityManager&gt;</code> list with the
	 *           members of the manager document of the members communitys who are
	 *           in public document (lista con los miembros del documento de
	 *           respoanbles de la comunidad de miembros comunes con el documento
	 *           publcio)
	 * 
	 * @param l2 <code>List&lt;MemberCommunityPublic&gt;</code> list with the
	 *           members in the public document of the members communitys who are in
	 *           manager document (lista con los miembros del documento publico de
	 *           la comunidad de miembors comunes con el documento de responsalbes)
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
	public static List<Object> comparativeMemberComunitinyByRol(List<Object> l1, List<Object> l2)
			throws ClassCastException, IndexOutOfBoundsException, NullPointerException {
		// Test the size of the lists (testea el tamaño de la listas)
		if (l1.size() == 0 || l2.size() == 0)
			throw new IndexOutOfBoundsException("Error, the size of the one or both lists haven't defined");

		// Test the type of the lists (teste el tipo de las listas)
		if (!(l1.get(0) instanceof MemberCommunityManager) || !(l2.get(0) instanceof MemberCommunityPublic))
			throw new ClassCastException("Error, the type of list don't define corretly");

		// Comparing and getting the member who is value diferent in the field specified
		// (Compara y obtiente el miembro que tiene una valor difiernte en el campo
		// especificado)
		List<Object> resul1 = new ArrayList();
		for (int i = 0; i < l1.size(); i++) {
			// System.out.println( l1.get(i).equals(l2.get(i)));

			if (!(((MemberCommunityManager) l1.get(i)).getRol()).equals(((MemberCommunityPublic) l2.get(i)).getRol())) {
				// System.out.println("Category of MemberCommunityManager (l1)>
				// "+((MemberCommunityManager) l1.get(i)).getRol());
				// System.out.println("Category of MemberCommunityPublic (l2)>
				// "+((MemberCommunityPublic) l2.get(i)).getRol());
				resul1.add(l1.get(i));
			}
		}

		System.out.println(resul1.size() + " miembros con diferencias en el campo 'rol'.");
		resul1.forEach(f -> {
			System.out.println(f);
		});
		return resul1;

	}

	/**
	 * comparativeMemberComunitinyByLevel() Returns
	 * <tt>List&lt;MemberCommunityManager&gt;</tt> with the members of the manager
	 * document who have the field "level" a value diferrent with themself but of
	 * the public document of the members community
	 * 
	 * Retorna <tt>List&lt;MemberCommunityManager&gt;</tt> con los miembros del
	 * documento gestor que tienen el campo "nivel dreyfus" un valor diferente a sí
	 * mismos pero del documento público de la comunidad miembros
	 * 
	 * 
	 * @param l1 <code>List&lt;MemberCommunityManager&gt;</code> list with the
	 *           members of the manager document of the members communitys who are
	 *           in public document (lista con los miembros del documento de
	 *           respoanbles de la comunidad de miembros comunes con el documento
	 *           publcio)
	 * 
	 * @param l2 <code>List&lt;MemberCommunityPublic&gt;</code> list with the
	 *           members in the public document of the members communitys who are in
	 *           manager document (lista con los miembros del documento publico de
	 *           la comunidad de miembors comunes con el documento de responsalbes)
	 * @return
	 * 
	 * @return <tt>List&lt;MemberCommunityManager&gt;</tt> wwith the members of the
	 *         managers documents who don't have the same value in the field
	 *         <b>level</b> in public document of member community (list con los
	 *         miembros del documenot de responsalbes los cuales no tiene el mis
	 *         valor en el campo "level" en el documento publico de la comunidad de
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
	public static List<Object> comparativeMemberComunitinyByLevel(List<Object> l1, List<Object> l2)
			throws ClassCastException, IndexOutOfBoundsException, NullPointerException {
		// Test the size of the lists (testea el tamaño de la listas)
		if (l1.size() == 0 || l2.size() == 0)
			throw new IndexOutOfBoundsException("Error, the size of the one or both lists haven't defined");

		// Test the type of the lists (teste el tipo de las listas)
		if (!(l1.get(0) instanceof MemberCommunityManager) || !(l2.get(0) instanceof MemberCommunityPublic))
			throw new ClassCastException("Error, the type of list don't define corretly");

		// Comparing and getting the member who is value diferent in the field specified
		// (Compara y obtiente el miembro que tiene una valor difiernte en el campo
		// especificado)
		List<Object> resul1 = new ArrayList();
		for (int i = 0; i < l1.size(); i++) {
			// System.out.println( l1.get(i).equals(l2.get(i)));

			if (!(((MemberCommunityManager) l1.get(i)).getLevel())
					.equals(((MemberCommunityPublic) l2.get(i)).getLevel())) {
				// System.out.println("Category of MemberCommunityManager (l1)>
				// "+((MemberCommunityManager) l1.get(i)).getLevel());
				// System.out.println("Category of MemberCommunityPublic (l2)>
				// "+((MemberCommunityPublic) l2.get(i)).getLevel());
				resul1.add(l1.get(i));
			}
		}

		System.out.println(resul1.size() + " miembros con diferencias en el campo 'nivel dreyfous'.");
		resul1.forEach(f -> {
			System.out.println(f);
		});
		return resul1;

	}

	/**
	 * comparativeMemberComunitinyByCodeProject() Returns
	 * <tt>List&lt;MemberCommunityManager&gt;</tt> with the members of the manager
	 * document who have the field "project code" a value diferrent with themself
	 * but of the public document of the members community
	 * 
	 * Retorna <tt>List&lt;MemberCommunityManager&gt;</tt> con los miembros del
	 * documento gestor que tienen el campo "codigo de proyecto" un valor diferente
	 * a sí mismos pero del documento público de la comunidad miembros
	 * 
	 * 
	 * @param l1 <code>List&lt;MemberCommunityManager&gt;</code> list with the
	 *           members of the manager document of the members communitys who are
	 *           in public document (lista con los miembros del documento de
	 *           respoanbles de la comunidad de miembros comunes con el documento
	 *           publcio)
	 * 
	 * @param l2 <code>List&lt;MemberCommunityPublic&gt;</code> list with the
	 *           members in the public document of the members communitys who are in
	 *           manager document (lista con los miembros del documento publico de
	 *           la comunidad de miembors comunes con el documento de responsalbes)
	 * @return
	 * @return
	 * 
	 * @return <tt>List&lt;MemberCommunityManager&gt;</tt> wwith the members of the
	 *         managers documents who don't have the same value in the field
	 *         <b>project code</b> in public document of member community (list con
	 *         los miembros del documenot de responsalbes los cuales no tiene el mis
	 *         valor en el campo "codigo de proyecto" en el documento publico de la
	 *         comunidad de miembros)
	 * 
	 * @throws ClassCastException        if the type of the specified element is
	 *                                   incompatible (si el tipo de elemento
	 *                                   especificado es incompatible)
	 * 
	 * @throws IndexOutOfBoundsException if the size of one or both list are 0 (si
	 *                                   el tamaño de una lista o ambas es 0)
	 * 
	 * @throws NullPointerException      if the size of one or both list are 0 (si
	 *                                   el tamaño de una lista o ambas es 0)
	 */
	public static List<Object> comparativeMemberComunitinyByCodeProject(List<Object> l1, List<Object> l2)
			throws ClassCastException, IndexOutOfBoundsException, NullPointerException {
		// Test the size of the lists (testea el tamaño de la listas)
		if (l1.size() == 0 || l2.size() == 0)
			throw new IndexOutOfBoundsException("Error, the size of the one or both lists haven't defined");

		// Test the type of the lists (teste el tipo de las listas)
		if (!(l1.get(0) instanceof MemberCommunityManager) || !(l2.get(0) instanceof MemberCommunityPublic))
			throw new ClassCastException("Error, the type of list don't define corretly");

		// Comparing and getting the member who is value diferent in the field specified
		// (Compara y obtiente el miembro que tiene una valor difiernte en el campo
		// especificado)
		List<Object> resul1 = new ArrayList();
		List<String> codeProjectL1 = null, codeProjectL2 = null;
		try {

			for (int i = 0; i < l1.size(); i++) {
				// System.out.println( l1.get(i).equals(l2.get(i)));
				codeProjectL1 = ((MemberCommunityManager) l1.get(i)).getCodeProject();
				codeProjectL2 = ((MemberCommunityPublic) l2.get(i)).getCodeProject();

				if (codeProjectL1 != null && codeProjectL2 != null) {
					if ((codeProjectL1 != null && codeProjectL2 == null)
							|| (codeProjectL1 == null && codeProjectL2 != null)) {
						resul1.add(l1.get(i));
					} else {
						if ((codeProjectL1 != null && codeProjectL2 != null)
								&& (codeProjectL1.size() != 0 && codeProjectL2.size() == 0)
								|| (codeProjectL1.size() == 0 && codeProjectL2.size() == 0)) {
							resul1.add(l1.get(i));
						} else {
							// System.out.println("codeProjectL1= "+codeProjectL1+", codeProjectL2=
							// "+codeProjectL2);
							if (!codeProjectL1.equals(codeProjectL2)) {
								// System.out.println("Category of MemberCommunityManager (l1)>
								// "+((MemberCommunityManager) l1.get(i)).getCodeProject());
								// System.out.println("Category of MemberCommunityPublic (l2)>
								// "+((MemberCommunityPublic) l2.get(i)).getCodeProject());
								resul1.add(l1.get(i));
							}
						}
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(resul1.size() + " miembros con diferencias en el campo 'codigo de proyecto'.");
		resul1.forEach(f -> {
			System.out.println(f);
		});
		return resul1;

	}

	/**
	 * comparativeMemberComunitinyByCodeProject() Returns
	 * <tt>List&lt;MemberCommunityManager&gt;</tt> with the members of the manager
	 * document who have the field "project" a value diferrent with themself but of
	 * the public document of the members community
	 * 
	 * Retorna <tt>List&lt;MemberCommunityManager&gt;</tt> con los miembros del
	 * documento gestor que tienen el campo "proyecto" un valor diferente a sí
	 * mismos pero del documento público de la comunidad miembros
	 * 
	 * 
	 * @param l1 <code>List&lt;MemberCommunityManager&gt;</code> list with the
	 *           members of the manager document of the members communitys who are
	 *           in public document (lista con los miembros del documento de
	 *           respoanbles de la comunidad de miembros comunes con el documento
	 *           publcio)
	 * 
	 * @param l2 <code>List&lt;MemberCommunityPublic&gt;</code> list with the
	 *           members in the public document of the members communitys who are in
	 *           manager document (lista con los miembros del documento publico de
	 *           la comunidad de miembors comunes con el documento de responsalbes)
	 * @return
	 * @return
	 * @return
	 * 
	 * @return <tt>List&lt;MemberCommunityManager&gt;</tt> wwith the members of the
	 *         managers documents who don't have the same value in the field
	 *         <b>project</b> in public document of member community (list con los
	 *         miembros del documenot de responsalbes los cuales no tiene el mis
	 *         valor en el campo "proyecto" en el documento publico de la comunidad
	 *         de miembros)
	 * 
	 * @throws ClassCastException        if the type of the specified element is
	 *                                   incompatible (si el tipo de elemento
	 *                                   especificado es incompatible)
	 * 
	 * @throws IndexOutOfBoundsException if the size of one or both list are 0 (si
	 *                                   el tamaño de una lista o ambas es 0)
	 * 
	 * @throws NullPointerException      if the size of one or both list are 0 (si
	 *                                   el tamaño de una lista o ambas es 0)
	 */
	public static List<Object> comparativeMemberComunitinyByProject(List<Object> l1, List<Object> l2)
			throws ClassCastException, IndexOutOfBoundsException, NullPointerException {
		// Test the size of the lists (testea el tamaño de la listas)
		if (l1.size() == 0 || l2.size() == 0)
			throw new IndexOutOfBoundsException("Error, the size of the one or both lists haven't defined");

		// Test the type of the lists (teste el tipo de las listas)
		if (!(l1.get(0) instanceof MemberCommunityManager) || !(l2.get(0) instanceof MemberCommunityPublic))
			throw new ClassCastException("Error, the type of list don't define corretly");

		// Comparing and getting the member who is value diferent in the field specified
		// (Compara y obtiente el miembro que tiene una valor difiernte en el campo
		// especificado)
		List<Object> resul1 = new ArrayList();
		List<String> projectL1 = null, projectL2 = null;
		try {

			for (int i = 0; i < l1.size(); i++) {
				// System.out.println( l1.get(i).equals(l2.get(i)));
				projectL1 = ((MemberCommunityManager) l1.get(i)).getProject();
				projectL2 = ((MemberCommunityPublic) l2.get(i)).getProject();

				if (projectL1 != null && projectL2 != null) {
					if ((projectL1 != null && projectL2 == null) || (projectL1 == null && projectL2 != null)) {
						resul1.add(l1.get(i));
					} else {
						if ((projectL1 != null && projectL2 != null) && (projectL1.size() != 0 && projectL2.size() == 0)
								|| (projectL1.size() == 0 && projectL2.size() == 0)) {
							resul1.add(l1.get(i));
						} else {
							// System.out.println("projectL1= "+projectL1+", projectL2=
							// "+projectL2);
							if (!projectL1.equals(projectL2)) {
								// System.out.println("Project of MemberCommunityManager (l1)>
								// "+((MemberCommunityManager) l1.get(i)).getProject());
								// System.out.println("Project of MemberCommunityPublic (l2)>
								// "+((MemberCommunityPublic) l2.get(i)).getProject());
								resul1.add(l1.get(i));
							}
						}
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(resul1.size() + " miembros con diferencias en el campo 'proyecto'.");
		resul1.forEach(f -> {
			System.out.println(f);
		});
		return resul1;

	}

	/**
	 * comparativeMemberComunitinyByCodeProject() Returns
	 * <tt>List&lt;MemberCommunityManager&gt;</tt> with the members of the manager
	 * document who have the field "Responsable" a value diferrent with themself but
	 * of the public document of the members community
	 * 
	 * Retorna <tt>List&lt;MemberCommunityManager&gt;</tt> con los miembros del
	 * documento gestor que tienen el campo "responsable" un valor diferente a sí
	 * mismos pero del documento público de la comunidad miembros
	 * 
	 * 
	 * @param l1 <code>List&lt;MemberCommunityManager&gt;</code> list with the
	 *           members of the manager document of the members communitys who are
	 *           in public document (lista con los miembros del documento de
	 *           respoanbles de la comunidad de miembros comunes con el documento
	 *           publcio)
	 * 
	 * @param l2 <code>List&lt;MemberCommunityPublic&gt;</code> list with the
	 *           members in the public document of the members communitys who are in
	 *           manager document (lista con los miembros del documento publico de
	 *           la comunidad de miembors comunes con el documento de responsalbes)
	 * @return
	 * @return
	 * @return
	 * 
	 * @return <tt>List&lt;MemberCommunityManager&gt;</tt> wwith the members of the
	 *         managers documents who don't have the same value in the field
	 *         <b>Responsable</b> in public document of member community (list con
	 *         los miembros del documenot de responsables los cuales no tiene el mis
	 *         valor en el campo "responsable" en el documento publico de la
	 *         comunidad de miembros)
	 * 
	 * @throws ClassCastException        if the type of the specified element is
	 *                                   incompatible (si el tipo de elemento
	 *                                   especificado es incompatible)
	 * 
	 * @throws IndexOutOfBoundsException if the size of one or both list are 0 (si
	 *                                   el tamaño de una lista o ambas es 0)
	 * 
	 * @throws NullPointerException      if the size of one or both list are 0 (si
	 *                                   el tamaño de una lista o ambas es 0)
	 */
	public static List<Object> comparativeMemberComunitinyByResponsable(List<Object> l1, List<Object> l2)
			throws ClassCastException, IndexOutOfBoundsException, NullPointerException {
		// Test the size of the lists (testea el tamaño de la listas)
		if (l1.size() == 0 || l2.size() == 0)
			throw new IndexOutOfBoundsException("Error, the size of the one or both lists haven't defined");

		// Test the type of the lists (teste el tipo de las listas)
		if (!(l1.get(0) instanceof MemberCommunityManager) || !(l2.get(0) instanceof MemberCommunityPublic))
			throw new ClassCastException("Error, the type of list don't define corretly");

		// Comparing and getting the member who is value diferent in the field specified
		// (Compara y obtiente el miembro que tiene una valor difiernte en el campo
		// especificado)
		List<Object> resul1 = new ArrayList();
		List<String> responsableL1 = null, responsableL2 = null;
		try {

			for (int i = 0; i < l1.size(); i++) {
				// System.out.println( l1.get(i).equals(l2.get(i)));
				responsableL1 = ((MemberCommunityManager) l1.get(i)).getResponsable();
				responsableL2 = ((MemberCommunityPublic) l2.get(i)).getResponsable();

				if (responsableL1 != null && responsableL2 != null) {
					if ((responsableL1 != null && responsableL2 == null)
							|| (responsableL1 == null && responsableL2 != null)) {
						resul1.add(l1.get(i));
					} else {
						if ((responsableL1 != null && responsableL2 != null)
								&& (responsableL1.size() != 0 && responsableL2.size() == 0)
								|| (responsableL1.size() == 0 && responsableL2.size() == 0)) {
							resul1.add(l1.get(i));
						} else {
							// System.out.println("responsableL1= "+responsableL2+", projectL2=
							// "+projectL2);
							if (!responsableL1.equals(responsableL2)) {
								// System.out.println("Responsable of MemberCommunityManager (l1)>
								// "+((MemberCommunityManager) l1.get(i)).getResponsable());
								// System.out.println("responsableL1 of MemberCommunityPublic (l2)>
								// "+((MemberCommunityPublic) l2.get(i)).getResponsable());
								resul1.add(l1.get(i));
							}
						}
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(resul1.size() + " miembros con diferencias en el campo 'responsable'.");
		resul1.forEach(f -> {
			System.out.println(f);
		});
		return resul1;

	}

	/**
	 * comparativeMemberComunitinyByCodeProject() Returns
	 * <tt>List&lt;MemberCommunityManager&gt;</tt> with the members of the manager
	 * document who have the field "Technology" a value diferrent with themself but
	 * of the public document of the members community
	 * 
	 * Retorna <tt>List&lt;MemberCommunityManager&gt;</tt> con los miembros del
	 * documento gestor que tienen el campo "tecología" un valor diferente a sí
	 * mismos pero del documento público de la comunidad miembros
	 * 
	 * 
	 * @param l1 <code>List&lt;MemberCommunityManager&gt;</code> list with the
	 *           members of the manager document of the members communitys who are
	 *           in public document (lista con los miembros del documento de
	 *           respoanbles de la comunidad de miembros comunes con el documento
	 *           publcio)
	 * 
	 * @param l2 <code>List&lt;MemberCommunityPublic&gt;</code> list with the
	 *           members in the public document of the members communitys who are in
	 *           manager document (lista con los miembros del documento publico de
	 *           la comunidad de miembors comunes con el documento de responsalbes)
	 * @return
	 * @return
	 * @return
	 * @return
	 * 
	 * @return <tt>List&lt;MemberCommunityManager&gt;</tt> wwith the members of the
	 *         managers documents who don't have the same value in the field
	 *         <b>Technology</b> in public document of member community (list con
	 *         los miembros del documenot de responsalbes los cuales no tiene el mis
	 *         valor en el campo "tecnología" en el documento publico de la
	 *         comunidad de miembros)
	 * 
	 * @throws ClassCastException        if the type of the specified element is
	 *                                   incompatible (si el tipo de elemento
	 *                                   especificado es incompatible)
	 * 
	 * @throws IndexOutOfBoundsException if the size of one or both list are 0 (si
	 *                                   el tamaño de una lista o ambas es 0)
	 * 
	 * @throws NullPointerException      if the size of one or both list are 0 (si
	 *                                   el tamaño de una lista o ambas es 0)
	 */
	public static List<Object> comparativeMemberComunitinyByTechnology(List<Object> l1, List<Object> l2)
			throws ClassCastException, IndexOutOfBoundsException, NullPointerException {
		// Test the size of the lists (testea el tamaño de la listas)
		if (l1.size() == 0 || l2.size() == 0)
			throw new IndexOutOfBoundsException("Error, the size of the one or both lists haven't defined");

		// Test the type of the lists (teste el tipo de las listas)
		if (!(l1.get(0) instanceof MemberCommunityManager) || !(l2.get(0) instanceof MemberCommunityPublic))
			throw new ClassCastException("Error, the type of list don't define corretly");

		// Comparing and getting the member who is value diferent in the field specified
		// (Compara y obtiente el miembro que tiene una valor difiernte en el campo
		// especificado)
		List<Object> resul1 = new ArrayList();
		List<String> technologyL1 = null, technologyL2 = null;
		try {

			for (int i = 0; i < l1.size(); i++) {
				// System.out.println( l1.get(i).equals(l2.get(i)));
				technologyL1 = ((MemberCommunityManager) l1.get(i)).getTechnology();
				technologyL2 = ((MemberCommunityPublic) l2.get(i)).getTechnology();

				if (technologyL1 != null && technologyL2 != null) {
					if ((technologyL1 != null && technologyL2 == null)
							|| (technologyL1 == null && technologyL2 != null)) {
						resul1.add(l1.get(i));
					} else {
						if ((technologyL1 != null && technologyL2 != null)
								&& (technologyL1.size() != 0 && technologyL2.size() == 0)
								|| (technologyL1.size() == 0 && technologyL2.size() == 0)) {
							resul1.add(l1.get(i));
						} else {
							// System.out.println("technologyL1= "+technologyL2+", technologyL2=
							// "+technologyL2);
							if (!technologyL1.equals(technologyL2)) {
								// System.out.println("Technology of MemberCommunityManager (l1)>
								// "+((MemberCommunityManager) l1.get(i)).getTechnology());
								// System.out.println("Technology of MemberCommunityPublic (l2)>
								// "+((MemberCommunityPublic) l2.get(i)).getTechnology());
								resul1.add(l1.get(i));
							}
						}
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(resul1.size() + " miembros con diferencias en el campo 'tecnología'.");
		resul1.forEach(f -> {
			System.out.println(f);
		});
		return resul1;
	}

	/**
	 * comparativeMemberComunitinyByCodeProject() Returns
	 * <tt>List&lt;MemberCommunityManager&gt;</tt> with the members of the manager
	 * document who have the field "Certification" a value diferrent with themself
	 * but of the public document of the members community
	 * 
	 * Retorna <tt>List&lt;MemberCommunityManager&gt;</tt> con los miembros del
	 * documento gestor que tienen el campo "certificación" un valor diferente a sí
	 * mismos pero del documento público de la comunidad miembros
	 * 
	 * @param l1 <code>List&lt;MemberCommunityManager&gt;</code> list with the
	 *           members of the manager document of the members communitys who are
	 *           in public document (lista con los miembros del documento de
	 *           respoanbles de la comunidad de miembros comunes con el documento
	 *           publcio)
	 * 
	 * @param l2 <code>List&lt;MemberCommunityPublic&gt;</code> list with the
	 *           members in the public document of the members communitys who are in
	 *           manager document (lista con los miembros del documento publico de
	 *           la comunidad de miembors comunes con el documento de responsalbes)
	 * @return
	 * 
	 * @return <tt>List&lt;MemberCommunityManager&gt;</tt> wwith the members of the
	 *         managers documents who don't have the same value in the field
	 *         <b>Certification</b> in public document of member community (list con
	 *         los miembros del documenot de responsalbes los cuales no tiene el mis
	 *         valor en el campo "certificación" en el documento publico de la
	 *         comunidad de miembros)
	 * 
	 * @throws ClassCastException        if the type of the specified element is
	 *                                   incompatible (si el tipo de elemento
	 *                                   especificado es incompatible)
	 * 
	 * @throws IndexOutOfBoundsException if the size of one or both list are 0 (si
	 *                                   el tamaño de una lista o ambas es 0)
	 * 
	 * @throws NullPointerException      if the size of one or both list are 0 (si
	 *                                   el tamaño de una lista o ambas es 0)
	 */
	public static List<Object> comparativeMemberComunitinyByCertification(List<Object> l1, List<Object> l2)
			throws ClassCastException, IndexOutOfBoundsException, NullPointerException {
		// Test the size of the lists (testea el tamaño de la listas)
		if (l1.size() == 0 || l2.size() == 0)
			throw new IndexOutOfBoundsException("Error, the size of the one or both lists haven't defined");

		// Test the type of the lists (teste el tipo de las listas)
		if (!(l1.get(0) instanceof MemberCommunityManager) || !(l2.get(0) instanceof MemberCommunityPublic))
			throw new ClassCastException("Error, the type of list don't define corretly");

		// Comparing and getting the member who is value diferent in the field specified
		// (Compara y obtiente el miembro que tiene una valor difiernte en el campo
		// especificado)
		List<Object> resul1 = new ArrayList();
		List<String> certificationL1 = null, certificationL2 = null;
		try {

			for (int i = 0; i < l1.size(); i++) {
				// System.out.println( l1.get(i).equals(l2.get(i)));
				certificationL1 = ((MemberCommunityManager) l1.get(i)).getCertification();
				certificationL2 = ((MemberCommunityPublic) l2.get(i)).getCertification();

				if (certificationL1 != null && certificationL2 != null) {
					if ((certificationL1 != null && certificationL2 == null)
							|| (certificationL1 == null && certificationL2 != null)) {
						resul1.add(l1.get(i));
					} else {
						if ((certificationL1 != null && certificationL2 != null)
								&& (certificationL1.size() != 0 && certificationL2.size() == 0)
								|| (certificationL1.size() == 0 && certificationL2.size() == 0)) {
							resul1.add(l1.get(i));
						} else {
							// System.out.println("certificationL1= "+certificationL1+",
							// certificationL2="+certificationL2);
							if (!certificationL1.equals(certificationL2)) {
								// System.out.println("Certification of MemberCommunityManager (l1)>
								// "+((MemberCommunityManager) l1.get(i)).getCertification());
								// System.out.println("Certification of MemberCommunityPublic (l2)>
								// "+((MemberCommunityPublic) l2.get(i)).getCertification());
								resul1.add(l1.get(i));
							}
						}
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(resul1.size() + " miembros con diferencias en el campo 'certification'.");
		resul1.forEach(f -> {
			System.out.println(f);
		});
		return resul1;

	}

	/**
	 * comparativeMemberComunitinyByCodeProject() Returns
	 * <tt>List&lt;MemberCommunityManager&gt;</tt> with the members of the manager
	 * document who have the field "Low" a value diferrent with themself but of the
	 * public document of the members community
	 * 
	 * Retorna <tt>List&lt;MemberCommunityManager&gt;</tt> con los miembros del
	 * documento gestor que tienen el campo "baja" un valor diferente a sí mismos
	 * pero del documento público de la comunidad miembros
	 * 
	 * @param l1 <code>List&lt;MemberCommunityManager&gt;</code> list with the
	 *           members of the manager document of the members communitys who are
	 *           in public document (lista con los miembros del documento de
	 *           respoanbles de la comunidad de miembros comunes con el documento
	 *           publcio)
	 * 
	 * @param l2 <code>List&lt;MemberCommunityPublic&gt;</code> list with the
	 *           members in the public document of the members communitys who are in
	 *           manager document (lista con los miembros del documento publico de
	 *           la comunidad de miembors comunes con el documento de responsalbes)
	 * @return
	 * 
	 * @return <tt>List&lt;MemberCommunityManager&gt;</tt> wwith the members of the
	 *         managers documents who don't have the same value in the field
	 *         <b>Low</b> in public document of member community (list con los
	 *         miembros del documenot de responsalbes los cuales no tiene el mis
	 *         valor en el campo "baja" en el documento publico de la comunidad de
	 *         miembros)
	 * 
	 * @throws ClassCastException        if the type of the specified element is
	 *                                   incompatible (si el tipo de elemento
	 *                                   especificado es incompatible)
	 * 
	 * @throws IndexOutOfBoundsException if the size of one or both list are 0 (si
	 *                                   el tamaño de una lista o ambas es 0)
	 * 
	 */
	public static void comparativeMemberComunitinyByLow(List<Object> l1, List<Object> l2)
			throws ClassCastException, IndexOutOfBoundsException {
		// Test the size of the lists (testea el tamaño de la listas)
		if (l1.size() == 0 || l2.size() == 0)
			throw new IndexOutOfBoundsException("Error, the size of the one or both lists haven't defined");

		// Test the type of the lists (teste el tipo de las listas)
		if (!(l1.get(0) instanceof MemberCommunityManager) || !(l2.get(0) instanceof MemberCommunityPublic))
			throw new ClassCastException("Error, the type of list don't define corretly");

		// Comparing and getting the member who is value diferent in the field specified
		// (Compara y obtiente el miembro que tiene una valor difiernte en el campo
		// especificado)
		List<Object> resul1 = new ArrayList();
		boolean lowL1 = false;
		boolean lowL2 = false;

		for (int i = 0; i < l1.size(); i++) {
			// System.out.println( l1.get(i).equals(l2.get(i)));
			lowL1 = ((MemberCommunityManager) l1.get(i)).isLow();
			lowL2 = ((MemberCommunityPublic) l2.get(i)).isLow();
			if (!(lowL1 == lowL2)) {
				resul1.add((MemberCommunityManager) l1.get(i));
			}
		}

		System.out.println(resul1.size() + " miembros con diferencias en el campo 'baja'.");
		resul1.forEach(f -> {
			System.out.println(f);
		});

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
	public static void identifierFieldDifferences(List<Object> l1, List<Object> l2)
			throws ClassCastException, IndexOutOfBoundsException, NullPointerException {
		// Test the size of the lists (testea el tamaño de la listas)
		if (l1.size() == 0 || l2.size() == 0)
			throw new IndexOutOfBoundsException("Error, the size of the one or both lists haven't defined");

		// Test the type of the lists (teste el tipo de las listas)
		if (!(l1.get(0) instanceof MemberCommunityManager) || !(l2.get(0) instanceof MemberCommunityPublic))
			throw new ClassCastException("Error, the type of list don't define corretly");

		Map<Integer, List<String>> mapResult = new HashMap<Integer, List<String>>();
		List<String> lFieldCommon = Constants.FIELDCOMMONMEMBERSCOMUNITY;

		try {
			for (int i = 0; i < l1.size(); i++) {
				MemberCommunityManager mcm = (MemberCommunityManager) l1.get(i);
				MemberCommunityPublic mcp = (MemberCommunityPublic) l2.get(i);
				List<String> listDifference = new ArrayList<String>();
				// Check the fields commons to both documents

				// CodeEmployed
				if (mcm.getCodEmployed() == null)
					mcm.setCodEmployed(-1);
				if (mcp.getCodEmployed() == null)
					mcp.setCodEmployed(-1);
				if (!mcm.getCodEmployed().equals(mcp.getCodEmployed())) {
					// System.out.println(lFieldCommon.get(0)+">> l1: "+mcm.getCodEmployed()+" l2:
					// "+mcp.getCodEmployed());
					listDifference.add(lFieldCommon.get(0));
				}

				// Name
				if (mcm.getName() == null)
					mcm.setName("");
				if (mcp.getName() == null)
					mcp.setName("");
				if (!mcm.getName().equals(mcp.getName())) {
					// System.out.println(lFieldCommon.get(1)+"["+mcm.getCodEmployed()+","+mcp.getCodEmployed()+"]>>
					// l1: "+mcm.getName()+" l2: "+mcp.getName());
					listDifference.add(lFieldCommon.get(1));
				}

				// Office
				if (mcm.getOffice() == null)
					mcm.setOffice("");
				if (mcp.getOffice() == null)
					mcp.setOffice("");
				if (!mcm.getOffice().equals(mcp.getOffice())) {
					// System.out.println(lFieldCommon.get(2)+"["+mcm.getCodEmployed()+","+mcp.getCodEmployed()+"]>>
					// l1: "+mcm.getOffice()+" l2: "+mcp.getOffice());
					listDifference.add(lFieldCommon.get(2));
				}

				// Category
				if (mcm.getCategory() == null)
					mcm.setCategory("");
				if (mcp.getCategory() == null)
					mcp.setCategory("");
				if (!mcm.getCategory().equals(mcp.getCategory())) {
					// System.out.println(lFieldCommon.get(3)+"["+mcm.getCodEmployed()+","+mcp.getCodEmployed()+"]>>
					// l1: "+mcm.getCategory()+" l2: "+mcp.getCategory());
					listDifference.add(lFieldCommon.get(3));
				}

				// Rol
				if (mcm.getRol() == null)
					mcm.setRol("");
				if (mcp.getRol() == null)
					mcp.setRol("");
				if (!mcm.getRol().equals(mcp.getRol())) {
					// System.out.println(lFieldCommon.get(4)+"["+mcm.getCodEmployed()+","+mcp.getCodEmployed()+"]>>
					// l1: "+mcm.getRol()+" l2: "+mcp.getRol());
					listDifference.add(lFieldCommon.get(4));
				}

				// Level D
				if (mcm.getLevel() == null)
					mcm.setLevel("");
				if (mcp.getLevel() == null)
					mcp.setLevel("");
				if (!mcm.getLevel().equals(mcp.getLevel())) {
					// System.out.println(lFieldCommon.get(5)+"["+mcm.getCodEmployed()+","+mcp.getCodEmployed()+"]>>
					// l1: "+mcm.getLevel()+" l2: "+mcp.getLevel());
					listDifference.add(lFieldCommon.get(5));
				}

				// Project Code
				if (mcm.getCodeProject() == null)
					mcm.setCodeProject(new ArrayList<String>());
				if (mcp.getCodeProject() == null)
					mcp.setCodeProject(new ArrayList<String>());
				if (!mcm.getCodeProject().equals(mcp.getCodeProject())) {
					// System.out.println(lFieldCommon.get(6)+"["+mcm.getCodEmployed()+","+mcp.getCodEmployed()+"]>>
					// l1: "+mcm.getCodeProject()+" l2: "+mcp.getCodeProject());
					listDifference.add(lFieldCommon.get(6));
				}

				// Project
				if (mcm.getProject() == null)
					mcm.setProject(new ArrayList<String>());
				if (mcp.getProject() == null)
					mcp.setProject(new ArrayList<String>());
				if (!mcm.getProject().equals(mcp.getProject())) {
					// System.out.println(lFieldCommon.get(7)+"["+mcm.getCodEmployed()+","+mcp.getCodEmployed()+"]>>
					// l1: "+mcm.getProject()+" l2: "+mcp.getProject());
					listDifference.add(lFieldCommon.get(7));
				}

				// Responsable
				if (mcm.getResponsable() == null)
					mcm.setResponsable(new ArrayList<String>());
				if (mcp.getResponsable() == null)
					mcp.setResponsable(new ArrayList<String>());
				if (!mcm.getResponsable().equals(mcp.getResponsable())) {
					// System.out.println(lFieldCommon.get(8)+"["+mcm.getCodEmployed()+","+mcp.getCodEmployed()+"]>>
					// l1: "+mcm.getResponsable()+" l2: "+mcp.getResponsable());
					listDifference.add(lFieldCommon.get(8));
				}

				// Technology
				if (mcm.getTechnology() == null)
					mcm.setTechnology(new ArrayList<String>());
				if (mcp.getTechnology() == null)
					mcp.setTechnology(new ArrayList<String>());
				if (!mcm.getTechnology().equals(mcp.getTechnology())) {
					// System.out.println(lFieldCommon.get(9)+"["+mcm.getCodEmployed()+","+mcp.getCodEmployed()+"]>>
					// l1: "+mcm.getTechnology()+" l2: "+mcp.getTechnology());
					listDifference.add(lFieldCommon.get(9));
				}

				// Certification
				if (mcm.getCertification() == null)
					mcm.setCertification(new ArrayList<String>());
				if (mcp.getCertification() == null)
					mcp.setCertification(new ArrayList<String>());
				if (!mcm.getCertification().equals(mcp.getCertification())) {
					// System.out.println(lFieldCommon.get(10)+"["+mcm.getCodEmployed()+","+mcp.getCodEmployed()+"]>>
					// l1: "+mcm.getCertification()+" l2: "+mcp.getCertification());
					listDifference.add(lFieldCommon.get(10));
				}

				// Low
				if (!(mcm.isLow() == mcp.isLow())) {
					listDifference.add(lFieldCommon.get(11));
				}

				// Check if there something difference
				if (listDifference.size() != 0)
					mapResult.put(mcm.getCodEmployed(), listDifference);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(mapResult.size() + " miembros con diferencias encontradas.");
		System.out.println(mapResult);
	}

	public static void comparativeCommunityWichPerson(Map<Integer, Object> mapPersonDigitalCenter,
			Map<Integer, Object> mapMemberComunity,
			List<PersonDigitalCenters> lMemberCommunityInPersonDigitalCenterLikeBack,
			List<PersonDigitalCenters> lMemberCommunityInPersonDigitalCenterOtherCommunity,
			List<PersonDigitalCenters> lPersonDigitalCenterOutMemberComunity,
			List<Object> lMemberCommunityOutPersonDigitalCenter,
			List<PersonDigitalCenters> lPersonDigitalCenterWithOutCommunity,
			String filterByComunity) {
		
		for (Integer clave:mapPersonDigitalCenter.keySet()) {
		    PersonDigitalCenters valor = (PersonDigitalCenters) mapPersonDigitalCenter.get(clave);
		    //System.out.println("Clave: " + clave + ", valor: " + valor);
		    //Member is inside of the Person Digital Center Doc and the technology community is identified like null?
		    if(mapMemberComunity.containsKey(clave) && valor.getTechnologyComunity()==null) {//Yes, member without community
		    	lMemberCommunityInPersonDigitalCenterOtherCommunity.add(valor);
		    }else {//No
		    	//Member is inside of the Person Digital Center Doc and the technology community isn't identified like requested ?
		    	if(mapMemberComunity.containsKey(clave) && !valor.getTechnologyComunity().equalsIgnoreCase(filterByComunity)   ) {//Yes, member in other community
		    		lMemberCommunityInPersonDigitalCenterOtherCommunity.add(valor);
			    }else {//No
			    	//Member is inside of the Person Digital Center Doc and the technology community is identified like requested ?
			    	if(mapMemberComunity.containsKey(clave) && valor.getTechnologyComunity().equalsIgnoreCase(filterByComunity)   ) {//Yes, member in same community
			    		lMemberCommunityInPersonDigitalCenterLikeBack.add(valor);
				    }else {//No
				    	//Member isn't inside of the Person Digital Center Doc and the technology community is identified to anything ?
				    	if(!mapMemberComunity.containsKey(clave) && valor.getTechnologyComunity()!=null && valor.getTechnologyComunity().equalsIgnoreCase(filterByComunity)   ) {//Yes
				    		lPersonDigitalCenterOutMemberComunity.add(valor);
					    }else {//No
					    	//Member isn't inside of the Person Digital Center Doc and the technology community isn't identified to anything ?
					    	if(!mapMemberComunity.containsKey(clave) && valor.getTechnologyComunity()==null  ) {//Yes
					    		lPersonDigitalCenterWithOutCommunity.add(valor);
						    }
					    }
				    }
			    }
		    }
		}
		
		//Look for the member who are in Person Digital Center but if they are in Member Comunity Manager
		//lMemberCommunityOutPersonDigitalCenter = mapMemberComunity.values().stream().filter(f->!mapPersonDigitalCenter.containsKey(((MemberCommunity) f).getCodEmployed())).collect(Collectors.toList());
		for (Integer clave:mapMemberComunity.keySet()) {
			
			//Member isn't inside of the Person Digital Center Doc?
			if(!mapPersonDigitalCenter.containsKey(clave)) {//Yes, then added to list lMemberCommunityOutPersonDigitalCenter
				lMemberCommunityOutPersonDigitalCenter.add(mapMemberComunity.get(clave));
			}
		}

	}

}
