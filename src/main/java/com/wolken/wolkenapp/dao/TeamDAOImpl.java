package com.wolken.wolkenapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import com.wolken.wolkenapp.dto.TeamDTO;

@Component
public class TeamDAOImpl implements TeamDAO {
	@Autowired
	LocalSessionFactoryBean bean;
//	@Override
	// public String saveTeam(TeamDTO dto) {
	// TODO Auto-generated method stub
//		Configuration configuration = bean.getConfiguration();
//		configuration.configure();
//		SessionFactory factory = configuration.buildSessionFactory();
//		Session session = factory.openSession();
//		Transaction transaction = session.beginTransaction();
//		session.save(dto);
//		transaction.commit();
//		session.close();
//		BasicDataSource basicDataSource = new BasicDataSource();
//		basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		basicDataSource.setUrl("jdbc:mysql://localhost:3306/wolken");
//        basicDataSource.setUsername("root");
//        basicDataSource.setPassword("Leela12345$$");

	// return "data added";
	// }
//	@Override
//	public String deleteTeamByName(int  teamId) {
//		// TODO Auto-generated method stub
//		SessionFactory factory = bean.getObject();
//		Session session = factory.openSession();
//		Transaction transaction = session.beginTransaction();
//      Query query = session.getNamedQuery("delete");
//      query.setParameter("teamId", teamId );
//      query.executeUpdate();
//      transaction.commit();
//      session.close();
//      return "Team Deleted"; 
//        
//		
//	}
	@Override
	public String addTeam(TeamDTO dto) {
		// TODO Auto-generated method stub
		try {
			SessionFactory factory = bean.getObject();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(dto);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "Data Added";
	}

	@Override
	public String deleteTeamByName(String teamName) {
		// TODO Auto-generated method stub
		try {
			SessionFactory factory = bean.getObject();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			System.out.println("entering query");
			Query query = session.getNamedQuery("delete");
			System.out.println("out of named query");
			query.setParameter("teamName", teamName);
			System.out.println("out of setparam");
			query.executeUpdate();
			System.out.println("executeUpdate");
			transaction.commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "Team Deleted";
	}

	@Override
	public String updateCaptainByTeamName(String teamName, String captain) {
		// TODO Auto-generated method stub
		try {
			SessionFactory factory = bean.getObject();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Query query = session
					.createQuery("update TeamDTO dto set dto.captain = :captain where dto.teamName = :teamName");
			System.out.println("dao named query");
			query.setParameter("captain", captain);
			query.setParameter("teamName", teamName);

			query.executeUpdate();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "Data Updated";
	}

	@Override
	public List<TeamDTO> getAllTeams() {
		// TODO Auto-generated method stub
		System.out.println("inside dao");
		SessionFactory factory = bean.getObject();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.getNamedQuery("selectall");

		List<TeamDTO> teamslist = query.list();
		session.close();
		return teamslist;

		// TODO: handle exception

	}
}
