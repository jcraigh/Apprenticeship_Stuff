package training.GameStuff;

import java.util.Comparator;

public class GameComparatorByMetacriticRating implements Comparator<Game> {
    @Override
    public int compare(Game g1, Game g2) {
        return g1.releaseDate.compareTo(g2.releaseDate);
//        return g1.metacriticRating - g2.metacriticRating;
    }
}
