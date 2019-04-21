package nn.task1;

import java.util.Scanner;

public class ShowInConsole {
	
	public static void main(String args[])
	{
		Vector vector = new Vector();
		vector.readVectorFromFile("test.txt");
		Matrix matrix = new Matrix(vector);
		matrix.calculateMatrix(vector);
		
		int length = vector.getVector()[0].length;
		
        int test[] = new int[length];
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input test vector");
        for(int i = 0; i < test.length; i++){
            test[i] = sc.nextInt();
        }

		matrix.testStable(test);
	}
	

}
