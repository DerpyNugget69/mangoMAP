package frc.robot;

import org.hotutilites.hotcontroller.HotController;

public class RobotState {
    private double CANCoderTheta; // Degrees
    private double motorEncoderTheta; // Degrees
    private HotController driver;
    
    driver = new HotController(0);

    public HotController getDriver() {
        return driver;
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
