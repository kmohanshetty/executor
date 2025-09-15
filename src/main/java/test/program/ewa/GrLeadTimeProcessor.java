package test.program.ewa;

public class GrLeadTimeProcessor {
	private final String name;
	private final Condition condition;
    private final Action action;
    private GrLeadTimeProcessor next;
    
    
	public GrLeadTimeProcessor(String name, Condition condition, Action action) {
		super();
		this.name = name;
		this.condition = condition;
		this.action = action;
	}


	public void setNext(GrLeadTimeProcessor next) {
		this.next = next;
	}
    
	
	public Long process(GrLeadTime gr, String prod8d, String prodLmn, String fdcPostalCode, String tptCode, String portOfDischarge) {
        if (condition.matches(gr, prod8d, prodLmn, fdcPostalCode, tptCode, portOfDischarge)) {
        	System.out.println("Handler picked: " + name);
            return action.execute(gr);
        } else if (next != null) {
        	System.out.println("Handler in comparision: " + name);
            return next.process(gr, prod8d, prodLmn, fdcPostalCode, tptCode, portOfDischarge);
        }
        return 0L;
    }
    

}
