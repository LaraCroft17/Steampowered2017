package org.usfirst.frc.team5665.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team5665.robot.Robot;
import org.usfirst.frc.team5665.robot.RobotMap;

/**
 *
 */
public class AutoMiddleGear extends CommandGroup {
	public AutoMiddleGear() {
		requires(Robot.drive);
		requires(Robot.gearHolder);
		
		double velocity = Robot.velocity;
		
		addSequential(new SetSensitivity(0.55));
		addSequential(new ArcadeDrive(0,1,2.5/velocity));
		addSequential(new Delay(4));
		addSequential(new ArcadeDrive(0,-0.6,1/velocity));
		addSequential(new ArcadeDrive(0,0.6,1/velocity));
		addSequential(new Delay(4));
		addSequential(new ArcadeDrive(0,-0.6,1/velocity));
		addSequential(new ArcadeDrive(0,0.6,1/velocity));
		addSequential(new SetSensitivity(RobotMap.driveMasterSensitivity));
		
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
