package org.usfirst.frc.team4849.robot.commands;

import org.usfirst.frc.team4849.robot.subsystems.Light;

import edu.wpi.first.wpilibj.command.Command;

public class PulseBattery extends Command{

	
	private Light light;
	
	public PulseBattery(Light light) {
		requires(light);
		this.light = light;
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		light.pulse();
	}

	@Override
	protected boolean isFinished() {
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
