/*
package day9.service;

import day9.domain.Album;
import day9.domain.User;
import day9.repository.AlbumRepository;
import day9.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumService {

  private final AlbumRepository albumRepository;
  private final UserRepository userRepository;

  public void addAlbum(String title, String username) {
    User user = userRepository.findByEmail(username)
        .orElseThrow(() -> new IllegalArgumentException("User not found"));

    Album album = new Album();
    album.setTitle(title);
    album.setUser(user);
    albumRepository.save(album);
  }

  public void updateAlbum(Long id, String title) {
    Album album = albumRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Album not found"));
    album.setTitle(title);
    albumRepository.save(album);
  }

  public void deleteAlbum(Long albumId) {
    albumRepository.deleteById(albumId);
  }
}
*/
