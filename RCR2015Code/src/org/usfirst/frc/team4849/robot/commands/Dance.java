package org.usfirst.frc.team4849.robot.commands;

import org.usfirst.frc.team4849.robot.Robot;
import org.usfirst.frc.team4849.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Dance extends Command {
	
	private DriveTrain driveTrain;
	private Timer timer;
	private Timer danceBeat;
	private double direction;
	
	public Dance(Robot robot) {
		requires(driveTrain);
		this.driveTrain = robot.getDriveTrain();
		this.timer = new Timer();
		this.danceBeat = new Timer();
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		timer.start();
		danceBeat.start();
		direction = 1.0;
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		driveTrain.drive(0,-0,0.5 * direction);
		
		if(danceBeat.hasPeriodPassed(0.2))
			direction *= -1;
		
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
