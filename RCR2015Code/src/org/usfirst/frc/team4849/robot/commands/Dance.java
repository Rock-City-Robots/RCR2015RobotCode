package org.usfirst.frc.team4849.robot.commands;

import org.usfirst.frc.team4849.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Dance extends Command {
	
	private DriveTrain driveTrain;
	private Timer timer;
	
	public Dance(DriveTrain driveTrain) {
		requires(driveTrain);
		this.driveTrain = driveTrain;
		this.timer = new Timer();
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		timer.start();
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		driveTrain.drive(0,-0,0.5);
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return timer.hasPeriodPassed(5.0);
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		driveTrain.drive(0, 0, 0);
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		driveTrain.drive(0, 0, 0);
		
	}

}
