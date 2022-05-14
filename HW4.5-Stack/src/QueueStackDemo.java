class QueueStackDemo {

	public static void main(String[] args)  {
		Queue<Integer> queue = new Queue<Integer>(5);
		//equeue 2 4 6 8 10 at the end
        queue.enqueue(2);
		queue.enqueue(4);
		queue.enqueue(6);
		queue.enqueue(8);
		queue.enqueue(10);
        //dequeue 2 elements from the start
		queue.dequeue();
		queue.dequeue();
		//enqueue 12 and 14 at the end
        queue.enqueue(12);
        queue.enqueue(14);

        System.out.println("Queue:");
        while(!queue.isEmpty()){
                System.out.print(queue.dequeue()+" ");
         }
            
        Stack<Integer> stack = new Stack<Integer>(3);
 
        stack.push(1);      // inserting 1 in the stack
        stack.push(2);      // inserting 2 in the stack
 
        stack.pop();        // removing the top element (2)
        stack.pop();        // removing the top element (1)
 
        stack.push(3);      // inserting 3 in the stack
 
        System.out.println("The top element is " + stack.peek());
        System.out.println("The stack size is " + stack.size());
 
        stack.pop();        // removing the top element (3)
 
        // check if the stack is empty
        if (stack.isEmpty()) {
            System.out.println("The stack is empty");
        }
        else {
            System.out.println("The stack is not empty");
        }
    }
}