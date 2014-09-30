/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2013.subsystems;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DriverStation;
import org.team225.robot2013.RobotMap;
import org.team225.robot2013.commands.CommandBase;

/**
 *
 * @author Andrew
 */
public class TurretLEDStrip {
    public DigitalOutput ledControl = new DigitalOutput(RobotMap.LEDCONTROL);
    
    public TurretLEDStrip()
    {
        
    }
    
    public void setFireballs()
    {
        ledControl.set(true);
    }
    
    public void setDriving()
    {
        ledControl.set(false);
    }
    
    public void setTurretLEDState(boolean state)
    {
        ledControl.set(state);
    }
    
}
