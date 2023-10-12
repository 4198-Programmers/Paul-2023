import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsystem;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.jni.CANSparkMaxJNI;
import edu.wpi.first.hal.HAL;

public class IntakeSubsystemTest {
    IntakeSubsystem subsystem;

    @BeforeEach
    void setup() {
        assert HAL.initialize(500, 0);
        this.subsystem = new IntakeSubsystem();
    }

    @AfterEach
    void shutdown() throws Exception {
        this.subsystem.close();
    }

    @Test
    void in_SetsSpeed() {
        this.subsystem.in();
    }

    @Test
    void eject_SetsSpeed() {
        this.subsystem.eject();
    }
}