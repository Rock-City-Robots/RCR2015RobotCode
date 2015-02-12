package org.usfirst.frc.team4849.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	/*
	 * MOTORS
	 */
	public static final int WHEEL_RIGHT_FRONT = 0;
	public static final int WHEEL_RIGHT_BACK = 1;
	public static final int WHEEL_LEFT_BACK = 2;
	public static final int WHEEL_LEFT_FRONT = 3;
	
	public static final int ROLLER_RIGHT = 4;
	public static final int ROLLER_LEFT = 5;
	
	/*
	 * DIGITAL I/O
	 */
	public static final int SWITCH_RIGHT_BOTTOM = 0;
	public static final int SWITCH_RIGHT_TOP = 1;
	public static final int SWITCH_LEFT_BOTTOM = 2;
	public static final int SWITCH_LEFT_TOP = 3;
	
	
	/*
	 * ANALOG I/0
	 */
	public static final int GYRO = 0;
	
	/*
	 * USB PORTS 
	 */
	public static final int CONTROLLER = 0;
	
	/*
	 * CANS
	 */
	public static final int BELT_RIGHT = 3;
	public static final int BELT_LEFT = 4;
	
	/*
	 * LIGHTS
	 */
	public static final int LIGHTS_BATTERY = 1;
}
