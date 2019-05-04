package nn.task1;

import java.io.IOException;
import java.util.Scanner;

public class ShowInConsole {
	
	public ShowInConsole() throws IOException
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
			vector.readVectorFromFile(filePath);
			matrix = new Matrix(vector);
			matrix.calculateMatrix(vector);
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
			matrix = new Matrix(vector);
			int[][] mat = matrix.calculateMatrix(vector);
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
	

}
