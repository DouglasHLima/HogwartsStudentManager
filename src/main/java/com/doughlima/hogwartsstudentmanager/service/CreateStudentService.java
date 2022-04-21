package com.doughlima.hogwartsstudentmanager.service;

import com.doughlima.hogwartsstudentmanager.clients.HouseSortingHatClient;
import com.doughlima.hogwartsstudentmanager.domain.Student;
import com.doughlima.hogwartsstudentmanager.dto.StudentCreateRequest;
import com.doughlima.hogwartsstudentmanager.dto.StudentCreateResponse;
import com.doughlima.hogwartsstudentmanager.mappers.StudentMapper;
import com.doughlima.hogwartsstudentmanager.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @___(@Autowired))
public class CreateStudentService {

    private final HouseSortingHatClient houseSortingHatClient;
    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;

    public StudentCreateResponse execute(StudentCreateRequest studentCreateRequest) {
        Student student = studentMapper.toDomain(studentCreateRequest, houseSortingHatClient.execute().getSortingHatChoice());
        return studentMapper.toCreateResponse(studentRepository.save(student));
    }
}
