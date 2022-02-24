package frc.robot.subsystems;

import frc.robot.RobotState;

import org.hotutilites.hotlogger.HotLogger;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotCommander;

public abstract class SubsystemBase {
    public abstract void enabledAction(RobotState robotState, RobotCommander commander);

    public abstract void disabledAction(RobotState robotState);

    public abstract void updateState();

    public abstract void zeroActuators();

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
