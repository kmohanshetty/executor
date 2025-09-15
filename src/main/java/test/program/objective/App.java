package test.program.objective;

public class App {
	public static void main(String[] args) {
		String[] starr = { "J", "a", "v", "a", "8" };
		for (int i = 0; i < starr.length; i++) {
			switch (starr[i]) {
			case "J":
				System.out.print("J");
				continue;
			case "a":
				System.out.print("a");
				continue;
			case "v":
				System.out.print("v");
				continue;
			case "8":
				System.out.print("8");
				break;
			}
		}
		System.out.println();
//		String name;
//		System.out.println(name);
		
//		App appObj = new App();
//		System.out.println(appObj.howMany(true, {true, true));
		
		StringBuilder sb1 = new StringBuilder("Duke");
		String str1 = sb1.toString();
		
//		String str2 = "Duke";
//		String str2 = str1;
		String str2 = sb1.toString();
		System.out.println(str1 == str2);
	}
	
	public int howMany(boolean b, boolean... b2) {
		return b2.length;
	}
}
