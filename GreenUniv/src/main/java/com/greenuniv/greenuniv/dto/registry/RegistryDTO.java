package com.greenuniv.greenuniv.dto.registry;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.dto.student.StudentDTO;
import com.greenuniv.greenuniv.entity.registry.RegistryEntity;
import java.time.LocalDate;
import java.time.Year;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistryDTO implements BaseDTO {

  private StudentDTO student;
  private RegistryLectureDTO registryLecture;
  private Year currentYear;
  @CreationTimestamp
  private LocalDate registerDate;

  @Override
  public RegistryEntity toEntity() {
    return RegistryEntity.builder()
        .student(student.toEntity())
        .registryLecture(registryLecture.toEntity())
        .currentYear(currentYear)
        .registerDate(registerDate)
        .build();
  }
}
