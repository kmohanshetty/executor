package test.design.pattern.behavioral;
/*
 * Chain of responsibility pattern is used to achieve loose coupling in software design 
   where a request from the client is passed to a chain of objects to process them
 * Later, the object in the chain will decide themselves who will be processing the 
   request and whether the request is required to be sent to the next object in the chain or not
   
   Where and When Chain of Responsibility pattern is applicable :
    * When you want to decouple a request’s sender and receiver
    * Multiple objects, determined at runtime, are candidates to handle a request
    * When you don’t want to specify handlers explicitly in your code
    * When you want to issue a request to one of several objects without specifying the receiver explicitly.
    * 
 */
abstract class Logger {
	protected Logger nextLogger;

	public void setNextLogger(Logger nextLogger){
		this.nextLogger = nextLogger;
	}

	public void logMessage(String message){
		log(message);
		if(nextLogger !=null){
			nextLogger.logMessage(message);
		}
	}
	abstract protected void log(String message);  
}
class ConsoleLogger extends Logger {
	public ConsoleLogger(){
	}
	@Override
	protected void log(String message) {    
		System.out.println("Console::Logger: " + message);
	}
}
class EMailLogger extends Logger {
	public EMailLogger(){
	}
	@Override
	protected void log(String message) {    
		System.out.println("EMail::Logger: " + message);
	}
}
class FileLogger extends Logger {
	public FileLogger(){
	}
	@Override
	protected void log(String message) {    
		System.out.println("File::Logger: " + message);
	}
}
public class ChainOfResponsiblityTest {

	private static Logger getChainOfLoggers(){
		Logger emailLogger = new EMailLogger();
		Logger fileLogger = new FileLogger();
		Logger consoleLogger = new ConsoleLogger();
		emailLogger.setNextLogger(fileLogger);
		fileLogger.setNextLogger(consoleLogger);
		return emailLogger;  
	}

	public static void main(String[] args) {
		Logger loggerChain = getChainOfLoggers();
		loggerChain.logMessage("Null pointer");
		loggerChain.logMessage("Array Index Out of Bound");
		loggerChain.logMessage("Illegal Parameters");
	}

}
