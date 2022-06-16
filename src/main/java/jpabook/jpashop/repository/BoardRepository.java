package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final EntityManager em;

    public void save(Board board){
        em.persist(board);
    }

    public Board findOne(Long id){
        return em.createQuery("select b from Board b where b.id = :id",Board.class)
                .setParameter("id",id)
                .getSingleResult();
    }

    public List<Board> findAll(){
        return em.createQuery("select b from Board b", Board.class)
                .getResultList();
    }

}
