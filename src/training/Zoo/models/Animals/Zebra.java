package training.Zoo.models.Animals;

import training.Zoo.models.AbstractAnimal;
import training.Zoo.models.Implements.CanBeGroomed;
import training.Zoo.models.Implements.LargeAnimal;
import training.Zoo.models.Implements.RackMuck;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Zebra extends AbstractAnimal implements LargeAnimal, CanBeGroomed, RackMuck {

    private LocalDateTime lastGroomed;

    public Zebra(LocalDate dateOfBirth) {
        super(dateOfBirth);
    }

    private LocalDateTime lastCleaned;

    @Override
    public void RackMuck(){
        lastCleaned = LocalDateTime.now();
    }

    @Override
    public void groom() {
        lastGroomed = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0}; Last Groomed {1}", super.toString(), lastGroomed);
    }
}
