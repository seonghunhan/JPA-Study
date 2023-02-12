package a01_helloJPA;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        // 이게 DB당 1개
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        
        // 에니티매니저를 통해서 작업가능
        EntityManager em = emf.createEntityManager();
        
        // DB의 모든 Data변경은 트랜젝션 안에서 일어난다
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();

        try{
            //code


// JPQL 연습 -> 여기서 쿼리안에 들가는 Member는 Table이 아니고 엔티티 객체에 맵핑하는거임!!!!
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5)
//                    .setMaxResults(0)
//                    .getResultList();
//
//            System.out.println("result = " + result);

//Update
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");

//Delete
//              em.remove() ;

//Select
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember = " + findMember.getId());
//            System.out.println("findMember = " + findMember.getName());

//Insert
            Member member = new Member();
            member.setId(210L);
            member.setName("abc");
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
