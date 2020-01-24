package training.Zoo.services;

import training.Zoo.models.Animals.Keeper;
import training.Zoo.models.Implements.Animal;
import training.Zoo.models.Implements.CleanEncloser;

import java.util.List;

public class CleaningScheduler {
    private static CleaningScheduler instance;

    private CleaningScheduler() {
    }

    public static CleaningScheduler getInstance() {
        if (instance == null) {
            instance = new CleaningScheduler();
        }
        return instance;
    }

    public void assignCleaningJobs(List<Keeper<? extends Animal>> keepers) {
        keepers.forEach(keeper -> keeper.getResponsibleAnimals().forEach(animal -> {
            if (animal instanceof CleanEncloser) {
                keeper.clean((CleanEncloser) animal);
            }
        }));
    }
}
