/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2013.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team225.robot2013.AndrewPID;
import org.team225.robot2013.RobotMap;
import org.team225.robot2013.commands.shooter.ManualTurret;

/**
 *
 * @author Andrew
 */
public class Turret extends Subsystem {
    
    Victor turretMotor = new Victor(RobotMap.SHOOTERTURRET);
    public AnalogChannel turretPot = new AnalogChannel(RobotMap.TURRET_POT);
    public static int TURRETOFFSET = -377; // Offset setpoints because of pot readjustment
    public boolean runPID = false;
    AndrewPID turretPID = new AndrewPID(0.0045, 0.003, 0.01);
    
    Relay shooterUp = new Relay(RobotMap.TURRETANGLE_A);
    Relay shooterDown = new Relay(RobotMap.TURRETANGLE_B);
    public Turret()
    {
        LiveWindow.addSensor("Turret", "Pot", turretPot);
        turretPID.setTarget(410);
        turretMotor.enableDeadbandElimination(true);
    }
    
    public void debug()
    {
        System.out.println(turretPID.getError());
    }
    
    public void setTurretMotor(double power)       
    {
        int current = turretPot.getAverageValue();
        runPID = false;
        turretMotor.set(power);
    }
    
    public void setTurretSetpoint(double setpoint)
    {
        setpoint += Turret.TURRETOFFSET;
        runPID = true;
        turretPID.setTarget(setpoint);
    }
    
    public double getSetpoint()
    {
        if ( !runPID )
            return 9999;
        return turretPID.getTarget();
    }
    
    public double getPosition()
    {
        return turretPot.getAverageValue();
    }
    
    public double getPositionAsSetpoint()
    {
        return getPosition()-TURRETOFFSET;
    }
    
    public boolean atSetpoint()
    {
        return Math.abs(turretPID.getError())<10;
    }
    
    public void setAngle(boolean up)
    {
        shooterUp.set((up?Relay.Value.kForward:Relay.Value.kOff));
        shooterDown.set((up?Relay.Value.kOff:Relay.Value.kForward));
    } 
    
    public void updatePID()
    {
        if(runPID)
            turretMotor.set(turretPID.calculate(turretPot.getAverageValue()));
        System.out.println(turretPID.getError());
    }
   
    protected void initDefaultCommand() {
        setDefaultCommand(new ManualTurret());
    }
}
