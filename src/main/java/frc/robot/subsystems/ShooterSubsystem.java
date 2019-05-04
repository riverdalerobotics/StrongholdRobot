/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotConstants;
import frc.robot.RobotMap;
import frc.robot.commands.ShooterDefaultCommand;

/**
 * Add your docs here.
 */
public class ShooterSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  Victor shooterMotor;

  public ShooterSubsystem () {

    shooterMotor = new Victor(RobotMap.SHOOTER_MOTOR_PORT);

  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ShooterDefaultCommand());
  }

  private void setShooterSpeed (double speed) {
    shooterMotor.set(speed);
  }

  public void startShooter () {
    setShooterSpeed(RobotConstants.SHOOTER_SPEED);
  }

  public void stopShooter () {
    setShooterSpeed(0);
  }

}
