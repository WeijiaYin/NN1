package nn.task1;

import java.io.IOException;
import java.util.Scanner;

public class MainClass {

	public static void main(String args[]) throws IOException
	{
		System.out.println("Do you want to do it in console? input Y if yes, input N if no");
		char y = (char) System.in.read();
		switch(y)
		{
		case 'Y': Frame frame = new Frame();
		frame.setVisible(true);
		break;
		case 'N':ShowInConsole showInConsole = new ShowInConsole();
			break;
		default:
			System.out.println("Wrong input");
		}
	}
	
}
