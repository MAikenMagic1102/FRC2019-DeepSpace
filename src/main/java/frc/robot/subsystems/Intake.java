package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;


public class Intake{

    //Balls
    //Hatch Pantels

    TalonSRX ball_intake;
    TalonSRX hatch_intake;

    Counter hatch_encoder;

    DigitalInput up_lim;
    DigitalInput down_lim;

    String last_position = "";

    Intake(){
        // ball_intake = new TalonSRX(8);
        // hatch_intake = new TalonSRX(9);

        // hatch_encoder = new Counter(0);

        // up_lim = new DigitalInput(1);
        // down_lim = new DigitalInput(2);
    }
    
    void ball_forward(double power){
        ball_intake.set(ControlMode.PercentOutput, 0.75);
    }
    void ball_reverse(double power){
        ball_intake.set(ControlMode.PercentOutput, -0.75);
    }
    void ball_stop(double power){
        ball_intake.set(ControlMode.PercentOutput, 0.0);
    }


    void hatch_manual(double input){
        hatch_intake.set(ControlMode.PercentOutput, input);
    }

    void hatch_up(){
        if(!up_lim.get()){
            hatch_intake.set(ControlMode.PercentOutput, 1.0);
        }else{
            hatch_stop();
            last_position = "up";
            hatch_encoder.reset();
        }
    }

    void hatch_down(){
        if(!down_lim.get()){
            hatch_intake.set(ControlMode.PercentOutput, -1.0);
        }else{
            hatch_stop();
            last_position = "down";
            hatch_encoder.reset();
        }
    }

    void hatch_neutral(){
        if(hatch_encoder.get() < 44 && last_position.equals("down")){
            hatch_intake.set(ControlMode.PercentOutput, 1.0);
        }else{
            if(hatch_encoder.get() > -44 && last_position.equals("up")){
                hatch_intake.set(ControlMode.PercentOutput, -1.0);
            }else{
                hatch_intake.set(ControlMode.PercentOutput, 0.0);

            }
        }
    }

    void hatch_stop(){
        hatch_intake.set(ControlMode.PercentOutput, 0.0);
    }

}