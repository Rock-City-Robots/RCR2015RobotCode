package org.usfirst.frc.team4849.robot.commands;

import org.usfirst.frc.team4849.robot.controller.Controller;
import org.usfirst.frc.team4849.robot.controller.CubicJoystick;
import org.usfirst.frc.team4849.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveWithCubicJoystick extends Command{
	private DriveTrain driveTrain;
	private CubicJoystick controller;
	
	private static int movementArc = 3;
	private static int rotationArc = 1;
	
	private static double movementMaxSpeed = 0.75;
	private static double rotationMaxSpeed = 0.50;
	
	private static boolean end = false;
	
	
	public DriveWithCubicJoystick(DriveTrain driveTrain) {
		requires(driveTrain);
		this.driveTrain = driveTrain;
		controller = (CubicJoystick) Controller.getController();
	}

	@Override
	protected void execute() {
		driveTrain.drive(controller.getValue(AxisType.kX, movementArc, movementMaxSpeed), controller.getValue(AxisType.kY, movementArc, movementMaxSpeed), controller.getValue(AxisType.kZ, rotationArc, rotationMaxSpeed));
		
		SmartDashboard.putNumber("Movement Arc:", movementArc);
		SmartDashboard.putNumber("Rotation Arc:", rotationArc);
		
		SmartDashboard.putNumber("Movement Max Speed:", movementMaxSpeed);
		SmartDashboard.putNumber("Rotation Max Speed:", rotationMaxSpeed);
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void interrupted() {
		end();
	}

	@Override
	protected boolean isFinished() {
		return end;
	}
	
	@Override
	protected void end() {
		end = true;
	}

}
