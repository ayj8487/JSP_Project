package dto;

public class Custom {

	private int custcode;		// 거래처 코드
	private String custname;	// 거래처명
	private String cust_tel;	// 거래처 전화번호
	private String cust_gubun;	// 거래처 구분
	private String cust_ceo;	// 거래처 대표
	
	public int getCustcode() {
		return custcode;
	}
	public void setCustcode(int custcode) {
		this.custcode = custcode;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getCust_tel() {
		return cust_tel;
	}
	public void setCust_tel(String cust_tel) {
		this.cust_tel = cust_tel;
	}
	public String getCust_gubun() {
		return cust_gubun;
	}
	public void setCust_gubun(String cust_gubun) {
		this.cust_gubun = cust_gubun;
	}
	public String getCust_ceo() {
		return cust_ceo;
	}
	public void setCust_ceo(String cust_ceo) {
		this.cust_ceo = cust_ceo;
	}


}
