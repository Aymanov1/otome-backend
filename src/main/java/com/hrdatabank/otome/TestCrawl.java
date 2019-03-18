package com.hrdatabank.otome;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hrdatabank.otome.domain.JobOtome;
import com.hrdatabank.otome.repositories.JobOtomeRepository;

public class TestCrawl {
	private static Logger log = LoggerFactory.getLogger(TestCrawl.class);

	@Autowired
	protected static JobOtomeRepository jobOtomeRepository;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		verifiyShopNameNotBanned();
	}

	public static void verifiyShopNameNotBanned() {
		List<String> list = new ArrayList<>();
		list.add("スタッフ");
		list.add("株式会社リクルートスタッフィング");
		list.add("アズスタッフ");
		list.add("株式会社ホットスタッフ");
		list.add("ライクスタッフィング株式会社");
		list.add("日研トータルソーシング株式会社");
		list.add("日本マニュファクチャリングサービス株式会社");
		list.add("ディーピーティー株式会社");
		list.add("日本KDK株式会社");
		list.add("株式会社ライフライン");
		list.add("株式会社ヒューマンイノベーション");
		list.add("高木工業株式会社");
		list.add("株式会社iDA");
		list.add("テイケイワークス株式会社");
		list.add("株式会社フルキャスト");
		list.add("株式会社ビート");
		list.add("株式会社サポート");
		list.add("株式会社ワールド");
		list.add("株式会社ワールドインテック");
		list.add("株式会社トーコー");
		list.add("フジアルテ株式会社");
		list.add("株式会社ピーアンドピー");
		list.add("パーソルマーケティング株式会社");
		list.add("パーソル パナソニック ファクトリーパートナーズ(株)");
		list.add("株式会社チェッカーサポート");
		list.add("株式会社トーコー");
		list.add("株式会社ビート");
		list.add("株式会社オープンループパートナーズ");
		list.add("生活協同組合ユーコープ/おうちCO-OP");
		list.add("生活協同組合コープあいち");
		list.add("株式会社ブレイブ");
		list.add("株式会社トライグループ");
		list.add("株式会社ワークオール");
		list.add("株式会社カクヤス");
		list.add("KAKUYASU class");
		list.add("株式会社アクトプラス");
		list.add("株式会社ケー・ピー・エー");
		list.add("グッドスタッフ");
		list.add("ファッション人材リンク株式会社");
		list.add("アイング株式会社");
		list.add("採用受付センター");
		list.add("登録");
		list.add("パーソル");
		list.add("スタッフ");
		list.add("セフティアシスト株式会社");
		list.add("エムジー株式会社");
		list.add("株式会社シーズン");
		list.add("株式会社サンエーサンクス");
		list.add("ジョブ");
		list.add("キャリア");
		list.add("ケイテム");
		list.add("HUMANIC");
		list.add("テイケイ");
		list.add("アプリリゾート");
		list.add("プロキャスト");
		list.add("日本ワークプレイス");
		list.add("エスケイコンサルタント");
		list.add("ティー･ピー･エス");
		list.add("TPS");
		list.add("ヒューマン");
		list.add("リソース");

		// list.forEach(e ->{
		jobOtomeRepository.findAll().forEach(j -> {
			list.forEach(e -> {
				if (j.getShopAddress().equals(e))
					j.setStatus(false);
			});
		});

	}

}
