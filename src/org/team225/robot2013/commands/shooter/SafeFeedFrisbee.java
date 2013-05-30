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
public class SafeFeedFrisbee extends CommandGroup {
    public SafeFeedFrisbee()
    {
        addSequential(new WaitForFlywheel());
        addSequential(new FeedFrisbee());
    }
}
