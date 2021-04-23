package dataAccessObject;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.MHwewon;
import valueObject.OHwewon;

public class DHwewonDeungrok {

	private File file;
	private FileWriter fileWriter;

	public DHwewonDeungrok() {
	}

	public void save(OHwewon oHwewon) {
		MHwewon mHwewon = new MHwewon();

		// oHwewon에서 mHwewon으로 데이터를 이동
		mHwewon.setHwewon(oHwewon.getId(), oHwewon.getName(), oHwewon.getAddress(), oHwewon.getHwakgwa());

		// mHwewon을 통해서 파일에 저장
		try {
			file = new File("test.txt");

			if (!file.exists()) {
				file.createNewFile();
				System.out.println("test 파일 생성!");
				fileWriter = new FileWriter(file);
			} else {
				fileWriter = new FileWriter(file, true);
				System.out.println("기존 파일에 덧붙임!");
			}

			fileWriter.write(mHwewon.getId() + " ");
			fileWriter.write(mHwewon.getName() + " ");
			fileWriter.write(mHwewon.getAddress() + " ");
			fileWriter.write(mHwewon.getHwakgwa() + " ");
			fileWriter.write("\n");

			fileWriter.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@SuppressWarnings("null")
	public OHwewon read(int inputID) {

		OHwewon oHwewon = null;

		// mHwewon을 통해 Data read (아이디 혹은 학번을 줌으로써 회원 정보 가져오기)
		FileReader fileReader;
		try {
			file = new File("test.txt");
			if (file.canRead()) {
				fileReader = new FileReader(this.file);
				ArrayList<String> allHwewonInfoArray = new ArrayList<String>();
				String buf = new String();
				int c = fileReader.read();

				while (c != -1) {
					if (c == ' ') {
						buf += ' ';
					} else if (c == '\n') {
						allHwewonInfoArray.add(buf);
						buf = new String();
					} else {
						buf += (char) c;
					}
					c = fileReader.read();
				}

				fileReader.close();

				// mHwewon에서 oHwewon으로 데이터 이동
				for (int p = 0; p < allHwewonInfoArray.size(); p++) {
					ArrayList<String> individualInfo = new ArrayList<String>();
					String bufForInfo[] = allHwewonInfoArray.get(p).split(" ");

					// 학생 개인정보를 개별적으로 저장 (individualInfo에)
					for (int q = 0; q < bufForInfo.length; q++) {
						individualInfo.add(bufForInfo[q]);
					}

					// oHwewon 생성
					int _id = Integer.parseInt(individualInfo.get(0));
					if (_id == inputID) {
						String _name = individualInfo.get(1);
						String _address = individualInfo.get(2);
						int _hwakgwa = Integer.parseInt(individualInfo.get(3));
						oHwewon = new OHwewon();
						oHwewon.setHwewon(_id, _name, _address, _hwakgwa);
						break;
					}
				}

				// oHwewon을 반환
				if (oHwewon == null) {
					System.out.println("[로그인 실패]로그인 한 회원정보를 찾을 수 없습니다.");
					return null;
				}
			} else {
				System.out.println("학생 정보가 담긴 파일을 찾을 수 없습니다.");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// oHwewon을 반환
		return oHwewon;
	}

}
