package Quiz;
import javax.swing.*;

import HomePage.HomePage;
import People.Student;

import java.awt.*;
import java.awt.event.*;


public class mathGame extends JFrame implements ActionListener {
		//declarations
			JPanel cover;
			JLabel prompt;
			JTextField r;
			JButton check;
			mathQuestion current;
			mathGameDatabase Questions;
			int num;
			static int tot = 0;
			Student st;
			//constructor
			public mathGame(int c, Student student) {		//(Question #)
				super("Math Quiz: "+c+" of 5");
				Questions = new mathGameDatabase();
				current = Questions.newQ();
				num = c;
				setSize(800,500);
				st = student;
				
				Container container = getContentPane();
				cover = new JPanel();
				prompt = new JLabel(current.getQuestion(), JLabel.CENTER);
				r = new JTextField(30);
				cover.add(r);
				check = new JButton("Check Answer");
				 
				 
				check.addActionListener(new Check());
				 
				container.add(prompt);
				container.add(cover);
				container.add(check);
				
				container.setLayout(new GridLayout(3,1));
				
				setLocationRelativeTo(null);
				setVisible(true);
			}
			private class Check implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					System.out.println("test");
					String input = r.getText();
					int in = 0;
					int answer = current.getAnswer();
					try{
						
						// Write a statement to convert the input value (a string) into an integer
						in = Integer.parseInt(input);
						
					}
					catch(NumberFormatException ex){ 
						JOptionPane.showMessageDialog(null,"Please input a number"); 
						dispose();

					}
					if(answer == in) {	//correct
						if(num>=5) {
							tot++;
							System.out.println (num + "\t" + tot);
							st.setMathPoints(st.getMathPoints() + num);
							st.setMathPointsTot(st.getMathPointsTot() + tot);
							new HomePage(st);
							tot=0;
							dispose();
						}
						else {
							tot++;
							new mathGame(num+1, st);
							dispose();

						}
					}
					else {
						tot++;
						new incorrectWindow();
								
						
					}
				}
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
}
