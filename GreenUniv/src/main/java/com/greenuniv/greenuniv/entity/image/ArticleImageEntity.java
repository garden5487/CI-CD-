package com.greenuniv.greenuniv.entity.image;

import com.greenuniv.greenuniv.dto.image.ArticleImageDTO;
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
@Table(name = "article_image")
@AllArgsConstructor
@NoArgsConstructor
public class ArticleImageEntity implements BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "location")
  private String location;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "article_id")
  private ArticleEntity article;

  @Column(name = "thumbnail_location")
  private String thumbnailLocation;

  @Override
  public ArticleImageDTO toDTO() {
    return ArticleImageDTO.builder()
        .id(id)
        .location(location)
        .thumbnailLocation(thumbnailLocation)
        .build();
  }
}
