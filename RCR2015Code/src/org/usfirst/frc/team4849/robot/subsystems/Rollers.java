package org.usfirst.frc.team4849.robot.subsystems;

import org.usfirst.frc.team4849.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Rollers extends Subsystem {
	private static final SpeedController rollerRight = new Victor(RobotMap.ROLLER_RIGHT);
	private static final SpeedController rollerLeft = new Victor(RobotMap.ROLLER_LEFT);
	
	@Override
	protected void initDefaultCommand() {

	}

}
