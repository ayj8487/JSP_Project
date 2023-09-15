package dto;

public class Order1_detail {

	private String order_date;		// 주문일자
	private int custcode;			// 거래처 코드
	private int item_code;			// 제품코드
	private String item_order_desc;	// 제품요청내용
	private String cancel;			// 반품구분
	
	private String custname; // Custom TBL join 조회용
	private String item_name; // Item TBL join 조회용
	
	
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public int getCustcode() {
		return custcode;
	}
	public void setCustcode(int custcode) {
		this.custcode = custcode;
	}
	public int getItem_code() {
		return item_code;
	}
	public void setItem_code(int item_code) {
		this.item_code = item_code;
	}
	public String getItem_order_desc() {
		return item_order_desc;
	}
	public void setItem_order_desc(String item_order_desc) {
		this.item_order_desc = item_order_desc;
	}
	public String getCancel() {
		return cancel;
	}
	public void setCancel(String cancel) {
		this.cancel = cancel;
	}
	
	
	
}
