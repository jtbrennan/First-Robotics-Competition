// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class DriveCommand extends CommandBase {
  Joystick joystick = Robot.m_robotContainer.getDriverStick();
  boolean speedUpIsPressed, slowDownIsPressed, defaultSpeedIsPressed;
  double joystickY, joystickX, slider;

  /** Creates a new DriveCommand. */
  public DriveCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.m_robotContainer.driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.m_robotContainer.driveSubsystem.stop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    joystickY = joystick.getY();
    joystickX = joystick.getX();
    slider = -joystick.getRawAxis(RobotMap.sliderAxisPort);
    speedUpIsPressed = joystick.getRawButton(RobotMap.fastRobotButton);
    defaultSpeedIsPressed = joystick.getRawButton(RobotMap.defaultRobotSpeed);
    slowDownIsPressed = joystick.getRawButton(RobotMap.slowRobotButton);
    if (speedUpIsPressed)
      Robot.m_robotContainer.driveSubsystem.drive(joystickY * Constants.fastRobotSpeed,
          joystickX * Constants.fastRobotSpeed);
    else if (defaultSpeedIsPressed)
      Robot.m_robotContainer.driveSubsystem.drive(joystickY * Constants.defaultRobotSpeed,
          joystickX * Constants.defaultRobotSpeed);
    else if (slowDownIsPressed)
      Robot.m_robotContainer.driveSubsystem.drive(joystickY * Constants.slowRobotSpeed,
          joystickX * Constants.slowRobotSpeed);
    else
      Robot.m_robotContainer.driveSubsystem.drive(
          joystickY * (Constants.defaultRobotSpeed + (slider * Constants.diffInSpeed)),
          joystickX * (Constants.defaultRobotSpeed + (slider * Constants.diffInSpeed)));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_robotContainer.driveSubsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}