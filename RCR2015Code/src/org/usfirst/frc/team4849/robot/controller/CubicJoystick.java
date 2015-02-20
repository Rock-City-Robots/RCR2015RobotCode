package org.usfirst.frc.team4849.robot.controller;

import edu.wpi.first.wpilibj.Joystick;

public class CubicJoystick extends Joystick {
	private double axisOutput;
	private double axisInverse;
	private double safezone =  0.05;
	private double pow = 3.0;

	public CubicJoystick(int port) {
		super(port);
	}
	
	public void setPower(double pow) {
		this.pow = pow;
	}
	
	private double curveAxis(double axisOutput, double pow, double max) {
		double output;
		this.pow = pow;
		
		output = 1.0 * ((axisOutput - safezone) / (1 - safezone));
		output = Math.pow(axisOutput, this.pow);
		output *= max;
		
		return output;
	}

	// This function alters the Joystick input
	public double getValue(AxisType axis, double pow, double max) {
		axisOutput = this.getAxis(axis);
		axisInverse = axisOutput * -1;
		
		if ((axisOutput < safezone) || (axisInverse < safezone)) return 0;
		
		if (axisOutput > axisInverse) {
			curveAxis(axisOutput, pow, max);
		}
		else {
			axisInverse = curveAxis(axisInverse, pow, max);
			axisOutput = axisInverse * -1;

			if (axisOutput > axisInverse) return axisInverse;
			
		}
		
		return axisOutput;
	}
}
