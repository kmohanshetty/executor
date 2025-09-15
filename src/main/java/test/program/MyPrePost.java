package test.program;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MyPrePost {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		Class<?> forName = Class.forName("test.program.MyPrePost");
		MyPrePost annotation = (MyPrePost) forName.newInstance();
		System.out.println(annotation);
		try{
			int res = 0/0;
			System.out.println(res);
		}finally{
			System.out.println("finally");
		}
	}
	
	@PostConstruct
    public void initIt() throws Exception {
        System.out.println("Initializing the property. The message is: " );
    }
    
    @PreDestroy
    public void cleanUp() throws Exception {
        System.out.println("Clean up done.");
    }

}
