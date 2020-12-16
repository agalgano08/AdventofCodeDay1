import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		Scanner s;
		try {
			s = new Scanner(new File("C:\\Users\\Anthony\\Personal\\AdventofCode2020Day3\\src\\input.txt"));

			while (s.hasNext()) {
				list.add(s.next());
			}
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long count[] = { 0, 0, 0, 0, 0 };
		int index = 0;
		for (int k = 0; k < 4; k++) {
			index = 0;
			for (int i = 0; i < list.size(); i++) {

				String line = list.get(i);
				for (int j = 0; j < 15; j++) {
					line = line + line;
				}
				if (line.charAt(index) == '#') {
					count[k]++;
				}
				switch (k) {
				case 0:
					index = index + 1;
					break;
				case 1:
					index = index + 3;
					break;
				case 2:
					index = index + 5;
					break;
				case 3:
					index = index + 7;
					break;

				}

			}
		}

		index = 0;
		for (int i = 0; i < list.size(); i = i + 2) {

			String line = list.get(i);
			for (int j = 0; j < 7; j++) {
				line = line + line;
			}
			if (line.charAt(index) == '#') {
				count[4]++;
			}
			index++;

		}
		System.out.println(count[0]);
		System.out.println(count[1]);
		System.out.println(count[2]);
		System.out.println(count[3]);
		System.out.println(count[4]);

		System.out.println((long) (count[0] * count[1] * count[2] * count[3] * count[4]));

	}
}
