// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;

public class DriveSubsystem extends SubsystemBase {
  PWMSparkMax frontRight = new PWMSparkMax(RobotMap.frontRight);
  PWMSparkMax backRight = new PWMSparkMax(RobotMap.backRight);
  PWMSparkMax frontLeft = new PWMSparkMax(RobotMap.frontLeft);
  PWMSparkMax backLeft = new PWMSparkMax(RobotMap.backLeft);

  MotorControllerGroup left = new MotorControllerGroup(backLeft, frontLeft);
  MotorControllerGroup right = new MotorControllerGroup(backRight, frontRight);
  DifferentialDrive drive;
  /** Creates a new DriverSubsystem. */
  public DriveSubsystem() {
    frontRight.setInverted(false);
    backRight.setInverted(false);
    frontLeft.setInverted(true);
    backLeft.setInverted(true);

    drive = new DifferentialDrive(left, right);
  }

  public void drive(double straight, double rotation){
      drive.arcadeDrive(straight, rotation);
  }

  public void stop(){
    drive.stopMotor();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new DriveCommand());
  }
}
