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
public class CheesyDrive extends CommandBase {
    
    double turn_gain = 1.1;
    double skim_gain = 0.5;//0.4; // was 0.5
    double turn_velocity_multiplier_gain = 0.85;
    double quickStopAccumulator = 0;
    
    public CheesyDrive()
    {
        requires(drivetrain);
    }
    
    protected void initialize() {
    }

    protected void execute() {
        //drivetrain.setMotorSpeeds(OI.driver.getY(), OI.driverLeft.getY());
        
        
        double throttle = OI.js.getRawAxis(2);
        double turnInput = OI.js.getRawAxis(3);
        double wheelNonLinearity = 0.5;
        turnInput = Math.sin((Math.PI/2)*wheelNonLinearity*turnInput)/Math.sin((Math.PI/2)*wheelNonLinearity);
        turnInput = Math.sin((Math.PI/2)*wheelNonLinearity*turnInput)/Math.sin((Math.PI/2)*wheelNonLinearity);
        turnInput = Math.sin((Math.PI/2)*wheelNonLinearity*turnInput)/Math.sin((Math.PI/2)*wheelNonLinearity);
        
        if ( Math.abs(turnInput) < 0.07 )
            turnInput = 0;
        
        double turn = 0;
        if ( Math.abs(throttle) < 0.07 )
        {
            throttle = 0;
            turn = turnInput;
        }
        else
            turn = (turnInput*turn_gain)*Math.abs(turn_velocity_multiplier_gain*OI.js.getRawAxis(2));
        
        double left_orig = throttle-turn;
        double right_orig = throttle+turn;

        double left = left_orig+ skim(right_orig);
        double right = right_orig+skim(left_orig);

        drivetrain.set(left, right);
        
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        drivetrain.set(0, 0);
    }
    
    private double skim(double v) {
        if (v > 1.0)
            return -((v - 1.0) * skim_gain);
        else if (v < -1.0)
            return -((v + 1.0) * skim_gain);
        return 0;
    }
}
