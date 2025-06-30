package com.greenuniv.greenuniv.entity.department;

import com.greenuniv.greenuniv.dto.department.CollegeDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import com.greenuniv.greenuniv.entity.image.ImageEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "college")
@AllArgsConstructor
@NoArgsConstructor
public class CollegeEntity implements BaseEntity {

  @Id
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "eng_name")
  private String engName;

  @Column(name = "description")
  private String description;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "image_id")
  private ImageEntity image;

  @Override
  public CollegeDTO toDTO() {
    return CollegeDTO.builder()
        .id(id)
        .name(name)
        .engName(engName)
        .description(description)
        .image(image.toDTO())
        .build();
  }
}
