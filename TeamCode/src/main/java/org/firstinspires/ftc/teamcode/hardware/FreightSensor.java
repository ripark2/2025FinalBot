package org.firstinspires.ftc.teamcode.hardware;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.ColorSensor;
@Config
public class FreightSensor extends Mechanism{
    public static double lowB = 1.5;
    public static double HighB = 3.5;
    ColorSensor left;
    ColorSensor right;
    @Override
    public void init(HardwareMap hwMap) {

        left = hwMap.get(ColorSensor.class, "color1");
    }
    public boolean hasFreightSensor(ColorSensor color) {
        return ((color.red() + color.green()) / 2 > color.blue() && (color.red()+color.green()) / 2 >= 100); //idk how this works mannn
    }

    public boolean hasFreight(){
        return hasFreightSensor(left);
    }
    public double green() {
        return left.green();
    }
    public double red() {
        return left.red();
    }
    public double blue() {
        return left.blue();
    }

    public boolean hasBlock() {
        return (this.red() / this.blue()) >= lowB && (this.red() / this.blue() <= HighB);
    }
}
