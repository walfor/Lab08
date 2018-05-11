package it.polito.tdp.dizionariograph.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		model.createGraph(4);
		System.out.println(String.format("**Grafo creato**\n"));
		String ricerca ="acca";
		List<String> vicini = model.displayNeighbours(ricerca);
		System.out.println("Neighbours di "+ricerca+" : " + vicini + "\n");
		
		System.out.println("Cerco il vertice con grado massimo...");
		System.out.println(model.findMaxDegree());
	}

}
