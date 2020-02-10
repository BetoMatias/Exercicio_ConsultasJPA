package consultasjpa;
import java.util.List;
/**
 *
 * @author beto
 */
public class ClasseTeste {
    public static void main(String[] args) throws Exception{
    VendaDAO dao = new VendaDAO();

    Cliente c = new Cliente();
        c.setCpf("111.111.111.11");
        c.setId(8L);
        c.setNome("Cleide");
    
    Produto p = new Produto();
        p.setId(7L);
        p.setDescricao("Flores");
        p.setPreco(5.50);
    
     Venda v = new Venda();
        v.setId(12L);
        v.setCliente(c);
        v.setProduto(p);
        v.setQuantidade(5L);
         
      Produto produto = dao.salvarProduto(p);
        System.out.println(produto.getDescricao());    
      Cliente cliente = dao.salvarCliente(c); 
        System.out.println(cliente.getNome());
      dao.salvarVenda(v);
     
        
        System.out.println("\n CLIENTE, PRODUTO E VENDA SALVOS \n \n");
        
        System.out.println("Consulta de vendas.");
      Venda vendatst = dao.consultarVenda(12L);
      Cliente stringCliente = vendatst.getCliente();
      Produto stringProduto = vendatst.getProduto();
        System.out.println("\n Cliente = " +  stringCliente.getNome() + "\n Produto = " + stringProduto.getDescricao() + "\n Quantidade = " + vendatst.getQuantidade());
     
        System.out.println("\n Listar venda por cliente");  
        List<Venda> vendas;
      vendas = dao.consultarVendaCliente(8L);
      for(Venda ven :vendas){
        System.out.println(ven.getProduto().getDescricao());
      }       
      vendas= dao.consultarVendaProduto(7L);
      for(Venda ven :vendas){
        System.out.println(ven.getCliente().getNome());
      } 
      
      vendas = dao.consultarTodas();
      for(Venda ven :vendas){
        System.out.println("Cliente - " + ven.getCliente().getNome() + " - Produto " + ven.getProduto().getDescricao()+ " - Quantidade " + ven.getQuantidade());
      }
//        dao.apagarCliente(10L);
//        dao.apagarProduto(11L);
//        dao.apagarVenda(9L);
    }    
}
