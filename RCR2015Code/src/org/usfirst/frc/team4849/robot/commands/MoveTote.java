package org.usfirst.frc.team4849.robot.commands;

import org.usfirst.frc.team4849.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.command.Command;

public class MoveTote extends Command {
	private static LifterState targetState;
	Lifter lifter;
	
	public MoveTote(Lifter lifter, LifterState targetState) {
		requires(lifter);
		this.lifter = lifter;
		this.targetState = targetState;
	}
	
	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		switch(targetState) {
			case TOP: lifter.up();
				break;
			case BOTTOM: lifter.down();
				break;
			case DRIVE: lifter.stop();
				break;
		}

	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
