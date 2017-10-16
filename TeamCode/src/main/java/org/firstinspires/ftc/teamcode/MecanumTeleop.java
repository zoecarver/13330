package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Duncan on 9/19/2017.
 */

@TeleOp(name = "mecanum")
public class MecanumTeleop extends OpMode{

    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;

    @Override
    public void init() {
        frontLeft = hardwareMap.dcMotor.get("fl");
        frontRight = hardwareMap.dcMotor.get("fr");
        backLeft = hardwareMap.dcMotor.get("bl");
        backRight = hardwareMap.dcMotor.get("br");
        //frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        //backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    /*
    Motor layout:



    fl fr

    bl br
     */

    float frontLeftPower, frontRightPower, backLeftPower, backRightPower;

    @Override
    public void loop() {
        drive();
    }

    private void drive() {
        frontLeftPower = (gamepad1.right_stick_y /*FORWARD POWER*/) + (gamepad1.right_stick_x /*SIDE POWER*/) + (gamepad1.left_stick_x /*TURN POWER*/);
        frontRightPower = (gamepad1.right_stick_y /*FORWARD POWER*/) - (gamepad1.right_stick_x /*SIDE POWER*/) - (gamepad1.left_stick_x /*TURN POWER*/);
        backRightPower = (gamepad1.right_stick_y /*FORWARD POWER*/) + (gamepad1.right_stick_x /*SIDE POWER*/) - (gamepad1.left_stick_x /*TURN POWER*/);
        backLeftPower = (gamepad1.right_stick_y /*FORWARD POWER*/) - (gamepad1.right_stick_x /*SIDE POWER*/) + (gamepad1.left_stick_x /*TURN POWER*/);



        frontLeft.setPower(frontLeftPower);
        frontRight.setPower(frontRightPower);
        backRight.setPower(backRightPower);
        backLeft.setPower(backLeftPower);
    }
}