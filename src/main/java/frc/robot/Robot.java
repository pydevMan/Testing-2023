// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs the motors with
 * arcade steering.
 */                                                                            
public class Robot extends TimedRobot {

  Constants cons = new Constants();
  Gear gear = new Gear();

  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    cons.rightMotor.setInverted(true);
  }

  @Override
  public void teleopPeriodic() {
    // Drive with arcade drive.
    // That means that the Y axis drives forward
    // and backward, and the X turns left and right.
    double speedMultiplier = gear.getSpeedMultiplier();
    cons.robotDrive.arcadeDrive(cons.xbox.getLeftY() * speedMultiplier, -cons.xbox.getLeftX() * speedMultiplier);

    if (cons.xbox.getBButtonPressed() == true) {
      // Gear Shift Logic
      if (speedMultiplier > 0.5) {
        gear.setSpeedMultiplier(cons.maxMultiplier);
      } else {
        gear.setSpeedMultiplier(cons.minMultiplier);
      }
    }

  }
}
