package org.usfirst.frc.team4849.robot.subsystems;

import org.usfirst.frc.team4849.robot.RobotMap;
import org.usfirst.frc.team4849.robot.commands.DriveType;
import org.usfirst.frc.team4849.robot.commands.DriveWithCubicJoystick;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem implements LightOutput{
	private static SpeedController rightFront = new Talon(RobotMap.WHEEL_RIGHT_FRONT);
	private static SpeedController rightBack = new Talon(RobotMap.WHEEL_RIGHT_BACK);
	private static SpeedController leftBack = new Talon(RobotMap.WHEEL_LEFT_BACK);
	private static SpeedController leftFront = new Talon(RobotMap.WHEEL_LEFT_FRONT);
	
	private static DriveType driveType = DriveType.ROBOT_ORIENTED;
	private static RobotDrive robotDrive = new RobotDrive(leftFront, leftBack, rightFront, rightBack);
	private static Gyro gyro = new Gyro(RobotMap.GYRO);
	
	private static double gyroAngle;
	private static double maxSpeed = 0.8;
	private static double currentSpeed = 0.0;
	
	private static final double movementContribution = 0.8;
	private static final double rotationContribution = 0.2;
	
	public DriveTrain() {
		gyro.initGyro();
		
		robotDrive.setMaxOutput(maxSpeed);
		robotDrive.setInvertedMotor(MotorType.kFrontRight, true);
		robotDrive.setInvertedMotor(MotorType.kRearRight, true);
		
		setDefaultCommand(new DriveWithCubicJoystick(this));
	}
	
	public void drive(double x, double y, double z){
		
		currentSpeed = ((Math.abs(x + y) / 2) * movementContribution) + (Math.abs(z) * rotationContribution);
		gyroAngle = gyro.getAngle();
		
		if(driveType == DriveType.ROBOT_ORIENTED) {
			gyroAngle = 0;
			
			robotDrive.setInvertedMotor(MotorType.kFrontRight, false);
			robotDrive.setInvertedMotor(MotorType.kRearRight, false);
			
			robotDrive.setInvertedMotor(MotorType.kFrontLeft, true);
			robotDrive.setInvertedMotor(MotorType.kRearLeft, true);
		}
		else if (driveType == DriveType.FIELD_ORIENTED) {
			//gyroAngle += 180;
			gyroAngle %= 360;
			
			robotDrive.setInvertedMotor(MotorType.kFrontRight, false);
			robotDrive.setInvertedMotor(MotorType.kRearRight, false);
			
			robotDrive.setInvertedMotor(MotorType.kFrontLeft, true);
			robotDrive.setInvertedMotor(MotorType.kRearLeft, true);
		}
		
		SmartDashboard.putNumber("Gyro Value:", -gyroAngle);
		SmartDashboard.putNumber("DriveTrain Speed:", currentSpeed);
		
		robotDrive.mecanumDrive_Cartesian(-x, -y, -z, gyroAngle);
	}
	
	public void resetGyro() {
		gyro.initGyro();
	}
	
	public void switchDriveType() {
		switch (driveType) {
			case ROBOT_ORIENTED: driveType = DriveType.FIELD_ORIENTED;
				break;
			case FIELD_ORIENTED: driveType = DriveType.ROBOT_ORIENTED;
				break;
		}
		
		SmartDashboard.putString("Drive Type:", driveType.toString());
	}
	
	@Override
	public double getLightOutput() {
		return currentSpeed;
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}
		
}
