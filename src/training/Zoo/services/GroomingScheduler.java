package training.Zoo.services;

import training.Zoo.models.Animals.Keeper;
import training.Zoo.models.Implements.Animal;
import training.Zoo.models.Implements.CanBeGroomed;

import java.util.List;

public class GroomingScheduler {
    private static GroomingScheduler instance;

    private GroomingScheduler() {
    }

    public static GroomingScheduler getInstance() {
        if (instance == null) {
            instance = new GroomingScheduler();
        }
        return instance;
    }

    public void assignGroomingJobs(List<Keeper<? extends Animal>> keepers) {
        keepers.forEach(keeper -> keeper.getResponsibleAnimals().forEach(animal -> {
            if (animal instanceof CanBeGroomed) {
                keeper.groom((CanBeGroomed) animal);
            }
        }));
    }
}
