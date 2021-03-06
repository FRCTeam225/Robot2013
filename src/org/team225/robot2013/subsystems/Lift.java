package org.team225.robot2013.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.team225.robot2013.RobotMap;
import org.team225.robot2013.commands.lift.ManualHang;

/**
 *
 * @author Andrew
 */
public class Lift extends Subsystem {
    Victor winchMotor = new Victor(RobotMap.HANGWINCH);
    public Lift()
    {
        LiveWindow.addActuator("Lift", "Winch", winchMotor);
    }

    
    public void setWinch(double value)
    {
        winchMotor.set(value);
    }
    
    protected void initDefaultCommand() {
        setDefaultCommand(new ManualHang());
    }
    
}
