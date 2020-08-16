package Admin;
import Quiz.mathGameDatabase;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class addQuestion extends JFrame implements ActionListener
{
	private JTextField num1, num2, op;
	private JLabel num1L, num2L, opL;
	private JButton submit;
	public addQuestion ()
	{
		super ("Enter Student Name");
		setSize (600, 100);
		Container container = getContentPane();
		container.setLayout (new FlowLayout());
		
		num1L = new JLabel ("Value 1: ");
		num2L = new JLabel ("Value 2: ");
		opL  = new JLabel ("Operation: ");
		
		num1 = new JTextField(10);
		num2 = new JTextField(10);
		op = new JTextField(10);
		
		submit = new JButton ("Submit");
		submit.addActionListener(this);
		
		container.add(num1L);
		container.add(num1);
		container.add(num2L);
		container.add(num2);
		container.add(opL);
		container.add(op);
		container.add(submit);
		
		setLocationRelativeTo(null);
		setVisible (true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		mathGameDatabase questions = new mathGameDatabase();
		questions.readQuestions();
		String val1 = num1.getText();
		String val2 = num2.getText();
		String oper = op.getText();
		try {
			int inNum1 = Integer.parseInt(val1);
			int inNum2 = Integer.parseInt(val2);
			char operation = oper.charAt(0);
			if (!(operation=='+' || operation == '-' || operation == '*'))
			{
				JOptionPane.showMessageDialog(null,"Invalid Operation... only:  +  -  *");
				return;
			}
			questions.addQuestion(inNum1, inNum2, operation);
			questions.writeQuestions();
			this.dispose();
		}
		catch (NumberFormatException ex)
		{
			JOptionPane.showMessageDialog(null,"Please input a number");
		}
	}
}