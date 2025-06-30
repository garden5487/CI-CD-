package com.greenuniv.greenuniv.entity.comment;

import com.greenuniv.greenuniv.dto.comment.CommentDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import com.greenuniv.greenuniv.entity.article.ArticleEntity;
import com.greenuniv.greenuniv.entity.user.UserEntity;
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
@Table(name = "comment")
@AllArgsConstructor
@NoArgsConstructor
public class CommentEntity implements BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private UserEntity user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "article_id")
  private ArticleEntity article;

  @Column(name = "content")
  private String content;

  @Column(name = "register_date")
  private String registerDate;

  @Override
  public CommentDTO toDTO() {
    return CommentDTO.builder()
        .id(id)
        .user(user.toDTO())
        .article(article.toDTO())
        .content(content)
        .registerDate(registerDate)
        .build();
  }
}
