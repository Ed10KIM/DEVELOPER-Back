package com.developer.board.service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.developer.board.dto.BoardDTO;
import com.developer.board.dto.BoardDTO.getBoardByBoardTypeDTO;
import com.developer.board.entity.Board;
import com.developer.board.repository.BoardRepository;
import com.developer.boardrep.dto.BoardRepDTO.BoardRepSelectDTO;
import com.developer.boardrep.repository.BoardRepRepository;
import com.developer.exception.AddException;
import com.developer.exception.FindException;
import com.developer.exception.RemoveException;
import com.developer.users.dto.UsersDTO;
import com.developer.users.entity.Users;
import com.developer.users.repository.UsersRepository;

@Service
public class BoardService {
	@Autowired
	private BoardRepository BoardRepository;
	@Autowired
	private BoardRepRepository BoardRepRepository;
	@Autowired
	private UsersRepository UsersRepository;

	ModelMapper modelMapper = new ModelMapper();
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 게시글 작성
	 * 
	 * @author choigeunhyeong
	 * @param board
	 * @throws AddException
	 */
	@Transactional
	public void addBoard(Board board, String userId) throws AddException {
		Optional<Users> user = UsersRepository.findById(userId);
		Users writer = user.get();
		board.setUsers(writer);
		BoardRepository.save(board);
	}
	
	public List<BoardDTO.getBoardByBoardTypeDTO> getBoardByC_date() throws FindException{
		List<Object[]> Blist = BoardRepository.getBoardByC_date();
		List<BoardDTO.getBoardByBoardTypeDTO> dtoList = new ArrayList<>();
		for (int i = 0; i < Blist.size(); i++) {
			BoardDTO.getBoardByBoardTypeDTO bDTO = new BoardDTO.getBoardByBoardTypeDTO();
			BigDecimal post_seq = (BigDecimal) Blist.get(i)[1];
			Long resultPost_seq = post_seq.longValue();
			bDTO.setPostSeq(resultPost_seq);

			BigDecimal Category = (BigDecimal) Blist.get(i)[2];
			int resultCategory = Category.intValue();
			bDTO.setCategory(resultCategory);

			bDTO.setTitle((String) Blist.get(i)[3]);
			bDTO.setContent((String) Blist.get(i)[4]);
			bDTO.setImgPath((String) Blist.get(i)[5]);
			bDTO.setCDate((LocalDateTime) Blist.get(i)[6]);

			BigDecimal Recommend = (BigDecimal) Blist.get(i)[7];
			int resultRec = Recommend.intValue();
			bDTO.setRecommend(resultRec);

			BigDecimal Cnt = (BigDecimal) Blist.get(i)[8];
			int resultCnt = Cnt.intValue();
			bDTO.setCnt(resultCnt);

			UsersDTO.UsersNameDTO uDTO = new UsersDTO.UsersNameDTO();
			uDTO.setNickname((String) Blist.get(i)[0]);
			bDTO.setUsersNameDTO(uDTO);
//			BigDecimal Role = (BigDecimal) Blist.get(i)[12];
//			int userRole = Role.intValue();
//			uDTO.setRole(userRole);
//			uDTO.setUserId((String) Blist.get(i)[13]);
			dtoList.add(bDTO);
		}
		return dtoList;
		
	}
	
	public List<BoardDTO.getBoardByBoardTypeDTO> getBoardByRecommend() throws FindException{
		List<Object[]> Blist = BoardRepository.getBoardByRecommend();
		List<BoardDTO.getBoardByBoardTypeDTO> dtoList = new ArrayList<>();
		for (int i = 0; i < Blist.size(); i++) {
			BoardDTO.getBoardByBoardTypeDTO bDTO = new BoardDTO.getBoardByBoardTypeDTO();
			BigDecimal post_seq = (BigDecimal) Blist.get(i)[1];
			Long resultPost_seq = post_seq.longValue();
			bDTO.setPostSeq(resultPost_seq);

			BigDecimal Category = (BigDecimal) Blist.get(i)[2];
			int resultCategory = Category.intValue();
			bDTO.setCategory(resultCategory);

			bDTO.setTitle((String) Blist.get(i)[3]);
			bDTO.setContent((String) Blist.get(i)[4]);
			bDTO.setImgPath((String) Blist.get(i)[5]);
			bDTO.setCDate((LocalDateTime) Blist.get(i)[6]);

			BigDecimal Recommend = (BigDecimal) Blist.get(i)[7];
			int resultRec = Recommend.intValue();
			bDTO.setRecommend(resultRec);

			BigDecimal Cnt = (BigDecimal) Blist.get(i)[8];
			int resultCnt = Cnt.intValue();
			bDTO.setCnt(resultCnt);

			UsersDTO.UsersNameDTO uDTO = new UsersDTO.UsersNameDTO();
			uDTO.setNickname((String) Blist.get(i)[0]);
			bDTO.setUsersNameDTO(uDTO);
//			BigDecimal Role = (BigDecimal) Blist.get(i)[12];
//			int userRole = Role.intValue();
//			uDTO.setRole(userRole);
//			uDTO.setUserId((String) Blist.get(i)[13]);
			dtoList.add(bDTO);
		}
		return dtoList;
		
	}
	
