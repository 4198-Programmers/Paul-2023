package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveStraightCommand extends CommandBase{
  
  public void driveStraightCommand(double speed, double distance){
    while (distance >= currentDistancePosition()){
      DriveTrain.drive(speed, speed);
    } 
    double resetPosition;
  }
    
}
