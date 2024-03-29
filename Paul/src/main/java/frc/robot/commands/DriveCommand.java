package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveCommand extends CommandBase {

public interface VelocityProvider{
    
    double getVelocity();
   
}

private final VelocityProvider m_velocityProviderLeft;
private final VelocityProvider m_velocityProviderRight;


    private final DriveTrain m_subsystem;
    public DriveCommand(DriveTrain subsystem, VelocityProvider velocityProviderLeft, VelocityProvider velocityProviderRight ) {
        m_subsystem = subsystem;
        m_velocityProviderLeft = velocityProviderLeft;
        m_velocityProviderRight = velocityProviderRight;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        m_subsystem.drive(m_velocityProviderLeft.getVelocity(), m_velocityProviderRight.getVelocity());
    }
}