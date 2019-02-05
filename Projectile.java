import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JOptionPane;
public class Projectile {
	/*
	 * Brevin Blalock
	 * CS 160 – 02/03/04, Spring Semester 2019
	 * Project 1: Compute the Projectile Motion
	 *
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberFormat nf = NumberFormat.getInstance(Locale.US);
		String distance = JOptionPane.showInputDialog(null, "Enter distance to target in feet:" );
		String velocity = JOptionPane.showInputDialog(null, "Enter initial velocity in feet:");
		String angle = JOptionPane.showInputDialog("Enter the launch angle in degrees:");
		double Angle = Double.parseDouble(angle);
		double Velocity = Double.parseDouble(velocity);
		double Distance = Double.parseDouble(distance);
		// Variables
		char Gravitation = 32;
		double distanceToTarget = Distance;
		double initialVelocity = Velocity;
		double launchAngle = Angle;
		double radian = (Angle * (Math.PI/180));
		double flightTime = (2 * Velocity * (Math.sin(radian/Gravitation)));
		double highestPoint = (Velocity * Math.sin(radian) * flightTime - (.5*Gravitation*Math.pow((flightTime/2), 2)));
		double distanceTraveled = ((Velocity * Math.cos(radian))* flightTime);
		double error = (distanceTraveled - distanceToTarget);
		//double minError;
		String trajectory = "Initial Velocity: " + nf.format(initialVelocity) + " feet/sec"
				+ "\nLaunch Angle: " +  nf.format(launchAngle) + " degrees\n"
				+ "Flight Time: " +   nf.format(flightTime) + " seconds" 
				+ "\nMaximum Height: " +   nf.format(highestPoint) + " feet"
				+ "\nDistance Traveled: " +   nf.format(distanceTraveled) + " feet" 
				+ "\nTarget Missed By: " +   nf.format(error) + " feet";
		
		JOptionPane.showMessageDialog(null, trajectory);
		
		//First
		if (error > 0){
			JOptionPane.showMessageDialog(null, "You overshot the target!\nDecrease the angle!");
			angle = JOptionPane.showInputDialog("Enter the launch angle in degrees:");
			
		} else {
			JOptionPane.showMessageDialog(null, "You undershot the target!\nIncrease the angle!");
			angle = JOptionPane.showInputDialog("Enter the launchg angle in degrees:");
			
			
		}
		
		if (Math.abs(error) < 1) {
			JOptionPane.showMessageDialog(null, "Congrats! You hit the target");
			System.exit(0);
			
		} 
	}
	
}
