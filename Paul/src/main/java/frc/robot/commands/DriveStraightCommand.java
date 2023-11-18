package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveStraightCommand extends CommandBase{
  
  private final double distanceInches; 
  private final double rightSpeed; 
  private final double leftSpeed; 

  private DriveTrain driveTrain;

  public DriveStraightCommand(DriveTrain drivetrain, double distanceInches, double rightSpeed, double leftSpeed){
  this.driveTrain = drivetrain;
  this.distanceInches = distanceInches;
  this.rightSpeed = rightSpeed;
  this.leftSpeed = leftSpeed;
  addRequirements(drivetrain);
  }

  @Override
  public void initialize() {
    driveTrain.resetPosition();
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //driveTrain.driveAuto(rightSpeed, leftSpeed);
    driveTrain.drive(leftSpeed, rightSpeed);
    System.out.println("Drive POsition: " + driveTrain.currentDistancePosition());
    } 

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.driveTrain.driveAuto(0,0);
    driveTrain.resetPosition();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
  return (Math.abs(distanceInches) <= Math.abs(driveTrain.currentDistancePosition()));
  }
}
