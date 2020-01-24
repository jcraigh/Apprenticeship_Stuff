package training.Zoo.models.Animals;

import training.Zoo.models.AbstractAnimal;
import training.Zoo.models.Implements.LargeAnimal;
import training.Zoo.models.Implements.RackMuck;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Graffi extends AbstractAnimal implements LargeAnimal, RackMuck {

    public Graffi(LocalDate dateOfBirth) {
        super(dateOfBirth);
    }

    private LocalDateTime lastCleaned;

    @Override
    public void RackMuck() {
        lastCleaned = LocalDateTime.now();
    }
}