	public List<BoardDTO.getBoardByBoardTypeDTO> getBoardByCnt() throws FindException{
		List<Object[]> Blist = BoardRepository.getBoardByCnt();
		List<BoardDTO.getBoardByBoardTypeDTO> dtoList = new ArrayList<>();
		for (int i = 0; i < Blist.size(); i++) {
			BoardDTO.getBoardByBoardTypeDTO bDTO = new BoardDTO.getBoardByBoardTypeDTO();
			BigDecimal post_seq = (BigDecimal) Blist.get(i)[1];
			Long resultPost_seq = post_seq.longValue();
			bDTO.setPostSeq(resultPost_seq);

			BigDecimal Category = (BigDecimal) Blist.get(i)[2];
			int resultCategory = Category.intValue();
			bDTO.setCategory(resultCategory);

			bDTO.setTitle((String) Blist.get(i)[3]);
			bDTO.setContent((String) Blist.get(i)[4]);
			bDTO.setImgPath((String) Blist.get(i)[5]);
			bDTO.setCDate((LocalDateTime) Blist.get(i)[6]);

			BigDecimal Recommend = (BigDecimal) Blist.get(i)[7];
			int resultRec = Recommend.intValue();
			bDTO.setRecommend(resultRec);

			BigDecimal Cnt = (BigDecimal) Blist.get(i)[8];
			int resultCnt = Cnt.intValue();
			bDTO.setCnt(resultCnt);

			UsersDTO.UsersNameDTO uDTO = new UsersDTO.UsersNameDTO();
			uDTO.setNickname((String) Blist.get(i)[0]);
			bDTO.setUsersNameDTO(uDTO);
//			BigDecimal Role = (BigDecimal) Blist.get(i)[12];
//			int userRole = Role.intValue();
//			uDTO.setRole(userRole);
//			uDTO.setUserId((String) Blist.get(i)[13]);
			dtoList.add(bDTO);
		}
		return dtoList;
		
	}
	
	public List<BoardDTO.getBoardByBoardTypeDTO> selectAllList() throws FindException{
		List<Object[]> Blist = BoardRepository.getBoardByC_date();
		List<BoardDTO.getBoardByBoardTypeDTO> dtoList = new ArrayList<>();
		for (int i = 0; i < Blist.size(); i++) {
			BoardDTO.getBoardByBoardTypeDTO bDTO = new BoardDTO.getBoardByBoardTypeDTO();
			BigDecimal post_seq = (BigDecimal) Blist.get(i)[1];
			Long resultPost_seq = post_seq.longValue();
			bDTO.setPostSeq(resultPost_seq);

			BigDecimal Category = (BigDecimal) Blist.get(i)[2];
			int resultCategory = Category.intValue();
			bDTO.setCategory(resultCategory);

			bDTO.setTitle((String) Blist.get(i)[3]);
			bDTO.setContent((String) Blist.get(i)[4]);
			bDTO.setImgPath((String) Blist.get(i)[5]);
			bDTO.setCDate((LocalDateTime) Blist.get(i)[6]);

			BigDecimal Recommend = (BigDecimal) Blist.get(i)[7];
			int resultRec = Recommend.intValue();
			bDTO.setRecommend(resultRec);

			BigDecimal Cnt = (BigDecimal) Blist.get(i)[8];
			int resultCnt = Cnt.intValue();
			bDTO.setCnt(resultCnt);

			UsersDTO.UsersNameDTO uDTO = new UsersDTO.UsersNameDTO();
			uDTO.setNickname((String) Blist.get(i)[0]);
			bDTO.setUsersNameDTO(uDTO);
//			BigDecimal Role = (BigDecimal) Blist.get(i)[12];
//			int userRole = Role.intValue();
//			uDTO.setRole(userRole);
//			uDTO.setUserId((String) Blist.get(i)[13]);
			dtoList.add(bDTO);
		}
		return dtoList;
		
	}
	
