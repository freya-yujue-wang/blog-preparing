package com.example.initializer.domain;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class User {
  private Long id;
  private String name;
  private String email;
}