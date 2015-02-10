package org.usfirst.frc.team4849.robot;

public enum ButtonBinding {
	/*
	 * Lifter
	 */
	
	LIFTERUP(7), 
	LIFTERCARRY(9), 
	LIFTERDOWN(11);
	
	private final int number;
	
	private ButtonBinding(int number) {
		this.number = number;
	}
	
	public int getBindingID() {
		return number;
	}
}
