/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.ChassisDefaultCommand;


public class ChassisSubsystem extends Subsystem {

  Victor leftMotor;
  Victor rightMotor;

  DifferentialDrive drive;

  public ChassisSubsystem () {

    leftMotor = new Victor(RobotMap.LEFT_MOTOR_PORT);
    rightMotor = new Victor(RobotMap.RIGHT_MOTOR_PORT);
    
    drive = new DifferentialDrive(leftMotor, rightMotor);

  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ChassisDefaultCommand());
  }

  public void move (double speed, double turn) {
    drive.arcadeDrive(speed, turn);
  }

}
