/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2013.subsystems;

import edu.wpi.first.wpilibj.DigitalModule;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Relay;
import org.team225.robot2013.RobotMap;

/**
 *
 * @author Andrew
 */
public class LEDStrip {
    Relay led = new Relay(8);
    
    public LEDStrip()
    {
    }
   
    public void setRed()
    {
        led.set(Relay.Value.kReverse);
    }
    
    public void setGreen()
    {
        led.set(Relay.Value.kForward);
    }
    
    public void setYellow()
    {
        led.set(Relay.Value.kOff);
    }
    
    public void setOff()
    {
        led.set(Relay.Value.kOn);
    }
}
