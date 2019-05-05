package nn.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matrix {
	private int matrix[][];
	private int size;
	
	public Matrix(Vector vector)
	{
		size = vector.getVector()[0].length;
	}
	
	public int[][] calculateMatrix(Vector vector)
	{	
		matrix = new int[size][size];
		for(int i = 0; i < size ;i++)
		{
			for(int j = 0; j <size; j++)
			{
				if(i == j)
					matrix[i][j] = 0;
				else {
					matrix[i][j] = 0;
					for(int k = 0; k < vector.getVector().length; k++)
					{
						matrix[i][j] += vector.getVector()[k][i]*vector.getVector()[k][j];
					}
				}
			}
		}
		
		return matrix;
		
	}
	
	public boolean testStable(int test[])
	{
		int flag = 0;
		int count = 0;
		int temp1[]= new int[test.length];
		int temp2[] = test;
		List<int[]> results = new ArrayList<int[]>();
		int temp[] = new int[test.length];
		results.add(test);
		while(true) 
		{
			for(int i = 0; i < size; i++)
			{
				temp[i] = 0;
				for (int j = 0; j < size; j++)
				{
					temp[i] += matrix[j][i] * temp2[j];
				}
			}
			for (int k = 0; k < test.length; k++)
			{
				if(temp[k] >= 0)
					temp[k] = 1;
				else
					temp[k] = -1;
			}
			count++;
			if(flag == 1)
			{
				count--;
				break;
			}
			if(results.contains(temp))
			{
				flag = 1;
				for(int i = 0; i < temp.length; i++)
					temp1[i] = temp[i];
			}
			else
				results.add(temp);
			for(int i = 0; i < temp.length; i++) {
				temp2[i] = temp[i];
			}
		}
		if(Arrays.equals(temp1, test) || Arrays.equals(temp, test))
		{
			System.out.println("Stable");
			if(Arrays.equals(temp, test))
				System.out.println("Resulted in "+ String.valueOf(count)+" iteration(s)");
			else {
				System.out.println("Resulted in two vector loops");
				for(int i = 0; i < temp.length; i++)
				{
					System.out.print(temp[i] + " ");
				}
				System.out.println();
			}
			for(int i = 0; i < temp1.length; i++)
			{
				System.out.print(temp1[i] + " ");
			}
			return true;
		}
		else {
			System.out.println("Not Stable");
			if(Arrays.equals(temp, temp1)) 
				System.out.println("Resulted in "+ String.valueOf(count)+" iteration(s)");
			else {
				System.out.println("Resulted in two vector loops");
				for(int i = 0; i < temp1.length; i++)
				{
					System.out.print(temp1[i] + " ");
				}
				System.out.println();
			}
			for(int i = 0; i < temp.length; i++)
			{
				System.out.print(temp[i] + " ");
			}
			
			return false;
		}
		
	}
	
}
