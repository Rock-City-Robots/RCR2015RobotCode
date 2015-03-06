package org.usfirst.frc.team4849.robot.controller;

import org.usfirst.frc.team4849.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
		
		output = (axisOutput - safezone) / (1 - safezone);
		output = Math.pow(axisOutput, this.pow);
		output *= max;
		
		return output;
	}

	// This function alters the Joystick input
	public double getValue(AxisType axis, double pow, double max) {
		axisOutput = Robot.getController().getAxis(axis);
		axisInverse = axisOutput * -1;
		
		SmartDashboard.putNumber("Axis Output", axisOutput);
		
		if (Math.abs(axisOutput) < safezone) return 0;
		
		if (axisOutput > axisInverse) {
			axisOutput = curveAxis(axisOutput, pow, max);
			
		}
		else {
			
			axisInverse = curveAxis(axisOutput, pow, max);
			axisOutput = axisInverse * -1;
			
			if (axisOutput > axisInverse) return axisInverse;
			
		}
		
		return axisOutput;
	}
}
