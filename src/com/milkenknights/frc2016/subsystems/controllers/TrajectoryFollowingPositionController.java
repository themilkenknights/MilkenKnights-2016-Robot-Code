package com.milkenknights.frc2016.subsystems.controllers;

import com.milkenknights.util.Controller;
import com.milkenknights.util.trajectory.TrajectoryFollower;

public class TrajectoryFollowingPositionController extends Controller {
    TrajectoryFollower follower;
    double goal;
    double error;
    double onTargetDelta;
    double result = 0;

    /**
     * Create a new TrajectoryFollowingPositionController.
     * 
     * @param kp The proportional constant
     * @param ki The integral constant
     * @param kd The derivative constant
     * @param kv The velocity constant
     * @param ka The acceleration constants
     * @param onTargetDelta The distance to go
     * @param config Configuration for the controller
     */
    public TrajectoryFollowingPositionController(final double kp, final double ki, final double kd, final double kv,
            final double ka, final double onTargetDelta, final TrajectoryFollower.TrajectoryConfig config) {
        follower = new TrajectoryFollower();
        follower.configure(kp, ki, kd, kv, ka, config);
        this.onTargetDelta = onTargetDelta;
    }

    public void setGoal(TrajectoryFollower.TrajectorySetpoint currentState, double goal) {
        this.goal = goal;
        follower.setGoal(currentState, goal);
    }

    public double getGoal() {
        return follower.getGoal();
    }

    public void setConfig(TrajectoryFollower.TrajectoryConfig config) {
        follower.setConfig(config);
    }

    public TrajectoryFollower.TrajectoryConfig getConfig() {
        return follower.getConfig();
    }

    public void update(double position, double velocity) {
        error = goal - position;
        result = follower.calculate(position, velocity);
    }

    public TrajectoryFollower.TrajectorySetpoint getSetpoint() {
        return follower.getCurrentSetpoint();
    }

    public double get() {
        return result;
    }

    public boolean isFinishedTrajectory() {
        return follower.isFinishedTrajectory();
    }

    @Override
    public boolean isOnTarget() {
        return follower.isFinishedTrajectory()
                && Math.abs(error) < onTargetDelta;
    }

}
