package a03_EntityMapping;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class entityMappingMain {
    public static void main(String[] args) {
        // 이게 DB당 1개
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        
        // 에니티매니저를 통해서 작업가능
        EntityManager em = emf.createEntityManager();
        
        // DB의 모든 Data변경은 트랜젝션 안에서 일어난다
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            // 처음실행할때 persistence.xml에서 옵션을 CREATE로했는데 동작원리가 드랍후 생성임 그니까
            // 추가하고싶으면 CREATE를 UPDATE로 바꾸고 해주기!
            Member member = new Member();
            member.setId(2L);
            member.setUsername("B");
            member.setRoleType(RoleType.ADMIN);

            em.persist(member);


// commit해야 DB로 날라감
            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally {
            // 꼭 닫아줘야함
            em.close();
        }

    // 이걸 닫아야 최종적으로 릴리스하고 그런다
    emf.close();
    }
}
