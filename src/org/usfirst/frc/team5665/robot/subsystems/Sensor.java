package org.usfirst.frc.team5665.robot.subsystems;

import org.usfirst.frc.team5665.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 *
 */
public class Sensor extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private final Accelerometer accelerometer = RobotMap.sensorAccelerometer;
	private final Gyro gyro = RobotMap.sensorGyro;

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void calibrateGyro() {
		gyro.calibrate();
	}
	public double getAngle() {
		return gyro.getAngle();
	}
	public double getXDisplacement() {
		accelerometer.getX();
		return 1;
	}
	public double getYDisplacement() {
		accelerometer.getY();
		return 1;
	}
	
}
