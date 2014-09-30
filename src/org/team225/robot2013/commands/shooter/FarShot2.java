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
public class FarShot2 extends CommandGroup {
    
    public FarShot2()
    {
        addSequential(new SetAngle(false));
        addSequential(new SetFlywheel(0.015889, 0.5));
        addSequential(new HoldTurretAtSetpoint(397));
    }
}
