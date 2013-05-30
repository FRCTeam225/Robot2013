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
public class UnjamFeeder extends CommandBase {

    public UnjamFeeder()
    {
        requires(feeder);
    }
    
    protected void initialize() {
       feeder.unJam();
    }

    protected void execute() { 
    }

    protected boolean isFinished() {
        return !feeder.isFeeding();
    }

    protected void end() {
    }
    
}
