package org.usfirst.frc.team4849.robot.commands;

import org.usfirst.frc.team4849.robot.subsystems.Lights;

import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.ControllerPower;
import edu.wpi.first.wpilibj.command.Command;

public class Light extends Command{

	
	private Lights light;
	
	@Override
	protected void initialize() {
		light = new Lights(0, 1, 200);
	}

	@Override
	protected void execute() {
		light.Light();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		light.end();
	}

	@Override
	protected void interrupted() {
		light.end();
	}
	
}
