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
	
	
	public void add(T newElement) {
		//1. verify if heap is full
		if(isFull())
		{
			//1.2. increase size and copy elements
			increaseArray();
		}
		
		//2. add new elements
		elements[elementCounter] = newElement;
		//3. increase element counter
		elementCounter++;
		reheapUp(elementCounter - 1);
	}
	
	public T remove() throws Exception {
		if(isEmpty())
		{
			throw (new Exception("heap is empty, it is not possible to retrieve root element"));
		}
		
		T element = elements[0];
		elements[0] = elements[elementCounter-1];
		elementCounter--;
		//TODO call reheapDown()
		return element;
		
	}
	
	
	private void reheapUp(int indexOfElement) {
		
		// rightChIndex = parentIndex * 2 + 2;
		//leftChIndex  = parentIndex * 2 + 1;
		
		//(rightChIndex - 2)/2 =  parentIndex
		//(leftChIndex - 1)/2  =  parentIndex
		
		// (4-2)/2 = 1 -> (4 - 1)/2 = 3/2 = 1.5-> (int)1.5 = 1
		// (3-1)/2 = (int)1 -> 1
		
		int indexOfParent = (int)((indexOfElement - 1)/2);
		
		if(indexOfElement >= 0) {
			
			//if(elements[indexOfElement] > elements[indexOfParent]) {
			if(     ((Comparable)(elements[indexOfElement])).compareTo(elements[indexOfParent]) > 0 )
			{
				swap(indexOfElement, indexOfParent);
				reheapUp(indexOfParent);
			}
		}
	
	}
	
	private void swap(int index1, int index2) {
		T temp = elements[index1];
		elements[index1] = elements[index2];
		elements[index2] = temp;
	}
	
}
