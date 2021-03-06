package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by ariporad on 2017-11-02.
 */

@Autonomous(name="Jewel Test", group="test")
public class JewelDetectorTest extends PulsarAuto {
    @Override
    protected Alliance getAlliance() {
        return Alliance.BLUE;
    }

    @Override
    protected StartPosition getStartPosition() {
        return StartPosition.FRONT;
    }

    @Override
    public void runOpMode() throws InterruptedException {
        ColorSensor jewelDetector = hardwareMap.colorSensor.get("leftJewelDetector");
        while (opModeIsActive()) {
            TargetJewelPosition targetJewelPosition = Alliance.BLUE.getTargetJewel(StartPosition.FRONT, jewelDetector);

            telemetry.addData("saw jewel", targetJewelPosition.toString());
            telemetry.update();
            idle();
        }
    }
}
