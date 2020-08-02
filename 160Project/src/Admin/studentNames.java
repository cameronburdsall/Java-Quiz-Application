package Admin;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import People.Admin;

public class studentNames extends JFrame
{
	JLabel label;
	JTextArea stdntNames;
	//JFrame names;
	public studentNames (Admin admin)
	{
		super ("Student Names/Scores");
		setSize (500, 750);
		stdntNames = new JTextArea();
		Container con = getContentPane();
		con.setLayout (new BorderLayout());
		String output = new String();
		output += "Name: \t Current Grade:\n";
		for (int i = 0; i < admin.getStdnts().size(); i++)
		{
			output += admin.getStdnts().get(i).getStudentName() + "\t" + admin.getStdnts().get(i).calculateGrade() + "%\n";
		}
		stdntNames.setText(output);
		con.add(stdntNames);
		//con.add(panel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setVisible(true);
		stdntNames.setEditable(false);
	}
}
