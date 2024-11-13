// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.swervedrive.drivebase;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.swervedrive.arm;

public class climberup extends Command {
  /** Creates a new climberup. */
  public arm s;
  public climberup(arm s) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.s=s;
    addRequirements(s);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {s.climb.set(-1);}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {s.climb.disable();}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return !RobotContainer.driverXbox.getRightBumper();
  }
}
