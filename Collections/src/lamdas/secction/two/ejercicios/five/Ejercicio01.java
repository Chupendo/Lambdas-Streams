package lambadas.secction.two.ejercicios.five;

public class Ejercicio01 {

	public static void main(String[] args) {
		IOperaciones areaCuadrado = calAreaCuadrado();
		areaCuadrado.area(3, 4);
	}

	/*
	 * Función que devuelve una interfaz funcional como parámetro
	 */
	private static IOperaciones calAreaCuadrado() {
		double pi=3.1416;
		return (lado1, lado2) -> {
			String resultado = ((lado1 <= 0 || lado2 <= 0) && (lado1 != lado2)) ? "No es un cuadrado"
					: "lado*lado=" + lado1 + "*" + lado2 + "=" + lado1 * lado2;
			System.out.println(pi);
			pi=lado1*lado2;
			System.out.println(resultado);
			
		};
	}
}
