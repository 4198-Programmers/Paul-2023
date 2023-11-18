package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystemBottom extends SubsystemBase{

  
  private CANSparkMax intakeBottomMotor = new CANSparkMax(Constants.Motor.intakeBackMotor, MotorType.kBrushed);


  // private RelativeEncoder frontRightEncoder = frontRightMotor.getEncoder();
  // private RelativeEncoder backLeftEncoder = backLeftMotor.getEncoder();

  private double speed = 1.0;

  // ** Creates a new ExampleSubsystem. */
  public IntakeSubsystemBottom() {}

  public void in() {
    this.intakeBottomMotor.set(speed);
  }

  public void eject() {
    this.intakeBottomMotor.set(-speed);
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
    this.intakeBottomMotor.set(0);
  }
}

    
}
