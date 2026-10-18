package Session5.Assignment5;
import java.util.Arrays;
public class Problem5 {
  static class Player implements Comparable<Player> {
        String name;
        int matchesPlayed;
        boolean injured;
        double battingAverage;

        Player(String name, int matchesPlayed,
               boolean injured, double battingAverage) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.injured = injured;
            this.battingAverage = battingAverage;
        }

        @Override
        public int compareTo(Player other) {
            return Double.compare(
                other.battingAverage, this.battingAverage
            );
        }

        @Override
        public String toString() {
            return name + " - " + battingAverage;
        }
    }

    // Overloaded method: checks match count only
    static boolean isDraftable(Player player, int minimumMatches) {
        return player.matchesPlayed >= minimumMatches;
    }

    // Overloaded method: checks match count and injury status
    static boolean isDraftable(Player player, int minimumMatches,
                               boolean checkInjury) {
        if (player.matchesPlayed < minimumMatches) {
            return false;
        }

        return !checkInjury || !player.injured;
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, false, 58.5),
            new Player("Rohit", 8, false, 45.2),
            new Player("Dhoni", 12, true, 40.8),
            new Player("Gill", 6, false, 52.1),
            new Player("Rahul", 4, false, 48.0)
        };

        System.out.println("Draftable players:");

        for (Player player : players) {
            boolean draftable;

            if (player.matchesPlayed >= 10) {
                draftable = isDraftable(player, 10);
            } else {
                draftable = isDraftable(player, 5, true);
            }

            if (draftable) {
                System.out.println(player);
            }
        }

        Arrays.sort(players);

        System.out.println("\nPlayers ranked by batting average:");

        for (Player player : players) {
            System.out.println(player);
        }
    }
}  
