package org.usfirst.frc.team4849.robot.commands;

import org.usfirst.frc.team4849.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4849.robot.subsystems.Roller;

import edu.wpi.first.wpilibj.command.Command;

public class GrabToteCommand extends Command {
	
	private Roller roller;
	private DriveTrain driveTrain;
	
	public GrabToteCommand(Roller roller, DriveTrain driveTrain){
		this.roller = roller;
		this.driveTrain = driveTrain;
	}

	@Override
	protected void end() {
		roller.stop();
		driveTrain.drive(0, 0, 0);

	}

	@Override
	protected void execute() {
		roller.in();
		driveTrain.drive(0, -0.2, 0);

	}

	@Override
	protected void initialize() {
		driveTrain.switchDriveType();
		driveTrain.resetGyro();

	}

	@Override
	protected void interrupted() {
		roller.stop();

	}

	@Override
	protected boolean isFinished() {
		return this.roller.isInsideRobot();
	}

}
