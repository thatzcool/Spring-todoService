package com.ssg.springtodoservice.service;

import com.ssg.springtodoservice.domain.TodoVO;
import com.ssg.springtodoservice.dto.TodoDTO;
import com.ssg.springtodoservice.mapper.TodoMapper;
import com.sun.tools.javac.comp.Todo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@Log4j2
@RequiredArgsConstructor
// 의존성 주입이 필요한 객체의 타입을 final로 고정시키고 @RequiredArgsConstructor 를 이용하여 생성자를 생성하는 방식으로 주입받는다
public class TodoServiceImpl implements TodoService{

    private  final TodoMapper todoMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO todoDTO) {
        log.info(modelMapper);
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        log.info(todoVO);
        todoMapper.insert(todoVO);

    }
}
