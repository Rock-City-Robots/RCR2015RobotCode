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
	
	public DriveTrain() {
		resetGyro();
		
		robotDrive.setMaxOutput(maxSpeed);
		robotDrive.setInvertedMotor(MotorType.kFrontRight, true);
		robotDrive.setInvertedMotor(MotorType.kRearRight, true);
		
		setDefaultCommand(new DriveWithCubicJoystick(this));
	}
	
	public void drive(double x, double y, double z){
		gyroAngle = gyro.getAngle();
		
		switch (driveType) {
			case ROBOT_ORIENTED: gyroAngle = 0.0;
				break;
			case FIELD_ORIENTED: gyroAngle %= 360;
				break;
		}
		
		//if(driveType == )
		 //gyroAngle *= 0.2;
		
		SmartDashboard.putNumber("Gyro Value:", gyroAngle);
		
		robotDrive.mecanumDrive_Cartesian(x, y, z, -gyroAngle);
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
	protected void initDefaultCommand() {
		
	}

	@Override
	public double getLightOutput() {
		return 0;
	}
		
}
