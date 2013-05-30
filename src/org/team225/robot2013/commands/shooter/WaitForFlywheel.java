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
public class WaitForFlywheel extends CommandBase {
    
    public WaitForFlywheel()
    {
        requires(shooter);
        setTimeout(2.0);
    }
    
    protected void initialize() {
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return shooter.atSetpoint() || isTimedOut();
    }

    protected void end() {
    }
    
}
