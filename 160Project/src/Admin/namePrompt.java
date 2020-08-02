package Admin;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import People.Admin;
import People.Student;

public class namePrompt extends JFrame implements ActionListener
{
	private JTextField stdntName;
	private JLabel nameLabel;
	private JButton submit;
	Admin admin;
	int mode;
	public namePrompt(Admin admin, int mode) //0 for show score, 1 for change score
	{
		super ("Enter Student Name");
		setSize (500, 100);
		Container container = getContentPane();
		container.setLayout (new FlowLayout());
		
		this.admin= admin;
		
		nameLabel = new JLabel ("Student Name: ", JLabel.CENTER);
		container.add(nameLabel);
		
		stdntName = new JTextField(10);
		stdntName.addActionListener(this);
		container.add(stdntName);
		
		submit = new JButton ("Enter");
		//stdntName.addActionListener(this);//may change
		submit.addActionListener(this);
		container.add(submit);
		
		this.mode = mode;
		
		setLocationRelativeTo(null);
		setVisible (true);
	}
	@Override
	public void actionPerformed (ActionEvent e)
	{	
		if (mode == 0)
			{

			if (admin.studentExists (stdntName.getText()))
			{
				new showStudentDetails(admin.getStudent(stdntName.getText()));
				this.dispose();
			}
			else {
				JOptionPane.showMessageDialog(null,"Student does not exist"); 
			}
		}
		else if (mode == 1)
		{
			if (admin.studentExists (stdntName.getText()))
			{
				new showStudentDetails(admin.getStudent(stdntName.getText()));
				new changeStudentScore(admin, stdntName.getText());
				new showStudentDetails(admin.getStudent(stdntName.getText()));
				this.dispose();
			}
			else {
				JOptionPane.showMessageDialog(null,"Student does not exist"); 
			}
		}
	}
}
class changeStudentScore extends JFrame implements ActionListener
{
	JComboBox<String> subjects;
	JButton submit;
	JTextField points, total;
	JLabel p, t;
	Admin a;
	String name;
	//Student stud;
	public changeStudentScore(Admin admin, String student)
	{
		super ("Changing Score for " + student);
		setSize (500, 100);
		Container container = getContentPane();
		container.setLayout (new FlowLayout());
		String sub[] = {"Math", "Geography", "Animals", "Puzzle"};
		subjects = new JComboBox<String> (sub);
		container.add(subjects);
		
		a = admin;
		name = student;
		
		submit = new JButton ("Submit");
		points = new JTextField (10);
		total = new JTextField (10);
		p = new JLabel ("Points: ");
		t = new JLabel ("Total: ");
		
		container.add(p);
		container.add(points);
		
		container.add(t);
		total.addActionListener(this);
		container.add(total);
		
		submit.addActionListener(this);
		container.add(submit);
		
		setLocationRelativeTo(null);
		setVisible (true);
		
		
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			Student s = a.getStudent(name);
			String inputp = points.getText();
			String inputt = total.getText();
			String sub = (String)subjects.getSelectedItem();
			System.out.println((String)subjects.getSelectedItem());
			int convP, convT;
			convP = Integer.parseInt(inputp);
			convT = Integer.parseInt(inputt);
			
			
			if (sub.equals( "Math")) {
				s.setMathPoints(convP);
				s.setMathPointsTot(convT);
				a.updateStudent(s);
				System.out.println(s.getMathPoints());

			}
			else if (sub.equals("Geography")) {
				s.setGeoPoints(convP);
				s.setGeoPointsTot(convT);
				a.updateStudent(s);
			}
			else if (sub.equals("Animals")) {
				s.setAnimalPoints(convP);
				s.setAnimalPointsTot(convT);
				a.updateStudent(s);
			}
			else if (sub.equals("Puzzle")) {
				s.setPuzzlePoints(convP);
				s.setPuzzlePointsTot(convT);
				a.updateStudent(s);
			}
			this.dispose();
		
		}
		catch(NumberFormatException ex){ 
				JOptionPane.showMessageDialog(null,"Please type in a valid number"); 
		}
	}
}

class showStudentDetails extends JFrame
{
		JLabel namelabel, mathlabel, geolabel, animallabel, puzzlelabel;
		JPanel name, math, geo, animal, puzzle;
		JTextArea stdntNames;
		public showStudentDetails (Student student)
		{
			super (student.getStudentName() + "'s Scores and Totals");
			setSize (500, 750);
			namelabel = new JLabel();
			mathlabel = new JLabel();
			geolabel = new JLabel();
			animallabel = new JLabel();
			puzzlelabel = new JLabel();
			
			namelabel.setFont(new Font("Sans", Font.BOLD, 30));
			name = new JPanel();
			namelabel.setText(student.getStudentName()+"'s Scores & Totals");
			name.add(namelabel);
			
			math = new JPanel ();
			mathlabel.setFont(new Font("Sans", Font.BOLD, 30));
			math.setBackground(Color.CYAN);
			mathlabel.setText("<html>Math: " + student.getMathPoints() + "<br/>Total: " + student.getMathPointsTot()+"</html>");
			math.add(mathlabel);
			
			geo = new JPanel ();
			geolabel.setFont(new Font("Sans", Font.BOLD, 30));
			geo.setBackground(Color.GREEN);
			geolabel.setText("<html>Geography: " + student.getGeoPoints() + "<br/>Total: " + student.getGeoPointsTot()+"</html>");
			geo.add(geolabel);
			
			animal = new JPanel();
			animallabel.setFont(new Font("Sans", Font.BOLD, 30));
			animal.setBackground(Color.yellow);
			animallabel.setText("<html>Animals: " + student.getAnimalPoints() + "<br/>Total: " + student.getAnimalPointsTot()+"</html>");
			animal.add(animallabel);
			
			puzzle = new JPanel();
			puzzlelabel.setFont(new Font("Sans", Font.BOLD, 30));
			puzzle.setBackground(Color.pink);
			puzzlelabel.setText("<html>Puzzle: " + student.getPuzzlePoints() + "<br/>Total: " + student.getPuzzlePointsTot()+"</html>");
			puzzle.add(puzzlelabel);
			
			stdntNames = new JTextArea();
			Container con = getContentPane();
			
			
			String output = new String();
			output += " <html><b>Name: " + student.getStudentName() + "</b></html>\n Math Points: "+student.getMathPoints() + "\n Math Total: "
					+ student.getMathPointsTot() + "\n Geography Points: " + student.getGeoPoints() + "\n Geography Total: " + student.getGeoPointsTot()
					+ "\n Animal Points: " + student.getAnimalPoints() + "\n Animal Total: " + student.getAnimalPointsTot() +"\n Puzzle Points " + student.getAnimalPoints()
					+ "\n Puzzle Total: " + student.getPuzzlePointsTot() + "\n";
			
			con.add(name);
			con.add(math);
			con.add(geo);
			con.add(animal);
			con.add(puzzle);
			//stdntNames.setText(output);
			//con.add(stdntNames);
			con.setLayout(new GridLayout(5,1));
			//con.add(panel, BorderLayout.CENTER);
			//setLocationRelativeTo(null);
			setVisible(true);
			stdntNames.setEditable(false);
		}
}