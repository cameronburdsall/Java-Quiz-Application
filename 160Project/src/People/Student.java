package People;

import java.io.*;
import java.util.ArrayList;

public class Student implements java.io.Serializable
{
	private int geoPoints;
	private int geoPointsTot;
	private int mathPoints;
	private int mathPointsTot;
	private int puzzlePoints;
	private int puzzlePointsTot;
	private int animalPoints;
	private int animalPointsTot;
	
	public Student copyStudent ()
	{
		Student copy = new Student (studentName);
		copy.setAnimalPoints(animalPoints);
		copy.setAnimalPointsTot(animalPointsTot);
		copy.setGeoPoints(geoPoints);
		copy.setGeoPointsTot(geoPointsTot);
		copy.setMathPoints(mathPoints);
		copy.setMathPointsTot(mathPointsTot);
		copy.setPuzzlePoints(puzzlePoints);
		copy.setPuzzlePointsTot(puzzlePointsTot);
		return copy;
	}
	
	public int getGeoPointsTot() {
		return geoPointsTot;
	}

	public void setGeoPointsTot(int geoPointsTot) {
		this.geoPointsTot = geoPointsTot;
	}

	public int getMathPointsTot() {
		return mathPointsTot;
	}

	public void setMathPointsTot(int mathPointsTot) {
		this.mathPointsTot = mathPointsTot;
	}

	public int getPuzzlePointsTot() {
		return puzzlePointsTot;
	}

	public void setPuzzlePointsTot(int puzzlePointsTot) {
		this.puzzlePointsTot = puzzlePointsTot;
	}

	public int getAnimalPointsTot() {
		return animalPointsTot;
	}

	public void setAnimalPointsTot(int animalPointsTot) {
		this.animalPointsTot = animalPointsTot;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	private String studentName;
	
	public void serializeStudent()
	{
		boolean exists = false;
		ArrayList<Student> stdnts = new ArrayList<Student>();
		try {
			FileInputStream inFile = new FileInputStream ("files/students.ser");
			ObjectInputStream obIn = new ObjectInputStream (inFile);
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
		
		for (int i = 0; i < stdnts.size(); i++)
		{
			if (stdnts.get(i).getStudentName().equals(this.studentName))
			{
				stdnts.set(i, this);
				exists = true;
				break;
			}
		}
		
		if (exists == false)
		{
			stdnts.add(this);
		}
		
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
	
	public Student(String studentName)
	{
		geoPoints = 0;
		geoPointsTot = 0;
		mathPoints = 0;
		mathPointsTot = 0;
		puzzlePoints = 0;
		puzzlePointsTot = 0;
		animalPoints = 0;
		animalPointsTot = 0;
		
		this.studentName = studentName;
		//TODO
	}
	
	public int getGeoPoints() {
		return geoPoints;
	}

	public void setGeoPoints(int geoPoints) {
		this.geoPoints = geoPoints;
	}

	public int getGeoPointTot() {
		return geoPointsTot;
	}
	public void addGeoPoints (int points, int total)
	{
		geoPoints += points;
		geoPointsTot += total;
	}

	public void setGeoPointTot(int geoPointTot) {
		this.geoPointsTot = geoPointTot;
	}

	public int getMathPoints() {
		return mathPoints;
	}

	public void setMathPoints(int mathPoints) {
		this.mathPoints = mathPoints;
	}
	
	public void addMathPoints (int points, int total)
	{
		mathPoints += points;
		mathPointsTot += total;
	}
	
	public int getMathPointTot() {
		return mathPointsTot;
	}

	public void setMathPointTot(int mathPointTot) {
		this.mathPointsTot = mathPointTot;
	}

	public int getPuzzlePoints() {
		return puzzlePoints;
	}

	public void setPuzzlePoints(int puzzlePoints) {
		this.puzzlePoints = puzzlePoints;
	}

	public void addPuzzlePoints (int points, int total)
	{
		puzzlePoints += points;
		puzzlePointsTot += total;
	}
	
	public int getPuzzlePointTot() {
		return puzzlePointsTot;
	}

	public void setPuzzlePointTot(int puzzlePointTot) {
		this.puzzlePointsTot = puzzlePointTot;
	}

	public int getAnimalPoints() {
		return animalPoints;
	}

	public void setAnimalPoints(int animalPoints) {
		this.animalPoints = animalPoints;
	}

	public void addAnimalPoints (int points, int total)
	{
		animalPoints += points;
		animalPointsTot += total;
	}
	
	public int getAnimalPointTot() {
		return animalPointsTot;
	}

	public void setAnimalPointTot(int animalPointTot) {
		this.animalPointsTot = animalPointTot;
	}

	public Student()
	{
		geoPoints = 0;
		geoPointsTot = 0;
		mathPoints = 0;
		mathPointsTot = 0;
		puzzlePoints = 0;
		puzzlePointsTot = 0;
		animalPoints = 0;
		animalPointsTot = 0;
		
		//TODO
	}
	public int calculateGrade ()
	{

		int points = geoPoints + mathPoints + puzzlePoints + animalPoints;
		int totalPoints = geoPointsTot + mathPointsTot + puzzlePointsTot + animalPointsTot;
		if (totalPoints == 0) return 0;
		float result = (float)points/(float)totalPoints;
		result*=100;
		result = Math.round(result);
		return (int)result;
	}
	
}
