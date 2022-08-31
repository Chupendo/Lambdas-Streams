import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MapExamples {

	public static void main(String[] args) {
		Integer codigo;
		Calendar calendar;
	    Map<String, String> vars;
	    Set<String> keysParams;
	    Object[] keyParams2;
	    
	   codigo=3151;
	   calendar = Calendar.getInstance();
	   vars = new HashMap<String, String>(); //FIFO- primero en entrar último en salir, lo que implica que el primer elmento introducido ocupla la última posicion del mapa
	   
	   
        vars.put("id",codigo.toString());
        vars.put("month",Integer.toString(calendar.get(Calendar.MONTH)));
        vars.put("year",Integer.toString(calendar.get(Calendar.YEAR)));
        
        keysParams = vars.keySet();
        keyParams2 = vars.keySet().toArray();
        System.out.println("keysParams "+keysParams+", "+keysParams.size());
        System.out.println("keysParams[0]: "+keysParams.toArray()[0]);
        
        System.out.println("keyParams2 "+keyParams2+", "+keyParams2.length);
        System.out.println("keysParams[0]: "+keyParams2[0]);
        
        
        
	}
}
