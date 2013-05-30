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
public class SetAngle extends CommandBase {

    boolean isUp = false;
    public SetAngle(boolean up)
    {
        isUp = up;
        requires(turret);
    }
    
    protected void initialize() {
        turret.setAngle(isUp);
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }
    
}
