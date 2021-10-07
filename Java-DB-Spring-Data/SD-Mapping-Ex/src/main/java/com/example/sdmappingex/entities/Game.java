package com.example.sdmappingex.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "games")
public class Game extends BaseEntity {
 private String title;
 private int trailerId;
 private String thumbnailUrl;
 private double size;
 private BigDecimal price;
 private String description;
 private LocalDate releaseDate;
 private Set<User> users;

 @Column(name = "title", length = 50, nullable = false, unique = true)
 public String getTitle() {
  return title;
 }

 public void setTitle(String title) {
  this.title = title;
 }

 @Column(name = "trailer_id", unique = true)
 public int getTrailerId() {
  return trailerId;
 }

 public void setTrailerId(int trailerId) {
  this.trailerId = trailerId;
 }

 @Column(name = "thumbnail_url", nullable = true, unique = true)
 public String getThumbnailUrl() {
  return thumbnailUrl;
 }

 public void setThumbnailUrl(String thumbnailUrl) {
  this.thumbnailUrl = thumbnailUrl;
 }

 @Column(name = "size", nullable = false)
 public double getSize() {
  return size;
 }

 public void setSize(double size) {
  this.size = size;
 }

 @Column(name = "price", nullable = false)
 public BigDecimal getPrice() {
  return price;
 }

 public void setPrice(BigDecimal price) {
  this.price = price;
 }

 @Column(name = "description", length = 1000)
 public String getDescription() {
  return description;
 }

 public void setDescription(String description) {
  this.description = description;
 }

 @Column(name = "release_date", nullable = false)
 public LocalDate getReleaseDate() {
  return releaseDate;
 }

 public void setReleaseDate(LocalDate releaseDate) {
  this.releaseDate = releaseDate;
 }
@ManyToMany(targetEntity = User.class,mappedBy = "games")
 public Set<User> getUsers() {
  return users;
 }

 public void setUsers(Set<User> users) {
  this.users = users;
 }
}
