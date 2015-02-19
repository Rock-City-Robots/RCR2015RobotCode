package org.usfirst.frc.team4849.robot.commands;

import org.usfirst.frc.team4849.robot.RobotMap;
import org.usfirst.frc.team4849.robot.subsystems.Roller;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;

public class MoveRoller extends Command {
	private RollerState targetState;
	private Roller roller;
	
	public MoveRoller(Roller roller, RollerState targetState) {
		requires(roller);
		this.roller = roller;
		this.targetState = targetState;
	}
	
	@Override
	protected void end() {
		roller.stop();
		
	}

	@Override
	protected void execute() {
		
		switch(targetState) {
		case IN: roller.in();
			break;
		case OUT: roller.out();
			break;
		case STOP: roller.stop();
			break;
		}
		
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void interrupted() {
		roller.stop();
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

}
