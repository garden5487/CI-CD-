package com.greenuniv.greenuniv.entity.image;

import com.greenuniv.greenuniv.dto.image.ImageDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "image")
@AllArgsConstructor
@NoArgsConstructor
public class ImageEntity implements BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "location")
  private String location;

  @Column(name = "thumbnail_location")
  private String thumbnailLocation;

  @Override
  public ImageDTO toDTO() {
    return ImageDTO.builder()
        .id(id)
        .location(location)
        .thumbnailLocation(thumbnailLocation)
        .build();
  }
}
