
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import java.text.DecimalFormat;

import frc.robot.Configs;
import frc.robot.Constants.armConstants;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.Command;

public class arm extends SubsystemBase {
  public final SparkMax masterSparkMax;
  private final RelativeEncoder m_masterEncoder;
  //private SparkClosedLoopController pidController;
  
private static class armHandler {
  private static final arm instance = new arm();
}

public static arm getInstance() {
    return armHandler.instance;
}

  public arm() {
    masterSparkMax = new SparkMax(armConstants.kArmCanId, MotorType.kBrushless);
    m_masterEncoder = masterSparkMax.getEncoder();
    masterSparkMax.configure(Configs.arm.armMasterConfig, ResetMode.kResetSafeParameters,
        PersistMode.kPersistParameters);
  }

  public void setPercentageOpenLoop(double value) {
    SmartDashboard.putNumber("Intake Running Speed", value);
    masterSparkMax.set(value);
}

public void stop(){
  setPercentageOpenLoop(0);
}
  
/**
   * Example command factory method.
   *
   * @return a command
   */
  public Command spin() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          setPercentageOpenLoop(-0.1);
        });
  }

  public Command stopSpin() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          stop();
        });
  }
  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
