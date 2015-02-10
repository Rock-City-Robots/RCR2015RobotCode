package org.usfirst.frc.team4849.robot.subsystems;

import org.usfirst.frc.team4849.robot.RobotMap;
import org.usfirst.frc.team4849.robot.commands.DriveType;
import org.usfirst.frc.team4849.robot.commands.DriveWithCubicJoystick;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	private static SpeedController rightFront = new Talon(RobotMap.WHEEL_RIGHT_FRONT);
	private static SpeedController rightBack = new Talon(RobotMap.WHEEL_RIGHT_BACK);
	private static SpeedController leftBack = new Talon(RobotMap.WHEEL_LEFT_BACK);
	private static SpeedController leftFront = new Talon(RobotMap.WHEEL_LEFT_FRONT);
	
	private static DriveType driveType = DriveType.ROBOT_ORIENTED;
	private static RobotDrive robotDrive = new RobotDrive(leftFront, leftBack, rightFront, rightBack);
	private static Gyro gyro = new Gyro(RobotMap.GYRO);
	
	private static double gyroAngle;
	private static double maxSpeed = 0.35;
	
	public DriveTrain() {
		robotDrive.setMaxOutput(maxSpeed);
		
		setDefaultCommand(new DriveWithCubicJoystick(this));
	}
	
	public void drive(double x, double y, double z){
		if(driveType == DriveType.ROBOT_ORIENTED) gyroAngle = 0.0;
		else if(driveType == DriveType.FIELD_ORIENTED) gyroAngle = gyroAngle % 360;
		
		setInvertedMotors(driveType);
		robotDrive.mecanumDrive_Cartesian(x, y, z, gyroAngle);
	}
	
	// Will set which motors to invert based on the drivetype
	private void setInvertedMotors(DriveType driveType) {
		boolean value = true;
		
		if(driveType == DriveType.ROBOT_ORIENTED) value = true;
		else if(driveType == DriveType.FIELD_ORIENTED) value = false;
		
		robotDrive.setInvertedMotor(MotorType.kFrontRight, value);
		robotDrive.setInvertedMotor(MotorType.kRearRight, value);
		
		robotDrive.setInvertedMotor(MotorType.kFrontLeft, !value);
		robotDrive.setInvertedMotor(MotorType.kRearLeft, !value);
		
		
	}
	
	public void setDriveType(DriveType driveType) {
		this.driveType = driveType;
	}
	
	public DriveType getDriveType() {
		return driveType;
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}
		
}
