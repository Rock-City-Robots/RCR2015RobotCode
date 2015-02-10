package org.usfirst.frc.team4849.robot.commands;

import org.usfirst.frc.team4849.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MoveTote extends Command {
	private LifterState targetState;
	private Lifter lifter;
	
	public MoveTote(Lifter lifter, LifterState targetState) {
		requires(lifter);
		this.lifter = lifter;
		this.targetState = targetState;
	}
	
	@Override
	protected void end() {
		lifter.stop();

	}

	@Override
	protected void execute() {
		
		switch(targetState) {
			case TOP: lifter.up();
				break;
			case BOTTOM: lifter.down();
				break;
			case STOP: lifter.stop();
				break;
		}

	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		lifter.stop();

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
