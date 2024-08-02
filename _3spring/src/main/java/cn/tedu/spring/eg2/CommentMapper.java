package cn.tedu.spring.eg2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CommentMapper {
    private Mapper mapper;

    @Autowired
    @Qualifier("mapperImpl1")
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String toString() {
        return "CommentMapper{" + "mapper=" + mapper + '}';
    }
}
