package org.sopt.secondSeminar.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.secondSeminar.dto.MemberCreateDto;
import org.sopt.secondSeminar.dto.MemberDetailDto;
import org.sopt.secondSeminar.dto.MemberFindDto;
import org.sopt.secondSeminar.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Void> createMember(
            @RequestBody MemberCreateDto memberCreate
    ) {
        return ResponseEntity.created(URI.create(memberService.createMember(memberCreate))).build();
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberFindDto> findMemberById(
            @PathVariable Long memberId
    ) {
      return ResponseEntity.ok(memberService.findMemberById(memberId));
    }


    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMemberById(
            @PathVariable Long memberId
    ) {
        memberService.deleteMemberById(memberId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<MemberDetailDto>> findAllMembers() {
        return ResponseEntity.ok(memberService.findAllMembers());
    }
}