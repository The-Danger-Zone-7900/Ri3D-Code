package org.firstinspires.ftc.teamcode.ToolClasses;

/**
 * Created by maxcr1 on 9/9/17.
 */

public class MathHandler {



    //V_d = desired robot speed, theta_d = desired robot velocity angle, V_theta = desired robot rotational speed
    public static double[] mechanumDrive(double left_stick_x, double left_stick_y, double right_stick_x){

        double mSpeed = Math.sqrt(Math.pow(left_stick_x, 2) +
                Math.pow(left_stick_y, 2));
        double theta = Math.atan2(left_stick_y, left_stick_x);
        double rSpeed = right_stick_x;


        double flWheel = mSpeed*Math.sin(theta + Math.PI/4) + rSpeed;
        double frWheel = mSpeed*Math.cos(theta + Math.PI/4) - rSpeed;
        double blWheel = mSpeed*Math.cos(theta + Math.PI/4) + rSpeed;
        double brWheel = mSpeed*Math.sin(theta + Math.PI/4) - rSpeed;


        return new double[]{flWheel, frWheel, blWheel, brWheel};



        /*
        V_{front,left} = V_d sin(theta_d + pi/4) + V_theta
        V_{front,right} = V_d cos(theta_d + pi/4) - V_theta
        V_{back,left} = V_d cos(theta_d + pi/4) + V_theta
        V_{back,right} = V_d sin(theta_d + pi/4) - V_theta

*/

    }
    }
