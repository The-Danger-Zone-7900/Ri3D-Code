package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ToolClasses.ActuatorMap;

/**
 * Created by maxcr1 on 9/9/17.
 */

public class Intakes extends Subsystem{


        //Define Actuators as null
        static DcMotor left;
        static DcMotor right;

        //Define variables
        boolean turningCube = false;
        //Constructor (put init things in here)

        public Intakes(HardwareMap ahwMap){
            //This is static
            hwMap = ahwMap;

            //Add actuators and sensors here
            left = hwMap.dcMotor.get(ActuatorMap.leftIntake);
            right = hwMap.dcMotor.get(ActuatorMap.rightIntake);
            left.setDirection(DcMotorSimple.Direction.REVERSE);

        }

        public static void init(){


        }

        public synchronized void turnCube(boolean cubeLeft, boolean cubeRight){
            if(cubeLeft){
                left.setPower(-1);
                right.setPower(1);
                turningCube = true;
            }
            else if (cubeRight){
                left.setPower(1);
                right.setPower(-1);
                turningCube = true;
            }
            else{
                left.setPower(0);
                right.setPower(0);
                turningCube = false;
            }

        }

        public synchronized void intake(boolean in, boolean out){
            if(!turningCube){
                if(in){
                    left.setPower(-1);
                    right.setPower(-1);
                }
                else if (out){
                    left.setPower(1);
                    right.setPower(1);
                }
                else{
                    left.setPower(0);
                    right.setPower(0);
                }
            }
        }


}
