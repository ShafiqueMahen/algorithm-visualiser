import java.util.ArrayList;
//Creating abstract class Algorithms in order for each of our algorithm classes to extend it
public abstract class Algorithms {
    public ArrayList<GraphPoint> array;
    //Each algorithm will have its own array which is defined and constructed here in the abstract class, to be inherited later
    public Algorithms(ArrayList<GraphPoint> array) {
        this.array = array;
    }
    //Creates a function to set the array so that other functions, when sorting, can set their array to add new values or change it
    public void setArray(ArrayList<GraphPoint> array) {
        this.array = array;
    }

    //This function performs a linear search through the current array in order to check if it is sorted
    public boolean sortCheck(ArrayList<GraphPoint> array){
        setArray(array);
        //For the whole array, if a single instance of a value being larger than its next value is detected, the array is not sorted and so false is returned
        for (int i = 1; i < array.size(); i++){
            if (array.get(i - 1).value > array.get(i).value){
                return false;
            }
        }
        //If the array is iterated through and no violations of order are found, then the array is sorted and true is returned
        return true;
    }
        //This function performs a linear search through the current array in order to check if it is sorted
        public boolean searchCheck(ArrayList<GraphPoint> array){
            setArray(array);
            //For the whole array, if a single instance of a value being larger than its next value is detected, the array is not sorted and so false is returned
            for (int i = 0; i < array.size(); i++){
                if (array.get(i).color ==  array.get(i).getSearchGreen() ){
                    return true;
                }
            }
            //If the array is iterated through and no violations of order are found, then the array is sorted and true is returned
            return false;
        }
}
