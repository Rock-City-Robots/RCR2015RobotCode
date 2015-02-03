
package org.usfirst.frc.team4849.robot.commands;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4849.robot.Robot;

/**
 *
 */
public class SimpleAutoCommand extends Command {

	private RobotDrive robotDrive;
	private Timer timer;
	private Gyro gyro;
	
    public SimpleAutoCommand(RobotDrive drive, Gyro gyro) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.exampleSubsystem);
        this.robotDrive = drive;
        timer = new Timer();
        this.gyro = gyro;
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	robotDrive.mecanumDrive_Cartesian(1.0, 1.0, 0, this.gyro.getAngle());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.hasPeriodPassed(5.0);
    }

    // Called once after isFinished returns true
    protected void end() {
    	robotDrive.stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
