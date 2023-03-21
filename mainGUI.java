import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import java.awt.*;

public class mainGUI {
    Graph graph = new Graph();
    Info info = new Info();
    Image icon = Toolkit.getDefaultToolkit().getImage("Algorithm Visualiser/src/Icon.png");

    mainGUI() {
        //below section for the JFrame
        JFrame frame = new JFrame("Algorithm Visualiser");
        frame.setSize(1250, 780);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1, 1, 5, 5));//not needed right now
        frame.setVisible(true);
        frame.setBackground(new Color(50, 50, 50));
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setIconImage(icon);

        //below section for the tabbed pane
        JTabbedPane tabbedPanel = new JTabbedPane();//idea behind left and right is that we can add components or layouts to the panels.
        tabbedPanel.setBackground(new Color(50, 50, 50));
        tabbedPanel.addChangeListener(this::ListSelectionListener);
        JPanel graphPanel = graph;
        tabbedPanel.setBorder(new TitledBorder(BorderFactory.createEmptyBorder()));
        graphPanel.setBorder(BorderFactory.createEmptyBorder());
        graphPanel.setBorder(BorderFactory.createEtchedBorder());
        graphPanel.setBackground(new Color(60,60, 100));
        JPanel infoPanel = info;
        tabbedPanel.addTab("Graph", graphPanel);
        tabbedPanel.addTab("Info", infoPanel);
        tabbedPanel.setBackground(Color.WHITE);

        //adding tabbedPanel to the frame
        frame.add(tabbedPanel);
        frame.setResizable(false);
    }

    //Listener to determine when the tabbedpane has switched to change the info displayed based on listValue
    public void ListSelectionListener(ChangeEvent e) {
        info.setListValue(graph.listValue);
    }
}

