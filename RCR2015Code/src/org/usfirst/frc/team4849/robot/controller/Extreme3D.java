package org.usfirst.frc.team4849.robot.controller;

import org.usfirst.frc.team4849.robot.Robot;
import org.usfirst.frc.team4849.robot.commands.LifterState;
import org.usfirst.frc.team4849.robot.commands.MoveRoller;
import org.usfirst.frc.team4849.robot.commands.MoveTote;
import org.usfirst.frc.team4849.robot.commands.ResetGyro;
import org.usfirst.frc.team4849.robot.commands.ResetToteCount;
import org.usfirst.frc.team4849.robot.commands.RollerState;
import org.usfirst.frc.team4849.robot.commands.ToggleDrivingMode;

public class Extreme3D extends Controller {
	private Robot robot;
	
	public Extreme3D(Robot robot) {
		TOGGLE_DRIVETYPE = 11;
		RESET_GYRO = 12;
		
		TOTE_UP = 6;
		TOTE_DOWN = 4;
		RESET_TOTE_COUNT = 7;
		
		TOTE_IN = 5;
		TOTE_OUT = 3;
		
		this.robot = robot;
		
		bindKeys();
	}

	@Override
	public void bindKeys() {
		/*
		 * DriveTrain
		 */
		createButton(TOGGLE_DRIVETYPE).whenPressed(new ToggleDrivingMode(robot.getDriveTrain()));
		createButton(RESET_GYRO).whenPressed(new ResetGyro(robot.getDriveTrain()));
		
		/*
		 * Lifter
		 */
		createButton(TOTE_UP).whenPressed(new MoveTote(robot.getLifter(), LifterState.TOP));
		createButton(TOTE_DOWN).whenPressed(new MoveTote(robot.getLifter(), LifterState.BOTTOM));
		createButton(RESET_TOTE_COUNT).whenPressed(new ResetToteCount(robot.getLifter()));
		
		/*
		 * Rollers
		 */
		createButton(TOTE_IN).whenPressed(new MoveRoller(robot.getRoller(), RollerState.IN));
		getButton(TOTE_IN).whenReleased(new MoveRoller(robot.getRoller(), RollerState.STOP));
		
		createButton(TOTE_OUT).whenPressed(new MoveRoller(robot.getRoller(), RollerState.OUT));
		getButton(TOTE_OUT).whenReleased(new MoveRoller(robot.getRoller(), RollerState.STOP));
	}
	
}
