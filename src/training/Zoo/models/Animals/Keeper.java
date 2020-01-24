package training.Zoo.models.Animals;

import training.Zoo.models.Implements.Animal;
import training.Zoo.models.Implements.CanBeGroomed;
import training.Zoo.models.Implements.CleanEncloser;

import java.util.ArrayList;
import java.util.List;

public class Keeper<T extends Animal> {
    private List<T> animals;

    public Keeper(List<T> animals) {
        this.animals = new ArrayList<>(animals);
    }

    public void startLookingAfter(T animal) {
        this.animals.add(animal);
    }

    public void groom(CanBeGroomed animal) {
        animal.groom();
    }

    public void clean (CleanEncloser animal){
        animal.CleanEncloser();
    }

    public void feed(Animal animal) {
        animal.feed();
    }

    public List<T> getResponsibleAnimals() {
        return new ArrayList<>(animals);
    }
}
