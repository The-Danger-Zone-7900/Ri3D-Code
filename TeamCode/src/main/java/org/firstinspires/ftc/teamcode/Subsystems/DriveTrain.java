package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ToolClasses.ActuatorMap;
import org.firstinspires.ftc.teamcode.ToolClasses.MathHandler;

public class DriveTrain extends Subsystem{


        //Define Actuators as null
        private static DcMotor lfMotor;
        private static DcMotor lbMotor;
        private static DcMotor rfMotor;
        private static DcMotor rbMotor;
        //Define variables

    //Constructor (put init things in here)

        public DriveTrain(HardwareMap ahwMap){
            //This is static
            hwMap = ahwMap;

            //Add actuators and sensors here
            lfMotor = hwMap.dcMotor.get(ActuatorMap.lfMotor);
            lbMotor = hwMap.dcMotor.get(ActuatorMap.lbMotor);
            rfMotor = hwMap.dcMotor.get(ActuatorMap.rfMotor);
            rbMotor = hwMap.dcMotor.get(ActuatorMap.rbMotor);
            rbMotor.setDirection(DcMotor.Direction.REVERSE);
            rfMotor.setDirection(DcMotor.Direction.REVERSE);


        }

        public synchronized void init(){



        }

        public synchronized void mechDrive(double strafe, double forward, double rotation){
            double[] motorInputs = MathHandler.mechanumDrive(strafe, forward, rotation);
            lfMotor.setPower(motorInputs[0]);
            rfMotor.setPower(motorInputs[1]);
            lbMotor.setPower(motorInputs[2]);
            rbMotor.setPower(motorInputs[3]);

        }

}
