package Admin;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class addQuestion extends JFrame implements ActionListener
{
	private JTextField num1, num2, op;
	private JLabel num1L, num2L, opL;
	private JButton submit;
	public addQuestion ()
	{
		super ("Enter Student Name");
		setSize (500, 100);
		Container container = getContentPane();
		container.setLayout (new FlowLayout());
		
		num1L = new JLabel ("Value 1: ");
		num2L = new JLabel ("Value 2: ");
		opL  = new JLabel ("Operation: ");
		
		num1 = new JTextField(10);
		num2 = new JTextField(10);
		op = new JTextField(10);
		
		submit = new JButton ("Submit");
		
		container.add(num1L);
		container.add(num1);
		container.add(num2L);
		container.add(num2);
		container.add(opL);
		container.add(opL);
		container.add(submit);
		
		setLocationRelativeTo(null);
		setVisible (true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}