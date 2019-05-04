/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class IntakeDefaultCommand extends Command {
  public IntakeDefaultCommand() {
    requires(Robot.m_intakeSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    boolean pullIntake = Robot.m_oi.pullIntake();
    boolean pushIntake = Robot.m_oi.pullIntake();

    boolean feedShooter = Robot.m_oi.feedShooter();
    
    if (pullIntake) {
      Robot.m_intakeSubsystem.pullLowIntake();
    } else if (pushIntake) {
      Robot.m_intakeSubsystem.pushLowIntake();
    } else {
      Robot.m_intakeSubsystem.stopLowIntake();
    }

    if (feedShooter) {
      Robot.m_intakeSubsystem.pullHighIntake();
    } else if (pushIntake) {
      Robot.m_intakeSubsystem.pushHighIntake();
    } else {
      Robot.m_intakeSubsystem.stopHighIntake();
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
