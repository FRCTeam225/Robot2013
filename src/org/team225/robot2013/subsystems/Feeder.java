/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2013.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.team225.robot2013.RobotMap;


/**
 *
 * @author ben
 */
public class Feeder extends Subsystem implements Runnable {    
    Victor feedMotor = new Victor(RobotMap.SHOOTERFEED);
    DigitalInput home = new DigitalInput(RobotMap.FEEDERHOMESWITCH);
    Thread watcherThread = null;
    
    
    int feederState = 0;
    
    public Feeder()
    {
        watcherThread = new Thread(this);
        //watcherThread.setPriority(Thread.NORM_PRIORITY+1);
        watcherThread.start();
        LiveWindow.addActuator("Feeder", "Motor", feedMotor);
        LiveWindow.addSensor("Feeder", "Home", home);
    }
    
    public DigitalInput getHomeObject()
    {
        return home;
    }

    public boolean isFeeding()
    {
        return feederState != 0;
    }
    
    public void feed()
    {
        feederState = 1;
    }
    
    public void unJam()
    {
        feederState = -1;
    }
    
    public void setMotorPower( boolean state ){
        
        feedMotor.set((state?0.5:0.0));
    }
    
    public void setReversedMotorPower( boolean state ){
        feedMotor.set((state?-1.0:0.0));
    }
    
    public void initDefaultCommand() {
    }

    public void run() 
    {
        Timer t = new Timer();
        t.stop();
        t.reset();
        while ( true )
        {
            try {
                switch ( feederState )
                {
                    case -1: // Unjam
                       setReversedMotorPower(true);
                       feederState = 3;
                       break;
                    case 0:
                        setMotorPower(false);
                        break;
                    case 1:
                        t.reset();
                        t.start();
                        feederState = 2;
                        break;
                    case 2:
                        setMotorPower(true);
                        if ( t.get() > 0.05 )
                            feederState = 3;
                        break;
                    case 3:
                        if ( home.get() )
                        {
                            setMotorPower(false);
                            feederState = 0;
                        }
                        break;
                }
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
