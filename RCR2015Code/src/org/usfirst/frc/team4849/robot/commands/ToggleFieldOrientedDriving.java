package org.usfirst.frc.team4849.robot.commands;

import org.usfirst.frc.team4849.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * A command to toggle between field oriented driving and robot oriented
 * driving.
 *
 */
public class ToggleFieldOrientedDriving extends Command {

	@Override
	protected void initialize() {
		if (Robot.driveType == DriveType.ROBOT_ORIENTED) {
			Robot.driveType = DriveType.FIELD_ORIENTED;
		} else {
			Robot.driveType = DriveType.ROBOT_ORIENTED;
		}

	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
