package org.usfirst.frc.team4849.robot;

import org.usfirst.frc.team4849.robot.controller.Extreme3D;
import org.usfirst.frc.team4849.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4849.robot.subsystems.Lifter;
import org.usfirst.frc.team4849.robot.subsystems.Roller;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	private DriveTrain driveTrain;
	private Lifter lifter;
	private Roller roller;
	private OI oi;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		driveTrain = new DriveTrain();
		lifter = new Lifter();
		roller = new Roller();
		oi = new OI(this, new Extreme3D());
		
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}

	public DriveTrain getDriveTrain() {
		return driveTrain;
	}

	public Lifter getLifter() {
		return lifter;
	}

	public Roller getRoller() {
		return roller;
	}
	
	public OI getOI() {
		return oi;
	}
	
	
	
}
