package frc.robot.sensors;

import org.hotutilites.hotlogger.HotLogger;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotCommander;
import frc.robot.RobotState;

public abstract class SensorBase {
    public abstract void updateState(RobotState robotState, RobotCommander commander);

    public abstract void zeroSensor();

    public abstract void logData();

    public void log(String msg, double data){
        SmartDashboard.putNumber(msg, data);
        HotLogger.Log(msg, data);
    }
    public void log(String msg, String data){
        SmartDashboard.putString(msg, data);
        HotLogger.Log(msg, data);
    }
    public void log(String msg, boolean data){
        SmartDashboard.putBoolean(msg, data);
        HotLogger.Log(msg, data);
    }
}