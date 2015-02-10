package org.usfirst.frc.team4849.robot;

import java.util.HashMap;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	public static CubicJoystick cubicJoystick = new CubicJoystick(RobotMap.CUBIC_JOYSTICK);
	
	private HashMap<Integer,JoystickButton> buttonMap = new HashMap<Integer, JoystickButton>();
	
	public OI() {
		
	}
	
	public JoystickButton createButton(int buttonNumber) {
		JoystickButton button;
		
		button = new JoystickButton(cubicJoystick, buttonNumber);
		buttonMap.put(buttonNumber, button);
		
		return button;
	}
	
	public JoystickButton getButton(int buttonNumber) {
		if(buttonMap.containsKey(buttonNumber)) return buttonMap.get(buttonNumber);
		else return createButton(buttonNumber);
		
	}
}
