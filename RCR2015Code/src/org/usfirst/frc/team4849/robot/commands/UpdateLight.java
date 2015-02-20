package org.usfirst.frc.team4849.robot.commands;

import org.usfirst.frc.team4849.robot.subsystems.Light;

import edu.wpi.first.wpilibj.command.Command;

public class UpdateLight extends Command{
	private Light light;
	
	private boolean end = false;
	
	public UpdateLight(Light light) {
		requires(light);
		this.light = light;
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		light.update();
	}

	@Override
	protected boolean isFinished() {
		return end;
	}

	@Override
	protected void end() {
		end = true;
		light.end();
	}

	@Override
	protected void interrupted() {
		end();
	}
	
}
