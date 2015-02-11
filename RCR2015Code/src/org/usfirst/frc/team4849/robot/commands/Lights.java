package org.usfirst.frc.team4849.robot.commands;

import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.ControllerPower;
import edu.wpi.first.wpilibj.command.Command;

public class Lights extends Command{

	int i;
	double bat;
	double batOld;
	int x;
	double ii;
	AnalogOutput lighta = new AnalogOutput(1);
	AnalogOutput lightb = new AnalogOutput(0);
	
	@Override
	protected void initialize() {
		i = 0;
		bat = ControllerPower.getInputVoltage();
		x = 1;
	}

	@Override
	protected void execute() {
		batOld = bat;
		bat = ControllerPower.getInputVoltage();
		bat = (batOld - bat)/2 + batOld;
		if(i == 200 || i == 0)
			x = x * -1;
		i = i + x;
		bat = bat - 8;
		ii = i / 200;
		bat = 5 - bat;
		bat = bat * ii;
		lighta.setVoltage(5.0 - bat);
		lightb.setVoltage(5.0 - bat);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		lighta.setVoltage(5.0);
		lightb.setVoltage(5.0);
	}

	@Override
	protected void interrupted() {
		lighta.setVoltage(5.0);
		lightb.setVoltage(5.0);
	}
	
}
