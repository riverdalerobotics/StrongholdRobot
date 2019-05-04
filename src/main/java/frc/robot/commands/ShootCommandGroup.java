/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotConstants;

public class ShootCommandGroup extends CommandGroup {
  /**
   * Add your docs here.
   */
  public ShootCommandGroup() {
    addParallel(new RevShooterCommand(RobotConstants.REV_TIME));
    addSequential(new FeedShooterCommand(RobotConstants.REV_TIME, RobotConstants.DELAY_PERCENT));
  }
}
