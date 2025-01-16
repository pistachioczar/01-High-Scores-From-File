public class Player {
    private String initials;
    private int score;

    public Player(){
        initials = "N/A";
        score = 0;
    }

    public String GetInitials() {
        return this.initials;
    }

    public void SetInitials(String newInitials) {
        this.initials = newInitials;
    }

    public int GetScore() {
        return this.score;
    }

    public void SetScore(int newScore) {
        this.score = newScore;
    }
}
