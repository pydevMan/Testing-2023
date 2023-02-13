package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class Constants {

  // Speed Multiplier Variables
  public final double minMultiplier = 0.2;
  public final double maxMultiplier = 0.85;

  // Motors 
  public final PWMSparkMax leftMotor = new PWMSparkMax(0);
  public final PWMSparkMax rightMotor = new PWMSparkMax(1);

  // Drivetrain
  public final DifferentialDrive robotDrive = new DifferentialDrive(leftMotor, rightMotor);

  // Controller Constants
  public final XboxController xbox = new XboxController(0);
    
}
