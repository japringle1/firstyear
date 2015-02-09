package Strips;

import java.util.ArrayList;

import sheffield.EasyWriter;

/**
 * A class to represent the monkey and bananas problem using strips.
 * @author Jonny
 *
 */
public class MonkeyAndBananas {

	public static void main(String[] args) {
		
		// Create an instance of the easy writer class
		EasyWriter scr = new EasyWriter();

	    //Create the operators
		//Move from one point to another
	    StripsOp move = new StripsOp("move from ?r1 to ?r2", // The action to perform
	                                   "monkey at ?r2", // Vector to add to the state
	                                   "monkey at ?r1", // Vector to remove from the state
	                                   "monkey at ?r1"); // The preconditions for the operator
	    //Push the box from one point to another
	    StripsOp push = new StripsOp("push box from ?r1 to ?r2",
	    								"monkey at ?r2|box at ?r2",
	    								"box at ?r1|monkey at ?r1",
	    								"box at ?r1|monkey at ?r1");
	    //Climb from the floor onto the box
	    StripsOp climb = new StripsOp("monkey climb on box",
	    								"monkey on box",
	    								"monkey on floor",
	    								"monkey on floor|monkey at Q");
	    //Carry the stick from one point to another
	    StripsOp carry = new StripsOp("carry stick from ?r1 to ?r2",
	                                    "monkey at ?r2|stick at ?r2",
	                                    "stick at ?r1|monkey at ?r1",
	                                    "stick at ?r1|monkey at ?r1");
	    //Pick the stick up
	    StripsOp pickUp = new StripsOp("stick picked up",
	    								"monkey has stick",
	    								"monkey doesn't have stick",
	    								"monkey doesn't have stick|monkey at R");
	    //Drop the stick
	    StripsOp drop = new StripsOp("stick dropped",
	    								"monkey doesn't have stick",
	    								"monkey has stick",
	    								"monkey has stick");
	    //Poke at the bananas
	    StripsOp poke = new StripsOp("monkey poked and obtained bananas",
										"monkey has bananas",
										"monkey doesn't have bananas",
										"monkey has stick|monkey on box|monkey at Q|monkey doesn't have bananas");

	    // Form them into a vector
	    ArrayList<StripsOp> monkeyAndBananas = new ArrayList<StripsOp>(); // Create the list
	    monkeyAndBananas.add(move); // Add the operators to the list
	    monkeyAndBananas.add(carry);
	    monkeyAndBananas.add(push);
	    monkeyAndBananas.add(climb);
	    monkeyAndBananas.add(pickUp);
	    monkeyAndBananas.add(drop);
	    monkeyAndBananas.add(poke);

	    //create instance of Strips1, give it the operators, init state & goal state
	    Strips1 str=new Strips1(monkeyAndBananas,
	                            new MStringVector("monkey at N|monkey on floor|monkey doesn't have stick|box at P|stick at R|bananas at Q|monkey doesn't have bananas"),
	                            new MStringVector("bananas at Q|box at Q|monkey has stick|stick at Q|monkey on box|monkey has bananas")
	                  			);


	    //run Strips
	    boolean res=str.run();
	    
	    // Print the result
	    scr.println("Result is "+res); //result
	    scr.println("Plan is \n"+str.getPlan()); //plan


	}

}
