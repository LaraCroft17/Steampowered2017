package org.usfirst.frc.team5665.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5665.robot.Robot;
import org.usfirst.frc.team5665.robot.subsystems.Sensor;

/**
 *
 */
public class ArcadeDriveAngle extends Command {
	
	private double xAxis,yAxis;
	private double targetAngle;
	
	public ArcadeDriveAngle(double xAxis, double yAxis, double targetAngle) {
		// Use requires() here to declare subsystem dependencies
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.targetAngle = targetAngle;
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
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		final double curAngle = 0;
		return Math.abs(curAngle-targetAngle)<5;
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
