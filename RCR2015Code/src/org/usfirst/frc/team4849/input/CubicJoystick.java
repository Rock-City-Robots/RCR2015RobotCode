package org.usfirst.frc.team4849.input;

import edu.wpi.first.wpilibj.Joystick;

public class CubicJoystick extends Joystick {

	public CubicJoystick(int port) {
		super(port);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public double getAxis(AxisType axis) {
		return (super.getAxis(axis) * super.getAxis(axis) * super.getAxis(axis))/2;
	}
}
