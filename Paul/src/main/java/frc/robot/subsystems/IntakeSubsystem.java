// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  private CANSparkMax frontRightMotor = new CANSparkMax(4, MotorType.kBrushless);
  private CANSparkMax backLeftMotor = new CANSparkMax(5, MotorType.kBrushless);

  // private RelativeEncoder frontRightEncoder = frontRightMotor.getEncoder();
  // private RelativeEncoder backLeftEncoder = backLeftMotor.getEncoder();

  private double speed = 1.0;

  // ** Creates a new ExampleSubsystem. */
  public IntakeSubsystem() {
    this.backLeftMotor.follow(this.frontRightMotor);
  }

  public void in() {
    this.frontRightMotor.set(speed);
  }

  public void out() {
    this.frontRightMotor.set(-speed);
  }


  /**
   * An example method querying a boolean state of the subsystem (for example, a
   * digital sensor).
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
