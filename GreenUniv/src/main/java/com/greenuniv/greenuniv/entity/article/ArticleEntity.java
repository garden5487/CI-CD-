package com.greenuniv.greenuniv.entity.article;

import com.greenuniv.greenuniv.dto.article.ArticleDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import com.greenuniv.greenuniv.entity.user.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@Builder
@ToString
@Table(name = "article")
@AllArgsConstructor
@NoArgsConstructor
public class ArticleEntity implements BaseEntity {

  @Id
  private int id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private UserEntity user;

  @Column(name = "title")
  private String title;

  @Column(name = "cateogory")
  private String category;

  @Column(name = "status")
  private String status;

  @Column(name = "content")
  private String content;

  @Column(name = "view")
  private int view;

  @Column(name = "register_date")
  @CreationTimestamp
  private LocalDate registerDate;

  @Override
  public ArticleDTO toDTO() {
    return ArticleDTO.builder()
        .id(id)
        .user(user.toDTO())
        .title(title)
        .category(category)
        .status(status)
        .content(content)
        .view(view)
        .registerDate(registerDate)
        .build();
  }

  public static class ArticleEntityBuilder {

    public ArticleEntity build() throws IllegalArgumentException {
      boolean isCategoryLegal = Arrays.asList(ArticleDTO.CATEGORIES).contains(category);
      boolean isStatusLegal = Arrays.asList(ArticleDTO.STATUS).contains(status);

      if (!isCategoryLegal) {
        String message = String.format("유효하지 않은 카테고리([%s]): %s",
            Arrays.toString(ArticleDTO.CATEGORIES),
            category);
        throw new IllegalArgumentException(message);
      } else if (!isStatusLegal) {
        String message = String.format("유효하지 않은 게시물 상태([%s]): %s",
            Arrays.toString(ArticleDTO.STATUS), status);
        throw new IllegalArgumentException(message);
      }

      return new ArticleEntity(id, user, title, category, status, content, view, registerDate);
    }
  }

}
