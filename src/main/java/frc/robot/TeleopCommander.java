package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

import static frc.robot.Constants.*;

public class TeleopCommander extends RobotCommander{

    RobotState robotState;

    public TeleopCommander(RobotState robotState) {
        this.robotState = robotState;
    }



    private static double deadband(double value, double deadband, double maxRange){
      /* Schang changed math so command is scaled from the deadband->max as 0->1 */
      /* The maxRange arguement is to scale the joystick range to a maximum value */
        if(Math.abs(value) < deadband){
          return 0;
        } else if (value < 0) {
          return  ((value + deadband)/(1.0 - deadband)) * maxRange;
        } else {
          return  ((value - deadband)/(1.0 - deadband)) * maxRange;
        }
      }



    @Override
    public double getTurnCommand() {
      return deadband(robotState.getDriver().getLeftX(), 0.25, 0.2);
    }
    


}
