package training.ilovevideogames;

import java.time.LocalDate;
import java.util.Objects;

class Game implements Comparable<Game> {
    String name;
    int metacriticRating;
    LocalDate releaseDate;

    Game(String name, int metacriticRating, LocalDate releaseDate) {
        this.name = name;
        this.metacriticRating = metacriticRating;
        this.releaseDate = releaseDate;
    }

    @Override
    public int compareTo(Game o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", name, metacriticRating, releaseDate.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Game game = (Game) obj;

        return name.equals(game.name) && metacriticRating == game.metacriticRating && releaseDate.isEqual(game.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, metacriticRating);
    }
}