	/**
	 * 글 번호로 게시글 상세 검색(닉네임+글상세+댓글)
	 * 
	 * @author choigeunhyeong
	 * @param postSeq
	 * @return
	 * @throws FindException
	 */
	public List<BoardDTO.BoardAllSelectDTO> selectAllPostSeq(Long postSeq) throws FindException {
		List<Object[]> Blist = BoardRepository.findPostSeq(postSeq);
		List<BoardDTO.BoardAllSelectDTO> dto = new ArrayList<>();
		for (int i = 0; i < Blist.size(); i++) {
			BoardDTO.BoardAllSelectDTO bDTO = new BoardDTO.BoardAllSelectDTO();
			BigDecimal post_seq = (BigDecimal) Blist.get(i)[2];
			Long resultPost_seq = post_seq.longValue();
			bDTO.setPostSeq(resultPost_seq);

			BigDecimal Category = (BigDecimal) Blist.get(i)[3];
			int resultCategory = Category.intValue();
			bDTO.setCategory(resultCategory);

			bDTO.setTitle((String) Blist.get(i)[4]);
			bDTO.setContent((String) Blist.get(i)[5]);
			bDTO.setImgPath((String) Blist.get(i)[6]);
			bDTO.setCDate((LocalDateTime) Blist.get(i)[7]);

			BigDecimal Recommend = (BigDecimal) Blist.get(i)[8];
			int resultRec = Recommend.intValue();
			bDTO.setRecommend(resultRec);

			BigDecimal Cnt = (BigDecimal) Blist.get(i)[9];
			int resultCnt = Cnt.intValue();
			bDTO.setCnt(resultCnt);

			UsersDTO.UsersNameDTO uDTO = new UsersDTO.UsersNameDTO();
			uDTO.setNickname((String) Blist.get(i)[1]);
			BigDecimal Role = (BigDecimal) Blist.get(i)[12];
			int userRole = Role.intValue();
			uDTO.setRole(userRole);
			uDTO.setUserId((String) Blist.get(i)[13]);

//			BoardRepDTO brDTO = new BoardRepDTO();
//			brDTO.setContent((String)Blist.get(i)[10]);
//			brDTO.setCDate((Date)Blist.get(i)[11]);
//			bDTO.setUsersDTO(uDTO);
//			bDTO.setBoardRepDTO(brDTO);

			BoardRepSelectDTO brsDTO = new BoardRepSelectDTO();
			brsDTO.setContent((String) Blist.get(i)[10]);
			brsDTO.setCDate((Date) Blist.get(i)[11]);
			brsDTO.setUsersNameDTO(uDTO);
			bDTO.setUsersNameDTO(uDTO);
			bDTO.setBoardRepSelectDTO(brsDTO);

			dto.add(bDTO);
		}
		return dto;
	}
	
	/**
	 * 글 수정폼 출력
	 * @param postSeq
	 * @throws FindException
	 */
	public getBoardByBoardTypeDTO detailBoard(Long postSeq) throws FindException{
		Object[] obj = BoardRepository.detailBoard(postSeq);
		logger.error("대체뭔데: "+ obj.length);
	    getBoardByBoardTypeDTO dto = new getBoardByBoardTypeDTO();
	    
	    // 각각의 값을 꺼내서 DTO에 셋팅
	    BigDecimal post_seq = (BigDecimal) obj[1];
		Long resultPost_seq = post_seq.longValue();
		dto.setPostSeq(resultPost_seq);
	    BigDecimal Category = (BigDecimal) obj[2];
		int resultCategory = Category.intValue();
	    dto.setCategory(resultCategory);
	    dto.setTitle((String) obj[3]);
	    dto.setContent((String) obj[4]);
	    dto.setImgPath((String) obj[5]);
	    dto.setCDate((LocalDateTime) obj[6]);
	    dto.setRecommend((Integer) obj[7]);
	    dto.setCnt((Integer) obj[8]);
	    UsersDTO.UsersNameDTO usersNameDTO = new UsersDTO.UsersNameDTO();
	    usersNameDTO.setNickname((String) obj[0]);
	    dto.setUsersNameDTO(usersNameDTO);
	    
	    return dto;
	}
	
	/**
	 * 글 수정
	 * 
	 * @author choigeunhyeong
	 * @param board
	 * @throws FindException
	 */
	@Transactional
	public void editBoard(Board board, Long postSeq) throws FindException {
//		Optional<Board> optB = BoardRepository.findById(postSeq);
		Optional<Board> optB = BoardRepository.findById(postSeq);
		if(optB.isPresent()) {
			Users a = optB.get().getUsers();
			optB.get().update(board.getTitle(), board.getContent(), board.getImgPath(), LocalDateTime.now());
			board.setUsers(a);
			BoardRepository.save(board);
		}else{
			logger.error("올바르지않은 수정");
		}
	}
	/**
	 * 게시글 조회수 증가
	 * @author choigeunhyeong
	 * @param postSeq
	 * @throws FindException
	 */
	@Transactional
	public void updateCnt(Long postSeq) throws FindException {
//		Optional<Board> optB = BoardRepository.findById(postSeq);
		Optional<Board> optB = BoardRepository.findById(postSeq);
		if(optB.isPresent()) {
			Integer oldcnt = optB.get().getCnt();
			optB.get().setCnt(oldcnt+1);
		}else{
			logger.error("올바르지않은 수정");
		}
	}
	/**
	 * 게시글 삭제
	 * @author choigeunhyeong
	 * @param postSeq
	 * @throws RemoveException
	 */
	public void deleteBoard(Long postSeq) throws RemoveException {
		Optional<Board> optB = BoardRepository.findById(postSeq);
		if(optB.isPresent()) {
			BoardRepository.deleteById(postSeq);
		}else{
			logger.error("삭제되지 않음");
		}
	}
	/**
	 * 제목으로 검색
	 * @author choigeunhyeong
	 * @param title
	 * @return
	 * @throws FindException
	 */
	public List<Board> findByTitle(String title) throws FindException {
		List<Board> list = BoardRepository.findByTitleLike(title);
		return list;
	}

}
