import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Hashtable;

//Initializing the main ui of the program
class Graph extends JPanel {
    //Defines many variables to be used elsewhere
    public ArrayList<GraphPoint> array = new ArrayList<>();
    public GraphDraw GraphDraw = new GraphDraw(array);
    public int sliderValue = 100;
    public int barsliderValue = 5;
    public String listValue = "BogoSort";
    public boolean actionRunning = false;
    int[] customArraySizes = {3, 5, 8, 13, 17, 20, 35, 40, 52, 68, 121, 136, 364, 547, 1094};
    public int timerDelayMs = 1000;
    Thread thread;
    public boolean threadRunning = false;
    //Class containing the creation of the graph
    public Graph (){
        setSize(500,500);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        //graph
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        //height and width
        c.ipady = 500;
        c.ipadx = 850;
        add(GraphDraw,c);

        //Menu
        GraphMenu GraphMenu = new GraphMenu();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.ipady = 120;
        c.ipadx = 620;
        add(GraphMenu, c);

        GraphMenu.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        //Create Array Button
        g.fill = GridBagConstraints.BOTH;
        g.gridx = 0;
        g.gridy = 0;
        //Height and width
        g.ipady = 5;
        g.ipadx = 38;
        Button arrayButton = new Button("Create Array");
        arrayButton.setBounds(30,30,50,100);
        arrayButton.addActionListener(this::actionPerformed);
        arrayButton.setSize(50,50);
        GraphMenu.add(arrayButton, g);

        //Sort Button
        g.fill = GridBagConstraints.BOTH;
        g.gridx = 1;
        g.gridy = 0;
        //Height and Width
        g.ipady = 5;
        g.ipadx = 38;
        Button sortButton = new Button("Sort!");
        sortButton.addActionListener(this::actionPerformed);
        GraphMenu.add(sortButton, g);

        //Auto Sort Button
        g.fill = GridBagConstraints.BOTH;
        g.gridx = 2;
        g.gridy = 0;
        //Height and Width
        g.ipady = 5;
        g.ipadx = 38;
        Button autoSortButton = new Button("Auto Sorting!");
        autoSortButton.addActionListener(this::actionPerformed);
        GraphMenu.add(autoSortButton, g);

        //Combobox to select algorithms
        g.fill = GridBagConstraints.BOTH;
        g.gridx = 3;
        g.gridy = 0;
        //Height and Width
        g.ipady = 5;
        g.ipadx = 38;
        String[] AlgorithmsList = { "BogoSort", "BubbleSort", "InsertionSort", "SelectionSort", "LinearSearch" };
        JComboBox<String> AlgoListBox = new JComboBox<>(AlgorithmsList);
        AlgoListBox.addActionListener(this::setListValue);
        GraphMenu.add(AlgoListBox,g);
        GraphDraw.setarray(array);

        //Row 2 of the buttons and options
        //Contrast Slider
        g.fill = GridBagConstraints.BOTH;
        g.gridx = 0;
        g.gridy = 1;
        //Height and Width
        g.ipady = 5;
        g.ipadx = 38;
        JSlider slider = new JSlider(10,2000);
        slider.setMajorTickSpacing(500);
        slider.setMinorTickSpacing(10);
        slider.setPaintLabels(true);
        JLabel sliderLabel1 = new JLabel("Contrast");
        sliderLabel1.setForeground(new Color(220,220,220));
        Hashtable<Integer, JLabel> labels = new Hashtable<Integer, JLabel>();
        labels.put(1000, sliderLabel1);
        slider.setLabelTable(labels);
        slider.addChangeListener(this::ChangeListener);
        slider.setValue(1000);
        slider.setBackground(new Color(50,50,50));
        GraphMenu.add(slider,g);

        //Array Size Slider
        g.fill = GridBagConstraints.BOTH;
        g.gridx = 1;
        g.gridy = 1;
        //Height and Width
        g.ipady = 5;
        g.ipadx = 38;
        JSlider barslider = new JSlider(1,15,1); //change this later to match with sizing
        barslider.setMajorTickSpacing(1);
        barslider.setPaintLabels(true);
        barslider.setSnapToTicks(true);
        Hashtable<Integer, JLabel> barlabels = new Hashtable<Integer, JLabel>();
        JLabel sliderLabel2 = new JLabel("Array Size");
        sliderLabel2.setForeground(new Color(220,220,220));
        barlabels.put(8, sliderLabel2);
        barslider.setLabelTable(barlabels);
        barslider.addChangeListener(this::BarChangeListener);
        barslider.setBackground(new Color(50,50,50));
        GraphMenu.add(barslider,g);

        //Speed Slider
        g.fill = GridBagConstraints.BOTH;
        g.gridx = 2;
        g.gridy = 1;
        //Height and Width
        g.ipady = 5;
        g.ipadx = 38;
        JSlider speedslider = new JSlider(1,1000,500); //Change this later to match with sizing
        speedslider.setMajorTickSpacing(100);
        speedslider.setPaintLabels(true);
        speedslider.setInverted(true);
        Hashtable<Integer, JLabel> speedlabels = new Hashtable<Integer, JLabel>();
        slider.setPaintLabels(true);
        JLabel sliderLabel3 = new JLabel("Speed");
        //Adjust colours of program
        sliderLabel3.setForeground(new Color(220,220,220));
        speedlabels.put(500, sliderLabel3);
        speedslider.setLabelTable(speedlabels);
        speedslider.addChangeListener(this::TimerChangeListener);
        speedslider.setBackground(new Color(50,50,50));
        GraphMenu.add(speedslider,g);
    }

