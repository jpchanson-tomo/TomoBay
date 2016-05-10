/**
 * This Package contains the Classes necessary to replace a standard procedural conditional statement 
 * (if-then-else) with a general purpose Object Oriented version that uses double dispatch as its method
 * of behaviour selection.
 * 
 * ##Introduction
 * First off this mini framework is not designed to completely replace the traditional conditional
 * statement, while possible to do so this may adversely effect the performance of the application.
 * It is designed for code, which for some reason reason or other, requires relatively complex
 * condition evaluation (traditionally evaluated using if-then, switch or nested if statements.....the horror) 
 * and encapsulate and compartmentalise the various parts of these to aid in maintainability and reduce
 * cyclomatic complexity; as well as enabling the user of this framework to have their classes BE
 * conditional as opposed to HAVING conditionality.
 * 
 * The use cases envisioned for this framework (although there may be other applications) are:
 *  - taking conditional statements with complex conditions and encapsulating the Condition and Result
 *  seperately.
 *  - replacing nested If statements by a 'chain of command' style pattern
 *  - Allowing users to created objects which are intrinsically conditional and to use them to simplify
 *  the design of their code.
 * 
 * ##Getting Started, Complex Conditions (Basic Usage)
 * Pretty much all of the use cases require similar setups so here is the basic skeleton of a test 
 * implementation:
 * 
 * \code
 * public class TestCondition extends Condition
 * {
 * 	private final int valueA_M;
 * 	private final int valueB_M;
 * 	private final int valueC_M;
 * 
 * 	//all values needed for condition evaluation should be passed to constructor
 * 	public TestCondition(int a, int b, int c)
 * 	{
 * 		this.valueA_M = a;
 * 		this.valueB_M = b;
 * 		this.valueC_M = c;
 * 	}
 * 
 * 	//defines the expression to evaluate
 * 	protected boolean expression()
 * 	{
 * 		return this.valueA_M > this.valueB_M 
 * 							&& 
 * 				this.valueB_M > this.valueC_M;
 * 	}
 * }
 * \endcode
 * 
 * As you can see, the first step is to subclass the Condition class, the important method in the
 * implementation of this class is the expression() method which returns a boolean value defined
 * by your expression, in this case: `a > b AND b > c` . All the values needed by this condition
 * should be passed into the constructor and stored so that this expression has data to operate on.
 * 
 * \code
 * public class TestResult extends Result<String>
 * {
 * 	public TestResult()
 * 	{super();}
 * 
 * 	//behaviour to be invoked if Condition evaluates to true goes here
 * 	public String result(True yes);
 * 	{
 * 		return "success!";
 * 	}
 * 	
 * 	//behaviour to be invoked if Condition evaluates to false goes here
 * 	public String result(False no);
 * 	{
 * 		return "Failure";
 * 	}
 * }
 * \endcode
 * 
 * The next step is to subclass the Result class in order to define what behaviour you wish to occur 
 * given a true or false result. This is accomplished by result(True yes) and result(False no) methods 
 * which contain the respective behaviours. The Result class must be parameterised as this is how you 
 * define the return types of the result methods. i.e. if you wanted to return an integer you would 
 * parameterise it as `public class TestResult Result<Integer>`  and the result methods would then 
 * also return Integer.
 * 
 * \code
 * public class TestConditional extends Conditional<String>
 * {
 * 	private final int valueA_M;
 * 	private final int valueB_M;
 * 	private final int valueC_M;
 * 
 * 	//default ctor
 * 	public TestConditional(int a, int b, int c)
 * 	{
 * 		this.valueA_M = a;
 * 		this.valueB_M = b;
 * 		this.valueC_M = c;
 * 	}
 * 
 *		//default condition
 * 	public Condition startCondition()
 * 	{
 * 		return new TestCondition(this.valueA_M, this.valueB_M, this.valueC_M);
 * 	}
 * 
 * 	//result for default condition
 * 	public Result<String> startResult()
 * 	{	
 * 		return new TestResult();
 * 	}
 * }
 * \endcode
 * 
 * The last stage of the setup is to define the initial conditions for the conditional. As with the 
 * similarly to the previous steps, this involves sub-classing, in this case the Conditional class. 
 * Overriding the startCondition() and startResult() methods to provide the default condition and 
 * behaviour, as well as making sure that the values needed for the Condition object (and the Result
 *  object if necessary) are passed into the constructor of the Conditional.
 * 
 * The Conditional derived object can then be used as follows:
 * \code
 * final int a = 3; final int b = 2; final int c = 1;
 * 
 * TestConditional test = new TestConditional(a,b,c)
 * 
 * String result = test.evaluate();
 * 
 * System.out.println()result; // prints "success"
 * \endcode
 * 
 * As you can see (above) it is relatively straightforward to call the default behaviour. Below is 
 * an example of passing in some non default Condition and Result objects.
 * 
 * \code
 * final int a = 3; final int b = 2; final int c = 1;
 * 
 * TestCondition testCondition = new TestCondition(a,b,c);
 * TestResult testResult = new TestResult();
 * TestConditional test = new TestConditional();
 * 
 * String result = test.evaluate(testCondition, testResult);
 * 
 * System.out.println(result); // prints "Success"
 * \endcode
 * 
 * This ignores the default behaviour and uses the Condition and Result objects passed in directly (
 * in this case they happen to be the same as the default behaviour, but they could be different).
 * 
 * ##Replacing Nested If's
 * Really speaking long sequences of if, else-if statements are a form of nested if statement, you can
 * see from the code below that the two are equivalent:
 * 
 * <table style="border 0px solid white"><tr><td>
 * \code 
 * //standard If/Else-If
 * 
 *  if(condition1)
 *	{
 *		//do stuff
 *	}
 *	else if(condition 2)
 *	{
 *		//do other stuff
 *	}
 *	else if(condition 3)
 *	{
 *		//do different stuff
 *	}
 *	else
 *	{
 *		//do other different stuff
 *	}
 * \endcode </td><td>
 * \code
 * //Unrolled If/Else-If
 * 
 *  if(condition1)
 *	{
 *		//do stuff
 *	}
 *	else
 *	{
 *		if(condition 2)
 *		{
 *			//do other stuff
 *		}
 *		else
 *		{
 *			if(condition 3)
 *			{
 *				//do different stuff
 *			}
 *			else
 *			{
 *				//do other different stuff
 *			}
 *		}
 *	}
 * \endcode </td></tr></table>
 * 
 * as a result the method for creating longer series of switch style if-else statements is the same 
 * as that for creating nested if statements. The process for this is more or less exactly the same as 
 * the basic usage with a minor modification to the Result and Conditional objects.
 * 
 * The first step is to set up all the conditions that you will need (as described in the previous section)
 * and then you need to set up the Result Object:
 * 
 * \code
 * public class NestedResult extends Result<String>
 * {
 * 	//holds the Conditional object that will handle the next set of Condition , Result object
 * 	private final nextConditional<String> next_M;
 * 	private final int valueA_M;
 * 	private final int valueB_M;
 * 	private final int valueC_M;
 * 
 * 	public TestResult(Conditional<String> next, int a, int b, int c)
 * 	{
 * 		super();
 * 		this.next_M = next;
 * 		this.valueA_M = a;
 * 		this.valueB_M = b;
 * 		this.valueC_M = c;
 * 	}
 * 
 * 	//behaviour to be invoked if Condition evaluates to true goes here
 * 	public String result(True yes);
 * 	{
 * 		return "success!";
 * 	}
 * 	
 * 	//behaviour to be invoked if Condition evaluates to false goes here
 * 	public String result(False no);
 * 	{
 * 		Condition nextCondition = new anotherCondition(this.valueA_M, this.valueB_M, this.valueC_M)
 * 		Result<String> nextResult = new anotherResult();
 * 
 * 		return this.nextHandler_M.evaluate(nextCondition, nextResult);
 * 	}
 * }
 * \endcode
 * 
 * Most of this should be self explanatory and very similar to what we've seen before with the Conditional
 * Condition derived classes we've created in the 'basic usage' section, and we need it now in this 
 * result, so that it can be passed to the next Condition.
 * 
 * You then need to set up the conditional, this is also slightly different from before but not by
 * much:
 * \code
 * public class TestConditional extends Conditional<String>
 * {
 * 	private final int valueA_M;
 * 	private final int valueB_M;
 * 	private final int valueC_M;
 * 
 * 	//default ctor
 * 	public TestConditional(int a, int b, int c)
 * 	{
 * 		this.valueA_M = a;
 * 		this.valueB_M = b;
 * 		this.valueC_M = c;
 * 	}
 * 
 *		//default condition
 * 	public Condition startCondition()
 * 	{
 * 		return new TestCondition(this.valueA_M, this.valueB_M, this.valueC_M);
 * 	}
 * 
 * 	//result for default condition
 * 	public Result<String> startResult()
 * 	{	
 * 		return new TestResult(this, this.valueA_M, this.valueB_M, this.valueC_M);
 * 	}
 * }
 * \endcode
 * 
 * The only differences here is that TestConditional passes itself to the TestResult object allowing
 * it to be used by Result objects further down the chain to evaluate other Condition and Result objects.
 * 
 * This Conditional class is then invoked using its default behaviour and the data makes its way down
 * the chain until it reaches a terminating outcome at which point the result makes its way back up the
 * chain to the caller.
 * 
 * ##Intrinsically Conditional Design
 * This framework doesn't need to be used in isolation to replace traditional conditional statements 
 * (although it will work fine doing it this way), it can be made an intrinsic part of the class; 
 * take, for example, a problem that you chose to solve using the strategy pattern, you could make the
 * context class implement the Conditional abstract base class allowing it to decide the particular
 * strategy implementation at runtime, keeping the coupling between the decision logic and the strategy
 * implementation loose; as well as keeping the cohesion high.
 * 
 * 
 * @author Jan P.C. Hanson
 *
 */
package tomoBay.model.dataTypes.conditionalStatement;