package lambadas.secction.three.intro;

/*
 * Ejemplo de problem�tica gue se puede dar con expresiones Lambda
 * El m�todo "engine" es un m�todo sobrecargado, porque tiene el mismo nombre pero recibe parametros diferentes
 * 
 * Con la inferencia de tipo, va a permitir no pasar el tipo de par�metro por defecto, ya que el compilador se encarga de detectarlo e incluso, puede detemrinar a que intefaz funcional hace reefencia la expresion lambda dado el contexto, pero si hacemos una llamada al m�todo "engine" y le pasamos dos parametros
 *
 *	engine((x,y)->{x+y});
 *
 * El compilador va tener un conflicto y nos idnicara que el m�todo referciado "engine" es amb�g�o, porque hay dos metodos iguales ambos reciben dos paraemtros de entrada, y por tnato el compilador no sabe a cual se refiere la expresi�n lambda.
 *
 *	En este caso, se produce una ambig�edad por el tipo de par�metros, para evitar esto, se puede:
 * 	a)	Indicar expl�citamente, cual es tipo de par�metros que recibe la expresi�n lambda
 *		engine((int x,int y)->{x+y} );
 * 	b)	Un cast de la interfaz funcional si no se desea poner el tipo de par�metros
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
