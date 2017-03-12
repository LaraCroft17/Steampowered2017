package org.usfirst.frc.team5665.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5665.robot.Robot;

/**
 *
 */
public class ArcadeDrive extends Command {
	
	private boolean isFinished = false;
	private double xAxis,yAxis,duration;
	
	public ArcadeDrive(double xAxis, double yAxis, double duration) {
		// Use requires() here to declare subsystem dependencies
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.duration = duration;
		requires(Robot.drive);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.drive.arcadeDrive(xAxis, yAxis);
		Timer.delay(duration);
		isFinished = true;
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.drive.arcadeDrive(0,0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
