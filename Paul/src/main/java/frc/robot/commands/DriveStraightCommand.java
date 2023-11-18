package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveStraightCommand extends CommandBase{
  
  public DriveStraightCommand(DriveTrain drivetrain, double distanceInches){
  this.driveTrain = drivetrain;
  this.distanceInches = distanceInches;

  }
  private DriveTrain driveTrain;
  private 

  public double currentDistancePosition(){
    double currentDistancePosition = (Math.PI)(RelativeEncoder.frontLeftEncoder())(Constants.diameterOfWheel); 
    return Math.round(currentDistancePosition);
  }
  
  @Override
  public void initialize() {}
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      this.intakeSubsystem.eject();
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
