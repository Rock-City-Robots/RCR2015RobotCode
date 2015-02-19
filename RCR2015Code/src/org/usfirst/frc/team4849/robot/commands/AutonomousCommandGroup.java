package org.usfirst.frc.team4849.robot.commands;

import org.usfirst.frc.team4849.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCommandGroup extends CommandGroup {
	
	public AutonomousCommandGroup(Robot robot){
		addSequential(new GrabToteCommand(robot.getRoller(), robot.getDriveTrain()));
		//addSequential(new MoveTote(robot.getLifter(), LifterState.TOP));
	}

}
