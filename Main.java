import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main{

    public static void main(String[] args) {
        String file = "players.csv";
        BufferedReader reader = null;
        String line = "";
        List<Player> players = new ArrayList<>();
        Player[] topTen = new Player[9];

        try {
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null){
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
        
        for(Player player: players){
            for (int i = 0; i < topTen.length; i++) {
                if (player.getScore() > topTen[i]){
                    
                }
            }
        }
    }

}