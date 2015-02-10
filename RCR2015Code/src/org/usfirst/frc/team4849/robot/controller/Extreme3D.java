package org.usfirst.frc.team4849.robot.controller;

public class Extreme3D extends Controller {
	
	public Extreme3D() {
		/*
		 * DriveTrain
		 */
		super.TOGGLE_DRIVETYPE = 2;
		
		/*
		 * Lifter
		 */
		super.TOTE_UP = 7;
		super.TOTE_DOWN = 9;
		
		/*
		 * Rollers
		 */
		super.TOTE_IN = 8;
		super.TOTE_OUT = 10;
	}
	
}
