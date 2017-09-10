package org.firstinspires.ftc.teamcode.ToolClasses;

/**
 * Created by max on 6/14/17.
 */

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.Gamepad;


public class Controls{

    public Gamepad gamepad1 = null;

    //Pxxx = Primary xxx
    //Sxxx = Secondary xxx

    public synchronized double motorPower(){
        return gamepad1.left_stick_y;
    }


}
