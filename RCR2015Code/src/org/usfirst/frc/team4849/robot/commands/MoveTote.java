package org.usfirst.frc.team4849.robot.commands;

import org.usfirst.frc.team4849.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.command.Command;

public class MoveTote extends Command {
	private LifterState targetState;
	private Lifter lifter;
	private boolean finished = false;
	
	public MoveTote(Lifter lifter, LifterState targetState) {
		requires(lifter);
		this.lifter = lifter;
		this.targetState = targetState;
		
	}

	@Override
	protected void execute() {
		if(targetState == LifterState.TOP) {
			if(!lifter.isTop()) {
				finished = false;
				lifter.toteUp();
			}
			else {
				finished = true;
				lifter.resetState();
				end();
			}
		}
		else if(targetState == LifterState.BOTTOM) {
			if(!lifter.isBottom()) {
				finished = false;
				lifter.toteDown();
			}
			else {
				finished = true;
				lifter.resetState();
				end();
			}
		}

		
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void interrupted() {
		lifter.stop();

	}
	
	@Override
	protected void end() {
		lifter.stop();
		lifter.resetState();
	}

	@Override
	protected boolean isFinished() {
		return finished;
	}

}
