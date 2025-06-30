package com.greenuniv.greenuniv.entity.club;

import com.greenuniv.greenuniv.dto.club.StudentCouncilDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import com.greenuniv.greenuniv.entity.image.ImageEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "student_council")
@AllArgsConstructor
@NoArgsConstructor
public class StudentCouncilEntity implements BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "content")
  private String content;

  @Column(name = "url")
  private String url;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "image_id")
  private ImageEntity image;

  @Override
  public StudentCouncilDTO toDTO() {
    return StudentCouncilDTO.builder()
        .id(id)
        .name(name)
        .content(content)
        .url(url)
        .image(image.toDTO())
        .build();
  }
}
