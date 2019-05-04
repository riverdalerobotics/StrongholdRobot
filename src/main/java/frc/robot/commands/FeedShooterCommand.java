/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class FeedShooterCommand extends Command {

  double duration;
  double delayPercent;

  public FeedShooterCommand(double duration, double delayPercent) {
    requires(Robot.m_intakeSubsystem);
    this.delayPercent = delayPercent;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    setTimeout(this.duration);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (timeSinceInitialized() > (this.duration * this.delayPercent)) {
      Robot.m_intakeSubsystem.pullHighIntake();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_intakeSubsystem.stopHighIntake();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
