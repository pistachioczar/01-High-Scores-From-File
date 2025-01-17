import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main{

    public static void main(String[] args) {
        String file = "players.csv";
        List<Player> players;
        Player[] topTen;

        //Read CSV
        players = ReadCSVPlayers(file);
        topTen = FillTopTen(players);
        ReadTopTen(topTen);

        //New Player
        Player zach = new Player();
        zach.SetInitials("ZSH");
        zach.SetScore(945);
        players.add(zach);

        //Fill the top 10 list
        topTen = FillTopTen(players);

        ReadTopTen(topTen);
    }
    
    

    public static List<Player> ReadCSVPlayers(String file) {
        BufferedReader reader = null;
        String line;
        List<Player> players = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] playerData = line.split(",");
                String initals = playerData[0];
                int score = Integer.parseInt(playerData[1]);
                Player player = new Player();
                player.SetInitials(initals);
                player.SetScore(score);
                players.add(player);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return players;
    }

    public static Player[] FillTopTen(List<Player> players) {
        Player[] topTen = new Player[10];
        for (Player player : players) {
            for (int i = 0; i < topTen.length; i++) {
                if (topTen[i] == null) {
                    topTen[i] = player;
                    break;
                } else if (player.GetScore() > topTen[i].GetScore()) {

                    for (int j = topTen.length - 1; j > i; j--) {
                        topTen[j] = topTen[j - 1];
                    }
                    topTen[i] = player;
                    break;
                }
            }
        }
        return topTen;
    }

    public static void ReadTopTen(Player[] topTen) {
        System.out.println("Top Ten Leaderboard:");
        for (int i = 0; i < topTen.length; i++) {
            System.out.println(i + 1 + "     " + topTen[i].GetInitials() + "   " + topTen[i].GetScore());
        }
        System.out.println();
    }

}