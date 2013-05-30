package org.team225.robot2013.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.team225.robot2013.RobotMap;
import org.team225.robot2013.commands.drivetrain.JoystickDrive;

/**
 *
 * @author Andrew
 */
public class Drivetrain extends Subsystem {

        
    Victor driveL1 = new Victor(RobotMap.LEFTDRIVE1);
    Victor driveL2 = new Victor(RobotMap.LEFTDRIVE2);
    Victor driveL3 = new Victor(RobotMap.LEFTDRIVE3);
    
    Victor driveR1 = new Victor(RobotMap.RIGHTDRIVE1);
    Victor driveR2 = new Victor(RobotMap.RIGHTDRIVE2);
    Victor driveR3 = new Victor(RobotMap.RIGHTDRIVE3);
    
    DoubleSolenoid driveLock = new DoubleSolenoid(RobotMap.DRIVELOCK_A, RobotMap.DRIVELOCK_B);
    
    //Gyro gyro = new Gyro(RobotMap.GYRO);
    
    public Drivetrain()
    {
        LiveWindow.addActuator("Drivetrain", "Left Drive 1", driveL1);
        LiveWindow.addActuator("Drivetrain", "Left Drive 2", driveL2);
        LiveWindow.addActuator("Drivetrain", "Left Drive 3", driveL3);
        
        LiveWindow.addActuator("Drivetrain", "Right Drive 1", driveR1);
        LiveWindow.addActuator("Drivetrain", "Right Drive 2", driveR2);
        LiveWindow.addActuator("Drivetrain", "Right Drive 3", driveR3);
        setLocked(false);
    }
    
    protected void initDefaultCommand() {
        setDefaultCommand(new JoystickDrive());
    }
    
    public void set(double left, double right)
    {
        driveL1.set(left);
        driveL2.set(left);
        driveL3.set(left);
        
        driveR1.set(-right);
        driveR2.set(-right);
        driveR3.set(-right);
        
    }
    
    public void drive(double magnitude, double turn)
    {
        double left = magnitude;
        double right = magnitude;
        
        if ( turn > 0 )
            left += turn;
        else if ( turn < 0 )
            right += turn;
        set(left, right);
    }
    
    public void setLocked(boolean state)
    {
        driveLock.set(state?DoubleSolenoid.Value.kForward:DoubleSolenoid.Value.kReverse);
    }
    
    public double getAngle()
    {
        return 0;
    }
    
    public void resetAngle()
    {
        //gyro.reset();
    }
    
}
