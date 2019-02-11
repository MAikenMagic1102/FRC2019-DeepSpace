package frc.robot.subsystems;

import frc.robot.Constants;

import frc.libs.motion.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class Drivetrain{

    CANSparkMax LeftFront; 
    CANSparkMax LeftRear; 
    CANSparkMax RightFront; 
    CANSparkMax RightRear;
    
    CANEncoder LeftDriveEncoder;
    CANEncoder RightDriveEncoder;

    DoubleSolenoid shift_solenoid;

    public Drivetrain(){
        RightFront = new CANSparkMax(2, MotorType.kBrushless);
        LeftRear = new CANSparkMax(4, MotorType.kBrushless);
        LeftFront = new CANSparkMax(3, MotorType.kBrushless);
        RightRear = new CANSparkMax(5, MotorType.kBrushless);

        //LeftFront.setInverted(true);
        //LeftRear.setInverted(true);
        RightFront.setInverted(true);
        RightRear.setInverted(true);

        LeftDriveEncoder = LeftRear.getEncoder();
        RightDriveEncoder = RightRear.getEncoder();

        shift_solenoid = new DoubleSolenoid(1, 2, 3);
    }

    //scales the joystick input to cause the robot to have a less steep acceleration curve.
    //This works well for us in VEX... testing needed to verify FRC use.
    double drive_math(double input){
        double out;
        double sing;
       
        if(input < 0){
            sing = -1;
            input = -input;
        }else {
            sing = 1;
        }
       
        if (input < .2){
            out = 0;
        }else{
            if(input < .80){
                out = input * 0.5;
            }else {
                out = input;
            }
        } 
        return out*sing;
    }

    public void arcade_drive_openloop(double inversion, double leftY, double rightX){
        shift_solenoid.set(Value.kReverse);
        
        double leftPower =  leftY - rightX;
        double rightPower = leftY + rightX;

        LeftFront.set(leftPower);
        LeftRear.set(leftPower);
        RightFront.set(rightPower);
        RightRear.set(rightPower);

    }
    

    public void mecanum_drive_openloop(double inversion, double triggers, double rightX, double leftY){

        //FrontLeft = Ch3 + Ch1 + Ch4
        //RearLeft = Ch3 + Ch1 - Ch4
        //FrontRight = Ch3 - Ch1 - Ch4
        //RearRight = Ch3 - Ch1 + Ch4    

        //Ch1 = Right joystick X-axis
        //Ch3 = Left joystick Y-axis
        //Ch4 = Left joystick X-axis

        rightX = rightX * -1;
        
        double _FrontRight = leftY - rightX - triggers;
        double _RearRight = leftY - rightX + triggers;
        double _FrontLeft = leftY + rightX + triggers;
        double _RearLeft = leftY + rightX - triggers;

        RightRear.set(_RearRight);
        RightFront.set(_FrontRight);
        LeftRear.set(_RearLeft);
        LeftFront.set(_FrontLeft);

        shift_solenoid.set(Value.kForward);  
      
    }


}