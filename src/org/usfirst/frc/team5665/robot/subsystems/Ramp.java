package org.usfirst.frc.team5665.robot.subsystems;

import org.usfirst.frc.team5665.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Ramp extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	private final SpeedController motor = RobotMap.rampMotor;
	private final DigitalInput switchTop = RobotMap.rampSwitchTop;
	private final DigitalInput switchBottom = RobotMap.rampSwitchBottom;

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void moveRamp(double rate) {
		if(!switchTop.get() && rate<0) rate = 0.0;
		else if(!switchBottom.get()) rate = -0.5;
		
		motor.set(rate);
	}
}
