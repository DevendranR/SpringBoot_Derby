package com.dev.service.projects;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProjectService {
	@Autowired
	ProjectRepository projectRepository;
	public List<Projects> fetchAllProjects() {
		// TODO Auto-generated method stub
		List<Projects> retList = new ArrayList<Projects>();
		Iterable<ProjectsEntity> val = projectRepository.findAll();
		for (ProjectsEntity projects : val) {
			Projects p = new Projects();
			p.setProjectId(projects.getProjectId());
			p.setProjectName(projects.getProjectName());
			retList.add(p);
		}
		return retList;
	}
	public void persistProject(){
		ProjectsEntity p1 = new ProjectsEntity();
		p1.setProjectId("Project1");
		p1.setProjectName("IOS");
		projectRepository.save(p1);
		ProjectsEntity p2 = new ProjectsEntity();
		p2.setProjectId("Project2");
		p2.setProjectName("Windows");
		projectRepository.save(p2);
		
	}

}
