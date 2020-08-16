package Quiz;

import java.util.*;

public class StatesDatabase {
	
	public static String[] STATES = {"Alabama","Alaska","Arizona","Arkansas",
			"California","Colorado","Connecticut","Delaware",
			"Florida","Georgia","Hawaii","Idaho","Illinois",
			"Indiana","Iowa","Kansas","Kentucky","Louisiana",
			"Maine","Maryland","Massachusetts","Michigan",
			"Minnesota","Mississippi","Missouri","Montana",
			"Nebraska","Nevada","New Hampshire","New Jersey",
			"New Mexico","New York","North Carolina","North Dakota",
			"Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island",
			"South Carolina","South Dakota","Tennessee","Texas","Utah",
			"Vermont","Virginia","Washington","West Virginia",
			"Wisconsin","Wyoming"};
	public static String[] STATESimg = {"Alabama","Alaska","Arizona","Arkansas",
			"California","Colorado","Connecticut","Delaware",
			"Florida","Georgia","Hawaii","Idaho","Illinois",
			"Indiana","Iowa","Kansas","Kentucky","Louisiana",
			"Maine","Maryland","Massachusetts","Michigan",
			"Minnesota","Mississippi","Missouri","Montana",
			"Nebraska","Nevada","New_Hampshire","New_Jersey",
			"New_Mexico","New_York","North_Carolina","North_Dakota",
			"Ohio","Oklahoma","Oregon","Pennsylvania","Rhode_Island",
			"South_Carolina","South_Dakota","Tennessee","Texas","Utah",
			"Vermont","Virginia","Washington","West_Virginia",
			"Wisconsin","Wyoming"};
	
	private int qCounter;
	//File i/o stuff
	StatesDatabase() {
	
	}
	
	public stateQuestion generateQuestion() {
		Random rand = new Random();
		int c = rand.nextInt(50);
		int I1 = rand.nextInt(50);
		while(I1==c||(I1==5&&c==49)||(c==5&&I1==49)) {
			I1 = rand.nextInt(50);
		}
		int I2 = rand.nextInt(50);
		while(I1==I2||c==I2||(I1==5&&I2==49)||(I2==5&&I1==49)||(c==5&&I2==49)||(I2==5&&c==49)) {
			I2 = rand.nextInt(50);
		}
		int I3 = rand.nextInt(50);
		while(I3==I2||I3==I1||I3==c||(I3==5&&c==49)||(c==5&&I3==49)||(I3==5&&I2==49)||(I2==5&&I3==49)||(I3==5&&I1==49)||(I1==5&&I3==49)) {
			I3 = rand.nextInt(50);
		}
		return new stateQuestion(STATES[c], STATESimg[c], STATESimg[I1], STATESimg[I2], STATESimg[I3]);
		
		
	}
}
//wrongs can't be Wyoming and Colorado, are square
class stateQuestion {
	private String c, ci, w1, w2, w3;
	
	stateQuestion(String g, String cI, String i1, String i2, String i3){
		c = g;
		ci = cI;
		w1 = i1;
		w2 = i2;
		w3 = i3;
	}
	
	public String getC() {
		return c;
	}
	public String getCI() {
		return ci;
	}
	public String getW1() {
		return w1;
	}
	public String getW2() {
		return w2;
	}
	public String getW3() {
		return w3;
	}
	
	
}