    //Sets the value of list value to change the page displayed by Info
    public void setListValue(ActionEvent aer){
        JComboBox<String> temp = (JComboBox<String>) aer.getSource();
        listValue = (String)temp.getSelectedItem();
    }

    //This function contains the switch statement to control what each of the buttons and sliders and drop box do
    public void actionPerformed(ActionEvent ae){

        switch (ae.getActionCommand()) {
            //The case for when the create array button is pushed
            case "Create Array":
                actionRunning = true;
                createArray();
                break;

            //Case which affects what algorithm is run based off of the list value when the button is pushed
            case "Sort!":
                actionRunning = true;
                switch (listValue) {
                    //Case for when Bogosort is selected and the Sort button pushed
                    case "BogoSort":
                        BogoSort algorithmInstance = new BogoSort(array);
                        if (!algorithmInstance.sortCheck(array)) {
                            algorithmInstance.sortStep(array);
                            array = algorithmInstance.array;
                            GraphDraw.setarray(array);
                            GraphDraw.repaint();

                        }
                        break;

                    //Case for when Bubble Sort is selected and the Sort button pushed
                    case "BubbleSort":
                        BubbleSort BubbleInstance = new BubbleSort(array);
                        if (!BubbleInstance.sortCheck(array)) {
                            BubbleInstance.sortStep(array);
                            array = BubbleInstance.array;
                            GraphDraw.setarray(array);
                            GraphDraw.repaint();

                        }
                        break;

                    //Case for when Insertion Sort is selected and the Sort button pushed
                    case "InsertionSort":
                        InsertionSort InsertionInstance = new InsertionSort(array);
                        if (!InsertionInstance.sortCheck(array)) {
                            InsertionInstance.sortStep(array);
                            array = InsertionInstance.array;
                            GraphDraw.setarray(array);
                            GraphDraw.repaint();

                       }
                       break;

                    //Case for when Selection Sort is selected and the Sort button pushed
                    case "SelectionSort":
                        SelectionSort SelectionInstance = new SelectionSort(array);
                        if (!SelectionInstance.sortCheck(array)) {
                            SelectionInstance.sortStep(array);
                            array = SelectionInstance.array;
                            GraphDraw.setarray(array);
                            GraphDraw.repaint();

                        }
                        break;

                    //Case for when Linear Search is selected and the Sort button pushed
                    case "LinearSearch":
                        LinearSearch LinearInstance = new LinearSearch(array);
                        if(!LinearInstance.searchCheck(array)) {
                            LinearInstance.searchStep(array);
                            array = LinearInstance.array;
                            GraphDraw.setarray(array);
                            GraphDraw.repaint();
                        }
                        break;

                    case "null":
                        System.out.println("listvalue is " + listValue);

                }

                break;
            //This case is for auto sorting by repeatedly running the algorithm without needing single inputs
            case "Auto Sorting!":
                switch(listValue){
                    //Case for when Insertion Sort is selected and the Auto Sort button pushed
                    case "InsertionSort":
                        InsertionSort insertionInstance = new InsertionSort(array);
                                 thread = new Thread(){
                            public void run() {
                                if (threadRunning) {
                                } else {
                                    threadRunning = true;
                                    actionRunning = false;
                                    InsertionSort insertionInstance = new InsertionSort(array);
                                    while (!insertionInstance.sortCheck(array) && !actionRunning) {
                                        insertionInstance = new InsertionSort(array);
                                        insertionInstance.sortStep(array);
                                        array = insertionInstance.array;
                                        GraphDraw.setarray(array);
                                        try {
                                            Thread.sleep(timerDelayMs);
                                        } catch (Exception e) {
                                            System.out.println("error in thread!");
                                        }
                                        GraphDraw.repaint();
                                    }
                                    actionRunning = false;
                                    threadRunning = false;
                                }
                            }
                        };
                        thread.start();
                        break;
                    //Case for when BogoSort is selected and the Auto Sort button pushed
                    case "BogoSort":
                        BogoSort BogoInstance = new BogoSort(array);
                             thread = new Thread(){
                            public void run() {
                                if (threadRunning) {
                                } else {
                                    threadRunning = true;
                                    actionRunning = false;
                                    BogoSort BogoInstance = new BogoSort(array);
                                    while (!BogoInstance.sortCheck(array) && actionRunning == false) {
                                        BogoInstance = new BogoSort(array);
                                        BogoInstance.sortStep(array);
                                        array = BogoInstance.array;
                                        GraphDraw.setarray(array);
                                        try {
                                            Thread.sleep(timerDelayMs);
                                        } catch (Exception e) {
                                            System.out.println("error in thread!");
                                        }
                                        GraphDraw.repaint();
                                    }
                                    actionRunning = false;
                                    threadRunning = false;
                                }
                            }
                        };
                        thread.start();
                        break;
                    //Case for when Selection Sort is selected and the Auto Sort button pushed
                    case "SelectionSort":
                        SelectionSort SelectionInstance = new SelectionSort(array);
                        thread = new Thread(){
                            public void run() {
                                if (threadRunning) {
                                } else {
                                    threadRunning = true;
                                    actionRunning = false;
                                    SelectionSort SelectionInstance = new SelectionSort(array);
                                    while (!SelectionInstance.sortCheck(array) && !actionRunning) {
                                        SelectionInstance = new SelectionSort(array);
                                        SelectionInstance.sortStep(array);
                                        array = SelectionInstance.array;
                                        GraphDraw.setarray(array);
                                        try {
                                            Thread.sleep(timerDelayMs);
                                        } catch (Exception e) {
                                            System.out.println("error in thread!");
                                        }
                                        GraphDraw.repaint();
                                    }
                                    actionRunning = false;
                                    threadRunning = false;
                                }
                            }
                        };
                        thread.start();
                        break;
                    //Case for when Bubble Sort is selected and the Auto Sort button pushed
                    case "BubbleSort":
                        BubbleSort BubbleInstance = new BubbleSort(array);
                        thread = new Thread(){
                            public void run() {
                                if (threadRunning) {
                                } else {
                                    threadRunning = true;
                                    actionRunning = false;
                                    BubbleSort BubbleInstance = new BubbleSort(array);
                                    while (!BubbleInstance.sortCheck(array) && !actionRunning) {
                                        BubbleInstance = new BubbleSort(array);
                                        BubbleInstance.sortStep(array);
                                        array = BubbleInstance.array;
                                        GraphDraw.setarray(array);
                                        try {
                                            Thread.sleep(timerDelayMs);
                                        } catch (Exception e) {
                                            System.out.println("error in thread!");
                                        }
                                        GraphDraw.repaint();
                                    }
                                    actionRunning = false;
                                    threadRunning = false;
                                }
                            }
                        };
                        thread.start();
                        break;

                    case "LinearSearch":
                        LinearSearch LinearInstance = new LinearSearch(array);
                        thread = new Thread(){
                            public void run() {
                                if (threadRunning) {
                                } else {
                                    threadRunning = true;
                                    actionRunning = false;
                                    LinearSearch LinearInstance = new LinearSearch(array);
                                    while (!LinearInstance.searchCheck(array) && !actionRunning) {
                                        LinearInstance = new LinearSearch(array);
                                        LinearInstance.searchStep(array);
                                        array = LinearInstance.array;
                                        GraphDraw.setarray(array);
                                        try {
                                            Thread.sleep(timerDelayMs);
                                        } catch (Exception e) {
                                            System.out.println("error in thread!");
                                        }
                                        GraphDraw.repaint();
                                    }
                                    actionRunning = false;
                                    threadRunning = false;
                                }
                            }
                        };
                        thread.start();
                        break;
                    default:
                        break;
                }
                    break;
                default:
                //Default check in case something wrong happens
                    System.out.println("currently not implemented! ");
                    break;
        }
    }

