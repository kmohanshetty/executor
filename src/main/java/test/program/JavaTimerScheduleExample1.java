package test.program;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class JavaTimerScheduleExample1 {  
	public static void main(String[] args) { 
		Timer timer = new Timer();
        TimerTask task = new Helper();
        timer.schedule(task, 2000, 1000);
	}  
}  

class Helper extends TimerTask {
	public static int i = 0;
	@Override
	public void run() {
		System.out.println("Timer ran "+ (new Date()) + ++i);
	}
	
}