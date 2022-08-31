package core;

import java.util.ArrayList;
import java.util.Iterator;

public class TestIterrator {
	

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		names.add("A");
		names.add("B");
		names.add("C");
		names.add("D");

		Iterator<String> it = names.iterator();
		while (it.hasNext()) {
			String i = it.next();
			System.out.println(i);
		}
		System.out.println(names);
	}

}
