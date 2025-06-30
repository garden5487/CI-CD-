package com.greenuniv.greenuniv.dao.mapper;

import com.greenuniv.greenuniv.dto.student.StudentDTO;

public interface StudentMapper extends GenericMapper<StudentDTO, String> {

  StudentDTO selectById(String studentNumber);
}
