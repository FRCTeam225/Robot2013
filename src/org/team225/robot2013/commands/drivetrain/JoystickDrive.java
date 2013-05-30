package org.team225.robot2013.commands.drivetrain;

import org.team225.robot2013.OI.OI;
import org.team225.robot2013.commands.CommandBase;

/**
 *
 * @author Andrew
 */
public class JoystickDrive extends CommandBase {
    boolean fullSpeed = false;
    public JoystickDrive() {
        requires(drivetrain);
        setInterruptible(true);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        drivetrain.setLocked(false);
        ledStrip.setRed();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        double speedL = OI.jsL.getY();
        double speedR = OI.jsR.getY();
        fullSpeed = OI.jsL.getTrigger()|| OI.jsR.getTrigger();
        
        if ( !fullSpeed )
        {
            speedL /= 2;
            speedR /= 2;
        }
        
        if ( Math.abs(speedL) < 0.05 )
            speedL = 0;
        
        if ( Math.abs(speedR) < 0.05 )
            speedR = 0;
        
        drivetrain.set(speedL, speedR);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        drivetrain.set(0, 0);
    }

}
