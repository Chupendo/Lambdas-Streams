package lambdas.secction.two.ejercicios.two;

public class OperacionesImp {
	
	//Uso de la expresion lambada.
	private ICalculadoraInt operacion;
	
	public void getAreaCuadrado(int x,int y) {	
		operacion = (lado1,lado2)-> {
				String resultado = ((lado1<=0 || lado2<=0) && (lado1!=lado2))?"No es un curadro":"lado*lado="+lado1+"*"+lado2+"="+lado1*lado2;
				System.out.println(resultado);
			};
		operacion.area(x, y);
	}
	
	public void getAreaRectangulo(int x,int y) {	
		operacion = (lado1,lado2)-> {
				String resultado = (lado1<=0 || lado2<=0)?"No es un triganulo":"lado*lado="+lado1+"*"+lado2+"="+lado1*lado2;
				System.out.println(resultado);
			};
		operacion.area(x, y);
	}
	
	
}
