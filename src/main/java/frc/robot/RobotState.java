package frc.robot;

import org.hotutilites.hotcontroller.HotController;
import edu.wpi.first.wpilibj.XboxController;
import org.hotutilites.hotlogger.HotLogger;

public class RobotState {
    private double CANCoderTheta; // Degrees
    private static XboxController driver;
    private double motorEncoderTheta; // Degrees
    
    public RobotState() {
        driver = new XboxController(0);
    }

    public XboxController getDriver() {
        return this.driver;
    }

    public void setCANCoderTheta(double CANCoderTheta) {
        this.CANCoderTheta = CANCoderTheta;
    }

    public double getCANCoderTheta() {
        return CANCoderTheta;
    }

    public void setMotorEncoderTheta(double motorEncoderTheta) {
        this.motorEncoderTheta = motorEncoderTheta;
    }

    public double getMotorEncoderTheta() {
        return motorEncoderTheta;
    }

}
