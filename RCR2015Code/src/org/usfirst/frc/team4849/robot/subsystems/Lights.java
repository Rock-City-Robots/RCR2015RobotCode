package org.usfirst.frc.team4849.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.ControllerPower;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lights extends Subsystem {
	int increment;
	double voltage;
	double voltageOld;
	int direction;
	double percent;
	int incrementValue;
	AnalogOutput lighta;
	AnalogOutput lightb;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public Lights(int a, int b, int incV) {
		lighta = new AnalogOutput(a);
		lightb = new AnalogOutput(b);
		incrementValue = incV;
		increment = 0;
		direction = 0;
		voltage = ControllerPower.getInputVoltage();
	}
	
	public void end() {
		lighta.setVoltage(5.0);
		lightb.setVoltage(5.0);
	}
	
	public void Light() {
		voltageOld = voltage;
		voltage = ControllerPower.getInputVoltage();
		voltage = (voltageOld - voltage)/2 + voltageOld;
		if(increment == incrementValue || increment == 0)
			direction = direction * -1;
		increment = increment + direction;
		voltage = voltage - 8;
		percent = increment / 200;
		voltage = 5 - voltage;
		voltage = voltage * percent;
		lighta.setVoltage(5.0 - voltage);
		lightb.setVoltage(5.0 - voltage);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

