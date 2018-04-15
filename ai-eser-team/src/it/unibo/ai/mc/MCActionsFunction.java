package it.unibo.ai.mc;

import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;
import aima.core.search.framework.problem.ActionsFunction;
import it.unibo.ai.search.mc.MCState;

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
	private boolean canMoveMC(State mcState) {
		// missionars that are on the shore where there is also the boat
	 	int numMissionari;
	 	
	 	// cannibals that are on the shore where there is also the boat
	 	int numCannibali;
	 	
	 	// depending on the shore, I calculate how many missionars/cannibals are
	 	// on that shore
	 	if (mcState.isPosBoat()) {
	 		numMissionari = mcState.getMissionars();
	 		numCannibali = mcState.getCannibals();
	 	}
	 	else {
	 		numMissionari = mcState.getTotMissionars() - mcState.getMissionars();
	 		numCannibali = mcState.getTotCannibals() - mcState.getCannibals();
	 	}
	 	
	 	// assunzione: lo stato corrente e' allowed
	 	// posso fare MC se e solo se: 
	 	if ((numMissionari >= 1) && (numCannibali >= 1) &&
	 		(numMissionari>=numCannibali) &&
	 		(mcState.getTotMissionars()-numMissionari+1 >= mcState.getTotCannibals()-numCannibali+1)
	 		)
	 		return true;
	 	else
	 		return false;
	}

	
	private boolean canMoveMM(State mcState) {
	 	int numMissionari;
	 	int numCannibali;
	 	
	 	if (mcState.isPosBoat()) {
	 		numMissionari = mcState.getMissionars();
	 		numCannibali = mcState.getCannibals();
	 	}
	 	else {
	 		numMissionari = mcState.getTotMissionars() - mcState.getMissionars();
	 		numCannibali = mcState.getTotCannibals() - mcState.getCannibals();
	 	}
	 	if ( 	(numMissionari >= 2) && 
	 			(numMissionari==2 || numMissionari-2 >= numCannibali) &&
	 			(mcState.getTotMissionars()-numMissionari+2 >= mcState.getTotCannibals()-numCannibali)
	 		)
	 		return true;
	 	else
	 		return false;
	}
	

	// quando muovo i cannibali, devo controllare che la sponda di arrivo non diventi sguarnita
	private boolean canMoveCC(State mcState) {
	 	int numMissionari;
	 	int numCannibali;
	 	
	 	if (mcState.isPosBoat()) {
	 		numMissionari = mcState.getMissionars();
	 		numCannibali = mcState.getCannibals();
	 	}
	 	else {
	 		numMissionari = mcState.getTotMissionars() - mcState.getMissionars();
	 		numCannibali = mcState.getTotCannibals() - mcState.getCannibals();
	 	}
	 	if ( 	(numCannibali >= 2) && 
	 			(mcState.getTotMissionars() - numMissionari == 0 ||
	 					mcState.getTotMissionars() - numMissionari >= (mcState.getTotCannibals()- numCannibali + 2)
	 			)
	 		)
	 		return true;
	 	else
	 		return false;
	}
	
	
	// quando muovo un missionario, devo controllare che la sponda di partenza non rimanga sguarnita 
	private boolean canMoveM(State mcState) {
	 	int numMissionari;
	 	int numCannibali;
	 	
	 	if (mcState.isPosBoat()) {
	 		numMissionari = mcState.getMissionars();
	 		numCannibali = mcState.getCannibals();
	 	}
	 	else {
	 		numMissionari = mcState.getTotMissionars() - mcState.getMissionars();
	 		numCannibali = mcState.getTotCannibals() - mcState.getCannibals();
	 	}
	 	if ( 	(numMissionari >= 1) && 
	 			(numMissionari == 1 || numMissionari-1 >= numCannibali) &&
	 			(mcState.getTotMissionars()-numMissionari+1 >= mcState.getTotCannibals()-numCannibali)
	 		)
	 		return true;
	 	else
	 		return false;
	}
	
	
	// quando muovo un cannibale, devo controllare che la sponda di arrivo non diventi sguarnita
	private boolean canMoveC(State mcState) {
	 	int numMissionari;
	 	int numCannibali;
	 	
	 	if (mcState.isPosBoat()) {
	 		numMissionari = mcState.getMissionars();
	 		numCannibali = mcState.getCannibals();
	 	}
	 	else {
	 		numMissionari = mcState.getTotMissionars() - mcState.getMissionars();
	 		numCannibali = mcState.getTotCannibals() - mcState.getCannibals();
	 	}
	 	if ( 	(numCannibali >= 1) && 
	 			(mcState.getTotMissionars() - numMissionari == 0 ||
	 			 mcState.getTotMissionars() - numMissionari >= mcState.getTotCannibals()- numCannibali + 1
	 			)
	 		)
	 		return true;
	 	else
	 		return false;
	}


