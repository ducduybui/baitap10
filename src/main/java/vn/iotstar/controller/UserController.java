package vn.iotstar.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.iotstar.entity.User;

@RequestMapping("/users")
@RestController
public class UserController {

    @GetMapping("/me")
    public ResponseEntity<User> authenticatedUser() {
        // Lấy thông tin user đang đăng nhập từ Security Context (nhờ Token)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        
        // Trả toàn bộ cục dữ liệu User về cho màn hình Thunder Client
        return ResponseEntity.ok(currentUser);
    }
}