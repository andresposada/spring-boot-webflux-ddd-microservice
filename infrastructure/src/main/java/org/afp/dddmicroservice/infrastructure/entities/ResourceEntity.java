package org.afp.dddmicroservice.infrastructure.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "resources")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class ResourceEntity extends GeneralEntity {

  @Column(name = "property_one", nullable = false)
  String propertyOne;

  @Column(name = "property_two", nullable = false)
  String propertyTwo;
}
