package frc.robot;

public class MathUtil {
    public static double adjustJoystick(double value) {
        double deadband = 0.1;
        double power = 3;
        double root = 1;

        if (-deadband < value && value < deadband) {
            return 0;
        } else {
            if (value > 0) {
                return Math.pow((value - deadband) / (1 - deadband), power / root);
            } else {
                int sign = (power / root % 2 != 0) ? 1 : -1;
                return sign * Math.pow((value + deadband) / (1 - deadband), power / root);
            }
        }
    }
}
