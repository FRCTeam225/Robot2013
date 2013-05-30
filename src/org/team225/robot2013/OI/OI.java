package org.team225.robot2013.OI;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import org.team225.robot2013.RobotMap;
import org.team225.robot2013.commands.CommandBase;
import org.team225.robot2013.commands.drivetrain.JoystickDrive;
import org.team225.robot2013.commands.drivetrain.LockDrivetrain;
import org.team225.robot2013.commands.shooter.CenterShot2;
import org.team225.robot2013.commands.shooter.CloseShot;
import org.team225.robot2013.commands.shooter.FarShot2;
import org.team225.robot2013.commands.shooter.FarShot2Up;
import org.team225.robot2013.commands.shooter.FarShot3;
import org.team225.robot2013.commands.shooter.HoldTurret;
import org.team225.robot2013.commands.shooter.ManualTurret;
import org.team225.robot2013.commands.shooter.MurderShot;
import org.team225.robot2013.commands.shooter.SafeFeedFrisbee;
import org.team225.robot2013.commands.shooter.StowShooter;
import org.team225.robot2013.commands.shooter.UnjamFeeder;

/**
 *
 * @author Andrew
 */
public class OI {
    public static int BUMPUPBTN = 6;
    public static int BUMPDWNBTN = 8;
    
    
    public static Joystick jsL = new Joystick(RobotMap.LEFT_JS);
    public static Joystick jsR = new Joystick(RobotMap.RIGHT_JS);
    public static Joystick jsOperator = new Joystick(RobotMap.OPERATOR_JS);
   
    public static Command manualControl = new ManualTurret();
    public static Command machineGun = new SafeFeedFrisbee();
    public static Command holdTurret = new HoldTurret();
        
    public static void init()
    {
        
        new CypressButton(2).whenPressed(new BumpUpShooter()); // Shooter Up - LB
        new CypressButton(3).whenPressed(new BumpDownShooter()); // Shooter Down - LT
    
        
        
        
        new JoystickButton(jsOperator, 4).whenPressed(new CloseShot()); 
        new JoystickButton(jsOperator, 2).whenPressed(new FarShot2());
        new JoystickButton(jsOperator, 6).whenPressed(new FarShot3());
        new JoystickButton(jsOperator, 5).whenPressed(new CenterShot2()); 
        new JoystickButton(jsOperator, 3).whenPressed(new StowShooter());
        new JoystickButton(jsOperator, 9).whenPressed(new UnjamFeeder());
        new JoystickButton(jsOperator, 7).whenPressed(new MurderShot());
        new JoystickButton(jsOperator, 8).whenPressed(new FarShot2Up());
        
        
        new JoystickButton(jsL, 3).whenPressed(new LockDrivetrain());
        new JoystickButton(jsR, 2).whenPressed(new JoystickDrive());   
        new JoystickButton(jsR, 3).whenPressed(new LockDrivetrain());
        new JoystickButton(jsL, 2).whenPressed(new JoystickDrive());  
    }
    
    public static void OIpoll()
    {
        if ( CommandBase.feeder.getCurrentCommand() == null && jsOperator.getRawButton(1) )
        {
            machineGun.start();
            if ( CommandBase.turret.getCurrentCommand() != holdTurret )
                holdTurret.start();
        }
            
            
        if ( OI.jsOperator.getRawAxis(5) != 0 && !CommandBase.turret.getCurrentCommand().equals(manualControl) )
            manualControl.start();
    }
}
