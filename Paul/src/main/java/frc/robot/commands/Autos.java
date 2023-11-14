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

  public static Autos middlePosition(DriveTrain subsystem){
    //forward into open area 
    //backward onto charging station

  }


  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
