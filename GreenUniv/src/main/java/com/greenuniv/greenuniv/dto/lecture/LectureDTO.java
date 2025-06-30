package com.greenuniv.greenuniv.dto.lecture;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.entity.lecture.LectureEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LectureDTO implements BaseDTO {

  private LectureInfoDTO lectureInfo;
  private LectureDayDTO lectureDay;
  private LectureTimeDTO lectureTime;

  @Override
  public LectureEntity toEntity() {
    return LectureEntity.builder()
        .lectureInfo(lectureInfo.toEntity())
        .lectureDay(lectureDay.toEntity())
        .build();
  }
}
