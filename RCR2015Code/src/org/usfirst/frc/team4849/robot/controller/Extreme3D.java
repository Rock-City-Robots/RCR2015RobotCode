package org.usfirst.frc.team4849.robot.controller;

import org.usfirst.frc.team4849.robot.Robot;
import org.usfirst.frc.team4849.robot.commands.LifterState;
import org.usfirst.frc.team4849.robot.commands.MoveRoller;
import org.usfirst.frc.team4849.robot.commands.MoveTote;
import org.usfirst.frc.team4849.robot.commands.ResetGyro;
import org.usfirst.frc.team4849.robot.commands.RollerState;
import org.usfirst.frc.team4849.robot.commands.ToggleDrivingMode;

public class Extreme3D extends Controller {
	private Robot robot;
	
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
	
	public Extreme3D(Robot robot) {
		super(TOGGLE_DRIVETYPE, RESET_GYRO, TOTE_UP, TOTE_DOWN, TOTE_IN, TOTE_OUT);
		this.robot = robot;
		
		bindKeys();
	}

	@Override
	public void bindKeys() {
		/*
		 * DriveTrain
		 */
		createButton(getToggleDriveType()).whenPressed(new ToggleDrivingMode(robot.getDriveTrain()));
		createButton(getResetGyro()).whenPressed(new ResetGyro(robot.getDriveTrain()));
		
		/*
		 * Lifter
		 */
		createButton(getToteUp()).whenPressed(new MoveTote(robot.getLifter(), LifterState.TOP));
		//getButton(getToteUp()).whenReleased(new MoveTote(robot.getLifter(), LifterState.DRIVE));
		
		createButton(getToteDown()).whenPressed(new MoveTote(robot.getLifter(), LifterState.BOTTOM));
		//getButton(getToteDown()).whenReleased(new MoveTote(robot.getLifter(), LifterState.DRIVE));
		
		/*
		 * Rollers
		 */
		createButton(getToteIn()).whenPressed(new MoveRoller(robot.getRoller(), RollerState.IN));
		getButton(getToteIn()).whenReleased(new MoveRoller(robot.getRoller(), RollerState.STOP));
		
		createButton(getToteOut()).whenPressed(new MoveRoller(robot.getRoller(), RollerState.OUT));
		getButton(getToteOut()).whenReleased(new MoveRoller(robot.getRoller(), RollerState.STOP));
	}
	
}
