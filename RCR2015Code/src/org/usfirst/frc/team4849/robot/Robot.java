
package org.usfirst.frc.team4849.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team4849.robot.commands.ExampleCommand;
import org.usfirst.frc.team4849.robot.subsystems.ExampleSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	
	public static SpeedController rightfront = new Talon(0);
	public static SpeedController rightback = new Talon(1);
	public static SpeedController leftback = new Talon(2);
	public static SpeedController leftfront = new Talon(3);
	
	public static SpeedController roller1 = new Victor(4);
	public static SpeedController roller2 = new Victor(5);
	
	public static RobotDrive robotDrive = new RobotDrive(leftfront, leftback, rightfront, rightback);

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		robotDrive.setInvertedMotor(MotorType.kFrontRight, true);
		robotDrive.setInvertedMotor(MotorType.kRearRight, true);
        // instantiate the command used for the autonomous period
        autonomousCommand = new ExampleCommand();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }
    
    private boolean safezone(double a) {
    	return a < 0.1;
    }

    //This function alters the Joystick input
    private double curve(AxisType a, int pow) {
    	double b = OI.a.getAxis(a);
    	double c = b * -1;
    	if (b > c) {
    		if (safezone(b))
    			return 0;
    		//[minFrom..maxFrom] -> [minTo..maxTo]
    		//mappedValue = minTo + (maxTo - minTo) * ((value - minFrom) / (maxFrom - minFrom));
    		b = 0.0 + (1.0 - 0.0) * ((b - 0.1) / (1 - 0.1));
    		double o = b;
    		do {
    			o = o * b;
    			pow = pow - 1;
    		}while (pow != 0);
    		return b;
    	} else {
    		if (safezone(c))
    			return 0;
    		c = 0.0 + (1.0 - 0.0) * ((c - 0.1) / (1 - 0.1));
    		double o = c;
    		do {
    			o = o * c;
    			pow = pow - 1;
    		}while (pow != 0);
    		b = c * -1;
    		if (b > c)
    			return c;
    		return b;
    	}
    }
    
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	robotDrive.mecanumDrive_Cartesian(curve(AxisType.kX, 3), curve(AxisType.kY, 3), curve(AxisType.kZ, 1), 0);
        Scheduler.getInstance().run();
        if (oi.a.getTrigger()){
        	roller1.set(1);
        	roller2.set(1);
        } else {
        	roller1.set(0);
        	roller2.set(0);
        }
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
