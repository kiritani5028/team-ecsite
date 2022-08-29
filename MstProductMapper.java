package jp.co.internous.sunflower.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import jp.co.internous.sunflower.model.domain.MstProduct;

@Mapper
public interface MstProductMapper {
	
	@Select("SELECT * FROM mst_product;")
	List<MstProduct> findAll();
	
	List<MstProduct> findByCategoryIdAndProductName(
		@Param("categoryId") long categoryId,
		@Param("productName") String[] ProductName
	);
}
