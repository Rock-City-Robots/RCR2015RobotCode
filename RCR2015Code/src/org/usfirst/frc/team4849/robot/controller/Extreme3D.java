package org.usfirst.frc.team4849.robot.controller;

import org.usfirst.frc.team4849.robot.OI;
import org.usfirst.frc.team4849.robot.Robot;
import org.usfirst.frc.team4849.robot.commands.LifterState;
import org.usfirst.frc.team4849.robot.commands.MoveRoller;
import org.usfirst.frc.team4849.robot.commands.MoveTote;
import org.usfirst.frc.team4849.robot.commands.ResetGyro;
import org.usfirst.frc.team4849.robot.commands.RollerState;
import org.usfirst.frc.team4849.robot.commands.ToggleDrivingMode;

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

	@Override
	public void bindKeys(OI oi, Robot robot) {
		/*
		 * DriveTrain
		 */
		oi.createButton(TOGGLE_DRIVETYPE).whenPressed(new ToggleDrivingMode(robot.getDriveTrain()));
		oi.createButton(RESET_GYRO).whenPressed(new ResetGyro(robot.getDriveTrain()));
		
		/*
		 * Lifter
		 */
		oi.createButton(TOTE_UP).whenPressed(new MoveTote(robot.getLifter(), LifterState.TOP));
		oi.getButton(TOTE_UP).whenReleased(new MoveTote(robot.getLifter(), LifterState.DRIVE));
		
		oi.createButton(TOTE_DOWN).whenPressed(new MoveTote(robot.getLifter(), LifterState.BOTTOM));
		oi.getButton(TOTE_DOWN).whenReleased(new MoveTote(robot.getLifter(), LifterState.DRIVE));
		
		/*
		 * Rollers
		 */
		oi.createButton(TOTE_IN).whenPressed(new MoveRoller(robot.getRoller(), RollerState.IN));
		oi.getButton(TOTE_IN).whenReleased(new MoveRoller(robot.getRoller(), RollerState.STOP));
		
		oi.createButton(TOTE_OUT).whenPressed(new MoveRoller(robot.getRoller(), RollerState.OUT));
		oi.getButton(TOTE_OUT).whenReleased(new MoveRoller(robot.getRoller(), RollerState.STOP));
	}
	
}
