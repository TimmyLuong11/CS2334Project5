import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
	//private JPanel panel1;
	//private JPanel panel2;
	//private JPanel panel3;
	private JComboBox<String> list;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel valueTextField;
	private JLabel dist0;
	private JLabel dist1;	
	private JLabel dist2;
	private JLabel dist3;
	private JLabel dist4;
	private JLabel showStationBox;
	private JLabel yes;
	private Color lb = new Color(51,153,225);
	private BufferedImage img;
	private JLabel pic;
	private JLabel pic1;
	
	public HummingDist() throws IOException
	{
		initFrame();
		setButton();
		setSlider();
		setComboBox();
		setText();
		setImage();
		panel0.add(b1);
		panel0.add(b2);
		panel0.add(b3);
		panel0.add(inputTextField);
		panel0.add(slider);
		panel0.add(list);
		panel0.add(label1);
		panel0.add(label2);
		panel0.add(label3);
		panel0.add(label4);
		panel0.add(label5);
		panel0.add(label6);
		panel0.add(label7);
		panel0.add(dist0);
		panel0.add(dist1);
		panel0.add(dist2);
		panel0.add(dist3);
		panel0.add(dist4);
		panel0.add(valueTextField);
		panel0.add(showStationBox);
		panel0.add(pic);
		panel0.add(pic1);
		panel0.add(yes);
		this.add(panel0);
	}

	private void setImage() throws IOException 
	{
		img = ImageIO.read(new File("pro.jpg"));
		pic = new JLabel(new ImageIcon(img));
		pic.setBounds(225, 15, 200, 200);
		img = ImageIO.read(new File("pic1.jpg"));
		pic1 = new JLabel(new ImageIcon(img));
		pic1.setBounds(300, 250, 200, 200);
	}

	private void setText() 
	{
		yes = new JLabel();
		yes.setText("Prof: Say Yes  Me: Yes");
		yes.setBounds(400, 600, 130, 100);
		
		inputTextField = new JTextField(10);
		inputTextField.setText("ZERO");
		inputTextField.setBounds(150, 700, 100, 25);

		label1 = new JLabel();
		label1.setText("Enter Hamming Dist:");
		label1.setBounds(10, 8, 120, 10);
		
		label2 = new JLabel();
		label2.setText("Compare with:");
		label2.setBounds(10, 415, 120, 10);

		label3 = new JLabel();
		label3.setText("Distance 0");
		label3.setBounds(15, 500, 120, 10);
		dist0 = new JLabel();
		dist0.setBorder(BorderFactory.createLineBorder(lb, 1));
		dist0.setBounds(150, 495, 100, 20);
		
		label4 = new JLabel();
		label4.setText("Distance 1");
		label4.setBounds(15, 545, 120, 10);
		dist1 = new JLabel();
		dist1.setBorder(BorderFactory.createLineBorder(lb, 1));
		dist1.setBounds(150, 535, 100, 20);
		
		label5 = new JLabel();
		label5.setText("Distance 2");
		label5.setBounds(15, 585, 120, 10);
		dist2 = new JLabel();
		dist2.setBorder(BorderFactory.createLineBorder(lb, 1));
		dist2.setBounds(150, 575, 100, 20);
		
		label6 = new JLabel();
		label6.setText("Distance 3");
		label6.setBounds(15, 625, 120, 10);
		dist3 = new JLabel();
		dist3.setBorder(BorderFactory.createLineBorder(lb, 1));
		dist3.setBounds(150, 615, 100, 20);
		
		label7 = new JLabel();
		label7.setText("Distance 4");
		label7.setBounds(15, 665, 120, 10);
		dist4 = new JLabel();
		dist4.setBorder(BorderFactory.createLineBorder(lb, 1));
		dist4.setBounds(150, 660, 100, 20);
		
		showStationBox = new JLabel();
		showStationBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		showStationBox.setBackground(Color.WHITE);
		showStationBox.setOpaque(true);
		showStationBox.setBounds(25, 150, 200, 250);
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
		list.setBounds(145, 410, 70, 20);
		
	}

	private void setButton() 
	{
		b1 = new JButton("b1");
		b1.setText("Show Station");
		b1.setBounds(17, 100, 115, 25);
		b2 = new JButton("b2");
		b2.setBounds(17, 450, 115, 25);
		b2.setText("Calculate HD");
		b3 = new JButton("b3");
		b3.setBounds(17, 700, 115, 25);
		b3.setText("Add Station");
		setVisible(true);
		
		b1.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				
			}
		});
		
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
		slider.setBounds(10, 25, 200, 50);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(1);
		slider.setPaintLabels(true);
		valueTextField = new JLabel();
		valueTextField.setBorder(BorderFactory.createLineBorder(lb, 1));
		valueTextField.setBounds(130, 5, 100, 20);
		valueTextField.setText(" " + slider.getValue());
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
		panel0 = new JPanel(null);
		//panel0 = new JPanel(new GridLayout(3,1));
		//panel1 = new JPanel();
		//panel2 = new JPanel(new GridLayout(3,1));
		//panel3 = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) throws IOException
	{
		HummingDist hd = new HummingDist();
		hd.revalidate();
	}
}
