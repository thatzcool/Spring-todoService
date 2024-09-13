
package com.ssg.springtodoservice.mapper;

import com.ssg.springtodoservice.domain.TodoVO;
import com.ssg.springtodoservice.dto.PageRequestDTO;

import java.util.List;

public interface TodoMapper {

      String getTime();
     void insert(TodoVO todoVO);

     List<TodoVO> selectAll();

    TodoVO selectOne(Long tno);

    void delete(Long tno);

    void update(TodoVO todoVO);
    List<TodoVO> selectList(PageRequestDTO pageRequestDTO);

    int getCount(PageRequestDTO pageRequestDTO);

}
