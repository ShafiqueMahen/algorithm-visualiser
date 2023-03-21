import java.util.ArrayList;
public class LinearSearch extends Algorithms{
    public ArrayList<GraphPoint> array;
    public boolean foundGreen = false;
    public boolean foundBlue = false;
    public int greenInd;
    public int blueInd;
    public LinearSearch(ArrayList<GraphPoint> array){
        super(array);
        this.array = array;
    }

    public boolean searchStep(ArrayList<GraphPoint> tempArray){
    //Declaring variables
    foundBlue = false;
    foundGreen = false;
    //finding a green value to search for
    for(int i=0; i<tempArray.size(); i++ ){
        if(tempArray.get(i).color == tempArray.get(0).getSearchGreen() || tempArray.get(i).isSorted){
           greenInd = i;
           foundGreen = true;
           break;
        }
    }
    if(!foundGreen){
       //turn a random one green
       greenInd = (int)(Math.random() * tempArray.size());
       tempArray.get(greenInd).setColorSearch();;
       tempArray.get(greenInd).isSorted = true;
    }
    //looking for our blue
    for(int i=0; i<tempArray.size(); i++ ){
         if(tempArray.get(i).color == tempArray.get(i).getSearchBlue()){
             blueInd = i;
             foundBlue = true;
             //making the next thing blue
             tempArray.get(blueInd).resetColor();
             tempArray.get(blueInd + 1).setSearchBlue();
             blueInd++;
             break;
         }
    }
    //if we haven't found our blue
    if(!foundBlue){
         //System.out.println("setting first value to blue");
         tempArray.get(0).setSearchBlue();
         blueInd = 0;
         foundBlue = true;
    }

    //check if we've found it
         if(blueInd == greenInd){
                tempArray.get(blueInd).setSearchGreen();
                return true;
         }else{return false;}
    }

}
