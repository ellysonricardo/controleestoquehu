package br.ufrj.hucff.controleestoque.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.ufrj.hucff.controleestoque.DAO.DAOGeneric;
import br.ufrj.hucff.controleestoque.modelo.Categoria;

@ViewScoped
@ManagedBean(name = "CategoriaBean")
public class CategoriaBean {
	
	private Categoria categoria = new Categoria();
	private DAOGeneric<Categoria> daoGeneric = new DAOGeneric<Categoria>();
	private List<Categoria> listaCategoria = new ArrayList<Categoria>();
	
	public void salvar(Categoria categoria) {
		daoGeneric.salvar(categoria);
	}
	
	public List<Categoria> listarCategoria(){
		listaCategoria = daoGeneric.listaCategoria();
		return listaCategoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getListaCategoria() {
		return listaCategoria;
	}

	public void setListaCategoria(List<Categoria> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}
}
