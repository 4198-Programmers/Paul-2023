// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  private CANSparkMax frontLeftMotor = new CANSparkMax(Constants.Motor.frontLeftMotor, MotorType.kBrushless);
  private CANSparkMax frontRightMotor = new CANSparkMax(Constants.Motor.frontRightMotor, MotorType.kBrushless);
  private CANSparkMax backLeftMotor = new CANSparkMax(Constants.Motor.backLeftMotor, MotorType.kBrushless);
  private CANSparkMax backRightMotor = new CANSparkMax(Constants.Motor.backRightMotor, MotorType.kBrushless);

  private RelativeEncoder frontLeftEncoder = frontLeftMotor.getEncoder();
  private RelativeEncoder frontRightEncoder = frontRightMotor.getEncoder();
  private RelativeEncoder backLeftEncoder = backLeftMotor.getEncoder();
  private RelativeEncoder backRightEncoder = backRightMotor.getEncoder();

  private MotorControllerGroup left = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
  private MotorControllerGroup right = new MotorControllerGroup(frontRightMotor, backRightMotor);

  private DifferentialDrive driveTrain = new DifferentialDrive(left, right); 
  public boolean driveInvert = true; 
  private double currentSpeed;
  private SlewRateLimiter slewRateLimiterLeft;
  private SlewRateLimiter slewRateLimiterRight;

  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
    this.backLeftMotor.setInverted(true);
    this.frontLeftMotor.setInverted(true);
    this.backLeftEncoder.setPositionConversionFactor(Constants.ConvertionFactorDrive);
    this.backRightEncoder.setPositionConversionFactor(Constants.ConvertionFactorDrive);
    this.frontLeftEncoder.setPositionConversionFactor(Constants.ConvertionFactorDrive);
    this.frontRightEncoder.setPositionConversionFactor(Constants.ConvertionFactorDrive);
    this.currentSpeed = Constants.Motor.maximumDriveSpeed;
    this.slewRateLimiterLeft = new SlewRateLimiter(Constants.Motor.slewRateLimit, -Constants.Motor.slewRateLimit, 0);
    this.slewRateLimiterRight = new SlewRateLimiter(Constants.Motor.slewRateLimit, -Constants.Motor.slewRateLimit, 0);
  }

  public void drive(double left, double right){
    driveTrain.arcadeDrive(applySpeed(left, this.slewRateLimiterLeft), applySpeed(right, this.slewRateLimiterRight));
  }

  public void driveAuto(double left, double right){
    frontLeftMotor.set(left);
    frontRightMotor.set(right);
    backLeftMotor.set(left);
    backRightMotor.set(right);
  }
  public double drivePosition(){
    return((frontRightEncoder.getPosition() + backRightEncoder.getPosition())/2d);
  }

  public double currentDistancePosition(){
    double currentDistancePosition = (Math.PI)*(frontRightEncoder.getPosition())*(Constants.diameterOfWheel)*(Constants.ConvertionFactorDrive); 
    double currentDistancePosition = (Math.PI)*(frontRightEncoder.getPosition())*(Constants.diameterOfWheel)*; 
    return Math.round(currentDistancePosition);
  }

  public void driveInvert(double left, double right){
    driveTrain.tankDrive(left * -1, right * -1);
  }
  
  private double applySpeed(double value, SlewRateLimiter slewRateLimiter){
    return slewRateLimiter.calculate(this.currentSpeed*value);
  }
  
  public void resetPosition(){
    frontLeftEncoder.setPosition(0);
    frontRightEncoder.setPosition(0); 
    backLeftEncoder.setPosition(0); 
    backRightEncoder.setPosition(0);
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

public void adjustSpeed(double adjustSpeedAmount) {
  double nextSpeed = this.currentSpeed;
  nextSpeed = nextSpeed+adjustSpeedAmount;
  nextSpeed = MathUtil.clamp(nextSpeed, Constants.Motor.minimumDriveSpeed, Constants.Motor.maximumDriveSpeed);
  this.currentSpeed = nextSpeed;
}
}
