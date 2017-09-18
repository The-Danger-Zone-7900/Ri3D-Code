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

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Subsystems.DriveTrain;
import org.firstinspires.ftc.teamcode.Subsystems.Intakes;
import org.firstinspires.ftc.teamcode.ToolClasses.Constants;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Sample Auto")
public class Autonomous extends LinearOpMode {

    /* Declare OpMode members. */
    Intakes intakes;
    ElapsedTime runtime;
    DriveTrain drive;
    Robot robot;


    @Override
    public void runOpMode(){

        //Initialization Stuff Goes Here.
        robot = new Robot(hardwareMap);
        drive = new DriveTrain(hardwareMap);
        intakes = new Intakes(hardwareMap);
        runtime  = new ElapsedTime();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        //Actual Autonomous Code Goes Here
        runtime.reset();
        while(opModeIsActive()) {
            if(runtime.milliseconds() < 2001) {
                drive.mechDrive(0, 1, 0);
            }
            if(runtime.milliseconds() > 2501 && runtime.milliseconds() < 3501) {
                drive.mechDrive(0, -1, 0);
                intakes.intakes(false, false, false, true);
            }
            if(runtime.milliseconds() > 3501 && runtime.milliseconds() < 4251) {
                intakes.intakes(false, false, false, false);
                drive.mechDrive(0, 0, -1);
            }

        }
    }
}
