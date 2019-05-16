package com.hrdatabank.otome.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.otome.domain.JobOtome;
import com.hrdatabank.otome.model.JobDto;

/**
 * The Interface JobOtomeRepository.
 */
@Repository
@RepositoryRestResource
public interface JobOtomeRepository extends JpaRepository<JobOtome, Long> {
	@Query(value = "SELECT count(j) AS count FROM JobOtome j where  j.status = TRUE and j.affiliateType LIKE CONCAT('%','BAITORU','%')")
	public long countBaitoruJobsAffiliateActivated();

	@Query(value = "SELECT j FROM JobOtome j where  j.status = TRUE and j.affiliateType LIKE CONCAT('%','BAITORU','%')")
	public Page<JobOtome> getBaitoruJobsAffiliateActivated(PageRequest pageRequest);

	
	@Query(value = "SELECT NEW com.hrdatabank.otome.model.JobDto(j.idJob,  j.shopName, j.jobURL, j.positionName, j.positionCategoryEnglish, j.shopAddress,  j.hourlyWageMemo, j.affiliateType,  j.transportation, j.status, j.startTime,  j.finishTime) FROM JobOtome j ")
	public List<JobDto> getAllJobsByDto();

	@Query(value = "SELECT j FROM JobOtome j  WHERE  j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) GROUP BY j.id_job, ?#{#pageable}", nativeQuery = true)
	public Page<JobOtome> getJobsByStationAndJobCategory(@Param("lat") double lat, @Param("lng") double lng,
			@Param("maxKm") int maxKm, Pageable pageable);

	@Query("select count(j) from JobOtome j")
	Long findCount();
	
	@Query("select  count( distinct j.shopName) from JobOtome j")
	int findCountShops();

	@Transactional
	@Modifying
	@Query(value = "UPDATE jobotome as j  SET   status='false' 	  where  (j.shopname like '%スタッフ%' or j.shopname like'%株式会社リクルートスタッフィング%' or j.shopname like'%アズスタッフ%' or j.shopname like'%株式会社ホットスタッフ%' or j.shopname like'%ライクスタッフィング株式会社%' or j.shopname like'%日研トータルソーシング株式会社%'"
			+ "  or j.shopname like'%日本マニュファクチャリングサービス株式会社%' or j.shopname like'%ディーピーティー株式会社%'  or j.shopname like'%日本KDK株式会社%' or j.shopname like'%株式会社ライフライン%'  or j.shopname like'%株式会社ヒューマンイノベーション%' or j.shopname like'%高木工業株式会社%' "
			+ "  or j.shopname like'%株式会社iDA%' or j.shopname like'%テイケイワークス株式会社%' or j.shopname like'%株式会社フルキャスト%' or j.shopname like'%株式会社ビート' or j.shopname like'%株式会社サポート%' "
			+ "  or j.shopname like'%株式会社ワールド%' or j.shopname like'%株式会社ワールドインテック%' or j.shopname like'%株式会社トーコー%' or j.shopname like'%フジアルテ株式会社%' or j.shopname like'%株式会社ピーアンドピー%' or j.shopname like'%パーソルマーケティング株式会社%' or j.shopname like'%パーソル パナソニック ファクトリーパートナーズ(株)%'"
			+ "  or j.shopname like'%株式会社チェッカーサポート%' or j.shopname like'%株式会社トーコー%' or j.shopname like'%株式会社ビート%' or j.shopname like'%株式会社オープンループパートナーズ%' or j.shopname like'%生活協同組合ユーコープ/おうちCO-OP%' or j.shopname like'%生活協同組合コープあいち%' or j.shopname like'%株式会社ブレイブ%'"
			+ "  or j.shopname like'%株式会社トライグループ%'  or j.shopname like'%株式会社ワークオール%' or j.shopname like'%株式会社カクヤス%' or j.shopname like'%KAKUYASU class%' or j.shopname like'%株式会社アクトプラス%' or j.shopname like'%株式会社ケー・ピー・エー%' or j.shopname like'%グッドスタッフ%' or j.shopname like'%ファッション人材リンク株式会社%'"
			+ "  or j.shopname like'%アイング株式会社%' or j.shopname like'%採用受付センター%' or j.shopname like'%登録%'  or j.shopname like'%パーソル%' or j.shopname like'%スタッフ%' or j.shopname like'%セフティアシスト株式会社%'  or j.shopname like'%エムジー株式会社%'   or j.shopname like'%株式会社シーズン%' "
			+ "  or j.shopname like'%株式会社サンエーサンクス%' or j.shopname like'%ジョブ%' or j.shopname like'%キャリア%' or j.shopname like'%ケイテム%' or j.shopname like'%HUMANIC%' or j.shopname like'%テイケイ%'  or j.shopname like'%アプリリゾート%'  or j.shopname like'%プロキャスト%' or j.shopname like'%日本ワークプレイス%' or j.shopname like'%エスケイコンサルタント%' "
			+ "  or j.shopname like'%ティー･ピー･エス%' or j.shopname like'%TPS%' or j.shopname like'%ヒューマン%' or j.shopname like'%リソース%');", nativeQuery = true)
	void cleanJobs();

	@Query("select count(j) from JobOtome j where j.status=true")
	Long findValidJobsCount();

	@Query("select count(j) from JobOtome j where j.transportation=true")
	Long findTransportationCount();

	@Query("select count(j) from JobOtome j where j.affiliateType = 'BAITORU'")
	Long findBaitoruJobsCount();

}
