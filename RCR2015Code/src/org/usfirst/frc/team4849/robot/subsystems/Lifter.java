package org.usfirst.frc.team4849.robot.subsystems;

import org.usfirst.frc.team4849.robot.RobotMap;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Lifter extends Subsystem {
	private static CANJaguar beltRight = new CANJaguar(RobotMap.BELT_RIGHT);
	private static CANJaguar beltLeft = new CANJaguar(RobotMap.BELT_LEFT);
	
	private static DigitalInput switchRightBottom = new DigitalInput(RobotMap.SWITCH_RIGHT_BOTTOM);
	private static DigitalInput switchRightTop = new DigitalInput(RobotMap.SWITCH_RIGHT_TOP);
	private static DigitalInput switchLeftBottom = new DigitalInput(RobotMap.SWITCH_LEFT_BOTTOM);
	private static DigitalInput switchLeftTop = new DigitalInput(RobotMap.SWITCH_LEFT_TOP);
	
	private static boolean bottom = false;
	private static boolean top = false;
	
	private boolean left = false;
	private boolean right = false;
	
	private static double beltSpeed = 0.45;
	
	public Lifter() {
		beltRight.setPercentMode();
		beltLeft.setPercentMode();
		
		beltRight.enableControl();
		beltLeft.enableControl();
		
	}
	
	public void toteUp() {
		
		if(!switchRightTop.get()) beltRight.set(beltSpeed);
		else {
			right = true;
			beltLeft.set(0);
		}
		
		if(!switchLeftTop.get()) beltLeft.set(beltSpeed);
		else {
			left = true;
			beltRight.set(0);
		}
		
		if(right && left) {
			top = true;
			right = false;
			left = false;
		}
		else top = false;
		
	}
	
	public void toteDown() {
		
		if(!switchRightBottom.get()) beltRight.set(-beltSpeed);
		else {
			right = true;
			beltLeft.set(0);
		}
		
		if(!switchLeftBottom.get()) beltLeft.set(-beltSpeed);
		else {
			left = true;
			beltRight.set(0);
		}
		
		if(right && left) {
			bottom = true;
			right = false;
			left = false;
		}
		else bottom = false;
		
	}
	
	public void drive() {
		
	}
	
	public void stop() {
		beltRight.set(0);
		beltLeft.set(0);
	}
	
	public boolean isBottom() {
		return bottom;
	}
	
	public boolean isTop() {
		return top;
	}
	
	public void resetState() {
		bottom = false;
		top = false;
		
	}
	
	public void outputSwitchs() {
		SmartDashboard.putBoolean("Right Top:", switchRightTop.get());
		SmartDashboard.putBoolean("Left Top:", switchLeftTop.get());
		SmartDashboard.putBoolean("Right Bottom:", switchRightBottom.get());
		SmartDashboard.putBoolean("Left Bottom:", switchLeftBottom.get());
		SmartDashboard.putBoolean("At Bottom:", isBottom());
		SmartDashboard.putBoolean("At Top:", isTop());
	}
	
	@Override
	protected void initDefaultCommand() {

	}

}
