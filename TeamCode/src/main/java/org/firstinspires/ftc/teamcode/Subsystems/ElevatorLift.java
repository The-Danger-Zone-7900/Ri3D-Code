package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ToolClasses.ActuatorMap;
import org.firstinspires.ftc.teamcode.ToolClasses.Constants;

/**
 * Created by maxcr1 on 9/9/17.
 */

public class ElevatorLift extends Subsystem{


        Constants constants = new Constants();

        //Define Actuators as null
        static DcMotor liftMotor;

        //Define variables
        int selectedPos = 0;
        boolean manualOverride = false;
        int[] positions = {constants.firstPosition, constants.secondPosition, constants.thirdPosition, constants.fourthPosition};

        //Constructor (put init things in here)
        public ElevatorLift(HardwareMap ahwMap){
            //This is static
            hwMap = ahwMap;

            //Add actuators and sensors here
            liftMotor = hwMap.dcMotor.get(ActuatorMap.liftMotor);
        }

        public static void init(){

            liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        }

        public synchronized void liftPositions(boolean up, boolean down) {
            if (!manualOverride) {

                if (up) {

                    selectedPos += 1;

                } else if (down) {

                    selectedPos -= 1;

                }

                liftMotor.setTargetPosition(positions[selectedPos]);


            }
        }

        public synchronized void liftManual(double amount){

            if(-.1 > amount && .1 < amount){

                liftMotor.setPower(amount);
                manualOverride = true;

            }

            else{
                manualOverride = false;
            }

        }

}
