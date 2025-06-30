package com.greenuniv.greenuniv.entity.lecture;

import com.greenuniv.greenuniv.dto.lecture.LectureTimeDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Builder
@ToString
@Table(name = "lecture_time")
@AllArgsConstructor
@NoArgsConstructor
public class LectureTimeEntity implements BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "start_at")
  private LocalTime startAt;

  @Column(name = "start_end")
  private LocalTime endAt;

  @Override
  public LectureTimeDTO toDTO() {
    return LectureTimeDTO.builder()
        .id(id)
        .startAt(startAt)
        .endAt(endAt)
        .build();
  }
}
