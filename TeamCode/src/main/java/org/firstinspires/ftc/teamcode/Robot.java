package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.ToolClasses.Controls;

public class Robot {

    /* local OpMode members. */
    HardwareMap hwMap  =  null;
    private ElapsedTime period  =  new ElapsedTime();

    //Actuators and globals

    /* Constructor */
    public Robot(HardwareMap ahwMap){
        hwMap = ahwMap;
    }

    /* Initialize standard Hardware interfaces */


    public void init() {

        //Skeletal remains of the pre-Max DeVos days.
        //Don't use this.

    }

    public void controllerTelemetry(){


    }

    public void waitForTick(long periodMs) {

        long  remaining = periodMs - (long)period.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0) {
            try {
                Thread.sleep(remaining);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Reset the cycle clock for the next pass.
        period.reset();
    }
}

