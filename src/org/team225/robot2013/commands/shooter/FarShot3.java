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
public class FarShot3 extends CommandGroup {
    
    public FarShot3()
    {
        addSequential(new SetAngle(false));
        addSequential(new SetFlywheel(0.0154799, 1));
        addSequential(new HoldTurretAtSetpoint(416));
    }
}
