package org.usfirst.frc.team4849.robot.commands;

import org.usfirst.frc.team4849.robot.OI;
import org.usfirst.frc.team4849.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Command;

public class DriveWithCubicJoystick extends Command{
	private DriveTrain driveTrain;
	private static int arc = 3;
	
	public DriveWithCubicJoystick(DriveTrain driveTrain) {
		requires(driveTrain);
		this.driveTrain = driveTrain;
	}
	
	@Override
	protected void end() {
	}

	@Override
	protected void execute() {
		driveTrain.drive(OI.cubicJoystick.getValue(AxisType.kX, arc), OI.cubicJoystick.getValue(AxisType.kY, arc), OI.cubicJoystick.getValue(AxisType.kZ, arc));
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void interrupted() {
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

}
