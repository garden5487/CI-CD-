package com.greenuniv.greenuniv.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.greenuniv.greenuniv.dto.student.StudentDTO;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentServiceTest {

  @Autowired
  private GenericService<StudentDTO, String> service;

  @Nested
  @DisplayName("조회")
  class Select {

    @Test
    @DisplayName("학생 조회 성공")
    void testSelectByStudentNumber_success() {
      StudentDTO student = service.findById("20250003");
      assertNotNull(student);
      assertEquals("20250003", student.getStudentNumber());
      assertEquals("김민지", student.getUser().getName());
      assertEquals("010203-9875641", student.getUser().getSocialNumber());
      assertEquals("010-2222-1232", student.getUser().getContact());
      assertEquals("kmj123@example.com", student.getUser().getEmail());
      assertEquals("사회교육과", student.getDepartment().getName());
      assertEquals(1, student.getGrade());
      assertEquals(1, student.getSemester());
      assertEquals(0, student.getCurrentCredit());
      assertEquals(130, student.getGraduationCredit());
      assertEquals(StudentDTO.STATUS_BREAK, student.getStatus());
    }

    @Test
    @DisplayName("학생 리스트 조회 성공")
    void testSelectAllStudents_success() {
      List<StudentDTO> students = service.findAll();
      assertNotEquals(0, students.size());
    }
  }

}
