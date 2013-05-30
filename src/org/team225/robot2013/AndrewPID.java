/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team225.robot2013;

/**
 *
 * @author Andrew
 */
public class AndrewPID {
    double kP, kI, kD;
    double error;
    double target; 
    double okError = 1;
    double errSum = 0;
    double maxInc = 0.01;
    double previousValue = 0;
    
    double maxOutput=1, minOutput=-1;
    public AndrewPID(double kP, double kI, double kD)
    {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD; 
    }
    
    public void setOutputConstraints(double max, double min)
    {
        maxOutput = max;
        minOutput = min;
    }
    
    public double getTarget()
    {
        return target;
    }
    
    public void setMaxInc(double val)
    {
        this.maxInc = val;
    }
    
    public void setOkError(double okError)
    {
        this.okError = okError;
    }
    
    public void setP(double kP)
    {
        this.kP = kP;
    }
    
    public void setI(double kI)
    {
        this.kI = kI;
    }
    
    public void setD(double kD)
    {
        this.kD = kD;
    }
    
    public double getError()
    {
        return error;
    }
    
    public void setTarget(double target)
    {
        this.target = target;
    }
    
    public double calculate(double input)
    {
        // P
        error = target-input;
        
        // I
        if ( error >= okError )
        {
            if ( errSum < 0 )
                errSum = 0;
            if ( error < maxInc )
                errSum += error;
            else
                errSum += maxInc;
        }
        else if ( error <= - okError )
        {
            if ( errSum < 0 )
                errSum = 0;
            if ( errSum > -maxInc )
                errSum += error;
            else
                errSum -= maxInc;
        }
        else
            errSum = 0;
        
        // D
        double velocity = input-previousValue;
        previousValue = input;
        
        double output = (kP*error)+(kI*errSum)-(kD*velocity);
        
        if ( output > maxOutput )
            output = maxOutput;
        else if ( output < minOutput )
            output = minOutput;
        
        return output;
        
    }
    
}
