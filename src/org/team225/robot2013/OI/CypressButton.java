/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2013.OI;

import edu.wpi.first.wpilibj.DriverStationEnhancedIO.EnhancedIOException;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 *
 * @author Andrew
 */
public class CypressButton extends Button {
    int pin = 0;
    boolean inverted = false;
    public CypressButton(int pin, boolean inverted)
    {
        this.inverted = inverted;
        this.pin = pin;
    }
    
    public CypressButton(int pin)
    {
        this(pin, false);
    }
    
    
    public boolean get() {
        try {
            boolean state = WrenBox.getDSIO().getDigital(pin);
            if ( inverted )
                return !state;
            return state;
        } catch (EnhancedIOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
}
