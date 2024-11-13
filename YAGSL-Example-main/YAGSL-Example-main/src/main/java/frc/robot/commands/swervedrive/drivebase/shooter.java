// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.swervedrive.drivebase;
import frc.robot.subsystems.swervedrive.arm;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

public class shooter extends Command {
  /** Creates a new shooter. */
private arm s;
public Timer t = new Timer();

  public shooter(arm s) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.s=s;
    addRequirements(s);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    t.start();
    s.lsho.set(1);
    s.rsho.set(-1);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (t.get()>.6) {s.take.set(-.5);}

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    s.lsho.disable();
    s.rsho.disable();
    s.take.disable();

    t.stop();
    t.reset();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return t.get()>2;
  }
}
