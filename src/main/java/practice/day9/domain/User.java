/*
package day9.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

  @Id
  private Long userId;
  private String name;
  private String email;
  private String city;
  private String phone;
  private String company;;
  private String password;


  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Album> albums = new ArrayList<>();

}*/
