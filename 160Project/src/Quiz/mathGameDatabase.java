package Quiz;

import java.util.ArrayList;
import java.util.Random;

public class mathGameDatabase {
	ArrayList<mathQuestion> questions;	//list of questions
	private int i = -1;					//previous Questions index for newQ
	
	mathGameDatabase(){
		//file i/o read and build the database
		questions = new ArrayList<mathQuestion>();
		questions.add(new mathQuestion(1,4,'+'));
		questions.add(new mathQuestion(2,6,'-'));
		questions.add(new mathQuestion(3,2,'*'));
		questions.add(new mathQuestion(4,9,'+'));
	}
	
	void addQuestion(int f, int s, char op) {
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

class mathQuestion {
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
