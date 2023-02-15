// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs the motors with
 * arcade steering.
 */     

 

public class Robot extends TimedRobot {

  // The gain for a simple P loop
  double kP = 1;

  // our inital refrance for the gyro at the start of the period
  double ref;

  // since we dont have a gyro im making a place holder
  //GyroType myGyro = new initializationOfGyro();

  // and my aceler
  //MyF__IngAcceleratorBoiType myAccelerator = new MyF__IngAcceleratorBoi();

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


  // Woopdy Doo now i got to go solve the inverse kinimatics of the autonimus period, 
  // step one find the expectation value of your mother a massy partical by finding its 
  // wave function of the hermision quantum operator momentum, lol just kidding here 
  // i just set up what happens when that loud alarm goes off and starts our refrance frame
  // where the inital gyro values are subtractedn by the values now lol
  @Override
  public void autonomousInit(){
    //refrance for where we start at
    //ref = myGyro.getAngle();
  }

  @Override
  public void autonomousPeriodic() {
    //have a custom class calculating the angles theta phi from the yaw and pitch gyro
    //and acelerometer telling us r dot as the axeleration
  }


}
