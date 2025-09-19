/*
package day9.service;


import day9.domain.Album;
import day9.domain.Photo;
import day9.domain.User;
import day9.dto.AlbumResponse;
import day9.dto.PhotoResponse;
import day9.dto.UserResponse;
import day9.repository.AlbumRepository;
import day9.repository.PhotoRepository;
import day9.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class DataService implements CommandLineRunner {
  @Autowired
  private AlbumRepository albumRepository;
  @Autowired
  private PhotoRepository photoRepository;
  @Autowired
  private UserRepository userRepository;
  private RestTemplate restTemplate = new  RestTemplate();
  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Override
  public void run(String... args) throws Exception {
    UserResponse[] users =  restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", UserResponse[].class);
    for (UserResponse userdto : users) {
      User user = new User();
      user.setUserId(userdto.getId());
      user.setName(userdto.getName());
      user.setEmail(userdto.getEmail());
      user.setCompany(userdto.getCompany().getName());
      user.setPhone(userdto.getPhone());
      user.setCity(userdto.getAddress().getCity());
      user.setPassword(passwordEncoder.encode("1234"));
      userRepository.save(user);
    }

    AlbumResponse[] albums = restTemplate.getForObject("https://jsonplaceholder.typicode.com/albums", AlbumResponse[].class);
    for (AlbumResponse albumdto : albums) {
      User user = userRepository.findById(albumdto.getUserId()).orElse(null);
      if (user != null) {
        Album album = new Album();
        album.setAlbumId(albumdto.getId());
        album.setTitle(albumdto.getTitle());
        album.setUser(user);
        albumRepository.save(album);
      }
    }


      PhotoResponse[] photos = restTemplate.getForObject("https://jsonplaceholder.typicode.com/photos", PhotoResponse[].class);
      for (PhotoResponse photodto : photos) {
        Album album = albumRepository.findById(photodto.getAlbumId()).orElse(null);
        if (album != null) {
          Photo photo = new Photo();
          photo.setPhotoId(photodto.getId());
          photo.setTitle(photodto.getTitle());
          photo.setAlbum(album);
          photo.setThumbnail(photodto.getThumbnail());
          photo.setUrl(photodto.getUrl());
          photoRepository.save(photo);
        }
      }
    }
  }
*/
