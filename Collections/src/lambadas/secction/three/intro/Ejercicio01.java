package lambadas.secction.three.intro;

/*
 * Ejemplo de problemática gue se puede dar con expresiones Lambda
 * El método "engine" es un método sobrecargado, porque tiene el mismo nombre pero recibe parametros diferentes
 * 
 * Con la inferencia de tipo, va a permitir no pasar el tipo de parámetro por defecto, ya que el compilador se encarga de detectarlo e incluso, puede detemrinar a que intefaz funcional hace reefencia la expresion lambda dado el contexto, pero si hacemos una llamada al método "engine" y le pasamos dos parametros
 *
 *	engine((x,y)->{x+y});
 *
 * El compilador va tener un conflicto y nos idnicara que el método referciado "engine" es ambígüo, porque hay dos metodos iguales ambos reciben dos paraemtros de entrada, y por tnato el compilador no sabe a cual se refiere la expresión lambda.
 *
 *	En este caso, se produce una ambigüedad por el tipo de parámetros, para evitar esto, se puede:
 * 	a)	Indicar explícitamente, cual es tipo de parámetros que recibe la expresión lambda
 *		engine((int x,int y)->{x+y} );
 * 	b)	Un cast de la interfaz funcional si no se desea poner el tipo de parámetros
 *		engine( (ICalculadoraInt) (x,y)->{x+y} );
 *	c)	Crear una referencia de la interfaz previa.
 *		ICalculadoraInt calInt = (x,y)->x+y;
 *		engine (calInt);
 */
public class Ejercicio01 {

	public static void main(String[] args) {
		engige((x,y)->x+y);
		//engige((int x,int y)->x+y);
		//engige((ICalculadoraLong)(x,y)->x+y);
		/*
		 ICalculadoraInt calInt = (x,y)->x+y;
		 engine (calInt);
		 */
	}

	
	public static void engige(ICalculadoraInt cal) {
		cal.calculate(3, 5);
	}

	public static void engige(ICalculadoraLong cal) {
		cal.calculate(3, 5);
	}
}
