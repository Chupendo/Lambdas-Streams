package lambdas.secction.two.ejercicios.three.a;

public class OperacionesImp {

	// Uso de la expresion lambada.
	private IOperaciones operacion;

	public void getAreaCuadrado(int x, int y) {
		operacion = (lado1, lado2) -> {
			return ((lado1 <= 0 || lado2 <= 0) && (lado1 != lado2)) ? "No es un curadro"
					: "lado*lado=" + lado1 + "*" + lado2 + "=" + lado1 * lado2;
		};
		System.out.println(operacion.area(x, y));
	}

	public void getAreaRectangulo(int x, int y) {
		operacion = (lado1, lado2) -> {
			return (lado1 <= 0 || lado2 <= 0) ? "No es un triganulo"
					: "lado*lado=" + lado1 + "*" + lado2 + "=" + lado1 * lado2;
		};
		System.out.println(operacion.area(x, y));
	}
}
