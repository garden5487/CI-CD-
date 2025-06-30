package com.greenuniv.greenuniv.entity.meal;

import com.greenuniv.greenuniv.dto.meal.MealDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import com.greenuniv.greenuniv.entity.menu.MenuEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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

@Entity
@Getter
@Builder
@ToString
@Table(name = "meal")
@AllArgsConstructor
@NoArgsConstructor
public class MealEntity implements BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "menu_id")
  private MenuEntity menu;

  @Column(name = "date")
  private LocalDate date;

  @Column(name = "meal_time")
  private String mealTime;

  @Override
  public MealDTO toDTO() {
    return MealDTO.builder()
        .id(id)
        .menu(menu.toDTO())
        .date(date)
        .mealTime(mealTime)
        .build();
  }

  public static class MealEntityBuilder {

    public MealEntity build() throws IllegalArgumentException {
      boolean isLegal = Arrays.asList(MealDTO.MEAL_TIME).contains(mealTime);
      if (!isLegal) {
        throw new IllegalArgumentException("유효하지 않은 식사 시간: " + mealTime);
      }
      return new MealEntity(id, menu, date, mealTime);
    }
  }
}
