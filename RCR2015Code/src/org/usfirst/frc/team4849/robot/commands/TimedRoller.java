package org.usfirst.frc.team4849.robot.commands;

import org.usfirst.frc.team4849.robot.subsystems.Roller;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TimedRoller extends Command {
	private Roller roller;
	private RollerState targetState;
	private double time;
	private Timer timer;
	private Command moveRoller;
	
    public TimedRoller(Roller roller, RollerState targetState, double time) {
        requires(roller);
        
    	this.roller = roller;
        this.targetState = targetState;
        this.time = time;
        this.timer = new Timer();
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
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

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.hasPeriodPassed(time);
    }

    // Called once after isFinished returns true
    protected void end() {
    	roller.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	roller.stop();
    }
}
