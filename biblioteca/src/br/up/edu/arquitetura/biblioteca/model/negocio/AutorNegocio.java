package br.up.edu.arquitetura.biblioteca.model.negocio;

import java.util.ArrayList;

import br.up.edu.arquitetura.biblioteca.model.dominio.Autor;
import br.up.edu.arquitetura.biblioteca.model.persistencia.AutorPersistencia;

public class AutorNegocio {

	private AutorPersistencia persist = new AutorPersistencia();

	public ArrayList<Autor> listarTodos() {

		System.out.println("lista");
		return persist.list();
	}

	public Autor find(String nome) {
		
		return persist.find(nome);
	}

	public Autor salvar(Autor autor) {

		if (autor.getId() == null) {
			return persist.insert(autor);
		} else {
			return persist.update(autor);
		}
	}

	public Autor findId(int id) {
		
		return persist.findId(id);
	}

	public void load() {

		if (listarTodos().size() == 0) {
			salvar(new Autor("Julio Verne", "FranÃ§a"));
			salvar(new Autor("J.R.R Tolkien", "Ã�frica do Sul"));
			salvar(new Autor("João de ferro", "Russia"));
		}
	}
}
