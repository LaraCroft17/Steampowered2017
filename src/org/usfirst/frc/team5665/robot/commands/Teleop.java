package org.usfirst.frc.team5665.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5665.robot.Robot;
import org.usfirst.frc.team5665.robot.RobotMap;

/**
 *
 */
public class Teleop extends Command {
	
	public Teleop() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drive);
		requires(Robot.climber);
		requires(Robot.fuelCollector);
		requires(Robot.gearHolder);
		requires(Robot.ramp);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Joystick j1 = Robot.oi.getJoystick();
		Joystick j2 = Robot.oi.getJoystick2();
		
		//Sensitivity
		if(j1.getRawButton(9)) {
			Robot.drive.setSensitivity(RobotMap.driveMasterAltSensitivity);
		} else if (j2.getRawButton(1) || j1.getRawAxis(3)>0.25) {
			Robot.drive.setSensitivity(RobotMap.driveMasterSpecSensitivity);
		} else {
			Robot.drive.setSensitivity(RobotMap.driveMasterSensitivity);
		}
		
		//Drive, Slider, Ramp
		Robot.drive.arcadeDrive(j1.getRawAxis(0)*((j1.getRawAxis(3)-j1.getRawAxis(2))+1), j1.getRawAxis(1));
		Robot.gearHolder.moveSlider(j1.getRawAxis(4));
		Robot.ramp.moveRamp(j1.getRawAxis(5));
		
		//Slider calibrate
		if(j1.getRawButton(2)) {
			Robot.calibrateEnabled = true;
		}
		if(Robot.calibrateEnabled) {
			Robot.gearHolder.calibrateSlider();
		}
		
		//Climber
		if(j2.getRawAxis(1)<0) {
			Robot.climber.moveClimber(-j2.getRawAxis(1));
		}
		else {
			Robot.climber.moveClimber(0);
		}
		
		//Lift
		if(j1.getRawButton(6)) {
			Robot.fuelCollector.moveLift(1.0);
		} else if (j1.getRawButton(5)) {
			Robot.fuelCollector.moveLift(-1.0);
		} else {
			Robot.fuelCollector.moveLift(0.0);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
