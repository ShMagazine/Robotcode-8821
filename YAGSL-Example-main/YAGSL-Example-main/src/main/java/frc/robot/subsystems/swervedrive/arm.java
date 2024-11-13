// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.swervedrive;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ScheduleCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.commands.swervedrive.drivebase.cdrive;
import frc.robot.commands.swervedrive.drivebase.shooter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;


import java.lang.Math;

public class arm extends SubsystemBase {
  /** Creates a new arm. */
  public shooter sh;
  // chain drive
  public CANSparkMax larm;
  public CANSparkMax rarm;
  // intake
  public CANSparkMax take;
  // shooter
  public CANSparkMax lsho;
  public CANSparkMax rsho;
  // beam
  public DigitalInput be;
  // limit swtich
  public DigitalInput swtich;
  // climber arm
  public CANSparkMax climb;
  // arm encoders
  public RelativeEncoder len;
  public RelativeEncoder ren;

  public double spset = 1.1;
  public double amset = 4.8;

  public boolean au = false;
  public boolean ad = false;

  public boolean su = false;
  public boolean sd = false;

  public Timer t1;

  public arm() {
    // beam break
    be = new DigitalInput(1);
    swtich = new DigitalInput(2);
    // chain drive
    larm = new CANSparkMax(16, MotorType.kBrushless);
    rarm = new CANSparkMax(17, MotorType.kBrushless);
    // intake
    take = new CANSparkMax(15, MotorType.kBrushless);
    // shooter
    lsho = new CANSparkMax(13, MotorType.kBrushless);
    rsho = new CANSparkMax(14, MotorType.kBrushless);
    // climber
    climb = new CANSparkMax(18, MotorType.kBrushless);
    // encoders
    len = larm.getEncoder();
    ren = rarm.getEncoder();

    t1 = new Timer();

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }

  public boolean hugo() {
    return !RobotContainer.shooter.getStartButton();
  }

  public Command auto() {
    return sh;
  }

  public boolean swit() {
    return !swtich.get();
  }

  public void res() {
    len.setPosition(0);
    ren.setPosition(0);
  }

  public boolean sp() {

    if (((len.getPosition() >= spset) && (su)) || ((len.getPosition() <= spset) && (sd))) {
      return true;
    } else {
      return false;
    }

  }

  public boolean am() {

    if (((len.getPosition() >= amset) && (au)) || ((len.getPosition() <= amset) && (ad))) {
      return true;
    } else {
      return false;
    }

  }

  public double armspeed() {
    return RobotContainer.shooter.getLeftY() * .75;
  }

  public boolean tim() {

    if (t1.get() > .2) {
      return true;
    }

    else {
      return false;
    }
  }

  public boolean enbo() {
    if (Math.abs(len.getPosition()) > 2) {
      return true;
    }

    else {
      return false;
    }
  }

  public void enset() {
    len.setPosition(0);
  }

}
