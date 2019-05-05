package nn.task1;

import java.io.IOException;

public class MainClass {

	public static void main(String args[]) throws IOException, WrongInputException
	{
		System.out.println("Do you want to do it in frame? input Y if yes, input N if no");
		char y = (char) System.in.read();
		System.in.skip(2);
		switch(y)
		{
		case 'Y': Frame frame = new Frame();
		frame.setVisible(true);
		break;
		case 'N':new ShowInConsole();
			break;
		default:
			System.out.println("Wrong input");
		}
	}
	
}
