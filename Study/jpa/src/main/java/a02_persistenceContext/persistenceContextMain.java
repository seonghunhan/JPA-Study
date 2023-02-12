package a02_persistenceContext;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class persistenceContextMain {
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





//            Member member = new Member(200L, "member200");
//            em.persist(member);
//            // 플러시 직접 호출 -> 커밋하기전에 그냥 바로 DB에 쿼리 날려보냄
//            em.flush();





//            Member memberA = em.find(Member.class, "memberA");
//            em.remove(memberA); // 엔티티 삭제




//            // detach으로 인해 영속상태에서 준영속상태로 만듬(DB반영안됨)
//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAAAA");
//            em.detach(member);




            // 찾고 데이터 변경 -> 객체만 바꿨는데 데이터가 바뀌네? persist없이?
            // -> pdf03의 엔티티 수정(변경 감지)참고
            // -> 마법같은거임
            // -> 커밋하는시점에 내부적으로 flush()후에 엔티티와 스냅샷을 비교함
            // -> entity랑 스냅샷을 비교하고 바뀐게 있으면 내부적으로 Update sql을 생성하고 db에 보냄
//            Member member = em.find(Member.class, 150L);
//            member.setName("CCCCCCCC");






//영속 (인서트)
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");

//            // 영속 컨텍스트에 차곡차곡 샇임 !!밑에 commit에서 최종적으로 SQL날림
//            em.persist(member1);
//            em.persist(member2);
//
//            System.out.println("==================");







//            // 비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            //영속
//            System.out.println(" ==========BEFORE ======");
//            em.persist(member);
//            System.out.println("==========AFTER========");

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
