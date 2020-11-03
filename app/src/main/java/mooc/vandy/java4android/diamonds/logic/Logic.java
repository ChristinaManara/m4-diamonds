package mooc.vandy.java4android.diamonds.logic;

import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {
        // TODO -- add your code here
        // Here we define the first line(fl), the last line(ll) and the center line(cl) based on the given size.
        int fl = 1;
        int cl = size + fl;
        int ll = 2 * size + 1;
        // Here we define the number of lines & the number of columns.
        int numOfLines = 2 * size + 1;
        int numOfCol = numOfLines + 1;
        // Here we define the first & second middle index.
        int middleIndex1 = numOfCol / 2;
        int middleIndex2 = middleIndex1 + 1;
        // Here we define the number of columns based on the given size.
        // fc -> first column, lc -> last column
        int fc = fl, lc = numOfCol;
        for(int i = 1; i < numOfLines + 1; i++){
            // We define the structure of the first and the last line.
            if(i == fl || i == ll){
                // For every column, if we are in the first of last column we print a plus else a minus.
                for(int j = 1; j < numOfCol + 1; j++){
                    if(j == fc || j == lc){
                        mOut.print("+");
                    } else{
                        mOut.print("-");
                    }
                }
                // Here we define the structure of the center line.
            } else if(i == cl){
                // For every column we check if we are in the first, last, or in the middle lines.
                for(int j = 1; j < numOfCol + 1; j++){
                    if(j == fc || j == lc){
                        mOut.print("|");
                    } else if(j == (fc + 1)){
                        mOut.print("<");
                    } else if(j == (lc - 1)){
                        mOut.print(">");
                    } else {
                        // If the index number of center line is even we print a minus or an equal.
                        if(size % 2 == 0){
                            mOut.print("-");
                        } else {
                            mOut.print("=");
                        }
                    }
                }
                middleIndex1 = middleIndex1 + 1;
                middleIndex2 = middleIndex2 - 1;
                // Here we define the structure of the upper part of the diamond.
            } else if(i < cl){
                for(int j = 1; j < numOfCol + 1; j++){
                    if(j == fc || j == lc){
                        mOut.print("|");
                    } else if(j < middleIndex1 || j > middleIndex2){
                        mOut.print(" ");
                    } else if(j == middleIndex1){
                        mOut.print("/");
                    } else if(j == middleIndex2){
                        mOut.print("\\");
                    } else if(j > middleIndex1 && j < middleIndex2){// We introduce two indexes which define the areas that have are not blank.
                        // If the line is even we print minus else equal.
                        if((i - 1) % 2 == 0){
                            mOut.print("-");
                        } else{
                            mOut.print("=");
                        }
                    }
                }
                middleIndex1 = middleIndex1 - 1;
                middleIndex2 = middleIndex2 + 1;
                // Here we define the structure of the down part of the diamond.
            } else {
                for(int j = 1; j < numOfCol + 1; j++){
                    if(j == fc || j == lc){
                        mOut.print("|");
                    } else if(j < middleIndex1 || j > middleIndex2){
                        mOut.print(" ");
                    } else if(j == middleIndex1){
                        mOut.print("\\");
                    } else if(j == middleIndex2){
                        mOut.print("/");
                    } else if(j > middleIndex1 && j < middleIndex2){// We introduce two indexes which define the areas that have are not blank.
                        // If the line is even wi print minus else equal.
                        if((i - 1) % 2 == 0){
                            mOut.print("-");
                        } else{
                            mOut.print("=");
                        }
                    }
                }
                middleIndex1 = middleIndex1 + 1;
                middleIndex2 = middleIndex2 - 1;
            }
            mOut.print("\n");
        }
    }
}
