package Quiz;


import java.awt.*;


import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

import HomePage.HomePage;
import People.Student;


class MyButton3 extends JButton {

	
    public MyButton3() 
    {
        super();
        begin();
    }

    public MyButton3(BufferedImage image) {

        super(new ImageIcon(image));
        begin();
    }

    private void begin() {

        BorderFactory.createLineBorder(Color.gray);

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
            	
                setBorder(BorderFactory.createLineBorder(Color.yellow));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBorder(BorderFactory.createLineBorder(Color.gray));
            }
        });
    }
}


public class Event1 extends JFrame implements ActionListener
{
	Student st;
	JFrame frame;
	public Event1(Student student)
    {
		st = student;
         frame = new JFrame("Opening window");
        
 		frame.setSize(675,300);
 		

 		Container container = frame.getContentPane();
 		container.setLayout(new FlowLayout());
 		
 		JPanel panel1 = new JPanel();
 		JLabel label1 = new JLabel("Please move the pieces on the next screen to complete the square puzzle and press the 'Check' button when done.");
 		JPanel panel2 = new JPanel(); 	
 		JLabel label2 = new JLabel("Press continue when ready to move to the game "); 
 		///container.add(label1);
 		//container.add(label2);
 		panel1.add(label1);
 		panel2.add(label2);
 		
 		JPanel panel3 = new JPanel();
 		JButton calculateButton = new JButton("Continue");
 		panel3.add(calculateButton);
 		
 		calculateButton.addActionListener(this);
 		
 		container.add(panel1,BorderLayout.NORTH);
 		container.add(panel2,BorderLayout.CENTER);
 		container.add(panel3, BorderLayout.SOUTH); 
 		// show the frame in the center of the screen
 		frame.setLocationRelativeTo(null);
 		frame.setVisible(true);
 	
 	}
 	
