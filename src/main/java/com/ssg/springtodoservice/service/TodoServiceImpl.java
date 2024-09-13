package com.ssg.springtodoservice.service;

import com.ssg.springtodoservice.domain.TodoVO;
import com.ssg.springtodoservice.dto.PageRequestDTO;
import com.ssg.springtodoservice.dto.PageResponseDTO;
import com.ssg.springtodoservice.dto.TodoDTO;
import com.ssg.springtodoservice.mapper.TodoMapper;
import com.sun.tools.javac.comp.Todo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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
//
//    @Override
//    public List<TodoDTO> getAll() {
//
//           List<TodoDTO> dtoList = todoMapper.selectAll().stream()
//                   .map(vo->modelMapper.map(vo,TodoDTO.class)).collect(Collectors.toList());
//
//
//        return dtoList;
//    }

    @Override
    public TodoDTO getOne(Long tno) {
         TodoVO vo = todoMapper.selectOne(tno);
         TodoDTO todoDTO = modelMapper.map(vo,TodoDTO.class);
        return todoDTO;
    }

    @Override
    public void remove(Long tno) {
        todoMapper.delete(tno);
    }

    @Override
    public void modify(TodoDTO todoDTO) {
        TodoVO todoVO = modelMapper.map(todoDTO,TodoVO.class);
        todoMapper.update(todoVO);
    }

    @Override
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {
        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
        List<TodoDTO> dtoList = voList.stream()
                .map(vo->modelMapper.map(vo,TodoDTO.class)).collect(Collectors.toList());;

         int total = todoMapper.getCount(pageRequestDTO);

        PageResponseDTO<TodoDTO> pageResponseDTO = PageResponseDTO.<TodoDTO>withAll().dtoList(dtoList)
                .total(total).pageRequestDTO(pageRequestDTO).build();
                return pageResponseDTO;
    }
}
