package org.usfirst.frc.team5665.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the Portber of magic Portbers
 * floating around.
 */
public class RobotMap {
	
	public static int driveRightRearPort = 0;
	public static int driveRightFrontPort = 1;
	public static int driveLeftRearPort = 2;
	public static int driveLeftFrontPort = 3;
	public static int climberMotorPort = 4;
	public static int rampMotorPort = 5;
	public static int fuelCollectorDumperPort = 6;
	public static int gearHolderSliderPort = 7;
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;
	// If you are using multiple modules, make sure to define both the port
	// Portber and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	public static SpeedController driveRightRear;
	public static SpeedController driveRightFront;
	public static SpeedController driveLeftRear;
	public static SpeedController driveLeftFront;
	public static RobotDrive driveRobotDrive4;
	public static SpeedController climberMotor;
	public static SpeedController rampMotor;
	public static SpeedController fuelCollectorDumper;
	public static SpeedController gearHolderSlider;
	
	public static void init() {
		 driveRightRear = new Victor(driveRightRearPort);
		 driveRightFront = new Victor(driveRightFrontPort);
		 driveLeftRear = new Victor(driveLeftRearPort);
		 driveLeftFront = new Victor(driveLeftFrontPort);
		 climberMotor = new Victor(climberMotorPort);
		 rampMotor = new Victor(rampMotorPort);
		 fuelCollectorDumper = new Victor(fuelCollectorDumperPort);
		 gearHolderSlider = new Victor(gearHolderSliderPort);
		 
		 driveRobotDrive4 = new RobotDrive(driveLeftFront, driveLeftRear, driveRightFront, driveRightRear);
		 
		 driveRobotDrive4.setSafetyEnabled(true);
	     driveRobotDrive4.setExpiration(0.1);
	     driveRobotDrive4.setSensitivity(0.5);
	     driveRobotDrive4.setMaxOutput(1.0);
	}
}
