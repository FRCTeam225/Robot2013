/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2013.commands.lift;

import org.team225.robot2013.OI.OI;
import org.team225.robot2013.commands.CommandBase;

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
        boolean winchDown = (OI.jsL.getRawButton(10)||OI.jsR.getRawButton(10));
        boolean winchUp = (OI.jsL.getRawButton(11)||OI.jsR.getRawButton(11))&&winchDown;

        if ( winchUp && winchDown )
            lift.setWinch(0.5);
        else if ( winchDown )
            lift.setWinch(-1.0);
        else
            lift.setWinch(0.0); 
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        lift.setWinch(0.0);
    }
    
}
