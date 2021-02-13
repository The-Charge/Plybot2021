// RobotBuilder Version: 3.1
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {

    private static RobotContainer m_robotContainer = new RobotContainer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    // The robot's subsystems
    private final Shooter m_shooter = new Shooter();
    private final TurretRotation m_turretRotation = new TurretRotation();
    private final Grabber m_grabber = new Grabber();
    private final Drivetrain m_drivetrain = new Drivetrain();

    // Joysticks
    private final Joystick buttonBox = new Joystick(2);
    private final Joystick rightJoystick = new Joystick(1);
    private final Joystick leftJoystick = new Joystick(0);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // A chooser for autonomous commands
    SendableChooser<Command> m_chooser = new SendableChooser<>();

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    private RobotContainer() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
        // Smartdashboard Subsystems
        SmartDashboard.putData(m_turretRotation);
        SmartDashboard.putData(m_grabber);
        SmartDashboard.putData(m_drivetrain);

        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("Tank Drive", new TankDrive(m_drivetrain));
        SmartDashboard.putData("ToggleLockStraight", new ToggleLockStraight(m_drivetrain));
        SmartDashboard.putData("SetGrabberExtended: Extend", new SetGrabberExtended(true, m_grabber));
        SmartDashboard.putData("SetGrabberExtended: Retract", new SetGrabberExtended(false, m_grabber));
        SmartDashboard.putData("RotateTurret", new RotateTurret(m_turretRotation));

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
        // Configure the button bindings
        configureButtonBindings();

        // Configure default commands
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND
        m_turretRotation.setDefaultCommand(new RotateTurret(m_turretRotation));
        m_drivetrain.setDefaultCommand(new TankDrive(m_drivetrain));

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND

        // Configure autonomous sendable chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        m_chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        SmartDashboard.putData("Auto Mode", m_chooser);
    }

    public static RobotContainer getInstance() {
        return m_robotContainer;
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be
     * created by instantiating a {@link GenericHID} or one of its subclasses
     * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
     * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
        // Create some buttons
        final JoystickButton topReleased = new JoystickButton(rightJoystick, 1);
        topReleased.whenReleased(new SetGrabberExtended(false, m_grabber), true);
        SmartDashboard.putData("TopReleased", new SetGrabberExtended(false, m_grabber));

        final JoystickButton topPressed = new JoystickButton(rightJoystick, 1);
        topPressed.whenPressed(new SetDrivetrainReversed(false, m_drivetrain), true);
        SmartDashboard.putData("TopPressed", new SetDrivetrainReversed(false, m_drivetrain));

        final JoystickButton leftTrigger = new JoystickButton(leftJoystick, 1);
        leftTrigger.whileHeld(new ToggleLockStraight(m_drivetrain), true);
        SmartDashboard.putData("Left Trigger", new ToggleLockStraight(m_drivetrain));

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS

        // This has to be done differently because it can't be active while another
        // command is. Additionally, instant commands with parameters must not have
        // a button a SmartDashboard.
        final JoystickButton rightTrigger = new JoystickButton(rightJoystick, 1);
        rightTrigger.whenPressed(new SetDrivetrainSpeedModifier(0.25, m_drivetrain));
        rightTrigger.whenReleased(new SetDrivetrainSpeedModifier(1, m_drivetrain));

        final JoystickButton leftTop = new JoystickButton(leftJoystick, 2);
        leftTop.whenPressed(new SetDrivetrainReversed(true, m_drivetrain));
        leftTop.whenReleased(new SetDrivetrainReversed(false, m_drivetrain));

        final JoystickButton shooterBtn = new JoystickButton(buttonBox, 1);
        shooterBtn.whileHeld(new Shoot(0.5, m_shooter));

        final JoystickButton shooterToggle = new JoystickButton(buttonBox, 2);
        shooterToggle.toggleWhenPressed(new Shoot(0.8, m_shooter));

        final JoystickButton shootHalf = new JoystickButton(buttonBox, 3);
        shootHalf.whileHeld(new Shoot(0.5, m_shooter));

        final JoystickButton shootFull = new JoystickButton(buttonBox, 4);
        shootFull.whileHeld(new Shoot(1.0, m_shooter));

        final JoystickButton shootJoystickSpeed = new JoystickButton(buttonBox, 4);
        shootJoystickSpeed.whileHeld(new Shoot(buttonBox.getX(), m_shooter));
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getLeftJoystick() {
        return leftJoystick;
    }

    public Joystick getRightJoystick() {
        return rightJoystick;
    }

    public Joystick getButtonBox() {
        return buttonBox;
    }

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // The selected command will be run in autonomous
        return m_chooser.getSelected();
    }

}
