package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Arm{

    private TalonSRX arm;

    public enum Mode{
        MANUAL,
        HOLD,
        POSITION,
        MOTION_MAGIC
    };

    public Mode currentMode = Mode.MANUAL;

    public Arm(){
        arm = new TalonSRX(9);
    }

    public void set(double power){
        currentMode = Mode.MANUAL;
        arm.set(ControlMode.PercentOutput, power);
    }

    public double getMotorOutputVoltage(){
        return arm.getMotorOutputVoltage();
    }

    public double getMotorOutputCurrent(){
        return arm.getOutputCurrent();
    }
    

    
}