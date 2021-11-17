package tn.esprit.spring.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;

import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;

@Service
public class MissionServiceImpl implements IMissionService {
	
	@Autowired
	MissionRepository missionRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	TimesheetRepository timesheetRepository;
	@Autowired
	EmployeRepository employeRepository;
	
	Logger logger = LoggerFactory.getLogger(MissionServiceImpl.class);
	
	public int ajouterMission(Mission mission) {
		logger.info("Adding  mission");
		try
		{
			
		missionRepository.save(mission);
		logger.info("Mission Added  Succefully !");
		} catch(Exception e) {
			logger.error(e.toString());
		}

		return mission.getId();
	}
    
	public void affecterMissionADepartement(int missionId, int depId) {
		if (Integer.toString(missionId).equals("")) {
			logger.warn("No mission to Add !");
		}
		else if (Integer.toString(depId).equals("")) {
			logger.warn("No Departement To Add mission to !");
		}else {
			
		try {
		logger.info("Adding Mission to Departement");		
		Optional<Mission> mission = missionRepository.findById(missionId);
		Optional<Departement> dep = deptRepoistory.findById(depId);
		if(mission.isPresent() && dep.isPresent())
		{
		Mission miss = mission.get();
		Departement depp = dep.get();
		miss.setDepartement(depp);
		missionRepository.save(miss);
		logger.info("Mission Added to departement  Succefully !");
		}}catch(Exception e) {
			logger.error(e.toString());
		}
		}
		
	}

	


	
	
	public List<Mission> findAllMissionByEmployeJPQL(int employeId) {
		List <Mission> missions = new ArrayList<>() ;
		if (Integer.toString(employeId).equals("")) {
			logger.warn("No employe found !");
		}
		else {
			try {
				logger.info("getting Mission by employé :" +employeId );
		missions = timesheetRepository.findAllMissionByEmployeJPQL(employeId);
		logger.info("getting Mission by employé :" +employeId +"succefully" );
		logger.info("getting Employee");
			}catch(Exception e) {
				logger.error(e.toString());
			}

	}
		return missions;
	}

	
	public List<Employe> getAllEmployeByMission(int missionId) {
		List <Employe> employes = new ArrayList<>() ;
		if (Integer.toString(missionId).equals("")) {
			logger.warn("No mission found !");
		}
		else {
			try {
				logger.info("getting employe by mission :" +missionId );
		employes= timesheetRepository.getAllEmployeByMission(missionId);
		logger.info("getting employe by mission :" +missionId +"succefully" );
			}catch(Exception e) {
				logger.error(e.toString());
			}

	}
		return employes;
		
	}

}
