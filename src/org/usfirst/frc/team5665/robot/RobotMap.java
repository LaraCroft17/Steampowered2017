package org.usfirst.frc.team5665.robot;

import edu.wpi.first.wpilibj.DigitalInput;
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
	
	//Sensitivity constants
	public static double driveTurningSensitivity = 0.6;
	public static double driveMasterSensitivity = 0.55;
	public static double driveMasterAltSensitivity = 0.85;
	public static double driveMasterSpecSensitivity = 0.2;
	
	//Analog ports
	public static int driveRightRearPort = 4;
	public static int driveRightFrontPort = 3;
	public static int driveLeftRearPort = 1;
	public static int driveLeftFrontPort = 2;
	public static int climberMotorPort = 8;
	public static int rampMotorPort = 7;
	public static int fuelCollectorLiftPort = 6;
	public static int gearHolderSliderPort = 5;
	
	//Digital ports
	public static int gearHolderSwitchLeftPort = 5;
	public static int gearHolderSwitchRightPort = 4;
	public static int rampSwitchTopPort = 2;
	public static int rampSwitchBottomPort = 3;
	public static int fuelCollectorSwitchTopPort = 0;
	public static int fuelCollectorSwitchBottomPort = 1;
	
	//Motors
	public static SpeedController driveRightRear;
	public static SpeedController driveRightFront;
	public static SpeedController driveLeftRear;
	public static SpeedController driveLeftFront;
	public static RobotDrive driveRobotDrive4;
	public static SpeedController climberMotor;
	public static SpeedController rampMotor;
	public static SpeedController fuelCollectorLift;
	public static SpeedController gearHolderSlider;
	
	//Switches
	public static DigitalInput gearHolderSwitchLeft;
	public static DigitalInput gearHolderSwitchRight;
	public static DigitalInput rampSwitchTop;
	public static DigitalInput rampSwitchBottom;
	public static DigitalInput fuelCollectorSwitchTop;
	public static DigitalInput fuelCollectorSwitchBottom;
	
	public static void init() {
		 driveRightRear = new Victor(driveRightRearPort);
		 driveRightFront = new Victor(driveRightFrontPort);
		 driveLeftRear = new Victor(driveLeftRearPort);
		 driveLeftFront = new Victor(driveLeftFrontPort);
		 climberMotor = new Victor(climberMotorPort);
		 rampMotor = new Victor(rampMotorPort);
		 fuelCollectorLift = new Victor(fuelCollectorLiftPort);
		 gearHolderSlider = new Victor(gearHolderSliderPort);
		 
		 gearHolderSlider.setInverted(true);
		 
		 driveRobotDrive4 = new RobotDrive(driveLeftFront, driveLeftRear, driveRightFront, driveRightRear);
		 
		 driveRobotDrive4.setSafetyEnabled(false);
	     driveRobotDrive4.setExpiration(0.1);
	     driveRobotDrive4.setSensitivity(driveTurningSensitivity);
	     driveRobotDrive4.setMaxOutput(driveMasterSensitivity);
	     
	     gearHolderSwitchLeft = new DigitalInput(gearHolderSwitchLeftPort);
	     gearHolderSwitchRight = new DigitalInput(gearHolderSwitchRightPort);
	     rampSwitchTop = new DigitalInput(rampSwitchTopPort);
	     rampSwitchBottom = new DigitalInput(rampSwitchBottomPort);
	     fuelCollectorSwitchTop = new DigitalInput(fuelCollectorSwitchTopPort);
	     fuelCollectorSwitchBottom = new DigitalInput(fuelCollectorSwitchBottomPort);
	}
}
