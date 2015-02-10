package org.usfirst.frc.team4849.robot.subsystems;

import org.usfirst.frc.team4849.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Roller extends Subsystem {
	private static final SpeedController rollerRight = new Victor(RobotMap.ROLLER_RIGHT);
	private static final SpeedController rollerLeft = new Victor(RobotMap.ROLLER_LEFT);
	
	private double rollerSpeed = 0.95;
	
	public void in() {
		rollerRight.set(-rollerSpeed);
		rollerLeft.set(rollerSpeed);
	}
	
	public void out() {
		rollerRight.set(rollerSpeed);
		rollerLeft.set(-rollerSpeed);
	}
	
	public void stop() {
		rollerRight.set(0);
		rollerLeft.set(0);
	}
	
	@Override
	protected void initDefaultCommand() {

	}

}
