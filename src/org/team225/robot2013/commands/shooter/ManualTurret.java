/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2013.commands.shooter;

import org.team225.robot2013.OI.OI;
import org.team225.robot2013.OI.WrenBox;
import org.team225.robot2013.commands.CommandBase;

/**
 *
 * @author Andrew
 */
public class ManualTurret extends CommandBase {

    public ManualTurret()
    {
        requires(turret);
    }
    
    protected void initialize() {
        WrenBox.setTurretLockedLED(false);
    }

    protected void execute() {
        double value = OI.jsOperator.getRawAxis(5);
        if ( value > 0.2 )
            value = 0.16;
        else if ( value < -0.2 )
            value = -0.16;
        turret.setTurretMotor(value);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        turret.setTurretMotor(0);
    }
    
}
