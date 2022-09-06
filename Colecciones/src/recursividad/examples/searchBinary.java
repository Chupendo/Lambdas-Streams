package recursividad.examples;

import java.util.Scanner;

public class searchBinary {

	public static int NUMBER = 4;

	public static void main(String[] args) {
		int[] number = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		//int[] number = { 0};
		int op = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("Inserte el elemento a buscar: ");
			op = sc.nextInt();
			if (op != -2) {
				printArray(number);
				int r = iterativeSearch(number,op);
				if (r != -1)
					System.out.println("Posicion: " + r + ", elemento= " + number[r]);
				
				else
					System.out.println("Elemento no encontrado");
				//Recursive
				System.out.println("Recursive.");
				r= recursiveSearch(number, op);
				if (r != -1)
					System.out.println("Posicion: " + r + ", elemento= " + number[r]);
				
				else
					System.out.println("Elemento no encontrado");
			}
		} while (op != -2);

	}

	/**
	 * Busqueda binaria iterativo
	 * @param arrayToSearch
	 * @param element
	 * @return
	 */
		public static int iterativeSearch(int[] arrayToSearch, int element) {
	    int lowIndex = 0;
	    int highIndex = arrayToSearch.length-1;

	    // Holds the position in array for given element
	    // Initial negative integer set to be returned if no match was found on array
	    int elementPos = -1;

	    // If lowIndex less than highIndex, there's still elements in the array
	    while (lowIndex <= highIndex) {
	        int midIndex = (lowIndex + highIndex) / 2;
	        if (element == arrayToSearch[midIndex]) {
	            elementPos = midIndex;
	            break;
	        } else if (element < arrayToSearch[midIndex]) {
	            highIndex = midIndex-1;
	        } else if (element > arrayToSearch[midIndex]) {
	            lowIndex = midIndex+1;
	        }
	    }
	    return elementPos;
	}

    /**
     * Busqueda binaria recurisva
     * @param arrayToSearch
     * @param element
     * @return
     */
	public static int recursiveSearch(int[] arrayToSearch, int element) {
	    return recursiveSearch(arrayToSearch, element, 0, arrayToSearch.length-1);
	}

	private static int recursiveSearch(int[] arrayToSearch, int element, int lowIndex, int highIndex) {
	    // If lowIndex surpasses highIndex, the element has not been found
	    if (lowIndex > highIndex) return -1;

	    // Default assumption is that the element is not found
	    int elementPos = -1;

	    int midIndex = (lowIndex + highIndex) / 2;

	    if (element == arrayToSearch[midIndex]) {
	    	System.out.println("Bingo!! "+midIndex);
	        elementPos = midIndex;
	    } else if (element < arrayToSearch[midIndex]) {
	    	elementPos = recursiveSearch(arrayToSearch, element, lowIndex, midIndex-1);
	    } else if (element > arrayToSearch[midIndex]) {
	    	elementPos = recursiveSearch(arrayToSearch, element, midIndex+1, highIndex);
	    }
	    return elementPos;
	}
	
	/**
	 * Muestra un array
	 * @param array
	 */
	public static void printArray(int[] array) {
		System.out.print("array = {");
		for (int i = 0; i < array.length; i++) {
			System.out.print(" " + array[i]);
		}
		System.out.println(" }");
	}
}
