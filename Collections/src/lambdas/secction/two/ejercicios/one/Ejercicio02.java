package lambdas.secction.two.ejercicios.one;

public class Ejercicio02 {

	public static void main(String[] args) {
		//Se crea objeto o referencia a la interfaz IFunctionTest
		IFunctionTest ft = ()-> System.out.println("Hola Mundo!");
		
		//Cargamos la operacion que recibe como parametro 
		//una funcion lambda
		Ejercicio02 objeto = new Ejercicio02();
		objeto.miMetodo(ft);
	}
	
	public void miMetodo(IFunctionTest parametro) {
		parametro.saludar();
	}

}
