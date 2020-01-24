package training.Zoo.services;

import training.Zoo.models.Animals.Keeper;
import training.Zoo.models.Implements.Animal;

import java.util.List;

public class FeedingScheduler {
    private static FeedingScheduler instance = new FeedingScheduler();

    private FeedingScheduler() {
    }

    public static FeedingScheduler getInstance() {return instance;}

    public void assignFeedingJobs(List<Keeper<? extends Animal>> keepers) {
        keepers.forEach(keeper -> keeper.getResponsibleAnimals().forEach(keeper::feed));
    }
}