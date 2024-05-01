package org.sopt.secondSeminar.service;

import lombok.RequiredArgsConstructor;
import org.sopt.secondSeminar.domain.Member;
import org.sopt.secondSeminar.dto.MemberCreateDto;
import org.sopt.secondSeminar.dto.MemberDetailDto;
import org.sopt.secondSeminar.dto.MemberFindDto;
import org.sopt.secondSeminar.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public String createMember(MemberCreateDto memberCreateDto) {
        Member member = Member.create(memberCreateDto.name(), memberCreateDto.part(), memberCreateDto.age());
        memberRepository.save(member);
        return member.getId().toString();
    }

    public MemberFindDto findMemberById(Long memberId) {
        return MemberFindDto.of(memberRepository.findByIdOrThrow(memberId));

    }

    public void deleteMemberById(Long memberId) {
        memberRepository.delete(memberRepository.findByIdOrThrow(memberId));
    }

    public List<MemberDetailDto> findAllMembers() {
        return memberRepository.findAll().stream()
                .map(MemberDetailDto::of)
                .toList();
    }
}
