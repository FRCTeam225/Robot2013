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
public class CenterShot2 extends CommandGroup {
    
    public CenterShot2()
    {
        addSequential(new SetAngle(false));
        addSequential(new SetFlywheel(0.01669+(5*0.0001))); // was 0.01669
        addSequential(new HoldTurretAtSetpoint(681)); // was 836
    }
}
