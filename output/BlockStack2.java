/**
 * Class BlockStack
 * Implements character block stack and operations upon it.
 *
 * $Revision: 1.4 $
 * $Last Revision Date: 2019/02/02 $
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca;
 * Inspired by an earlier code by Prof. D. Probst

 */
class BlockStack
{
	/**
	 * # of letters in the English alphabet + 2
	 */
	public static final int MAX_SIZE = 28;

	/*
	* Task 1: create stack access counter
	*/
	private int stackAccessCounter = 0;

	/**
	 * Default stack size
	 */
	public static final int DEFAULT_SIZE = 6;

	/**
	 * Current size of the stack
	 * Make the variable private
	 */
	private int iSize = DEFAULT_SIZE;

	/**
	 * Current top of the stack
	 * Make the variable private
	 */
	private int iTop  = 3;

	/**
	 * stack[0:5] with four defined values
	 * Make the variable private
	 */
	private char acStack[] = new char[] {'a', 'b', 'c', 'd', '*', '*'};

	/**
	 * Add mutators & accessors from iTop, iSize & acStack
	 */
	public int getTop(){return iTop;}
	public int getSize(){return iSize;}
	public int getAccessCounter(){return stackAccessCounter;}
	public char[] getAcStack(){return acStack;}

	/**
	 * Default constructor
	 */
	public BlockStack()
	{
	}

	/**
	 * Supplied size
	 */
	public BlockStack(final int piSize)
	{


                if(piSize != DEFAULT_SIZE)
		{
			this.acStack = new char[piSize];

			// Fill in with letters of the alphabet and keep
			// 2 free blocks
			for(int i = 0; i < piSize - 2; i++)
				this.acStack[i] = (char)('a' + i);

			this.acStack[piSize - 2] = this.acStack[piSize - 1] = '*';

			this.iTop = piSize - 3;
                        this.iSize = piSize;
		}
	}

	/**
	 * Picks a value from the top without modifying the stack
	 * @return top element of the stack, char
	 */
	public char pick()
	{
		stackAccessCounter++; //increment stack access counter
		return this.acStack[this.iTop];
	}

	/**
	 * Returns arbitrary value from the stack array
	 * @return the element, char
	 */
	public char getAt(final int piPosition)
	{
		stackAccessCounter++; //increment stack access counter
		return this.acStack[piPosition];
	}

	/**
	 * Standard push operation
	 */
	public void push(final char pcBlock)
	{
		//If stack is empty, place pcBlock at 0 (++iTop), otherwise, operate as per.
		
		if(this.isEmpty()){
			this.acStack[++this.iTop] = 'a';
		} else{
			this.acStack[++this.iTop] = pcBlock;
			stackAccessCounter++; //increment stack access counter
			System.out.println("Succesfully pushed to stack.");
		}
	}

	/**
	 * Standard pop operation
	 * @return ex-top element of the stack, char
	 */
	public char pop()
	{
		char cBlock = this.acStack[this.iTop];
		this.acStack[this.iTop--] = '*'; // Leave prev. value undefined
		stackAccessCounter++; //increment stack access counter
		System.out.println("Succesfully popped off stack.");
		return cBlock;
	}

	/**
	 * Standard pop operation
	 * @return if stack is empty, returns true, otherwise is false
	 */
	public boolean isEmpty()
	{
		return (this.iTop == -1);
	}
}

// EOF
