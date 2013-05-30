package org.team225.robot2013.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.team225.robot2013.OI.WrenBox;
import org.team225.robot2013.RobotMap;

/**
 *
 * @author Andrew
 */
public class Shooter extends Subsystem implements Runnable {
    Counter wheelSpeed = new Counter(RobotMap.SHOOTERSPEEDSENSOR);
    Victor wheelMotor = new Victor(RobotMap.SHOOTERWHEEL);
    private double setpoint = Double.POSITIVE_INFINITY;
    private double rate = 0;
    private double percentError = 0;
    private double minPercentError = 20.0;
    
    public Shooter()
    {
        wheelSpeed.start();
        
        LiveWindow.addActuator("Shooter", "Wheel", wheelMotor);
        new Thread(this).start();
    }
    
    public void setWheelSetpoint(double setpoint)
    {
        this.setpoint = setpoint;
    }

    public double getWheelSetpoint()
    {
        return setpoint;
    }
    
    protected void initDefaultCommand() {
    }
    
    public void setAllowedPercentError(double perc)
    {
        minPercentError = perc;
    }
    
    public boolean atSetpoint()
    {
        return percentError < minPercentError;
    }
    
    public double getErrorPrecent()
    {
        if ( Double.isInfinite(percentError) || Double.isNaN(percentError) )
            return 0;
        return percentError;
    }
    
    public double getPeriod()
    {
        return rate;
    }

    public void run() 
    {
        while ( true )
        {
                rate = wheelSpeed.getPeriod();
                percentError = (Math.abs(rate-setpoint)/setpoint)*100;
                WrenBox.setShooterReadyLED(percentError < 1.5);
                if ( setpoint != Double.POSITIVE_INFINITY && (WrenBox.shooterEnabled() || DriverStation.getInstance().isAutonomous()) )
                    wheelMotor.set(rate > setpoint?1.0:0.4); 
                else
                    wheelMotor.set(0);
        }
    }
    
}
