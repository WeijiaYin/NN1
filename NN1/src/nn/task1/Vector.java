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

	public int[][] readVectorFromFile(String fileName) throws WrongInputException {
		File file = new File(fileName);
		int cols = 0;
		int rows = 0;
		try {
			FileReader fileReader = new FileReader(file);
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(fileReader);
			String arrayInfo = br.readLine();
			String line = null;
			if (arrayInfo != null) {
				String arraySize[] = arrayInfo.split(",");
				rows = Integer.parseInt(arraySize[0]);
				cols = Integer.parseInt(arraySize[1]);
				vector = new int[rows][cols];
			}
			while ((line = br.readLine()) != null) {
				String elements[] = line.split(",");
				if(elements.length != cols)
					throw new WrongInputException("WrongInputException", "vector size doesn't match");
				addVector(elements, count);
				count++;
			}

			changeElement(vector);

			br.close();
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("io exception");
			e.printStackTrace();
		}

		return vector;

	}

	public int[][] readVectorFromInput(String[] input, int num, int length) throws WrongInputException {
		vector = new int[num][length];
		for (int i = 0; i < num; i++) {
			String elements[] = input[i].split(",");
			if(elements.length != length)
				throw new WrongInputException("Wrong input Exception", "vector size doesn't match");
			addVector(elements, i);
		}

		changeElement(vector);

		return vector;

	}

	private void changeElement(int vector[][]) throws WrongInputException {
		for (int i = 0; i < vector.length; i++) {
			for (int j = 0; j < vector[i].length; j++) {
				if (checkValid(vector[i][j])) {
					if (vector[i][j] == 0)
						vector[i][j] = -1;
				}
			}
		}
	}

	private boolean checkValid(Integer e) throws WrongInputException {
		if (e != 1 && e != -1 && e != 0) 
			throw new WrongInputException("WrongInputException","The vector can only contains 0, -1, 1");
		else
			return true;
	}

	private void addVector(String[] elements, int num) {
		for (int i = 0; i < elements.length; i++) {
			vector[num][i] = Integer.parseInt(elements[i]);
		}
	}
}
