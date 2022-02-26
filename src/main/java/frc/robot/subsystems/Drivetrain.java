package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.CANCoder;
import com.ctre.phoenix.motorcontrol.ControlMode;
import org.hotutilites.hotlogger.HotLogger;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.AutonCommader;
import frc.robot.RobotCommander;
import frc.robot.RobotState;

import static frc.robot.Constants.*;

public class Drivetrain extends SubsystemBase{
CANCoder canCoder;
TalonFX turnTalonFX; 
private RobotState robotState;
double canEncoder;
double motorEncoder;
double motorDeg;
double motorCmd;

public Drivetrain(RobotState robotState) {
        canCoder = new CANCoder(ABSOLUTE_ENCODER);
        turnTalonFX = new TalonFX(TURN_MOTOR);
        this.robotState = robotState;
        this.zeroSensor();
}

 @Override
public void enabledAction(RobotState robotState, RobotCommander commander) {
        this.setTurnBrake(true);
        motorCmd = commander.getTurnCommand();
        if (commander.getZeroEncoders()) {
                this.zeroSensor();
        }
        turnTalonFX.set(ControlMode.PercentOutput, motorCmd);
                
}

@Override
public void disabledAction(RobotState robotState) {
        this.setTurnBrake(false);
                
}

@Override
public void updateState() {
        canEncoder = canCoder.getPosition();
        motorEncoder = turnTalonFX.getSelectedSensorPosition();
        motorDeg = (motorEncoder / 122.0);

        robotState.setMotorEncoderTheta(motorDeg);
        robotState.setCANCoderTheta(canEncoder);


}

@Override
public void zeroActuators() {
             
}

@Override
public void zeroSensor() {
        canCoder.setPosition(0.0);
        turnTalonFX.setSelectedSensorPosition(0.0);  
                
}

@Override
public void logData() {
        HotLogger.Log("motorEncoder", motorEncoder);
        SmartDashboard.putNumber("motorEncoder", motorEncoder);
        HotLogger.Log("canEncoder", canEncoder);
        SmartDashboard.putNumber("canEncoder", canEncoder);
        HotLogger.Log("motorDeg", motorDeg);
        SmartDashboard.putNumber("motorDeg", motorDeg);
        HotLogger.Log("RS_leftX", robotState.getDriver().getLeftX());
        SmartDashboard.putNumber("RS_leftX", robotState.getDriver().getLeftX());
        HotLogger.Log("RS_CANCoderTheta", robotState.getCANCoderTheta());
        SmartDashboard.putNumber("RS_CANCoderTheta", robotState.getCANCoderTheta());
        HotLogger.Log("RS_MotorEncoderTheta", robotState.getMotorEncoderTheta());
        SmartDashboard.putNumber("RS_MotorEncoderTheta", robotState.getMotorEncoderTheta());
        HotLogger.Log("motorCmd", motorCmd);
        SmartDashboard.putNumber("motorCmd", motorCmd);
                
}

public void setTurnBrake(boolean brake){
        if(brake == true){
            turnTalonFX.setNeutralMode(NeutralMode.Brake);
        }
        else{
            turnTalonFX.setNeutralMode(NeutralMode.Coast);
        }
    }

}
