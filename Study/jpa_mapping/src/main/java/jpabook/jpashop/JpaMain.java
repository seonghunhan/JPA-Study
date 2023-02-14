package jpabook.jpashop;

import jpabook.jpashop.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.lang.reflect.Member;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try{
            //일례로 오더한사람이 누군지 보려면 아래처럼했는데 객체지향적에 좀 어긋남
            // Order에서 멤버아디를찾고 또 멤버에서 멤버아디로 찾는 로직이잖아 이것보다는
            Order order = em.find(Order.class, 1L);
//            Long memberId = order.getMemberId();
//            Member member = em.find(Member.class, memberId);

            //오더에 member를 추가하고!
            //이게 좀더 객체지향코드임(오더에서 한방에 멤버아이디를쓰게끔)
//            Member findMember = order.getMember();
//            Long memberId = order.getMemberId();



            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally{
            em.close();
        }

        emf.close();

    }


}
