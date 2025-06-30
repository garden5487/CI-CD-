package com.greenuniv.greenuniv.entity.student;

import com.greenuniv.greenuniv.dto.student.StudentDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import com.greenuniv.greenuniv.entity.department.DepartmentEntity;
import com.greenuniv.greenuniv.entity.image.ImageEntity;
import com.greenuniv.greenuniv.entity.professor.ProfessorEntity;
import com.greenuniv.greenuniv.entity.user.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.Year;
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
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity implements BaseEntity {

  @Id
  private String studentNumber;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private UserEntity user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "department_id")
  private DepartmentEntity department;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "image_id")
  private ImageEntity image;

  @Column(name = "grade")
  private int grade;

  @Column(name = "semester")
  private int semester;

  @Column(name = "current_credit")
  private int currentCredit;

  @Column(name = "graduation_credit")
  private int graduationCredit;

  @Column(name = "status")
  private String status;

  @Column(name = "entrance_type")
  private String entranceType;

  @Column(name = "entrance_year")
  private Year entranceYear;

  @Column(name = "entrance_grade")
  private int entranceGrade;

  @Column(name = "entrance_semester")
  private int entranceSemester;

  @Column(name = "graduation_year")
  private Year graduationYear;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "supvis_prof_id")
  private ProfessorEntity supervisorProfessor;

  @Override
  public StudentDTO toDTO() {
    return StudentDTO.builder()
        .studentNumber(studentNumber)
        .user(user.toDTO())
        .department(department.toDTO())
        .image(image.toDTO())
        .grade(grade)
        .semester(semester)
        .currentCredit(currentCredit)
        .graduationCredit(graduationCredit)
        .status(status)
        .entranceType(entranceType)
        .entranceYear(entranceYear)
        .entranceGrade(entranceGrade)
        .entranceSemester(entranceSemester)
        .graduationYear(graduationYear)
        .supervisorProfessor(supervisorProfessor.toDTO())
        .build();
  }

  public static class StudentEntityBuilder {

    public StudentEntity build() throws IllegalArgumentException {
      boolean isLegal = Arrays.asList(StudentDTO.STATUSES).contains(status);
      if (!isLegal) {
        throw new IllegalArgumentException("유효하지 않은 상태: " + status);
      }
      return new StudentEntity(studentNumber, user, department, image, grade, semester,
          currentCredit, graduationCredit,
          status, entranceType, entranceYear, entranceGrade, entranceSemester, graduationYear,
          supervisorProfessor);
    }
  }
}
