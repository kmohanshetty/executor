package test.program.ewa;

import java.util.ArrayList;
import java.util.List;

public class EWATest {

	public static void main(String[] args) {
		List<GrLeadTime> grLeadTimeList = new ArrayList<GrLeadTime>();
		
		GrLeadTime grLeadTime1 = new GrLeadTime();
		grLeadTime1.setProd8d("32945883");
		grLeadTime1.setProdLmn("ADKIT77.WW");
		grLeadTime1.setFdcPostalCd("CH6");
		grLeadTime1.setTptCd("8");
		grLeadTime1.setEtaPort("DXB");
		grLeadTime1.setTotalGrLt(20L);
		grLeadTimeList.add(grLeadTime1);
		
		GrLeadTime grLeadTime2 = new GrLeadTime();
		grLeadTime2.setProd8d("32945883");
		grLeadTime2.setProdLmn("ADKIT77.WW");
		grLeadTime2.setFdcPostalCd("CH6");
		grLeadTime2.setTptCd("8");
		grLeadTime2.setEtaPort(null);
		grLeadTime2.setTotalGrLt(30L);
		grLeadTimeList.add(grLeadTime2);
		
		GrLeadTimeService service = new GrLeadTimeService(grLeadTimeList);
//		GrLeadTimeService service = new GrLeadTimeService();
		String prod8d = "32945883";
		String prodLmn = "ADKIT77.WW"; 
		String fdcPostalCode = "CH6"; 
		String tptCode = "8"; 
		String portOfDischarge = "AEDXB";
		
		System.out.println(service.process(prod8d, prodLmn, fdcPostalCode, tptCode, portOfDischarge));
		
	}

}
