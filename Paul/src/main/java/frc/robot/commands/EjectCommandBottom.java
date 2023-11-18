package frc.robot.commands;

import frc.robot.subsystems.IntakeSubsystemBottom;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class EjectCommandBottom extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final IntakeSubsystemBottom intakeSubsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public EjectCommandBottom(IntakeSubsystemBottom subsystem) {
    intakeSubsystem = subsystem;
  
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }
  @Override
  public void execute() {
      this.intakeSubsystem.eject();
    } 

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.intakeSubsystem.stop();
    
  }
}
