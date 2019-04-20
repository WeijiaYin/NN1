package nn.task1;

import java.util.ArrayList;
import java.util.List;

public class Matrix {
	private int matrix[][];
	private int size;
	
	public Matrix(Vector vector)
	{
		size = vector.getVector()[0].length;
	}
	
	private void calculateMatrix(Vector vector)
	{	
		for(int i = 0; i < size ;i++)
		{
			for(int j = 0; j <size; j++)
			{
				if(i == j)
					matrix[i][j] = 0;
				else {
					matrix[i][j] = 0;
					for(int k = 0; k < vector.getCount(); k++)
					{
						matrix[i][j] += vector.getVector()[k][i]*vector.getVector()[k][j];
					}
				}
			}
		}
		
	}
	
	private boolean testStable(int test[])
	{
		List<int[]> results = new ArrayList<int[]>();
		results.add(test);
		int result[] = {};
		while(!results.contains(result)) 
		{
			for(int i = 0; i < size; i++)
			{
				test[i] = 0;
				for (int j = 0; j < size; j++)
				{
					test[i] += matrix[i][j] * test[j];
				}
				for (int k = 0; k < test.length; k++)
				{
					if(test[k] >= 0)
						test[k] = 1;
					else
						test[k] = -1;
				}
			}
		}
		if(result.equals(test))
		{
			System.out.println("Stable");
			for(int i = 0; i < result.length; i++)
			{
				System.out.println(result[i]);
			}
			return true;
		}
		else {
			System.out.println("Not Stable");
			for(int i = 0; i < result.length; i++)
			{
				System.out.println(result[i]);
			}
			return false;
		}
		
	}
}
