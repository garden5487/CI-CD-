package com.greenuniv.greenuniv.entity.menu;

import com.greenuniv.greenuniv.dto.menu.MenuDTO;
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
@Table(name = "menu")
@AllArgsConstructor
@NoArgsConstructor
public class MenuEntity implements BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "main")
  private String main;

  @Column(name = "soup")
  private String soup;

  @Column(name = "rice")
  private String rice;

  @Column(name = "side_1")
  private String sideOne;

  @Column(name = "side_2")
  private String sideTwo;

  @Override
  public MenuDTO toDTO() {
    return MenuDTO.builder()
        .id(id)
        .main(main)
        .soup(soup)
        .rice(rice)
        .sideOne(sideOne)
        .sideTwo(sideTwo)
        .build();
  }
}
