package com.milkenknights.frc2016.subsystems;

import com.milkenknights.util.Subsystem;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public final class BallClamp extends Subsystem {
    
    private Solenoid solenoid;
    
    public enum BallClampState {
        OPEN(true), LOCK(false);
        
        public final boolean state;
        private BallClampState(final boolean state) {
            this.state = state;
        }
    }

    /**
     * Create a new ball clamp.
     */
    public BallClamp(final String name, final Solenoid solenoid) {
        super(name);
        
        this.solenoid = solenoid;
    }
    
    /**
     * Opens the BallClamp.
     */
    public void open() {
        solenoid.set(BallClampState.OPEN.state);
    }
    
    /**
     * Locks the BallClamp.
     */
    public void lock() {
        solenoid.set(BallClampState.LOCK.state);
    }

    @Override
    public void updateSmartDashboard() {
        SmartDashboard.putBoolean("BallClamp: State", solenoid.get());
    }

}
