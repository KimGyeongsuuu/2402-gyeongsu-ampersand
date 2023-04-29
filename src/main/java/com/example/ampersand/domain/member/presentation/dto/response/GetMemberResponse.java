package com.example.ampersand.domain.member.presentation.dto.response;


import com.example.ampersand.domain.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMemberResponse {

    private String id;

    public static GetMemberResponse convertToMember(Member member) {
        return GetMemberResponse.builder()
                .id(member.getId())
                .build();
    }

}
