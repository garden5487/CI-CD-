package com.greenuniv.greenuniv.entity.faq;

import com.greenuniv.greenuniv.dto.faq.FaqDTO;
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
@Table(name = "faq")
@AllArgsConstructor
@NoArgsConstructor
public class FaqEntity implements BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "category")
  private String category;

  @Column(name = "question")
  private String question;

  @Column(name = "answer")
  private String answer;

  @Override
  public FaqDTO toDTO() {
    return FaqDTO.builder()
        .id(id)
        .category(category)
        .question(question)
        .answer(answer)
        .build();
  }
}
