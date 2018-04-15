package it.unibo.ai.mc;

import aima.core.search.framework.problem.GoalTest;

public class State implements GoalTest{
	
	private int totCan = 3;
	private int totMiss = 3;
	private int m;
	private int c;
	private int b;
	
	public State(int totCan, int totMiss, int m, int c, int b) {
		super();
		this.totCan = totCan;
		this.totMiss = totMiss;
		this.m = m;
		this.c = c;
		this.b = b;
	}
	
	public int getTotCannibals() {
		return totCan;
	}
	
	public int getTotMissionars() {
		return totMiss;
	}
	
	public int getMissionars() {
		return m;
	}
	
	public int getCannibals() {
		return c;
	}
	
	public boolean isPosBoat() {
		return b==1;
	}
	public void setB(int b) {
		this.b = b;
	}
	
	@Override
	public boolean isGoalState(Object arg0) {
		State current = (State) arg0;

		return (current.getMissionars() == 0 && current.getCannibals() == 0 && current.b == 0);
	}
	
	
}
