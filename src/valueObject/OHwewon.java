package valueObject;

public class OHwewon {

	private int id;
	private String name;
	private String address;
	private int hwakgwa;
	
	public OHwewon() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public int getHwakgwa() {
		return this.hwakgwa;
	}
	
	public void setHwewon(int id, String name, String address, int hwakgwa) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.hwakgwa = hwakgwa;
	}
	
	public void printInfo() {
		System.out.println("�й� : " + this.id);
		System.out.println("�̸� : " + this.name);
		System.out.println("�ּ� : " + this.address);
		System.out.println("�а���ȣ : " + this.hwakgwa);
	}
}
