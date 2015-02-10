package org.usfirst.frc.team4849.robot;

public enum ButtonBinding {
	/*
	 * DriveTrain
	 */
	DRIVEMODE(2),
	
	/*
	 * Lifter
	 */
	
	LIFTERUP(7), 
	LIFTERCARRY(9), 
	LIFTERDOWN(11), 
	
	/*
	 * Rollers
	 */
	
	ROLLERIN(8),
	ROLLERSTOP(10),
	ROLLEROUT(12);
	
	private final int number;
	
	private ButtonBinding(int number) {
		this.number = number;
	}
	
	public int getBindingID() {
		return number;
	}
}
