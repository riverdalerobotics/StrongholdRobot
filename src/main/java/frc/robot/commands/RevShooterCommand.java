/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RevShooterCommand extends Command {

  double timeout;

  public RevShooterCommand(double timeout) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_shooterSubsystem);
    this.timeout = timeout;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_shooterSubsystem.startShooter();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return !Robot.m_intakeSubsystem.getIntakeSensor() || timeSinceInitialized() > this.timeout;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_shooterSubsystem.stopShooter();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
