package it.unibo.ai;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;
import aima.core.search.framework.problem.ResultFunction;

public class MCResultFunction implements ResultFunction {

	@Override
	public Object result(Object arg0, Action arg1) {
		DynamicAction action = (DynamicAction) arg1;
		State current = (State) arg0;
		
		if(action.getName().equals("MC")) 
			return moveMC(action, current);
		
		if(action.getName().equals("MM") ) 
			return moveMM(action, current);
		
		if(action.getName().equals("CC") ) 
			return moveCC(action, current);
		
		if(action.getName().equals("C") ) 
			return moveC(action, current);
		
		if(action.getName().equals("M") ) 
			return moveM(action, current);
		
		return null;
	}

	private State moveMC(Action action, State state){
		if(state.boatIsPresent()) {
			System.out.println("MCResultFunction = MC from SIDE1 to SIDE2");
			return new State(3, 3, state.getM()-1, state.getC()-1, 0);
		}
		else {
			System.out.println("MCResultFunction = MC from SIDE2 to SIDE1");
			return new State(3, 3, state.getM()+1, state.getC()+1, 1);	
		}
	}
	
	private State moveMM(Action action, State state){
		System.out.println("MCResultFunction = MM");
		if(state.boatIsPresent()) 
			return new State(3, 3, state.getM()-2, state.getC(), 0);
		else 
			return new State(3, 3, state.getM()+2, state.getC(), 1);	
	}
	
	private State moveCC(Action action, State state){
		System.out.println("MCResultFunction = CC");
		if(state.boatIsPresent()) 
			return new State(3, 3, state.getM(), state.getC()-2, 0);
		else 
			return new State(3, 3, state.getM(), state.getC()+2, 1);	
	}
	
	private State moveM(Action action, State state){
		System.out.println("MCResultFunction = M");
		if(state.boatIsPresent()) 
			return new State(3, 3, state.getM()-1, state.getC(), 0);
		else 
			return new State(3, 3, state.getM()+1, state.getC(), 1);	
	}
	
	private State moveC(Action action, State state){
		System.out.println("MCResultFunction = C");
		if(state.boatIsPresent()) 
			return new State(3, 3, state.getM(), state.getC()-1, 0);
		else 
			return new State(3, 3, state.getM(), state.getC()+1, 1);	
	}
}
