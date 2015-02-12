package org.usfirst.frc.team4849.robot.commands;

import org.usfirst.frc.team4849.robot.CubicJoystick;
import org.usfirst.frc.team4849.robot.controller.Controller;
import org.usfirst.frc.team4849.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Command;

public class DriveWithCubicJoystick extends Command{
	private DriveTrain driveTrain;
	private CubicJoystick controller;
	private static int arc = 5;
	
	public DriveWithCubicJoystick(DriveTrain driveTrain) {
		requires(driveTrain);
		this.driveTrain = driveTrain;
		controller = (CubicJoystick) Controller.getController();
	}
	
	@Override
	protected void end() {
	}

	@Override
	protected void execute() {
		driveTrain.drive(controller.getValue(AxisType.kX, arc), controller.getValue(AxisType.kY, arc), controller.getValue(AxisType.kZ, arc));
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void interrupted() {
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

}
