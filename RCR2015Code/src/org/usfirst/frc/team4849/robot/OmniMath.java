package org.usfirst.frc.team4849.robot;

public class OmniMath {
	private double a;
	private double b;
	private double c;
	private double d;
	//0 <= angle < 360, 0 <= speed <= 1, 0 <= rotation <= 1
	// a════════b
	// ║        ║
	// ║        ║
	// c════════d
	
	public void translate(double angle, double speed, double rotation) {
		a = speed * Math.cos(angle) + rotation;
		b = speed * Math.sin(angle) + rotation;
		c = speed * -1 * Math.cos(angle) + rotation;
		d = speed * -1 * Math.sin(angle) + rotation;
	}
	
	public double geta() {
		return a;
	}
	
	public double getb() {
		return b;
	}
	
	public double getc() {
		return c;
	}
	
	public double getd() {
		return d;
	}
}
