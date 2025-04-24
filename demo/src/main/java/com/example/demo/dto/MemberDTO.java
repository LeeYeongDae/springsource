package com.example.demo.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {
    @Pattern(regexp = "(?=^[A-Za-z])(?=.+\\d)[A-Za-z+\\d]{6,12}$", message = "아이디는 대소문자, 특수문자, 숫자 포한 6~12자리입니다")
    @NotBlank(message = "userid 를 확인해 주세요")
    private String userid;
    @NotBlank(message = "password 를 확인해 주세요")
    private String password;
    @Pattern(regexp = "^[가-힣]{2,5}", message = "이름은 2~5자리로 입력해 주세요")
    // @Length(min = 2, max = 5, message = "길이가 너무 짧거나 너무 깁니다")
    private String name;
    @NotBlank(message = "이메일을 입력해 주세요")
    @Email(message = "이메일 형식을 확인해 주세요")
    private String email;
    @NotNull
    @Min(value = 0, message = "0보다는 커야 합니다")
    @Max(value = 140, message = "140보다는 작아야 합니다")
    private Integer age;

    private boolean check;
}
