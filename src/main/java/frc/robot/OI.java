/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.IntakeShootCommandGroup;
import frc.robot.commands.ShootCommandGroup;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  
  XboxController controller = new XboxController(0);

  /* Button 2 --> The B Button */
  JoystickButton autoShoot;
  /* Button 3 --> The X Button */
  JoystickButton autoIntakeShoot;
  /* Button 4 --> The Y Button */
  JoystickButton intake;

  public OI () {
    autoShoot = new JoystickButton(controller, 2);
    autoShoot.whenPressed(new ShootCommandGroup());

    autoIntakeShoot = new JoystickButton(controller, 3);
    autoIntakeShoot.whenPressed(new IntakeShootCommandGroup());

    intake = new JoystickButton(controller, 4);
    intake.whenPressed(new IntakeCommand(RobotConstants.INTAKE_DURATION));
  }

  public double getSpeed () {
    return -controller.getY(Hand.kLeft); 
  } 

  public double getTurn () {
    return controller.getX(Hand.kRight);
  }

  public boolean pullIntake () { 
    return controller.getBumper(Hand.kLeft);
  }

  public boolean pushIntake () {
    return controller.getBumper(Hand.kRight);
  }

  public boolean startShooter () {
    return controller.getTriggerAxis(Hand.kLeft) > RobotConstants.DEADBAND;
  }

  public boolean feedShooter () {
    return controller.getTriggerAxis(Hand.kRight) > RobotConstants.DEADBAND;
  }

}
