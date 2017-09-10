package org.firstinspires.ftc.teamcode.ToolClasses;

/**
 * Created by max on 6/14/17.
 */

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.Gamepad;


public class Controls{

    public Gamepad gamepad1 = null;
    public Gamepad gamepad2 = null;

    //Pxxx = Primary xxx
    //Sxxx = Secondary xxx

    public synchronized double rotation(){
        return gamepad1.right_stick_x;
    }


    public double forward() {
        return gamepad1.left_stick_y;
    }

    public double strafe() {
        return gamepad1.left_stick_x;
    }

    public boolean intakeIn() {
        if (gamepad2.right_trigger > .05){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean intakeOut() {
        if (gamepad2.left_trigger > .05){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean turnCubeLeft(){
        return gamepad1.left_bumper;
    }

    public boolean turnCubeRight(){
        return gamepad1.right_bumper;
    }
    public boolean liftUp(){
        return gamepad2.y;
    }

    public boolean liftDown(){
        return gamepad2.a;
    }
    public double manualLift(){
        return gamepad2.right_stick_y;
    }
}
