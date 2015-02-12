package org.usfirst.frc.team4849.robot.controller;

import java.util.HashMap;

import org.usfirst.frc.team4849.robot.CubicJoystick;
import org.usfirst.frc.team4849.robot.Robot;
import org.usfirst.frc.team4849.robot.RobotMap;
import org.usfirst.frc.team4849.robot.commands.LifterState;
import org.usfirst.frc.team4849.robot.commands.MoveRoller;
import org.usfirst.frc.team4849.robot.commands.MoveTote;
import org.usfirst.frc.team4849.robot.commands.ResetGyro;
import org.usfirst.frc.team4849.robot.commands.RollerState;
import org.usfirst.frc.team4849.robot.commands.ToggleDrivingMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public abstract class Controller {
	private static CubicJoystick controller = new CubicJoystick(RobotMap.CONTROLLER);
	private HashMap<Integer,JoystickButton> buttonMap = new HashMap<Integer, JoystickButton>();	
	
	/*
	 * DriveTrain
	 */
	private static int TOGGLE_DRIVETYPE;
	private static int RESET_GYRO;
	
	/*
	 * Lifter
	 */
	private static int TOTE_UP;
	private static int TOTE_DOWN;
	
	/*
	 * Rollers
	 */
	private static int TOTE_IN;
	private static int TOTE_OUT;
	
	public Controller(int TOGGLE_DRIVETYPE, int RESET_GYRO, int TOTE_UP, int TOTE_DOWN, int TOTE_IN, int TOTE_OUT) {
		this.TOGGLE_DRIVETYPE = TOGGLE_DRIVETYPE;
		this.RESET_GYRO = RESET_GYRO;
		this.TOTE_UP = TOTE_UP;
		this.TOTE_DOWN = TOTE_DOWN;
		this.TOTE_IN = TOTE_IN;
		this.TOTE_OUT = TOTE_OUT;
	
	}
	
	public void bindKeys() {}
	
	public JoystickButton createButton(int buttonNumber) {
		JoystickButton button;
		
		button = new JoystickButton(controller, buttonNumber);
		buttonMap.put(buttonNumber, button);
		
		return button;
	}
	
	public JoystickButton getButton(int buttonNumber) {
		if(buttonMap.containsKey(buttonNumber)) return buttonMap.get(buttonNumber);
		else return createButton(buttonNumber);
		
	}
	
	public static Joystick getController() {
		return controller;
	}

	public static int getToggleDriveType() {
		return TOGGLE_DRIVETYPE;
	}

	public static int getResetGyro() {
		return RESET_GYRO;
	}

	public static int getToteUp() {
		return TOTE_UP;
	}

	public static int getToteDown() {
		return TOTE_DOWN;
	}

	public static int getToteIn() {
		return TOTE_IN;
	}

	public static int getToteOut() {
		return TOTE_OUT;
	}
	
}
