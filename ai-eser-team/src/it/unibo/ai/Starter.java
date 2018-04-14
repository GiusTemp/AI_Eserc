package it.unibo.ai;

import java.util.List;
import java.util.Properties;

import aima.core.agent.Action;
import aima.core.search.framework.SearchAgent;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.TreeSearch;
import aima.core.search.uninformed.BreadthFirstSearch;

public class Starter {

	public static void main(String[] args) {
		State initState = new State(3,3,3,3,1);
		State goalTest = new State(3,3,0,0,0);
		Problem problem = new Problem(initState, new MCActionsFunction(), new MCResultFunction(), goalTest);

		/**
		 * algoritmi di ricerca non informati, non tengono conto dello stato attuale
		 * */
		BreadthFirstSearch search = new BreadthFirstSearch(new TreeSearch());
//		DepthFirstSearch search = new DepthFirstSearch(new TreeSearch());
//		UniformCostSearch search = new UniformCostSearch(new TreeSearch());
		
		/**
		 * algoritmi di ricerca informati, tengono conto dello stato attuale
		 * */
//		AStarSearch search = new AStarSearch(new TreeSearch(),initState);
//		GreedyBestFirstSearch search = new GreedyBestFirstSearch(new TreeSearch(),initState);
		
		try {
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void printInstrumentation(Properties instrumentation) {
		System.out.println(instrumentation);
		System.out.println("------------");

	}

	private static void printActions(List<Action> actions) {
		for (Action x : actions)
			System.out.println(x);
		System.out.println("------------");
	}
}
