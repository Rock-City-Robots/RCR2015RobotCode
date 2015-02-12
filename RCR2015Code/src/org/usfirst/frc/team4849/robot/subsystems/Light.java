package org.usfirst.frc.team4849.robot.subsystems;

import org.usfirst.frc.team4849.robot.RobotMap;
import org.usfirst.frc.team4849.robot.commands.PulseBattery;

import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.ControllerPower;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Light extends Subsystem {
	private int increment = 0;
	private int direction = 1;
	private int incrementValue = 200;
	private double maxVoltage = 5.0;
	private double voltage, voltageOld, percent;
	
	private AnalogOutput light = new AnalogOutput(RobotMap.LIGHTS_BATTERY);

	public Light() {
		voltage = ControllerPower.getInputVoltage();
		
		setDefaultCommand(new PulseBattery(this));
	}
	
	public void end() {
		light.setVoltage(maxVoltage);
	}
	
	public void pulse() {
		voltageOld = voltage;
		voltage = ControllerPower.getInputVoltage();
		voltage = (voltageOld - voltage)/2 + voltageOld;
		
		if(increment == incrementValue || increment == 0) direction = direction * -1;
		
		increment = increment + direction;
		voltage = voltage - 8;
		percent = increment / incrementValue;
		voltage = 5 - voltage;
		voltage = voltage * percent;
		
		light.setVoltage(maxVoltage - voltage);
	}
	
    public void initDefaultCommand() {

    }
}

