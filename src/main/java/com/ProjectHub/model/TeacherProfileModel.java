package com.ProjectHub.model;

import com.ProjectHub.entities.TeacherProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherProfileModel {
    private String employeeID;
    private String firstName;
    private String lastName;
    private String department;
    private String emailId;
    private List<ProjectProfileModel> closedProjects;

    public TeacherProfileModel(TeacherProfile teacherProfile, List<ProjectProfileModel> projectProfileModel) {
        setEmployeeID(teacherProfile.getEmployeeID());
        setFirstName(teacherProfile.getFirstName());
        setLastName(teacherProfile.getLastName());
        setDepartment(teacherProfile.getDepartment());
        setEmailId(teacherProfile.getEmailId());
        setClosedProjects(projectProfileModel);
    }
}