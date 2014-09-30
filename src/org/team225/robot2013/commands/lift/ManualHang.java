/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2013.commands.lift;

import org.team225.robot2013.OI.OI;
import org.team225.robot2013.commands.CommandBase;
import org.team225.robot2013.subsystems.LEDStrip;
import org.team225.robot2013.subsystems.TurretLEDStrip;

/**
 *
 * @author Andrew
 */
public class ManualHang extends CommandBase {

    public ManualHang()
    {
        requires(lift);
    }
    
    protected void initialize() {
    }

    protected void execute() {
        
        boolean winchDown = (OI.js.getRawButton(1));
        boolean winchUp = (OI.js.getRawButton(2))&&winchDown;
        if ( winchUp && winchDown )
        {
            lift.setWinch(0.5);
        }
        else if ( winchDown )
            lift.setWinch(-1.0);
        else
        {
            lift.setWinch(0.0); 
        }
    }
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        lift.setWinch(0.0);
    }
    
}
