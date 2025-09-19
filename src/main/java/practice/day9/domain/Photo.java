/*
package day9.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Photo {

  @Id
  private Long photoId;
  private String title;
  private String url;
  @ManyToOne
  @JoinColumn(name="album_id")
  private Album album;
  private String thumbnail;
}
*/
