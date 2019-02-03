package frc.robot.subsystems;

import frc.robot.Constants;

import frc.libs.motion.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Drivetrain{

    CANSparkMax LeftFront; 
    CANSparkMax LeftRear; 
    CANSparkMax RightFront; 
    CANSparkMax RightRear;
    
    CANEncoder LeftDriveEncoder;
    CANEncoder RightDriveEncoder;

    Drivetrain(){
        // LeftFront = new CANSparkMax(2, MotorType.kBrushless);
        // LeftRear = new CANSparkMax(4, MotorType.kBrushless);
        // RightFront = new CANSparkMax(3, MotorType.kBrushless);
        // LeftRear = new CANSparkMax(5, MotorType.kBrushless);

        // LeftDriveEncoder = LeftRear.getEncoder();
        // RightDriveEncoder = RightRear.getEncoder();
    }

}