package frc.robot;

import frc.robot.Autons.AutoRunner;

public class AutonCommader extends RobotCommander{

    AutoRunner auton;

    public AutonCommader(RobotState robotState) {
        auton = new AutoRunner(robotState);
    }

    @Override
    public double getTurnCommand() {
        // TODO Auto-generated method stub
        return 0;
    }


}
