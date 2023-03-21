import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//Draws the background for the Graph Menu, small function but mostly affects bg and design
public class GraphMenu extends JPanel {
    public ArrayList<Integer> array;
    public GraphMenu(){
        setBackground(new Color(50, 50, 50));
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(new Color(0,0,0));
        g.drawRect(0, 0,getWidth()-1,getHeight());
    }
    
    
}
