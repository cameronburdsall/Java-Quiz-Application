package HomePage;

import Admin.*;
import java.io.*;

import javax.swing.*;

import People.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AdminHomePage extends JFrame {
	//declarations
		JFrame f;
		JLabel prompt;
		JButton sShow, sdShow, change, exit, add, changePswd;
		Admin admin;
		//constructor
		public static void main (String args[])
		{
			SwingUtilities.invokeLater(new Runnable() {
				Admin a = new Admin ("Bill", "pswd");
				@Override
				public void run()
				{
					new AdminHomePage(a);
				}
			});
		}
		public AdminHomePage(Admin admin) {
			super("Welcome Administrator " + admin.getName() +"!");
			this.admin = admin.copyAdmin();
			
			setSize(500,500);
			
			
			//f = new JFrame()
			Container container = getContentPane();
			prompt = new JLabel(admin.getName() + ", select one of the operations", JLabel.CENTER);
			sShow = new JButton("Show All Students");
			sShow.setBounds(10, 10, 50, 50);
			sdShow = new JButton("Individual Student Grades");
			change = new JButton("Change Score");
			changePswd = new JButton ("Change " + admin.getName() + "'s Password");
			add = new JButton ("Add Question");
			exit = new JButton("Save and Exit");
			
			
			
			
			sShow.addActionListener(new studentShower());
			sdShow.addActionListener(new studentDetailShower());
			change.addActionListener(new changeScore());
			exit.addActionListener(new quitApp());
			add.addActionListener(new addQ()); 
			changePswd.addActionListener(new changePswd());
			
			container.add(prompt);
			container.add(sShow);
			container.add(sdShow);
			container.add(change);
			container.add(changePswd);
			container.add(add);
			container.add(exit);

			
			container.setLayout(new GridLayout(7,1));
			
			// showing the frame in the center of the screen


			setLocationRelativeTo(null);
			setVisible(true);
		}
		
		/////////////   Driver Classes    ////////////////
		
		public void saveAndQuit ()
		{
			admin.serializeStudents();
			admin.setStdnts(new ArrayList<Student> ());
			admin.serializeAdmin();
			this.dispose();
		}
		private class addQ implements ActionListener
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new addQuestion();
			}
			
		}
		private class changePswd implements ActionListener
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				new changePassword(admin);
				dispose();
			}
			
		}
		private class studentShower implements ActionListener
		{
			public void actionPerformed (ActionEvent e)
			{
				new studentNames(admin);
			}
		}
		private class studentDetailShower implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {

				new namePrompt(admin, 0);
			}
		}
		private class changeScore implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new namePrompt(admin, 1);
			}
		}
		private class quitApp implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				saveAndQuit();
			}
		}
}