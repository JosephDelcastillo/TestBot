	package org.usfirst.frc.team86.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.XboxController;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;

public class Robot extends IterativeRobot {
	
	public static Victor leftMotor;
	public static Victor rightMotor;
	
	public AHRS ahrs = new AHRS(SPI.Port.kMXP);
	
	private Timer timer = new Timer();
	
	public XboxController controller = new XboxController(0);

	@Override	
	public void robotInit() {
		rightMotor = new Victor(0);
		leftMotor = new Victor(1);
		leftMotor.setInverted(true);
		
		ahrs.reset();
	}

	@Override
	public void autonomousInit() {
		timer.start();
	}

	@Override
	public void autonomousPeriodic() {
		
		if (ahrs.getAngle() < 90) {
			leftMotor.set(-0.15);
			rightMotor.set(0.15);
		}else {
			rightMotor.set(0);
			leftMotor.set(0);
		}
	}
	
	@Override
	public void teleopPeriodic() {
		leftMotor.set((-controller.getX() + controller.getY())/2);
		rightMotor.set((controller.getX() + controller.getY())/2 );		
	}

	@Override
	public void testPeriodic() {
		
	}
}

