import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class LivesRocket {

    private ImageIcon icon;
    private ArrayList<ImageIcon> images;

    public LivesRocket(){
        //create arraylist for images
        images = new ArrayList<>();
        images.add(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/Ship_Lives_0.png"))));
        images.add(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/Ship_Lives_1.png"))));
        images.add(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/Ship_Lives_2.png"))));
        images.add(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/Ship_Lives_3.png"))));
        images.add(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/Ship_Lives_4.png"))));
        images.add(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/Ship_Lives_5.png"))));
        images.add(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/Ship_Lives_6.png"))));

        //set inital image
        icon = images.get(6);
    }

    //update image as player loses lives
    public void updateImage(int lives){
        if(lives >= 0){
            icon = images.get(lives);
        }
        else {
            icon = images.get(6);
        }
    }

    //returns icon
    public ImageIcon getImage(){
        return icon;
    }
}