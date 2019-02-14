package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


public class Intake{

    //Balls
    //Hatch Pantels

    TalonSRX ball_intake;

    DoubleSolenoid hatch_intake;

    public Intake(){
         ball_intake = new TalonSRX(8);
         hatch_intake = new DoubleSolenoid(1, 4,5);
    }
    
    public void ball_forward(){
        ball_intake.set(ControlMode.PercentOutput, 0.75);
    }
    
    public void ball_reverse(){
        ball_intake.set(ControlMode.PercentOutput, -0.75);
    }
    
    public void ball_stop(){
        ball_intake.set(ControlMode.PercentOutput, 0.0);
    }

    public void hatch_clamp(){
        hatch_intake.set(Value.kForward);
    }

    public void hatch_release(){
        hatch_intake.set(Value.kReverse);
    }

}