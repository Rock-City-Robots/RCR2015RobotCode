package org.usfirst.frc.team4849.robot.commands;

import org.usfirst.frc.team4849.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveToAutoZoneCommand extends Command {
	
	private DriveTrain driveTrain;
	private Timer timer;
	
	public DriveToAutoZoneCommand(DriveTrain driveTrain) {
		requires(driveTrain);
		this.driveTrain = driveTrain;
		this.timer = new Timer();
	}

	@Override
	protected void initialize() {
		timer.start();
		this.driveTrain.setDriveType(DriveType.ROBOT_ORIENTED);

	}

	@Override
	protected void execute() {
		driveTrain.drive(-0, -.7, 0);

	}

	@Override
	protected boolean isFinished() {
		return timer.hasPeriodPassed(1.0);
	}

	@Override
	protected void end() {
		driveTrain.drive(0, 0, 0);

	}

	@Override
	protected void interrupted() {
		driveTrain.drive(0, 0, 0);

	}

}
