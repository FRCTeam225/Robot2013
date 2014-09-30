/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2013.commands.shooter;

import org.team225.robot2013.commands.CommandBase;

/**
 *
 * @author Andrew
 */
public class AutoTurret extends CommandBase {

    double offset = 0;
    public AutoTurret()
    {
        requires(turret);
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
        /*
        double setpoint = turret.getPosition();
        boolean hasTarget = SmartDashboard.getBoolean("hasTarget");
        if ( hasTarget )
        {
            offset = SmartDashboard.getNumber("cameraError")*1.1375;
            setpoint -= Math.floor(offset);
        }
        
        turret.setTurretSetpoint(setpoint);
        */
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        turret.setTurretMotor(0);
    }
    
}
