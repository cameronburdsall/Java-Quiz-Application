package People;

import java.io.*;
import java.util.ArrayList;

public class Admin implements java.io.Serializable
{
	private String name;
	private String pswd;
	private ArrayList<Student> stdnts;
	
	public Admin(String name, String pswd)
	{
		stdnts = new ArrayList<Student> ();
		this.name = name;
		this.pswd = pswd;
		populateStudents();
	}
	
	public Admin copyAdmin ()
	{
		Admin a = new Admin("default", "password");
		a.setName(this.name);
		a.setPswd(this.pswd);
		a.setStdnts(this.stdnts);
		return a;
	}
	
	public void updateStudent(Student student)
	{
		int i = 0;
		while (!stdnts.get(i).getStudentName().equals(student.getStudentName()))
		{
			i++;
			if (i >= stdnts.size())
			{
				System.out.println("Student not found");
				return;
			}
		}
		stdnts.set(i, student);
	}
	
	public int indexOfStudent (String name)
	{
		int i;
		for (i = 0; i < stdnts.size(); i++)
		{
			if (name.equals(stdnts.get(i).getStudentName()))
			{
				return i;
			}
		}
		return -1;
	}
	public Student getStudent (String name)
	{
		Student query = new Student(name);
		for (int i = 0; i < stdnts.size(); i++)
		{
			if (name.equals(stdnts.get(i).getStudentName()))
			{
				query=stdnts.get(i).copyStudent();
			}
		}
		return query;
	}
	
	public boolean studentExists (String name)
	{
		for (int i = 0; i < stdnts.size(); i++)
		{
			if (name.equals(stdnts.get(i).getStudentName()))
			{
				return true;
			}
		}
		return false;
	}
	
	public void serializeStudents()
	{
		try {
			FileOutputStream outFile = new FileOutputStream ("files/students.ser");
			ObjectOutputStream obOut = new ObjectOutputStream (outFile);
			for (int i = 0; i < stdnts.size(); i++) {
				obOut.writeObject (stdnts.get(i));
			}
			obOut.close();
			outFile.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void serializeAdmin()
	{
		ArrayList<Admin> admins = new ArrayList<Admin>();
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
				obIn.close();
				inFile.close();
			}
		}
		catch (OptionalDataException e)
		{
			System.out.println("Data Exceeded");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//find admins
		boolean exists = false;
		System.out.println("Serializing Admins");
		if (admins.size()>0)//if there are saved admins, find and overwrite this, then rewrite
		{
			for (int i = 0; i < admins.size(); i++) {
				if (name.equals(admins.get(i).getName())){
					admins.set(i, this);
					exists = true;
					break;
				}
			}
			
			if (exists == false)
			{
				admins.add(this);
			}
			
			try {
				FileOutputStream outFile = new FileOutputStream ("files/admins.ser");
				ObjectOutputStream obOut = new ObjectOutputStream (outFile);
				for (int i = 0; i < admins.size(); i++) {
					obOut.writeObject (admins.get(i));
				}
				obOut.close();
				outFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {//if not saved admins, just save
		try {
			FileOutputStream outFile = new FileOutputStream ("files/admins.ser");
			ObjectOutputStream obOut = new ObjectOutputStream (outFile);
			obOut.writeObject (this);
			obOut.close();
			outFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	
	public void populateStudents()
	{
		try {
			FileInputStream inFile = new FileInputStream ("files/students.ser");
			ObjectInputStream obIn = new ObjectInputStream (inFile);
			try {
				while (true)
				{
					try {
						this.stdnts.add((Student)obIn.readObject()); 
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			catch (EOFException e) {
				//end of file
				System.out.println("Students imported Successfully!");
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

	public ArrayList<Student> getStdnts() {
		return stdnts;
	}

	public void setStdnts(ArrayList<Student> stdnts) {
		this.stdnts = stdnts;
	}
	
}