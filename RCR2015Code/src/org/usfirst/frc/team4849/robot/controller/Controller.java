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
	public static int TOGGLE_DRIVETYPE;
	public static int RESET_GYRO;
	
	/*
	 * Lifter
	 */
	public static int TOTE_UP;
	public static int TOTE_DOWN;
	public static int RESET_TOTE_COUNT;
	
	/*
	 * Rollers
	 */
	public static int TOTE_IN;
	public static int TOTE_OUT;
	
	protected Controller(Robot robot) {
		Controller.robot = robot;
		bindKeys();
	
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
	
	protected static Joystick getController() {
		return controller;
	}
	
}
