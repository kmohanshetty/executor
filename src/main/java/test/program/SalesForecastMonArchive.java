package test.program;

import java.io.Serializable;

public class SalesForecastMonArchive implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long salesFctMonArchiveId;
	private String compCode;
	private String planningSiteCode;
	private String prod8D;
	private String prodLmn;
	private Character sellInTypeCd;
	private Long monNo;
	private Long sellInQty;
	private Character forecastType;
	private String extSystem;
	private Character isDeleted;

	public SalesForecastMonArchive() {
		// TODO Auto-generated constructor stub
	}

	public SalesForecastMonArchive(Long salesFctMonArchiveId, String compCode, String planningSiteCode, String prod8d,
			String prodLmn, Character sellInTypeCd, Long monNo, Long sellInQty, Character forecastType,
			String extSystem, Character isDeleted) {
		super();
		this.salesFctMonArchiveId = salesFctMonArchiveId;
		this.compCode = compCode;
		this.planningSiteCode = planningSiteCode;
		prod8D = prod8d;
		this.prodLmn = prodLmn;
		this.sellInTypeCd = sellInTypeCd;
		this.monNo = monNo;
		this.sellInQty = sellInQty;
		this.forecastType = forecastType;
		this.extSystem = extSystem;
		this.isDeleted = isDeleted;
	}

	public Long getSalesFctMonArchiveId() {
		return salesFctMonArchiveId;
	}

	public String getCompCode() {
		return compCode;
	}

	public String getPlanningSiteCode() {
		return planningSiteCode;
	}

	public String getProd8D() {
		return prod8D;
	}

	public String getProdLmn() {
		return prodLmn;
	}

	public Character getSellInTypeCd() {
		return sellInTypeCd;
	}

	public Long getMonNo() {
		return monNo;
	}

	public Long getSellInQty() {
		return sellInQty;
	}

	public Character getForecastType() {
		return forecastType;
	}

	public String getExtSystem() {
		return extSystem;
	}

	public Character getIsDeleted() {
		return isDeleted;
	}
	
	
	@Override
	public String toString() {
		return "SalesForecastMonArchive [salesFctMonArchiveId=" + salesFctMonArchiveId + ", compCode=" + compCode
				+ ", planningSiteCode=" + planningSiteCode + ", prod8D=" + prod8D + ", prodLmn=" + prodLmn
				+ ", sellInTypeCd=" + sellInTypeCd + ", monNo=" + monNo + ", sellInQty=" + sellInQty + ", forecastType="
				+ forecastType + ", extSystem=" + extSystem + ", isDeleted=" + isDeleted + "]";
	}
}
