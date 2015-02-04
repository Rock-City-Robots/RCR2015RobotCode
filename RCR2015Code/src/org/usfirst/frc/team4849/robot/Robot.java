package org.usfirst.frc.team4849.robot;

import org.usfirst.frc.team4849.robot.commands.DriveType;
import org.usfirst.frc.team4849.robot.commands.SimpleAutoCommand;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;

	// TODO: move all "magic numbers" to RobotMap
	//TODO: move all motors and gyro to drivetrain subsystem

	public static SpeedController rightfront = new Talon(0);
	public static SpeedController rightback = new Talon(1);
	public static SpeedController leftback = new Talon(2);
	public static SpeedController leftfront = new Talon(3);

	public static SpeedController roller1 = new Victor(4);
	public static SpeedController roller2 = new Victor(5);

	public static RobotDrive robotDrive = new RobotDrive(leftfront, leftback,
			rightfront, rightback);
	public static Gyro gyro = new Gyro(0);

	public static DriveType driveType;

	private Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();
		driveType = DriveType.FIELD_ORIENTED;
		robotDrive.setInvertedMotor(MotorType.kFrontRight, true);
		robotDrive.setInvertedMotor(MotorType.kRearRight, true);

		autonomousCommand = new SimpleAutoCommand(robotDrive, gyro);
		robotDrive.setMaxOutput(.35);
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		gyro.initGyro();
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		gyro.initGyro();
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

	}

	private boolean safezone(double a) {
		return a < 0.1;
	}

	// This function alters the Joystick input
	// TODO: move to Cubic Joystick or static method
	private double curve(AxisType a, int pow) {
		double b = OI.joystick.getAxis(a);
		double c = b * -1;
		if (b > c) {
			if (safezone(b))
				return 0;
			// [minFrom..maxFrom] -> [minTo..maxTo]
			// mappedValue = minTo + (maxTo - minTo) * ((value - minFrom) /
			// (maxFrom - minFrom));
			b = 0.0 + (1.0 - 0.0) * ((b - 0.1) / (1 - 0.1));
			double o = b;
			do {
				o = o * b;
				pow = pow - 1;
			} while (pow != 0);
			return b;
		} else {
			if (safezone(c))
				return 0;
			c = 0.0 + (1.0 - 0.0) * ((c - 0.1) / (1 - 0.1));
			double o = c;
			do {
				o = o * c;
				pow = pow - 1;
			} while (pow != 0);
			b = c * -1;
			if (b > c)
				return c;
			return b;
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {

		// TODO: move all drive related code to a method.
		double angle = 0.0;

		if (driveType == DriveType.FIELD_ORIENTED) {
			angle = gyro.getAngle() % 360;
		}

		SmartDashboard.putNumber("GYRO", gyro.getAngle());
		SmartDashboard.putNumber("GYRO - mod 360", angle);

		robotDrive.mecanumDrive_Cartesian(curve(AxisType.kX, 3),
				curve(AxisType.kY, 3), OI.joystick.getAxis(AxisType.kZ), angle);

		// TODO: move to a command.
		if (oi.joystick.getTrigger()) {
			roller1.set(1);
			roller2.set(1);
		} else {
			roller1.set(0);
			roller2.set(0);
		}

		Scheduler.getInstance().run();

	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
