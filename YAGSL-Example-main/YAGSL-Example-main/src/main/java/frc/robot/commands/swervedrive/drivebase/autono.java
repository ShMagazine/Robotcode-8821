// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.swervedrive.drivebase;


import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.swervedrive.arm;

public class autono extends Command {
  /** Creates a new autono. */

  
  public arm s;
  public autono(arm s) {
    // Use addRequirements() here to declare subsystem dependencies.
    
    this.s=s;
    addRequirements(s);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    s.t1.start(); 
    s.larm.set(-.2);
    s.rarm.set(.2);
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    s.larm.disable();
    s.rarm.disable();
    s.t1.stop();
    s.t1.reset();    
  }


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if ((s.tim())||(s.enbo())) {
      return true;
    }
    else {return false;}
  }
}
