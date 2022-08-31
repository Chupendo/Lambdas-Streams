package lambadas.secction.two.ejercicios.one;

public class Ejercicio01 {

	public static void main(String[] args) {
		//Se crea objeto o referencia a la interfaz IFunctionTest
		IFunctionTest ft = ()-> System.out.println("Hola Mundo!");
		
		//Uso de la expresion lambada.
		ft.saludar();

	}

}
