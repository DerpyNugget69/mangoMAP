package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

import org.hotutilites.hotlogger.HotLogger;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.Drivetrain;

import static frc.robot.Constants.*;

public class Robot extends TimedRobot {

  private RobotState robotState;
  private TeleopCommander teleopCommander;
  private AutonCommader autonCommander;
  private Drivetrain drivetrain;

  @Override
  public void robotInit() {
    HotLogger.Setup("motorEncoder", "canEncoder", "motorDeg", "RS_leftX",
     "RS_CANCoderTheta", "RS_MotorEncoderTheta", "motorCmd");

    robotState = new RobotState();
    teleopCommander = new TeleopCommander(robotState);
    autonCommander = new AutonCommader(robotState);
    drivetrain = new Drivetrain(robotState);
  }

  @Override
  public void robotPeriodic() {
    drivetrain.updateState();
    drivetrain.logData();
  }

  @Override
  public void disabledInit() {
    drivetrain.zeroActuators();
  }

  @Override
  public void disabledPeriodic() {
    drivetrain.disabledAction(robotState);
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
    drivetrain.enabledAction(robotState, autonCommander);
  }

  @Override
  public void teleopInit() {
    drivetrain.zeroActuators();
    drivetrain.zeroSensor();
  }

  @Override
  public void teleopPeriodic() {
    drivetrain.enabledAction(robotState, teleopCommander);
  }
}
