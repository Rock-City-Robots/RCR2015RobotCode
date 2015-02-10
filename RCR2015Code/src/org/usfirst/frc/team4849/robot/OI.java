package org.usfirst.frc.team4849.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	public static CubicJoystick cubicJoystick = new CubicJoystick(RobotMap.CUBIC_JOYSTICK);
	
	public OI() {
		
	}
	
	public JoystickButton createButton(int buttonNumber) {
		JoystickButton button = new JoystickButton(cubicJoystick, buttonNumber);
		return button;
	}
}
