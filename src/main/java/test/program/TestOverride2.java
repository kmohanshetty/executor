package test.program;

public class TestOverride2 {

	public static void main(String[] args) {
		int i = 10;
		System.out.println(i.toString());
	}
}

class Color {
	public String getColor(){
		
		return "";
	}
}

class Red extends Color{
	protected String getColor(){
		
		return "";
	}
}