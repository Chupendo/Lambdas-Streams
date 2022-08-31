package core;

public class TestStringContains {

	public static void main(String[] args) {
        System.out.println("Welcome to Online IDE!! Happy Coding :)");
        String name1 = "adriano antonio romero romero";
        String name2 = "adriano romero romero";
        String fragmentName[] = name1.split(" ");
        
        for(int i=0;i<fragmentName.length;i++){
            System.out.println(name2.contains(fragmentName[i]));
        }
        
    }

}
