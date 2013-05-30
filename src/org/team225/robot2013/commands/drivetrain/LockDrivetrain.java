/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2013.commands.drivetrain;

import org.team225.robot2013.OI.OI;
import org.team225.robot2013.commands.CommandBase;

/**
 *
 * @author Andrew
 */
public class LockDrivetrain extends CommandBase {

    public LockDrivetrain()
    {
        requires(drivetrain);
        setInterruptible(true);
    }
    
    protected void initialize() {
        drivetrain.set(0, 0);
        drivetrain.setLocked(true);
        ledStrip.setGreen();
    }

    protected void execute() {
        drivetrain.set(0, 0);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        drivetrain.setLocked(false);
    }
    
}
