package org.usfirst.frc.team5665.robot.subsystems;

import org.usfirst.frc.team5665.robot.Robot;
import org.usfirst.frc.team5665.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearHolder extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	private final SpeedController slider = RobotMap.gearHolderSlider;
	private final DigitalInput switchLeft = RobotMap.gearHolderSwitchLeft;
	private final DigitalInput switchRight = RobotMap.gearHolderSwitchRight;
	

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void moveSlider(double rate) {
		if(!switchLeft.get()) rate = 0.5;
		else if(!switchRight.get()) rate = -0.5;
		
		slider.set(rate);
	}
	public void calibrateSlider() {
		slider.set(0.8);
		Timer.delay(0.185);
		if(!switchRight.get()) {
			slider.set(-0.8);
			Timer.delay(0.7);
			slider.set(0.0);
			Robot.calibrateEnabled = false;
		}
	}
}
