package view;

import java.util.Scanner;

import controll.CHwewonDeungrok;
import valueObject.OHwewon;

public class VHwewonDeungrok {
	
	private CHwewonDeungrok cHwewonDeungrok;

	public VHwewonDeungrok() {
		cHwewonDeungrok = new CHwewonDeungrok();
	}
	
	public void show() {
		System.out.println("LHwewonDeungrok::show()");
		
		OHwewon oHwewon = new OHwewon();
		// ����ڿ��� ���� �Է¹޾�
		int id;	String name; String address; int hwakgwa;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�й��� �Է����ּ���");
		id = sc.nextInt();
		System.out.println("�̸��� �Է����ּ���");
		name = sc.next();
		System.out.println("�ּҸ� �Է����ּ���");
		address = sc.next();
		System.out.println("�а�(�а��� ��ȣ)�� �Է����ּ���");
		hwakgwa = sc.nextInt();
		
		// oHwewon�� ����
		oHwewon.setHwewon(id, name, address, hwakgwa);
		sc.close();
		
		this.cHwewonDeungrok.saveHwewon(oHwewon);
	}
	
	public void login(int id) {
		System.out.println("LHwewonDeungrok::login(int id)");
		//
		OHwewon oHwewon = this.cHwewonDeungrok.readHwewon(id);
		if(oHwewon != null) {
			System.out.println("[�α��� ����]�α��� �� ȸ�������� ������ �����ϴ�.");
			oHwewon.printInfo();
		}
	}
}
