
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SetExamples {
	
	public static void main(String[] args) {
		Set<String> s1 = new TreeSet<String>();
		Set<String> s2 = new TreeSet<String>();
		
		s1.add("adrian.fcardenal@babelgroup.com");
		s1.add("adrian.reyes@babelgroup.com");
		s1.add("adriano.romero@babelgroup.com");
		s1.add("alberto.arias@babelgroup.com");
		s1.add("alberto.gutierrez@babelgroup.com");
		s1.add("alberto.vicente@babelgroup.com");
		s1.add("alejandro.cervera@babelgroup.com");
		s1.add("alejandro.martinez@babelgroup.com");
		s1.add("alejandro.ortega@babelgroup.com");
		s1.add("alejandro.sanchez@babelgroup.com");
		s1.add("alexander.suntaxi@babelgroup.com");
		s1.add("alvaro.frias@babelgroup.com");
		s1.add("alvaro.pelaez@babelgroup.com");
		s1.add("andres.rpenuela@babelgroup.com");
		s1.add("angel.sisamon@babelgroup.com");
		s1.add("antonio.gonzalez@babelgroup.com");
		s1.add("antonio.gvillar@babelgroup.com");
		s1.add("antonio.vidal@babelgroup.com");
		s1.add("beatriz.gruizadame@babelgroup.com");
		s1.add("borja.pena@babelgroup.com");
		s1.add("borja.vera@babelgroup.com");
		s1.add("carlos.dcoco@babelgroup.com");
		s1.add("carlos.doblado@babelgroup.com");
		s1.add("carlos.gonzalo@babelgroup.com");
		s1.add("carlos.pajuelo@babelgroup.com");
		s1.add("christian.payo@babelgroup.com");
		s1.add("cristian.lcervera@babelgroup.com");
		s1.add("cristina.dmoreno@babelgroup.com");
		s1.add("cristino.suarez@babelgroup.com");
		s1.add("daniel.casas@babelgroup.com");
		s1.add("daniel.fernandez@babelgroup.com");
		s1.add("daniel.fheras@babelgroup.com");
		s1.add("daniel.iarias@babelgroup.com");
		s1.add("daniel.rodajo@babelgroup.com");
		s1.add("dario.garcia@babelgroup.com");
		s1.add("david.vargas@babelgroup.com");
		s1.add("diego.gvidal@babelgroup.com");
		s1.add("diogo.ribeiro@babelgroup.com");
		s1.add("eduardo.delpozo@babelgroup.com");
		s1.add("eduardo.luque@babelgroup.com");
		s1.add("enoc.munoz@babelgroup.com");
		s1.add("francisco.castro@babelgroup.com");
		s1.add("george.avram@babelgroup.com");
		s1.add("iciar.gallego@babelgroup.com");
		s1.add("ivan.becerra@babelgroup.com");
		s1.add("ivan.horcajo@babelgroup.com");
		s1.add("ivan.menendez@babelgroup.com");
		s1.add("jaime.palomo@babelgroup.com");
		s1.add("jasle.carrasco@babelgroup.com");
		s1.add("javier.ajimena@babelgroup.com");
		s1.add("javier.bermejo@babelgroup.com");
		s1.add("javier.isedano@babelgroup.com");
		s1.add("javier.melguizo@babelgroup.com");
		s1.add("javier.moreno@babelgroup.com");
		s1.add("javier.rguijarro@babelgroup.com");
		s1.add("jesus.sanchez@babelgroup.com");
		s1.add("jorge.garrido@babelgroup.com");
		s1.add("jose.caro@babelgroup.com");
		s1.add("jose.debenito@babelgroup.com");
		s1.add("jose.gaguilar@babelgroup.com");
		s1.add("jose.ortega@babelgroup.com");
		s1.add("josecarlos.sanjuan@babelgroup.com");
		s1.add("juan.gaguero@babelgroup.com");
		s1.add("juan.lopez@babelgroup.com");
		s1.add("luciano.mbayon@babelgroup.com");
		s1.add("luis.rfernandez@babelgroup.com");
		s1.add("maria.rballesteros@babelgroup.com");
		s1.add("marian.hervas@babelgroup.com");
		s1.add("marta.roman@babelgroup.com");
		s1.add("martin.sanchez@babelgroup.com");
		s1.add("miguel.aguilar@babelgroup.com");
		s1.add("miguel.morueco@babelgroup.com");
		s1.add("miguel.olivares@babelgroup.com");
		s1.add("miguel.villagra@babelgroup.com");
		s1.add("omar.montero@babelgroup.com");
		s1.add("pablo.carcaba@babelgroup.com");
		s1.add("rafael.salas@babelgroup.com");
		s1.add("rebeca.delgado@babelgroup.com");
		s1.add("rodrigo.carmo@babelgroup.com");
		s1.add("ronald.rivas@babelgroup.com");
		s1.add("salvador.cobrero@babelgroup.com");
		s1.add("sandra.garcia@babelgroup.com");
		s1.add("serafin.velez@babelgroup.com");
		s1.add("sergio.carrasco@babelgroup.com");
		s1.add("sergio.perea@babelgroup.com");
		s1.add("sergio.sromero@babelgroup.com");
		s1.add("teresa.diaz@babelgroup.com");
		s1.add("vanesa.gallardo@babelgroup.com");
		s1.add("xavier.ibanez@babelgroup.com");
		s1.add("yingying.hu@babelgroup.com");
		s1.add("youri.garcia@babelgroup.com");
		
		s2.add("juan.lopezz@babelgroup.com");
		s2.add("alberto.gutierrez@babelgroup.com");
		s2.add("ivan.menendez@babelgroup.com");
		s2.add("cristina.dmoreno@babelgroup.com");
		s2.add("andres.rpenuela@babelgroup.com");
		
		Set<String> sResul = getOfS1NotFindS2(s1,s2);
		System.out.println("Elementos de s1 no encontrados en s2:");
		if(sResul.isEmpty()) {System.out.println("null");}else{sResul.forEach(System.out::println);}
		
		
		sResul = getOfS1NotFindS2(s2,s1);
		System.out.println("Elementos de s2 no encontrados en s1");
		if(sResul.isEmpty()) {System.out.println("null");}else{sResul.forEach(System.out::println);}
		
	}
	
	//Devueve los que es elementos de s1 que estan en s2
	public static Set<String> getOfS1FindS2(Set s1, Set s2){
		
		return (Set<String>) s2.stream().filter(s->s1.contains(s)).collect(Collectors.toSet());
	}
	
	//Devueve los elementos de s1 que no estan estan en s12
	public static Set<String> getOfS1NotFindS2(Set s1, Set s2){
		
		return (Set<String>) s1.stream().filter(s->!s2.contains(s)).collect(Collectors.toSet());
	}
	
	
}
