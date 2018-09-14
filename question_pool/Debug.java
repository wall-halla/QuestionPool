/**
 * 
 */
package question_pool;

/**
 * @author jacob.wall
 *
 */
public class Debug {

	public void printString(String stringToPrint) {
	System.out.println(stringToPrint);
	}

	public void printBoolArray(boolean bool[], int size) {
		int index=0;
		for (index=0; index<size; index++) {
			System.out.println("Index " + index + " contains " + bool[index] + " !");
		}
	}

	public void printIntArray(int array[], int size) {
		int index=0;
		for (index = 0; index<size; index++) {
			System.out.println("Index " + index + " contains " + array[index] + " !");
		}
	}
	
}
