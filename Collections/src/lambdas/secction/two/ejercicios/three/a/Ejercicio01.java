package lambdas.secction.two.ejercicios.three.a;

public class Ejercicio01 {

	public static void main(String[] args) {
		//Se crea objeto o referencia a la interfaz IFunctionTest
		IOperaciones cuadrado = (lado1,lado2)-> {
			String resultado = (lado1!=lado2)?"No es un curadro":"lado*lado="+lado1+"*"+lado2+"="+lado1*lado2;
			return resultado;
			
		};
		
		//Uso de la expresion lambada.
		System.out.println(cuadrado.area(1, 2));

	}


}
