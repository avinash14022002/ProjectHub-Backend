package com.ProjectHub.service;

import com.ProjectHub.entities.StudentProfile;
import com.ProjectHub.entities.TeacherProfile;
import com.ProjectHub.model.ChangePasswordModel;
import com.ProjectHub.repository.TeacherRepository;
import com.ProjectHub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TeacherRepository teacherRepository;

    private boolean updateStudentPassword(String studentId, String newPassword, String oldPassword) {
        StudentProfile studentProfile = userRepository.findByUsername(studentId).get();
        if (Objects.equals(studentProfile.getPassword(), oldPassword)) {
            studentProfile.setPassword(newPassword);
            userRepository.save(studentProfile);
            return true;
        }
        return false;
    }

    private boolean updateTeacherPassword(String teacherId, String newPassword, String oldPassword) {
        TeacherProfile teacherProfile = teacherRepository.findById(teacherId).get();
        if (Objects.equals(teacherProfile.getPassword(), oldPassword)) {
            teacherProfile.setPassword(newPassword);
            teacherRepository.save(teacherProfile);
            return true;
        }
        return false;
    }

    public boolean changePassword(ChangePasswordModel model) {
        if (Objects.equals(model.getUserType(), "student")) {
            return updateStudentPassword(model.getId(), model.getNewPassword(), model.getOldPassword());
        } else if (Objects.equals(model.getUserType(), "teacher")) {
            return updateTeacherPassword(model.getId(), model.getNewPassword(), model.getOldPassword());
        }
        return false;
    }
}
