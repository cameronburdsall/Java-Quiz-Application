package Testing;

import People.*;
import java.io.*;
import java.util.ArrayList;

public class SerialTest {
	public ArrayList<Student> s;
	public SerialTest ()
	{
		s = new ArrayList<Student> ();
	}
	public static void main (String [] args)
	{
		
		SerialTest st = new SerialTest();
		
		st.s.add(new Student ("Jimmy"));
		st.s.add(new Student ("Jane"));
		System.out.println(st.s.get(0).getStudentName());
		System.out.println(st.s.get(1).getStudentName());
		st.serializeMe();
		//System.out.println(st.s.get(0).getStudentName());
		//System.out.println(st.s.get(1).getStudentName());
		st.deserializeMe();
		System.out.println(st.s.get(0).getStudentName());
		System.out.println(st.s.get(1).getStudentName());
		
		Admin a = new Admin ("Bill", "pswd");
	}
	public void serializeMe ()
	{
		try {
			FileOutputStream outFile = new FileOutputStream ("files/students.ser");
			ObjectOutputStream obOut = new ObjectOutputStream (outFile);
			for (int i = 0; i < s.size(); i++)
			{
				obOut.writeObject(s.get(i));
			}
			obOut.close();
			outFile.close();
			s.clear();
		}
		catch(IOException e){
			System.out.println ("Cannot find file");
		}
	}
	public void deserializeMe()
	{
		try {
			FileInputStream inFile = new FileInputStream ("files/students.ser");
			ObjectInputStream obIn = new ObjectInputStream (inFile);
			int i = 0;
			try {
				while (true)
				{
					try {
						s.add((Student)obIn.readObject()); 
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
	}
}
