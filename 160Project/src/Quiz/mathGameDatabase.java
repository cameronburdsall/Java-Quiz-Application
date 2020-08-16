package Quiz;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.Random;

import People.Student;

public class mathGameDatabase {
	ArrayList<mathQuestion> questions;	//list of questions
	private int i = -1;					//previous Questions index for newQ
	public mathGameDatabase(){
		//file i/o read and build the database
		questions = new ArrayList<mathQuestion>();
		readQuestions();
	}
	
	public void readQuestions() {
		try {
			FileInputStream inFile = new FileInputStream ("files/mathQuestions.ser");
			ObjectInputStream obIn = new ObjectInputStream (inFile);
			try {
				while (true)
				{
					try {
						questions.add((mathQuestion)obIn.readObject()); 
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			catch (EOFException e) {
				//end of file
				System.out.println("Questions imported Successfully!");
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
		
//		for (int i = 0; i < Qs.size(); i++)
//		{
//			if (Qs.get(i).getQuestion().equals(this.studentName))
//			{
//				stdnts.set(i, this);
//			}
//		}
		
	}
	
	public void writeQuestions() {
		try {
			FileOutputStream outFile = new FileOutputStream ("files/mathQuestions.ser");
			ObjectOutputStream obOut = new ObjectOutputStream (outFile);
			for (int i = 0; i < questions.size(); i++) {
				obOut.writeObject (questions.get(i));
			}
			obOut.close();
			outFile.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void addQuestion(int f, int s, char op) {
		questions.add(new mathQuestion(f,s,op));
	}
	
	mathQuestion newQ() {
		mathQuestion back;
		Random rand = new Random();
		int c = rand.nextInt(questions.size());
		while(c==i) {
			c = rand.nextInt(questions.size());
		}
		back = questions.get(c);
		i=c;
		return back;	
	}
	
}

class mathQuestion implements java.io.Serializable {
	private String question;
	private int answer;

	mathQuestion(int f, int s, char op){
		question = String.valueOf(f) + String.valueOf(op)+String.valueOf(s)+"=";
		switch(op) {
			case '+':
				answer = f+s;
				break;
			case '-':
				answer = f-s;
				break;
			case '*':
				answer = f*s;
				break;
			case '/':
				answer = f/s;
				break;
		}
	}
	public String getQuestion() {
		return question;
	}
	public int getAnswer() {
		return answer;
	}
}
