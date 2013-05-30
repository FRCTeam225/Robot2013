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
public class FarShot2Up extends CommandGroup {
    
    public FarShot2Up()
    {
        // plastidip 0.0208
        // ducktape 0.018
        addSequential(new SetAngle(true));
        addSequential(new SetFlywheel(0.0173, 1));
        addSequential(new HoldTurretAtSetpoint(808));
    }
}
