/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2013.OI;

import org.team225.robot2013.commands.CommandBase;

/**
 *
 * @author Andrew
 */
public class BumpDownShooter extends CommandBase {
    public BumpDownShooter()
    {
        requires(shooter);
    }

    protected void initialize() {
        shooter.setWheelSetpoint(shooter.getWheelSetpoint()+0.0001);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return !OI.jsOperator.getRawButton(OI.BUMPDWNBTN);
    }

    protected void end() {
    }
   
}
