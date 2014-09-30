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
public class AroundShot extends CommandGroup {
    public AroundShot()
    {
        addSequential(new SetAngle(false));
        addSequential(new SetFlywheel(0.01788+(-0.0001*7), 1));
        addSequential(new HoldTurretAtSetpoint(570));
    }
}
