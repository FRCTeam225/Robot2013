/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2013.OI;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO.EnhancedIOException;

/**
 *
 * @author Andrew
 * 
 * This class is for our Cypress IO board, which is used by our operator named Wren
 * Thus the name WrenBox.
 */
public class WrenBox {
    public static DriverStationEnhancedIO getDSIO()
    {
        return DriverStation.getInstance().getEnhancedIO();
    }
    
    public static boolean shooterEnabled()
    {
        try {
            return getDSIO().getDigital(1);
        } catch (Exception ex) {
        }
        return true;
    }

    public static void setLEDs(boolean state)
    {
        try {
            getDSIO().setLEDs(state?(byte)0xff:(byte)0);
        } catch (EnhancedIOException ex) {
        }
    }
    
    public static void setShooterReadyLED(boolean state)
    {
        try {
            getDSIO().setDigitalOutput(4, state);
        } catch (EnhancedIOException ex) {
        }
    }
    
    public static void setTurretLockedLED(boolean state)
    {
        try {
            getDSIO().setDigitalOutput(5, state);
        } catch (EnhancedIOException ex) {
        }
    }
    
    
}
