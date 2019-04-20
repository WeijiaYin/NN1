package nn.task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Vector {
	private int vector[][];
	private int count = 0;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	

	public int[][] getVector() {
		return vector;
	}

	public void setVector(int[][] vector) {
		this.vector = vector;
	}

	private void readVectorFromFile(String fileName) {
		File file = new File(fileName);
		if (file.exists()) {
			try {
				FileReader fileReader = new FileReader(file);
				BufferedReader br = new BufferedReader(fileReader);
				String line = null;
				while ((line = br.readLine()) != null) {
					addVector(line, count);
					count++;
				}
				br.close();
				fileReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("File not found");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("io exception");
				e.printStackTrace();
			}
		}

	}

	private void changeElement(int vector[][]) {
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < vector[i].length; j++) {
				if (checkValid(vector[i][j])) {
					if (vector[i][j] == 0)
						vector[i][j] = -1;
				}
			}
		}
	}

	private boolean checkValid(Integer e) {
		if (e != 1 && e != -1 && e != 0) {
			System.out.println("The vector can only contains 0, -1, 1");
			return false;
		} else
			return true;
	}
	
	private void addVector(String line, int num)
	{
		String elements[] = line.split(",");
		for (int i = 0; i < elements.length; i++) {
			vector[num][i] = Integer.parseInt(elements[i]);
		}
	}
}
