package com.wolken.wolkenapp.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wolken.wolkenapp.dao.TeamDAO;
import com.wolken.wolkenapp.dto.TeamDTO;

@Component
public class TeamServiceImpl implements TeamService {
 @Autowired
 TeamDAO dao;
	
	@Override
	public String validateAndAdd(TeamDTO dto) {
		// TODO Auto-generated method stub
		if(dto != null) {
			if(dto.getTeamId() > 0 && dto.getTeamId() <1000) {
				if(dto.getCaptain() != null ) {
					if(dto.getTeamName() != null) {
						if(dto.getHomeGround() != null) {
							 dao.addTeam(dto);
							 return "Team Added";
						}
					}
					
				}
			}
		}
		return "failed";
	}

	@Override
	public String validateAndDeleteByName(String teamName) {
		// TODO Auto-generated method stub
		if(teamName != null && teamName.length() <100 ) {
			System.out.println("valid team name");
			 dao.deleteTeamByName(teamName);
			 return "Deleted Successfully";
			
		}
		return "Failed to delete";
	}

	@Override
	public String validateAndUpdateCaptainByTeamName(String captain, String teamName) {
		// TODO Auto-generated method stub
		if(teamName != null && teamName.length() < 100) {
			System.out.println("teamName passed");
			if(captain != null && captain.length() < 100) {
				System.out.println("captain");
				 dao.updateCaptainByTeamName(teamName, captain);
				 return "Successfully updated";
			}
		}
		
		return "Failed to update";
	}

	@Override
	public List<TeamDTO> getAllValues() {
		// TODO Auto-generated method stub
        return  dao.getAllTeams();
		
		
	}

}
