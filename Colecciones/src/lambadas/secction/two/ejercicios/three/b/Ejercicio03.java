package lambadas.secction.two.ejercicios.three.b;

public class Ejercicio03 {

	public static void main(String[] args) {
		System.out.print("SUMA ->");
		ICalculadora sumar = (a,b)-> a+b;
		engine(sumar);
		System.out.print("RESTA ->");
		engine((a,b)-> a-b);
		System.out.print("MULTIPLICACION ->");
		engine((a,b)-> a*b);
		System.out.print("RESTA ->");
		engine((a,b)-> a/(double)b);
		System.out.print("MODULO ->");
		engine((a,b)-> a%(double)b);
	}
	
	public static void engine(ICalculadora calculadora) {
		int x=33,y=24;
		double z = calculadora.calcular(x, y);
		
		System.out.println("resultado: "+z);
		
	}
}
