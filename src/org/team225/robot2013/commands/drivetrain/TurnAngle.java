/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2013.commands.drivetrain;

import org.team225.robot2013.commands.CommandBase;

/**
 *
 * @author Andrew
 */
public class TurnAngle extends CommandBase {
    double angle = 0;
    double error = 0;
    public TurnAngle(double targetAngle)
    {
        angle = targetAngle;
    }
    
    
    protected void initialize() {
        drivetrain.resetAngle();
    }

    protected void execute() {
        error = (angle-drivetrain.getAngle());
        double mPower = error*0.001;
        if ( mPower > 50 )
            mPower = 50;
        else if ( mPower < -50 )
            mPower = -50;
        drivetrain.set(-mPower, mPower);
    }

    protected boolean isFinished() {
        return error < 5;
    }

    protected void end() {
    }
    
}
