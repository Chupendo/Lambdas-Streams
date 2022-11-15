package lambdas.secction.five.copyCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CopyColletionsDemo {

	public static void main(String[] args) {
		Collection<String> data1 = Arrays.asList("1", "2", "3", "4");
		Collection<String> data2 = Arrays.asList("5", "6", "7", "8");
		Collection<String> data3 = Arrays.asList("9", "10", "11", "12");
		Collection<String> data = new ArrayList<String>();

		data = concatenate(data, data2);
		System.out.print("Concatenacion 1: {");
		data.forEach(dat -> System.out.print(" " + dat));
		System.out.println(" }");

		data = new ArrayList<String>();
		data = concatenate(data, data1, data2, data3);
		System.out.print("Concatenacion 2: {");
		data.forEach(dat -> System.out.print(" " + dat));
		System.out.println(" }");

	}

	/**
	 * Formas de concanctera una colección
	 */
	// Pipeline Stream
	// Método genérico para concatenar varias listas en Java
	public static <T> Collection<T> concatenate(Collection<T>... lists) {
		return Stream.of(lists)
				.flatMap(x -> x.stream())
				.collect(Collectors.toList());
	}

	// Método genérico para concatenar varias listas en Java
	public static <T> List<T> concatenate(List<T>... lists) {
		return Stream.of(lists)
				.flatMap(x -> x.stream())
				.collect(Collectors.toList());
	}

	// Stream + forEach
	
	// Método genérico para concatenar varias listas en Java
	public static <T> List<T> concatenateForEach1(List<T>... lists) {
		List<T> result = new ArrayList<>();
		Stream.of(lists).forEach(result::addAll);

		return result;
	}
	// Método genérico para concatenar varias listas en Java
	public static <T> List<T> concatenateForEach2(List<T>... lists) {
		List<T> result = new ArrayList<>();

		for (List<T> l : lists) {
			result.addAll(l);
		}

		return result;
	}

		

	// Método genérico para concatenar varias listas en Java
		public static <T> List<T> concatenateForEach3(List<T>... lists) {
			return new ArrayList<T>() {
				{
					for (List<T> l : lists) {
						addAll(l);
					}
				}
			};
		}
	// Método genérico para concatenar varias listas en Java
	public static <T> List<T> concatenateConcat(List<T>... lists) {
		Stream<T> stream = Stream.of();
		for (List<T> l : lists) {
			stream = Stream.concat(stream, l.stream());
		}

		return stream.collect(Collectors.toList());
	}
}
