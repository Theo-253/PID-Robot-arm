package frc.robot;

import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.*;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import frc.robot.Constants.armConstants;

public class Configs {
    public class arm {
    public static final SparkMaxConfig armMasterConfig = new SparkMaxConfig();
    static {
        armMasterConfig
        .inverted(false)
        .idleMode(IdleMode.kBrake)
        .smartCurrentLimit(armConstants.kOutputLimit);
        armMasterConfig.closedLoop
        .p(Constants.armConstants.kP)
        .i(Constants.armConstants.kI)
        .d(Constants.armConstants.kD)
        .outputRange(Constants.armConstants.kMinOutput, Constants.armConstants.kMaxOutput);
    }
}
}
