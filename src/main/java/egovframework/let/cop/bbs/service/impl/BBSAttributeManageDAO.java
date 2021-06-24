package egovframework.let.cop.bbs.service.impl;
import java.util.List;

import egovframework.let.cop.bbs.service.BoardMaster;
import egovframework.let.cop.bbs.service.BoardMasterVO;

import org.egovframe.rte.psl.dataaccess.EgovAbstractDAO;

import org.springframework.stereotype.Repository;

/**
 * 게시판 속성정보 관리를 위한 데이터 접근 클래스
 * @author 공통 서비스 개발팀 이삼섭
 * @since 2009.03.12
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2009.03.12  이삼섭          최초 생성
 *  2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성
 *
 *  </pre>
 */
@Repository("BBSAttributeManageDAO")
public class BBSAttributeManageDAO extends EgovAbstractDAO {

    /**
     * 등록된 게시판 속성정보를 삭제한다.
     *
     * @param BoardMaster
     */
    public void deleteBBSMasterInf(BoardMaster boardMaster) throws Exception {
	update("BBSAttributeManageDAO.deleteBBSMasterInf", boardMaster);
    }

    /**
     * 신규 게시판 속성정보를 등록한다.
     *
     * @param BoardMaster
     */
    public String insertBBSMasterInf(BoardMaster boardMaster) throws Exception {
	return (String)insert("BBSAttributeManageDAO.insertBBSMasterInf", boardMaster);
    }

    /**
     * 게시판 속성정보 한 건을 상세조회 한다.
     *
     * @param BoardMasterVO
     */
    public BoardMasterVO selectBBSMasterInf(BoardMaster vo) throws Exception {
	return (BoardMasterVO)select("BBSAttributeManageDAO.selectBBSMasterInf", vo);
    }

    /**
     * 게시판 속성정보 목록을 조회한다.
     *
     * @param BoardMasterVO
     */
    @SuppressWarnings("unchecked")
    public List<BoardMasterVO> selectBBSMasterInfs(BoardMasterVO vo) throws Exception {
	return (List<BoardMasterVO>) list("BBSAttributeManageDAO.selectBBSMasterInfs", vo);
    }

    /**
     * 게시판 속성정보 목록 숫자를 조회한다
     *
     * @param vo
     * @return
     * @throws Exception
     */
    public int selectBBSMasterInfsCnt(BoardMasterVO vo) throws Exception {
	return (Integer)select("BBSAttributeManageDAO.selectBBSMasterInfsCnt", vo);
    }

    /**
     * 게시판 속성정보를 수정한다.
     *
     * @param BoardMaster
     */
    public void updateBBSMasterInf(BoardMaster boardMaster) throws Exception {
	update("BBSAttributeManageDAO.updateBBSMasterInf", boardMaster);
    }

    /**
     * 템플릿의 유효여부를 점검한다.
     *
     * @param BoardMasterVO
     */
    public boolean validateTemplate(BoardMasterVO vo) throws Exception {
	return true;
    }

    /**
     * 유효한 게시판 목록을 불러온다.
     *
     * @param vo
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<BoardMasterVO> selectAllBBSMasteInf(BoardMasterVO vo) throws Exception {
	// 커뮤니티, 동호회의 게시판이 나오지 않도록 LETTNBBSUSE 테이블과 Join 필요
	return (List<BoardMasterVO>) list("BBSAttributeManageDAO.selectAllBBSMaster", vo);
    }

    /**
     * 사용중인 게시판 속성정보 목록을 조회한다.
     *
     * @param BoardMasterVO
     */
    @SuppressWarnings("unchecked")
    public List<BoardMasterVO> selectBdMstrListByTrget(BoardMasterVO vo) throws Exception {
	return (List<BoardMasterVO>) list("BBSAttributeManageDAO.selectBdMstrListByTrget", vo);
    }

    /**
     * 사용중인 게시판 속성정보 목록 숫자를 조회한다
     *
     * @param vo
     * @return
     * @throws Exception
     */
    public int selectBdMstrListCntByTrget(BoardMasterVO vo) throws Exception {
	return (Integer)select("BBSAttributeManageDAO.selectBdMstrListCntByTrget", vo);
    }

    /**
     * 커뮤니티, 동호회등 게시판 사용등록이 된 게시판 목록 전체를 불러온다.
     *
     * @param vo
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<BoardMasterVO> selectAllBdMstrByTrget(BoardMasterVO vo) throws Exception {
	return (List<BoardMasterVO>) list("BBSAttributeManageDAO.selectAllBdMstrByTrget", vo);
    }

    /**
     * 사용 중이지 않은 게시판 속성정보 목록을 조회한다.
     *
     * @param BoardMasterVO
     */
    @SuppressWarnings("unchecked")
    public List<BoardMasterVO> selectNotUsedBdMstrList(BoardMasterVO vo) throws Exception {
	return (List<BoardMasterVO>) list("BBSAttributeManageDAO.selectNotUsedBdMstrList", vo);
    }

    /**
     * 사용 중이지 않은 게시판 속성정보 목록 숫자를 조회한다
     *
     * @param vo
     * @return
     * @throws Exception
     */
	public int selectNotUsedBdMstrListCnt(BoardMasterVO vo) throws Exception {
	return (Integer)select("BBSAttributeManageDAO.selectNotUsedBdMstrListCnt", vo);
    }
}
