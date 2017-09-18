#KING TeC 2169 FTC Framework

This framework provides a modular and clean solution to FTC Programming in Java.
This framework contains various systems, but in short, the system is laid out with 4 main
organization components.

#Programming Guide
**Subsystems:** Subsystems are the control schemes for the mechanisms of your robot.  Each
mechanism will have a subsystem attached to it.  For example, if you had a robot with a Tank Drive
and an Arm, you would have two subsystems; and Arm subsytem and a DriveTrain subsystem.  
The subsystem for the Arm would contain the instructions on handling moving it up and down,
and encoder positions.  The methods will be entered as 

`public syncronized void <methodname> (<parameters>)`

To make a new subsystem, copy the empty subsystem and add your own methods and actuators.
For help with what goes where, refer to the SampleSubsystem.

**Controls:**  In order to easily and quickly modify and establish controls, the Controls class 
is for getters and setters of the controllers.  This way, you can easily switch controls and the
subsystems can be programmed to work with multiple modes and using multiple configurations 
that can be easily toggled.

Once inside the pre-configured Controls class, to create a new control, use this format;

_Buttons_

`public boolean <controlName>(){`

`return gamepad<1/2>.<button>; }`

_Sticks_

`public double <controlName>(){`

`return gamepad<1/2>.<stick / axis>; }`


To use these controls in your TeleOp class, make an instance of Controls, and then use, for example;

`telemetry.addData("Stick", controls.forward());`



**AcutatorMap:** The ActuatorMap is intended for storing the names of all actuators and sensors 
in one place for quick and easy changing and debugging.  This step is optional, but will make
configuring the phones and debugging errors at comp much easier.

To use it, create the String within the ActuatorMap class, and then call it when creating the actuator
object within the class.

So within the ActuatorMap, define the motorName like this;
`public static final String liftMotor = "lift";`

and within the Subsystem, create the motor object, 
and then inside the constructor, put this;
`liftMotor = hwMap.dcMotor.get(ActuatorMap.liftMotor);`

Now, whenever you change the name in ActuatorMap, it changes it everywhere that motor is called.

**Constants:**  Constants is pretty self-explanatory; it's a class that works across the entire
programming project to allow you to call the same number and modify it across the entire code structure 
with only a few keystrokes in a single class.  Things you might put in constants include; encoder clicks,
distances, measurements, rotation information, etc.

This system also has a PID class built in as of right now, and OpenCV will be built in soon.