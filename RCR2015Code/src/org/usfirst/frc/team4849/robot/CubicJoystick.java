package org.usfirst.frc.team4849.robot;

import edu.wpi.first.wpilibj.Joystick;

public class CubicJoystick extends Joystick {

	double power = 3.0;

	public CubicJoystick(int port) {
		super(port);
	}

	public void setPower(double pow) {
		this.power = pow;
	}

	private boolean safezone(double a) {
		return a < 0.1;
	}

	// This function alters the Joystick input
	private double curve(AxisType a, double pow) {
		double b = this.getAxis(a);
		double c = b * -1;

		if (b > c) {
			if (safezone(b)) return 0;

			b = 0.0 + (1.0 - 0.0) * ((b - 0.1) / (1 - 0.1));
			b = Math.pow(b, pow);

			return b;

		} else {
			if (safezone(c)) return 0;

			c = 0.0 + (1.0 - 0.0) * ((c - 0.1) / (1 - 0.1));
			c = Math.pow(c, pow);
			b = c * -1;

			if (b > c)
				return c;

			return b;
		}
	}

	public double getValue(AxisType axis, double pow) {
		this.power = pow;
		return curve(axis, power);
	}

}
