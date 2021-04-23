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
		// 사용자에게 정보 입력받아
		int id;	String name; String address; int hwakgwa;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("학번을 입력해주세요");
		id = sc.nextInt();
		System.out.println("이름을 입력해주세요");
		name = sc.next();
		System.out.println("주소를 입력해주세요");
		address = sc.next();
		System.out.println("학과(학과의 번호)를 입력해주세요");
		hwakgwa = sc.nextInt();
		
		// oHwewon에 저장
		oHwewon.setHwewon(id, name, address, hwakgwa);
		sc.close();
		
		this.cHwewonDeungrok.saveHwewon(oHwewon);
	}
	
	public void login(int id) {
		System.out.println("LHwewonDeungrok::login(int id)");
		//
		OHwewon oHwewon = this.cHwewonDeungrok.readHwewon(id);
		if(oHwewon != null) {
			System.out.println("[로그인 성공]로그인 한 회원정보는 다음과 같습니다.");
			oHwewon.printInfo();
		}
	}
}
