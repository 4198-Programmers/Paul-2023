// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.LoadCommand;
import frc.robot.commands.TopBottomIntakeCommand;
import frc.robot.commands.TopBottomOutputCommand;
import frc.robot.commands.TopIntakeCommand;
import frc.robot.commands.TopOutputCommand;
import frc.robot.commands.EjectCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.commands.AdjustSpeedCommand;
import frc.robot.commands.Autos;
import frc.robot.commands.BottomIntakeCommand;
import frc.robot.commands.BottomOutputCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.DriveStraightCommand;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  private final CommandXboxController m_driverController = new CommandXboxController(OperatorConstants.kDriverControllerPort);


  // The robot's subsystems and commands are defined here...
  private final DriveTrain drive = new DriveTrain();
  private final IntakeSubsystem intake = new IntakeSubsystem();
  private final DriveCommand joystickDriveCommand = new DriveCommand(drive, ()->{return m_driverController.getLeftY();}, ()->{return m_driverController.getRightX();});
  
  private final TopIntakeCommand topIntakeCommand = new TopIntakeCommand(intake);
  private final BottomIntakeCommand bottomIntakeCommand = new BottomIntakeCommand(intake);
  private final TopOutputCommand topOutputCommand = new TopOutputCommand(intake);
  private final BottomOutputCommand bottomOutputCommand = new BottomOutputCommand(intake);
  private final TopBottomIntakeCommand topBottomIntakeCommand = new TopBottomIntakeCommand(intake);
  private final TopBottomOutputCommand topBottomOutputCommand = new TopBottomOutputCommand(intake);

  // Replace with CommandPS4Controller or CommandJoystick if needed
 
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    drive.setDefaultCommand(joystickDriveCommand);
    // Configure the trigger bindings
    configureBindings();
    //m_driverController.button(kA).onTrue();
  }


  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {

    m_driverController.b().onTrue(new SequentialCommandGroup(new DriveStraightCommand(drive, 100, 0.25, 0.25).andThen( (new DriveStraightCommand(drive, -100, -0.25, -0.25)))));
    m_driverController.y().onTrue(new DriveStraightCommand(drive, 100, 0.25, 0.25));
    m_driverController.x().onTrue(new DriveStraightCommand(drive, -100, -0.25, -0.25));

    m_driverController.povUp().onTrue(new AdjustSpeedCommand(this.drive, Constants.Motor.driveSpeedStep));
    m_driverController.povDown().onTrue(new AdjustSpeedCommand(this.drive, -Constants.Motor.driveSpeedStep));

    m_driverController.leftBumper().and(m_driverController.leftTrigger().negate()).whileTrue(topOutputCommand); 
    m_driverController.rightBumper().and(m_driverController.rightTrigger().negate()).whileTrue(topIntakeCommand);
    
    m_driverController.leftTrigger().and(m_driverController.leftBumper().negate()).whileTrue(bottomOutputCommand);
    m_driverController.rightTrigger().and(m_driverController.rightBumper().negate()).whileTrue(bottomIntakeCommand);

    m_driverController.leftBumper().and(m_driverController.leftTrigger()).whileTrue(topBottomOutputCommand);
    m_driverController.rightTrigger().and(m_driverController.rightBumper()).whileTrue(topBottomIntakeCommand);

  }
//robot understands that it is turning on, controler is working
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
   // return new SequentialCommandGroup(new DriveStraightCommand(drive, 15, 0.5, 0.5).andThen(new DriveStraightCommand(drive, -15, -0.5, -0.5)));
    return Autos.DriveOutAuto(drive);
  }
}
