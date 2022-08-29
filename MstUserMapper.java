package jp.co.internous.sunflower.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import jp.co.internous.sunflower.model.domain.MstUser;

@Mapper
public interface MstUserMapper {
	
	@Select("SELECT * FROM mst_user WHERE user_name = #{userName};")
	List<MstUser> findByUserName(String userName);
	
	@Select("SELECT * FROM mst_user WHERE user_name = #{userName} AND password = #{password};")
	List<MstUser> findByUserNameAndPassword(
			@Param("userName") String userName,
			@Param("password") String password
		);
	
	@Insert("INSERT INTO mst_user(user_name, password, family_name, first_name, family_name_kana, first_name_kana, gender) VALUES"
			+ "(#{userName}, #{password}, #{familyName}, #{firstName}, #{familyNameKana}, #{firstNameKana}, #{gender});")
	@Options(useGeneratedKeys=true, keyProperty="id")
	void registerUser(MstUser user);
	
}
