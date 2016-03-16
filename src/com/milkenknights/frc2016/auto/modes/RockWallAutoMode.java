package com.milkenknights.frc2016.auto.modes;

import com.milkenknights.frc2016.HardwareAdapter;
import com.milkenknights.frc2016.auto.AutoMode;
import com.milkenknights.frc2016.auto.AutoModeEndedException;
import com.milkenknights.frc2016.subsystems.Intake.IntakePosition;

/**
 * This AutoMode will reach the OuterWorks and stop.
 * 
 * TODO: Test this AutoMode
 */
public class RockWallAutoMode extends AutoMode {

    @Override
    protected void routine() throws AutoModeEndedException {
        waitTime(0.25);
        HardwareAdapter.INTAKE.setPosition(IntakePosition.STORED);
        waitTime(1.0);
        //HardwareAdapter.DRIVE.setDistanceSetpoint((25 * 12));
        HardwareAdapter.DRIVE.setDistanceSetpoint((20 * 12));
    }

}