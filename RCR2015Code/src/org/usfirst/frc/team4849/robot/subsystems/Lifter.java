package org.usfirst.frc.team4849.robot.subsystems;

import org.usfirst.frc.team4849.robot.RobotMap;
import org.usfirst.frc.team4849.robot.commands.LifterState;

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
	
	private LifterState currentState = LifterState.STOP;
	
	private static boolean beltLeftFinished = false;
	private static boolean beltRightFinished = false;
	
	private static double beltSpeed = 0.15;
	
	public Lifter() {
		beltRight.setPercentMode();
		beltLeft.setPercentMode();
		
		beltRight.enableControl();
		beltLeft.enableControl();
		
	}
	
	public void toteUp() {
		// If the selected belt is not at the top start moving the belt upwards
		// If it is at the top stop the belt and indicate which belt is finished
		
		if(!switchRightTop.get()) beltRight.set(beltSpeed);
		else {
			beltLeft.set(0);
			beltRightFinished = true;
		}
		
		if(!switchLeftTop.get()) beltLeft.set(beltSpeed);
		else {
			beltRight.set(0);
			beltLeftFinished = true;
		}
		
		// If both of the belts are at the top indicate that the entire lifter position is at the top and done
		
		if(beltRightFinished && beltLeftFinished) currentState = LifterState.TOP;
		else currentState = LifterState.STOP;
		
	}
	
	public void toteDown() {
		
		if(!switchRightBottom.get()) beltRight.set(-beltSpeed);
		else {
			beltLeft.set(0);
			beltRightFinished = true;
		}
		
		if(!switchLeftBottom.get()) beltLeft.set(-beltSpeed);
		else {
			beltRight.set(0);
			beltLeftFinished = true;
		}
		
		if(beltRightFinished && beltLeftFinished) currentState = LifterState.BOTTOM;
		else currentState = LifterState.STOP;
		
	}
	
	public void drive() {
		
	}
	
	public LifterState getCurrentState() {
		return currentState;
	}
	
	public void resetLifter() {
		currentState = LifterState.STOP;
		
		beltRightFinished = false;
		beltLeftFinished = false;
		
		beltRight.set(0);
		beltLeft.set(0);
		
	}
	
	public void outputSwitchs() {
		SmartDashboard.putBoolean("Right Top:", switchRightTop.get());
		SmartDashboard.putBoolean("Left Top:", switchLeftTop.get());
		SmartDashboard.putBoolean("Right Bottom:", switchRightBottom.get());
		SmartDashboard.putBoolean("Left Bottom:", switchLeftBottom.get());
		SmartDashboard.putString("Current Lifter State:", getCurrentState().toString());
	}
	
	@Override
	protected void initDefaultCommand() {

	}

}
