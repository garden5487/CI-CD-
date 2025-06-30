package com.greenuniv.greenuniv.dto.lecture;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.entity.lecture.LectureTimeEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LectureTimeDTO implements BaseDTO {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private LectureInfoDTO lecture;
  private LocalTime startAt;
  private LocalTime endAt;


  @Override
  public LectureTimeEntity toEntity() {
    return LectureTimeEntity.builder()
        .id(id)
        .startAt(startAt)
        .endAt(endAt)
        .build();
  }
}
