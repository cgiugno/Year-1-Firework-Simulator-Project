Name: Catherine Giugno
Net ID #: 31326032
Assignment Number: Project 3
Lab Section: TR 9:40-10:55
I did not collaborate with anyone on this assignment.

For this project, I created three different classes which work together to make a firework-explosion interface. 
The first of these is a class which defines a Firework object, including all the parameters for its launch and explosion. This Firework object is given a constructor and getters and setters.
The second of these is a class which draws the central panel in my firework-explosion interface, i.e. the one upon which the explosions are painted. This includes a method to paint the trajectory of a firework, drawing on variables defined by the user, five methods to paint five different explosions, a method to paint every firework given some kind of definition by the user, and a method which is performed whenever the launch button is clicked in the interface.
The third of these is a class which structures the user interface and defines the places in which the user must specify input. This contains a frame to hold all of the contents, the launch buttons, groups of checkboxes to determine the firework currently being edited as well as that firework's type and color, and text fields in which the user may enter the parameters of the launch. A method exists to register the user's action when they click one of the check boxes. This action will uncheck all other boxes in this certain check box group and register the input to the firework that is currently being edited. Other methods exist that allow other classes to access user-input variables. Yet more methods exist to facilitate these previously-mentioned processes.

It is necessary to compile all submitted .java files. It is only necessary to run the FireworkTest program to see the firework-explosion interface.

User's Guide
Step 1: Pick a firework by checking one of the boxes to the right of the main display screen.
You may only check one firework at a time. This must be done before entering any variables or checking any colors/types.
Step 2:Enter the preferred color for the explosion.
You may only choose one color for each firework. If a color is not selected, the explosion will be gray.
Step 3: Enter the preferred type for the explosion.
Again, a firework may only have one explosion type. An explosion type, however, must be selected; otherwise, the explosion will not occur.
Step 4: Enter the expected velocity for the firework in meters per second. Your input may be a decimal number. It should, however, not use any letters or spaces.
Step 5: Enter the expected angle for the firework's launch in degrees. Your input may be a decimal number. It should, however, not use any letters or spaces.
Step 6: Enter the expected position for the firework's launch in meters. Your input may be a decimal number from 0 to the specified number in the label beside the input field. It should, however, not use any letters or spaces.
Step 7: Enter the expected time until the firework's explosion in seconds. Your input should be an integer number, not including any letters or spaces.
Step 8: Repeat these steps as needed for other fireworks. You may go back and edit fireworks you have already specified launch variables for.
Step 9: Press the launch button at the top of the screen. After the specified number of seconds, you should see each firework's path and explosion appear on the main display screen.