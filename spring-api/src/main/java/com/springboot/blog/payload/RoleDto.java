package com.springboot.blog.payload;

import lombok.Data;

import javax.persistence.Column;


@Data
public class RoleDto {
  private Long id;
  private String name;
}
