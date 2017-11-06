	package org.usfirst.frc.team86.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.XboxController;

public class Robot extends IterativeRobot {
	
	public static Victor leftMotor;
	public static Victor rightMotor;
	private Timer timer = new Timer();;
	public XboxController controller = new XboxController(1);

	@Override	
	public void robotInit() {
		rightMotor = new Victor(0);
		rightMotor.setInverted(true);
		leftMotor = new Victor(1);
	}

	@Override
	public void autonomousInit() {
		timer.start();
	}

	@Override
	public void autonomousPeriodic() {
		if (timer.get() < 5) {
			rightMotor.set(0.5);
			leftMotor.set(0.5);
		} else {
			rightMotor.set(0);
			leftMotor.set(0);			
		}
	}
	
	@Override
	public void teleopPeriodic() {
		leftMotor.set(controller.getY());
		rightMotor.set(controller.getY());
		if(controller.getX() > 0 ) {
			leftMotor.set((controller.getX() + controller.getY())/2);
		} else if (controller.getX() < 0 ) {
			rightMotor.set( (controller.getX() + controller.getY())/2 );
		}
	}

	@Override
	public void testPeriodic() {
		
	}
}

