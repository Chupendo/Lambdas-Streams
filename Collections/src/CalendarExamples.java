import java.util.Calendar;

public class CalendarExamples {

	public static void main(String[] args) {
		
		//Fecja actual (del sistme)
		Calendar calendarActual = Calendar.getInstance();
		System.out.println("date: " + calendarActual.get(Calendar.DATE));
		System.out.println("date: " + calendarActual.get(Calendar.MONTH));
		System.out.println("date: " + calendarActual.get(Calendar.YEAR));
		
		
		//Calculo del mes vencido
		Calendar calendarVencido = Calendar.getInstance();
		calendarVencido.set(2016, 0, 5);
		System.out.println("Mes actual (insertada a pincho):");
		System.out.println("date: " + calendarVencido.get(Calendar.DATE));
		System.out.println("date: " + calendarVencido.get(Calendar.MONTH));
		System.out.println("date: " + calendarVencido.get(Calendar.YEAR));
		System.out.println("Mes vencido:");
		if (calendarVencido.get(Calendar.MONTH) == 0) {
			// Corresponde el mes de Enero, por lo que el mes vencio es del año anterior
			calendarVencido.set(Calendar.DATE, 1);
			calendarVencido.set(Calendar.MONTH, 11);//Mes de 0 a 11
			calendarVencido.set(Calendar.YEAR, calendarVencido.get(Calendar.YEAR) - 1);
		}else {
			calendarVencido.set(Calendar.DATE, 1);
			calendarVencido.set(Calendar.MONTH, calendarVencido.get(Calendar.MONTH) - 1);
			calendarVencido.set(Calendar.YEAR, calendarVencido.get(Calendar.YEAR) - 1);
		}
		System.out.println("date: " + calendarVencido.get(Calendar.DATE));
		System.out.println("date: " + calendarVencido.get(Calendar.MONTH));
		System.out.println("date: " + calendarVencido.get(Calendar.YEAR));
	}
}
