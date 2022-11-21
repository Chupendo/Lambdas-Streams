/**
 * 
 */
package lamdas.secction.six.ejercicio.one;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.util.Random;
import java.util.stream.Stream;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * @author andres.rpenuela
 *
 */
public class Seed {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String seed = stringSeed(512);
		System.out.println("Seed: "+seed
				+"\nlength: "+seed.length()
				+"\nbits: "+seed.length()*8);
		
		Integer seedInt = intSeed(255);
		System.out.println("Seed: "+seedInt
				+"\nlength: "+seedInt.SIZE
				+"\nbits: "+seedInt.SIZE*8);
	}
	
	static String stringSeed(int nBits) {
		int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = nBits/8;
	    Random random = new Random();
	    // seed alfanumerico
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
		return generatedString;
	}
	
	static Integer intSeed(int nBits) {
		int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = nBits/8;
	    Random random = new Random();
	    // seed alfanumerico
	    int generatedString = random.nextInt();
	    String rsr = random.ints(0, 9).limit(256).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
	    System.out.println("rsr: "+rsr);
		return generatedString;
	}
	
}
