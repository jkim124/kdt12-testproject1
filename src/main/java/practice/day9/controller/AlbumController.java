/*
package day9.controller;

import day9.domain.Album;
import day9.domain.User;
import day9.repository.AlbumRepository;
import day9.repository.UserRepository;
import day9.service.AlbumService;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlbumController {

  @Autowired
  private AlbumRepository albumRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private AlbumService albumService;


  @GetMapping("/albums")
  public String getAllAlbums(Model model) {
    List<Album> albums = albumRepository.findAll();
    model.addAttribute("albums", albums);
    return "albums"; // albums.html
  }

  @GetMapping("/albums/{userId}")
  public String getUserAlbums(@PathVariable Long userId, Model model) {
    User user = userRepository.findById(userId).orElse(null);
    if (user != null) {
      List<Album> albums = albumRepository.findAllByUser_UserId(userId);
      model.addAttribute("user", user);
      model.addAttribute("albums", albums);
    }
    return "user-albums"; // user-albums.html
  }

  @PostMapping("/albums")
  public String addAlbum(@RequestParam String title, Principal principal) {
    albumService.addAlbum(title, principal.getName());
    return "redirect:/albums";
  }

  @PutMapping("/albums/{id}")
  public String updateAlbum(@PathVariable Long id, @RequestParam String title) {
    albumService.updateAlbum(id, title);
    return "redirect:/albums";
  }


  @DeleteMapping("/albums/{id}")
  public String deleteAlbum(@PathVariable Long id) {
    albumService.deleteAlbum(id);
    return "redirect:/albums";
  }
}
*/
