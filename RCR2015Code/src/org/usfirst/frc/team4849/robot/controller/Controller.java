package org.usfirst.frc.team4849.robot.controller;

import java.util.HashMap;

import org.usfirst.frc.team4849.robot.Robot;
import org.usfirst.frc.team4849.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public abstract class Controller {
	private static Robot robot;
	private static CubicJoystick controller = new CubicJoystick(RobotMap.CONTROLLER);
	private static HashMap<Integer,JoystickButton> buttonMap = new HashMap<Integer, JoystickButton>();	
	
	/*
	 * DriveTrain
	 */
	protected static int TOGGLE_DRIVETYPE;
	protected static int RESET_GYRO;
	
	/*
	 * Lifter
	 */
	protected static int TOTE_UP;
	protected static int TOTE_DOWN;
	
	/*
	 * Rollers
	 */
	protected static int TOTE_IN;
	protected static int TOTE_OUT;
	
	protected Controller(Robot robot) {
		Controller.robot = robot;
	
	}
	
	protected abstract void bindKeys();
	
	protected JoystickButton createButton(int buttonNumber) {
		JoystickButton button;
		
		button = new JoystickButton(controller, buttonNumber);
		buttonMap.put(buttonNumber, button);
		
		return button;
	}
	
	protected JoystickButton getButton(int buttonNumber) {
		if(buttonMap.containsKey(buttonNumber)) return buttonMap.get(buttonNumber);
		else return createButton(buttonNumber);
		
	}
	
	protected static Robot getRobot() {
		return robot;
	}
	
	public static Joystick getController() {
		return controller;
	}
	
}
