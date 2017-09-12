package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ToolClasses.ActuatorMap;
import org.firstinspires.ftc.teamcode.ToolClasses.Constants;

public class ElevatorLift extends Subsystem{


        //Define Actuators as null
        private static DcMotor liftMotor;

        //Define variables
        private int position;

        //Constructor (put init things in here)
        public ElevatorLift(HardwareMap ahwMap){
            //This is static
            hwMap = ahwMap;

            //Add actuators and sensors here
            liftMotor = hwMap.dcMotor.get(ActuatorMap.liftMotor);
        }


        public synchronized void liftManual(boolean up, boolean down){

            if(up){

                liftMotor.setPower(1);

            }

            else if(down){

                liftMotor.setPower(-1);

            }

            else{
                liftMotor.setPower(0);
            }

        }

}
