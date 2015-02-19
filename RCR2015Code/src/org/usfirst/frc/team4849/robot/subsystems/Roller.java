package org.usfirst.frc.team4849.robot.subsystems;

import org.usfirst.frc.team4849.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Roller extends Subsystem implements LightOutput {
	private static final SpeedController rollerRight = new Victor(RobotMap.ROLLER_RIGHT);
	private static final SpeedController rollerLeft = new Victor(RobotMap.ROLLER_LEFT);
	
	private static DigitalInput switchBack = new DigitalInput(RobotMap.SWITCH_BACK);
	
	private double rollerSpeed = 1;
	
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
	
	public boolean isInsideRobot(){
		return !switchBack.get();
	}
	
	@Override
	protected void initDefaultCommand() {

	}

	@Override
	public double getLightOutput() {
		return 0;
	}
	
	public void outputDashboard() {
		SmartDashboard.putBoolean("Switch Back", switchBack.get());
	}

}
