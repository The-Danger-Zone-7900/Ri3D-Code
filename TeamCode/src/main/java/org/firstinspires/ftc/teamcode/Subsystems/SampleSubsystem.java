package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ToolClasses.ActuatorMap;

/**
 * Created by maxcr1 on 9/9/17.
 */

public class SampleSubsystem extends Subsystem{


        //Define Actuators as null
        static DcMotor sampleMotor = null;

        //Define variables

        //Constructor (put init things in here)

        public SampleSubsystem(HardwareMap ahwMap){
            //This is static
            hwMap = ahwMap;

            //Add actuators and sensors here
            sampleMotor = hwMap.dcMotor.get(ActuatorMap.sampleMotor);
        }

        public static void init(boolean auto){
            if(auto){

                sampleMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            }
            else{

                sampleMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

            }
        }

        public static void runMotorPosition(int pos){

            sampleMotor.setTargetPosition(pos);

        }

        public static void runMotorSpeed(double speed){
            sampleMotor.setPower(speed);
        }

}
