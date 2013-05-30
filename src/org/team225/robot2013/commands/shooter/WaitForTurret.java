/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2013.commands.shooter;

import org.team225.robot2013.commands.CommandBase;

/**
 *
 * @author Andrew
 */
public class WaitForTurret extends CommandBase {
    public int loopsStable = 0;
    public WaitForTurret()
    {
        requires(turret);
        setTimeout(10);
    }
    
    
    protected void initialize() {
    }

    protected void execute() {
        if ( turret.atSetpoint() )
            loopsStable++;
        else 
            loopsStable = 0;
    }

    protected boolean isFinished() {
        return loopsStable>50||isTimedOut();
    }

    protected void end() {
    }
    
}
