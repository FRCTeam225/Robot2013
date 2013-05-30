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
public class MurderShot extends CommandGroup {
    
    public MurderShot()
    {
        addSequential(new SetFlywheel(0)); // Full speed
    }
}
