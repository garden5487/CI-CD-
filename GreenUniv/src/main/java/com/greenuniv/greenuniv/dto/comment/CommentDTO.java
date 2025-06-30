package com.greenuniv.greenuniv.dto.comment;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.dto.article.ArticleDTO;
import com.greenuniv.greenuniv.dto.user.UserDTO;
import com.greenuniv.greenuniv.entity.comment.CommentEntity;
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
public class CommentDTO implements BaseDTO {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private UserDTO user;
  private ArticleDTO article;
  private String content;
  private String registerDate;

  @Override
  public CommentEntity toEntity() {
    return CommentEntity.builder()
        .id(id)
        .user(user.toEntity())
        .article(article.toEntity())
        .content(content)
        .registerDate(registerDate)
        .build();
  }
}
