/**
 * 
 */
package question_pool;

/**
 * @author Walls
 *
 ***         Make changes to Test.testSize and QuestionPool.poolSize as desired***
 *
 *         The purpose of this program is to figure out how many times a student
 *         would have to take a practice quiz in order to see all of the
 *         questions in a given pool. Each question will be unique on the test,
 *         and duplicates aren't allowed.
 *
 */
public class Logic {
	int numTestsNeeded;
	double attemptsArray[];
	int numCycles = 50_000;
	double averageAttempts;
	int questionPopularity[];

	Logic() {
		attemptsArray = new double[numCycles];
		questionPopularity = new int[QuestionPool.poolSize];
		initializeAttempts();
	}

	static public void main(String args[]) {

		int index = 0;

		// Debug debugger = new Debug();
		QuestionPool pool = new QuestionPool();
		Test test = new Test();
		Logic mainLogic = new Logic();

		for (index = 0; index < mainLogic.numCycles; index++) {
			while (pool.checkPoolFinished() == false) {
				mainLogic.attemptsArray[index]++;
				mainLogic.takeTest(pool, test);
			} // end while
			pool.initializePool();
		//	System.out.println(mainLogic.attemptsArray[index] + " tests completed to view all answers!");
		} // end for
		mainLogic.printPopularity();
		mainLogic.averageAttempts();
	}// end main method

	public void takeTest(QuestionPool pool, Test test) {
		int index = 0;
		test.initializeArray();
		test.makeTest();
		for (index = 0; index < test.testSize; index++) {
			pool.modifyPool(test.testArray[index]);
			questionPopularity[test.testArray[index]]++;
		} // end for
	}// end takeTest()

	public void initializeAttempts() {
		int index = 0;
		for (index = 0; index < numCycles; index++) {
			attemptsArray[index] = -1;
		}
	} // end initializeAttempts()

	public void printPopularity() {
		int index = 0;
		for (index = 0; index < QuestionPool.poolSize; index++) {
			System.out.println("Question number " + index + " came up " + questionPopularity[index] + " times.");
		}
	} // end printPopularity()

	public void averageAttempts() {
		int index = 0;
		double averageInt = 0;
		for (index = 0; index < numCycles; index++) {
			averageInt = averageInt + attemptsArray[index];
		}
		averageAttempts = averageInt / numCycles;
		System.out.println("The average number of attempts to view all questions is: " + averageAttempts);
		System.out.println("The total number of cycles completed is: " + numCycles);
	} // end averageAttempts()

}// end Main class
