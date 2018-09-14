/**
 * 
 */
package question_pool;

import java.util.Random;

/**
 * @author jacob.wall
 *
 */
public class Test {
	int testSize = 7; //CHANGE ME IF DESIRED
	int testArray[];

	Random numGenerator = new java.util.Random();

	Test() {
		testArray = new int[testSize];
		initializeArray();
		makeTest();
	}

	public void initializeArray() {
		int index = 0;
		int initializeValue = -1;
		for (index = 0; index < testSize; index++) {
			testArray[index] = initializeValue;
		}
	} //end inirializeArray()

	public int makeQuestion() {
		int question = numGenerator.nextInt(QuestionPool.poolSize);
		return question;
	} // end makeQuestion()

	public boolean checkUnique(int question, int checkUntil) {
		int index;
		boolean isUnique = true;
		for (index = 0; index < checkUntil; index++) {
			if (testArray[index] == question)
				isUnique = false;
		} // end for
		return isUnique;
	} // end checkUnique()

	public void makeTest() {
		int index;
		int question;
		for (index = 0; index < testSize; index++) {
			question = makeQuestion();
			while (checkUnique(question, index) == false) {
			//	System.out.println("Index " + index + " containing " + question + " was a duplicate.");
				question = makeQuestion();
				checkUnique(question, index);
			} // end while
			testArray[index] = question;
		} // end for

	} // end makeTest()

}