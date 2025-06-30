package com.greenuniv.greenuniv.entity.lecture;

/*
 * 작성자: id3ntity99(이현민)
 * 설명 : 강의시간 엔티티.
 */

import com.greenuniv.greenuniv.dto.lecture.LectureDayDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@Builder
@Table(name = "lecture_day")
@AllArgsConstructor
@NoArgsConstructor
public class LectureDayEntity implements BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "day")
  private String day;

  @Override
  public LectureDayDTO toDTO() {
    return LectureDayDTO
        .builder()
        .id(id)
        .day(day)
        .build();
  }

  public static class LectureDayEntityBuilder {

    public LectureDayEntity build() throws IllegalArgumentException {
      boolean isLegal = Arrays.asList(LectureDayDTO.WEEK_DAYS).contains(day);
      if (!isLegal) {
        throw new IllegalArgumentException("유효하지 않은 요일: " + day);
      }
      return new LectureDayEntity(id, day);
    }
  }
}
