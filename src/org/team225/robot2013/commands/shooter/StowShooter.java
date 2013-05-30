/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2013.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Andrew
 */
public class StowShooter extends CommandGroup {
    public StowShooter()
    {
        addSequential(new SetAngle(false));
        addSequential(new SetFlywheel(Double.POSITIVE_INFINITY));
        addSequential(new HoldTurretAtSetpoint(925));
        
    }
}
