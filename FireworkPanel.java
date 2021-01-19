/*Name: Catherine Giugno
 * NetID: 31326032
 * Assignment Number: Third Project
 * Lab Section: TR 9:40-10:55
 * I did not collaborate with anyone on this assignment.
 */
import javax.swing.JComponent; //This program will extend Java Swing's JComponent Functions
import javax.swing.Timer; //This program will use Java Swing's Timer functions

import java.awt.Graphics; //This program will use Java AWT's Graphics functions.
import java.awt.Color; //This program will use Java AWT's Color functions.

import java.awt.event.ActionEvent; //This program will use Java AWT's ActionEvent functions.
import java.awt.event.ActionListener; //This program will use Java AWT's ActionListener functions.

import java.security.SecureRandom; //This program will use Java's SecureRandom functions.


public class FireworkPanel extends JComponent implements ActionListener{ 
	private static int thisX; //Creates an integer value accessible by all methods in the class to represent the current x-coordinate of where drawing is taking place
	private static int thisY; //Creates an integer value accessible by all methods in the class to represent the current y-coordinate of where drawing is taking place
	private static Timer[] timers = new Timer[5]; //Creates an array to hold the timers for each possible firework out of five that could go off
	
	public void actionPerformed(ActionEvent e) { //Creates a method to deal with any actions that may be performed; listener for the "Launch!" button
		String source = e.getActionCommand(); //Checks the source of the ActionEvent's ActionCommand and sets it equal to a string variable, source
		if (source.equals("Go")) { //Checks if source is equal to the Launch button's ActionCommand Go
			paintAll();
		}
		
	}
	public void paintJacksonPollock(Graphics g) { 
		SecureRandom random = new SecureRandom(); //Creates a new random number generator called random
		for (int i = 0; i < 25; i++) { //Iterates twenty five times.
			int xCoord = thisX - random.nextInt(15) + random.nextInt(15); //Takes the current drawing position--as this method will always run after a paintSmokePath, guaranteed to be at where the firework goes off-- and generates an x-coordinate anywhere from 15 pixels behind it to fifteen pixels in front of it
			int yCoord = thisY - random.nextInt(15) + random.nextInt(15); //Takes the current drawing position--as this method will always run after a paintSmokePath, guaranteed to be at where the firework goes off-- and generates an y-coordinate anywhere from 15 pixels below it to fifteen pixels above it
			g.drawOval(xCoord, yCoord, 1, 1); //Draws a one pixel point there
			if (i % 2 == 0) { //Every other time the for loop iterates
				g.drawOval(xCoord-10, yCoord-10, 1, 1); //Draw a pixel down 10 pixels and to the lef 10 pixels from it
				g.drawOval(xCoord-10, yCoord + 10, 1, 1); //Draw a pixel up 10 pixels and to the left 10 pixels from it
				g.drawOval(xCoord + 10, yCoord-10, 1, 1); //Draw a pixel down 10 pixels and to the right 10 pixels from it
				g.drawOval(xCoord + 10, yCoord + 10, 1, 1); //Draw a pixel up 10 pixels and to the right 10 pixels from it
			//This ensures that there will be a small cluster of dots and then a larger cluster of dots around them
			} 
		}
	}
	public void paintSolarPlunge (Graphics g) {
		g.drawLine(thisX + 5, thisY + 5, thisX + 10, thisY + 10); //Draws a diagonal line from a bit away from the point of explosion (again, the fact that this is the point of explosion guaranteed by the fact this is always painted after paintSmokePath) to a bit farther away in the upper right direction
		g.drawLine(thisX, thisY + 5, thisX, thisY + 10); //Draws a diagonal line from a bit away from the point of explosion to a bit farther away in the upper direction
		g.drawLine(thisX - 5, thisY + 5, thisX - 10, thisY + 10); //Draws a diagonal line from a bit away from the point of explosion to a bit farther away in the upper left direction
		g.drawLine(thisX - 5, thisY, thisX - 10, thisY); //Draws a diagonal line from a bit away from the point of explosion to a bit farther away in the left direction
		g.drawLine(thisX - 5, thisY - 5, thisX - 10, thisY - 10); //Draws a diagonal line from a bit away from the point of explosion to a bit farther away in the bottom left direction
		g.drawLine(thisX, thisY - 5, thisX, thisY -10); //Draws a diagonal line from a bit away from the point of explosion to a bit farther away in the bottom direction
		g.drawLine(thisX + 5, thisY - 5, thisX + 10, thisY - 10); //Draws a diagonal line from a bit away from the point of explosion to a bit farther away in the bottom right direction
		g.drawLine(thisX + 5, thisY, thisX + 10, thisY); //Draws a diagonal line from a bit away from the point of explosion to a bit farther away in the right direction
	}
	public void paintBullsEye(Graphics g) {
		for (int i = 3; i < 21; i += 3) { //Iterates increasing by three seven times
			g.drawOval(thisX - i, thisY - i, 2 * i, 2 * i); //Draws a circle around what is guaranteed to be the point of explosion by the fact paintSmokePath() is always called first; the radius of this circle is the current value of the iteration
		}
	}
	public void paintWifiSignal(Graphics g) { 
		for (int i = 0; i <= 25; i += 5) { //Iterates increasing by five for five times
			g.drawArc(thisX + i, thisY + i, i, i, 90, 90); //Creates an arc to the upper right of the point of explosion (guaranteed to be the point of explosion as paintSmokePath() is always called before this function) scaled to the current value of the iteration
			g.drawArc(thisX + i, thisY - 2 * i, i , i, 180, 90); //Creates an arc to the upper left of the point of explosion scaled to the current value of the iteration
			g.drawArc(thisX - 2 * i, thisY - 2 * i, i, i, 270, 90); //Creates an arc to the bottom left of the point of explosion scaled to the current value of the iteration
			g.drawArc(thisX - 2 * i, thisY + i, i, i, 360, 90); //Creates an arc to the bottom right of the point of explosion scaled to the current value of the iteration
			
		}
	}
	public void paintCircles(Graphics g) {
		int rad = 10; //Creates a value to represent each circle's radius
		for (int i = -rad; i <= rad; i += rad) { //Iterates from a negative radius to 0 to a positive radius
			for (int j = -rad; j <= rad; j += rad) { //Iterates from a negative radius to 0 to a positive radius
				g.drawOval(thisX + i, thisY + j, rad, rad); //Draws a circle in one of three rows covering the point of the explosion (guaranteed to be the point of explosion by the fact paintSmokePath() is always called before this function)
			}
		}
	}
	
