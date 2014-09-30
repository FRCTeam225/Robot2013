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
public class DemoShot extends CommandGroup {
    public DemoShot()
    {
        addSequential(new SetFlywheel(0.032, 1));  // old 0.017099
        addSequential(new SetAngle(false));
        addSequential(new HoldTurretAtSetpoint(565));
    }
}