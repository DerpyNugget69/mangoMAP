package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.CANCoder;
import com.swervedrivespecialties.swervelib.AbsoluteEncoder;
import com.swervedrivespecialties.swervelib.Mk4SwerveModuleHelper;
import com.swervedrivespecialties.swervelib.Mk4iSwerveModuleHelper;
import com.swervedrivespecialties.swervelib.SwerveModule;

import org.hotutilites.hotlogger.HotLogger;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInLayouts;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.AutonCommader;
import frc.robot.RobotCommander;
import frc.robot.RobotState;

import static frc.robot.Constants.*;

public class Drivetrain extends SubsystemBase{

    private final SwerveModule frontLeftModule;
    private final SwerveModule frontRightModule;
    private final SwerveModule backLeftModule;
    private final SwerveModule backRightModule;

    private TalonFX frontLeftDrive;
    private TalonFX frontRightDrive;
    private TalonFX backLeftDrive;
    private TalonFX backRightDrive;

    private TalonFX frontLeftSteer;
    private TalonFX frontRightSteer;
    private TalonFX backLeftSteer;
    private TalonFX backRightSteer;
    
    private CANCoder frontLeftEncoder;
    private CANCoder frontRightEncoder;
    private CANCoder backLeftEncoder;
    private CANCoder backRightEncoder;

    private ChassisSpeeds chassisSpeeds = new ChassisSpeeds(0.0, 0.0, 0.0);

    private SwerveModuleState[] states;

    private final SwerveDriveKinematics kinematics = new SwerveDriveKinematics(
        new Translation2d(DRIVETRAIN_TRACKWIDTH_METERS / 2.0, DRIVETRAIN_WHEELBASE_METERS / 2.0),
        new Translation2d(DRIVETRAIN_TRACKWIDTH_METERS / 2.0, -DRIVETRAIN_WHEELBASE_METERS / 2.0),
        new Translation2d(-DRIVETRAIN_TRACKWIDTH_METERS / 2.0, DRIVETRAIN_WHEELBASE_METERS / 2.0),
        new Translation2d(-DRIVETRAIN_TRACKWIDTH_METERS / 2.0, -DRIVETRAIN_WHEELBASE_METERS / 2.0));

