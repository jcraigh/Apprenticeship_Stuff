package training.Zoo.models.Animals;

import training.Zoo.models.AbstractAnimal;
import training.Zoo.models.Implements.SmallAnimal;

import java.time.LocalDate;

public class Guinea extends AbstractAnimal implements SmallAnimal {
    public Guinea (LocalDate dateOfBirth) {
        super(dateOfBirth);
    }
}