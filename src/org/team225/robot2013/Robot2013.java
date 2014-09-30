package org.team225.robot2013;


import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team225.robot2013.OI.OI;
import org.team225.robot2013.commands.CommandBase;
import org.team225.robot2013.commands.autonomous.CenterShoot;
import org.team225.robot2013.commands.autonomous.RightSideShootAndBackup;
import org.team225.robot2013.commands.drivetrain.DriveDistance;

public class Robot2013 extends IterativeRobot {
    SendableChooser autonomousList = new SendableChooser();
    Command autonomousCommand = null;
    NetworkTable test = NetworkTable.getTable("test");
    public void robotInit() {
        CommandBase.init();
        OI.init();
        autonomousList.addDefault("RightSideBackupAuton", new RightSideShootAndBackup());
        autonomousList.addObject("CenterAuton", new CenterShoot());
        //autonomousList.addObject("test", new DriveDistance(2000));
        test.putBoolean("hasTarget", false);
        SmartDashboard.putData("SelectAuton", autonomousList);
        CommandBase.ledStrip.setRed();
    }

    public void autonomousInit()
    {
       // CommandBase.drivetrain.getCurrentCommand().cancel();
        CommandBase.turretLEDStrip.setDriving();
        autonomousCommand = (Command)autonomousList.getSelected();
        autonomousCommand.start();
    }
    
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() 
    {
        Scheduler.getInstance().run();
        CommandBase.turret.updatePID();
    }

    public void teleopInit()
    {
       // CommandBase.drivetrain.getCurrentCommand().cancel();
        stopAutonomous();
    }
    
    /**
     * This function is called periodically during operator control
     */
    
    
    public void teleopPeriodic() 
    {
        Scheduler.getInstance().run();
        OI.poll();
        sendDashboardDebug();
        
        CommandBase.turret.updatePID();
        
    }
    
    public void testInit()
    {
        stopAutonomous();
    }
    
    /**
     * This function is called periodically during test mode
     */
    
    public void testPeriodic() 
    {
        sendDashboardDebug();
    }
    
    
    public void disabledPeriodic()
    {
        sendDashboardDebug();
    }
    
    public void disabledInit()
    {
        stopAutonomous();
    }
    
    public void stopAutonomous()
    {
        if ( autonomousCommand != null )
            autonomousCommand.cancel();
    }
    
    public void sendDashboardDebug()
    {        
        try
        {
            //SmartDashboard.putNumber("Shooter %Error", CommandBase.shooter.getErrorPrecent());
            //SmartDashboard.putNumber("Shooter Setpoint", CommandBase.shooter.getWheelSetpoint());
            //SmartDashboard.putNumber("Turret Location", CommandBase.turret.getPosition());
            //SmartDashboard.putNumber("Turret Setpoint", CommandBase.turret.getSetpoint());

            DriverStationLCD dsLCD = DriverStationLCD.getInstance();
            dsLCD.println(DriverStationLCD.Line.kUser1, 1, String.valueOf(CommandBase.shooter.getWheelSetpoint())+"       ");
            dsLCD.println(DriverStationLCD.Line.kUser2, 1, "Pos: "+String.valueOf(CommandBase.turret.getPosition())+"       ");
            dsLCD.println(DriverStationLCD.Line.kUser3, 1, "SetP: "+String.valueOf(CommandBase.turret.getSetpoint())+"       ");
            dsLCD.println(DriverStationLCD.Line.kUser4, 1, "%Err: "+String.valueOf(CommandBase.shooter.getErrorPrecent())+"       ");
            dsLCD.println(DriverStationLCD.Line.kUser5, 1, "DTPos: "+String.valueOf(CommandBase.drivetrain.getDistance())+"       ");
            dsLCD.println(DriverStationLCD.Line.kUser6, 1, "DTAng: "+String.valueOf(CommandBase.drivetrain.getAngle())+"       ");
            
            dsLCD.updateLCD();
        }
        catch ( Exception e )
        {
            
        }
    }
}
