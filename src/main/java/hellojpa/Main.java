package hellojpa;

import hellojpa.entity.Member;
import hellojpa.entity.MemberType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {

		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			Member member = new Member();
			member.setName("홍길동");
			member.setAge(18);
			member.setMemberType(MemberType.USER);
			em.persist(member);

			Member member2 = new Member();
			member2.setName("정훈희");
			member2.setAge(40);
			member2.setMemberType(MemberType.ADMIN);
			em.persist(member2);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}

		emf.close();

	}
}
