/*Name: Catherine Giugno
 * NetID: 31326032
 * Assignment Number: Third Project
 * Lab Section: TR 9:40-10:55
 * I did not collaborate with anyone on this assignment.
 */

public class Firework { 
	private String color; //Creates a private string to represent the color of the firework
	private String type; //Creates a private string to represent the type of the firework
	private String velocity; //Creates a private string to represent the velocity of the firework's launch (this will be converted to a double during the FireworkPanel paint methods)
	private String angle; //Creates a private string to represent the angle of the firework's launch (this will be converted to a double during the FireworkPanel paint methods)
	private String position; //Creates a private string to represent the position of the firework's launch (this will be converted to a during the FireworkPanel paint methods)
	private String time; //Creates a private string to represent the time of the firework's launch (this will be converted to a int during the FireworkPanel paint methods)
	public Firework(String color, String type, String velocity, String angle, String position, String time) { //Creates a constructor for a firework which takes color, type, velocity, angle, position, and time as String paremeters
		this.color = color; //Sets the color of this firework equal to the input parameter
		this.type = type; //Sets the type of this firework equal to the input parameter
		this.velocity = velocity; //Sets the velocity of this firework equal to the input parameter
		this.angle = angle; //Sets the angle of this firework equal to the input parameter
		this.position = position; //Sets the position of this firework equal to the input parameter
		this.time = time; //Sets the time of this firework equal to the input parameter
		
	}
	public void setColor(String color) { //Creates a method for the user to choose the color of a firework
		this.color = color; //Sets the color of this firework equal to the input parameter
	}
	public String getFColor() { //Creates a method for the user to access the color of a firework
		return color; //Returns the String color variable
	}
	
	public void setType(String type) { //Creates a method for the user to choose the type of a firework
		this.type = type; //Sets the type of this firework equal to the input parameter
	}
	public String getFType() { //Creates a method for the user to access the type of a firework
		return type; //Returns the String type variable
	}
	public void setVelocity(String velocity) { //Creates a method for the user to choose the velocity of a firework's launch
		this.velocity = velocity; //Sets the velocity of this firework equal to the input parameter
	}
	public String getFVelocity() { //Creates a method for the user to access the velocity of a firework's launch
		return velocity; //Returns the String velocity variable
	}
	public void setAngle(String angle) { //Creates a method for the user to choose the angle of a firework's launch
		this.angle = angle; //Sets the angle of this firework equal to the input parameter
	}
	public String getFAngle() { //Creates a method for the user to access the angle of a firework's launch
		return angle; //Returns the String angle variable
	}
	public void setPosition(String position) { //Creates a method for the user to choose the position of a firework's launch
		this.position = position; //Sets the position of this firework equal to the input parameter
	}
	public String getFPosition() { //Creates a method for the user to access the position of a firework's launch
		return position; //Returns the String position variable
	}
	public void setTime(String time) { //Creates a method for the user to choose the time of a firework's launch
		this.time = time; //Sets the time of this firework equal to the input parameter
	}
	public String getFTime() { //Creates a method for the user to access the time of a firework's launch
		return time; //Returns the String time variable
	}
	@Override
	public String toString() { //Creates a way to represent a firework as a String including its various traits
		return String.format("Firework: %nColor: %s %nType: %s%nVelocity: %s%nAngle: %s%nPosition: %s%nTime: %s%n", getFColor(), getFType(), getFVelocity(), getFAngle(), getFPosition(), getFTime());
		
	}
	
}
