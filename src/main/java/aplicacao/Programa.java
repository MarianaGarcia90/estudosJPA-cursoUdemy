package aplicacao;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {

    public static void main (String[] args) {

        //Depois de já ter salvo no banco poderia apagar nesse caso
        //Pessoa p1 = new Pessoa(null, "Carlos Joaquim Silva", "cjsilva@gmail.com");
        //Pessoa p2 = new Pessoa(null, "Cassandra Joaquim Silva", "cassansilva@gmail.com");
        //Pessoa p3 = new Pessoa(null, "Domingos Pereira", "dominguera@gmail.com");

        //conexão com o banco
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplo-jpa"); //descrito no persistence.xml
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //inicia a transação com o banco - comentado pq foi usado na fase 1
        //entityManager.getTransaction().begin();

        //salva o objeto no BD - comentados pois já foram salvos
        //entityManager.persist(p1);
        //entityManager.persist(p2);
        //entityManager.persist(p3);

        //finaliza a transação com o banco - comentado pq foi usado na fase 1
        //entityManager.getTransaction().commit();

        //Numa segunda etapa, para pesquisar os dados do banco
        Pessoa pessoa = entityManager.find(Pessoa.class, 1);
        System.out.println(pessoa);

        //Para remover um objeto do banco
        Pessoa pessoaDeletada = entityManager.find(Pessoa.class, 2);
        //Sempre q não for consulta precisa coocar a transação
        entityManager.getTransaction().begin();
        entityManager.remove(pessoaDeletada);
        entityManager.getTransaction().commit();


        //fecha o entityManager dps de usa-lo
        entityManager.close();
        entityManagerFactory.close();

        //SOUT da primeira etapa, onde foram salvos os dados
        //System.out.println("Dados enviados!");

    }

}
