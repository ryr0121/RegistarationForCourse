package view;

import java.io.IOException;
import java.util.Scanner;

public class VInitial {

	private VHwewonDeungrok vHwewonDeungrok;
	public VInitial() {
		this.vHwewonDeungrok = new VHwewonDeungrok();
	}

	public void show() {
		System.out.println("다음 기능을 선택 하세요");
		System.out.println("로그인(1) , 회원등록(2)");
		
		try {
			int input = System.in.read();
			
			if(input == '1') {
				// login dialog show
				
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				System.out.println("아이디(학번)를 입력하세요 : ");
				int id = sc.nextInt();
				this.vHwewonDeungrok.login(id);
			} else if(input == '2') {
				this.vHwewonDeungrok.show();
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
