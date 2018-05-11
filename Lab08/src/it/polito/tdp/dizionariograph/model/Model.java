package it.polito.tdp.dizionariograph.model;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.dizionariograph.db.WordDAO;

public class Model {
	private Graph<String, DefaultEdge> graph;

	private WordDAO dao;
	private List<String> parole;

	public void createGraph(int numeroLettere) {

		graph = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);
		dao = new WordDAO();
		parole = new ArrayList<>(dao.getAllWordsFixedLength(numeroLettere));

		for (String s : this.parole) {
			graph.addVertex(s);
		}
		for (String a : this.parole) {
			for (String b : this.parole) {
				if (cambiaUnaSolaLettera(a, b) && !a.equals(b)) {

					graph.addEdge(a, b);
				}
			}

		}
		// System.out.println(graph.toString());

	}

	private boolean cambiaUnaSolaLettera(String a, String b) {
		int contatore = 0;
		for (int i = 0; i < a.length(); i++) {
			char primocarattere = a.charAt(i);
			char confronto = b.charAt(i);
			if (primocarattere == confronto) {

				contatore++;

			}
		}

		if (contatore == a.length() - 1)
			return true;

		return false;
	}

	public List<String> displayNeighbours(String parolaInserita) {

		try {
			Graphs.neighborListOf(graph, parolaInserita);
			
		}catch (IllegalArgumentException iae) {
			return new ArrayList<String>();
		}
		return Graphs.neighborListOf(graph, parolaInserita);

	}

	public int findMaxDegree() {
		//System.err.println("findMaxDegree -- TODO");
		int max = 0;
		for (String v : this.graph.vertexSet()) {
			if (max < Graphs.neighborListOf(graph, v).size()) {
				max = Graphs.neighborListOf(graph, v).size();
			}
		}
		return max;
	}

	public  String getGraph() {
		// TODO Auto-generated method stub
		return this.graph.toString();
	}
}
