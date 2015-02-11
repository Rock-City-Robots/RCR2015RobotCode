package org.usfirst.frc.team4849.robot.controller;

public interface Controller {
	/*
	 * DriveTrain
	 */
	public int getToggleDrivetype();
	public int getResetGyro();
	
	/*
	 * Lifter
	 */
	public int getToteUp();
	public int getToteDown();
	
	/*
	 * Roller
	 */
	public int getToteIn();
	public int getToteOut();
	
}
