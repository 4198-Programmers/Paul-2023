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
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  private CANSparkMax intakeTopMotor = new CANSparkMax(Constants.Motor.intakeTopMotor, MotorType.kBrushless);
  private CANSparkMax intakeBottomMotor = new CANSparkMax(Constants.Motor.intakeBottomMotor, MotorType.kBrushless);

  // private RelativeEncoder frontRightEncoder = frontRightMotor.getEncoder();
  // private RelativeEncoder backLeftEncoder = backLeftMotor.getEncoder();

  private double speed = 1.0;

  // ** Creates a new ExampleSubsystem. */
  public IntakeSubsystem() {
    this.intakeBottomMotor.follow(this.intakeTopMotor);
  }
//RB 
  public void topRight() {
    this.intakeTopMotor.set(speed);
  }
//LB
public void topLeft() {
  this.intakeTopMotor.set(speed);
}
//RT
  public void bottomRight() {
    this.intakeBottomMotor.set(speed);
  }
//LT
public void bottomLeft() {
  this.intakeBottomMotor.set(speed);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void stop() {
    this.intakeTopMotor.set(0);
  }
}
