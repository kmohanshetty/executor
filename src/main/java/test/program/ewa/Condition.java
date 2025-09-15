package test.program.ewa;

public interface Condition {
	boolean matches(GrLeadTime gr, 
			String fdcPostalCd, 
			String prodLmn, 
			String fdcPostalCode, 
			String tptCode, 
			String portOfDischarge);
}
