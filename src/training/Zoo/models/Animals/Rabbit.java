package training.Zoo.models.Animals;


import training.Zoo.models.AbstractAnimal;
import training.Zoo.models.Implements.CanBeGroomed;
import training.Zoo.models.Implements.CleanEncloser;
import training.Zoo.models.Implements.SmallAnimal;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Rabbit extends AbstractAnimal implements SmallAnimal, CanBeGroomed, CleanEncloser {
    private LocalDateTime lastCleaned;

    private LocalDateTime lastGroomed;

    public Rabbit(LocalDate dateOfBirth) {
        super(dateOfBirth);
    }


    @Override
    public void feed() {
        System.out.println("<Munch munch>");
        super.feed();
    }

    @Override
    public void groom() {
        lastGroomed = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0}; Last Groomed {1}", super.toString(), lastGroomed);
    }

    @Override
    public void CleanEncloser() {
        lastCleaned = LocalDateTime.now();
    }
}
