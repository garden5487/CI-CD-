package com.greenuniv.greenuniv.dto.score;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.dto.lecture.LectureInfoDTO;
import com.greenuniv.greenuniv.dto.student.StudentDTO;
import com.greenuniv.greenuniv.entity.score.ScoreEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScoreDTO implements BaseDTO {

  private StudentDTO student;
  private LectureInfoDTO lecture;
  private int attendScore;
  private int midScore;
  private int finalScore;
  private int etcScore;
  private char grade;

  @Override
  public ScoreEntity toEntity() {
    return ScoreEntity.builder()
        .student(student.toEntity())
        .lecture(lecture.toEntity())
        .attendScore(attendScore)
        .midScore(midScore)
        .finalScore(finalScore)
        .etcScore(etcScore)
        .grade(grade)
        .build();
  }
}
