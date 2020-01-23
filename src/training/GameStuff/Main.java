package training.GameStuff;

import training.Annotations.GetDone;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class Main {
    @GetDone("This is pointless")
    public static void main(String[] args) {
        List<Game> games = Arrays.asList(
            new Game("Fire Emblem: Three Houses", 89, LocalDate.of(2019, 7, 26)),
            new Game("The Sims 4", 70, LocalDate.of(2014, 9, 2)),
            new Game("Stellaris", 78, LocalDate.of(2016, 5, 9)),
            new Game("Journey", 92, LocalDate.of(2015, 7, 21)),
            new Game("Ride to Hell: Retribution", 16, LocalDate.of(2013, 6, 24)),
            new Game("Call of Duty: Black Ops 4", 83, LocalDate.of(2018, 10, 12)),
            new Game("Death Stranding", 82, LocalDate.of(2019, 11, 8)),
            new Game("Overwatch", 91, LocalDate.of(2016, 5, 23)),
            new Game("Shenmue III", 70, LocalDate.of(2019, 11, 19)),
            new Game("Slay the Spire", 89, LocalDate.of(2019, 1, 23)),
            new Game("Outer Wilds", 85, LocalDate.of(2019, 5, 30)),
            new Game("The Outer Worlds", 82, LocalDate.of(2019, 10, 25)),
            new Game("Fallout 3", 91, LocalDate.of(2008, 10, 28)),
            new Game("Overwatch", 90, LocalDate.of(2016, 5, 23)),
            new Game("Evil Genius", 75, LocalDate.of(2004, 9, 28)),
            new Game("Call of Duty: Black Ops 4", 85, LocalDate.of(2018, 10, 12)),
            new Game("Journey", 92, LocalDate.of(2015, 7, 21)),
            new Game("Sayonara Wild Hearts", 84, LocalDate.of(2019, 9, 19)),
            new Game("Evil Genius", 75, LocalDate.of(2004, 9, 28)),
            new Game("The Legend of Zelda: Breath of the Wild", 97, LocalDate.of(2017, 3, 3))
        );

        //Do Same thing
        /*
        games.sort(new GameComparatorByMetacriticRating());
        games.forEach(System.out::println);
        games.sort((g1,g2) -> Integer.compare(g1.metacriticRating, g2.metacriticRating));
        */
        Collections.sort(games);

        //games.forEach(System.out::println);

        List<Game> example = games.stream()
                .filter(g -> g.metacriticRating < 91)
                .filter(game -> (game.releaseDate.isBefore(LocalDate.now().minusYears(2))))
                .sorted()
                .distinct()
                .limit(3)
                .collect(Collectors.toList());
        example.forEach(System.out::println);


        AtomicBoolean outsideFlag = new AtomicBoolean(false);

        Runnable seperateThreadFunction = () -> {
            for (int i = 0; i < 100000; i++){
                if (outsideFlag.get()){
                    return;
                }
                System.out.println("separate Thread");
            }
        };

        Thread backgroundThread = new Thread(seperateThreadFunction);
        backgroundThread.start();

        for (int i = 0; i < 100000; i++){
            if (i == 50000){
                outsideFlag.set(true);
            }
            System.out.println("Main Thread");
        }
    }
}
