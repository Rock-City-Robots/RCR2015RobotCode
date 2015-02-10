package org.usfirst.frc.team4849.robot;

import java.util.HashMap;

import org.usfirst.frc.team4849.robot.commands.LifterState;
import org.usfirst.frc.team4849.robot.commands.MoveRoller;
import org.usfirst.frc.team4849.robot.commands.MoveTote;
import org.usfirst.frc.team4849.robot.commands.RollerState;
import org.usfirst.frc.team4849.robot.commands.ToggleDrivingMode;
import org.usfirst.frc.team4849.robot.controller.Controller;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	public static CubicJoystick cubicJoystick = new CubicJoystick(RobotMap.CUBIC_JOYSTICK);
	private Controller controller;
	private Robot robot;
	private HashMap<Integer,JoystickButton> buttonMap = new HashMap<Integer, JoystickButton>();
	
	public OI(Robot robot, Controller controller) {
		this.robot = robot;
		this.controller = controller;
	}
	
	private void BindKeys() {
		/*
		 * DriveTrain
		 */
		getButton(Controller.TOGGLE_DRIVETYPE).whenPressed(new ToggleDrivingMode(robot.getDriveTrain()));
		
		/*
		 * Lifter
		 */
		getButton(Controller.TOTE_UP).whenPressed(new MoveTote(robot.getLifter(), LifterState.TOP));
		getButton(Controller.TOTE_UP).whenReleased(new MoveTote(robot.getLifter(), LifterState.DRIVE));
		
		getButton(Controller.TOTE_DOWN).whenPressed(new MoveTote(robot.getLifter(), LifterState.BOTTOM));
		getButton(Controller.TOTE_DOWN).whenReleased(new MoveTote(robot.getLifter(), LifterState.DRIVE));
		
		/*
		 * Rollers
		 */
		getButton(Controller.TOTE_IN).whenPressed(new MoveRoller(robot.getRoller(), RollerState.IN));
		getButton(Controller.TOTE_IN).whenReleased(new MoveRoller(robot.getRoller(), RollerState.STOP));
		
		getButton(Controller.TOTE_OUT).whenPressed(new MoveRoller(robot.getRoller(), RollerState.OUT));
		getButton(Controller.TOTE_OUT).whenReleased(new MoveRoller(robot.getRoller(), RollerState.STOP));
		
	}
	
	private JoystickButton createButton(int buttonNumber) {
		JoystickButton button;
		
		button = new JoystickButton(cubicJoystick, buttonNumber);
		buttonMap.put(buttonNumber, button);
		
		return button;
	}
	
	private JoystickButton getButton(int buttonNumber) {
		if(buttonMap.containsKey(buttonNumber)) return buttonMap.get(buttonNumber);
		else return createButton(buttonNumber);
		
	}
}
