package com.greenuniv.greenuniv.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.greenuniv.greenuniv.dao.mapper.GenericMapper;
import com.greenuniv.greenuniv.dto.lecture.LectureDTO;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LectureServiceTest {

  @Autowired
  private GenericService<LectureDTO, String> service;

  @Autowired
  private GenericMapper<LectureDTO, String> mapper;

  @Test
  @DisplayName("강의 목록 조회 성공")
  void testSelectAllLectures_success() {
    List<LectureDTO> list = service.findAll();
    assertNotEquals(0, list.size());
  }

  @Test
  @DisplayName("강의 조회 성공")
  void testSelectLecture_success() {
    LectureDTO lecture = service.findById("304001");
    System.out.println(lecture);
    assertEquals("304001", lecture.getLectureInfo().getId());
  }
}
