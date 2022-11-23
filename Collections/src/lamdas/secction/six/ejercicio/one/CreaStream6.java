package lamdas.secction.six.ejercicio.one;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class CreaStream6 {

	public static void main(String[] args) {
		Path path1 = Paths.get("src/lamdas/secction/six/ejercicio/one/text.txt");
		
		try (Stream<String> lineas = Files.lines(path1)){
			lineas.forEach(System.out::println);
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println("No se puede abrir el fichero: ");
			e.printStackTrace();
		}
		
		Path dir = Paths.get(".");
		System.out.println("El arbol de achivos del proyecto: "+dir.toAbsolutePath());
		
		try (Stream<Path> paths = Files.walk(dir)){
			paths.forEach(System.out::println);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
