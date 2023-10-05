// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  private CANSparkMax frontLeftMotor = new CANSparkMax(Constants.FRONTLEFTMOTOR, MotorType.kBrushless);
  private CANSparkMax frontRightMotor = new CANSparkMax(Constants.FRONTRIGHTMOTOR, MotorType.kBrushless);
  private CANSparkMax backLeftMotor = new CANSparkMax(Constants.BACKLEFTMOTOR, MotorType.kBrushless);
  private CANSparkMax backRightMotor = new CANSparkMax(Constants.BACKRIGHTMOTOR, MotorType.kBrushless);

  private RelativeEncoder frontLeftEncoder = frontLeftMotor.getEncoder();
  private RelativeEncoder frontRightEncoder = frontRightMotor.getEncoder();
  private RelativeEncoder backLeftEncoder = backLeftMotor.getEncoder();
  private RelativeEncoder backRightEncoder = backRightMotor.getEncoder();

  private MotorControllerGroup left = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
  private MotorControllerGroup right = new MotorControllerGroup(frontRightMotor, backRightMotor);

  private DifferentialDrive driveTrain = new DifferentialDrive(left, right); 


  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
    
  }

  public void drive(double left, double right){
    driveTrain.tankDrive(left, right);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
