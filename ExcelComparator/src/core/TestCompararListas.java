package core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestCompararListas {
	public static void main(String[] args) {

		ArrayList<String> listaA = new ArrayList<String>();
		ArrayList<String> listaB = new ArrayList<String>();

		listaA.add("uno");
		listaA.add("dos");
		listaA.add("tres");
		listaA.add("cuatro");
		listaA.add("cinco");

		listaB.add("uno");
		listaB.add("dos");
		listaB.add("tres");
		listaB.add("cuatro");
		listaB.add("cinco");
		listaB.add("seis");
		listaB.add("siete");
		listaB.add("ocho");
		listaB.add("nueve");
		listaB.add("diez");

		//
		System.out.println("Lista A:");
		listaA.stream().forEach(System.out::println);
		System.out.println("Lista B:");
		listaB.stream().forEach(System.out::println);
		
		
		//
		List<String> newList = listaB.stream().filter(p -> !listaA.contains(p)).collect(Collectors.toList());
		
		System.out.println(newList);
		
		List<String> newList2 = encuentraDiferencias(listaA,listaB);
		System.out.println(newList2);
	}
	
	public static ArrayList<String> encuentraDiferencias(ArrayList<String> listaA, 
		    ArrayList<String> listaB) {
		        for(String elemento : listaA){
		            if(listaB.contains(elemento)){
		                listaB.remove(elemento);
		            }
		        }
		        return listaB.size()>0 ? listaB : null ;
		}
}
