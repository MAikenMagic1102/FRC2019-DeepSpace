package frc.robot.subsystems;

import frc.robot.Constants;

import frc.libs.motion.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Timer;

public class Elevator{
    
    private double profileOffset = 0;
    private double holdPosition = 0;

    private Timer profileTimer = new Timer();

    private TrapezoidalMotionProfile profile = null;

    private CANSparkMax LeftMotor;
    private CANSparkMax RightMotor;

    private CANEncoder LeftEncoder;
    private CANEncoder RightEncoder;

    private Constants constants;

    public enum Mode {
        MANUAL,
        HOLD,
        PROFILE
    };

    public Mode currentMode = Mode.MANUAL;


    public Elevator(){
        LeftMotor = new CANSparkMax(6, MotorType.kBrushless);
        RightMotor = new CANSparkMax(7, MotorType.kBrushless);
        LeftEncoder = LeftMotor.getEncoder();
        RightEncoder = RightMotor.getEncoder();
        RightMotor.setInverted(true);
    }

    public void set(double input){
        currentMode = Mode.MANUAL;
        LeftMotor.set(input);
        RightMotor.set(input);
    }

    public double getLeftMotorPosition(){
        return LeftEncoder.getPosition();
    }

    public double getRightMotorPosition(){
        return RightEncoder.getPosition();
    }

    public double getLeftMotorVelocity(){
        return LeftEncoder.getVelocity();
    }
    
    public double getRightMotorVelocity(){
        return RightEncoder.getVelocity();
    }

    public void setManual(double speed) {
        currentMode = Mode.MANUAL;
        set(speed);
    }
    
    public void holdPosition() {
        holdPosition = getLeftMotorPosition();
        currentMode = Mode.HOLD;
    }
    
    public void goToGoal(double goal) {
        profile = new TrapezoidalMotionProfile(goal-getLeftMotorPosition(), constants.ElevatorMaxVelocity, constants.ElevatorMaxAccel);
        System.out.println("Generating profile for "+(goal-getLeftMotorPosition()));
        profileOffset = getLeftMotorPosition();
        profileTimer.reset();
        profileTimer.start();

        currentMode = Mode.PROFILE;
    }

    public void update() {
        //FireLog.log("elevator_position", encoder.getDistance());
        //FireLog.log("elevator_mode", currentMode);
        if ( currentMode == Mode.MANUAL )
            return;

        double output = constants.Elevator_kGravity;
        if ( currentMode == Mode.PROFILE && profile != null ) {
            ProfilePoint point = profile.getAtTime(profileTimer.get());
            //FireLog.log("elevator_target", point.pos);
            double error = (point.pos + profileOffset) - getLeftMotorPosition();
            output += point.vel * constants.Elevator_kF + error * constants.Elevator_kP;
            //FireLog.log("elevator_error", error);
        }
        else if ( currentMode == Mode.HOLD ) {
            double error = holdPosition - getLeftMotorPosition();
            output += error * constants.Elevator_kP;
            //FireLog.log("elevator_error", error);
        }

        set(output);
    }

}