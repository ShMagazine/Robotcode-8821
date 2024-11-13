// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.swervedrive.drivebase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.swervedrive.arm;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import java.lang.Math;

public class cdrive extends Command {
  /** Creates a new cdrive. */
  private arm s;
  public cdrive(arm s) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.s=s;
    addRequirements(s);

    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    


    if (!s.swit()){
    s.rarm.set(s.armspeed());
    s.larm.set(s.armspeed());
  }
  else {s.rarm.set(Math.abs(s.armspeed()));
  s.larm.set(Math.abs(s.armspeed()));}
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
