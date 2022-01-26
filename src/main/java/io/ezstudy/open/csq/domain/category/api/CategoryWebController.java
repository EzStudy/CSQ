package io.ezstudy.open.csq.domain.category.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categories")
public class CategoryWebController {

  @GetMapping("/createCategory")
  public String createCategory(Model model) {
    return "category/create";
  }
}
