public class Players {

    private String[] players = { "Player 1", "Player 2" };
    private int playersAmount = players.length;
    private int[] scores = new int[players.length];

    public Players() {
    }

    public Players(String[] players) {
        setPlayers(players);
        setPlayersAmount(players.length);
        setScore(playersAmount);
    }

    public String[] getPlayers() {
        return this.players;
    }

    public void setPlayers(String[] players) {
        this.players = players;
    }

    public int getPlayersAmount() {
        return this.playersAmount;
    }

    public void setPlayersAmount(int playersAmount) {
        this.playersAmount = playersAmount;
    }

    public int[] getScore() {
        return this.scores;
    }

    public int getScore(int index) {
        return this.scores[index];
    }

    public void setScore(int playerAmount) {
        this.scores = new int[playerAmount];
    }

    public void setScore(int index, int amount) {
        this.scores[index] = amount;
    }

}