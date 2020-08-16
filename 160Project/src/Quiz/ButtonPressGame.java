package Quiz;
import javax.swing.*;

import HomePage.HomePage;
import People.Student;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class ButtonPressGame extends JFrame implements ActionListener {
	//declarations
	JLabel question, qNumber, blank1, blank2;
	JButton b1, b2, b3, b4;
	StatesDatabase states = new StatesDatabase();
	stateQuestion current;
	static int a, tot = 1;
	Student st;
	
	public ButtonPressGame(int j, Student student){	
		super("Geography Game");
		a = j;
		current = states.generateQuestion();
		setSize(800,500);
		st = student;
		Container container = getContentPane();
		qNumber = new JLabel("Question "+a+" of 5", JLabel.CENTER);
		question = new JLabel("Which state is "+ current.getC()+"?", JLabel.CENTER);
		blank1 = new JLabel("");
		blank2 = new JLabel("");
		
		Random rand = new Random();
		int i = rand.nextInt(4);
		Icon i1, i2, i3, i4;
		switch(i) {
			case 0:
				i1 = new ImageIcon("files/Images/states/"+current.getCI()+".jpg");
				i2 = new ImageIcon("files/Images/states/"+current.getW1()+".jpg");
				i3 = new ImageIcon("files/Images/states/"+current.getW2()+".jpg");
				i4 = new ImageIcon("files/Images/states/"+current.getW3()+".jpg");
				break;
			case 1:
				i1 = new ImageIcon("files/Images/states/"+current.getW1()+".jpg");
				i2 = new ImageIcon("files/Images/states/"+current.getCI()+".jpg");
				i3 = new ImageIcon("files/Images/states/"+current.getW2()+".jpg");
				i4 = new ImageIcon("files/Images/states/"+current.getW3()+".jpg");
				break;
			case 2:
				i1 = new ImageIcon("files/Images/states/"+current.getW2()+".jpg");
				i2 = new ImageIcon("files/Images/states/"+current.getW1()+".jpg");
				i3 = new ImageIcon("files/Images/states/"+current.getCI()+".jpg");
				i4 = new ImageIcon("files/Images/states/"+current.getW3()+".jpg");
				break;
			default:
				i1 = new ImageIcon("files/Images/states/"+current.getW3()+".jpg");
				i2 = new ImageIcon("files/Images/states/"+current.getW1()+".jpg");
				i3 = new ImageIcon("files/Images/states/"+current.getW2()+".jpg");
				i4 = new ImageIcon("files/Images/states/"+current.getCI()+".jpg");
				break;
		}
		//System.out.println(current.getCI());
		//System.out.println(current.getW1());
		//System.out.println(current.getW2());
		//System.out.println(current.getW3());
		b1 = new JButton(i1);
		b2 = new JButton(i2);
		b3 = new JButton(i3);
		b4 = new JButton(i4);
		b1.addActionListener(new B1(i,a));
		b2.addActionListener(new B2(i,a));
		b3.addActionListener(new B3(i,a));
		b4.addActionListener(new B4(i,a));
		
		
		container.add(blank1);
		container.add(question);
		container.add(qNumber);
		container.add(blank2);
		container.add(b1);
		container.add(b2);
		container.add(b3);
		container.add(b4);
		
		container.setLayout(new GridLayout(2,4));
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	private class B1 implements ActionListener{
		int i, c;
		B1(int j,int b){i=j;c=b;}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			tot++;
			System.out.println(tot);
			if(i == 0) {
				//correct
				c++;
				if(c<=5) {
					new ButtonPressGame(c, st);
					dispose();
				}
				else {
					System.out.println(c+ "\t" + tot);
					st.setGeoPoints(st.getGeoPoints() + c - 1);
					st.setGeoPointsTot(st.getGeoPointsTot() + tot - 1);
					new HomePage(st);
					tot = 0;
					dispose();
				}
				
			}
			else {
				new incorrectWindow();
			}
		}
	}
	private class B2 implements ActionListener{
		int i, c;
		B2(int j,int b){i=j;c=b;}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			tot++;
			System.out.println(tot);
			if(i == 1) {
				//correct
				c++;
				if(c<=5) {
					new ButtonPressGame(c, st);
					dispose();
				}
				else {
					System.out.println(c+ "\t" + tot);
					st.setGeoPoints(st.getGeoPoints() + c - 1);
					st.setGeoPointsTot(st.getGeoPointsTot() + tot - 1);
					new HomePage(st);
					tot = 0;
					dispose();
				}
				
			}
			else {
				new incorrectWindow();
			}
		}
	}
	private class B3 implements ActionListener{
		int i, c;
		B3(int j,int b){i=j;c=b;}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			tot++;
			System.out.println(tot);
			if(i == 2) {
				//correct
				System.out.println("test");
				c++;
				if(c<=5) {
					new ButtonPressGame(c, st);
					dispose();
				}
				else {
					System.out.println(c+ "\t" + tot);
					st.setGeoPoints(st.getGeoPoints() + c - 1);
					st.setGeoPointsTot(st.getGeoPointsTot() + tot - 1);
					new HomePage(st);
					tot = 0;
					dispose();
				}
				
			}
			else {
				new incorrectWindow();
			}
		}
	}
	private class B4 implements ActionListener{
		int i, c;
		B4(int j,int b){i=j;c=b;}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			tot++;
			System.out.println(tot);
			if(i == 3) {
				//correct
				System.out.println("test");
				c++;
				if(c<=5) {
					new ButtonPressGame(c, st);
					dispose();
				}
				else {
					System.out.println(c+ "\t" + tot);
					st.setGeoPoints(st.getGeoPoints() + c - 1);
					st.setGeoPointsTot(st.getGeoPointsTot() + tot - 1);
					new HomePage(st);
					tot = 0;
					dispose();
				}
				
			}
			else {
				new incorrectWindow();
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}


class incorrectWindow extends JFrame implements ActionListener {
	
	incorrectWindow(){
		super("Incorrect");
		setSize(300,100);
		JButton a = new JButton("Try Again");
		a.addActionListener(this);
		add(a);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
		System.out.println("test");
	}
}





