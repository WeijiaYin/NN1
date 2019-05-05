package nn.task1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;

public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private String filePath = null;
	private Vector vector;
	private Matrix matrix;
	private JTextField textField_1;
	private JTextField textField_2;
	private int num = 0;
	private JTextField[] jtf;


	/**
	 * Create the frame.
	 */
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 685);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout());
		
		JPanel panel_2 = new JPanel();
		JPanel panel_1 = new JPanel();
		JButton btnInput_1 = new JButton("input");
		panel_1.setLayout(null);
		panel_2.setLayout(null);
		contentPane.add(panel_1, "hopfield");
		contentPane.add(panel_2, "input vector");
		
		JLabel lblSize = new JLabel("size:");
		lblSize.setBounds(23, 27, 41, 15);
		panel_2.add(lblSize);
		
		textField_1 = new JTextField();
		textField_1.setBounds(63, 24, 66, 21);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblX = new JLabel("\u00D7");
		lblX.setBounds(140, 27, 15, 15);
		panel_2.add(lblX);
		
		textField_2 = new JTextField();
		textField_2.setBounds(165, 24, 66, 21);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnOk_1 = new JButton("ok");
		btnOk_1.setBounds(255, 23, 57, 23);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 71, 404, 323);
		panel_2.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		CardLayout cl = (CardLayout)(contentPane.getLayout());
		cl.show(this.getContentPane(), "hopfield");
		
		JLabel lblHowWillYou = new JLabel("How will you input vectors?");
		lblHowWillYou.setBounds(10, 10, 178, 15);
		panel_1.add(lblHowWillYou);
		JTextArea textArea = new JTextArea();
		JButton btnFile = new JButton("file");
		btnFile.setBounds(183, 6, 64, 23);
		JButton btnInput = new JButton("input");
		JLabel lblT = new JLabel("T:");
		JLabel lblNewLabel_1 = new JLabel("Test Vector:");
		JButton btnOk = new JButton("ok");
		JLabel lblResult = new JLabel("Result:");
		JLabel label_1 = new JLabel("");
		JTextArea textArea_1 = new JTextArea();
		
		
		
		JLabel lblVectorsThatYou = new JLabel("Vectors that you input:");
		btnFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int returnVal = fileChooser.showOpenDialog(fileChooser);
				if(returnVal == JFileChooser.APPROVE_OPTION){
					filePath= fileChooser.getSelectedFile().getAbsolutePath();
				}
				if(filePath != null)
				{
					vector = new Vector();
					int[][] vec = vector.readVectorFromFile(filePath);
					textArea_1.setLineWrap(true);
					textArea_1.setEditable(false);
					for(int i = 0; i < vec.length; i++)
					{
						for(int j = 0; j < vec[0].length; j++)
						{
							textArea_1.append(String.valueOf(vec[i][j])+" ");
						}
						textArea_1.append("\r\n");
					}
					matrix = new Matrix(vector);
					int[][] mat = matrix.calculateMatrix(vector);
					textArea.setLineWrap(true);
					textArea.setEditable(false);
					for(int i = 0; i < mat.length; i++)
					{
						for(int j = 0; j < mat.length; j++)
						{
							textArea.append(String.valueOf(mat[i][j])+" ");
						}
						textArea.append("\r\n");
					}
				}
			}
			
		});
		panel_1.add(btnFile);
		
		btnInput.setBounds(255, 6, 64, 23);
		panel_1.add(btnInput);
		btnInput.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				cl.show(getContentPane(), "input vector");
			}
			
		});
		
		lblVectorsThatYou.setBounds(10, 41, 144, 15);
		panel_1.add(lblVectorsThatYou);
		
		lblT.setBounds(10, 225, 54, 15);
		panel_1.add(lblT);
		
		lblNewLabel_1.setBounds(10, 549, 79, 15);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(111, 546, 226, 21);
		panel_1.add(textField);
		textField.setColumns(10);
		
		btnOk.setBounds(344, 545, 64, 23);
		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String test = textField.getText();
				if(test != null)
				{
					String t[] = test.split(",");
					int t1[] = new int[t.length];
					for(int i = 0; i < t.length; i++)
					{
						t1[i] = Integer.parseInt(t[i]);
					}
					boolean result = matrix.testStable(t1);
					if(result)
						label_1.setText("stable");
					else
						label_1.setText("not stable");
				}
				
			}
			
		});
		panel_1.add(btnOk);
		
		lblResult.setBounds(10, 582, 54, 15);
		panel_1.add(lblResult);
		
		label_1.setBounds(89, 582, 117, 15);
		panel_1.add(label_1);
		
		textArea.setBounds(10, 250, 404, 245);
		panel_1.add(textArea);
		
		textArea_1.setBounds(10, 66, 381, 139);
		panel_1.add(textArea_1);
		
		btnOk_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				num = Integer.parseInt(textField_1.getText());
				jtf = new JTextField[num];
				for(int i = 0; i < num; i++)
				{
					jtf[i] = new JTextField();
					panel.add(jtf[i]);
					panel.revalidate();
				}
				
			}
			
		});
		panel_2.add(btnOk_1);
		
		btnInput_1.setBounds(298, 441, 93, 23);
		btnInput_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				cl.show(getContentPane(), "hopfield");
				String[] val = new String[num];
				for(int i = 0; i < num; i++)
				{
					val[i] = jtf[i].getText();
				}
				vector = new Vector();
				int[][] vec = vector.readVectorFromInput(val, num, Integer.parseInt(textField_2.getText()));
				textArea_1.setLineWrap(true);
				textArea_1.setEditable(false);
				for(int i = 0; i < vec.length; i++)
				{
					for(int j = 0; j < vec[0].length; j++)
					{
						textArea_1.append(String.valueOf(vec[i][j])+" ");
					}
					textArea_1.append("\r\n");
				}
				matrix = new Matrix(vector);
				int[][] mat = matrix.calculateMatrix(vector);
				textArea.setLineWrap(true);
				textArea.setEditable(false);
				for(int i = 0; i < mat.length; i++)
				{
					for(int j = 0; j < mat.length; j++)
					{
						textArea.append(String.valueOf(mat[i][j])+" ");
					}
					textArea.append("\r\n");
				}
				
			}
			
		});
		panel_2.add(btnInput_1);
		
	}
}
