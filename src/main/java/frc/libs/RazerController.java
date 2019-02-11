package frc.libs;

import edu.wpi.first.wpilibj.Joystick;

public class RazerController extends Joystick {
	
	public RazerController(int usbport) {
		super(usbport);
	}
	
	public boolean backbutton() {
		if (super.getRawButton(7))
			return true;
		else
			return false;
		
	}	
	
	
	public boolean startbutton() {
		if (super.getRawButton(8))
			return true;
		else
			return false;
	}
	
	public boolean xbutton() {
		if (super.getRawButton(3))
			return true;
		else
			return false;
	}
	public boolean dpadf() {
		if (super.getPOV() == 0)
			return true;
		else
			return false;
	}
	public boolean dpadb() {
		if (super.getPOV() == 180)
			return true;
		else
			return false;
	}
	public boolean dpadl() {
		if (super.getPOV() == 270)
			return true;
		else
			return false;
	}
	public boolean dpadr() {
		if (super.getPOV() == 90)
			return true;
		else
			return false;
	}
	
	public boolean abutton() {
		if (super.getRawButton(1))
			return true;	
		else
			return false; 
	}
	
	public boolean bbutton() {
		if (super.getRawButton(2))
			return true;
		else
			return false;
	}
					
	public boolean ybutton() {
		if (super.getRawButton(4))
			return true;
		else
			return false;	
	}
		
	public boolean rbbutton() {
		if (super.getRawButton(8))
			return true;
		else
			return false;
	}
	
	public boolean rtbutton() {
		if (super.getRawButton(6))
			return true;
		else
			return false;
	}
			
	public boolean lbbutton() {
		if (super.getRawButton(7))
			return true;
		else
			return false;	
		}
	
	public boolean ltbutton() {
		if (super.getRawButton(5))
			return true;
		else
			return false;			
	}	
			
	public double rightthumby_dmode() {
		return super.getRawAxis(3);
	}	
	
	public double rightthumbx_dmode() {
		return -1 * super.getRawAxis(2);
	}

	public double rightthumby() {
		return -1 * super.getRawAxis(5);
	}

	public double rightthumbx() {
		if(super.getRawAxis(4) > -0.2 || super.getRawAxis(4) < 0.2) {
			return super.getRawAxis(4);
		}else {
			return 0;
		}
	}
								
							
	public double leftthumbx() {
		return -1 * super.getRawAxis(0);
	}
 

	public double leftthumby() {
		if(super.getRawAxis(1) > 0.2 || super.getRawAxis(1) < -0.2) {
			return super.getRawAxis(1);
		}else {
			return 0;
		}
	}
	
	public double lefttrigger() {
		return super.getRawAxis(2);
	}
	
	public double righttrigger() {
		return super.getRawAxis(3);
	}
	
	public double triggers() {
		return ((super.getRawAxis(2)) + (-1 * super.getRawAxis(3)));
	}
	
}				

