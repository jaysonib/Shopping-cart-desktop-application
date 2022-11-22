public class Test {


	
	Test(){

	}
	
	public static void main(String args[]) {
		String s1[][];
		String s2[][] = {{"12","ab"}};
		s1 = s2;
		System.out.println(s1[0][0]);
	}
}
