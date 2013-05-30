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
public class CloseShot extends CommandGroup {
    public CloseShot()
    {
        addSequential(new SetFlywheel(0.017099, 0.007));  // old 0.017099
        addSequential(new SetAngle(true));
        addSequential(new HoldTurretAtSetpoint(699));
    }
}
