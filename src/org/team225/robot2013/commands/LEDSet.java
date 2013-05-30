/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2013.commands;

/**
 *
 * @author Andrew
 */
public class LEDSet extends CommandBase {

    static public int RED = 0;
    static public int GREEN = 1;
    
    int color;
    
    public LEDSet(int color)
    {
        this.color = color;
    }
    
    protected void initialize() {
        if ( color == RED )
            ledStrip.setRed();
        else if ( color == GREEN )
            ledStrip.setGreen();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }
}
