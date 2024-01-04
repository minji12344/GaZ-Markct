/*
 * 상품 전체 목록보기
 * 상품 등록하기
 * 상품 정렬하기
 * 상품 검색하기
 * 상품 수정하기
 * 상품 삭제하기
 * */



package kr.co.dong.Product;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.dong.ImgDTO;
import kr.co.dong.board.PagingVO;


@Repository

public class ProductDAOImpl implements ProductDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace ="kr.co.dong.Product";
	
	@Override
	public List<ProductDTO> plist() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".plist");
	}
	

	@Override
	public ProductDTO pdetail(int pcode) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".pdetail", pcode);
	}
	
	@Override
	public List<ImgDTO> pdetailimg(int imgfromno) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".pdetailimg", imgfromno);
	}
	

	@Override
	public int pinsert(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+".pinsert", productDTO);
		
	}
	
	@Override
	public int pimageinsert(ImgDTO imgDTO) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+".pimageinsert", imgDTO);
	}


	@Override
	public ProductDTO psearch(String pname) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".psearch", pname);
	}

	@Override
	public int pupdate(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+".pupdate", productDTO);
	}

	@Override
	public int pdelete(int pcode) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+".pdelete", pcode);
	}
	

	@Override
	public int pdeldelete(int pcode) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+".pdeldelete", pcode);
	}

	@Override
	public List<ProductDTO> pdellist() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".pdellist");
	}

	@Override
	public int countProduct() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".countProduct");
	}

	@Override
	public int countProduct2(PagingPVO pvo) {
		// TODO Auto-generated method stub
		 return sqlSession.selectOne(namespace+".countProduct2", pvo);
	}

	@Override
	public List<ProductDTO> selectProduct(PagingPVO pvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".selectProduct", pvo);
	}

	
	@Override
	public List<ProductDTO> psearchlist(PagingPVO pvo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".psearchlist", pvo);
	}

	@Override
	public int productSort(int ptcodemain) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".productSort", ptcodemain);
	}

@Override
	public List<ProductDTO> productSortList(PagingSortPVO spvo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".productSortList", spvo);
	}


@Override
public int productSort2(int ptcodesub) {
	// TODO Auto-generated method stub
	return sqlSession.selectOne(namespace+".productSort2", ptcodesub);
}


@Override
public List<ProductDTO> productSortList2(PagingSortPVO2 spvo) throws Exception {
	// TODO Auto-generated method stub
	return sqlSession.selectList(namespace+ ".productSortList2", spvo);
}




@Override
public List<ProductReply> pGetDetail(int pcode) {
	// TODO Auto-generated method stub
	return sqlSession.selectList(namespace+".pGetDetail", pcode);
}


@Override
public ProductReply pReplyDetail(int preno) {
	// TODO Auto-generated method stub
	return sqlSession.selectOne(namespace+".pReplyDetail", preno);
}


@Override
public int pReply(ProductReply productReply) {
	// TODO Auto-generated method stub
	return sqlSession.insert(namespace+".pReply", productReply);
}


@Override
public int pReplyUpdate(ProductReply productReply) {
	// TODO Auto-generated method stub
	return sqlSession.update(namespace+".pReplyUpdate", productReply);
}


@Override
public int pReplyDelete(int preno) {
	// TODO Auto-generated method stub
	return sqlSession.delete(namespace+".pReplyDelete", preno);
}


@Override
public int BuycountUpdate(ProductDTO productDTO) {
	// TODO Auto-generated method stub
	return sqlSession.update(namespace+".BuycountUpdate", productDTO);
}


@Override
public int MaxProduct() {
	// TODO Auto-generated method stub
	return sqlSession.selectOne(namespace+".MaxProduct");
}


	}


