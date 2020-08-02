package Admin;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import HomePage.AdminHomePage;
import People.Admin;

public class changePassword extends JFrame implements ActionListener
{
	private JTextField current, newP;
	private JLabel cPW, nPW;
	private JButton submit;
	Admin a;
	
	public changePassword(Admin admin)
	{
		super ("Enter Old and New Password");
		setSize (500, 100);
		Container container = getContentPane();
		container.setLayout (new FlowLayout());
		
		a = admin;
		cPW = new JLabel ("Current Password");
		nPW = new JLabel ("New Password");
		
		current = new JTextField (10);
		newP = new JTextField (10);
		
		submit = new JButton ("Submit");
		submit.addActionListener(this);
		
		container.add(cPW);
		container.add(current);
		container.add(nPW);
		container.add(newP);
		container.add(submit);
		
		setLocationRelativeTo(null);
		setVisible (true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == submit) {
		if (a.getPswd().equals(current.getText()))
		{
			a.setPswd(newP.getText());
			System.out.println (a.getPswd());
			new AdminHomePage (a);
			this.dispose();
		}
		else {
			JOptionPane.showMessageDialog(null,"Current Password Incorrect..."); 
		}
		}
	}
	
}


