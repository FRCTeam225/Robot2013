/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2013.commands.drivetrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team225.robot2013.commands.CommandBase;

/**
 *
 * @author Andrew
 */
public class DriveDistance extends CommandBase {
    
    double distance;
    double err;
    double loopsStable = 0;
    public DriveDistance(double distance)
    {
        this.distance = distance;
        requires(drivetrain);
    }
    
    protected void initialize() {
        drivetrain.resetDistance();
        
    }

    protected void execute() { 
            err = distance-drivetrain.getDistance();
            double output = err*0.0008;
            
            drivetrain.set(output, output);
            
            if ( Math.abs(err) < 5 )
                loopsStable++;
            else 
                loopsStable = 0;
            
            System.out.println(err);
            SmartDashboard.putNumber("DriveError", output);
    }

    protected boolean isFinished() {
        return loopsStable > 30;
    }

    protected void end() {
        drivetrain.set(0,0);
    }
    
}
