package Quiz;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class test extends JFrame {

	String selectedFoods = "Selected: ";
    public test() {
       setTitle("MenuBarDemo");
       setSize(500, 200);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       
       // Create the menu bar
       JMenuBar menuBar = new JMenuBar();

		// Create a menu
		JMenu menu1 = new JMenu("Fruits");
		menuBar.add(menu1);
	
		// Create a menu item
		JMenuItem item1 = new JMenuItem("Apples");
		// Add the action listener
		item1.addActionListener(new MenuActionListener());
		// Add the menu item to menu
		menu1.add(item1);
	
	    // Create a menu item
		JMenuItem item2 = new JMenuItem("Oranges");
		item2.addActionListener(new MenuActionListener());
		menu1.add(item2);
		
		// Create a second menu
		JMenu menu2 = new JMenu("Drinks");
		menuBar.add(menu2);
		// Create a menu item
		JMenuItem item3 = new JMenuItem("Coke");
		item3.addActionListener(new MenuActionListener());
		menu2.add(item3);
	
	    // Create a menu item
		JMenuItem item4 = new JMenuItem("Orange Juice");
		item4.addActionListener(new MenuActionListener());
		menu2.add(item4);
		
		// Install the menu bar in the frame
		setJMenuBar(menuBar); 	    
       
    }
///////////////////////////////////////////////////
class MenuActionListener implements ActionListener {
  public void actionPerformed(ActionEvent e) {
    //System.out.println("Selected: " + e.getActionCommand());
    selectedFoods += "-"+e.getActionCommand();
    System.out.println(selectedFoods);

  }
}
////////////////////////////////////////////////
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                test ex = new test();
                ex.setVisible(true);
            }
        });
    }
    
 
}
