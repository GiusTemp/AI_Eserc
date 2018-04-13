package it.unibo.ai;

import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;
import aima.core.search.framework.problem.ActionsFunction;

public class MCActionsFunction implements ActionsFunction {

	@Override
	public Set<Action> actions(Object arg0) {
		Set<Action> newSetAction = new LinkedHashSet<Action>();
		State current = (State) arg0;
		
		if (canMoveMC(current))
			newSetAction.add(new DynamicAction("MC"));
		if (canMoveMM(current))
			newSetAction.add(new DynamicAction("MM"));
		if (canMoveCC(current))
			newSetAction.add(new DynamicAction("CC"));
		if (canMoveM(current))
			newSetAction.add(new DynamicAction("M"));
		if (canMoveC(current))
			newSetAction.add(new DynamicAction("C"));
		
		return newSetAction;
	}

	private boolean canMoveC(State current) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean canMoveM(State current) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean canMoveCC(State current) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean canMoveMM(State current) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private boolean canMoveMC(State current) {
		if(current.boatIsPresent()) { // DA PARTENZA AD ARRIVO
			if( current.getM()-1>=current.getC()-1 
				&& current.getTotMiss()-current.getM()+1 >= current.getTotCan()-current.getC()+1 
				 ) 
				return true;
			else
				return false;
			
		} 
		else{ 						//DA ARRIVO A PARTENZA
			
			if(current.getM()>=current.getC() 
					&& current.getM()<=2 
					&& current.getC()<=2 
					&& current.getTotMiss()-current.getM()+1 >= current.getTotCan()-current.getC()+1 
				 ) 
				return true;
			else
				return false;
			
		}
		
	}

	
}

