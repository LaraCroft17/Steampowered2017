package org.usfirst.frc.team5665.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5665.robot.Robot;

/**
 *
 */
public class SetSensitivity extends Command {
	
	private double sensitivity;
	
	public SetSensitivity(double sensitivity) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drive);
		this.sensitivity = sensitivity;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.drive.setSensitivity(sensitivity);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return true;
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
