package org.usfirst.frc.team4849.robot.commands;

import org.usfirst.frc.team4849.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
		
		switch (driveTrain.getDriveType()) {
			case ROBOT_ORIENTED: driveTrain.setDriveType(DriveType.FIELD_ORIENTED);
				break;
			case FIELD_ORIENTED: driveTrain.setDriveType(DriveType.ROBOT_ORIENTED);
				break;
		}
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
