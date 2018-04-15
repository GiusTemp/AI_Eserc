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
		int missOnSide1 = current.getM();
		int canOnSide1 = current.getC();
		int missOnSide2 = current.getTotMiss()-missOnSide1;
		int canOnSide2 = current.getTotCan()-canOnSide1;
		
		if(current.boatIsPresent()) { // DA PARTENZA AD ARRIVO
			if( canOnSide1>=1 && missOnSide1>=canOnSide1-1 && missOnSide2 >= canOnSide2+1 ) 
				return true;
			else
				return false;
			
		} 
		else{ 						//DA ARRIVO A PARTENZA
			if( canOnSide2>=1 && missOnSide2>=canOnSide2-1 && missOnSide1 >= canOnSide1+1 ) 
				return true;
			else
				return false;
		}
	}

	private boolean canMoveM(State current) {
		int missOnSide1 = current.getM();
		int canOnSide1 = current.getC();
		int missOnSide2 = current.getTotMiss()-missOnSide1;
		int canOnSide2 = current.getTotCan()-canOnSide1;
		
		if(current.boatIsPresent()) { // DA PARTENZA AD ARRIVO
			if( missOnSide1>=1 && missOnSide1-1>=canOnSide1 && missOnSide2+1 >= canOnSide2 ) 
				return true;
			else
				return false;
			
		} 
		else{ 						//DA ARRIVO A PARTENZA
			if( missOnSide2>=1 && missOnSide2-1>=canOnSide2 && missOnSide1+1 >= canOnSide1 ) 
				return true;
			else
				return false;
		}
	}

	private boolean canMoveCC(State current) {
		int missOnSide1 = current.getM();
		int canOnSide1 = current.getC();
		int missOnSide2 = current.getTotMiss()-missOnSide1;
		int canOnSide2 = current.getTotCan()-canOnSide1;
		
		if(current.boatIsPresent()) { // DA PARTENZA AD ARRIVO
			if( canOnSide1>=2 && missOnSide1>=canOnSide1-2 && missOnSide2 >= canOnSide2+2 ) 
				return true;
			else
				return false;
			
		} 
		else{ 						//DA ARRIVO A PARTENZA
			if( canOnSide2>=2 && missOnSide2>=canOnSide2-2 && missOnSide1 >= canOnSide1+2 ) 
				return true;
			else
				return false;
		}
	}

	private boolean canMoveMM(State current) {
		int missOnSide1 = current.getM();
		int canOnSide1 = current.getC();
		int missOnSide2 = current.getTotMiss()-missOnSide1;
		int canOnSide2 = current.getTotCan()-canOnSide1;
		
		if(current.boatIsPresent()) { // DA PARTENZA AD ARRIVO
			if( missOnSide1 >= 2 && missOnSide1-2>=canOnSide1 && missOnSide2+2 >= canOnSide2 ) 
				return true;
			else
				return false;
			
		} 
		else{ 						//DA ARRIVO A PARTENZA
			if( missOnSide2 >= 2 && missOnSide2-2>=canOnSide2 && missOnSide1+2 >= canOnSide1 ) 
				return true;
			else
				return false;
		}
	}
	
	private boolean canMoveMC(State current) {
		int missOnSide1 = current.getM();
		int canOnSide1 = current.getC();
		int missOnSide2 = current.getTotMiss()-missOnSide1;
		int canOnSide2 = current.getTotCan()-canOnSide1;
		
		if(current.boatIsPresent()) { // DA PARTENZA AD ARRIVO
			if( canOnSide1 >= 1 && missOnSide1 >= 1 && missOnSide1-1>=canOnSide1-1 
					&& missOnSide2+1 >= canOnSide2+1 ) 
				return true;
			else
				return false;
		} 
		else{ 						//DA ARRIVO A PARTENZA
			if( canOnSide2 >= 1 && missOnSide2 >= 1 && missOnSide2-1>=canOnSide2-1 
					&& missOnSide1+1 >= canOnSide1+1 ) 
				return true;
			else
				return false;
		}
	}

	
}

