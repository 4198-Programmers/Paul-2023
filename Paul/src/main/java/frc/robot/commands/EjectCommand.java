// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class EjectCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final IntakeSubsystem intakeSubsystem;
  private double timeToStartTopMotor;
  private double timeToFinish;

  /**
   //start bottom motor
   //continously run bottom motor
   //start top motor
  //stop both motors

   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public EjectCommand(IntakeSubsystem subsystem) {
    intakeSubsystem = subsystem;
  
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.timeToStartTopMotor = Timer.getFPGATimestamp() + 2;
    this.timeToFinish = this.timeToStartTopMotor + 2;
  }
  // Called every time the scheduler runs while the command is scheduled.
  
  // @Override
  // public void execute() {
  //   if(this.timeToStartTopMotor < Timer.getFPGATimestamp()){
  //     this.intakeSubsystem.topBottomOuttake();
  //   }else{
  //     this.intakeSubsystem.bottomOuttake();
  //   }
  //   } 

    @Override
    public void execute() {
      if(this.timeToStartTopMotor < Timer.getFPGATimestamp()){
        this.intakeSubsystem.topOuttake();
      }
      this.intakeSubsystem.bottomOuttake();
      } 

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.intakeSubsystem.stop();
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return this.timeToFinish < Timer.getFPGATimestamp();
  }
}
