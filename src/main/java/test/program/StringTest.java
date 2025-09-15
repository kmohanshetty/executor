package test.program;

class StringTest {

	public static void main(String[] args) {
		String s = "ABC";
		String abc = new String("ABC");
		String abc2 = new String("ABC");
		String s2 = "ABC";
		
		System.out.println(s+" "+s.hashCode());
		System.out.println((s == abc));
		System.out.println((s == s2));
		System.out.println((abc == abc2));
		System.out.println(s2+" "+s2.hashCode());
		System.out.println(abc+" "+abc.hashCode());
		System.out.println(abc2+" "+abc2.hashCode());
	}

}
