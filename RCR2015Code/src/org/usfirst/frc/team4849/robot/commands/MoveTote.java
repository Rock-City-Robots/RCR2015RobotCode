package org.usfirst.frc.team4849.robot.commands;

import org.usfirst.frc.team4849.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.command.Command;

public class MoveTote extends Command {
	private LifterState targetState;
	private Lifter lifter;
	private boolean finished;
	
	public MoveTote(Lifter lifter, LifterState targetState) {
		requires(lifter);
		this.lifter = lifter;
		this.targetState = targetState;
		
	}

	@Override
	protected void execute() {
		if(targetState == LifterState.TOP && lifter.getCurrentState() != LifterState.TOP) {
			lifter.toteUp();
			finished = false;

		}
		
		else if(targetState == LifterState.BOTTOM && lifter.getCurrentState() != LifterState.BOTTOM) {
			lifter.toteDown();
			finished = false;
			
		}
		
		else finished = true;

	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void interrupted() {
		finished = true;
		lifter.setCurrentState(LifterState.INTERRUPTED);
		end();

	}
	
	@Override
	protected void end() {
		lifter.resetLifter();
	}

	@Override
	protected boolean isFinished() {
		return finished;
	}

}
