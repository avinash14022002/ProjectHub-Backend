package com.ProjectHub.controller;

import com.ProjectHub.model.StudentProfileModel;
import com.ProjectHub.repository.ProjectRepository;
import com.ProjectHub.entities.Project;
import com.ProjectHub.service.StudentProfileService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.ProjectHub.util.Constants.BEARER_AUTH;

/**
 * Created by Avinash Vijayvargiya on 22-09-2021.
 */

@RestController
//@SecurityRequirement(name = BEARER_AUTH)
@RequestMapping("/api")
public class StudentController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    StudentProfileService studentProfileService;

    /**
     * @param id
     * @return
     */
    @GetMapping("/studentProject")
    public ResponseEntity<List<Project>> getAllProjects(@RequestParam(required = false) Long id) {
        try {
            List<Project> tutorials = new ArrayList<>();

            if (id == null)
                tutorials.addAll(projectRepository.findAll());
            else
                tutorials.addAll(projectRepository.getProjectByProjectId(id));

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @param project
     * @return
     */
    @PostMapping("/studentProject")
    public ResponseEntity<Project> getDetailedProject(@RequestBody Project project) {
        try {
            Project _project = projectRepository
                    .save(new Project(project.getProjectTitle(), project.getProjectDomain(), project.getDescription(), project.getProjectTag1(), project.getProjectTag2(), project.getProjectTag3(), project.getImageUrl(), project.getPptUrl(), project.getPaperUrl(),"0"));
            return new ResponseEntity<>(_project, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/studentProfileDetails")
    public ResponseEntity<StudentProfileModel> getStudentProfile(@RequestParam String username){
        return ResponseEntity.ok(studentProfileService.getStudentProfileByUsername(username));
    }
}