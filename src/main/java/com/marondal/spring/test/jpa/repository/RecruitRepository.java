package com.marondal.spring.test.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.marondal.spring.test.jpa.domain.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Integer> {

	// 전달받은 company Id가 일치하는 공고 조회 
	// WHERE `companyId` = #{companyId}
	public List<Recruit> findByCompanyId(int companyId);
	
	// WHERE `position` = #{position} AND `type` = #{type}
	public List<Recruit> findByPositionAndType(String position, String type);
	
	// WHERE `type` = #{type} OR `salary` >= #{salary}
	public List<Recruit> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	
	// WHERE `type` = ${type} ORDER BY `salary` DESC LIMIT 3;
	public List<Recruit> findTop3ByTypeOrderBySalaryDesc(String type);
	
	// WHERE `region` = #{region} AND `salary` BETWEEN #{start} AND #{end}
	public List<Recruit> findByRegionAndSalaryBetween(String region, int start, int end);
	
	@Query(value="SELECT * FROM `recruit`"
			+ " WHERE `deadline` > :deadline"
			+ " AND `salary` >= :salary"
			+ " AND `type` = :type"
			+ " ORDER BY `salary` DESC", nativeQuery=true)
	public List<Recruit> selectByNativeQuery(
			@Param("deadline") String deadline
			, @Param("salary") int salary
			, @Param("type") String type);
	
}
