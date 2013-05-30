package org.team225.robot2013.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.team225.robot2013.subsystems.Compressor;
import org.team225.robot2013.subsystems.Drivetrain;
import org.team225.robot2013.subsystems.Feeder;
import org.team225.robot2013.subsystems.LEDStrip;
import org.team225.robot2013.subsystems.Lift;
import org.team225.robot2013.subsystems.Shooter;
import org.team225.robot2013.subsystems.Turret;

/**
 *
 * @author Andrew
 */
public abstract class CommandBase extends Command {
    public static Drivetrain drivetrain;
    public static Shooter shooter;
    public static Lift lift;
    public static Feeder feeder;
    public static Turret turret;
    public static Compressor compressor;
    public static LEDStrip ledStrip;
    
    public static void init()
    {
        drivetrain = new Drivetrain();
        shooter = new Shooter();
        lift = new Lift();
        feeder = new Feeder();
        turret = new Turret();
        compressor = new Compressor();
        ledStrip = new LEDStrip();
    }
    
    protected void interrupted() {
        end();
    }
}
