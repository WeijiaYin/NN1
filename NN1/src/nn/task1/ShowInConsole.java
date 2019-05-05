package nn.task1;

import java.io.IOException;
import java.util.Scanner;

public class ShowInConsole {
	
	public ShowInConsole() throws IOException, WrongInputException
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Vector vector = new Vector();
		Matrix matrix = null;
		System.out.println("How will you input vectors? F for read from file, T for input");
		char y = sc.nextLine().charAt(0);
		switch(y)
		{
		case 'F':
			System.out.println("Please input file path");
			String filePath = sc.nextLine();
			int vect[][] = vector.readVectorFromFile(filePath);
			System.out.println("The vectors you input(after change 0 to -1):");
			show(vect);
			matrix = new Matrix(vector);
			System.out.println("T:");
			int matr[][] = matrix.calculateMatrix(vector);
			show(matr);
			break;
		case 'T':
			System.out.println("How many vectors do you want to input?");
			int num = Integer.parseInt(sc.nextLine());
			System.out.println("How many elements are there in one vector?");
			int length1 = Integer.parseInt(sc.nextLine());
			System.out.println("Please input vectors:");
			String inputss[] = new String[num];
			for(int i = 0; i < num; i++)
			{
				inputss[i] = sc.nextLine();
			}
			vector = new Vector();
			int[][] vec = vector.readVectorFromInput(inputss, num, length1);
			System.out.println("The vectors you input(after change 0 to -1):");
			show(vec);
			matrix = new Matrix(vector);
			System.out.println("T:");
			int[][] mat = matrix.calculateMatrix(vector);
			show(mat);
			break;
			
		}
		int test[] = new int[vector.getVector()[0].length];
        System.out.println("Please input test vector");
        String inputs = sc.nextLine();
        String[] inputSplit = inputs.split(",");
        for(int i = 0; i < test.length; i++){
            test[i] = Integer.parseInt(inputSplit[i]);
        }

		matrix.testStable(test);
		
	}
	
	private void show(int[][] matrix)
	{
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[0].length; j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	

}
