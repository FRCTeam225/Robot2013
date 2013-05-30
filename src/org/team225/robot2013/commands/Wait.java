/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2013.commands;

/**
 *
 * @author Andrew
 */
public class Wait extends CommandBase {

    public Wait(double time)
    {
        setTimeout(time);
    }
    
    protected void initialize() {
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    }
    
}
