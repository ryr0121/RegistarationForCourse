package model;

public class MHwewon{

	private int id;
	private String name;
	private String address;
	private int hwakgwa;
	
	public MHwewon() {
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

}
