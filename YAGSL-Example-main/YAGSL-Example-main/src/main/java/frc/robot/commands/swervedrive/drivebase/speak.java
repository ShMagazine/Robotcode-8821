// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.swervedrive.drivebase;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.swervedrive.arm;

public class speak extends Command {
  /** Creates a new speak. */
  private arm s;
  public speak(arm s) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.s=s;
    addRequirements(s);

  }

//true or false for above or below
   


      //TANNER CHANGE VALUES HERE 


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
     if (s.len.getPosition()>s.spset) {s.sd=true;}

    if (s.len.getPosition()<s.spset) {s.su=true;}
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      if (s.su) {s.rarm.set(.5);
      s.larm.set(.5);}

      if (s.sd) {s.rarm.set(-.5);
      s.rarm.set(-.5);}
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    s.larm.disable();
    s.rarm.disable();
    s.sd=false;
    s.su=false;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return s.sp();
  }
}
