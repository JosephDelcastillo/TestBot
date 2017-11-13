package autonomous;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Victor;

public class Turn {
	
	public static Victor leftMotor;
	public static Victor rightMotor;
	
	public AHRS ahrs = new AHRS(SPI.Port.kMXP);
	
	public void turnToAngle(double angle, double speed, boolean clockwise) {
		
		if (ahrs.getAngle() < angle) {
			leftMotor.set(-0.15);
			rightMotor.set(0.15);
		}
	}
}
