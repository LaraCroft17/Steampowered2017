
package org.usfirst.frc.team5665.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5665.robot.commands.AutoLeftForward;
import org.usfirst.frc.team5665.robot.commands.AutoLeftGear;
import org.usfirst.frc.team5665.robot.commands.AutoMiddleGear;
import org.usfirst.frc.team5665.robot.commands.AutoMove;
import org.usfirst.frc.team5665.robot.commands.AutoRightForward;
import org.usfirst.frc.team5665.robot.commands.AutoRightGear;
import org.usfirst.frc.team5665.robot.commands.AutoSpin;
import org.usfirst.frc.team5665.robot.subsystems.Climber;
import org.usfirst.frc.team5665.robot.subsystems.Drive;
import org.usfirst.frc.team5665.robot.subsystems.FuelCollector;
import org.usfirst.frc.team5665.robot.subsystems.GearHolder;
import org.usfirst.frc.team5665.robot.subsystems.Ramp;
import org.usfirst.frc.team5665.robot.RobotMap;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	//Meters per second
	public static final double velocity = 1.25;
	//Revolutions per second
	public static final double revolution = 0.5;

	public static Drive drive;
	public static Climber climber;
	public static FuelCollector fuelCollector;
	public static GearHolder gearHolder;
	public static Ramp ramp;
	public static OI oi;
	
	public static boolean calibrateEnabled;
	
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.init();
		drive = new Drive();
		climber = new Climber();
		fuelCollector = new FuelCollector();
		gearHolder = new GearHolder();
		ramp = new Ramp();
		oi = new OI();
		
		calibrateEnabled = false;
		
		chooser.addDefault("Middle Gear", new AutoMiddleGear());
		chooser.addObject("Left Charge", new AutoLeftForward());
		chooser.addObject("Right Charge", new AutoRightForward());
		chooser.addObject("Left Gear", new AutoLeftGear());
		chooser.addObject("Right Gear", new AutoRightGear());
		//Debug commands
		chooser.addObject("Velocity test", new AutoMove());
		chooser.addObject("Revolution test", new AutoSpin());
		SmartDashboard.putData("Auto Mode", chooser);
		
		CameraServer.getInstance().startAutomaticCapture();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
