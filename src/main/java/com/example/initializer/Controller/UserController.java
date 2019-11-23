package com.example.initializer.Controller;

import com.example.initializer.Repository.UserRepo;
import com.example.initializer.domain.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserRepo _userRepo;

  /**
   * List all users
   * @param model
   * @return
   */
  @GetMapping
  public ModelAndView list(Model model) {
    model.addAttribute("userList", _userRepo.findAll());
    model.addAttribute("title", "用户管理");
    return new ModelAndView("users/list", "model", model);
  }

  @GetMapping("/{id}")
  public ModelAndView view(@PathVariable("id") Long id, Model model) {
    User user = _userRepo.findById(id);
    model.addAttribute("user", user);
    model.addAttribute("title", "查看用户");
    return new ModelAndView("users/view", "model", model);
  }

  @GetMapping("/form")
  public ModelAndView createForm(Model model) {
    model.addAttribute("user", new User());
    model.addAttribute("title", "创建用户");
    return new ModelAndView("users/form", "model", model);
  }

  @PostMapping
  public ModelAndView saveOrUpdate(User user) {
    _userRepo.saveOrUpdate(user);
    return new ModelAndView("redirect:/users");
  }

  @GetMapping("/delete/{id}")
  public ModelAndView delete(@PathVariable("id") Long id) {
    _userRepo.deleteById(id);
    return new ModelAndView("redirect:/users");
  }

  @GetMapping("/edit/{id}")
  public ModelAndView edit(@PathVariable("id") Long id, Model model) {
    User user = _userRepo.findById(id);
    model.addAttribute("user", user);
    model.addAttribute("title", "修改用户");
    return new ModelAndView("users/form", "model", model);
  }
}
