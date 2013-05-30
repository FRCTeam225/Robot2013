/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2013.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.team225.robot2013.commands.LEDSet;
import org.team225.robot2013.commands.drivetrain.DriveForTime;
import org.team225.robot2013.commands.shooter.FeedFrisbee;
import org.team225.robot2013.commands.shooter.HoldTurretAtSetpoint;
import org.team225.robot2013.commands.shooter.SafeFeedFrisbee;
import org.team225.robot2013.commands.shooter.SetAngle;
import org.team225.robot2013.commands.shooter.SetFlywheel;
import org.team225.robot2013.commands.shooter.SetTurret;
import org.team225.robot2013.commands.shooter.StowShooter;
import org.team225.robot2013.commands.shooter.WaitForTurret;

/**
 *
 * @author Andrew
 */
public class RightSideShootAndBackup extends CommandGroup {
    public RightSideShootAndBackup()
    {
        addSequential(new SetFlywheel(0.017099, 0.007)); 
        addSequential(new SetAngle(true));
        addSequential(new SetTurret(699));
        addParallel(new HoldTurretAtSetpoint(699));
        addSequential(new WaitForTurret());
        
        addSequential(new LEDSet(LEDSet.GREEN));
        
        addSequential(new SafeFeedFrisbee());
        addSequential(new WaitCommand(1.0));
        addSequential(new SafeFeedFrisbee());
        addSequential(new WaitCommand(1.0));
        addSequential(new SafeFeedFrisbee());
        addSequential(new WaitCommand(1.0));
        addSequential(new SafeFeedFrisbee());
        addSequential(new WaitCommand(1.0));
        addSequential(new SafeFeedFrisbee());
        addSequential(new SafeFeedFrisbee());
        addSequential(new SafeFeedFrisbee());
        
        addSequential(new LEDSet(LEDSet.RED));
        
        addParallel(new StowShooter());

        addSequential(new DriveForTime(-1.3, 0));
        
        
        //addSequential(new DriveForTime(0.2,0.2));
    }
}