    public Drivetrain(RobotState robotState) {        
        ShuffleboardTab tab = Shuffleboard.getTab("Drivetrain");
    
        if (realBot){
            frontLeftModule = Mk4iSwerveModuleHelper.createFalcon500(
                    tab.getLayout("Front Left Module", BuiltInLayouts.kList)
                            .withSize(2, 4)
                            .withPosition(0, 0),
                    Mk4iSwerveModuleHelper.GearRatio.L2,
                    FRONT_LEFT_MODULE_DRIVE_MOTOR,
                    FRONT_LEFT_MODULE_STEER_MOTOR,
                    FRONT_LEFT_MODULE_STEER_ENCODER,
                    FRONT_LEFT_MODULE_STEER_OFFSET
            );
        
            frontRightModule = Mk4iSwerveModuleHelper.createFalcon500(
                    tab.getLayout("Front Right Module", BuiltInLayouts.kList)
                            .withSize(2, 4)
                            .withPosition(2, 0),
                    Mk4iSwerveModuleHelper.GearRatio.L2,
                    FRONT_RIGHT_MODULE_DRIVE_MOTOR,
                    FRONT_RIGHT_MODULE_STEER_MOTOR,
                    FRONT_RIGHT_MODULE_STEER_ENCODER,
                    FRONT_RIGHT_MODULE_STEER_OFFSET
            );
        
            backLeftModule = Mk4iSwerveModuleHelper.createFalcon500(
                    tab.getLayout("Back Left Module", BuiltInLayouts.kList)
                            .withSize(2, 4)
                            .withPosition(4, 0),
                    Mk4iSwerveModuleHelper.GearRatio.L2,
                    BACK_LEFT_MODULE_DRIVE_MOTOR,
                    BACK_LEFT_MODULE_STEER_MOTOR,
                    BACK_LEFT_MODULE_STEER_ENCODER,
                    BACK_LEFT_MODULE_STEER_OFFSET
            );
        
            backRightModule = Mk4iSwerveModuleHelper.createFalcon500(
                    tab.getLayout("Back Right Module", BuiltInLayouts.kList)
                            .withSize(2, 4)
                            .withPosition(6, 0),
                    Mk4iSwerveModuleHelper.GearRatio.L2,
                    BACK_RIGHT_MODULE_DRIVE_MOTOR,
                    BACK_RIGHT_MODULE_STEER_MOTOR,
                    BACK_RIGHT_MODULE_STEER_ENCODER,
                    BACK_RIGHT_MODULE_STEER_OFFSET
            );
        } else {
            frontLeftModule = Mk4SwerveModuleHelper.createFalcon500(
                    tab.getLayout("Front Left Module", BuiltInLayouts.kList)
                            .withSize(2, 4)
                            .withPosition(0, 0),
                    Mk4SwerveModuleHelper.GearRatio.L2,
                    FRONT_LEFT_MODULE_DRIVE_MOTOR,
                    FRONT_LEFT_MODULE_STEER_MOTOR,
                    FRONT_LEFT_MODULE_STEER_ENCODER,
                    FRONT_LEFT_MODULE_STEER_OFFSET
            );
        
            frontRightModule = Mk4SwerveModuleHelper.createFalcon500(
                    tab.getLayout("Front Right Module", BuiltInLayouts.kList)
                            .withSize(2, 4)
                            .withPosition(2, 0),
                    Mk4SwerveModuleHelper.GearRatio.L2,
                    FRONT_RIGHT_MODULE_DRIVE_MOTOR,
                    FRONT_RIGHT_MODULE_STEER_MOTOR,
                    FRONT_RIGHT_MODULE_STEER_ENCODER,
                    FRONT_RIGHT_MODULE_STEER_OFFSET
            );
        
            backLeftModule = Mk4SwerveModuleHelper.createFalcon500(
                    tab.getLayout("Back Left Module", BuiltInLayouts.kList)
                            .withSize(2, 4)
                            .withPosition(4, 0),
                    Mk4SwerveModuleHelper.GearRatio.L2,
                    BACK_LEFT_MODULE_DRIVE_MOTOR,
                    BACK_LEFT_MODULE_STEER_MOTOR,
                    BACK_LEFT_MODULE_STEER_ENCODER,
                    BACK_LEFT_MODULE_STEER_OFFSET
            );
        
            backRightModule = Mk4SwerveModuleHelper.createFalcon500(
                    tab.getLayout("Back Right Module", BuiltInLayouts.kList)
                            .withSize(2, 4)
                            .withPosition(6, 0),
                    Mk4SwerveModuleHelper.GearRatio.L2,
                    BACK_RIGHT_MODULE_DRIVE_MOTOR,
                    BACK_RIGHT_MODULE_STEER_MOTOR,
                    BACK_RIGHT_MODULE_STEER_ENCODER,
                    BACK_RIGHT_MODULE_STEER_OFFSET
            );
        }

        frontLeftDrive = (TalonFX) frontLeftModule.getDriveMotor();
        frontRightDrive = (TalonFX) frontRightModule.getDriveMotor();
        backLeftDrive = (TalonFX) backLeftModule.getDriveMotor();
        backRightDrive = (TalonFX) backRightModule.getDriveMotor();
        
        frontLeftSteer = (TalonFX) frontLeftModule.getSteerMotor();
        frontRightSteer = (TalonFX) frontRightModule.getSteerMotor();
        backLeftSteer = (TalonFX) backLeftModule.getSteerMotor();
        backRightSteer = (TalonFX) backRightModule.getSteerMotor();

        frontLeftEncoder = frontLeftModule.getSteerEncoder();
        frontRightEncoder = frontRightModule.getSteerEncoder();
        backLeftEncoder = backLeftModule.getSteerEncoder();
        backRightEncoder = backRightModule.getSteerEncoder();
    }

    @Override
    public void enabledAction(RobotState robotState, RobotCommander commander) {        
        setBrakeMode(true);
        
        chassisSpeeds = ChassisSpeeds.fromFieldRelativeSpeeds(
            commander.getForwardCommand(),
            commander.getStrafeCommand(),
            commander.getTurnCommand(), 
            Rotation2d.fromDegrees(robotState.getTheta()));

        states = kinematics.toSwerveModuleStates(chassisSpeeds);
        SwerveDriveKinematics.desaturateWheelSpeeds(states, MAX_VELOCITY_METERS_PER_SECOND);

        frontLeftModule.set(states[0].speedMetersPerSecond / MAX_VELOCITY_METERS_PER_SECOND * MAX_VOLTAGE, states[0].angle.getRadians());
        frontRightModule.set(states[1].speedMetersPerSecond / MAX_VELOCITY_METERS_PER_SECOND * MAX_VOLTAGE, states[1].angle.getRadians());
        backLeftModule.set(states[2].speedMetersPerSecond / MAX_VELOCITY_METERS_PER_SECOND * MAX_VOLTAGE, states[2].angle.getRadians());
        backRightModule.set(states[3].speedMetersPerSecond / MAX_VELOCITY_METERS_PER_SECOND * MAX_VOLTAGE, states[3].angle.getRadians());        
    }

