package datastr;

public class MyHeap<T> {
	private T[] elements;
	private final int DEFAULT_ARRAY_SIZE = 10;
	private int arraySize = DEFAULT_ARRAY_SIZE;
	private int elementCounter = 0;
	
	public MyHeap()
	{
		elements = (T[]) new Object[arraySize];
	}
	
	public MyHeap(int inputArraySize)
	{
		if(inputArraySize > 0)
		{
			arraySize = inputArraySize;
		}
		elements = (T[]) new Object[arraySize];
		
	}
	
	//TODO isFull, isEmpty, howManyElements, increaseArray

	
	
	public boolean isEmpty() {
		return (elementCounter == 0);
	}

	public boolean isFull() {
		return (elementCounter == arraySize);
	}

	public int howManyElements() {
		return elementCounter;
	}

	// 1. create a definition of function increaseArray
	private void increaseArray() {
		// 2. calculate the new size of the new array
		int newArraySize = (arraySize > 100) ? (int) (arraySize * 1.5) : arraySize * 2;

		/*
		 * int newArraySize = arraySize *2; if(arraySize>100) { newArraySize = (int)
		 * (arraySize*1.5); }
		 */
		/*
		 * int newArraySize; if(arraySize > 100) { newArraySize = (int)(arraySize *1.5);
		 * } else { newArraySize =arraySize * 2; }
		 */
		// 3. create the new array
		T[] newElements = (T[]) new Object[newArraySize];
		// 4. copy all elements from the old array to the new array
		for (int i = 0; i < elementCounter; i++) {
			newElements[i] = elements[i];
		}
		// 5. change reference to the new array and it's size
		elements = newElements;
		arraySize = newArraySize;
	}
}
