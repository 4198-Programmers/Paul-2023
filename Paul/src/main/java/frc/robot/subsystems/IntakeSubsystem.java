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
  private CANSparkMax intakeBottomWheels = new CANSparkMax(Constants.Motor.intakeBottomWheels, MotorType.kBrushless);
  private CANSparkMax intakeTopWheels = new CANSparkMax(Constants.Motor.intakeTopWheels, MotorType.kBrushless);

  private RelativeEncoder bottomWheelEncoder = intakeBottomWheels.getEncoder();
  private RelativeEncoder topWheelEncoder = intakeTopWheels.getEncoder();

  private double speed = 1.0;

  // ** Creates a new ExampleSubsystem. */
  public IntakeSubsystem() {
    //this.intakeBottomMotor.follow(this.intakeTopMotor);
    //this.intakeTopWheels.setInverted(true);
    this.bottomWheelEncoder.setPosition(0);
    this.topWheelEncoder.setPosition(0);
  }

  public void inLeft() {
    this.intakeBottomWheels.set(-speed);
    this.intakeTopWheels.set(speed);
  }

  public void inRight() {
    this.intakeBottomWheels.set(speed);
    this.intakeTopWheels.set(-speed);
  }

  public void leftEject() {
    this.intakeBottomWheels.set(speed);
    if((Math.abs(this.bottomWheelEncoder.getVelocity()/Constants.Motor.maxMotorVelocity)) >= 0.9) {
      this.intakeTopWheels.set(-speed);
    }
  }

  public void rightEject() {
    this.intakeBottomWheels.set(-speed);
    if((Math.abs(this.bottomWheelEncoder.getVelocity()/Constants.Motor.maxMotorVelocity)) >= 0.9) {
      this.intakeTopWheels.set(speed);
    }
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
    this.intakeBottomWheels.set(0);
    this.intakeTopWheels.set(0);
  }

public void intakeRight() {
  this.intakeTopWheels.set(speed);
  this.intakeBottomWheels.set(speed);
}

public void intakeLeft() {
this.intakeTopWheels.set(-speed);
this.intakeBottomWheels.set(-speed);
}
}