package com.greenuniv.greenuniv.entity.file;

import com.greenuniv.greenuniv.dto.file.FileDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import com.greenuniv.greenuniv.entity.article.ArticleEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "file")
@AllArgsConstructor
@NoArgsConstructor
public class FileEntity implements BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "article_id")
  private ArticleEntity article;

  @Column(name = "location")
  private String location;

  @Override
  public FileDTO toDTO() {
    return FileDTO.builder()
        .id(id)
        .article(article.toDTO())
        .location(location)
        .build();
  }
}
