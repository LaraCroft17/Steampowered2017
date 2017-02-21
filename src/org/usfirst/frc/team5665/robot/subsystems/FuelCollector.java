package org.usfirst.frc.team5665.robot.subsystems;

import org.usfirst.frc.team5665.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FuelCollector extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	private final SpeedController lift = RobotMap.fuelCollectorLift;
	private final DigitalInput switchBottom = RobotMap.fuelCollectorSwitchBottom;
	private final DigitalInput switchTop = RobotMap.fuelCollectorSwitchTop;
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void moveLift(double rate) {
		if(!switchTop.get()) rate = -1.0;
		else if(!switchBottom.get()) rate = 1.0;
		
		lift.set(rate);
	}
}
