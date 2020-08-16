package Quiz;
import javax.swing.*;

import HomePage.HomePage;
import People.Student;

import java.awt.*;
import java.awt.event.*;


public class matchingGame extends JFrame implements ActionListener {
	JLabel prompt, monkey, giraffe, elephant, lion;
	JButton check;
	JPanel p1, p2;
	JComboBox menu;
	stateQuestion current;
	int qCorrect;
	int numAttempts; 
	String [] animals = {"giraffe", "monkey", "elephant", "lion"};
	String [] order = {"monkey", "giraffe", "lion", "elephant"}; 
	Student st;
	
	public matchingGame(int qS, int nA, Student student)
	{
		
		super("Animal Quiz: "+ (qS+1) + " of 4");
		setSize(500,500);
		Container container = getContentPane();
		st = student;
		qCorrect = qS; 
		numAttempts = nA; 
		
		menu = new JComboBox(animals);     
        check = new JButton("Check");
        p1 = new JPanel();
		p2  = new JPanel();
		prompt = new JLabel("Question: what animal that?", JLabel.CENTER);
        
        if(qCorrect == 0)
		{
			Image monkeyIm = new ImageIcon("files/Images/animalGame/monkey.jpg.png").getImage().getScaledInstance(150, 260, Image.SCALE_DEFAULT); 
			ImageIcon monkeyIc = new ImageIcon(monkeyIm); 
		    monkey = new JLabel(); 
			monkey.setIcon(monkeyIc);
			p1.add(monkey);
	        p1.add(menu);
	        p2.add(check);
	        check.addActionListener(this);
	        container.add(prompt);
	        container.add(p1);
	        container.add(p2);  
	        container.setLayout(new GridLayout(3,1)); 
			setLocationRelativeTo(null);
			setVisible(true);	
		}
        
      
        if(qCorrect == 1)
        {
        	Image giraffeIm = new ImageIcon("files/Images/animalGame/giraffe.jpg.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT); 
    		ImageIcon giraffeIc = new ImageIcon(giraffeIm); 
    		giraffe = new JLabel(); 
    		giraffe.setIcon(giraffeIc);
    		p1.add(giraffe);
	        p1.add(menu);
	        p2.add(check);
	        check.addActionListener(this);
	        container.add(prompt);
	        container.add(p1);
	        container.add(p2);
	        container.setLayout(new GridLayout(3,1)); 
			setLocationRelativeTo(null);
			setVisible(true);	   				
        }
        
        
        if(qCorrect == 2)
		{
			Image lionIm = new ImageIcon("files/Images/animalGame/lion.jpg.png").getImage().getScaledInstance(180, 150, Image.SCALE_DEFAULT); 
			ImageIcon lionIc = new ImageIcon(lionIm); 
			lion = new JLabel(); 
			lion.setIcon(lionIc);
			p1.add(lion);
	        p1.add(menu);
	        p2.add(check);
	        check.addActionListener(this);
	        container.add(prompt);
	        container.add(p1);
	        container.add(p2);
	        container.setLayout(new GridLayout(3,1)); 
			setLocationRelativeTo(null);
			setVisible(true);	   		
		}
        
        else if(qCorrect == 3)
		{
			Image elephantIm = new ImageIcon("files/Images/animalGame/elephant.jpg.png").getImage().getScaledInstance(150, 200, Image.SCALE_DEFAULT); 
			ImageIcon elephantIc = new ImageIcon(elephantIm); 
			elephant = new JLabel(); 
			elephant.setIcon(elephantIc);
			p1.add(elephant);
	        p1.add(menu);
	        p2.add(check);
	        check.addActionListener(this);
	        container.add(prompt);
	        container.add(p1);
	        container.add(p2);
	        container.setLayout(new GridLayout(3,1)); 
			setLocationRelativeTo(null);
			setVisible(true);	   		
			
		}
		 
        
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		String sel = String.valueOf(menu.getSelectedItem()); 
		numAttempts++; 
		
		if(order[qCorrect].equals(sel))
		{
			System.out.println("correct"); 
			
				if(qCorrect == 3)
				{
					qCorrect++; 
					System.out.println(numAttempts); 
					
					// add something here for student score
					System.out.println (qCorrect + "/t" + numAttempts);
					st.setAnimalPoints(st.getAnimalPoints() + qCorrect);
					st.setAnimalPointsTot(st.getAnimalPointsTot() + numAttempts);
					new HomePage(st); 
					//System.exit(0);
				}
			
			qCorrect++; 
			System.out.println(numAttempts); 
			matchingGame a = new matchingGame(qCorrect, numAttempts, st); 
			dispose();
			
		}
		else
		{
			matchingGame a = new matchingGame(qCorrect, numAttempts, st); 
			dispose();
			System.out.println(numAttempts); 
		}
		
	}
	
}
