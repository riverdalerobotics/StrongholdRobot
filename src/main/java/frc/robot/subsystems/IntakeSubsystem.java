/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotConstants;
import frc.robot.RobotMap;
import frc.robot.commands.IntakeDefaultCommand;

public class IntakeSubsystem extends Subsystem {

  Victor lowIntakeMotor;
  Victor highIntakeMotor;

  DigitalInput intakeSensor;

  public IntakeSubsystem () {

    lowIntakeMotor = new Victor(RobotMap.LOW_INTAKE_MOTOR_PORT);

    highIntakeMotor = new Victor(RobotMap.HIGH_INTAKE_MOTOR_PORT);

    intakeSensor = new DigitalInput(RobotMap.INTAKE_SENSOR_PORT);

  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new IntakeDefaultCommand());
  }

  private void setLowIntakeSpeed (double speed) {
    lowIntakeMotor.set(speed);
  }

  public void pullLowIntake () {
    setLowIntakeSpeed(RobotConstants.LOW_INTAKE_SPEED);
  }

  public void pushLowIntake () {
    setLowIntakeSpeed(-RobotConstants.LOW_INTAKE_SPEED);
  }

  public void stopLowIntake() {
    setLowIntakeSpeed(0);
  }

  private void setHighIntakeSpeed (double speed) {
    highIntakeMotor.set(speed);
  }

  public void pullHighIntake () {
    setHighIntakeSpeed(RobotConstants.HIGH_INTAKE_SPEED);
  }

  public void pushHighIntake () {
    setHighIntakeSpeed(-RobotConstants.HIGH_INTAKE_SPEED);
  }

  public void stopHighIntake() {
    setHighIntakeSpeed(0);
  }

  public boolean getIntakeSensor() {
    return !intakeSensor.get();
  }

  public void updateSmartdashboard () {
    SmartDashboard.putBoolean("Intake Sensor", getIntakeSensor());
  }

}
