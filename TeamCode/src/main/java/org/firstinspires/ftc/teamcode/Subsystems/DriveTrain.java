package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.ToolClasses.ActuatorMap;
import org.firstinspires.ftc.teamcode.ToolClasses.MathHandler;

public class DriveTrain extends Subsystem{


        //Define Actuators as null
        private static DcMotor lfMotor = null;
        private static DcMotor lbMotor = null;
        private static DcMotor rfMotor = null;
        private static DcMotor rbMotor = null;
        private static Servo tail = null;
        //Define variables

    //Constructor (put init things in here)

        public DriveTrain(HardwareMap ahwMap){
            //This is static
            hwMap = ahwMap;

            //Add actuators and sensors here
            lfMotor = ahwMap.dcMotor.get(ActuatorMap.lfMotor);
            lbMotor = ahwMap.dcMotor.get(ActuatorMap.lbMotor);
            rfMotor = ahwMap.dcMotor.get(ActuatorMap.rfMotor);
            rbMotor = ahwMap.dcMotor.get(ActuatorMap.rbMotor);
            tail = ahwMap.servo.get(ActuatorMap.tail);
            rbMotor.setDirection(DcMotor.Direction.REVERSE);
            rfMotor.setDirection(DcMotor.Direction.REVERSE);

            tail = hwMap.servo.get(ActuatorMap.tail);

        }

        public synchronized void init(){



        }

        public synchronized void setTailPos(double pos){
            tail.setPosition(pos);
        }

        public synchronized  void runAllWheels(){
            lfMotor.setPower(1);
            lbMotor.setPower(1);
            rfMotor.setPower(1);
            rbMotor.setPower(1);
        }

        public synchronized void mechDrive(double strafe, double forward, double rotation) {

            lfMotor.setPower(forward + rotation + strafe);
            lbMotor.setPower(forward + rotation - strafe);
            rfMotor.setPower(forward - rotation - strafe);
            rbMotor.setPower(forward - rotation + strafe);
        }

        public synchronized void mechD(double strafe, double forward, double rotation){
            double[] motorInputs = MathHandler.mechanumDrive(strafe, forward, rotation);
            lfMotor.setPower(motorInputs[0]);
            rfMotor.setPower(motorInputs[1]);
            lbMotor.setPower(motorInputs[2]);
            rbMotor.setPower(motorInputs[3]);

        }

        public synchronized void driveAuto(double direction, int distance){

            lfMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rfMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rbMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            lbMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);







        }

}
