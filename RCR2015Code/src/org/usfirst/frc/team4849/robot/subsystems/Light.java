package org.usfirst.frc.team4849.robot.subsystems;

import org.usfirst.frc.team4849.robot.Robot;
import org.usfirst.frc.team4849.robot.RobotMap;
import org.usfirst.frc.team4849.robot.commands.UpdateLight;

import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Light extends Subsystem {
	private double maxTickIncrement = 0.5;
	private double maxVoltage = 5.0;
	private double minVoltage = 0.4;
	private double voltage = getFilteredVoltage(minVoltage);
	
	private AnalogOutput light = new AnalogOutput(RobotMap.LIGHT);
	private Robot robot;

	public Light(Robot robot) {
		this.robot = robot;
		
		light.setVoltage(getUnfilteredVoltage(voltage));
		setDefaultCommand(new UpdateLight(this));
	}
	
	public void update() {
		
		if(getGlobalVoltage() > voltage) {
			if(voltage < getFilteredVoltage(maxVoltage)) voltage += maxTickIncrement;
			else voltage = getFilteredVoltage(maxVoltage);
			
		}
		
		else if(getGlobalVoltage() < voltage) {
			if(voltage > getFilteredVoltage(minVoltage)) voltage -= maxTickIncrement;
			else voltage = getFilteredVoltage(minVoltage);
			
		}
		
		light.setVoltage(getUnfilteredVoltage(voltage));
		
	}
	
	private double getFilteredVoltage(double rawVoltage) {
		return rawVoltage / maxVoltage;
	}
	
	private double getUnfilteredVoltage(double voltage) {
		return voltage * maxVoltage;
	}
    
    private double getGlobalVoltage() {
    	double globalVoltage = 0;
    	
    	globalVoltage += robot.getDriveTrain().getLightOutput() * 0.7;
    	globalVoltage += robot.getLifter().getLightOutput() * 0.2;
    	globalVoltage += robot.getRoller().getLightOutput() * 0.1;
    	
    	return globalVoltage;
    }
    
	public void end() {
		light.setVoltage(minVoltage);
	}

	@Override
	protected void initDefaultCommand() {
	}
	
}

