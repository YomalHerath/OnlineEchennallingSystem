package payment.model;

public class Payment {
	
	private int pId;
	private String cardName;
	private String cardNo;
	private int secCode;
	private String expMonth;
	private String expYear;
	private int patientId;
	
	public Payment() {
		
	}

	public Payment(int pId, String cardName, String cardNo, int secCode, String expMonth, String expYear, int patientId) {
		super();
		this.pId = pId;
		this.cardName = cardName;
		this.cardNo = cardNo;
		this.secCode = secCode;
		this.expMonth = expMonth;
		this.expYear = expYear;
		this.patientId = patientId;
	}

	public Payment(String cardName, String cardNo, int secCode, String expMonth, String expYear,int patientId) {
		super();
		this.cardName = cardName;
		this.cardNo = cardNo;
		this.secCode = secCode;
		this.expMonth = expMonth;
		this.expYear = expYear;
		this.patientId = patientId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public int getSecCode() {
		return secCode;
	}

	public void setSecCode(int secCode) {
		this.secCode = secCode;
	}

	public String getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}

	public String getExpYear() {
		return expYear;
	}

	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}

	@Override
	public String toString() {
		return "Payment [pId=" + pId + ", cardName=" + cardName + ", cardNo=" + cardNo + ", secCode=" + secCode
				+ ", expMonth=" + expMonth + ", expYear=" + expYear + ", patientId=" + patientId + "]";
	}

}
