// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.States.armPos;
//import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.arm;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final arm m_arm;
  

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private static final XboxController m_driverController = new XboxController(Constants.OperatorConstants.kDriverControllerPort);

      public static final Trigger driver_A = new JoystickButton(m_driverController, 1);
      public static final Trigger driver_B = new JoystickButton(m_driverController, 2);
      public static final Trigger driver_X = new JoystickButton(m_driverController, 3);
      public static final Trigger driver_Y = new JoystickButton(m_driverController, 4);
      public static final Trigger driver_LB = new JoystickButton(m_driverController, 5);
      public static final Trigger driver_RB = new JoystickButton(m_driverController, 6);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    m_arm = arm.getInstance();
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    driver_A.onTrue(
      new RunCommand(() -> m_arm.setArmPos(armPos.acute), m_arm));
    driver_B.onTrue(
      new RunCommand(() -> m_arm.setArmPos(armPos.right), m_arm));
    driver_X.onTrue(
        new RunCommand(() -> m_arm.setArmPos(armPos.obtuse), m_arm));
    driver_Y.onTrue(
      new RunCommand(() -> m_arm.setArmPos(armPos.striaght), m_arm));
    driver_LB.onTrue(
        new RunCommand(() -> m_arm.setArmPos(armPos.fullRot), m_arm));
    driver_RB.onTrue(
      new RunCommand(() -> m_arm.stop(), m_arm));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  // public Command getAutonomousCommand() {
  //   // An example command will be run in autonomous
  //   return Autos.exampleAuto(m_arm);
  }
//}
