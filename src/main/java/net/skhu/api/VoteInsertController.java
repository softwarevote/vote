package net.skhu.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Users;
import net.skhu.dto.SignUpRequestDto;
import net.skhu.service.SignUpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class VoteInsertController {

    private final SignUpService signUpService;

    //TODO 회원가입 유효성 검사와 아이디 만들기
    @PostMapping("/api/v1/signUp")
    public ResponseEntity<Users> createAccount(@Valid @RequestBody SignUpRequestDto signUpRequestDto) {
        Users user = signUpService.signUp(signUpRequestDto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
