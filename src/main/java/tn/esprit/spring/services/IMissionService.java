package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;

public interface IMissionService {
	public int ajouterMission(Mission mission);
	public void affecterMissionADepartement(int missionId, int depId);
	public List<Mission> findAllMissionByEmployeJPQL(int employeId);
	public List<Employe> getAllEmployeByMission(int missionId);

}
