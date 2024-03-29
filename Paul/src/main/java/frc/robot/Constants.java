// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
  public static class Motor{
    public static final int frontRightMotor = 1;
    public static final int backLeftMotor = 5;
    public static final int frontLeftMotor = 6; 
    public static final int backRightMotor = 4;

    public static final double maximumDriveSpeed = 1.0f;
    public static final double minimumDriveSpeed = 0.2f;
    public static final double driveSpeedStep = 0.1f;
    public static final double slewRateLimit = 0.75f;


    public static final int intakeTopMotor = 2;
    public static final int intakeBottomMotor = 3;

    //original 1 and 8 
  public static final double maximumTopIntakeSpeed = 1.0f;
  public static final double maximumBottomIntakeSpeed = 1.0f;

  }
//change
  public static final double diameterOfWheel = 8.5f;
  public static final double ConvertionFactorDrive = 0.083;

}
