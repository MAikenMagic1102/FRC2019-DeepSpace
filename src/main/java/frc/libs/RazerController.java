package frc.libs;

import edu.wpi.first.wpilibj.Joystick;

public class RazerController {
	
	Joystick Jenny;
	
	public RazerController(int usbport) {
		Jenny = new Joystick(usbport);
	}
	
	
	public boolean backbutton() {
		if (Jenny.getRawButton(7))
			return true;
		else
			return false;
		
	}	
	
	
	public boolean startbutton() {
		if (Jenny.getRawButton(8))
			return true;
		else
			return false;
	}
	
	public boolean xbutton() {
		if (Jenny.getRawButton(3))
			return true;
		else
			return false;
	}
	public boolean dpadf() {
		if (Jenny.getPOV() == 0)
			return true;
		else
			return false;
	}
	public boolean dpadb() {
		if (Jenny.getPOV() == 180)
			return true;
		else
			return false;
	}
	public boolean dpadl() {
		if (Jenny.getPOV() == 270)
			return true;
		else
			return false;
	}
	public boolean dpadr() {
		if (Jenny.getPOV() == 90)
			return true;
		else
			return false;
	}
	
	public boolean abutton() {
		if (Jenny.getRawButton(1))
			return true;	
		else
			return false; 
	}
	
	public boolean bbutton() {
		if (Jenny.getRawButton(2))
			return true;
		else
			return false;
	}
					
	public boolean ybutton() {
		if (Jenny.getRawButton(4))
			return true;
		else
			return false;	
	}
		
	public boolean rbbutton() {
		if (Jenny.getRawButton(8))
			return true;
		else
			return false;
	}
	
	public boolean rtbutton() {
		if (Jenny.getRawButton(6))
			return true;
		else
			return false;
	}
			
	public boolean lbbutton() {
		if (Jenny.getRawButton(7))
			return true;
		else
			return false;	
		}
	
	public boolean ltbutton() {
		if (Jenny.getRawButton(5))
			return true;
		else
			return false;			
	}	
			
	public double rightthumby_dmode() {
		return Jenny.getRawAxis(3);
	}	
	
	public double rightthumbx_dmode() {
		return -1 * Jenny.getRawAxis(2);
	}

	public double rightthumby() {
		return -1 * Jenny.getRawAxis(5);
	}

	public double rightthumbx() {
		if(-1 * Jenny.getRawAxis(4) < -0.15 || -1 * Jenny.getRawAxis(4) > 0.15) {
			return -1 * Jenny.getRawAxis(4);
		}else {
			return 0;
		}
	}
								
							
	public double leftthumbx() {
		return -1 * Jenny.getRawAxis(0);
	}
 

	public double leftthumby() {
		if(-1 * Jenny.getRawAxis(1) < -0.15 || -1 * Jenny.getRawAxis(1) > 0.15) {
			return -1 * Jenny.getRawAxis(1);
		}else {
			return 0;
		}
	}
	
	public double lefttrigger() {
		return Jenny.getRawAxis(2);
	}
	
	public double righttrigger() {
		return Jenny.getRawAxis(3);
	}
	
	public double triggers() {
		return ((Jenny.getRawAxis(2)) + (-1 * Jenny.getRawAxis(3)));
	}
	
}				

