package nn.task1;

import static org.junit.Assert.*;

import org.junit.Before;


public class Test {

	@Before
	public void setUp() throws Exception {
	}

	@org.junit.Test
	public void testReadVectorFromInput() throws WrongInputException {
		String[] inputss = {"1,0,1,0,1","1,1,1,0,0","1,0,0,1,0"};
		Vector vector = new Vector();
		int[][] vec = vector.readVectorFromInput(inputss, 3, 5);
		int[][] vec1 = {{1,-1,1,-1,1},{1,1,1,-1,-1},{1,-1,-1,1,-1}};
		assertArrayEquals(vec, vec1);
	}
	
	@org.junit.Test
	public void testReadVectorFromFile() throws WrongInputException
	{
		String path = "test.txt";
		Vector vector = new Vector();
		int[][] vec = vector.readVectorFromFile(path);
		int[][] vec1 = {{1,-1,1,-1,1},{1,1,1,-1,-1},{1,-1,-1,1,-1}};
		assertArrayEquals(vec, vec1);
	}
	
	@org.junit.Test
	public void testCalculateMatrix() throws WrongInputException
	{
		String[] inputss = {"1,0,1,0,1","1,1,1,0,0","1,0,0,1,0"};
		Vector vector = new Vector();
		vector.readVectorFromInput(inputss, 3, 5);
		Matrix matrix = new Matrix(vector);
		matrix.calculateMatrix(vector);
		int[][] mat = matrix.calculateMatrix(vector);
		int[][] mat1 = {{0,-1,1,-1,-1},{-1,0,1,-1,-1},{1,1,0,-3,1},{-1,-1,-3,0,-1},{-1,-1,1,-1,0}};
		assertArrayEquals(mat,mat1);
	}
	
	@org.junit.Test
	public void testCalculateMatrix1() throws WrongInputException
	{
		String[] inputss = {"1,1","1,1"};
		Vector vector = new Vector();
		vector.readVectorFromInput(inputss, 2, 2);
		Matrix matrix = new Matrix(vector);
		matrix.calculateMatrix(vector);
		int[][] mat = matrix.calculateMatrix(vector);
		int[][] mat1 = {{0,1},{1,0}};
		assertArrayEquals(mat,mat1);
	}
	
	@org.junit.Test
	public void testStable() throws WrongInputException
	{
		String[] inputss = {"1,0,1,0,1","1,1,1,0,0","1,0,0,1,0"};
		Vector vector = new Vector();
		vector.readVectorFromInput(inputss, 3, 5);
		Matrix matrix = new Matrix(vector);
		matrix.calculateMatrix(vector);
		int[] test = {1,1,1,-1,1};
		boolean stable = matrix.testStable(test);
		assertTrue(stable);
	}
	
	@org.junit.Test
	public void testStable1() throws WrongInputException
	{
		String[] inputss = {"1,0,1,0,1","1,1,1,0,0","1,0,0,1,0"};
		Vector vector = new Vector();
		vector.readVectorFromInput(inputss, 3, 5);
		Matrix matrix = new Matrix(vector);
		matrix.calculateMatrix(vector);
		int[] test = {1,-1,1,-1,1};
		boolean stable = matrix.testStable(test);
		assertFalse(stable);
	}
}
