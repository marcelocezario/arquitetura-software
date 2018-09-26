package br.up.edu.arquitetura.biblioteca.model.negocio;

import java.util.ArrayList;

import br.up.edu.arquitetura.biblioteca.model.dominio.Mutuario;
import br.up.edu.arquitetura.biblioteca.model.persistencia.MutuarioPersistencia;

public class MutuarioNegocio {

	private MutuarioPersistencia persist = new MutuarioPersistencia();

	public ArrayList<Mutuario> listarTodos() {
		
		return persist.list();
	}

	public Mutuario find(String nome) {

		return persist.find(nome);
	}

	public Mutuario salvar(Mutuario mutuario) {

		if (mutuario.getId() == null) {
			return persist.update(mutuario);

		} else {
			return persist.insert(mutuario);
		}
	}

	public Mutuario findId(int id) {
		return persist.findId(id);
	}
	
	public void load() {
		
		if (listarTodos().size() == 0) {
			salvar(new Mutuario("Marcelo Henrique", "Rua Senador Accyoli Filho, 511", "41999998888"));
			salvar(new Mutuario("Gabryel", "Rua A, 10", "4133333333"));
		}
	}
}
