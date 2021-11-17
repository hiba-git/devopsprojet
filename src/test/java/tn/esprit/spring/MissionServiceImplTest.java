package tn.esprit.spring;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.IMissionService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionServiceImplTest {
	@Autowired
	private IMissionService missionService ;
	
	int employeId =0;
	int missionId=0;
	int depId=0;
	int validateurId=0;
	Mission mission =new Mission("mamission","c ma mission");
	
	Date DateD = new Date(System.currentTimeMillis());
	Date DateF = new Date(System.currentTimeMillis());
	
	@Test
	 public void testajouterMission() {
		missionService.ajouterMission(mission);
	}
	
	@Test
	public void testaffecterMissionADepartement() {

		missionService.affecterMissionADepartement(missionId, depId);
	}
	
	@Test
	public void testfindAllMissionByEmployeJPQL() {
		missionService.findAllMissionByEmployeJPQL(employeId);
	}
	
	@Test
	public void testgetAllEmployeByMission() {
		missionService.getAllEmployeByMission(missionId);
	}

}
