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
public class CrossCourt2 extends CommandGroup {
    
    public CrossCourt2()
    {
        // plastidip 0.0208
        // ducktape 0.018
        addSequential(new SetAngle(false));
        addSequential(new SetFlywheel(0.016489));
        addSequential(new HoldTurretAtSetpoint(800));
    }
}
