package org.usfirst.frc.team4849.robot.commands;

import org.usfirst.frc.team4849.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonomousCommandGroup extends CommandGroup {
	
	public AutonomousCommandGroup(Robot robot, boolean autoModeJumper){
		SmartDashboard.putBoolean("AutoModeJumper", autoModeJumper);
		if(autoModeJumper) {
			addSequential(new DriveCommnad(robot.getDriveTrain(), 0, -0.7, 0, 1));
		}else{
			//step 1: Lift tote
			addSequential(new MoveTote(robot.getLifter(), LifterState.BOTTOM));
			addSequential(new MoveTote(robot.getLifter(), LifterState.DRIVE));
			
			//step 2: drive right to autozone
			addSequential(new DriveCommnad(robot.getDriveTrain(), -.7,0 ,0 , 2.5));
			
			//step 3: Lifterstate bottom
			addSequential(new MoveTote(robot.getLifter(), LifterState.BOTTOM));
			
			//step 4: Eject and drive backwards
			addParallel(new TimedRoller(robot.getRoller(), RollerState.IN, 1.5));
			addParallel(new DriveCommnad(robot.getDriveTrain(), 0, .35, 0, 1.5));
		}
		
		//addSequential(new Dance(robot.getDriveTrain()));
	}

}
