// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;

public class Autos extends CommandBase {
  /** Example static factory for an autonomous command. */
  public static CommandBase exampleAuto(DriveTrain subsystem) {
    return Commands.sequence(subsystem.exampleMethodCommand());
  }

  private DriveTrain drive; 
  public Auto drive(DriveTrain drive){
    this.drive = drive; 
  }

  private boolean timerBoolean(double startTime, double duration){
    double delayTime = startTime + duration; 

    if(System.currentTimeMillis() <= delayTime)
    {
      return true; 
    } else {
      return false; 
    }
  }

  public void AutonomousForward(int time, double speed){

    double start = System.currentTimeMillis();

    while (timerBoolean(start, time)){
      DriveTrain.drive(speed, speed);
     }
     isFinished();
  }



  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
