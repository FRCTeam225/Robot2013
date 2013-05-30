/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2013.commands.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team225.robot2013.OI.WrenBox;
import org.team225.robot2013.commands.CommandBase;
import org.team225.robot2013.subsystems.Turret;

/**
 *
 * @author Andrew
 */
public class HoldTurret extends CommandBase {

    public HoldTurret()
    {
        requires(turret);
    }
    
    protected void initialize() {
        turret.setTurretSetpoint(turret.getPositionAsSetpoint());
        WrenBox.setTurretLockedLED(true);
    }

    protected void execute() {
        SmartDashboard.putNumber("Turret Pot", turret.turretPot.getAverageValue());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }
    
}
