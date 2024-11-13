// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.swervedrive.drivebase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.swervedrive.arm;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

public class takeseq extends Command {
  /** Creates a new takeseq. */
private arm s;



public Timer e = new Timer();
  public takeseq(arm s) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.s=s;
    addRequirements(s);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {s.take.set(-.5);}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    s.take.disable();
    
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return !s.be.get();
  }
}
 