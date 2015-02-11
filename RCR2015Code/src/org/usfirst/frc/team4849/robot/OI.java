package org.usfirst.frc.team4849.robot;

import java.util.HashMap;

import org.usfirst.frc.team4849.robot.commands.LifterState;
import org.usfirst.frc.team4849.robot.commands.MoveRoller;
import org.usfirst.frc.team4849.robot.commands.MoveTote;
import org.usfirst.frc.team4849.robot.commands.ResetGyro;
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
		
		bindKeys();
	}
	
	private void bindKeys() {
		/*
		 * DriveTrain
		 */
		createButton(controller.getToggleDrivetype()).whenPressed(new ToggleDrivingMode(robot.getDriveTrain()));
		createButton(controller.getResetGyro()).whenPressed(new ResetGyro(robot.getDriveTrain()));
		
		/*
		 * Lifter
		 */
		createButton(controller.getToteUp()).whenPressed(new MoveTote(robot.getLifter(), LifterState.TOP));
		getButton(controller.getToteUp()).whenReleased(new MoveTote(robot.getLifter(), LifterState.DRIVE));
		
		createButton(controller.getToteDown()).whenPressed(new MoveTote(robot.getLifter(), LifterState.BOTTOM));
		getButton(controller.getToteDown()).whenReleased(new MoveTote(robot.getLifter(), LifterState.DRIVE));
		
		/*
		 * Rollers
		 */
		createButton(controller.getToteIn()).whenPressed(new MoveRoller(robot.getRoller(), RollerState.IN));
		getButton(controller.getToteIn()).whenReleased(new MoveRoller(robot.getRoller(), RollerState.STOP));
		
		createButton(controller.getToteOut()).whenPressed(new MoveRoller(robot.getRoller(), RollerState.OUT));
		getButton(controller.getToteOut()).whenReleased(new MoveRoller(robot.getRoller(), RollerState.STOP));
		
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
