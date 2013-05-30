/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2013.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.team225.robot2013.RobotMap;
import org.team225.robot2013.commands.AutomaticCompressor;

/**
 *
 * @author Andrew
 */
public class Compressor extends Subsystem {
    DigitalInput pressureSwitch = new DigitalInput(RobotMap.PRESSURE_SWITCH);
    Relay compressor = new Relay(RobotMap.COMPRESSOR);
    
    public Compressor()
    {
        LiveWindow.addActuator("Penumatics", "Compressor", compressor);
        LiveWindow.addSensor("Pneumatics", "Pressure", pressureSwitch);
    }
    
    public void update()
    {
        compressor.set(pressureSwitch.get()?Relay.Value.kOff:Relay.Value.kForward);
    }
    
    public void setCompressor(boolean state)
    {
        compressor.set(state?Relay.Value.kForward:Relay.Value.kOff);
    }
    
    public boolean getPressureSwitch()
    {
        return pressureSwitch.get();
    }
    
    protected void initDefaultCommand() {
        setDefaultCommand(new AutomaticCompressor());
    }
}
