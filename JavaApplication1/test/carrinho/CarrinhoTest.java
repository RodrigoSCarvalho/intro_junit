package carrinho;

import junit.framework.Assert;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {
    Carrinho car;
	Produto pao;
	Produto queijo;
	Produto manteiga;
	Produto poDeCafe;
	Produto leite;

    public CarrinhoTest() {
    }

    @Before
    public void inicializa() {
        this.pao = new Produto("Pao de Sal", 4.00);
        this.queijo = new Produto("Queijo Minas", 3.50);
        this.manteiga = new Produto("Manteiga com Sal", 6.00);
        this.poDeCafe = new Produto("Cafe extra forte", 8.00);
        this.leite = new Produto("Leite em po", 8.00);
        this.car = new Carrinho();
        this.car.addItem(this.pao);
        this.car.addItem(this.queijo);
        this.car.addItem(this.manteiga);
        this.car.addItem(this.poDeCafe);
    }

    @DisplayName("Testa o valor total")
    @Test
    public void testValorTotal(){
    	assertEquals(21.50, this.car.getValorTotal(), 0.02);
    	
    }
    
    @DisplayName("Testa a quantidade de itens")
    @Test
    public void testQuantidade() {
        assertEquals(4, this.car.getQtdeItems());
    }
    
    @DisplayName("Testa a adição de itens")
    @Test
    public void testAddItens() {
    	this.car.addItem(leite);
        assertEquals(5, this.car.getQtdeItems());
    }
    
    @DisplayName("Testa a remoção de item")
    @Test
    public void testRemoveItem(){
    	try { 
			this.car.removeItem(leite);
		} catch (ProdutoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	assertEquals(4, this.car.getQtdeItems());
    	
    }
    
    @DisplayName("Testa esvaziar carrinho")
    @Test
    public void testEsvaziarCarrinho() {
    	this.car.esvazia();
        assertEquals(0, this.car.getQtdeItems());
    }

	

}
