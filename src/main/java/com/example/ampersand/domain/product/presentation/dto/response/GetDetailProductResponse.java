package com.example.ampersand.domain.product.presentation.dto.response;

import com.example.ampersand.domain.member.presentation.dto.response.GetMemberResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetDetailProductResponse {

    private Long productId;

    private String name;

    private String content;

    private Long price;

    private GetMemberResponse member;
}
