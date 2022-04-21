package com.doughlima.hogwartsstudentmanager.service;

import com.doughlima.hogwartsstudentmanager.clients.HouseInfoClient;
import com.doughlima.hogwartsstudentmanager.domain.Student;
import com.doughlima.hogwartsstudentmanager.dto.StudentResponse;
import com.doughlima.hogwartsstudentmanager.mappers.StudentMapper;
import com.doughlima.hogwartsstudentmanager.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @___(@Autowired))
public class SearchStudentService {

    private final HouseInfoClient houseInfoClient;
    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;

    public StudentResponse execute(UUID id) {
        Student student = studentRepository.findById(id).orElseThrow();
        return studentMapper.toResponse(student,houseInfoClient.execute(student.getHouse()));
    }
}
