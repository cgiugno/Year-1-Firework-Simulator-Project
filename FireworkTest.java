/*Name: Catherine Giugno
 * NetID: 31326032
 * Assignment Number: Third Project
 * Lab Section: TR 9:40-10:55
 * I did not collaborate with anyone on this assignment.
 */
import javax.swing.JFrame; //This program will use Java Swing's JFrame functions.
import javax.swing.JPanel; //This program will use Java Swing's JPanel functions.
import javax.swing.JButton; //This program will use Java Swing's JButton functions.
import javax.swing.JLabel; //This program will use Java Swing's JLabel functions.
import javax.swing.JCheckBox; //This program will use Java Swing's JCheckBox functions.
import javax.swing.JTextField; //This program will use Java Swing's JTextField functions.
import javax.swing.BoxLayout; //This program will use Java Swing's BoxLayout functions.

import java.awt.event.ComponentAdapter; //this program will use Java AWT's ComponentAdapter functions.
import java.awt.event.ComponentEvent; //This program will use Java AWT's ComponentEvent functions.
import java.awt.event.ComponentListener; //This program will use Java AWT's ComponentListener functions.

import javax.swing.event.DocumentEvent; //This program will use Java Swing's DocumentEvent functions.
import javax.swing.event.DocumentListener; //This program will use Java Swing's DocumentListener functions.

import java.awt.event.ItemEvent; //This program will use Java AWT's ItemEvent functions.
import java.awt.event.ItemListener; //This program will use Java AWT's ItemListener functions.

import java.awt.BorderLayout; //This program will use Java AWT's BorderLayout functions.
import java.awt.Dimension; //This program will use Java AWT's Dimension functions.
import java.awt.Color; //This program will use Java AWT's Color functions.

public class FireworkTest extends JFrame implements ItemListener{
	private static JTextField velocity; //Creates a new text field accessible by all functions that will hold a firework's velocity.
	private static JTextField angle; //Creates a new text field accessible by all functions that will hold a firework's angle.
	private static JLabel positionLabel = new JLabel(); //Creates a new label accessible by all functions that will prompt the user for the firework's position
	private static JTextField position; //Creates a new text field accessible by all functions that will hold a firework's position.
	private static JTextField time; //Creates a new text field accessible by all functions that will hold the time a firework explodes.
	
	private static JFrame frame; //Creates a new frame accessible by all functions that will hold all the GUI's components.
	private static FireworkPanel fireworks = new FireworkPanel(); //Creates a new FireworkPanel object accessible by all functions that will illustrate the firework's path and explosion.
	
	private static JCheckBox firework1; //Creates a new check box accessible by all functions that will represent whether the user is currently editing the first firework
	private static JCheckBox firework2; //Creates a new check box accessible by all functions that will represent whether the user is currently editing the second firework
	private static JCheckBox firework3; //Creates a new check box accessible by all functions that will represent whether the user is currently editing the third firework
	private static JCheckBox firework4; //Creates a new check box accessible by all functions that will represent whether the user is currently editing the fourth firework
	private static JCheckBox firework5; //Creates a new check box accessible by all functions that will represent whether the user is currently editing the fifth firework
	
	private static Firework fObject1 = new Firework("none","none", "0", "0", "0", "0"); //Creates a new firework object accessible by all functions to represent the first firework
	private static Firework fObject2 = new Firework("none","none", "0", "0", "0", "0"); //Creates a new firework object accessible by all functions to represent the second firework
	private static Firework fObject3 = new Firework("none","none", "0", "0", "0", "0"); //Creates a new firework object accessible by all functions to represent the third firework
	private static Firework fObject4 = new Firework("none","none", "0", "0", "0", "0"); //Creates a new firework object accessible by all functions to represent the fourth firework
	private static Firework fObject5 = new Firework("none","none", "0", "0", "0", "0"); //Creates a new firework object accessible by all functions to represent the fifth firework
	
	private static Firework currentFirework = new Firework("none","none", "0", "0", "0", "0"); //Creates a new firework object accessible by all functions to represent the firework the user is currently editing
	
	
	private static JCheckBox type1; //Creates a new check box accessible by all functions that will represent whether the current firework's type of explosion is Jackson Pollock 
	private static JCheckBox type2; //Creates a new check box accessible by all functions that will represent whether the current firework's type of explosion is Solar Plunge 
	private static JCheckBox type3; //Creates a new check box accessible by all functions that will represent whether the current firework's type of explosion is Bull's Eye 
	private static JCheckBox type4; //Creates a new check box accessible by all functions that will represent whether the current firework's type of explosion is Signal 
	private static JCheckBox type5; //Creates a new check box accessible by all functions that will represent whether the current firework's type of explosion is Circles 
	
	private static JCheckBox fireworkColor1; //Creates a new check box accessible by all functions that will represent whether the current firework's color is red
	private static JCheckBox fireworkColor2; //Creates a new check box accessible by all functions that will represent whether the current firework's color is orange
	private static JCheckBox fireworkColor3; //Creates a new check box accessible by all functions that will represent whether the current firework's color is yellow
	private static JCheckBox fireworkColor4; //Creates a new check box accessible by all functions that will represent whether the current firework's color is green
	private static JCheckBox fireworkColor5; //Creates a new check box accessible by all functions that will represent whether the current firework's color is blue
	
	
	private static String type = "none"; //Creates a new string to represent a type of firework
	private static String aColor = "none"; //Creates a new string to represent a certain type of color
	private static int height = 0; //Creates a new int variable to represent the height of the fireworks panel
	private static int width = 0; //Creates a new int variable to represent the width of the fireworks panel
	
