package lambdas.secction.five.autcoseable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFileWithAutocloseable {
	private static final String nFile = "C:\\Users\\andres.rpenuela\\Downloads\\eclipse-jee-2022-03-R-win32-x86_64\\workspace\\Lambdas-Streams\\Colecciones\\src\\lambdas\\secction\\five\\autcoseable\\readme.txt";

	public static void main(String[] args) {
		int i;

		try (MyResource res = new MyResource()) {
			// use resource here, exmaple:
			
			// The following code uses a try-with-resources statement to open
			// a file and then automatically close it when the try block is left.
			try (FileInputStream fin = new FileInputStream(nFile)) {

				do {
					i = fin.read();
					if (i != -1)
						System.out.print((char) i);
				} while (i != -1);
				//fin.close(); //No es necesario, cuadno finaliza el bloque try() de MyResource lo cierra automaticmaente
			} catch (FileNotFoundException e) {
				System.out.println("File Not Found.");
			} catch (IOException e) {
				System.out.println("An I/O Error Occurred");
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public static class MyResource implements AutoCloseable {
		@Override
		public void close() throws Exception {
			System.out.println("Closing!");
		}
	}
}
