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

		// oHwewon���� mHwewon���� �����͸� �̵�
		mHwewon.setHwewon(oHwewon.getId(), oHwewon.getName(), oHwewon.getAddress(), oHwewon.getHwakgwa());

		// mHwewon�� ���ؼ� ���Ͽ� ����
		try {
			file = new File("test.txt");

			if (!file.exists()) {
				file.createNewFile();
				System.out.println("test ���� ����!");
				fileWriter = new FileWriter(file);
			} else {
				fileWriter = new FileWriter(file, true);
				System.out.println("���� ���Ͽ� ������!");
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

		// mHwewon�� ���� Data read (���̵� Ȥ�� �й��� �����ν� ȸ�� ���� ��������)
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

				// mHwewon���� oHwewon���� ������ �̵�
				for (int p = 0; p < allHwewonInfoArray.size(); p++) {
					ArrayList<String> individualInfo = new ArrayList<String>();
					String bufForInfo[] = allHwewonInfoArray.get(p).split(" ");

					// �л� ���������� ���������� ���� (individualInfo��)
					for (int q = 0; q < bufForInfo.length; q++) {
						individualInfo.add(bufForInfo[q]);
					}

					// oHwewon ����
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

				// oHwewon�� ��ȯ
				if (oHwewon == null) {
					System.out.println("[�α��� ����]�α��� �� ȸ�������� ã�� �� �����ϴ�.");
					return null;
				}
			} else {
				System.out.println("�л� ������ ��� ������ ã�� �� �����ϴ�.");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// oHwewon�� ��ȯ
		return oHwewon;
	}

}
