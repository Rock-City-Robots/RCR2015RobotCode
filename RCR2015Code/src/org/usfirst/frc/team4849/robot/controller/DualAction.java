package org.usfirst.frc.team4849.robot.controller;

import org.usfirst.frc.team4849.robot.Robot;
import org.usfirst.frc.team4849.robot.commands.LifterState;
import org.usfirst.frc.team4849.robot.commands.MoveRoller;
import org.usfirst.frc.team4849.robot.commands.MoveTote;
import org.usfirst.frc.team4849.robot.commands.ResetGyro;
import org.usfirst.frc.team4849.robot.commands.RollerState;
import org.usfirst.frc.team4849.robot.commands.ToggleDrivingMode;

import edu.wpi.first.wpilibj.Joystick.AxisType;

public class DualAction extends Controller {
//
	public DualAction(Robot robot) {
		super(robot);

		TOGGLE_DRIVETYPE = 6;
		RESET_GYRO = 5;
		
		TOTE_UP = 1;
		TOTE_DOWN = 2;
		DRIVE_MODE = 7;
		
		TOTE_IN = 3;
		TOTE_OUT = 4;
	}
	
	@Override
	public double getAxis(AxisType Axis) {
		if(Axis == AxisType.kX) {
			return Robot.getController().getController().getRawAxis(0);
		}else if(Axis == AxisType.kY)
			return Robot.getController().getController().getRawAxis(1);
		else if(Axis == AxisType.kZ)
			return Robot.getController().getController().getRawAxis(4);
		else
			return Robot.getController().getController().getAxis(Axis);
	}
	
	@Override
	public void bindKeys() {
		/*
		 * DriveTrain
		 */
		createButton(TOGGLE_DRIVETYPE).whenPressed(new ToggleDrivingMode(getRobot().getDriveTrain()));
		createButton(RESET_GYRO).whenPressed(new ResetGyro(getRobot().getDriveTrain()));
		
		/*
		 * Lifter
		 */
		createButton(TOTE_UP).whenPressed(new MoveTote(getRobot().getLifter(), LifterState.TOP));
		createButton(TOTE_DOWN).whenPressed(new MoveTote(getRobot().getLifter(), LifterState.BOTTOM));
		createButton(DRIVE_MODE).whenPressed(new MoveTote(getRobot().getLifter(), LifterState.DRIVE));
		
		/*
		 * Rollers
		 */
		createButton(TOTE_IN).whenPressed(new MoveRoller(getRobot().getRoller(), RollerState.IN));
		getButton(TOTE_IN).whenReleased(new MoveRoller(getRobot().getRoller(), RollerState.STOP));
		
		createButton(TOTE_OUT).whenPressed(new MoveRoller(getRobot().getRoller(), RollerState.OUT));
		getButton(TOTE_OUT).whenReleased(new MoveRoller(getRobot().getRoller(), RollerState.STOP));
	}

}