 	public void actionPerformed(ActionEvent e) 
 	{
 		
 		Event2 t = new Event2(st); 
    	try 
    	{
			t.gameWindow();
			frame.dispose();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		} 
 		
 	}
}
class Event2 extends JFrame implements ActionListener
{
	
	
	PuzzleGame c; 
	PuzzleGame one, two, three, four, five, six, seven, eight, nine; 
	Student st;
	JFrame frame;
	static int attempts = 1;
	public Event2 (Student student)
	{
		st = student;
	}
 	public void  gameWindow() throws IOException
 	{
 		frame = new JFrame("Game Window");
        
         frame.setLayout(null);
         
         BufferedImage check = ImageIO.read(new File("files/Images/puzzleImages/c.jpg"));
     
         BufferedImage i1 = ImageIO.read(new File("files/Images/puzzleImages/sunflower1.jpg"));
         BufferedImage i2 = ImageIO.read(new File("files/Images/puzzleImages/sunflower2.jpg"));
         BufferedImage i3 = ImageIO.read(new File("files/Images/puzzleImages/sunflower3.jpg"));
         BufferedImage i4 = ImageIO.read(new File("files/Images/puzzleImages/sunflower4.jpg"));
         BufferedImage i5 = ImageIO.read(new File("files/Images/puzzleImages/sunflower5.jpg"));
         BufferedImage i6 = ImageIO.read(new File("files/Images/puzzleImages/sunflower6.jpg"));
         BufferedImage i7 = ImageIO.read(new File("files/Images/puzzleImages/sunflower7.jpg"));
         BufferedImage i8 = ImageIO.read(new File("files/Images/puzzleImages/sunflower8.jpg"));
         BufferedImage i9 = ImageIO.read(new File("files/Images/puzzleImages/sunflower9.jpg"));
        
         one = new PuzzleGame(i1); 
         two = new PuzzleGame(i2); 
         three = new PuzzleGame(i3); 
         four = new PuzzleGame(i4); 
         five = new PuzzleGame(i5); 
         six = new PuzzleGame(i6); 
         seven = new PuzzleGame(i7); 
         eight = new PuzzleGame(i8); 
         nine = new PuzzleGame(i9); 
         
         frame.getContentPane().add(one);
         frame.getContentPane().add(two);
         frame.getContentPane().add(three);
         frame.getContentPane().add(four);
         frame.getContentPane().add(five);
         frame.getContentPane().add(six);
         frame.getContentPane().add(seven);
         frame.getContentPane().add(eight);
         frame.getContentPane().add(nine);
         
         c = new PuzzleGame(check); 
         c.addActionListener((ActionListener) this);
         frame.getContentPane().add(c);
        
        
         
         frame.setSize(1000, 1000);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);
         
        
 	}
 	public void actionPerformed(ActionEvent e) 
 	{
 		System.out.println("continue");
 		checkGame(); 
 		attempts++;
 		System.out.println (attempts);
 	}
 	
 	public void checkGame()
 	{
 		int onex = one.getLocation().x;
 		int oney = one.getLocation().y;
 		
 		int twox = two.getLocation().x;
 		int twoy = two.getLocation().y;
 		
 		int threex = three.getLocation().x;
 		int threey = three.getLocation().y;
 		
 		int fourx = four.getLocation().x;
 		int foury = four.getLocation().y;
 		
 		int fivex = five.getLocation().x;
 		int fivey = five.getLocation().y;
 		
 		int sixx = six.getLocation().x;
 		int sixy = six.getLocation().y;
 		
 		int sevenx = seven.getLocation().x;
 		int seveny = seven.getLocation().y;
 		
 		
 		int eightx = eight.getLocation().x;
 		int eighty = eight.getLocation().y;
 		
 		int ninex = nine.getLocation().x;
 		int niney = nine.getLocation().y;
 		
 		
 		int d1 = (onex + 150) - twox; 
 		System.out.println(d1); 
 		
 		int d2 = (twox + 150) - threex; 
 		int d3 = (oney + 150) - foury; 
 		int d4 = (twoy + 150) - fivey; 
 		int d5 = (threey + 150) - sixy; 
 		int d6 = (fourx + 150) - fivex; 
 		int d7 = (fivex + 150) - sixx; 
 		int d8 = (foury + 150) - seveny; 
 		int d9 = (fivey + 150) - eighty; 
 		int d10 = (sixy + 150) - niney; 
 		int d11 = (sevenx + 150) - eightx; 
 		int d12 = (eightx + 150) - ninex; 
 		
 		
 		if(((-10 < d1) && (d1 < 10))  && ((-10 < d2) && (d2 < 10))  && ((-10 < d3) && (d3 < 10))  && ((-10 < d4) && (d4 < 10))  && 
 				((-10 < d5) && (d5 < 10))  && ((-10 < d6) && (d6 < 10))  &&  ((-10 < d7) && (d7 < 10))  && ((-10 < d8) && (d8 < 10)) && 
 				((-10 < d9) && (d9 < 10))  && ((-10 < d10) && (d10 < 10))  &&  ((-10 < d11) && (d11 < 10))  && ((-10 < d12) && (d12 < 10))) 
 		{
 			System.out.println("true");
 			Event3 z = new Event3(st, attempts); 
 	    	z.openWindow3(); 
 	    	attempts = 0;
 	    	frame.dispose();
 		}
 		else
 		{
 			JOptionPane.showMessageDialog(null,"Incorrect, try a different arrangement"); 
 			System.out.println("check game ");
 		}
 		
 		
 	}
}

class Event3 extends JFrame implements ActionListener
{
	Student st;
	JFrame frame;
	int attempts;
	public Event3 (Student st, int attempts)
	{
		this.st = st;
		this.attempts = attempts;
	}
	void openWindow3()
    {
    	
        frame = new JFrame("Closing Window");
        
 		frame.setSize(500,500);

 		Container container = frame.getContentPane();
 		container.setLayout(new FlowLayout());
 		
 		
 		JPanel panel1 = new JPanel();
 		JPanel panel2 = new JPanel(); 
 		
 		JLabel label1 = new JLabel("CONGRATS! You completed the puzzle correctly!");
 		JLabel Label2 = new JLabel(" Press the Exit button to return to home page"); 
 		
 		
 		//container.add(label1);
 		panel1.add(label1);
 		panel1.setBackground(Color.GREEN); 
 		panel2.add(Label2); 
 		
 		JPanel panel3 = new JPanel();
 		JButton calculateButton = new JButton("Exit");
 		panel3.add(calculateButton);
 		
 		calculateButton.addActionListener(this);
 		
 		container.add(panel1,BorderLayout.NORTH);
 		container.add(panel2,BorderLayout.CENTER);
 		container.add(panel3, BorderLayout.SOUTH); 
 		// show the frame in the center of the screen
 		frame.setLocationRelativeTo(null);
 		frame.setVisible(true);
 	
 	}
 	