//	private boolean canMoveC(State current) {
//		int missOnSide1 = current.getMissionars();
//		int canOnSide1 = current.getCannibals();
//		int missOnSide2 = current.getTotMissionars()-missOnSide1;
//		int canOnSide2 = current.getTotCannibals()-canOnSide1;
//		
//		if(current.isPosBoat()) { // DA PARTENZA AD ARRIVO
//			if( canOnSide1>=1 && missOnSide1>=canOnSide1-1 && missOnSide2 >= canOnSide2+1 ) 
//				return true;
//			else
//				return false;
//		} 
//		else{ 						//DA ARRIVO A PARTENZA
//			if( canOnSide2>=1 && missOnSide2>=canOnSide2-1 && missOnSide1 >= canOnSide1+1 ) 
//				return true;
//			else
//				return false;
//		}
//	}
//
//	private boolean canMoveM(State current) {
//		int missOnSide1 = current.getMissionars();
//		int canOnSide1 = current.getCannibals();
//		int missOnSide2 = current.getTotMissionars()-missOnSide1;
//		int canOnSide2 = current.getTotCannibals()-canOnSide1;
//		
//		if(current.isPosBoat()) { // DA PARTENZA AD ARRIVO
//			if( missOnSide1>=1 && missOnSide1-1>=canOnSide1 && missOnSide2+1 >= canOnSide2 ) 
//				return true;
//			else
//				return false;
//			
//		} 
//		else{ 						//DA ARRIVO A PARTENZA
//			if( missOnSide2>=1 && missOnSide2-1>=canOnSide2 && missOnSide1+1 >= canOnSide1 ) 
//				return true;
//			else
//				return false;
//		}
//	}
//
//	private boolean canMoveCC(State current) {
//		int missOnSide1 = current.getMissionars();
//		int canOnSide1 = current.getCannibals();
//		int missOnSide2 = current.getTotMissionars()-missOnSide1;
//		int canOnSide2 = current.getTotCannibals()-canOnSide1;
//		
//		if(current.isPosBoat()) { // DA PARTENZA AD ARRIVO
//			if( canOnSide1>=2 && missOnSide1>=canOnSide1-2 && missOnSide2 >= canOnSide2+2 ) 
//				return true;
//			else
//				return false;
//			
//		} 
//		else{ 						//DA ARRIVO A PARTENZA
//			if( canOnSide2>=2 && missOnSide2>=canOnSide2-2 && missOnSide1 >= canOnSide1+2 ) 
//				return true;
//			else
//				return false;
//		}
//	}
//
//	private boolean canMoveMM(State current) {
//		int missOnSide1 = current.getMissionars();
//		int canOnSide1 = current.getCannibals();
//		int missOnSide2 = current.getTotMissionars()-missOnSide1;
//		int canOnSide2 = current.getTotCannibals()-canOnSide1;
//		
//		if(current.isPosBoat()) { // DA PARTENZA AD ARRIVO
//			if( missOnSide1 >= 2 && missOnSide1-2>=canOnSide1 && missOnSide2+2 >= canOnSide2 ) 
//				return true;
//			else
//				return false;
//			
//		} 
//		else{ 						//DA ARRIVO A PARTENZA
//			if( missOnSide2 >= 2 && missOnSide2-2>=canOnSide2 && missOnSide1+2 >= canOnSide1 ) 
//				return true;
//			else
//				return false;
//		}
//	}
//	
//	private boolean canMoveMC(State current) {
//		int missOnSide1 = current.getMissionars();
//		int canOnSide1 = current.getCannibals();
//		int missOnSide2 = current.getTotMissionars()-missOnSide1;
//		int canOnSide2 = current.getTotCannibals()-canOnSide1;
//		
//		if(current.isPosBoat()) { // DA PARTENZA AD ARRIVO
//			if( canOnSide1 >= 1 && missOnSide1 >= 1 && missOnSide1-1>=canOnSide1-1 
//					&& missOnSide2+1 >= canOnSide2+1 ) 
//				return true;
//			else
//				return false;
//		} 
//		else{ 						//DA ARRIVO A PARTENZA
//			if( canOnSide2 >= 1 && missOnSide2 >= 1 && missOnSide2-1>=canOnSide2-1 
//					&& missOnSide1+1 >= canOnSide1+1 ) 
//				return true;
//			else
//				return false;
//		}
//	}


}

