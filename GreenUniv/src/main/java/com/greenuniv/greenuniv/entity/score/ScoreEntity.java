package com.greenuniv.greenuniv.entity.score;

import com.greenuniv.greenuniv.dto.score.ScoreDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import com.greenuniv.greenuniv.entity.lecture.LectureInfoEntity;
import com.greenuniv.greenuniv.entity.student.StudentEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Builder
@ToString
@Table(name = "score")
@AllArgsConstructor
@NoArgsConstructor
public class ScoreEntity implements BaseEntity {

  @Id
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "student_number")
  private StudentEntity student;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "lecture_id")
  private LectureInfoEntity lecture;

  @Column(name = "attend_score")
  private int attendScore;

  @Column(name = "mid_score")
  private int midScore;

  @Column(name = "final_score")
  private int finalScore;

  @Column(name = "etc_score")
  private int etcScore;

  @Column(name = "grade")
  private char grade;


  @Override
  public ScoreDTO toDTO() {
    return ScoreDTO.builder()
        .student(student.toDTO())
        .lecture(lecture.toDTO())
        .attendScore(attendScore)
        .midScore(midScore)
        .finalScore(finalScore)
        .etcScore(etcScore)
        .grade(grade)
        .build();
  }
}