 	public void actionPerformed(ActionEvent e) 
 	{
 		st.setPuzzlePoints(st.getPuzzlePoints() + 1);
 		st.setPuzzlePointsTot(st.getPuzzlePointsTot() + attempts);
 		System.out.println(st.getPuzzlePoints() + "\t" + st.getPuzzlePointsTot()); 
 		new HomePage (st);
 		frame.dispose();
 	}
}



class PuzzleGame extends MyButton3 
{

    private volatile int draggedAtX, draggedAtY;
    Image im;
    
    public PuzzleGame(BufferedImage image){
        
    	
    	super(image);
        
        setDoubleBuffered(false);
       
        im = image; 

        int w = image.getWidth();
        int h = image.getHeight(); 
        
        
        if(im.getWidth(null) > 155)
    	{
        	
    		System.out.println("check"); 
            setMargin(new Insets(0, 0, 0, 0));
    		setLocation(450, 30); 
    		setSize(w, h);
            setPreferredSize(new Dimension(w, h));
    	}
        else
        {
        	 Random rand = new Random();        
             setLocation(rand.nextInt(700),rand.nextInt(300)+400); 
             
             setMargin(new Insets(0, 0, 0, 0));
             //System.out.println(image.getHeight()); 
             //System.out.println(image.getWidth()); 
            
             setSize(150, 150);
             setPreferredSize(new Dimension(150, 150));
        }
        
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                draggedAtX = e.getX();
                System.out.println(draggedAtX);
                draggedAtY = e.getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e){
                setLocation(e.getX() - draggedAtX + getLocation().x,
                        e.getY() - draggedAtY + getLocation().y);
            }
        });
       
    }
  /*
    public static void main(String[] args) throws Exception
    {
        
    	
    	
    	
    	
    	//JFrame frame = new JFrame("DragButton");
        
        
       // frame.setLayout(null);
        /*
        BufferedImage i1 = ImageIO.read(new File("C:/Users/cbushnel/coen160labs/puzzlegame/gameimages/sunflower1.jpg"));
        BufferedImage i2 = ImageIO.read(new File("C:/Users/cbushnel/coen160labs/puzzlegame/gameimages/sunflower2.jpg"));
        BufferedImage i3 = ImageIO.read(new File("C:/Users/cbushnel/coen160labs/puzzlegame/gameimages/sunflower3.jpg"));
        BufferedImage i4 = ImageIO.read(new File("C:/Users/cbushnel/coen160labs/puzzlegame/gameimages/sunflower4.jpg"));
        BufferedImage i5 = ImageIO.read(new File("C:/Users/cbushnel/coen160labs/puzzlegame/gameimages/sunflower5.jpg"));
        BufferedImage i6 = ImageIO.read(new File("C:/Users/cbushnel/coen160labs/puzzlegame/gameimages/sunflower6.jpg"));
        BufferedImage i7 = ImageIO.read(new File("C:/Users/cbushnel/coen160labs/puzzlegame/gameimages/sunflower7.jpg"));
        BufferedImage i8 = ImageIO.read(new File("C:/Users/cbushnel/coen160labs/puzzlegame/gameimages/sunflower8.jpg"));
        BufferedImage i9 = ImageIO.read(new File("C:/Users/cbushnel/coen160labs/puzzlegame/gameimages/sunflower9.jpg"));
        BufferedImage check = ImageIO.read(new File("C:/Users/cbushnel/coen160labs/puzzlegame/gameimages/c.jpg"));
       
        
        
        frame.getContentPane().add(new PuzzleGame(i1));
        frame.getContentPane().add(new PuzzleGame(i2));
        frame.getContentPane().add(new PuzzleGame(i3));
        frame.getContentPane().add(new PuzzleGame(i4));
        frame.getContentPane().add(new PuzzleGame(i5));
        frame.getContentPane().add(new PuzzleGame(i6));
        frame.getContentPane().add(new PuzzleGame(i7));
        frame.getContentPane().add(new PuzzleGame(i8));
        frame.getContentPane().add(new PuzzleGame(i9));
        frame.getContentPane().add(new PuzzleGame(check));
        
        JLabel prompt = new JLabel("Please move the pieces to complete the puzzle and press the 'Check' button when done"); 
        JPanel quest = new JPanel(); 
        quest.add(prompt); 
        frame.getContentPane().add(new JLabel("Please move the pieces to complete the puzzle and press the 'Check' button when done")); 
        
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
       */
    //}

    
}