    //This function creates a randomised array based off of the slider values selected by the user
    public void createArray(){
        array = new ArrayList<>();
        for (int i = 1; i <= barsliderValue; i++) {
            array.add(new GraphPoint((int) ((Math.random() * (sliderValue * 0.9) + (sliderValue * 0.1)))));
        }
        GraphDraw.setarray(array);
        GraphDraw.repaint();
    }

    //Checks if anything is changed and redraws the program if so
    public void ChangeListener(ChangeEvent e){
       JSlider source = (JSlider) e.getSource();
        if(!source.getValueIsAdjusting()){
            sliderValue = source.getValue();
            GraphDraw.repaint();
        }
    }

    //Checks if the delay timer is adjusted
    public void TimerChangeListener(ChangeEvent ears){
        JSlider source = (JSlider) ears.getSource();
        if(!source.getValueIsAdjusting()){
            timerDelayMs = source.getValue();
        }
    }

    //Checks if the total bar amount is changed
    public void BarChangeListener(ChangeEvent ear){
        actionRunning = true;
       JSlider source = (JSlider) ear.getSource();
        if(!source.getValueIsAdjusting()){
            System.out.println("Changing Bar Amount to " + source.getValue());
            barsliderValue = customArraySizes[source.getValue() - 1];
            createArray();
            GraphDraw.repaint();
        }
        }
}
