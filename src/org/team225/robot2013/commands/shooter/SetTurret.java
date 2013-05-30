/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2013.commands.shooter;

import org.team225.robot2013.OI.WrenBox;
import org.team225.robot2013.commands.CommandBase;

/**
 *
 * @author Andrew
 */
public class SetTurret extends CommandBase {

    double position;
    public SetTurret(int position) {
        requires(turret);
        this.position = position;
    }

    protected void initialize() {
        turret.setTurretSetpoint(position);
        WrenBox.setTurretLockedLED(true);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }
    
}
