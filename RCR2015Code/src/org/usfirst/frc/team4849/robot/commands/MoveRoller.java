package org.usfirst.frc.team4849.robot.commands;

import org.usfirst.frc.team4849.robot.subsystems.Roller;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		roller.stop();
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
