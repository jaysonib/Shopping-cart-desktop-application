package DatabaseConnection;

public class Test {

	String s1[][];
	
	Test(){
		String s2[][] = {{"12","ab"}};
		
		s1 = new String[s2.length][s2[0].length];
		
	}
	
	public static void main(String args[]) {
		Test t1 = new Test();
		System.out.println(t1.s1);
	}
}
