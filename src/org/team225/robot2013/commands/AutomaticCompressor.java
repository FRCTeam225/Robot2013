/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2013.commands;

/**
 *
 * @author Andrew
 */
public class AutomaticCompressor extends CommandBase {

    public AutomaticCompressor()
    {
        requires(compressor);
    }
    
    protected void initialize() {
    }

    protected void execute() {
        compressor.setCompressor(!compressor.getPressureSwitch());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        compressor.setCompressor(false);
    }
    
}
