package org.usfirst.frc.team4849.robot.controller;

public class Extreme3D implements Controller {
	/*
	 * DriveTrain
	 */
	private static final int TOGGLE_DRIVETYPE = 11;
	private static final int RESET_GYRO = 12;
	
	/*
	 * Lifter
	 */
	private static final int TOTE_UP = 6;
	private static final int TOTE_DOWN = 4;
	
	/*
	 * Rollers
	 */
	private static final int TOTE_IN = 5;
	private static final int TOTE_OUT = 3;
	
	public Extreme3D() {

	}

	@Override
	public int getToggleDrivetype() {
		return TOGGLE_DRIVETYPE;
	}

	@Override
	public int getResetGyro() {
		return RESET_GYRO;
	}

	@Override
	public int getToteUp() {
		return TOTE_UP;
	}

	@Override
	public int getToteDown() {
		return TOTE_DOWN;
	}

	@Override
	public int getToteIn() {
		return TOTE_IN;
	}

	@Override
	public int getToteOut() {
		return TOTE_OUT;
	}
	
}
