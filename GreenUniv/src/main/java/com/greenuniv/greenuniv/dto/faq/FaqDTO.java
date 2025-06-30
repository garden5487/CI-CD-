package com.greenuniv.greenuniv.dto.faq;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.entity.faq.FaqEntity;
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
public class FaqDTO implements BaseDTO {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String category;
  private String question;
  private String answer;

  @Override
  public FaqEntity toEntity() {
    return FaqEntity.builder()
        .id(id)
        .category(category)
        .question(question)
        .answer(answer)
        .build();
  }
}
