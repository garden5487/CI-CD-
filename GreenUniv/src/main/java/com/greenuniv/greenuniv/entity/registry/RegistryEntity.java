package com.greenuniv.greenuniv.entity.registry;

import com.greenuniv.greenuniv.dto.registry.RegistryDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import com.greenuniv.greenuniv.entity.student.StudentEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.Year;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@Builder
@ToString
@Table(name = "registry")
@AllArgsConstructor
@NoArgsConstructor
public class RegistryEntity implements BaseEntity {

  @Id
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "student_number")
  private StudentEntity student;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "registry_lecture_id")
  private RegistryLectureEntity registryLecture;

  @Column(name = "current_year")
  private Year currentYear;

  @Column(name = "register_date")
  @CreationTimestamp
  private LocalDate registerDate;

  @Override
  public RegistryDTO toDTO() {
    return RegistryDTO.builder()
        .student(student.toDTO())
        .registryLecture(registryLecture.toDTO())
        .currentYear(currentYear)
        .registerDate(registerDate)
        .build();
  }
}
