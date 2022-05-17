package submission_folder;
import java.util.ArrayList;

/**
 * This file controls how stack will be handled by the user
 * @author Leon Lu
 * @version May 16, 2022
 * @param <V> - the data type of element that will be used in the stack
 */
public class Stack<V>
{
	private ArrayList<V> stackArray;// The list that will be used to store the elements. Unable to use array due to the need to store generic object
	private int size = 0; 			// The maximum size of the stack
	private V element; 				// The element that will be added to the array list
	private int numberOfItem = 0; 	// The number of elements in the stack
	private int stackTop = -1; 		// The index of the stack. -1 indicates the stack does not exist or is empty
	
	
	
    /**
     * Constructor to initialize the stack with a maximum capacity of maxSize.
     * @param size - the user desired size for the stack
     */
    @SuppressWarnings("unchecked")
    public Stack(int size)
    {
    	this.size = size; 							// Set the maximum size for stack
    	this.stackArray = new ArrayList<V>(size); 	// Create the array with the size of size (variable)
    }
    
    /**
     * Pushes an item onto the top of this stack.
     * @param - the element is the element that will be added to the stack
     */
    public void push(V element)
    {
    	
    	//Check if the stack is full. If is full, throw exception
    	if(isFull())
    	{
    		throw new IllegalStateException("Cannot add elemenet: Stack is full");
    	}
    	else
    	{
    		stackArray.add(element); 	// Add element to the arraylist
    		stackTop++; 				// Increment the index for the new top element
    		numberOfItem++; 			// Increment the number of items in the arraylist
    	}
    }
 
    /**
     * Removes the object at the top of this stack and returns that object as the value of this function.
     * @return elementToReturn - the element that is removed from the stack
     */
    public V pop()
    {
    	// Check if the stack is empty. If is empty, throw exception
    	if(isEmpty())
    	{
    		throw new IllegalStateException("Cannot remove element: Stack is already empty.");
    	}
    	else
    	{
    		V elementToReturn = this.peek();	// Get element from the top of the stack
    		stackArray.remove(stackTop);		// Remove the element from the top of the stack
    		stackTop--;							// Decrement the index due to removal of the top element
    		numberOfItem--;						// Decrement the index due to removal of the top element
    		return elementToReturn;
    	}
    }
 
    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     * @return element - the element that is on the top of the stack; otherwise, return null if otherwise
     */
    public V peek()
    {
    	if(isEmpty() == false)
    	{
    		return stackArray.get(stackTop); // Return the element found on top index
    	}
    	else
    	{
    		return null;
    	}

    }
 
    /**
     * Returns the number of items currently in the stack
     * @return numberOfItem - the number of elements in the stack
     */
    public int currentSize() 
    {
    	return numberOfItem;
    }
 
    /**
     * Tests if this stack is empty.
     * @return true - if the stack is empty; false if otherwise
     */
    public boolean isEmpty()
    {
    	return(stackTop == -1);
    }
 
    /**
     * Tests if this stack is full
     * @return true - if the stack is false; false if otherwise
     */
    public boolean isFull() 
    {
    	return(stackTop == size - 1);
    }
    
}