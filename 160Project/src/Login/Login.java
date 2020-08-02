package Login;

import People.*;
import javax.swing.*;

import HomePage.AdminHomePage;
import HomePage.HomePage;

import java.awt.*;
import java.awt.event.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.util.ArrayList;

public class Login extends JFrame implements ActionListener
{
	private JButton admin, student;
	
	public Login ()
	{
		super ("Login");
		setSize (500, 100);
		Container container = getContentPane();
		container.setLayout (new FlowLayout());
		
		student = new JButton ("Student");
		admin = new JButton ("Administrator");
		
		student.addActionListener(new launchStudent());
		student.addActionListener(this);
		admin.addActionListener(new launchAdmin());
		admin.addActionListener(this);
		
		container.add(student);
		container.add(admin);
		
		setLocationRelativeTo(null);
		setVisible (true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		this.dispose();
		/*
		if (e.getSource() == admin)
		{
			new AdminLogin();
			this.dispose();
		}
		else if (e.getSource() == student)
		{
			new StudentLogin();
			this.dispose();
		}
		*/
	}
	
	class launchStudent extends JFrame implements ActionListener
	{
		public void actionPerformed(ActionEvent arg)
		{
			new StudentLogin();
		}
	}
	class launchAdmin extends JFrame implements ActionListener
	{
		public void actionPerformed(ActionEvent arg)
		{
			new AdminLogin();
		}
	}
	public static void main (String args[])
	{
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run()
			{
				new Login();
			}
		});
	}
}

class AdminLogin extends JFrame implements ActionListener
{
	private JTextField adminName;
	private JPasswordField pswd;
	private JLabel nameLabel, pswdLabel;
	private JButton submit;
	private String password;
	Admin admin;
	
	boolean findAdmin (String name, String pswd)
	{
		ArrayList<Admin> admins = new ArrayList<Admin>();
		//Student student;
		try {
			FileInputStream inFile = new FileInputStream ("files/admins.ser");
			ObjectInputStream obIn = new ObjectInputStream (inFile);
			int i = 0;
			try {
				while (true)
				{
					try {
						admins.add((Admin)obIn.readObject()); 
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			catch (EOFException e) {
				//end of file
			}
			obIn.close();
			inFile.close();
		}
		catch (OptionalDataException e)
		{
			System.out.println("Data Exceeded");
		}
		catch(IOException e)
		{
			System.out.println ("Error opening file");
		}
		for (int i = 0; i < admins.size(); i++)
		{
			if (name.equals(admins.get(i).getName()) && (pswd.equals(admins.get(i).getPswd()))) //find student, copy to stdnt variable
			{
				System.out.println(pswd + "\t" + admins.get(i).getPswd());
				admin = admins.get(i);
				System.out.println ("Admin Found");
				admin.populateStudents();
				return true;
			}
		}
		System.out.println("Admin not found, try again");
		//create new student if one is not found
		//admin = new Admin (name, pswd);
		return false;
	}
	
	public AdminLogin()
	{
		super ("Administrator Login");
		setSize (500, 100);
		Container container = getContentPane();
		container.setLayout (new FlowLayout());
		
		nameLabel = new JLabel ("Admin Name: ", JLabel.CENTER);
		container.add(nameLabel);

		
		adminName = new JTextField(10);
		pswd = new JPasswordField (10);
		pswd.addActionListener(this);
		
		container.add(adminName);
		
		pswdLabel = new JLabel ("Password: ", JLabel.CENTER);
		container.add(pswdLabel);
		
		container.add(pswd);
		
		submit = new JButton ("Enter");
		adminName.addActionListener(this);//may change
		submit.addActionListener(this);
		container.add(submit);
		
		setLocationRelativeTo(null);
		setVisible (true);
	}
	
	private boolean checkPswd ()
	{
		char[] pswdTxt = pswd.getPassword();
		System.out.println(pswd + "\t" + new String(pswdTxt));
		return pswd.equals(new String (pswdTxt));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//launch admin page using admin object created/imported
		
		if (findAdmin(adminName.getText(), new String(pswd.getPassword())))
		{
			new AdminHomePage(admin);
			this.dispose();
		}
		else if ("newadmin".equals(new String(pswd.getPassword())))
		{
			admin = new Admin (adminName.getText(), "admin");
			System.out.println ("Creating New Admin User... Default Password: admin");
			new AdminHomePage (admin);
			this.dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Invalid Name/Password Entry"); 
		}
	}
	public static void main (String args[])
	{
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run()
			{
				new StudentLogin();
			}
		});
	}
}

class StudentLogin extends JFrame implements ActionListener {
	private JTextField stdntName;
	private JLabel nameLabel;
	private JButton submit;
	private Student stdnt;
	public StudentLogin()
	{
		super ("Student Login");
		setSize (500, 100);
		Container container = getContentPane();
		container.setLayout (new FlowLayout());
		
		nameLabel = new JLabel ("Student Name: ", JLabel.CENTER);
		container.add(nameLabel);
		
		stdntName = new JTextField(10);
		stdntName.addActionListener(this);
		container.add(stdntName);
		
		submit = new JButton ("Enter");
		//stdntName.addActionListener(this);//may change
		submit.addActionListener(this);
		container.add(submit);
		
		setLocationRelativeTo(null);
		setVisible (true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//lauch student home page
		importStudent (stdntName.getText());
		//launch stdnt home with stdnt obj
		
		new HomePage (stdnt);
		
		
		this.dispose(); //delete login window
	}
	private void importStudent (String name)
	{
		ArrayList<Student> stdnts = new ArrayList<Student>();
		//Student student;
		try {
			FileInputStream inFile = new FileInputStream ("files/students.ser");
			ObjectInputStream obIn = new ObjectInputStream (inFile);
			int i = 0;
			try {
				while (true)
				{
					try {
						stdnts.add((Student)obIn.readObject()); 
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			catch (EOFException e) {
				//end of file
			}
			obIn.close();
			inFile.close();
		}
		catch (OptionalDataException e)
		{
			System.out.println("Data Exceeded");
		}
		catch(IOException e)
		{
			System.out.println ("Error opening file");
		}
		for (int i = 0; i < stdnts.size(); i++)
		{
			if (name.equals(stdnts.get(i).getStudentName())) //find student, copy to stdnt variable
			{
				stdnt = stdnts.get(i).copyStudent();
				System.out.println ("Student Found");
				return;
			}
		}
		System.out.println("Student not found, creating new Student");
		//create new student if one is not found
		stdnt = new Student (name);
		return;
	}
	public static void main (String args[])
	{
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run()
			{
				new StudentLogin();
			}
		});
	}
}



