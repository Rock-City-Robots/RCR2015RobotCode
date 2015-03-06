package org.usfirst.frc.team4849.robot;

import org.usfirst.frc.team4849.robot.commands.AutonomousCommandGroup;
import org.usfirst.frc.team4849.robot.commands.DriveType;
import org.usfirst.frc.team4849.robot.controller.Controller;
import org.usfirst.frc.team4849.robot.controller.Extreme3D;
import org.usfirst.frc.team4849.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4849.robot.subsystems.Lifter;
import org.usfirst.frc.team4849.robot.subsystems.Light;
import org.usfirst.frc.team4849.robot.subsystems.Roller;

import edu.wpi.first.wpilibj.DigitalInput;
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
	private static Light light;
	private static Controller controller;
	private DigitalInput autoModeJumperInput;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		driveTrain = new DriveTrain();
		lifter = new Lifter();
		roller = new Roller();
		light = new Light(this);
		controller = new Extreme3D(this);
		autoModeJumperInput = new DigitalInput(RobotMap.AUTO_MODE_JUMPER);
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		
		Scheduler.getInstance().add(new AutonomousCommandGroup(this, autoModeJumperInput.get()));
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		driveTrain.setDriveType(DriveType.FIELD_ORIENTED);
	}

	public void disabledInit() {

	}

	public void teleopPeriodic() {
		lifter.outputSwitchs();
		roller.outputDashboard();
		Scheduler.getInstance().run();

	}

	public void testPeriodic() {
		LiveWindow.run();
	}
	
	///////////////// GETTERS ////////////////////////

	public DriveTrain getDriveTrain() {
		return driveTrain;
	}

	public Lifter getLifter() {
		return lifter;
	}

	public Roller getRoller() {
		return roller;
	}
	
	public static Controller getController() {
		return controller;
	}
	
	
	public static Light getLights() {
		return light;
	}
}
