package net.skhu.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Member;
import net.skhu.mapper.MemberMapper;
import net.skhu.dto.SignUpRequestDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SignUpService {

    private final PasswordEncoder passwordEncoder;
    private final MemberMapper memberMapper;

    public Member signUp(SignUpRequestDto signUpRequestDto) {

        Member member = Member.builder()
                .name(signUpRequestDto.getName())
                .studentIdx(signUpRequestDto.getStudentIdx())
                .department(signUpRequestDto.getDepartment())
                .password(passwordEncoder.encode(signUpRequestDto.getPassword()))
                .email(signUpRequestDto.getEmail())
                .type(signUpRequestDto.getType())
                .build();

        memberMapper.insertUsers(member);
       return member;
    }



}
