package training.Zoo.models.Animals;

import training.Zoo.models.AbstractAnimal;
import training.Zoo.models.Implements.LargeAnimal;
import training.Zoo.models.Implements.RackMuck;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Lion extends AbstractAnimal implements LargeAnimal, RackMuck {
    protected LocalDateTime lastCleaned;

    public Lion(LocalDate dateOfBirth) {
        super(dateOfBirth);
    }

    @Override
    public void RackMuck(){
        lastCleaned = LocalDateTime.now();
    }
}
