package org.usfirst.frc.team4849.robot.commands;

import org.usfirst.frc.team4849.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveCommnad extends Command {
	
	private DriveTrain driveTrain;
	private Timer timer;
	
	private double x, y, z, time;
	
	public DriveCommnad(DriveTrain driveTrain, double x, double y, double z, double time) {
		requires(driveTrain);
		this.driveTrain = driveTrain;
		this.timer = new Timer();
		
		this.x = x;
		this.y = y;
		this.z = z;
		this.time = time;
	}

	@Override
	protected void initialize() {
		timer.start();
		this.driveTrain.setDriveType(DriveType.ROBOT_ORIENTED);

	}

	@Override
	protected void execute() {
		driveTrain.drive(x, y, z);

	}

	@Override
	protected boolean isFinished() {
		return timer.hasPeriodPassed(time);
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
