// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.swervedrive.drivebase;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.swervedrive.arm;

public class amp extends Command {
  /** Creates a new amp. */
  private arm s;
  public amp(arm s) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.s=s;
    addRequirements(s);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (s.len.getPosition()>s.amset) {s.ad=true;}

    if (s.len.getPosition()<s.amset) {s.au=true;}
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (s.au) {s.rarm.set(.5);
      s.larm.set(.5);}

      if (s.ad) {s.rarm.set(-.5);
      s.rarm.set(-.5);}
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    s.larm.disable();
    s.rarm.disable();
    s.ad=false;
    s.au=false;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return s.am();
  }
}
