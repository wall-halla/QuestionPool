/**
 * 
 */
package question_pool;

/**
 * @author jacob.wall
 *
 */
public class QuestionPool {
	static int poolSize = 25; // CHANGE ME IF DESIRED
	boolean questionPool[];
	boolean isFinished = false;

	QuestionPool() {
		questionPool = new boolean[poolSize];
		initializePool();
	} // Constructor End

	public void initializePool() {
		int index = 0;
		for (index = 0; index < poolSize; index++) {
			questionPool[index] = false;
		} // end For
	}

	public void modifyPool(int index) {
		questionPool[index] = true;
	}

	public int getPoolSize() {
		return poolSize;
	}

	public boolean checkPoolFinished() {
		int index = 0;
		isFinished = true;
		for (index = 0; index < poolSize; index++) {
			if (questionPool[index] == false) {
				isFinished = false;
			}
		}
		return isFinished;
	}

}