	public void paintSmokePath(Graphics g) {
		double velocity = 0; //Creates a double value to represent the velocity of the firework as it is launched into the sky
		double angleDeg = 0; //Creates a double value to represent the angle of the firework in degrees as it is launched into the sky
		double angleRad = 0; //Creates a double value to represent the angle of the firework in radians as it is launched into the sky
		double position = 0; //Creates a double value to represent the position of the firework as it is launched into the sky
		int time = 0; //Creates a int value to represent the time it will take for the firework to explode
		if ((! FireworkTest.getVelocity().equals("")) & (! FireworkTest.getAngle().equals("")) & (! FireworkTest.getPosition().equals("")) & (! FireworkTest.getTime().equals(""))) { //Checks that each variable does, in fact, have some input value
			velocity = Double.parseDouble(FireworkTest.getVelocity()); //Takes the input velocity value, recorded as a string, from the gui and converts it to a usable double
			angleDeg = Double.parseDouble(FireworkTest.getAngle()); //Takes the input ange value, recorded as a string, from the gui and converts it to a usable double. However, this string represents the angle in degrees which is not usable by the Java cosine function.
			angleRad = (angleDeg * 2 * Math.PI / 360); //Converts the input angle to radians
			position = Double.parseDouble(FireworkTest.getPosition()); //Takes the input position value, recorded as a string, from the gui and converts it to a usable double
			time = Integer.parseInt(FireworkTest.getTime()); //Takes the input time value, recorded as a string, from the gui and converts it to a usable integer
		}
		double gravity = 9.8; //Creates a double representation of the acceleration due to gravity
		g.setColor(Color.GRAY); //Sets the color of the smoke path to gray
		for (int i = 1; i < time; i++) { //Iterates through each second until the explosion time, not including 0--which will be referenced in the body of the loop
			int lastX = (int) ( position + (velocity * Math.cos(angleRad) * (i - 1))); //Gets the x-coordinate position of the firework in the previous second
			int lastY = (int) (FireworkTest.getPanelHeight() -((velocity * Math.sin(angleRad) * (i-1)) - (0.5 * gravity * (i - 1) * (i - 1)))); //Gets the y-coordinate position of the firework in the previous second
			thisX = (int) ( position + (velocity * Math.cos(angleRad) * (i))); //Gets the x-coordinate position of the firework in the current second
			thisY = (int) (FireworkTest.getPanelHeight() -((velocity * Math.sin(angleRad) * (i)) - (0.5 * gravity * (i) * (i)))); //Gets the y-coordinate position of the firework in the current second
			g.drawLine(lastX, lastY, thisX, thisY); //Draws a line from the firework's position in the previous second to its position in the current second, resulting in a path from on position to the next
		}
	}
	protected class TimerCallback implements ActionListener { //Creates an inner class to be used when the timer fires; this class implements the ActionListener
		public void actionPerformed (ActionEvent e) { //Creates a method to be performed when the class detects an ActionEvent
			Object command = e.getSource(); //Checks for the source of the ActionEvent and sets it equal to the variable command
			Graphics g = getGraphics(); //Creates a graphics object called g
			if (command == timers[0]) { //Checks if the object that generated the event was associated with the first timer, corresponding to the first possible firework
				FireworkTest.setCurrent(1); //Sets the current firework equal to this first possible input firework
			}
			else if (command == timers[1]) { //Checks if the object that generated the event was associated with the second timer, corresponding to the second possible firework
				FireworkTest.setCurrent(2); //Sets the current firework equal to this second possible input firework
			}
			else if (command == timers[2]) { //Checks if the object that generated the event was associated with the third timer, corresponding to the third possible firework
				FireworkTest.setCurrent(3); //Sets the current firework equal to this third possible input firework
			}
			else if (command == timers[3]) { //Checks if the object that generated the event was associated with the fourth timer, corresponding to the fourth possible firework
				FireworkTest.setCurrent(4);  //Set the current firework equal to this fourth possible input firework
			}
			else if (command == timers[4]) { //Checks if the object that generated the event was associated with the fifth timer, corresponding to the fifth possible firework
				FireworkTest.setCurrent(5); //Set the current firework equal to this fifth possible input firework
			}
			paintSmokePath(g); //Paints the route of the firework using the paintSmokePath method
			switch (FireworkTest.getFireworkColor()) { //Uses a switch statement to check the current firework's String color
			case "RED" : //If that string color is equal to "RED"
				g.setColor(Color.red); //Set the current color equal to red
				break; //Break out of the switch statement
			case "ORANGE": //If that string color is equal to "ORANGE"
				g.setColor(Color.orange); //Set the current color equal to orange
				break; //Break out of the switch statement
			case "YELLOW": //If that string color is equal to "YELLOW"
				g.setColor(Color.yellow); //Set the current color equal to yellow
				break; //Break out of the switch statement
			case "GREEN": //If that string color is equal to "GREEN"
				g.setColor(Color.green); //Set the current color equal to green
				break; //Break out of the switch statement
			case "BLUE": //If that string color is equal to "BLUE"
				g.setColor(Color.blue); //Set the current color equal to blue
				break; //Break out of the switch statement
			default: //If the string color is equal to none of these
				g.setColor(Color.gray); //Set the current color equal to gray
				break; //Break out of the switch statement
			}
			switch (FireworkTest.getFireworkType()) { //Uses a switch statement to check the current firework's type
			case "Jackson Pollock": //If that string type is equal to "Jackson Pollock"
				paintJacksonPollock(g); //Paint the Pollock firework explosion
				break; //Break out of the switch statement
			case "Solar Plunge": //If that string type is equal to "Solar Plunge"
				paintSolarPlunge(g); //Paint the Solar Plunge firework explosion
				break; //Break out of the switch statement
			case "Bull's Eye": //If that string type is equal to "Bull's Eye"
				paintBullsEye(g); //Paint the Bull's Eye fireworks explosion
				break; //Break out of the switch statement
			case "Signal": //If that string type is equal to "Signal"
				paintWifiSignal(g); //Paint the Signal fireworks explosion
				break; //Break out of the switch statement
			case "Circles": //If that string type is equal to "Circles"
				paintCircles(g); //Paint the Circle fireworks explosion
				break; //Break out of the switch statement
			}
			((Timer) e.getSource()).stop(); //Stop the timer to ensure that this does not paint more more than once per firework
		}
	}
	public void paintAll() { //Creates a method that paints all the fireworks as they are
		Graphics g = getGraphics(); //Creates a graphics object
		g.fillRect(0, 0, (int) FireworkTest.getPanelWidth(), (int) FireworkTest.getPanelHeight()); //Resets the panel's background to black
		Firework isCurrent = FireworkTest.isCurrent(); //Checks which firework is the one currently in use, using the isCurrent() method and sets it equal to a Firework variable isCurrent
		for (int i = 1; i <= 5; i++) { //For each of five possible fireworks that could be initialized for launch
			FireworkTest.setCurrent(i); //Sets this firework to be the current firework using the FireworkTest setCurrent() method
			int time = (Integer.parseInt(FireworkTest.isCurrent().getFTime()) * 1000); //Registers the time that the user input as an integer
			timers[i-1] = new Timer(time, new TimerCallback()); //Creates a timer for this firework which goes off once after every input time passes. This timer makes reference to the TimerCallback class. It is also stored in the timers array at a spot specific to which firework it is referring to.
			timers[i-1].start(); //Starts this timer.
			
		}
		FireworkTest.setCurrent(isCurrent); //After the for loop is done and everything has been drawn, resets the current firework to what it was originally
	}
}

