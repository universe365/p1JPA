package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Model.member;

public class memberDao implements memberImpl{
	
	public static void main(String[] args) {
//		member m = new member("jcb","asd","12312","123123123","e@gm.com");
//		new memberDao().add(m);
		
//		new memberDao().queryId(5);
		
//		System.out.println(new memberDao().queryAll());
		
//		System.out.println(new memberDao().queryUser("123123", "12312") );
		
//		System.out.println(new memberDao().update("test1","testpass","1233211233","test@gmail.com", 11));
		
//		member m1 = (member) new memberDao().queryId(12);
//		m1.setName("test12");
//		m1.setUsername("test12user");
//		m1.setPassword("tt12");
//		System.out.println(new memberDao().update(m1));
		
		System.out.println(new memberDao().delete(13));
		
	}

	@Override
	public void add(Object o) {
		EntityManager em = Conn.getDB();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(o);
		System.out.println("add success");
		t.commit();
		em.close();
	}

	@Override
	public List<Object> queryAll() {
		EntityManager em = Conn.getDB();
		EntityTransaction t = em.getTransaction();
		Query query=em.createQuery("from member");
		List<Object> list = null;
		
		list = query.getResultList();
		
		return list;
	}
	
	@Override
	public List<Object> queryUser(String user, String pass){
		List<Object> list=null;
		EntityManager em = Conn.getDB();
		EntityTransaction t = em.getTransaction();
		Query jpql = em.createQuery("from member where username like ?0 and password like ?1");
		
		list = jpql.setParameter(0, user).setParameter(1, pass).getResultList();
		
		return list;
	}

	@Override
	public Object queryId(int id) {
		EntityManager em = Conn.getDB();
		EntityTransaction t = em.getTransaction();
		t.begin();
		member m = em.find(member.class, id) ;
		if(m!=null) {
			System.out.println(m.getClass().getName()+" Name:"+m.getName());
		}
		t.commit();
		em.close();
		
		return m;
	}

	
	
	@Override
	public boolean update(String username, String password, String phone, String email, int id) {
		EntityManager em = Conn.getDB();
		EntityTransaction t = em.getTransaction();
		boolean status=false;
		
		member m = (member) new memberDao().queryId(id);
		
		if(m !=null) {
			m.setUsername(username);
			m.setPassword(password);
			m.setPhone(phone);
			m.setEmail(email);
			
			t.begin();
			
			em.merge(m);
			
			t.commit();
			em.close();
			
			status=true;
			
		}else {
			status=false;
		}
		
		return status;
	}
	
	@Override
	public boolean update(Object o) {
		EntityManager em = Conn.getDB();
		EntityTransaction t = em.getTransaction();
		boolean status = false;
		member m = (member) o;
		
		if(m!=null) {
			t.begin();
			
			em.merge(m);
			
			t.commit();
			em.close();
			
			status=true;
		}
		
		return status;
	}

	@Override
	public boolean delete(int id) {
		EntityManager em = Conn.getDB();
		EntityTransaction t = em.getTransaction();
		
		t.begin();
		
		boolean status=false;
		member m = em.find(member.class, id);
		
		if(m!=null) {
			em.remove(m);
			status=true;
		}

		t.commit();
		em.close();
		
		return status;
	}

}
