package training.Zoo;

import training.Zoo.models.Animals.*;
import training.Zoo.models.Implements.Animal;
import training.Zoo.models.Implements.LargeAnimal;
import training.Zoo.models.Implements.SmallAnimal;
import training.Zoo.services.CleaningScheduler;
import training.Zoo.services.FeedingScheduler;
import training.Zoo.services.GroomingScheduler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<LargeAnimal> largeAnimals = Arrays.asList(
                new Lion(LocalDate.of(2010, 4, 28)),
                new Graffi(LocalDate.of(2018,3,30)),
                new Lion(LocalDate.of(2012, 5, 11)),
                new Zebra(LocalDate.of(2008, 12, 1))
        );
        List<SmallAnimal> smallAnimals = Arrays.asList(
                new Guinea(LocalDate.of(2016,6,12)),
                new Rabbit(LocalDate.of(2014, 1, 1))
        );
        List<Animal> animals = new ArrayList<>();
        animals.addAll(largeAnimals);
        animals.addAll(smallAnimals);

        Keeper<LargeAnimal> largeAnimalKeeper = new Keeper<>(largeAnimals);
        Keeper<SmallAnimal> smallAnimalKeeper = new Keeper<>(smallAnimals);

        List<Keeper<? extends Animal>> keepers = Arrays.asList(largeAnimalKeeper, smallAnimalKeeper);

        Rabbit babyRabbit = new Rabbit(LocalDate.now());
        smallAnimalKeeper.startLookingAfter(babyRabbit);

        FeedingScheduler feedingScheduler = FeedingScheduler.getInstance();
        GroomingScheduler groomingScheduler = GroomingScheduler.getInstance();
        CleaningScheduler cleaningScheduler = CleaningScheduler.getInstance();

        feedingScheduler.assignFeedingJobs(keepers);
        groomingScheduler.assignGroomingJobs(keepers);
        cleaningScheduler.assignCleaningJobs(keepers);
        animals.forEach(System.out::println);
    }
}
