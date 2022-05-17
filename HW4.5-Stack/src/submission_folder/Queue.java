package submission_folder;
import java.util.Arrays;

/**
 * This class allows user to create a queue and operate it as similar to the import operations
 * @author Leon Lu
 * @version May 16, 2022
 * @param <V> - the generic parameter to allow user to create a queue holding a specific data type
 */
public class Queue<V> 
{
	private V[] queueArray; 	// The array list to store any data type element.
	private int maxSize = 0;			// The maximum size of the queue.
	private int frontIndex = -1;		// The front index of the queue. As -1, the queue doesn't exist.
	private int lastIndex = -1;			// The last index of the queue. As -1, the queue doesn't exist.
	private int currentSize = 0;		// The current size of the queue.
	
	
	/**
	 * Constructor to initialize the queue with a maximum capacity of maxSize.
	 * @param maxSize - the size of the queue specified by the user
	 */
    @SuppressWarnings("unchecked")
    public Queue(int maxSize) 
    {
    	this.maxSize = maxSize;
    	this.queueArray = (V[]) new Object[maxSize];
    }

    /**
     * Returns the maximum size this queue can support.
     * @return maxSize - the maximum size of the queue
     */
    public int getMaxSize() 
    {
    	return maxSize;
    }

    /**
     * Returns the current number of items enqueued.
     * @return currentSize - the current size of the queue
     */
    public int getCurrentSize() 
    {
    	return currentSize;
    }

    /**
     * Returns true if there are no elements in the queue
     * @return true - if the queue is empty; false if otherwise
     */
    public boolean isEmpty() 
    {
    	return (frontIndex == -1 && lastIndex == -1);
    }

    /**
     * Returns true if the queue is size is at max size.
     * @return true - if the queue is full; false if otherwise
     */
    public boolean isFull() 
    {
    	return (lastIndex == maxSize - 1);
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     * @return the element found at the head of the queue; null if queue is empty
     */
    public V peek()
    {
    	if(this.isEmpty())
    	{
    		return null;
    	}
    	
    	else
    	{
    		return queueArray[frontIndex];
    	}
    }
    
    /**
     * Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions, returning true upon success and throwing an IllegalStateException if no space is currently available.
     * @param value - the element that will be added to the queue
     */
    public void add(V value) 
    {
    	// Check if queue is empty
    	if(this.isEmpty())
    	{
    		// Set both frontIndex and lastIndex to point to the first index
    		frontIndex = 0;
    		lastIndex = 0;
    		queueArray[lastIndex] = value;
    		currentSize++;
    	}
    	
    	// Check if queue is full
    	else if(this.isFull()) 
    	{
    		throw new IllegalStateException("Unable to add element: Queue is full.");
    	}
    	
    	// Queue is neither empty or full
    	else
    	{
    		lastIndex++;
    		queueArray[lastIndex] = value;	 // Increment the last index
    		currentSize++;
    	}
    }

    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     * @return the element from the head of the queue; null if queue is empty
     */
    public V poll() 
    {
    	// Check if queue is empty
    	if(this.isEmpty())
    	{
    		return null;
    	}
    	
    	// Queue has one element
    	else if (frontIndex == lastIndex)
    	{
    		V headElement = this.peek();
    		queueArray[0] = null;
    		
    		// Set both frontIndex and lastIndex to -1, indicating the queue is empty
    		frontIndex = -1; 
    		lastIndex = -1;
    		currentSize--;
    		return headElement;
    	}
    	
    	// Queue has more than one elements
    	else
    	{
    		V headElement = this.peek();
    		
    		// "Shift" the values toward the head by replacing the current value with the next
    		for(int i = 0; i < lastIndex; i++)
    		{
    			queueArray[i] = queueArray[i + 1];
    		}
    		lastIndex--;
    		currentSize--;
    		return headElement;
    	}
    }
    
    /**
     * Retrieves and removes the head of this queue.
     * @return the element from the head of the queue; null if queue is empty
     */
    public V remove()
    {
    	// Check if queue is empty
    	if(this.isEmpty())
    	{
    		return null;
    	}
    	
    	// Queue has one element
    	else if (frontIndex == lastIndex)
    	{
    		V headElement = this.peek();
    		queueArray[0] = null;
    		
    		// Set both frontIndex and lastIndex to -1, indicating the queue is empty
    		frontIndex = -1; 
    		lastIndex = -1;
    		currentSize--;
    		return headElement;
    	}
    	
    	// Queue has more than one elements
    	else
    	{
    		V headElement = this.peek();
    		
    		// "Shift" the values toward the head by replacing the current value with the next
    		for(int i = 0; i < lastIndex; i++)
    		{
    			queueArray[i] = queueArray[i + 1];
    		}
    		lastIndex--;
    		currentSize--;
    		return headElement;
    	}
    }
    
}