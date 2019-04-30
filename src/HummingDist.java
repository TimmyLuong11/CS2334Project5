import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class HummingDist extends JFrame
{
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JSlider slider;	
	private JTextField inputTextField;
	private JPanel panel0;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JComboBox<String> list;
	private JLabel label1;
	private JLabel valueTextField;
	
	public HummingDist() throws IOException
	{
		initFrame();
		setButton();
		setSlider();
		setTextField();
		setComboBox();
		setText();
		panel1.add(b1);
		panel1.add(b2);
		panel1.add(b3);
		panel1.add(inputTextField);
		panel1.add(slider);
		panel1.add(list);
		panel1.add(label1);
		panel0.add(panel1);
		panel0.add(valueTextField);
		panel0.add(panel2);
		this.add(panel0);
	}

	 

	private void setText() 
	{
		label1 = new JLabel();
		label1.setText("Enter Hamming Dist:");
	}



	private void setComboBox() throws IOException
	{
		BufferedReader input = new BufferedReader(new FileReader("Mesonet.txt"));
		input.readLine();
		input.readLine();
		input.readLine();
		input.readLine();
		List<String> strings = new ArrayList<String>();
		try 
		{
			String line = null;
			while((line = input.readLine()) != null)
			{
				strings.add(line.split("\\s+")[1]);
			}
		}
		catch (FileNotFoundException e)
		{
		    System.err.println("Error, file " + "Mesonet.txt" + " didn't exist.");
		}
		finally 
		{
		    input.close();
		}

		String[] lineArray = strings.toArray(new String[]{});

		list = new JComboBox<>(lineArray);
		//list.setBounds(100, 400, 115, 30);
		
	}

	private void setTextField() 
	{
		inputTextField = new JTextField(10);
		inputTextField.setBounds(150, 700, 115, 25);
	}

	private void setButton() 
	{
		b1 = new JButton("b1");
		b1.setText("Show Station");
		b1.setBounds(15, 90, 115, 25);
		b2 = new JButton("b2");
		b2.setBounds(15, 450, 115, 25);
		b2.setText("Calculate HD");
		b3 = new JButton("b3");
		b3.setBounds(15, 700, 115, 25);
		b3.setText("Add Station");
		setVisible(true);
		
		b2.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//TODO
				
			}
		});
		
		b3.addActionListener(new ActionListener() 
		{ 
			@Override 
			public void actionPerformed(ActionEvent e)
			{ 
				list.addItem(inputTextField.getText());	
			} 
		 });
	}

	private void setSlider() 
	{
		slider = new JSlider(1, 4);	
		slider.setBounds(10, 10, 200, 30);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(1);
		slider.setPaintLabels(true);
		valueTextField = new JLabel();
		valueTextField.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
		valueTextField.setBounds(10, 10, 200, 30);
		slider.addChangeListener(new ChangeListener()
		{
			@Override
			public void stateChanged(ChangeEvent e)
			{
				valueTextField.setText(" " + slider.getValue());
			}
		});
		
	}

	private void initFrame()
	{
		setTitle("Hamming Distance");
		setSize(625, 775);
		panel0 = new JPanel(new GridLayout(3,1));
		panel1 = new JPanel();
		panel2 = new JPanel(new GridLayout(3,1));
		panel3 = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) throws IOException
	{
		HummingDist hd = new HummingDist();
		hd.revalidate();
	}
}
