package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.CANCoder;
import com.swervedrivespecialties.swervelib.Mk4SwerveModuleHelper;
import com.swervedrivespecialties.swervelib.Mk4iSwerveModuleHelper;
import com.swervedrivespecialties.swervelib.SwerveModule;

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

public Drivetrain(RobotState robotState) {
        canCoder = new CANCoder(ABSOLUTE_ENCODER);
        turnTalonFX = new TalonFX(TURN_MOTOR);
        this.robotState = robotState;
}

 @Override
public void enabledAction(RobotState robotState, RobotCommander commander) {
        this.setTurnBrake(true);
                
}

@Override
public void disabledAction(RobotState robotState) {
        this.setTurnBrake(false);
                
}

@Override
public void updateState() {


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
