/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2013.commands.shooter;

/**
 *
 * @author Andrew
 */
public class HoldTurretAtSetpoint extends SetTurret {
    public HoldTurretAtSetpoint(int target)
    {
        super(target);
    }
    
    public boolean isFinished()
    {
        return false;
    }
}
