package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ToolClasses.ActuatorMap;
import org.firstinspires.ftc.teamcode.ToolClasses.Constants;

public class ElevatorLift extends Subsystem{


        //Define Actuators as null
        private static DcMotor liftMotor;

        //Define variables
        private int selectedPos = 0;
        private boolean manualOverride = false;
        private int[] positions;

        //Constructor (put init things in here)
        public ElevatorLift(HardwareMap ahwMap){
            //This is static
            hwMap = ahwMap;

            //Add actuators and sensors here
            liftMotor = hwMap.dcMotor.get(ActuatorMap.liftMotor);
            positions = new int[]{Constants.firstPosition, Constants.secondPosition, Constants.thirdPosition, Constants.fourthPosition};
        }

        public synchronized void liftPositions(boolean up, boolean down) {
            if (!manualOverride) {
                    
                liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                if (up) {

                    selectedPos += 1;

                } else if (down) {

                    selectedPos -= 1;

                }

                liftMotor.setTargetPosition(positions[selectedPos]);
                liftMotor.setPower(.75);

            }
        }

        public synchronized void liftManual(double amount){

            if(-.1 > amount && .1 < amount){
                    
                liftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                liftMotor.setPower(amount);
                manualOverride = true;

            }

            else{
                manualOverride = false;
            }

        }

}
