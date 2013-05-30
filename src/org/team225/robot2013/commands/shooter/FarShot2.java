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
        
        // old
        //addSequential(new SetFlywheel(0.01659, 1)); // was 0.01629+(2*0.0001
        //addSequential(new HoldTurretAtSetpoint(822)); // was 836
        
        
        addSequential(new SetFlywheel(0.01669, 1));
        addSequential(new HoldTurretAtSetpoint(808)); // new 447+377
    }
}
