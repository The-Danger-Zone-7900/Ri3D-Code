/*
Copyright (c) 2016 Robert Atkinson

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Robert Atkinson nor the names of his contributors may be used to
endorse or promote products derived from this software without specific prior
written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESSFOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Subsystems.DriveTrain;
import org.firstinspires.ftc.teamcode.Subsystems.ElevatorLift;
import org.firstinspires.ftc.teamcode.Subsystems.Intakes;
import org.firstinspires.ftc.teamcode.ToolClasses.ActuatorMap;
import org.firstinspires.ftc.teamcode.ToolClasses.Controls;


@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Tele-Op")
public class TeleOp extends OpMode{

    /* Declare OpMode members. */
    Robot robot = new Robot(hardwareMap);
    private Controls controls;
    private DriveTrain drive;
    private Intakes intakes;
    private ElevatorLift elevatorLift;




    @Override
    public void init() {
        elevatorLift = new ElevatorLift(hardwareMap);
        intakes  = new Intakes(hardwareMap);
        controls = new Controls(gamepad1, gamepad2);
        drive = new DriveTrain(hardwareMap);
        telemetry.addData("Say", "Initializing");

        //Put init functions here
      //  drive.init();

        telemetry.addData("Say", "Initializing Complete");

    }

    @Override
    public void init_loop() {

        //This really doesn't serve any purpose

    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {

        //This really doesn't serve any purpose
        telemetry.addData("Say", "Start!");
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {

        drive.mechDrive(controls.strafe(), controls.forward(), controls.rotation());
        //drive.mechDrive(controls.strafe(), controls.forward(), controls.rotation());
        intakes.intakes(controls.turnCubeLeft(), controls.turnCubeRight(), controls.intakeIn(), controls.intakeOut());
        elevatorLift.liftManual(controls.liftUp(), controls.liftDown());



        robot.waitForTick(10);
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {

        telemetry.addData("Say", "Robot Stopped");

    }

}
