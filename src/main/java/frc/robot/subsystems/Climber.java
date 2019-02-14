package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class Climber {
    //TO DO:
    //Create default constructor that initializes a double solenoid!
    //Create a method that sets a Double Solenoid to kForward and another method for kReverse


    TalonSRX wing_wheel_left;
    TalonSRX wing_wheel_right;
    TalonSRX wing_left;
    TalonSRX wing_right;
    DoubleSolenoid Dsolenoid;


    public Climber(){
        wing_wheel_left = new TalonSRX(9);
        wing_wheel_right = new TalonSRX(9);
        wing_left = new TalonSRX(9);
        wing_right = new TalonSRX(9);
        Dsolenoid = new DoubleSolenoid(1, 1);
    }

    public void wing_forward(){
        wing_right.set(ControlMode.PercentOutput, 1);
        wing_left.set(ControlMode.PercentOutput, 1);
    }

    public void wing_stop(){
        wing_right.set(ControlMode.PercentOutput, 0);
        wing_left.set(ControlMode.PercentOutput, 0);
    }

    public void wing_reverse(){
        wing_right.set(ControlMode.PercentOutput, -1);
        wing_left.set(ControlMode.PercentOutput, -1);
    }

    public void wing_wheel_forward(){
        wing_wheel_right.set(ControlMode.PercentOutput, 1);
        wing_wheel_left.set(ControlMode.PercentOutput, 1);
    }

    public void wing_wheel_stop(){
        wing_wheel_right.set(ControlMode.PercentOutput, 0);
        wing_wheel_left.set(ControlMode.PercentOutput, 0);
    }

    public void wing_wheel_reverse(){
        wing_wheel_right.set(ControlMode.PercentOutput, -1);
        wing_wheel_left.set(ControlMode.PercentOutput, -1);
    }

    public void climb_cylinder_forward(){
        Dsolenoid.set(DoubleSolenoid.Value.kForward);
    
    }
    public void climb_cylinder_reverse(){
        Dsolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    public void climb_cylinder_neutral(){
        Dsolenoid.set(DoubleSolenoid.Value.kOff);
    }
    
}