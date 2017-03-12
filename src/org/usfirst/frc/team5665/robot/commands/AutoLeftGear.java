package org.usfirst.frc.team5665.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team5665.robot.Robot;

/**
 *
 */
public class AutoLeftGear extends CommandGroup {
	public AutoLeftGear() {
		requires(Robot.drive);
		requires(Robot.gearHolder);
		
		double velocity = Robot.velocity;
		double revolution = Robot.revolution;
		
		//Move forward, turn 30 degrees, move into gear position, activate vision
		//Stretch goal: Go back, dump balls (SPECIFICALLY LEFT SIDE), turn 30 reverse, go forward into neutral area
		
		// Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
	}
}
