// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;

public class Autos extends CommandBase {
  /** Example static factory for an autonomous command. */

  public static CommandBase DriveOutAuto(DriveTrain subsystem) {
    return Commands.sequence(new DriveStraightCommand(subsystem, 8.5, 0.25, 0.25), new DriveStraightCommand(subsystem, -8.5, -0.25, -0.25));
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
