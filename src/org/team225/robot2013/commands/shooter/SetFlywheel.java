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
public class SetFlywheel extends CommandBase {
    double setpoint = Double.POSITIVE_INFINITY;
    public SetFlywheel(double setpoint)
    {
        this.setpoint = setpoint;
        requires(shooter);
        shooter.setAllowedPercentError(20);
    }
    
    public SetFlywheel(double setpoint, double allowedPercError)
    {
        this(setpoint);
        shooter.setAllowedPercentError(allowedPercError);
    }

    protected void initialize() {
        shooter.setWheelSetpoint(setpoint);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }
}
