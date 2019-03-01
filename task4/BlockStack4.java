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

import common.myStackException;

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
	 */
	public int iSize = DEFAULT_SIZE;

	/**
	 * Current top of the stack
	 */
	private int iTop  = 3;

	/**
	 * stack[0:5] with four defined values
	 */
	private char acStack[] = new char[] {'a', 'b', 'c', 'd', '*', '*'};

	/**
	 * @return if stack is empty, returns true, otherwise is false
	 */
	public boolean isEmpty()
	{
		return (this.iTop == -1);
	}

	/*
	* Getters
	*/
	public int getITop(){return iTop;}
	public int getISize(){return iSize;}
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
	public char pick() throws myStackException
	{
		stackAccessCounter++;
		if(!isEmpty())
			return this.acStack[this.iTop];
		else 
			throw new myStackException("Stack is empty!!!"); //If stack is empty, cannot return top element.
	}

	/**
	 * Returns arbitrary value from the stack array
	 * @return the element, char
	 */
	public char getAt(final int piPosition) throws myStackException
	{
		stackAccessCounter++;
		if(piPosition < iSize) //If position is inside limits of stack size, return value
			return this.acStack[piPosition];
		else
			throw new myStackException("Cannot access position " + piPosition + " in the stack.");
	}

	/**
	 * Standard push operation
	 */
	public void push(final char pcBlock) throws myStackException
	{
		stackAccessCounter++;
		if(iTop < iSize){
			if(isEmpty()) 
				this.acStack[++this.iTop] = 'a'; //If stack is empty, add 'a' as first value
 			else
				this.acStack[++this.iTop] = pcBlock;
		} else
			throw new myStackException("Stack is full!!!"); //If stack is full, cannot push
	}

	/**
	 * Standard pop operation
	 * @return ex-top element of the stack, char
	 */
	public char pop() throws myStackException
	{
		stackAccessCounter++;
		if(!isEmpty()){
			char cBlock = this.acStack[this.iTop];
			this.acStack[this.iTop--] = '*'; // Leave prev. value undefined
			return cBlock;
		} else
			throw new myStackException("Empty Stack!!!"); //If stack is empty, cannot pop
	}
}

// EOF
