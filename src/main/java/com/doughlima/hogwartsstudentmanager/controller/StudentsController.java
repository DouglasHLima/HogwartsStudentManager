package com.doughlima.hogwartsstudentmanager.controller;

import com.doughlima.hogwartsstudentmanager.dto.StudentCreateRequest;
import com.doughlima.hogwartsstudentmanager.dto.StudentCreateResponse;
import com.doughlima.hogwartsstudentmanager.dto.StudentResponse;
import com.doughlima.hogwartsstudentmanager.service.CreateStudentService;
import com.doughlima.hogwartsstudentmanager.service.SearchStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(
        path = "api/v1/students",
        produces = MediaType.APPLICATION_JSON_VALUE
)
@RequiredArgsConstructor
public class StudentsController {

    private final CreateStudentService createStudentService;
    private final SearchStudentService searchStudentService;

    @PostMapping
    public ResponseEntity<StudentCreateResponse> createStudent(
            @Valid @RequestBody StudentCreateRequest studentCreateRequest
    ) {
        StudentCreateResponse saved = createStudentService.execute(studentCreateRequest);
        return ResponseEntity.created(
                linkTo(methodOn(StudentsController.class).getStudent(saved.getId())).withSelfRel().toUri()
        ).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudent(@PathVariable(value = "id") UUID id){
        return ResponseEntity.ok(searchStudentService.execute(id));
    }

}
