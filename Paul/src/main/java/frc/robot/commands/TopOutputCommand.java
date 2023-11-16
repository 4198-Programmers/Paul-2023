package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class TopOutputCommand extends CommandBase {
    //left orintated 
private final IntakeSubsystem intakeSubsystem;

public TopOutputCommand(IntakeSubsystem intakeSubsystem) {
    this.intakeSubsystem = intakeSubsystem;
    addRequirements(intakeSubsystem);
}
@Override
public void initialize() {}

// Called every time the scheduler runs while the command is scheduled.
@Override
public void execute() {
  this.intakeSubsystem.topOuttake();
}

// Called once the command ends or is interrupted.
@Override
public void end(boolean interrupted) {
  this.intakeSubsystem.stop();
}

// Returns true when the command should end.
@Override
public boolean isFinished() {
  return false;
}

}
