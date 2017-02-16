package org.usfirst.frc.team5665.robot.subsystems;

import org.usfirst.frc.team5665.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	private final SpeedController rightRear = RobotMap.driveRightRear;
	private final SpeedController rightFront = RobotMap.driveRightFront;
	private final SpeedController leftRear = RobotMap.driveLeftRear;
	private final SpeedController leftFront = RobotMap.driveLeftFront;
	private final RobotDrive robotDrive4 = RobotMap.driveRobotDrive4;
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		
	}
}
