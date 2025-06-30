package com.greenuniv.greenuniv.entity.professor;

import com.greenuniv.greenuniv.dto.professor.ProfessorDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import com.greenuniv.greenuniv.entity.department.DepartmentEntity;
import com.greenuniv.greenuniv.entity.user.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Builder
@ToString
@Table(name = "professor")
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorEntity implements BaseEntity {

  @Id
  private String id;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private UserEntity user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "department_id")
  private DepartmentEntity department;

  @Column(name = "graduated_from")
  private String graduatedFrom;

  @Column(name = "graduated_at")
  private LocalDate graduatedAt;

  @Column(name = "major")
  private String major;

  @Column(name = "degree")
  private String degree;

  @Column(name = "employed_at")
  private LocalDate employedAt;

  @Column(name = "status")
  private String status;

  @Column(name = "position")
  private String position;

  @Column(name = "is_chief")
  private boolean isChief;


  @Override
  public ProfessorDTO toDTO() {
    return ProfessorDTO.builder()
        .id(id)
        .user(user.toDTO())
        .department(department.toDTO())
        .graduatedAt(graduatedAt)
        .graduatedFrom(graduatedFrom)
        .major(major)
        .degree(degree)
        .employedAt(employedAt)
        .status(status)
        .position(position)
        .isChief(isChief)
        .build();
  }

  public static class ProfessorEntityBuilder {

    public ProfessorEntity build() throws IllegalArgumentException {
      boolean isDegreeLegal = Arrays.asList(ProfessorDTO.DEGREES).contains(degree);
      boolean isStatusLegal = Arrays.asList(ProfessorDTO.STATUSES).contains(status);
      boolean isPositionLegal = Arrays.asList(ProfessorDTO.POSITIONS).contains(position);

      if (!isDegreeLegal) {
        throw new IllegalArgumentException("유효하지 않은 교수 학위: " + degree);
      } else if (!isStatusLegal) {
        throw new IllegalArgumentException("유효하지 않은 교수 상태 : " + status);
      } else if (!isPositionLegal) {
        throw new IllegalArgumentException("유효하지 않은 교수 직위: " + position);
      }
      return new ProfessorEntity(id, user, department, graduatedFrom, graduatedAt, major, degree,
          employedAt, status, position, isChief);
    }
  }
}
