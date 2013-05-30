/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2013.commands.drivetrain;

import edu.wpi.first.wpilibj.Timer;
import org.team225.robot2013.commands.CommandBase;

/**
 *
 * @author Andrew
 */
public class DriveForTime extends CommandBase {
    boolean reverse = false;
    double time = 0;
    double turn = 0;
    Timer timer = new Timer();
    double lockAngle = 0;
    public DriveForTime(double time, double turn)
    {
        requires(drivetrain);
        this.time = time;
        this.turn = turn;
        reverse = false;
        timer.stop();
        timer.reset();
        if ( time < 0 )
        {
            reverse = true;
            this.time = Math.abs(time);
        }   
    }
    
    public DriveForTime(double time)
    {
        this(time, 0);
    }

    protected void initialize() {
        timer.reset();
        timer.start();
    }

    protected void execute() {
        if ( reverse )
            drivetrain.drive(0.5,turn);
        else
            drivetrain.drive(-0.5,turn);
    }

    protected boolean isFinished() {
        return timer.get() > time;
    }

    protected void end() {
        timer.stop();
        timer.reset();
        drivetrain.set(0.0,0.0);
    }
}
