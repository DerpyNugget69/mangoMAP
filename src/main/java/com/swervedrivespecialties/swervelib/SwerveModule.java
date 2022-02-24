package com.swervedrivespecialties.swervelib;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.CANCoder;

public interface SwerveModule {
    double getDriveVelocity();

    double getSteerAngle();

    Object getDriveMotor();

    Object getSteerMotor();

    AbsoluteEncoder getSteerEncoder();

    void set(double driveVoltage, double steerAngle);
}
