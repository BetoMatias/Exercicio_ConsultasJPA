/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultasjpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author beto
 */
public class VendaDAO {

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = null;
        EntityManager em = null;
        try {
            factory = Persistence.createEntityManagerFactory("ConsultasJPAPU");
            em = factory.createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return em;
    }

    public Venda salvarVenda(Venda venda) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            System.out.println("Salvando venda.");
            if (venda.getId() == null) {
                em.persist(venda);
            } else {
                venda = em.merge(venda);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return venda;
    }

    public Cliente salvarCliente(Cliente cliente) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            System.out.println("Salvando Cliente.");
            if (cliente.getId() == null) {
                em.persist(cliente);
            } else {
                cliente = em.merge(cliente);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return cliente;
    }

    public Produto salvarProduto(Produto produto) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            System.out.println("Salvando Cliente.");
            if (produto.getId() == null) {
                em.persist(produto);
            } else {
                produto = em.merge(produto);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return produto;
    }

    public void apagarCliente(Long id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Cliente cliente = em.find(Cliente.class, id);
            System.out.println("Excluindo...");
            em.remove(cliente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void apagarProduto(Long id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Produto produto = em.find(Produto.class, id);
            System.out.println("Excluindo...");
            em.remove(produto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void apagarVenda(Long id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Venda venda = em.find(Venda.class, id);
            System.out.println("Excluindo...");
            em.remove(venda);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public List<Venda> consultarVendaCliente(Long clienteId) {
        EntityManager em = getEntityManager();
        List<Venda> venda = null;
        try {
            Query query = em.createNamedQuery("Venda.consultarPorCliente");
            query.setParameter("cliente", clienteId);
            venda = query.getResultList();
            return venda;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return venda;
    }
    
    public List<Venda> consultarVendaProduto(Long produtoId) {
        EntityManager em = getEntityManager();
        List<Venda> venda = null;
        try {
            Query query = em.createNamedQuery("Venda.consultarPorProduto");
            query.setParameter("produto", produtoId);
            venda = query.getResultList();
            return venda;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return venda;
    }
    
    public Venda consultarVenda(Long vendaId) {
        EntityManager em = getEntityManager();
        Venda venda = null;
        try {
            Query query = em.createNamedQuery("Venda.consultarVenda");
            query.setParameter("id", vendaId);
            venda = (Venda) query.getSingleResult();
            return venda;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return venda;
    }
    
    public List<Venda> consultarTodas(){
        EntityManager em = getEntityManager();
        List<Venda> venda = null;
        try{
            Query query  = em.createNamedQuery("Venda.consultar");
            venda = (List<Venda>)query.getResultList();
           }catch(Exception e){
               venda = new ArrayList();
           }finally{
            em.close();
        }
        return venda;
    }
        
}

