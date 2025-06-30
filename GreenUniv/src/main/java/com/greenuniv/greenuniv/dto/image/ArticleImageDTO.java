package com.greenuniv.greenuniv.dto.image;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.dto.article.ArticleDTO;
import com.greenuniv.greenuniv.entity.image.ArticleImageEntity;
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
public class ArticleImageDTO implements BaseDTO {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private ArticleDTO article;
  private String location;
  private String thumbnailLocation;

  @Override
  public ArticleImageEntity toEntity() {
    return ArticleImageEntity.builder()
        .id(id)
        .location(location)
        .thumbnailLocation(thumbnailLocation)
        .build();
  }
}
