/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2013.commands.shooter;

import edu.wpi.first.wpilibj.Timer;
import org.team225.robot2013.commands.CommandBase;

/**
 *
 * @author ben
 */
public class FeedFrisbee extends CommandBase {
    
    public FeedFrisbee() {
        requires(feeder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        feeder.feed();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !feeder.isFeeding();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

}