    @Override
    public void disabledAction(RobotState robotState) {
        setBrakeMode(false);
    }

    @Override
    public void updateState() {
        // Constantly update the motors and encoders
        frontLeftDrive = (TalonFX) frontLeftModule.getDriveMotor();
        frontRightDrive = (TalonFX) frontRightModule.getDriveMotor();
        backLeftDrive = (TalonFX) backLeftModule.getDriveMotor();
        backRightDrive = (TalonFX) backRightModule.getDriveMotor();
        
        frontLeftSteer = (TalonFX) frontLeftModule.getSteerMotor();
        frontRightSteer = (TalonFX) frontRightModule.getSteerMotor();
        backLeftSteer = (TalonFX) backLeftModule.getSteerMotor();
        backRightSteer = (TalonFX) backRightModule.getSteerMotor();

        frontLeftEncoder = frontLeftModule.getSteerEncoder();
        frontRightEncoder = frontRightModule.getSteerEncoder();
        backLeftEncoder = backLeftModule.getSteerEncoder();
        backRightEncoder = backRightModule.getSteerEncoder();
    }

    @Override
    public void zeroActuators() {
        frontLeftModule.set(0, 0);
        frontRightModule.set(0, 0);
        backLeftModule.set(0, 0);
        backRightModule.set(0, 0);
    }

    @Override
    public void zeroSensor() {

    }

    @Override
    public void logData() {
        // Absolute Steer Encoders
        log("Left Front Steer Absolute", Math.toDegrees(frontLeftEncoder.getAbsolutePosition()));
        log("Right Front Steer Absolute", Math.toDegrees(frontRightEncoder.getAbsolutePosition()));
        log("Left Rear Steer Absolute", Math.toDegrees(backLeftEncoder.getAbsolutePosition()));
        log("Right Rear Steer Absolute", Math.toDegrees(backRightEncoder.getAbsolutePosition()));

        // Assumed Steer Encoders
        log("Left Front Steer Assumed", frontLeftSteer.getSelectedSensorPosition());
        log("Right Front Steer Assumed", frontRightSteer.getSelectedSensorPosition());
        log("Left Rear Steer Assumed", backLeftSteer.getSelectedSensorPosition());
        log("Right Rear Steer Assumed", backRightSteer.getSelectedSensorPosition());

        // Drive Encoders
        log("Left Front Drive", frontLeftDrive.getSelectedSensorPosition());
        log("Right Front Drive", frontRightDrive.getSelectedSensorPosition());
        log("Left Rear Drive", backLeftDrive.getSelectedSensorPosition());
        log("Right Rear Drive", backRightDrive.getSelectedSensorPosition());
    }

    public void setBrakeMode(boolean brakes){
        if(brakes){
                frontLeftDrive.setNeutralMode(NeutralMode.Brake);
                frontRightDrive.setNeutralMode(NeutralMode.Brake);
                backLeftDrive.setNeutralMode(NeutralMode.Brake);
                backRightDrive.setNeutralMode(NeutralMode.Brake);

                frontLeftSteer.setNeutralMode(NeutralMode.Brake);
                frontRightSteer.setNeutralMode(NeutralMode.Brake);
                backLeftSteer.setNeutralMode(NeutralMode.Brake);
                backRightSteer.setNeutralMode(NeutralMode.Brake);
        } else {
                frontLeftDrive.setNeutralMode(NeutralMode.Coast);
                frontRightDrive.setNeutralMode(NeutralMode.Coast);
                backLeftDrive.setNeutralMode(NeutralMode.Coast);
                backRightDrive.setNeutralMode(NeutralMode.Coast);

                frontLeftSteer.setNeutralMode(NeutralMode.Coast);
                frontRightSteer.setNeutralMode(NeutralMode.Coast);
                backLeftSteer.setNeutralMode(NeutralMode.Coast);
                backRightSteer.setNeutralMode(NeutralMode.Coast);
        }
    }
}
