package com.greenuniv.greenuniv.dto.file;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.dto.article.ArticleDTO;
import com.greenuniv.greenuniv.entity.file.FileEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileDTO implements BaseDTO {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private ArticleDTO article;
  private String location;

  @Override
  public FileEntity toEntity() {
    return FileEntity.builder()
        .id(id)
        .article(article.toEntity())
        .location(location)
        .build();
  }
}
