package skeleton;

import java.lang.Math;
import java.util.HashMap;

public class Belly {
    public static final double SICK_THRESHOLD = 6000.0;
    public static final double KEEP_PERCENT_PER_HOUR = 0.7;

    public static enum Edibles {
        CAKE("cake", 100.0, "growl", 1600.0),
        BEER("beer", 750.0, "burp", 1600.0);

      public final double volume, actionThreshold;
      public final String name, action;

      Edibles(String name, double volume, String action, double actionThreshold) {
        this.name = name;
        this.volume = volume;
        this.actionThreshold = actionThreshold;
        this.action =  action;
      }
    };

    private double volumeInBelly;
    private boolean isSick;
    private HashMap <String, Boolean> bodilyActions;
    private HashMap <Edibles, Double> volumesInBelly;

    public Belly() {
      volumeInBelly = 0.0;
      isSick = false;
      bodilyActions =  new HashMap <String, Boolean>();
      volumesInBelly = new HashMap <Edibles, Double>();
      for (Edibles edible : Edibles.values()) {
        bodilyActions.putIfAbsent(edible.action, false);
        volumesInBelly.put(edible, 0.0);
      }
    }

    public void eat(int amount, Edibles edible) {
      double addAmount = amount * edible.volume;
      volumeInBelly += addAmount;
      Double edibleVolume = volumesInBelly.get(edible);
      edibleVolume += addAmount;
      volumesInBelly.put(edible, edibleVolume);
      if (volumeInBelly > SICK_THRESHOLD) {
        isSick = true;
      }
    }

    public void wait(int hours) {
      double newVolumeInBelly = 0.0;
      for (Edibles edible : volumesInBelly.keySet()) {
        Double edibleVolume = volumesInBelly.get(edible);
        double oldEdibleVolume = edibleVolume;
        edibleVolume *= Math.pow(KEEP_PERCENT_PER_HOUR, hours);
        volumesInBelly.put(edible, edibleVolume);
        if (oldEdibleVolume - edibleVolume > edible.actionThreshold) {
          bodilyActions.put(edible.action, true);
        }  else {
          bodilyActions.put(edible.action, false);
        }
        newVolumeInBelly += edibleVolume;
      }
      volumeInBelly = newVolumeInBelly;
      if (volumeInBelly <= SICK_THRESHOLD) {
        isSick = false;
      }
    }

    public boolean getIsPerformingAction(String action) {
      Boolean isPerforming = bodilyActions.get(action);
      if (isPerforming != null) {
        return isPerforming;
      }
      return false;
    }

    public boolean getIsSick() {
      return isSick;
    }

    public int getvolumeInBelly() {
      return (int)volumeInBelly;
    }
}
