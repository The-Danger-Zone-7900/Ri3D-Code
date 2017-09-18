package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.ToolClasses.ActuatorMap;

public class Intakes extends Subsystem{


        //Define Actuators as null
        private static DcMotor left;
        private static DcMotor right;

        //Define variables
        //Constructor (put init things in here)

        public Intakes(HardwareMap hwMap){

            //Add actuators and sensors here
            left = hwMap.dcMotor.get(ActuatorMap.leftIntake);
            right = hwMap.dcMotor.get(ActuatorMap.rightIntake);
            left.setDirection(DcMotor.Direction.REVERSE);

        }

        public synchronized void intakes(boolean cubeLeft, boolean cubeRight,boolean in, boolean out){
                if(cubeLeft){
                    left.setPower(-1);
                    right.setPower(1);
                }
                else if (cubeRight){
                    left.setPower(1);
                    right.setPower(-1);
                }
                else if(in){
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
