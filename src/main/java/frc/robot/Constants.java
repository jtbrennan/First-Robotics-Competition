// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    // Drive station speed constants
    public static final double slowRobotSpeed = 0.60;
    public static final double defaultRobotSpeed = 0.75;
    public static final double fastRobotSpeed = 0.90;
    public static final double diffInSpeed = 0.15;

    // Ultrasonic sensor constants
    public static final double distFromObject = 20.0;
}