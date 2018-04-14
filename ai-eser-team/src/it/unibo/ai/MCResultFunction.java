package it.unibo.ai;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;
import aima.core.search.framework.problem.ResultFunction;

public class MCResultFunction implements ResultFunction {

	@Override
	public Object result(Object arg0, Action arg1) {
		DynamicAction action = (DynamicAction) arg1;
		State current = (State) arg0;
		
		if(action.getName().equals("MC") ) 
			return new State(3, 3, current.getM()-1, current.getC()-1, 0);
		
		if(action.getName().equals("MM") ) 
			return new State(3, 3, current.getM()-2, current.getC(), 0);
		
		if(action.getName().equals("CC") ) 
			return new State(3, 3, current.getM(), current.getC()-2, 0);
		
		if(action.getName().equals("C") ) 
			return new State(3, 3, current.getM(), current.getC()-1, 0);
		
		if(action.getName().equals("M") ) 
			return new State(3, 3, current.getM()-1, current.getC(), 0);
		
		return null;
	}

}
