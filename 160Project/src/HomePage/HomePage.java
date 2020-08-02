package HomePage;

import javax.swing.*;
import Quiz.*;

import People.Student;

import java.awt.*;
import java.awt.event.*;

public class HomePage extends JFrame implements ActionListener {
	//declarations
		JFrame f;
		JLabel prompt;
		JButton mGame, gGame, aGame, puzzle, save;
		Student student;
		//constructor
		public HomePage(Student stdnt) {
			super("Welcome " + stdnt.getStudentName() +"!");
			student = stdnt.copyStudent();
			
			setSize(500,500);
			
			
			//f = new JFrame()
			Container container = getContentPane();
			prompt = new JLabel(student.getStudentName() + ", select a topic for the quiz", JLabel.CENTER);
			mGame = new JButton("Math");
			mGame.setBounds(10, 10, 50, 50);
			gGame = new JButton("Geography");
			aGame = new JButton("Animals");
			puzzle = new JButton("Puzzle");
			save = new JButton ("Save and Quit");
			
			mGame.addActionListener(new Math());
			gGame.addActionListener(new Geography());
			aGame.addActionListener(new Animal());
			puzzle.addActionListener(new Puzzle());
			 save.addActionListener(this);
			 
			container.add(prompt);
			container.add(mGame);
			container.add(gGame);
			container.add(aGame);
			container.add(puzzle);
			container.add(save);
			
			container.setLayout(new GridLayout(6,1));
			
			// showing the frame in the center of the screen


			setLocationRelativeTo(null);
			setVisible(true);
		}
		
		
		/////////////   Driver Classes    ////////////////
		
		private class Math implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new mathGame(1, student);
			}
		}
		private class Geography implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new ButtonPressGame(1, student);
			}
		}
		private class Animal implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new matchingGame(0,0, student);
			}
		}
		private class Puzzle implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Event1(student);
			}
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			student.serializeStudent();
			this.dispose();
		}

}
