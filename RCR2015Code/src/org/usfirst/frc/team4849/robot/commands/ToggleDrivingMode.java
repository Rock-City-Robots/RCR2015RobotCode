package org.usfirst.frc.team4849.robot.commands;

import org.usfirst.frc.team4849.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleDrivingMode extends Command {
	private DriveTrain driveTrain;
	
	public ToggleDrivingMode(DriveTrain driveTrain) {
		requires(driveTrain);
		this.driveTrain = driveTrain;
	}
	
	@Override
	protected void end() {

	}

	@Override
	protected void execute() {
		driveTrain.switchDriveType();
		
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void interrupted() {

	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
