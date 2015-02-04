package org.usfirst.frc.team4849.robot.commands;

import org.usfirst.frc.team4849.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/*
 * A command that resets the Gyro
 */
public class ResetGyroCommand extends Command {

	@Override
	protected void initialize() {
		Robot.gyro.initGyro();

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub

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
