package test.program.ewa;

import java.util.ArrayList;
import java.util.List;

public class GrLeadTimeService {
	private final List<GrLeadTime> grLeadTimeList;
	private final GrLeadTimeProcessor chain;
	
	public GrLeadTimeService() {
		this.grLeadTimeList = new ArrayList<GrLeadTime>();
		this.chain = createChain();
	}
	
	public GrLeadTimeService(List<GrLeadTime> grLeadTimeList) {
		this.grLeadTimeList = grLeadTimeList;
		this.chain = createChain();
	}

	private GrLeadTimeProcessor createChain() {
		GrLeadTimeProcessor handler1 = new GrLeadTimeProcessor("handler1", ((gr, prod8d, prodLmn, fdcPostalCode, tptCode, portOfDischarge) ->
				(gr.getProd8d() != null && gr.getProd8d().equals(prod8d))
		        && (gr.getFdcPostalCd() != null && gr.getFdcPostalCd().equals(fdcPostalCode))
		        && (gr.getTptCd() != null && gr.getTptCd().equals(tptCode))
		        && (portOfDischarge != null && portOfDischarge.substring(2, 5).equals(gr.getEtaPort()))),GrLeadTime::getTotalGrLt);
		GrLeadTimeProcessor handler2 = new GrLeadTimeProcessor("handler2", 		
				((gr, prod8d, prodLmn, fdcPostalCode, tptCode, portOfDischarge) ->
				gr.getProd8d() != null && gr.getProd8d().equals(prod8d)
                && (gr.getFdcPostalCd() != null && gr.getFdcPostalCd().equals(fdcPostalCode))
                && gr.getEtaPort() == null
                && (gr.getTptCd() != null && gr.getTptCd().equals(tptCode))),GrLeadTime::getTotalGrLt);
		GrLeadTimeProcessor handler3 = new GrLeadTimeProcessor("handler3",		
				((gr, prod8d, prodLmn, fdcPostalCode, tptCode, portOfDischarge) ->
				(gr.getProdLmn() != null && gr.getProdLmn().equals(prodLmn))
                && (gr.getFdcPostalCd() != null && gr.getFdcPostalCd().equals(fdcPostalCode))
                && (gr.getTptCd() != null && gr.getTptCd().equals(tptCode))
                && gr.getProd8d() == null
                && (portOfDischarge != null && portOfDischarge.substring(2, 5).equals(gr.getEtaPort()))),GrLeadTime::getTotalGrLt);
		GrLeadTimeProcessor handler4 = new GrLeadTimeProcessor("handler4",		
				((gr, prod8d, prodLmn, fdcPostalCode, tptCode, portOfDischarge) ->
				(gr.getProdLmn() != null && gr.getProdLmn().equals(prodLmn))
                && (gr.getFdcPostalCd() != null && gr.getFdcPostalCd().equals(fdcPostalCode))
                && (gr.getTptCd() != null && gr.getTptCd().equals(tptCode))
                && gr.getProd8d() == null
                && (portOfDischarge != null && portOfDischarge.substring(2, 5).equals(gr.getEtaPort()))),GrLeadTime::getTotalGrLt);
		GrLeadTimeProcessor handler5 = new GrLeadTimeProcessor("handler5",				
				((gr, prod8d, prodLmn, fdcPostalCode, tptCode, portOfDischarge)->
				(gr.getProdLmn() != null && gr.getProdLmn().equals(prodLmn))
                && (gr.getFdcPostalCd() != null && gr.getFdcPostalCd().equals(fdcPostalCode))
                && (gr.getTptCd() != null && gr.getTptCd().equals(tptCode))
                && gr.getEtaPort() == null
                && gr.getProd8d() == null),GrLeadTime::getTotalGrLt);
		GrLeadTimeProcessor handler6 = new GrLeadTimeProcessor("handler6",
				((gr, prod8d, prodLmn, fdcPostalCode, tptCode, portOfDischarge)->
				(gr.getFdcPostalCd() != null && gr.getFdcPostalCd().equals(fdcPostalCode))
                && (gr.getTptCd() != null && gr.getTptCd().equals(tptCode))
                && gr.getProd8d() == null && gr.getProdLmn() == null
                && (portOfDischarge != null && portOfDischarge.substring(2, 5).equals(gr.getEtaPort()))
                && gr.getGroup1Code() != null && gr.getGroup2Code() != null && gr.getGroup3Code() != null &&
                gr.getGroup4Code() != null && gr.getGroup5Code() != null && gr.getSupplierCode() != null),GrLeadTime::getTotalGrLt);
		
		handler1.setNext(handler2);
		handler2.setNext(handler3);
		handler3.setNext(handler4);
		handler4.setNext(handler5);
		handler5.setNext(handler6);
		
		return handler1;
	}
	
	public Long process(String prod8d, String prodLmn, String fdcPostalCode, String tptCode, String portOfDischarge) {
		for(GrLeadTime grLt: grLeadTimeList) {
			Long result = chain.process(grLt, prod8d, prodLmn, fdcPostalCode, tptCode, portOfDischarge);
			System.out.println("result: "+result);
//			if (result != 0L) {
//                return result;
//            }
		}
		return 0L;
	}
}
