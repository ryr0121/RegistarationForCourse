package view;

import java.io.IOException;
import java.util.Scanner;

public class VInitial {

	private VHwewonDeungrok vHwewonDeungrok;
	public VInitial() {
		this.vHwewonDeungrok = new VHwewonDeungrok();
	}

	public void show() {
		System.out.println("���� ����� ���� �ϼ���");
		System.out.println("�α���(1) , ȸ�����(2)");
		
		try {
			int input = System.in.read();
			
			if(input == '1') {
				// login dialog show
				
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				System.out.println("���̵�(�й�)�� �Է��ϼ��� : ");
				int id = sc.nextInt();
				this.vHwewonDeungrok.login(id);
			} else if(input == '2') {
				this.vHwewonDeungrok.show();
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
