package lambdas.delete.duplicates;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DeleteDuplicates {
	private static final String rutaArchivoExcel = "C:\\Users\\andres.rpenuela\\Downloads\\eclipse-jee-2022-03-R-win32-x86_64\\workspace\\Lambdas-Streams\\Colecciones\\src\\lambdas\\delete\\duplicates\\56442.xlsx";

	public static void main(String[] args) {
		List<Somatic> lSomatic = new ArrayList<Somatic>();

		try (MyResource res = new MyResource()) {
			FileInputStream inputStream = new FileInputStream(new File(rutaArchivoExcel));
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet firstSheet = workbook.getSheetAt(0);
			Iterator iterator = firstSheet.iterator();

			DataFormatter formatter = new DataFormatter();
			while (iterator.hasNext()) {
				Somatic sm = new Somatic();
				boolean head = false;
				short count = 0;

				Row nextRow = (Row) iterator.next();
				Iterator cellIterator = nextRow.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = (Cell) cellIterator.next();
					if (head) {
						String contenidoCelda = formatter.formatCellValue(cell);
						System.out.println("celda: " + contenidoCelda);
						switch (count) {
						case 0:
							sm.setNumeroPoliza(Integer.parseInt(contenidoCelda));
							count++;
							break;
						case 1:
							sm.setTomador(contenidoCelda);
							count++;
							break;
						case 2:
							sm.setTomadorDni(contenidoCelda);
							count++;
							break;
						case 3:
							Date date = new Date(contenidoCelda);
							sm.setEfectoPoliza(date);
							count++;
							break;
						}
						lSomatic.add(sm);
					} else {
						head = true;
					}

				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
		} catch (IOException e) {
			System.out.println("An I/O Error Occurred");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//
		lSomatic.forEach(System.out::println);

	}

	public static class MyResource implements AutoCloseable {
		@Override
		public void close() throws Exception {
			System.out.println("Closing!");
		}
	}

}
