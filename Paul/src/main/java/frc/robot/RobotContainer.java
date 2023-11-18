// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.LoadCommandTop;
import frc.robot.commands.EjectCommandTop;
import frc.robot.commands.LoadCommandBottom;
import frc.robot.subsystems.IntakeSubsystemTop;
import frc.robot.commands.AdjustSpeedCommand;
import frc.robot.commands.Autos;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.EjectCommandBottom;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.IntakeSubsystemBottom;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
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
  private final IntakeSubsystemTop intakeTop = new IntakeSubsystemTop();
  private final IntakeSubsystemBottom intakeBottom = new IntakeSubsystemBottom();
  private final DriveCommand joystickDriveCommand = new DriveCommand(drive, ()->{return m_driverController.getLeftY();}, ()->{return m_driverController.getRightY();});
  
  // Commands
  EjectCommandTop ejectCommandTop = new EjectCommandTop(intakeTop);
  EjectCommandBottom ejectCommandBottom = new EjectCommandBottom(intakeBottom);
  LoadCommandTop loadCommandTop = new LoadCommandTop(intakeTop);
  LoadCommandBottom loadCommandBottom = new LoadCommandBottom(intakeBottom);

  // Command Groups
  Command loadCommandBoth = (new LoadCommandTop(intakeTop))
  .andThen((new LoadCommandBottom(intakeBottom)));

  Command ejectCommandBoth = (new EjectCommandTop(intakeTop))
  .andThen((new EjectCommandBottom(intakeBottom)));
  


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
    m_driverController.leftBumper().whileTrue(loadCommandBoth);
    m_driverController.rightBumper().whileTrue(ejectCommandBoth);

    m_driverController.povUp().onTrue(new AdjustSpeedCommand(this.drive, Constants.Motor.driveSpeedStep));
    m_driverController.povDown().onTrue(new AdjustSpeedCommand(this.drive, -Constants.Motor.driveSpeedStep));
  }
//robot understands that it is turning on, controler is working
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomou
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(drive);
  }
}