	private static int lastHeight = 0; //Creates a new int variable to represent the height before resizing the window
	private static int lastWidth = 0; //Creates a new int variable to represent the width before resizing the window
	public FireworkTest() { //Creates a constructor for the FireworkTest class
		setLayout(new BorderLayout()); //Sets the overall layout of the FireworkTest object to be determined by the BorderLayout Layout manager
		frame = new JFrame("Fireworks Test"); //Creates a new JFrame object to hold all the components of the Fireworks GUI
		frame.getContentPane().setBackground(Color.BLACK); //Sets the background of this frame to black
		frame.addComponentListener(new ComponentAdapter () { //Adds a ComponentAdapter to act as ComponentListener for this frame
			public void componentResized(ComponentEvent e) { //Creates a method to respond when the frame window is resized
				Object source = e.getComponent(); //Registers the source of the event 
				if (source == frame) { //Checks if this source is the frame
					height = fireworks.getHeight(); //Sets the variable height equal to the firework panel's height
					width = fireworks.getWidth(); //Sets the variable width equal to the firework panel's width
					positionLabel.setText("Enter position from 0 to " + width + ":"); //Updates the position label to reflect the increase or decrease in available size
					if ((height != lastHeight) | (width != lastWidth)) { //If the width and the height are not the same before and after it was resized
						fireworks.paintAll(); //Repaint all the fireworks
						lastHeight = height; //Sets the height before resizing equal to the current height
						lastWidth = width; //Sets the width before resizing equal to the current width
					}
				}
			}
		});
		fireworks = new FireworkPanel(); //Creates a new FireworkPanel object to display the path and explosion of the firework
		frame.add(fireworks, BorderLayout.CENTER); //Adds it to the center of the frame
		
		
		frame.setPreferredSize(new Dimension(700,500)); //Sets the frame's preferred size to 700 by 500 pixels
		frame.pack(); //Packs the frame to its preferred size
		
		
		JButton launch = new JButton("Launch!"); //Creates a new button to launch the fireworks, displaying their route and explosion
		launch.setActionCommand("Go"); //Sets the accessible ActionCommand for this object's pressing to "Go"
		launch.setBackground(Color.GRAY); //Sets the background of this button to gray
		launch.setForeground(Color.BLACK); //Sets the foreground, e.g. the text, of this button to black
		launch.setFocusPainted(false); //Makes sure the button is not painted when focused
		launch.setBorderPainted(false); //Makes sure the the button's border is not painted
		launch.addActionListener(fireworks); //Gives this button a FireworkPanel object as its ActionListener
		frame.add(launch, BorderLayout.NORTH); //Adds this button to the frame at its top
		
		
		JPanel subpanel = new JPanel(); //Creates a new subpanel to hold the numerical launch parameters
		subpanel.setLayout(new BoxLayout(subpanel, BoxLayout.Y_AXIS)); //Sets the layout of this subpanel to BoxLayout, aligned along the Y axis of the subpanel
		JPanel subsubpanel1 = new JPanel(new BorderLayout()); //Creates a new subpanel of the subpanel to hold the velocity text field and its label
		JPanel subsubpanel2 = new JPanel(new BorderLayout()); //Creates a new subpanel of the subpanel to hold the angle text field and its label
		JPanel subsubpanel3 = new JPanel(new BorderLayout()); //Creates a new subpanel of the subpanel to hold the position text field and its label
		JPanel subsubpanel4 = new JPanel(new BorderLayout()); //Creates a new subpanel of the subpanel to hold the time text field and its label
		
		JLabel velocityLabel = new JLabel("Enter velocity in meters per second: "); //Creates the label for the velocity text field, instructing the user on what to enter into it
		velocityLabel.setForeground(Color.BLACK); //Sets the foregroud color, e.g. the color of the text, to BLACK
		velocity = new JTextField("0", 20); //Creates a new text field to hold the user's velocity input with initial input zero
		velocity.getDocument().addDocumentListener(new DocumentListener() { //Adds a new Document Listener to this text field to tell when it is changed; the class that details what happens when it is changed is added as an inner class
			public void removeUpdate (DocumentEvent e) { //If any part of the text field is removed
				isCurrent().setVelocity(velocity.getText()); //Sets the velocity of the firework the user is currently editing to be the remaining text in the text field
			}
			public void insertUpdate(DocumentEvent e) { //If any part of the text field is added
				isCurrent().setVelocity(velocity.getText()); //Sets the velocity of the firework the user is currently editing to be the text in the text field
			}
			public void changedUpdate(DocumentEvent e) { //If any attributes of the text field are changed
				isCurrent().setVelocity(velocity.getText()); //Sets the velocity of the firework the user is currently editing to be the text in the text field
			}
		});
		subsubpanel1.add(velocityLabel, BorderLayout.WEST); //Adds the label to the velocity field in the left of the first sub-subpanel
		subsubpanel1.add(velocity, BorderLayout.EAST); //Adds the text field in the right of the first sub-subpanel
		subpanel.add(subsubpanel1); //Adds the first sub-subpanel to the subpanel
		subsubpanel1.setBackground(Color.GRAY); //Sets the background of the first sub-subpanel to gray
		
		
		JLabel angleLabel = new JLabel("Enter angle in degrees: "); //Creates the label for the angle text field, instructing the user on what to enter into it
		angleLabel.setForeground(Color.BLACK); //Sets the foregroud color, e.g. the color of the text, to BLACK
		angle = new JTextField("0", 20); //Creates a new text field to hold the user's angle input with initial input zero
		angle.getDocument().addDocumentListener(new DocumentListener() { //Adds a new Document Listener to this text field to tell when it is changed; the class that details what happens when it is changed is added as an inner class
			public void removeUpdate (DocumentEvent e) { //If any part of the text field is removed
				isCurrent().setAngle(angle.getText()); //Sets the angle of the firework the user is currently editing to be the remaining text in the text field
			}
			public void insertUpdate(DocumentEvent e) { //If any part of the text field is added
				isCurrent().setAngle(angle.getText()); //Sets the angle of the firework the user is currently editing to be the text in the text field
			}
			public void changedUpdate(DocumentEvent e) { //If any attributes of the text field are changed
				isCurrent().setAngle(angle.getText()); //Sets the angle of the firework the user is currently editing to be the text in the text field
			}
		});
		
		subsubpanel2.add(angleLabel, BorderLayout.WEST); //Adds the label to the angle field in the left of the second sub-subpanel
		subsubpanel2.add(angle, BorderLayout.EAST); //Adds the text field in the right of the second sub-subpanel
		subpanel.add(subsubpanel2); //Adds the second sub-subpanel to the subpanel
		subsubpanel2.setBackground(Color.GRAY); //Sets the background of the second sub-subpanel to gray
		
		positionLabel = new JLabel("Enter position from 0 to " + getPanelWidth() + ":"); //Creates the label for the position text field, instructing the user on what to enter into it 
		positionLabel.setForeground(Color.BLACK); //Sets the foregroud color, e.g. the color of the text, to BLACK
		position = new JTextField("0", 20); //Creates a new text field to hold the user's position input with initial input zero
		position.getDocument().addDocumentListener(new DocumentListener() { //Adds a new Document Listener to this text field to tell when it is changed; the class that details what happens when it is changed is added as an inner class
			public void removeUpdate (DocumentEvent e) { //If any part of the text field is removed
				isCurrent().setPosition(position.getText()); //Sets the position of the firework the user is currently editing to be the remaining text in the text field
			}
			public void insertUpdate(DocumentEvent e) { //If any part of the text field is added
				isCurrent().setPosition(position.getText()); //Sets the position of the firework the user is currently editing to be the remaining text in the text field
			}
			public void changedUpdate(DocumentEvent e) { //If any attributes of the text field are changed
				isCurrent().setPosition(position.getText()); //Sets the position of the firework the user is currently editing to be the remaining text in the text field
			}
		});
		
		subsubpanel3.add(positionLabel, BorderLayout.WEST); //Adds the label to the position field in the left of the third sub-subpanel
		subsubpanel3.add(position, BorderLayout.EAST); //Adds the text field in the right of the third sub-subpanel
		subpanel.add(subsubpanel3); //Adds the third sub-subpanel to the subpanel
		subsubpanel3.setBackground(Color.GRAY); //Sets the background of the third sub-subpanel to gray
		
		JLabel timeLabel = new JLabel("Set the timer for when the firework should explode: "); //Creates the label for the time text field, instructing the user on what to enter into it 
		timeLabel.setForeground(Color.BLACK); //Sets the foregroud color, e.g. the color of the text, to BLACK
		time = new JTextField("0", 15); //Creates a new text field to hold the user's time input with initial input zero
		time.getDocument().addDocumentListener(new DocumentListener() { //Adds a new Document Listener to this text field to tell when it is changed; the class that details what happens when it is changed is added as an inner class
			public void removeUpdate (DocumentEvent e) { //If any part of the text field is removed
				isCurrent().setTime(time.getText()); //Sets the time of the firework's explosion the user is currently editing to be the remaining text in the text field
			}
			public void insertUpdate(DocumentEvent e) { //If any part of the text field is added
				isCurrent().setTime(time.getText()); //Sets the time of the firework's explosion the user is currently editing to be the remaining text in the text field
			}
			public void changedUpdate(DocumentEvent e) { //If any of the text's attributes are changed
				isCurrent().setTime(time.getText()); //Sets the time of the firework's explosion the user is currently editing to be the remaining text in the text field
			}
		});
		
		subsubpanel4.add(timeLabel, BorderLayout.WEST); //Adds the label to the position field in the left of the fourth sub-subpanel
		subsubpanel4.add(time, BorderLayout.EAST); //Adds the text field in the right of the fourth sub-subpanel
		subpanel.add(subsubpanel4); //Adds the fourth sub-subpanel to the subpanel
		subsubpanel4.setBackground(Color.GRAY); //Sets the background of the fourth sub-subpanel to gray
		
		frame.add(subpanel, BorderLayout.SOUTH); //Adds the subpanel to the bottom of the frame
		
		JPanel subpanel2 = new JPanel(); //Creates a new subpanel to hold the fireworks the user can edit
		subpanel2.setBackground(Color.LIGHT_GRAY); //Sets the background of this subpanel to gray
		subpanel2.setLayout(new BoxLayout(subpanel2, BoxLayout.Y_AXIS)); //Sets the layout of this subpanel to a BoxLayout aligned along the Y axis
		
		JLabel fireworkChoice = new JLabel("Select a Firework"); //Creates a new label instructing the user to pick which firework they're editing
		fireworkChoice.setForeground(Color.BLACK); //Sets the foreground color (e.g., the color of the text) to black
		subpanel2.add(fireworkChoice); //Adds this label to the top of the second subpanel
		
		firework1 = new JCheckBox("Firework 1", false); //Creates a new check box labelled "Firework 1", representing whether the user is editing that firework, and sets it unchecked
		firework1.addItemListener(this); //Adds this class to the checkbox as its listener, activating whether it is checked or unchecked
		firework1.setForeground(Color.BLACK); //Sets the foreground color (e.g., the color of text) to black
		firework1.setBackground(Color.LIGHT_GRAY); //Sets the background color of the check box to light gray
		subpanel2.add(firework1); //Adds this check box to the second subpanel
		
		firework2 = new JCheckBox("Firework 2", false); //Creates a new check box labelled "Firework 2", representing whether the user is editing that firework, and sets it unchecked
		firework2.addItemListener(this); //Adds this class to the checkbox as its listener, activating whether it is checked or unchecked
		firework2.setForeground(Color.BLACK); //Sets the foreground color (e.g., the color of the text) to black 
		firework2.setBackground(Color.LIGHT_GRAY); //Sets the background color of the check box to light gray
		subpanel2.add(firework2); //Adds this check box to the second subpanel
		
		firework3 = new JCheckBox("Firework 3", false); //Creates a new check box labelled "Firework 3", representing whether the user is editing that firework, and sets it unchecked
		firework3.addItemListener(this); //Adds this class to the checkbox as its listener, activating whether it is checked or unchecked
		firework3.setForeground(Color.BLACK); //Sets the foreground color (e.g., the color of text) to black
		firework3.setBackground(Color.LIGHT_GRAY); //Sets the background color of the check box to light gray
		subpanel2.add(firework3); //Adds this check box to the second subpanel
		
		firework4 = new JCheckBox("Firework 4", false); //Creates a new check box labelled "Firework 4", representing whether the user is editing that firework, and sets it unchecked
		firework4.addItemListener(this); //Adds this class to the checkbox as its listener, activating whether it is checked or unchecked
		firework4.setForeground(Color.BLACK); //Sets the foreground color (e.g., the color of the text) to black
		firework4.setBackground(Color.LIGHT_GRAY); //Sets the background color of the check box to light gray
		subpanel2.add(firework4); //Adds this check box to the second subpanel
		
		firework5 = new JCheckBox("Firework 5", false); //Creates a new check box labelled "Firework 5", representing whether the user is editing that firework, and sets it unchecked
		firework5.addItemListener(this); //Adds this class to the checkbox as its listener, activating whether it is checked or unchecked 
		firework5.setForeground(Color.BLACK); //Sets the foreground color (e.g., the color of text) to black
		firework5.setBackground(Color.LIGHT_GRAY); //Sets the background color of the check box to light gray
		subpanel2.add(firework5); //Adds this check box to the second subpanel
		
		frame.add(subpanel2, BorderLayout.EAST); //Adds this second subpanel to the frame in the right 
		
		JPanel subpanel3 = new JPanel(); //Creates a new subpanel to hold the colors and type of the current firework
		subpanel3.setLayout(new BoxLayout(subpanel3, BoxLayout.Y_AXIS)); //Sets the layout of this subpanel to be managed by a BoxLayout manager oriented along the Y axis
		subpanel3.setBackground(Color.LIGHT_GRAY); //Sets the background color of this third subpanel to gray
		frame.add(subpanel3, BorderLayout.WEST); //Adds this third subpanel to the frame at its left
		
		JPanel subsubpanel31 = new JPanel(); //Creates a new sub-subpanel to hold the color choices of the current firework
		subsubpanel31.setLayout(new BoxLayout(subsubpanel31, BoxLayout.Y_AXIS)); //Sets the layout of this sub-subpanel to be managed by BoxLayout manager oriented along the Y axis
		subsubpanel31.setBackground(Color.LIGHT_GRAY); //Sets the background color of this sub-subpanel to gray
		subpanel3.add(subsubpanel31); //Adds this sub-subpanel to the third subpanel
		
		JLabel selectColor = new JLabel("Select color: "); //Creates a new label instructing the user to select a color for the firework
		selectColor.setForeground(Color.BLACK); //Sets the foreground color, e.g. the color of the text to black
		subsubpanel31.add(selectColor); //Adds the label to the created sub-subpanel
		
		fireworkColor1 = new JCheckBox("Red", false); //Creates a new check box to represent whether the firework is red or not, initializing it as unchecked
		fireworkColor1.addItemListener(this); //Adds this class to the checkbox as its listener, activating whether it is checked or not
		fireworkColor1.setForeground(Color.RED); //Sets the foreground color, e.g. the color of the text to red
		fireworkColor1.setBackground(Color.LIGHT_GRAY); //Sets the background color of the checkbox to gray
		subsubpanel31.add(fireworkColor1); //Adds the checkbox to the created sub-subpanel
		
		fireworkColor2 = new JCheckBox("Orange", false); //Creates a new check box to represent whether the firework is orange or not, initializing it as unchecked
		fireworkColor2.addItemListener(this); //Adds this class to the checkbox as its listener, activating whether it is checked or not
		fireworkColor2.setForeground(Color.ORANGE); //Sets the foreground color, e.g. the color of the text to orange
		fireworkColor2.setBackground(Color.LIGHT_GRAY); //Sets the background color of the checkbox to gray
		subsubpanel31.add(fireworkColor2); //Adds the checkbox to the created sub-subpanel
		
		fireworkColor3 = new JCheckBox("Yellow", false); //Creates a new check box to represent whether the firework is yellow or not, initializing it as unchecked
		fireworkColor3.addItemListener(this); //Adds this class to the checkbox as its listener, activating whether it is checked or not
		fireworkColor3.setForeground(Color.YELLOW); //Sets the foreground color, e.g. the color of the text to YELLOW
		fireworkColor3.setBackground(Color.LIGHT_GRAY); //Sets the background color of the checkbox to gray
		subsubpanel31.add(fireworkColor3); //Adds the checkbox to the created sub-subpanel
		
		fireworkColor4 = new JCheckBox("Green", false); //Creates a new check box to represent whether the firework is green or not, initializing it as unchecked
		fireworkColor4.addItemListener(this); //Adds this class to the checkbox as its listener, activating whether it is checked or not
		fireworkColor4.setForeground(Color.GREEN); //Sets the foreground color, e.g. the color of the text to GREEN
		fireworkColor4.setBackground(Color.LIGHT_GRAY); //Sets the background color of the checkbox to gray
		subsubpanel31.add(fireworkColor4); //Adds the checkbox to the created sub-subpanel
		
		fireworkColor5 = new JCheckBox("Blue", false); //Creates a new check box to represent whether the firework is blue or not, initializing it as unchecked
		fireworkColor5.addItemListener(this); //Adds this class to the checkbox as its listener, activating whether it is checked or not
		fireworkColor5.setForeground(Color.BLUE); //Sets the foreground color, e.g. the color of the text to blue
		fireworkColor5.setBackground(Color.LIGHT_GRAY); //Sets the background color of the checkbox to gray
		subsubpanel31.add(fireworkColor5); //Adds the checkbox to the created sub-subpanel
		
		JPanel subsubpanel32 = new JPanel(); //Creates a new sub-subpanel to hold the type choices of the current firework
		subsubpanel32.setLayout(new BoxLayout(subsubpanel32, BoxLayout.Y_AXIS)); //Sets the layout of this sub-subpanel to be managed by BoxLayout manager oriented along the Y axis
		subsubpanel32.setBackground(Color.LIGHT_GRAY); //Sets the background color of this sub-subpanel to gray
		subpanel3.add(subsubpanel32); //Adds this sub-subpanel to the third subpanel
		
		JLabel selectType = new JLabel("Select firework type: "); //Creates a new label instructing the user to select a type for the firework
		selectColor.setForeground(Color.BLACK); //Sets the foreground color, e.g. the color of the text to black
		subsubpanel32.add(selectType); //Adds the label to the created sub-subpanel
		
		type1 = new JCheckBox("Jackson Pollock", false); //Creates a new check box to represent whether the firework is a Jackson Pollock explosion or not, initializing it as unchecked
		type1.addItemListener(this); //Adds this class to the checkbox as its listener, activating whether it is checked or not
		type1.setBackground(Color.LIGHT_GRAY); //Sets the background color of the check box to light gray
		subsubpanel32.add(type1); //Adds the checkbox to the created sub-subpanel
		
		type2 = new JCheckBox("Solar Plunge", false); //Creates a new check box to represent whether the firework is a Solar Plunge explosion or not, initializing it as unchecked
		type2.addItemListener(this); //Adds this class to the checkbox as its listener, activating whether it is checked or not
		type2.setBackground(Color.LIGHT_GRAY); //Sets the background color of the check box to light gray
		subsubpanel32.add(type2); //Adds the checkbox to the created sub-subpanel
		
		type3 = new JCheckBox("Bull's Eye", false); //Creates a new check box to represent whether the firework is a Bull's Eye explosion or not, initializing it as unchecked
		type3.addItemListener(this); //Adds this class to the checkbox as its listener, activating whether it is checked or not
		type3.setBackground(Color.LIGHT_GRAY); //Sets the background color of the check box to light gray
		subsubpanel32.add(type3); //Adds the checkbox to the created sub-subpanel
		
		type4 = new JCheckBox("Signal", false); //Creates a new check box to represent whether the firework is a Signal explosion or not, initializing it as unchecked
		type4.addItemListener(this); //Adds this class to the checkbox as its listener, activating whether it is checked or not
		type4.setBackground(Color.LIGHT_GRAY); //Sets the background color of the check box to light gray
		subsubpanel32.add(type4); //Adds the checkbox to the created sub-subpanel
		
		type5 = new JCheckBox("Circling Chaos", false); //Creates a new check box to represent whether the firework is a Circling Chaos explosion or not, initializing it as unchecked
		type5.addItemListener(this); //Adds this class to the checkbox as its listener, activating whether it is checked or not
		type5.setBackground(Color.LIGHT_GRAY); //Sets the background color of the check box to gray
		subsubpanel32.add(type5); //Adds the checkbox to the created sub-subpanel
		
		
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Sets the default operation of the window to disappearing and finishing the program's running 
		frame.setVisible(true); //Sets the window to visible
		
	}
	public static String getVelocity() { //Creates a method for the user to get the velocity of the firework currently being edited
		return isCurrent().getFVelocity();
	}
	public static String getAngle() { //Creates a method for the user to get the angle of the firework currently being edited
		return isCurrent().getFAngle();
	}
	public static String getPosition() { //Creates a method for the user to get the position of the firework currently being edited
		return isCurrent().getFPosition(); 
	}
	public static String getTime() { //Creates a method for the user to get the time of the launch of the firework currently being edited
		return isCurrent().getFTime();
	}
	public static double getPanelWidth() { //Creates a method for the user to get the width of the panel upon which the fireworks are illustrated
		return width;
	}
	public static double getPanelHeight() { //Creates a method for the user to get the height of the panel upon which the fireworks are illustrated
		return height;
	}
	public static String getFireworkType() { //Creates a method for the user to get the type of the firework currently being edited
		return isCurrent().getFType();
	}
	public static String getFireworkColor() { //Creates a method for the user to get the color of the firework currently being edited
		return isCurrent().getFColor();
	}
	@Override //Overrides the ItemListener interface
	public void itemStateChanged (ItemEvent e) { //Creates a method which responds whenever an ItemEvent occurred (e.g., a checkbox is checked or unchecked)
		Object command = e.getSource(); //Gets the source of the ItemEvent that occurred and sets it equal to the variable command
		if ((command == type1) | (command == type2) | (command == type3) | (command == type4) | (command == type5)) { //Checks if the source was one of the checkboxes determining type
			if ((command == type1) & (type1.isSelected() == true)) { //Checks if the source was the check box for the first explosion and whether it was selected
				type = "Jackson Pollock"; //Sets the current type of explosion equal to Jackson Pollock
				isCurrent().setType(type); //Sets the type of explosion within the current firework to the current type
				assureCurrentType(type); //Sets the check boxes representing all the other types to unchecked and the check box representing this type to checked
			}
			else if ((command == type2) & (type2.isSelected() == true)){ //Checks if the source was the check box for the second explosion and whether it was selected
				type = "Solar Plunge"; //Sets the current type of explosion equal to Solar Plunge
				isCurrent().setType(type); //Sets the type of explosion within the current firework to the current type
				assureCurrentType(type); //Sets the check boxes representing all the other types to unchecked and the check box representing this type to checked
			}
			else if ((command == type3) & (type3.isSelected() == true) ) { //Checks if the source was the check box for the third explosion and whether it was selected
				type = "Bull's Eye"; //Sets the current type of explosion equal to Bull's Eye
				isCurrent().setType(type); //Sets the type of explosion within the current firework to the current type
				assureCurrentType(type); //Sets the check boxes representing all the other types to unchecked and the check box representing this type to checked
			}
			else if ((command == type4) & (type4.isSelected() == true ) ) { //Checks if the source was the check box for the fourth explosion and whether it was selected
				type = "Signal"; //Sets the current type of explosion equal to Signal
				isCurrent().setType(type); //Sets the type of explosion within the current firework to the current type
				assureCurrentType(type); //Sets the check boxes representing all the other types to unchecked and the check box representing this type to checked
			}
			else if ((command == type5) & (type5.isSelected() == true) ) { //Checks if the source was the check box for the fifth explosion and whether it was selected
				type = "Circles"; //Sets the current type of explosion equal to Circles
				isCurrent().setType(type); //Sets the type of explosion within the current firework to the current type
				assureCurrentType(type); //Sets the check boxes representing all the other types to unchecked and the check box representing this type to checked
			}
		}
		else if ((command == fireworkColor1) | (command == fireworkColor2) | (command == fireworkColor3) | (command == fireworkColor4) | (command == fireworkColor5)) { //Checks if the source was one of the checkboxes determining color
			if ((command == fireworkColor1) & (fireworkColor1.isSelected() == true)) { //Checks if the source was the check box for the first color and whether it was selected
				aColor = "RED"; //Sets the current type of color equal to red
				isCurrent().setColor(aColor); //Sets the type of color within the current firework to the current type
				assureCurrentColor(aColor); //Sets the check boxes representing all the other colors to unchecked and the check box representing this color to checked
			}
			else if ((command == fireworkColor2) & (fireworkColor2.isSelected() == true)) { //Checks if the source was the check box for the second color and whether it was selected
				aColor = "ORANGE"; //Sets the current type of color equal to orange
				isCurrent().setColor(aColor); //Sets the type of color within the current firework to the current type
				assureCurrentColor(aColor); //Sets the check boxes representing all the other colors to unchecked and the check box representing this color to checked
			}
			else if ((command == fireworkColor3) & (fireworkColor3.isSelected() == true)) { //Checks if the source was the check box for the third color and whether it was selected
				aColor = "YELLOW"; //Sets the current type of color equal to yellow
				isCurrent().setColor(aColor); //Sets the type of color within the current firework to the current type
				assureCurrentColor(aColor); //Sets the check boxes representing all the other colors to unchecked and the check box representing this color to checked
			}
			else if ((command == fireworkColor4) & (fireworkColor4.isSelected() == true)) { //Checks if the source was the check box for the fourth color and whether it was selected
				aColor = "GREEN"; //Sets the current type of color equal to green
				isCurrent().setColor(aColor); //Sets the type of color within the current firework to the current type
				assureCurrentColor(aColor); //Sets the check boxes representing all the other colors to unchecked and the check box representing this color to checked
			}
			else if ((command == fireworkColor5) & (fireworkColor5.isSelected() == true) ) { //Checks if the source was the check box for the fifth color and whether it was selected
				aColor = "BLUE"; //Sets the current type of color equal to blue
				isCurrent().setColor(aColor); //Sets the type of color within the current firework to the current type
				assureCurrentColor(aColor); //Sets the check boxes representing all the other colors to unchecked and the check box representing this color to checked
			}
		}
		else { //If the ItemEvent did not originate from the type or color check boxes (i.e., it originated from the firework check boxes)
			if ((command == firework1) & (firework1.isSelected() == true)) { //Checks if the source was the check box for the first firework and whether it was selected
				currentFirework = fObject1; //Set the firework currently being edited to the first firework
				firework2.setSelected(false); //Sets the second check box to unselected
				firework3.setSelected(false); //Sets the third check box to unselected
				firework4.setSelected(false); //Sets the fourth check box to unselected
				firework5.setSelected(false); //Sets the fifth check box to unselected
				velocity.setText(fObject1.getFVelocity()); //Sets the text of the velocity text field equal to current velocity stored in the first firework object
				angle.setText(fObject1.getFAngle()); //Sets the text of the angle text field equal to current angle stored in the first firework object
				position.setText(fObject1.getFPosition()); //Sets the text of the position text field equal to current position stored in the first firework object
				time.setText(fObject1.getFTime()); //Sets the text of the time text field equal to current time stored in the first firework object
				assureCurrentType(fObject1.getFType()); //Sets the check boxes representing all the other types besides the one of this firework to unchecked and the check box representing this type to checked
				assureCurrentColor(fObject1.getFColor()); //Sets the check boxes representing all the other colors besides the one of this firework to unchecked and the check box representing this color to checked
			}
			else if ((command == firework2) & (firework2.isSelected() == true)) { //Checks if the source was the check box for the second firework and whether it was selected
				currentFirework = fObject2; //Set the firework currently being edited to the second firework
				firework1.setSelected(false); //Sets the first check box to unselected
				firework3.setSelected(false); //Sets the third check box to unselected
				firework4.setSelected(false); //Sets the fourth check box to unselected
				firework5.setSelected(false); //Sets the fifth check box to unselected
				velocity.setText(fObject2.getFVelocity()); //Sets the text of the velocity text field equal to current velocity stored in the second firework object
				angle.setText(fObject2.getFAngle()); //Sets the text of the angle text field equal to current angle stored in the second firework object
				position.setText(fObject2.getFPosition()); //Sets the text of the position text field equal to current position stored in the second firework object
				time.setText(fObject2.getFTime()); //Sets the text of the time text field equal to current time stored in the second firework object
				assureCurrentType(fObject2.getFType()); //Sets the check boxes representing all the other types besides the one of this firework to unchecked and the check box representing this type to checked
				assureCurrentColor(fObject2.getFColor()); //Sets the check boxes representing all the other colors besides the one of this firework to unchecked and the check box representing this color to checked
			}
			else if ((command == firework3) & (firework3.isSelected() == true)) { //Checks if the source was the check box for the third firework and whether it was selected
				currentFirework = fObject3; //Set the firework currently being edited to the third firework
				firework2.setSelected(false); //Sets the second check box to unselected
				firework1.setSelected(false); //Sets the first check box to unselected
				firework4.setSelected(false); //Sets the third check box to unselected
				firework5.setSelected(false); //Sets the fourth check box to unselected
				velocity.setText(fObject3.getFVelocity()); //Sets the text of the velocity text field equal to current velocity stored in the third firework object
				angle.setText(fObject3.getFAngle()); //Sets the text of the angle text field equal to current angle stored in the third firework object
				position.setText(fObject3.getFPosition()); //Sets the text of the position text field equal to current position stored in the third firework object
				time.setText(fObject3.getFTime()); //Sets the text of the time text field equal to current time stored in the third firework object
				assureCurrentType(fObject3.getFType()); //Sets the check boxes representing all the other types besides the one of this firework to unchecked and the check box representing this type to checked
				assureCurrentColor(fObject3.getFColor()); //Sets the check boxes representing all the other colors besides the one of this firework to unchecked and the check box representing this color to checked
				}
			else if ((command == firework4) & (firework4.isSelected() == true)) { //Checks if the source was the check box for the fourth firework and whether it was selected
				currentFirework = fObject4; //Set the firework currently being edited to the fourth firework
				firework2.setSelected(false); //Sets the second check box to unselected
				firework3.setSelected(false); //Sets the third check box to unselected
				firework1.setSelected(false); //Sets the fourth check box to unselected
				firework5.setSelected(false); //Sets the fifth check box to unselected
				velocity.setText(fObject4.getFVelocity()); //Sets the text of the velocity text field equal to current velocity stored in the fourth firework object
				angle.setText(fObject4.getFAngle()); //Sets the text of the angle text field equal to current angle stored in the fourth firework object
				position.setText(fObject4.getFPosition()); //Sets the text of the position text field equal to current position stored in the fourth firework object
				time.setText(fObject4.getFTime()); //Sets the text of the time text field equal to current time stored in the fourth firework object
				assureCurrentType(fObject4.getFType()); //Sets the check boxes representing all the other types besides the one of this firework to unchecked and the check box representing this type to checked
				assureCurrentColor(fObject4.getFColor()); //Sets the check boxes representing all the other colors besides the one of this firework to unchecked and the check box representing this color to checked
			}
			else if ((command == firework5) & (firework5.isSelected() == true)) { //Checks if the source was the check box for the fifth firework and whether it was selected
				currentFirework = fObject5; //Set the firework currently being edited to the fifth firework
				firework2.setSelected(false); //Sets the second check box to unselected
				firework3.setSelected(false); //Sets the third check box to unselected
				firework4.setSelected(false); //Sets the fourth check box to unselected
				firework1.setSelected(false); //Sets the fifth check box to unselected
				velocity.setText(fObject5.getFVelocity()); //Sets the text of the velocity text field equal to current velocity stored in the fifth firework object
				angle.setText(fObject5.getFAngle()); //Sets the text of the angle text field equal to current angle stored in the fifth firework object
				position.setText(fObject5.getFPosition()); //Sets the text of the position text field equal to current position stored in the fifth firework object
				time.setText(fObject5.getFTime()); //Sets the text of the time text field equal to current time stored in the fifth firework object
				assureCurrentType(fObject5.getFType()); //Sets the check boxes representing all the other types besides the one of this firework to unchecked and the check box representing this type to checked
				assureCurrentColor(fObject5.getFColor()); //Sets the check boxes representing all the other colors besides the one of this firework to unchecked and the check box representing this color to checked
			}
		}
		
		
		
	}
	public static Firework isCurrent() { //Creates a method that returns the firework the user is currently editing
		if (currentFirework == fObject1) { //Checks if the current firework being edited is equal to the firework object representing the first firework
			return fObject1;
		}
		else if (currentFirework == fObject2) { //Checks if the current firework being edited is equal to the firework object representing the second firework
			return fObject2;
		}
		else if (currentFirework == fObject3) { //Checks if the current firework being edited is equal to the firework object representing the third firework
			return fObject3;
		}
		else if (currentFirework == fObject4) { //Checks if the current firework being edited is equal to the firework object representing the fourth firework
			return fObject4;
		}
		else if (currentFirework == fObject5) { //Checks if the current firework being edited is equal to the firework object representing the fifth firework
			
			return fObject5;
		}
		else { //If it is not equal to any of these
			return currentFirework;
		}
	}
	public static void setCurrent(int num) { //Creates a method for the user to set the firework they are currently editing equal to one of the five possible fireworks to edit, represented by integer input from 1 to 5
		if (num == 1) { //If the input is equal to one
			currentFirework = fObject1; //Sets the current firework equal to the first firework object
		}
		else if (num ==2 ) { //If the input is equal to two
			currentFirework = fObject2; //Sets the current firework equal to the second firework object
		}
		else if (num == 3) { //If the input is equal to three
			currentFirework = fObject3; //Sets the current firework equal to the third firework object
		}
		else if (num == 4) { //If the input is equal to four
			currentFirework = fObject4; //Sets the current firework equal to the fourth firework object
		}
		else if (num ==5) { //If the input is equal to five
			currentFirework = fObject5; //Sets the current firework equal to the fifth firework object
		}
	}
	public static void setCurrent(Firework aCurrent) { //Creates a method for the user to set the firework they are currently editing to an input firework
		currentFirework = aCurrent; //Sets the input firework equal to the first firework object
	}
	public static void assureCurrentType(String type) { //Creates a method to uncheck all boxes besides those of a certain type
		if (type == "Jackson Pollock") { //If the input type is Jackson Pollock, corresponding to the first check box
			type1.setSelected(true); //Set the first type check box to true
			type2.setSelected(false); //Set the second type check box to false
			type3.setSelected(false); //Set the third type check box to false
			type4.setSelected(false); //Set the fourth type check box to false
			type5.setSelected(false); //Set the fifth type check box to false
		}
		else if (type == "Solar Plunge") { //If the input type is Solar Plunge, corresponding to the second check box
			type2.setSelected(true); //Set the second type check box to true
			type1.setSelected(false); //Set the first type check box to false
			type3.setSelected(false); //Set the third type check box to false
			type4.setSelected(false); //Set the fourth type check box to false
			type5.setSelected(false); //Set the fifth type check box to false
		}
		else if (type == "Bull's Eye") { //If the input type is Bull's Eye, corresponding to the third check box
			type3.setSelected(true); //Set the third type check box to true
			type2.setSelected(false); //Set the second type check box to false
			type1.setSelected(false); //Set the third type check box to false
			type4.setSelected(false); //Set the fourth type check box to false
			type5.setSelected(false);//Set the fifth type check box to false
		}
		else if (type == "Signal") {  //If the input type is Signal, corresponding to the fourth check box
			type2.setSelected(false); //Set the second type check box to false
			type3.setSelected(false); //Set the third type check box to false
			type1.setSelected(false); //Set the first type check box to false
			type4.setSelected(true); //Set the fourth type check box to true
			type5.setSelected(false); //Set the fifth type check box to false
		}
		else if (type == "Circles") { //If the input type is Circle, corresponding to the fifth check box
			type2.setSelected(false); //Set the second type check box to false
			type3.setSelected(false); //Set the third type check box to false
			type4.setSelected(false); //Set the fourth type check box to false
			type1.setSelected(false); //Set the first type check box to false
			type5.setSelected(true); //Set the fifth type check box to true
		}
		else { //If the input type is not any of the above, set all the type check boxes to false
			type1.setSelected(false);
			type2.setSelected(false);
			type3.setSelected(false);
			type4.setSelected(false);
			type5.setSelected(false);
		}
	}
	public static void assureCurrentColor(String color) { //Creates a method to uncheck all boxes besides those of a certain color
		if (color == "RED") { //If the input type is RED, corresponding to the first check box
			fireworkColor1.setSelected(true); //Set the first color check box to true
			fireworkColor2.setSelected(false); //Set the second color check box to false
			fireworkColor3.setSelected(false); //Set the third color check box to false
			fireworkColor4.setSelected(false); //Set the fourth color check box to false
			fireworkColor5.setSelected(false); //Set the fifth color check box to false
		}
		else if (color == "ORANGE") { //If the input type is ORANGE, corresponding to the second check box
			fireworkColor2.setSelected(true); //Set the second color check box to true
			fireworkColor1.setSelected(false); //Set the first color check box to false
			fireworkColor3.setSelected(false); //Set the third color check box to false
			fireworkColor4.setSelected(false); //Set the fourth color check box to false
			fireworkColor5.setSelected(false); //Set the fifth color check box to false
		}
		else if (color == "YELLOW") { //If the input type is YELLOW, corresponding to the third check box
			fireworkColor3.setSelected(true); //Set the third color check box to true
			fireworkColor2.setSelected(false); //Set the second color check box to false
			fireworkColor1.setSelected(false); //Set the first color check box to false
			fireworkColor4.setSelected(false); //Set the third color check box to false
			fireworkColor5.setSelected(false); //Set the fourth color check box to false
		}
		else if (color == "GREEN") { //If the input type is GREEB, corresponding to the fourth check box
			fireworkColor4.setSelected(true); //Set the fourth color check box to true
			fireworkColor2.setSelected(false); //Set the second color check box to false
			fireworkColor1.setSelected(false); //Set the third color check box to false
			fireworkColor3.setSelected(false); //Set the fourth color check box to false
			fireworkColor5.setSelected(false); //Set the fifth color check box to false
		}
		else if (color == "BLUE") { //If the input type is BLUE, corresponding to the fifth check box
			fireworkColor5.setSelected(true); //Set the fifth color check box to true
			fireworkColor2.setSelected(false); //Set the second color check box to false
			fireworkColor1.setSelected(false); //Set the third color check box to false
			fireworkColor3.setSelected(false); //Set the fourth color check box to false
			fireworkColor4.setSelected(false); //Set the fifth color check box to false
		}
		else { //If the input type is not any of the above, set all the color check boxes to false
			fireworkColor5.setSelected(false);
			fireworkColor2.setSelected(false);
			fireworkColor1.setSelected(false);
			fireworkColor3.setSelected(false);
			fireworkColor4.setSelected(false);
		}
	}
	public static void main(String [] args) { //Creates a new main method
		FireworkTest fireworkTest = new FireworkTest(); //Creates a new FireworkTest object

	}
}
