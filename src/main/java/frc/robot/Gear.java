package frc.robot;

public class Gear {

    Constants cons = new Constants();

    private double speedMultiplier = cons.maxMultiplier;

    public double getSpeedMultiplier() {
        return speedMultiplier;
    }

    public void setSpeedMultiplier(double multiplier) {
        speedMultiplier = validateMultiplier(multiplier);
    }

    private double validateMultiplier(double multiplier) {
        if (multiplier > cons.maxMultiplier) {
            multiplier = cons.maxMultiplier;
        } else if (multiplier < cons.minMultiplier) {
            multiplier = cons.minMultiplier;
        }
        return multiplier;
    }

}
