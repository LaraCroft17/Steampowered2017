package org.usfirst.frc.team5665.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team5665.robot.Robot;

/**
 *
 */
public class AutoRightForward extends CommandGroup {
	public AutoRightForward() {
		requires(Robot.drive);
		
		double velocity = Robot.velocity;
		
		addSequential(new ArcadeDrive(0,1,3/velocity));
		addSequential(new ArcadeDrive(0,-1,1/velocity));
		
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
