package com.greenuniv.greenuniv.entity.club;

import com.greenuniv.greenuniv.dto.club.ClubDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import com.greenuniv.greenuniv.entity.image.ImageEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "club")
@AllArgsConstructor
@NoArgsConstructor
public class ClubEntity implements BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "content")
  private String content;

  @Column(name = "url")
  private String url;

  @OneToOne
  @JoinColumn(name = "image_id")
  private ImageEntity image;

  @Override
  public ClubDTO toDTO() {
    return ClubDTO.builder()
        .id(id)
        .name(name)
        .content(content)
        .url(url)
        .image(image.toDTO())
        .build();
  }
}
