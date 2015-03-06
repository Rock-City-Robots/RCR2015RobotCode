package org.usfirst.frc.team4849.robot.subsystems;

import org.usfirst.frc.team4849.robot.RobotMap;
import org.usfirst.frc.team4849.robot.commands.LifterState;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Lifter extends Subsystem implements LightOutput{
	private static Jaguar beltRight = new Jaguar(RobotMap.BELT_RIGHT);
	private static Jaguar beltLeft = new Jaguar(RobotMap.BELT_LEFT);
	
	private static DigitalInput switchRightBottom = new DigitalInput(RobotMap.SWITCH_RIGHT_BOTTOM);
	private static DigitalInput switchRightTop = new DigitalInput(RobotMap.SWITCH_RIGHT_TOP);
	private static DigitalInput switchLeftBottom = new DigitalInput(RobotMap.SWITCH_LEFT_BOTTOM);
	private static DigitalInput switchLeftTop = new DigitalInput(RobotMap.SWITCH_LEFT_TOP);
	
	private static LifterState currentState = LifterState.BOTTOM;
	
	private static boolean beltLeftFinished = false;
	private static boolean beltRightFinished = false;
	
	private static double beltSpeed = 0.3;
	private static double currentSpeed = 0.0;
	
	public Lifter() {
		
	}
	
	public void toteUp() {
		// If the selected belt is not at the top start moving the belt upwards
		// If it is at the top stop the belt and indicate which belt is finished
		
		if(!switchRightTop.get()) {
			beltRight.set(beltSpeed);
		}else {
			beltRight.set(0);
			beltRightFinished = true;
		}
		
		if(!switchLeftTop.get()){ 
			beltLeft.set(beltSpeed);
		}else {
			beltLeft.set(0);
			beltLeftFinished = true;
		}
		
		// If both of the belts are at the top indicate that the entire lifter position is at the top and done
		
		if(beltRightFinished && beltLeftFinished) {
			currentState = LifterState.TOP;
			currentSpeed = 0.0;
		}
		else {
			currentState = LifterState.MOVE;
			currentSpeed = 1.0;
		}
		
	}
	
	public void toteDown() {
		
		if(!switchRightBottom.get()) beltRight.set(-beltSpeed);
		else {
			beltRight.set(0);
			beltRightFinished = true;
		}
		
		if(!switchLeftBottom.get()) beltLeft.set(-beltSpeed);
		else {
			beltLeft.set(0);
			beltLeftFinished = true;
		}
		
		if(beltRightFinished && beltLeftFinished) {
			currentState = LifterState.BOTTOM;
			currentSpeed = 0.0;
		}
		else {
			currentState = LifterState.MOVE;
			currentSpeed = 1.0;
		}
		
	}
	
	public void driveMode() {
		if(currentState == LifterState.BOTTOM) {
			beltRight.set(0.45);
			beltLeft.set(0.45);
			
			Timer.delay(0.4);
			
			beltRight.set(0);
			beltLeft.set(0);
			
			currentState = LifterState.DRIVE;
		}
	}
	
	public LifterState getCurrentState() {
		return currentState;
	}
	
	public void setCurrentState(LifterState state) {
		currentState = state;
	}
	
	public void resetLifter() {
		beltRight.set(0);
		beltLeft.set(0);
		
		beltRightFinished = false;
		beltLeftFinished = false;
		
	}
	
	public void outputSwitchs() {
		SmartDashboard.putBoolean("Right Top:", switchRightTop.get());
		SmartDashboard.putBoolean("Left Top:", switchLeftTop.get());
		SmartDashboard.putBoolean("Right Bottom:", switchRightBottom.get());
		SmartDashboard.putBoolean("Left Bottom:", switchLeftBottom.get());
		SmartDashboard.putString("Current Lifter State:", getCurrentState().toString());
		SmartDashboard.putNumber("Lifter Speed:", currentSpeed);
	}
	
	@Override
	protected void initDefaultCommand() {

	}

	@Override
	public double getLightOutput() {
		return currentSpeed;
	}

}
