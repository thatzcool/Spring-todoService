package com.ssg.springtodoservice.dto;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

//서버 사이드 데이터 검증 : 스프링 MVC에서는 파라미터 검증 작업은 컨트롤러에서 진행한다.
// @Valid 와 BindingResult 객체를 이용하여 처리한다.
// hibernate-validate 라이브러리가  필요하다

public class TodoDTO {

    private Long tno;

    @NotEmpty
    private String title;

    @Future
    private LocalDate dueDate;

    private boolean finished;

    @NotEmpty
    private String writer;

}
