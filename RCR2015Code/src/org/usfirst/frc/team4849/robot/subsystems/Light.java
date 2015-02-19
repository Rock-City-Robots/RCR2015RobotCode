package org.usfirst.frc.team4849.robot.subsystems;

import org.usfirst.frc.team4849.robot.RobotMap;
import org.usfirst.frc.team4849.robot.commands.ChangeBatteryLevel;

import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.ControllerPower;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Light extends Subsystem {
	private int increment = 1;
	private int direction = 1;
	private int incrementValue = 1000;
	
	private double maxVoltage = 5.0;
	private double minVoltage = 0.2;
	private double xSpeed = 0;
	private double ySpeed = 0;
	
	private double voltage, voltageOld, percent, speed;
	
	private AnalogOutput light = new AnalogOutput(RobotMap.LIGHTS_BATTERY);

	public Light() {
		voltage = ControllerPower.getInputVoltage();
		
		setDefaultCommand(new ChangeBatteryLevel(this));
	}
	
	public void end() {
		light.setVoltage(minVoltage);
	}
	
	public void changeLightLevel() {
		speed = Math.pow(Math.pow(xSpeed, 2) + Math.pow(ySpeed, 2), 0.5);
		speed = 1.0 + (0.5 - 1.0) * ((speed - 0.0) / (1.0 - 0.0));
		
		voltageOld = voltage;
		voltage = ControllerPower.getInputVoltage();
		voltage = (voltageOld - voltage)/2 + voltageOld;
		
		if(increment == incrementValue || increment == 0) direction *= -1;
		
		increment += direction;
		voltage -= 8;
		maxVoltage *= speed;
		
		if(voltage < minVoltage) voltage = minVoltage;
		else if(voltage > maxVoltage) voltage = maxVoltage;
		
		percent = increment / incrementValue;
		voltage = maxVoltage - voltage;
		voltage *= percent;
		
		
		light.setVoltage(maxVoltage - voltage);
		maxVoltage = 5.0;
	}
	
    public void initDefaultCommand() {

    }
    
    public void update(AxisType a, double b) {
    	if(a.equals(AxisType.kX)) xSpeed = b;
    	else if(a == AxisType.kY) ySpeed = b;
    }
}

