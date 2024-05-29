package br.ufrj.hucff.controleestoque.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.ufrj.hucff.controleestoque.DAO.DAOGeneric;
import br.ufrj.hucff.controleestoque.modelo.ItemEstoque;

@ViewScoped
@ManagedBean(name = "ItemEstoqueBean")
public class ItemEstoqueBean {
	
	private DAOGeneric<ItemEstoque> daoGeneric = new DAOGeneric<ItemEstoque>();
	private List<ItemEstoque> listaItemEstoque = new ArrayList<ItemEstoque>();
	
	public void salvar(ItemEstoque itemEstoque) {
		daoGeneric.salvar(itemEstoque);
	}
	
	public List<ItemEstoque> listarItemEstoque(){
		listaItemEstoque = daoGeneric.listaItemEstoque();
		return listaItemEstoque;
	}

	public List<ItemEstoque> getListaItemEstoque() {
		return listaItemEstoque;
	}

	public void setListaItemEstoque(List<ItemEstoque> listaItemEstoque) {
		this.listaItemEstoque = listaItemEstoque;
	}
}
