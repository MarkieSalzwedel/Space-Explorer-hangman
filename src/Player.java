public class Player {

    private int lives;

    // constructor
    public Player(){
        this.lives = 6;
    }

    // player losses life
    public void lifeLoss(){
        lives -= 1;
    }

    // get player lives
    public int get_lives(){
        return lives;
    }

}
