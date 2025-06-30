package com.greenuniv.greenuniv.dto.club;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.dto.image.ImageDTO;
import com.greenuniv.greenuniv.entity.club.ClubEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClubDTO implements BaseDTO {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private String content;
  private String url;
  private ImageDTO image;

  @Override
  public ClubEntity toEntity() {
    return ClubEntity.builder()
        .id(id)
        .name(name)
        .content(content)
        .url(url)
        .image(image.toEntity())
        .build();
  }
}
