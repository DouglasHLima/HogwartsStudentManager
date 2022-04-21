package com.doughlima.hogwartsstudentmanager.mappers;

import com.doughlima.hogwartsstudentmanager.domain.Student;
import com.doughlima.hogwartsstudentmanager.dto.HouseInfoResponse;
import com.doughlima.hogwartsstudentmanager.dto.StudentCreateRequest;
import com.doughlima.hogwartsstudentmanager.dto.StudentCreateResponse;
import com.doughlima.hogwartsstudentmanager.dto.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(
        componentModel = "spring"
)
public interface StudentMapper {

    @Mapping(source = "house", target = "house")
    Student toDomain(StudentCreateRequest studentCreateRequest, UUID house);

    StudentCreateResponse toCreateResponse(Student student);

    @Mapping(source = "houseInfo", target = "house")
    @Mapping(source = "student.name", target = "name")
    StudentResponse toResponse(Student student, HouseInfoResponse houseInfo);
}
