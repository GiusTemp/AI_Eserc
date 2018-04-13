package it.unibo.ai;

import aima.core.search.framework.problem.GoalTest;

public class State implements GoalTest{
	
	private int totCan = 3;
	private int totMiss = 3;
	private int m = 3;
	private int c = 3;
	private int b = 1;
	
	public int getTotCan() {
		return totCan;
	}
	public void setTotCan(int totCan) {
		this.totCan = totCan;
	}
	public int getTotMiss() {
		return totMiss;
	}
	public void setTotMiss(int totMiss) {
		this.totMiss = totMiss;
	}
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public boolean boatIsPresent() {
		return b==1;
	}
	public void setB(int b) {
		this.b = b;
	}
	@Override
	public boolean isGoalState(Object arg0) {
		State current = (State) arg0;

		return current.getM() == 0 && current.getC() == 0 && current.b == 0;
	}
	
	
}
